const API_URL = "/api/veiculos/bateria";

let ultimaLeitura = null;


async function atualizarDashboard() {

    try {

        const resposta =
            await fetch(API_URL);

        if (!resposta.ok) {

            throw new Error(
                "Erro HTTP " + resposta.status
            );

        }


        const dados =
            await resposta.json();


        if (!dados) {

            atualizarOffline();

            return;

        }


        ultimaLeitura = dados;


        atualizarOnline(dados);


    } catch (erro) {

        console.error(
            "Erro ao consultar API:",
            erro
        );

        atualizarOffline();

    }

}


function atualizarOnline(dados) {

    const tensao =
        dados.tensao ??
        dados.voltagem ??
        dados.voltage;


    if (tensao !== undefined) {

        document.getElementById(
            "tensao"
        ).textContent =
            Number(tensao).toFixed(2);

    }


    document.getElementById(
        "dispositivo"
    ).textContent =
        dados.dispositivo || "OBDII";


    document.getElementById(
        "status-comunicacao"
    ).textContent =
        "● Online";


    document.getElementById(
        "status-comunicacao"
    ).className =
        "status online";


    document.getElementById(
        "status-veiculo"
    ).className =
        "indicador online";


    document.getElementById(
        "texto-veiculo"
    ).textContent =
        "Online";


    document.getElementById(
        "status-bateria"
    ).textContent =
        "Dados recebidos";


    let data = null;


    if (dados.dataHora) {

        data =
            new Date(dados.dataHora);

    } else if (dados.timestamp) {

        data =
            new Date(dados.timestamp);

    }


    if (data && !isNaN(data)) {

        document.getElementById(
            "ultima-atualizacao"
        ).textContent =
            data.toLocaleTimeString(
                "pt-BR"
            );

    } else {

        document.getElementById(
            "ultima-atualizacao"
        ).textContent =
            "Agora";

    }

}


function atualizarOffline() {

    document.getElementById(
        "status-comunicacao"
    ).textContent =
        "● Offline";


    document.getElementById(
        "status-comunicacao"
    ).className =
        "status offline";


    document.getElementById(
        "status-veiculo"
    ).className =
        "indicador offline";


    document.getElementById(
        "texto-veiculo"
    ).textContent =
        "Offline";

}


// Primeira consulta
atualizarDashboard();


// Atualiza a cada 2 segundos
setInterval(
    atualizarDashboard,
    2000
);