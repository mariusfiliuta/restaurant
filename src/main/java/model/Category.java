package model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column (name = "name", unique = true)
    private String categoryName;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }


    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

}
