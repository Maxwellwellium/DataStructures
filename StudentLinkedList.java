import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentLinkedList {
    private StudentNode head;
    private StudentNode tail;

    public StudentLinkedList(){
        head = null;
        tail = null;
    }
    public void removeAfter(StudentNode student) {
        //get node after input and call delete function
        assert (student != null);
        if (student.getNext() != null) {
            deleteNode(student.getNext().getStudent().getName());
        }else{
            System.out.println("No node after " + student.getStudent().getName());
        }
    }

    public StudentLinkedList copy(StudentNode student) {
        //creates the copy link list
        StudentLinkedList copy = new StudentLinkedList();
        //insert passed node
        copy.insertNode(student.getStudent());
        StudentNode x = student;
        //iterates through link list and appends to new copy
        while (x.getNext() != null) {
            copy.insertNode(x.getNext().getStudent());
            x = x.getNext();
        }
        return copy;
    }

    public int max(StudentNode student, String metric) {
        //assignment is ambiguous, so this function calcs age or seniority
        StudentNode current = head;
        List<StudentNode> maxList = new ArrayList<StudentNode>();
        maxList.add(head);
        int max;

        if (Objects.equals(metric, "age")){

            //for returning age
            max = current.getStudent().getAge();

            //collects max info from linked list
            while(current.getNext() != null) {
                //checks to see if next node has higher value
                if (max < current.getNext().getStudent().getAge()){
                    max = current.getNext().getStudent().getAge();
                    //clears list and adds now highest value to it
                    maxList.clear();
                    maxList.add(current.getNext());
                }else if(max == current.getNext().getStudent().getAge()){
                    //in case where max is tied, add additional students to max list
                    maxList.add(current.getNext());
                }
                current = current.getNext();
            }

            String x = null;
            StringBuilder y;
            if (maxList.size() == 1){
                y = new StringBuilder("Oldest Student in list is: ");
                x = maxList.getFirst().getStudent().getName() + " age " + maxList.getFirst().getStudent().getAge() + "years old";
                y.append(x);
            }else{
                y = new StringBuilder("Oldest Students in list are: ");
                for (StudentNode studentNode : maxList) {
                    x = studentNode.getStudent().getName() + " age " + studentNode.getStudent().getAge() + "years old, ";
                    y.append(x);
                }
            }
            System.out.println(y);
        }else {

            //for returning grad year
            max = current.getStudent().getGradYear();

            //collects max info from linked list
            while(current.getNext() != null) {
                //checks to see if next node has lower value
                if (max > current.getNext().getStudent().getGradYear()){
                    max = current.getNext().getStudent().getGradYear();
                    //clears list and adds now lowest value to it
                    maxList.clear();
                    maxList.add(current.getNext());
                }else if(max == current.getNext().getStudent().getGradYear()){
                    //in case where max is tied, add additional students to max list
                    maxList.add(current.getNext());
                }
                current = current.getNext();
            }

            //creating string statement
            String x = null;
            StringBuilder y;
            if (maxList.size() == 1){
                y = new StringBuilder("Highest Standing Student in list is: ");
                x = maxList.getFirst().getStudent().getName() + " graduating in " + maxList.getFirst().getStudent().getGradYear();
                y.append(x);
            }else{
                y = new StringBuilder("Highest Standing Students in list are: ");
                for (StudentNode studentNode : maxList) {
                    x = studentNode.getStudent().getName() + " graduating in " + studentNode.getStudent().getGradYear();
                    y.append(x);
                }
            }
            System.out.println(y);
        }
        return max;
    }
    public StudentNode insertNode(Student student){
        StudentNode node = new StudentNode(student);
        if(head == null){
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        return node;
    }

    public StudentNode insertNode(Student student, StudentNode before){
        //for inserting a node after another node instead of at the end of the list
        StudentNode insert = new StudentNode(student);
        if(head == null){
            head = insert;
        }
        else {
            StudentNode after = before.getNext();
            before.setNext(insert);
            insert.setPrev(before);
            insert.setNext(after);
            after.setPrev(insert);
        }
        //tail = node;
        return insert;
    }

    public void removeDuplicate(String key) {
        //get student if found and delete it from list
        if (searchNode(key) != null) {
            Student w = searchNode(key).getStudent();
            StudentNode y = searchNode(key).getPrev();
            deleteNode(key);

            //loop through list to delete all duplicates
            int z = 0;
            StudentNode x = searchNode(key);
            while (x != null) {
                z += 1;
                System.out.println("removing " + z + " duplicates");
                deleteNode(x.getStudent().getName());
                x = searchNode(key);
                //System.out.println(x.getStudent().getName());
            }
            //reinsert student back in original first spot
            if (y != null){
                insertNode(w, y);
            }else {
                insertNode(w, head);
            }
            System.out.println("duplicates of" + key + "removed");
        }
    }

    public StudentNode searchNode(String name){
        //starts with head of linked list
        StudentNode current = head;
        if (current.getStudent().getName().equals(name)){
            return head;
        } else {
            while(current.getNext() != null){
                if(current.getNext().getStudent().getName().equals(name)) {
                    //prints predecessor, node, and successor
                    //System.out.println("P Node => " + current.getStudent().getName());
                    System.out.println("Found Node => " + current.getNext().getStudent().getName());
                    //if (current.getNext().getNext() != null) {
                    //    System.out.println("N Node => " + current.getNext().getNext().getStudent().getName());
                    //}else{
                    //    System.out.println("N Node is Null");
                    //}
                    return current.getNext();
                }else{
                    //reassigns current to iterate through list
                    current = current.getNext();
                }
            }
        }
        return null;
    }

    public void deleteNode(String name){
        //starts with head of linked list
        StudentNode current = head;
        if(!current.getStudent().getName().equals(name)){
            while(current.getNext() != null) {
                if (current.getNext().getStudent().getName().equals(name)) {
                    //prints predecessor, node, and successor
                    //System.out.println("P Node => " + current.getStudent().getName());
                    System.out.println("Deleted Node => " + current.getNext().getStudent().getName());
                    //if (current.getNext().getNext() != null) {
                        //System.out.println("N Node => " + current.getNext().getNext().getStudent().getName());
                    //}else{
                        //System.out.println("N Node => Null");
                    //}

                    //updates predecessor's successor and successor's predecessor
                    current.setNext(current.getNext().getNext());
                    if (current.getNext() != null) {
                        current.getNext().setPrev(current.getPrev());
                    }
                    //System.out.println("---------------");
                    break;
                }else{
                    //reassigns current to iterate through list
                    current = current.getNext();
                }
            }
        }else{
            //in the case the head is deleted
            //updates predecessor's successor and successor's predecessor
            if (current.getNext() != null) {
                head = current.getNext();
                current.getNext().setPrev(null);
            }
            System.out.println("---------------");
        }
    }

    public void printList(){
        //starts with head of linked list
        StudentNode current = head;
        System.out.println("============PrintList Start=============");
        while(current.getNext() != null) {
            String sCurrent = current.getStudent().getName();
            //prints node and its predecessor
            if (current.getPrev() == null) {
                System.out.println(sCurrent + " Does not have a Previous node");
            }else{
                System.out.println(sCurrent + " succeeds=> " + current.getPrev().getStudent().getName());
            }

            //prints node and its successor
            System.out.println(sCurrent + " <=precedes " + current.getNext().getStudent().getName());

            //reassigns current to iterate through list
            current = current.getNext();
        }

        //prints last element and ending line
        System.out.println(current.getStudent().getName() + " Does not have a Next node");
        System.out.println("============PrintList End=============");
    }

}