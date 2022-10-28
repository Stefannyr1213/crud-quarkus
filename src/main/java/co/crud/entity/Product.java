package co.crud.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
//products
@Entity
@Table(name="products")
public class Product extends PanacheEntity {

    private String name;
    private Long stock;
    private Double price;



    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
