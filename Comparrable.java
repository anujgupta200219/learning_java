import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class students implements Comparable<students>{
    int id;
    String name;
    students(int id,String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(students s){
        return s.name.compareTo(this.name); //Descending order
    }
}

public class Second {
    public static void main(String args[]){
        List<students> li=new ArrayList<>();
        li.add(new students(4,"f"));
        li.add(new students(1,"e"));
        li.add(new students(9,"l"));
        li.add(new students(6,"a"));
        li.add(new students(3,"i"));

        for(students s:li) {
            System.out.print(s.name);
        }
        System.out.println();
        Collections.sort(li);
        for(students s:li) {
            System.out.print(s.name);
        }
    }
}
