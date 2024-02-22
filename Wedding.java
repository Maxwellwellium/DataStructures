import java.time.LocalDate;

public class Wedding extends Couple{

    private Couple couple;
    private LocalDate date;
    private String location;
    // constructor
    Wedding(){
        this.couple = new Couple();
    };
    // getters
    public Couple getCouple() {
        return couple;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }
    // setters
    public void setDate(LocalDate newDate) {
        this.date = newDate;
        System.out.println("the date is now: " + this.date);
    }
    public void setLocation(String newLocation) {
        this.location = newLocation;
        System.out.println("the location is now: " + this.location);
    }
}