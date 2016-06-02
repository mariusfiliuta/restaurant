package foamenbot.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = false, nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "in_stock", length = 1)
    private String in_stock;

    @Column(name = "url_to_image")
    private String urlTOImage;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(targetEntity = ProductIngredient.class, mappedBy = "product")
    private List<ProductIngredient> ingredientList = new ArrayList<ProductIngredient>();

    public List<ProductIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<ProductIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

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

    public String getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(String in_stock) {
        this.in_stock = in_stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrlTOImage() {
        return urlTOImage;
    }

    public void setUrlTOImage(String urlTOImage) {
        this.urlTOImage = urlTOImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
