package foamenbot.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column (name = "username")
    private String userName;

    @Column (name = "password")
    private String password;

    @Column (name = "role")
    private String role;

    @Column (name = "name", unique = true)
    private String contactName;

    @OneToMany(targetEntity = Order.class, mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(targetEntity = History.class, mappedBy = "user")
    private Set<History> orderHistory = new HashSet<>();

    public User() {}; // jpa


    public Set<History> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(Set<History> orderHistory) {
        this.orderHistory = orderHistory;
    }


    public User(String userName, String password, String role, String contactName) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.contactName = contactName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) { this.contactName = contactName; }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
