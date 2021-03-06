package foamenbot.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProduct;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Order() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderProduct> getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(Set<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
