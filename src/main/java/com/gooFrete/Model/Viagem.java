package com.gooFrete.Model;

import java.util.List;

/**
 *
 * @author mauricio.rodrigues
 */
public class Viagem {
    
    private String nome, transportador, tipoVeiculo;
    private int numEixos, tipoPagamento;
    private List<String> paradas;

    public Viagem(String nome, String transportador, String tipoVeiculo, int numEixos, int tipoPagamento, List<String> paradas) {
        this.nome = nome;
        this.transportador = transportador;
        this.tipoVeiculo = tipoVeiculo;
        this.numEixos = numEixos;
        this.tipoPagamento = tipoPagamento;
        this.paradas = paradas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTransportador() {
        return transportador;
    }

    public void setTransportador(String transportador) {
        this.transportador = transportador;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }

    public int getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<String> getParadas() {
        return paradas;
    }

    public void setParadas(List<String> paradas) {
        this.paradas = paradas;
    }

    @Override
    public String toString() {
        return "Viagem{" + "nome=" + nome + ", transportador=" + transportador + ", tipoVeiculo=" + tipoVeiculo + ", numEixos=" + numEixos + ", tipoPagamento=" + tipoPagamento + ", paradas=" + paradas + '}';
    }
    
}
