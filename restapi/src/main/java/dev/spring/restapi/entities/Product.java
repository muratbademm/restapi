package dev.spring.restapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "product_id",columnDefinition = "int auto_increment")
    private int id;

    @Column(name = "product_name")
    private  String  productName;

    @Column(name = "product_price")
    private  double productPrice;

    @Column(name = "product_stock")
    private  int productStock;

    @ManyToOne
    @JoinColumn(name = "product_supplier_id",referencedColumnName = "supplier_id")
    private Supplier supplier; //birden çok ürün 1 supplier id ye bağlı olabilir

    @ManyToOne
    @JoinColumn(name = "product_category_id",referencedColumnName = "category_id")
    private Category category;

}
