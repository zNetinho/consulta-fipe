package br.com.consultafipe.consultafipe.principal;
import br.com.consultafipe.consultafipe.domain.MarcaVeiculo;
import br.com.consultafipe.consultafipe.service.ConsultaAPI;
import br.com.consultafipe.consultafipe.service.ConverteDados;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner sc = new Scanner(System.in);
    String tipoDaConsulta = "";
    final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
    private final ConsultaAPI consultaAPI = new ConsultaAPI();
    private final ConverteDados conversor = new ConverteDados();

    public void startAplication() {

        while (!tipoDaConsulta.equalsIgnoreCase("sair")) {
            System.out.println("Informe o tipo de veículo ('carros', 'motos', 'caminhoes') ou 'sair' para encerrar:");
            tipoDaConsulta = sc.nextLine();

            if (!tipoDaConsulta.equalsIgnoreCase("sair")) {
                String json = consultaAPI.obterDados(ENDERECO);
                List<MarcaVeiculo> listaDeMarcasDosVeiculos = conversor.obterDados(json, MarcaVeiculo.class);
                listaDeMarcasDosVeiculos.sort(Comparator.comparing(MarcaVeiculo::nome));

                listaDeMarcasDosVeiculos.stream()
                        .forEach(item -> System.out.println(item.codigo() + " - " + item.nome()));
            }
        }
    }
}
