package br.com.gestaoconsignado.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TBINVOICES")
public class Invoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "note_number")
    private int noteNumber;
    private Date emissionDate;

    @ManyToOne
    @JoinColumn(name = "id_suppliers", referencedColumnName = "id")
    private Suppliers idSuppliers;
    private Double total;

    public Invoices() {
    }

    public Invoices(Long id, int noteNumber, Date emissionDate, Suppliers idSuppliers, Double total) {
        this.id = id;
        this.noteNumber = noteNumber;
        this.emissionDate = emissionDate;
        this.idSuppliers = idSuppliers;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(int noteNumber) {
        this.noteNumber = noteNumber;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public Suppliers getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(Suppliers idSuppliers) {
        this.idSuppliers = idSuppliers;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoices invoices = (Invoices) o;
        return Objects.equals(id, invoices.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
