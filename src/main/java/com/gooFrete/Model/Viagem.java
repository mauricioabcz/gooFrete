package com.gooFrete.Model;

import java.util.List;

/**
 *
 * @author mauricio.rodrigues
 */
public class Viagem {
    
    private String nomeTransportador, transportadorCNPJCPF, tipoVeiculo, placa;
    private int numEixos, tipoPagamento, qtdePracas;
    private String paradas, valor, distancia, duracao;
    private List<String> listaPracas;


    public Viagem(String nomeTransportador, String transportadorCNPJCPF, String tipoVeiculo, String placa, int numEixos, int tipoPagamento, String paradas) {
        this.nomeTransportador = nomeTransportador;
        this.transportadorCNPJCPF = transportadorCNPJCPF;
        this.tipoVeiculo = tipoVeiculo;
        this.placa = placa;
        this.numEixos = numEixos;
        this.tipoPagamento = tipoPagamento;
        this.paradas = paradas;
    }

    public String getTransportador() {
        return transportadorCNPJCPF;
    }

    public void setTransportador(String transportador) {
        this.transportadorCNPJCPF = transportador;
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

    public int getQtdePracas() {
        return qtdePracas;
    }

    public void setQtdePracas(int qtdePracas) {
        this.qtdePracas = qtdePracas;
    }

    public String getParadas() {
        return paradas;
    }

    public void setParadas(String paradas) {
        this.paradas = paradas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public List<String> getListaPracas() {
        return listaPracas;
    }

    public void setListaPracas(List<String> listaPracas) {
        this.listaPracas = listaPracas;
    }

    public String getNomeTransportador() {
        return nomeTransportador;
    }

    public void setNomeTransportador(String nomeTransportador) {
        this.nomeTransportador = nomeTransportador;
    }

    public String getTransportadorCNPJCPF() {
        return transportadorCNPJCPF;
    }

    public void setTransportadorCNPJCPF(String transportadorCNPJCPF) {
        this.transportadorCNPJCPF = transportadorCNPJCPF;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Viagem{" + "nomeTransportador=" + nomeTransportador + ", transportadorCNPJCPF=" + transportadorCNPJCPF + ", tipoVeiculo=" + tipoVeiculo + ", placa=" + placa + ", numEixos=" + numEixos + ", tipoPagamento=" + tipoPagamento + ", qtdePracas=" + qtdePracas + ", paradas=" + paradas + ", valor=" + valor + ", distancia=" + distancia + ", duracao=" + duracao + ", listaPracas=" + listaPracas + '}';
    }

}
