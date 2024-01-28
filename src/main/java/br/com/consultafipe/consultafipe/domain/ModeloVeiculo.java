/*
 * Copyright (c) 2024.
 */

package br.com.consultafipe.consultafipe.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloVeiculo(
        @JsonAlias("codigo") String codigo,
        @JsonAlias("nome") String nome
) implements Comparable<ModeloVeiculo>
{
    @Override
    public int compareTo(ModeloVeiculo o) {
        return this.codigo.compareTo(o.codigo);
    }
}
