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
        Stream<Integer> stream = li.stream();

        Integer arr[]={6,3,5,8,9,2};
        Stream<Integer> stream1 = Arrays.stream(arr);

        List<Integer> filter = li.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(filter);

        List<Integer> map = li.stream().map(x -> x/2)
                .distinct()
                .sorted(Collections.reverseOrder())
                .limit(2)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(map);

        List<Integer> collect = Stream.iterate(0, x -> x + 1).limit(10).collect(Collectors.toList());
        System.out.println(collect);
    }
}
