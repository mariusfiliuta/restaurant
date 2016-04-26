package model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column (name = "name", unique = true)
    private String categoryName;

    @OneToMany(mappedBy="category")
    private List<Product> productsList = new ArrayList<Product>();

    public Category(){}

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }


    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public List<Product> getProductsList() {  return productsList; }

    public void setProductsList(List<Product> productsList) { this.productsList = productsList; }


}
