import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams {
    public static void main(String args[]) {
        List<Integer> li=new ArrayList<>();
        li.add(6);
        li.add(3);
        li.add(3);
        li.add(9);
        li.add(2);
        Stream<Integer> stream = li.stream(); //creating stream from list

        Integer arr[]={6,3,5,8,9,2};
        Stream<Integer> stream1 = Arrays.stream(arr); //creating steam from array 

        List<Integer> filter = li.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());  //using filter
        System.out.println("x%2 -> "+filter);

        List<Integer> map = li.stream()
                .map(x -> x/2) //using map
                .distinct()    //provide distinct elements
                .sorted(Collections.reverseOrder()) // sort the list and it want object of comparator
                .limit(2)  //limit of the scanning
                .skip(1)   // skip the elements
                .collect(Collectors.toList()); //convert stream to list
        System.out.println("x/2 -> "+map);

        List<Integer> collect = Stream
                .iterate(0, x -> x + 1)
                .limit(10)
                .peek(x-> System.out.print(x+" "))  //perform operation in between the urls
                .collect(Collectors.toList()); 
        System.out.println();
        System.out.println("x+1 -> "+collect);

        System.out.println("min -> "+li.stream()
                .map(x->x)
                .min((a,b)->a-b));  //provide min of the elements

        System.out.println("count -> "+li.stream()
                .map(x->x)
                .distinct()
                .count());  //provides count of the elements.
    }
}
