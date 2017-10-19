package com.example.tiburcio.galletas.pojos;

/**
 * Created by Tiburcio on 18/10/2017.
 */

public class Galleta {
    String marca;
    int stock;

    public Galleta(String marca, int stock) {
        this.marca = marca;
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
