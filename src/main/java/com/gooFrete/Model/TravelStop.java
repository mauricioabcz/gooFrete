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
@Table(name = "emit.TravelStop")
public class TravelStop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;
    
    @Column(name = "Praca", nullable = false)
    private String praca;
    
    @Column(name = "Valor", nullable = false)
    private double valor;
    
    @Column(name = "TravelId")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID travelId;
    
    @Column(name = "InsertDate", nullable = false)
    private String insertDate;

    public TravelStop() {
        
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPraca() {
        return praca;
    }

    public void setPraca(String placa) {
        this.praca = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public UUID getTravelId() {
        return travelId;
    }

    public void setTravelId(UUID travelId) {
        this.travelId = travelId;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "TravelStop{" + "id=" + id + ", praca=" + praca + ", valor=" + valor + ", travelId=" + travelId + ", insertDate=" + insertDate + '}';
    }
    
}
