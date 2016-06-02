package foamenbot.model;

/**
 * Created by Mihai on 01.06.2016.
 */
public class helpObject {

    private String orderName;
    private long id;

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    private String waiter;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }
    public helpObject(){

    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
