package br.com.eduardo.ifrj.monitoramento.veicular.controller;

import br.com.eduardo.ifrj.monitoramento.veicular.model.DadosVeiculo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @GetMapping("/teste")
    public String testeVeiculo() {
        return "VeiculoController funcionando!";
    }

    @PostMapping("/dados")
    public String receberDados(@RequestBody DadosVeiculo dados) {

        System.out.println("RPM: " + dados.getRpm());
        System.out.println("Velocidade: " + dados.getVelocidade());
        System.out.println("Temperatura: " + dados.getTemperaturaMotor());

        return "Dados do veiculo recebidos com sucesso!";
    }
}