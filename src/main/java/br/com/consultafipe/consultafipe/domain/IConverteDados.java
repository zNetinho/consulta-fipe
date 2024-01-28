package br.com.consultafipe.consultafipe.domain;

import java.util.List;

public interface IConverteDados {
    // metodo generico que não sabe qual vai ser o seu recebimento
    <T> List<MarcaVeiculo> obterDados(String json, Class<T> classe);
}