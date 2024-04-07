public class StudentNode {
    private Student student;
    private StudentNode next;
    private StudentNode prev;

    public StudentNode(Student student){
        this.student = student;
        this.next = null;
        this.prev = null;
    }

    public Student getStudent() {
        return student;
    }

    public StudentNode getNext() {
        return next;
    }
    public StudentNode getPrev() {
        return prev;
    }
    public void setPrev(StudentNode prev) {
        this.prev = prev;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
}