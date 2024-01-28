package br.com.consultafipe.consultafipe.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarcaVeiculo(@JsonAlias("codigo") String codigo,
                           @JsonAlias("nome") String nome) implements Comparable<MarcaVeiculo>
{

    @Override
    public int compareTo(MarcaVeiculo o) {
        return this.codigo.compareTo(o.codigo);
    }
}
