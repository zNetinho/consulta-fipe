package br.com.consultafipe.consultafipe.domain;

public class Consulta {
    private TiposVeiculo tipoDoVeiculo;

    public Consulta(TiposVeiculo tipoDoVeiculo) {
        this.tipoDoVeiculo = tipoDoVeiculo;
    }

    public TiposVeiculo getTipoDoVeiculo() {
        return tipoDoVeiculo;
    }

    public void setTipoDoVeiculo(TiposVeiculo tipoDoVeiculo) {
        this.tipoDoVeiculo = tipoDoVeiculo;
    }
}

