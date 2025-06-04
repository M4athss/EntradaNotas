package br.com.gestaoconsignado.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TBENTRYS")
public class Entrys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_invoice",referencedColumnName = "id")
    private Invoices id_invoice;

    @ManyToOne
    @JoinColumn(name = "id_item",referencedColumnName = "id")
    private Items id_item;

    @Column(name = "date_entry")
    private Date entry;
    private int quantity;

    @Column(name = "value_item")
    private double valueItem;

    public Entrys() {
    }

    public Entrys(Long id, Invoices id_invoice, Items id_items, Date entry, int quantity, double valueItem) {
        this.id = id;
        this.id_invoice = id_invoice;
        this.id_item = id_items;
        this.entry = entry;
        this.quantity = quantity;
        this.valueItem = valueItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoices getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(Invoices id_invoice) {
        this.id_invoice = id_invoice;
    }

    public Items getId_items() {
        return id_item;
    }

    public void setId_items(Items id_items) {
        this.id_item = id_items;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValueItem() {
        return valueItem;
    }

    public void setValueItem(double valueItem) {
        this.valueItem = valueItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrys entrys = (Entrys) o;
        return Objects.equals(id, entrys.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
