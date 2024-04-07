import java.util.*;

public class Main{
    static HashMap<String, StudentLinkedList> userLists = new HashMap<>();
    public Main() {
        StudentLinkedList xyz = new StudentLinkedList();

        //insert node functionality
        StudentNode a = xyz.insertNode(new Student("Alice", 18, "Computer Science", 2027));
        StudentNode b = xyz.insertNode(new Student("Brandon", 19, "Data Science", 2026));
        StudentNode c = xyz.insertNode(new Student("Chris", 20, "Political Science", 2025));
        StudentNode d = xyz.insertNode(new Student("Dan", 21, "Economy Science", 2021));
        StudentNode e = xyz.insertNode(new Student("Ethan", 22, "Art Science ", 2024));
        StudentNode f = xyz.insertNode(new Student("Francis", 28, "Scrhodingy Science ", 2029));

        System.out.println("█████Inserting Nodes█████");
        xyz.printList();

        System.out.println("█████Remove After Functions█████");
        xyz.removeAfter(a); //removes brandon
        xyz.removeAfter(f); //francis is the tail, noone is removed

        xyz.printList();

        xyz.insertNode(c.getStudent());
        xyz.insertNode(c.getStudent());
        xyz.insertNode(c.getStudent());
        xyz.insertNode(c.getStudent());
        xyz.insertNode(f.getStudent());

        xyz.printList();

        System.out.println("█████Removing duplicates List█████");
        xyz.removeDuplicate("chris"); //all duplicate chris's are removed, the duplicate francis stays

        xyz.printList();

        System.out.println("█████Maximum Functions█████");
        xyz.max(f, "age"); //returns oldest student
        xyz.max(f, "standing"); //returns highest standing student

        StudentLinkedList abc = xyz.copy(d); //copies list starting from d

        System.out.println("█████Original List█████");
        xyz.printList();
        System.out.println("█████Copied List█████");
        abc.printList();

    }


        //This place is not a place of honor... no highly esteemed deed is commemorated here... nothing valued is here.
        //What is here was dangerous and repulsive to us. This message is a warning about danger.




//        Scanner sc = new Scanner(System.in);
//        String x = null;
//        while (!Objects.equals(x, "quit")) {
//            System.out.println("MAIN MENU | enter 'info' for more information");
//            mainInput();
//        }

//    public static void mainInput() {
//        Scanner sc = new Scanner(System.in);
//        while (!Objects.equals(sc.nextLine(), "back") || !Objects.equals(sc.nextLine(), "quit")) {
//            if (Objects.equals(sc.nextLine(), "info")) {
//                System.out.println("enter 'create' to create a list ");
//                System.out.println("enter list name to modify list");
//                System.out.println("enter 'quit' to quit program");
//
//            } else if (Objects.equals(sc.nextLine(), "create")) {
//                System.out.println("creating");
//                create();
//            } else if (userLists.containsKey(sc.nextLine())) {
//                System.out.println("modifying list" + sc.nextLine());
//                modify();
//            }
//        }
//    }
//
//    public static void modify() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter 'delete' to delete list");
//        System.out.println("enter 'add' to add a student");
//        System.out.println("enter 'remove' to remove a student");
//        System.out.println("enter 'removeafter' to remove the student after a student");
//        System.out.println("enter 'copy' to copy a list");
//        System.out.println("enter 'max' to find oldest or highest student");
//
//        System.out.println("enter 'back' to go back");
//        while (!Objects.equals(sc.nextLine(), "back") || !Objects.equals(sc.nextLine(), "quit")) {
//            if (userLists.containsKey(sc.nextLine())) {
//                System.out.println("list " + sc.nextLine() + " already exists.");
//            }else if (Objects.equals(sc.nextLine(), "create")){
//                System.out.println("creating");
//                create();
//            }else if (Objects.equals(sc.nextLine(), "create")){
//                System.out.println("creating");
//                create();
//            }else if (Objects.equals(sc.nextLine(), "create")){
//                System.out.println("creating");
//                create();
//            } else {
//                createList(sc.nextLine());
//            }
//        }
//        System.out.println(sc.nextLine());
//    }
//
//
//    public static void create() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("please enter title for list:");
//        System.out.println("enter 'back' to go back");
//        while (!Objects.equals(sc.nextLine(), "back") || !Objects.equals(sc.nextLine(), "quit")) {
//            if (userLists.containsKey(sc.nextLine())) {
//                System.out.println("list " + sc.nextLine() + " already exists.");
//            } else {
//                createList(sc.nextLine());
//            }
//        }
//        System.out.println(sc.nextLine());
//    }
//    public static void createList(String name) {
//        System.out.println("list: " + name + " created");
//        userLists.put(name, new StudentLinkedList());
//    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}