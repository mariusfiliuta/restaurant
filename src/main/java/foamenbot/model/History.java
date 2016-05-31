package foamenbot.model;

import javax.persistence.*;

import com.sun.istack.internal.NotNull;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "table_name")
    private String tableName;

    @ManyToOne
    @JoinColumn( name = "user_id")
    private User user;


    public History(){}
    public History(Order order){
        this.startDate = order.getDate();
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Calendar calendarInstance = Calendar.getInstance();
        this.endDate = df.format(calendarInstance.getTime());
        this.totalPrice = order.getTotalPrice();
        this.tableName = order.getName();
        this.user = order.getUser();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
