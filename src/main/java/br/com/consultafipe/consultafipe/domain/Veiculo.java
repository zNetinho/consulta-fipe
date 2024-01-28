/*
 * Copyright (c) 2024.
 */

package br.com.consultafipe.consultafipe.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Veiculo(
        @JsonAlias("TipoVeiculo") int tipoVeiculo,
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") int anoModelo,
        @JsonAlias("Combustivel") String combustivel,
        @JsonAlias("CodigoFipe") String codigoFipe,
        @JsonAlias("MesReferencia") String mesReferencia,
        @JsonAlias("SiglaCombustivel") String siglaCombustivel
) {}

//public class Veiculo {
//
//    @JsonAlias("TipoVeiculo")
//    private Integer tipoVeiculo;
//    @JsonAlias("Valor")
//    private Double valor;
//    @JsonAlias("Marca")
//    private String marca;
//    @JsonAlias("Modelo")
//    private String modelo;
//    @JsonAlias("AnoModelo")
//    private Integer anoModelo;
//    @JsonAlias("Combustivel")
//    private String combustivel;
//    @JsonAlias("CodigoFipe")
//    private String codigoFipe;
//    @JsonAlias("MesReferencia")
//    private String mesReferencia;
//    @JsonAlias("SiglaCombustivel")
//    private char siglaCombustivel;
//
//    public Veiculo(Integer tipoVeiculo, Double valor, String marca, String modelo, Integer anoModelo, String combustivel, String codigoFipe, String mesRefetencia, char siglaCombustivel) {
//        tipoVeiculo = tipoVeiculo;
//        valor = valor;
//        marca = marca;
//        modelo = modelo;
//        anoModelo = anoModelo;
//        combustivel = combustivel;
//        codigoFipe = codigoFipe;
//        mesRefetencia = mesRefetencia;
//        siglaCombustivel = siglaCombustivel;
//    }
//
//    public Veiculo() {
//
//    }
//
//    public Integer getTipoVeiculo() {
//        return tipoVeiculo;
//    }
//
//    public void setTipoVeiculo(Integer tipoVeiculo) {
//        tipoVeiculo = tipoVeiculo;
//    }
//
//    public Double getValor() {
//        return valor;
//    }
//
//    public void setValor(Double valor) {
//        valor = valor;
//    }
//
//    public String getMarca() {
//        return marca;
//    }
//
//    public void setMarca(String marca) {
//        marca = marca;
//    }
//
//    public String getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(String modelo) {
//        modelo = modelo;
//    }
//
//    public Integer getAnoModelo() {
//        return anoModelo;
//    }
//
//    public void setAnoModelo(Integer anoModelo) {
//        anoModelo = anoModelo;
//    }
//
//    public String getCombustivel() {
//        return combustivel;
//    }
//
//    public void setCombustivel(String combustivel) {
//        combustivel = combustivel;
//    }
//
//    public String getCodigoFipe() {
//        return codigoFipe;
//    }
//
//    public void setCodigoFipe(String codigoFipe) {
//        codigoFipe = codigoFipe;
//    }
//
//    public String getMesReferencia() {
//        return mesReferencia;
//    }
//
//    public void setMesRefetencia(String mesReferencia) {
//        mesReferencia = mesReferencia;
//    }
//
//    public char getSiglaCombustivel() {
//        return siglaCombustivel;
//    }
//
//    public void setSiglaCombustivel(char siglaCombustivel) {
//        siglaCombustivel = siglaCombustivel;
//    }
//
//    @Override
//    public String toString() {
//        return "Veiculo{" +
//                "TipoVeiculo=" + tipoVeiculo +
//                ", Valor=" + valor +
//                ", Marca='" + marca + '\'' +
//                ", Modelo='" + modelo + '\'' +
//                ", AnoModelo=" + anoModelo +
//                ", Combustivel='" + combustivel + '\'' +
//                ", CodigoFipe='" + codigoFipe + '\'' +
//                ", MesRefetencia='" + mesReferencia + '\'' +
//                ", SiglaCombustivel=" + siglaCombustivel +
//                '}';
//    }
//}
