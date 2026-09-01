package br.com.eduardo.ifrj.monitoramento.veicular.controller;

import br.com.eduardo.ifrj.monitoramento.veicular.model.DadosVeiculo;
import br.com.eduardo.ifrj.monitoramento.veicular.model.TensaoBateria;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @PostMapping("/dados")
    public String receberDados(@RequestBody DadosVeiculo dados) {

        System.out.println("RPM: " + dados.getRpm());
        System.out.println("Velocidade: " + dados.getVelocidade());
        System.out.println("Temperatura: " + dados.getTemperaturaMotor());

        return "Dados do veiculo recebidos com sucesso!";
    }

    @PostMapping("/bateria")
    public String receberTensaoBateria(@RequestBody TensaoBateria dados) {

        System.out.println("Tensão da bateria: " + dados.getTensaoBateria() + " V");

        return "Tensão da bateria recebida com sucesso!";
    }
}