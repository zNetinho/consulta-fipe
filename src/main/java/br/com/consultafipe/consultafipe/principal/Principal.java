package br.com.consultafipe.consultafipe.principal;
import br.com.consultafipe.consultafipe.domain.*;
import br.com.consultafipe.consultafipe.service.ConsultaAPI;
import br.com.consultafipe.consultafipe.service.ConverteDados;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner sc = new Scanner(System.in);
    String tipoDaConsulta = "";
    String marca;
    String modelo;
    String ano;
    final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    private final ConsultaAPI consultaAPI = new ConsultaAPI();
    private final ConverteDados conversor = new ConverteDados();

    public void startAplication() throws JsonProcessingException {
        System.out.println("Informe o tipo de veículo ('carros', 'motos', 'caminhoes') ou 'sair' para encerrar:");
        tipoDaConsulta = sc.nextLine();

        while (!tipoDaConsulta.equalsIgnoreCase("sair")) {
            if(!tipoDaConsulta.isEmpty()) {
                var json = consultaAPI.obterDados(ENDERECO + tipoDaConsulta.toLowerCase() + "/marcas");
                List<MarcaVeiculo> listaDeMarcasDosVeiculos = conversor.obterDados(json, MarcaVeiculo.class);
                listaDeMarcasDosVeiculos.sort(Comparator.comparing(MarcaVeiculo::nome));
                listaDeMarcasDosVeiculos.stream()
                        .forEach(item -> System.out.println(item.codigo() + " - " + item.nome()));

                System.out.println("Digite o numero que corresponde a marca");
                marca = sc.next();
                json = consultaAPI.obterDados(ENDERECO + tipoDaConsulta + "/marcas/" + marca + "/modelos");
                System.out.println(json);
                List<VeiculoData>listaDeModelos = conversor.obterDadosModelos(json);
                listaDeModelos.stream().forEach(item -> item.modelos().stream().forEach(modelo -> System.out.println(modelo.codigo() + " - " + modelo.nome())));
                System.out.println("Digite o numero que corresponde ao modelo");
                modelo = sc.next();

                json = consultaAPI.obterDados(ENDERECO + tipoDaConsulta + "/marcas/" + marca + "/modelos/" + modelo + "/anos");
                List<AnoVeiculo> listaDeAnos = conversor.obterDados(json, AnoVeiculo.class);
                listaDeAnos.stream().forEach(item -> System.out.println(item.codigo() + " - " + item.nome()));
                System.out.println("Digite o codigo referente ao ano");
                ano = sc.next();

                var fipe = consultaAPI.obterDados(ENDERECO + tipoDaConsulta + "/marcas/" + marca + "/modelos/" + modelo + "/anos/" + ano);
                Veiculo veiculo = conversor.obterVeiculo(fipe, Veiculo.class);
                System.out.println("O veículo " + veiculo.modelo() + ", tem uma fipe de " + veiculo.valor());

                System.out.println("Obrigado por usar nossa aplicação, vamos reiniciar a consulta, se desejar encerrar digite 'sair'");
                tipoDaConsulta = "";
            } else {
                System.out.println("Por favor informe o tipo do veículo");
                tipoDaConsulta = sc.nextLine();
            }

            }
        }
}
