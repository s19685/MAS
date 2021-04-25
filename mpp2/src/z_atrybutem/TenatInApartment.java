package z_atrybutem;

import java.time.LocalDate;

public class TenatInApartment {

    private Tenat tenat;
    private Apartment apartment;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public TenatInApartment(Tenat tenat, Apartment apartment, LocalDate dateFrom) {
        this.tenat = tenat;
        this.apartment = apartment;
        this.dateFrom = dateFrom;
    }

    public Tenat getTenat() {
        return tenat;
    }

    public void setTenat(Tenat tenat) {
        this.tenat = tenat;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
