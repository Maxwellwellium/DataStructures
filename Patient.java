public class Patient {
    int id;
    int age;
    BloodData bd;
    public Patient() {
        this.id = 0;
        this.age = 0;
        this.bd = new BloodData();
    }
    public Patient(int id, int age, BloodData bd) {
        this.id = id;
        this.age = age;
        this.bd = bd;
        //this.bd = new BloodData(bt, rh);
    }

    public String rep() {
        return "<html> Patient Data:       Blood Data: " + this.bd.printBlood() +
                "<br> Patient Age: " + this.getAge() + "       Patient ID Number: " + this.getId();
    }
    public BloodData getBd() {
        return bd;
    }
    public void setBd(BloodData bd) {
        this.bd = bd;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
