package com.gooFrete.Model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "emit.Travel")
public class Travel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "identification", nullable = false, length = 100)
    private String identification;
    
    @Column(name = "CarrierId")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID carrierId;

    @Column(name = "carrierName", nullable = false)
    private String carrierName;
    
    @Column(name = "carrierCNPJCPF", nullable = false)
    private String carrierCNPJCPF;
    
    @Column(name = "Valor", nullable = false)
    private double valor;
    
    @Column(name = "Distancia", nullable = false)
    private double distancia;
    
    @Column(name = "Duracao", nullable = false)
    private double duracao;
    
    @Column(name = "qtdePracas", nullable = false)
    private int qtdePracas;
    
    @Column(name = "EquipmentId")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID equipmentId;
    
    @Column(name = "InsertDate", nullable = false)
    private String insertDate;

    public Travel() { 
    
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public UUID getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(UUID carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierCNPJCPF() {
        return carrierCNPJCPF;
    }

    public void setCarrierCNPJCPF(String carrierCNPJCPF) {
        this.carrierCNPJCPF = carrierCNPJCPF;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getQtdePracas() {
        return qtdePracas;
    }

    public void setQtdePracas(int qtdePracas) {
        this.qtdePracas = qtdePracas;
    }

    public UUID getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(UUID equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    
    
    @Override
    public String toString() {
        return "Travel{" + "id=" + id + ", identification=" + identification + ", carrierId=" + carrierId + ", carrierName=" + carrierName + ", carrierCNPJCPF=" + carrierCNPJCPF + ", valor=" + valor + ", distancia=" + distancia + ", duracao=" + duracao + ", qtdePracas=" + qtdePracas + ", equipmentId=" + equipmentId + ", insertDate=" + insertDate + '}';
    }

}
