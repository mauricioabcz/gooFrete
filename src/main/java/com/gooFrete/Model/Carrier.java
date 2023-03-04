package com.gooFrete.Model;

/**
 *
 * @author mauricio.rodrigues
 */
public class Carrier {
    
    private String carrierName, carrierCNPJCPF, address, district, city, state, country, zipcode, telefone;
    private int carrierType;

    public Carrier(String carrierName, String carrierCNPJCPF, String address, String district, String city, String state, String country, String zipcode, String telefone, int carrierType) {
        this.carrierName = carrierName;
        this.carrierCNPJCPF = carrierCNPJCPF;
        this.address = address;
        this.district = district;
        this.city = city;
        this.country = state;
        this.state = country;
        this.zipcode = zipcode;
        this.telefone = telefone;
        this.carrierType = carrierType;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getCarrierType() {
        return carrierType;
    }

    public void setCarrierType(int carrierType) {
        this.carrierType = carrierType;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Carrier{" + "carrierName=" + carrierName + ", carrierCNPJCPF=" + carrierCNPJCPF + ", address=" + address + ", district=" + district + ", city=" + city + ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + ", telefone=" + telefone + ", carrierType=" + carrierType + '}';
    }
    
}
