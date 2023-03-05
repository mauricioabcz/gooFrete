package com.gooFrete.Model;

/**
 *
 * @author mauricio.rodrigues
 */
public class Equipment {
    
    private String equipmentType, Modelo, Marca, licensePlate, transportadorVinculado;
    private int eixos;

    public Equipment(String equipmentType, String Modelo, String Marca, String licensePlate, int eixos, String transportadorVinculado) {
        this.equipmentType = equipmentType;
        this.Modelo = Modelo;
        this.Marca = Marca;
        this.licensePlate = licensePlate;
        this.eixos = eixos;
        this.transportadorVinculado = transportadorVinculado;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }

    public String getTransportadorVinculado() {
        return transportadorVinculado;
    }

    public void setTransportadorVinculado(String transportadorVinculado) {
        this.transportadorVinculado = transportadorVinculado;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentType=" + equipmentType + ", Modelo=" + Modelo + ", Marca=" + Marca + ", licensePlate=" + licensePlate + ", transportadorVinculado=" + transportadorVinculado + ", eixos=" + eixos + '}';
    }

}
