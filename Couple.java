public class Couple extends Person{
    private Person groom;
    private Person bride;
    // constructors
    Couple() {
        this.groom = new Person();
        this.bride = new Person();
    }
    Couple(Person groom, Person bride) {
        this.groom = groom;
        this.bride = bride;
    };
    // getters
    public Person getGroom() {
        return groom;
    }
    public Person getBride() {
        return bride;
    }
}
