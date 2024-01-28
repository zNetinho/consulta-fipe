package br.com.consultafipe.consultafipe.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoData(
        @JsonAlias("anos") List<ModeloVeiculo> anos,
        @JsonAlias("modelos") List<ModeloVeiculo> modelos) {
}
