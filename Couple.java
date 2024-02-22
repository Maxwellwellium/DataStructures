public class Couple extends Person{
    private Person groom;
    private Person bride;
    // constructor
    public Couple() {
        this.groom = new Person();
        this.bride = new Person();
    }

    // getters
    public Person getGroom() {
        return groom;
    }
    public Person getBride() {
        return bride;
    }
}
