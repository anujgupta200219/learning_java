import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class student{
    int id;
    String name;
    student(int id,String name){
        this.id=id;
        this.name=name;
    }
}

public class First implements Comparator<student>{
    public int compare(student s1,student s2){
        return s1.name.compareTo(s2.name);
    }

    public static void main(String args[]){
        List<student> li=new ArrayList<>();
        li.add(new student(4,"f"));
        li.add(new student(1,"b"));
        li.add(new student(9,"k"));
        li.add(new student(6,"e"));
        li.add(new student(3,"a"));

        for(student s:li) {
            System.out.print(s.name);
        }
        //--------------------------------------------------------
        System.out.println();

        li.sort(new First()); //Ascending Order

        for(student s:li) {
            System.out.print(s.name);
        }
        //-------------------------------------------------------
        //reverse order
        li.sort(Comparator.comparing((student s)->s.name,Comparator.reverseOrder()).thenComparing((student s)->s.id,Comparator.reverseOrder()));

        System.out.println();
        for(student s:li) {
            System.out.print(s.name);
        }

        //----------------------------------------------------------
        //reverse order
        li.sort(Comparator.comparing((student s)->s.name).reversed().thenComparing((student s)->s.id,Comparator.reverseOrder()));

        System.out.println();
        for(student s:li) {
            System.out.print(s.name+" "+s.id+" | ");
        }

        System.out.println();
        for(student s:li) {
            System.out.print(s.name+" "+s.id+" | ");
        }
    }
}
