package br.com.eduardo.ifrj.monitoramento.veicular.controller;

import br.com.eduardo.ifrj.monitoramento.veicular.model.DadosVeiculo;
import br.com.eduardo.ifrj.monitoramento.veicular.model.TensaoBateria;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private TensaoBateria ultimaTensaoBateria;

    @GetMapping("/teste")
    public String teste() {
        return "VeiculoController funcionando!";
    }

    @PostMapping("/dados")
    public String receberDados(@RequestBody DadosVeiculo dados) {
        System.out.println("RPM: " + dados.getRpm());
        System.out.println("Velocidade: " + dados.getVelocidade());
        System.out.println("Temperatura: " + dados.getTemperaturaMotor());

        return "Dados do veiculo recebidos com sucesso!";
    }

    @PostMapping("/bateria")
    public String receberTensaoBateria(@RequestBody TensaoBateria dados) {

        ultimaTensaoBateria = dados;

        System.out.println("===== DADOS DA BATERIA =====");
        System.out.println("Tensão: " + dados.getTensao() + " V");
        System.out.println("Valor: " + dados.getValor());
        System.out.println("Dispositivo: " + dados.getDispositivo());
        System.out.println("Data/Hora: " + dados.getDataHora());
        System.out.println("============================");

        return "Tensão da bateria recebida com sucesso!";
    }

    @GetMapping("/bateria")
    public TensaoBateria consultarTensaoBateria() {
        return ultimaTensaoBateria;
    }
}