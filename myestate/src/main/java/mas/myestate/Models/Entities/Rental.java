package mas.myestate.Models.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;


@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "flat_id", referencedColumnName = "id")
    private Flat flat;

    @ManyToOne
    @JoinColumn(name = "resident_id", referencedColumnName = "id")
    private Resident resident;

    public Rental() {
    }

    public Rental(LocalDate startDate, LocalDate endDate, Flat flat, Resident resident) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.flat = flat;
        this.resident = resident;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Double getCost(){
        Double d = 0.;

        long days = DAYS.between(startDate,endDate);

        d = days * getFlat().getPrice();
        List<IotDevice> devices = getFlat().getDevices();
        if(!devices.isEmpty()){
            for (IotDevice dev : devices) {
                d += dev.getPrice()*days;
            }
        }
        return d;
    }
}
