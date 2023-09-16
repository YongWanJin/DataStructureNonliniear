
import java.util.*;


class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}

public class _2_Custom {
    public static void main(String[] args) {
        String[] name = {"dddd", "dzzzz", "apple", "coconut", "banana"};
        int[] age = {30, 20, 45, 62, 35};

        // # 나이 순서대로 우선순위 설정
        PriorityQueue<Person> pq = new PriorityQueue<>(
                (Person p1, Person p2) -> p1.age >= p2.age ? 1 : -1 // 오름차순
             // (Person p1, Person p2) -> p1.age >= p2.age ? -1 : 1 // 내림차순
        );

        for (int i = 0; i < age.length; i++) {
            pq.add(new Person(name[i], age[i]));
        }
        while(!pq.isEmpty()){
            Person p = pq.poll();
            System.out.println(p.name + "  " + p.age);
        }
        System.out.println();

        // # 알파벳 순으로 우선순위 설정
        PriorityQueue<Person> pq2 = new PriorityQueue<>(
                (Person p1, Person p2) -> p1.name.compareTo(p2.name) // 오름차순
             // (Person p1, Person p2) -> p2.name.compareTo(p1.name) // 내림차순
        );
        for (int i = 0; i < age.length; i++) {
            pq2.add(new Person(name[i], age[i]));
        }
        while(!pq2.isEmpty()){
            Person p = pq2.poll();
            System.out.println(p.name + "  " + p.age);
        }
    }
}
