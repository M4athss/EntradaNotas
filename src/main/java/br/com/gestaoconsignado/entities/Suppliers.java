package br.com.gestaoconsignado.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TBSUPPLIERS")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar")
    private int cnpj;
    private String name;

    @Column(name = "common_name")
    private String commonName;

    @Column(columnDefinition = "varchar")
    private int cep;
    private String country;
    private String state;

    public Suppliers() {
    }

    public Suppliers(Long id, int cnpj, String name, String commonName, int cep, String country, String state) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.commonName = commonName;
        this.cep = cep;
        this.country = country;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suppliers suppliers = (Suppliers) o;
        return Objects.equals(id, suppliers.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
