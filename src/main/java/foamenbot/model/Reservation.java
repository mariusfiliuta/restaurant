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
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Mese masa;

    public Reservation(){}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mese getMasa() {
        return masa;
    }

    public void setMasa(Mese masa) {
        this.masa = masa;
    }
}
