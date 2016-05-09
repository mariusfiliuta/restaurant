package foamenbot.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "in_stock")
    private boolean in_stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
