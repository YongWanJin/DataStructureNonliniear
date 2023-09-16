import java.util.*;

public class _5_1_PriorityQueue {

    // ### 정렬된 연결 리스트로 구현한 우선순위 큐
    // # enqueue 구현
    // (들어오는 값의 크기가 작을수록 우선순위가 높다고 하자.)
    // (우선순위가 가장 높은 데이터를 맨 앞에 삽입)
    public static void enqueue(LinkedList<Integer> list, int data) {
        // * 1. data를 삽입할 위치 인덱스 찾기
        int idx = list.size();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > data){
                idx = i;
                break;
            }
        }
        // * 2. data 삽입
        list.add(idx, data);
    }

    // # dequeue 구현
    public static Integer dequeue(LinkedList<Integer> list) {
        // * 0. 예외 처리
        if(list.size() == 0){
            return null;
        }

        // * 1. 데이터 출력 및 삭제
        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args) {
        // 연결리스트를 이용한 우선순위 큐
        System.out.println("== 연결리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 4);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        // 자바 기본 PriorityQueue 사용
        System.out.println("== 자바 기본 우선순위 큐 ==");
        // 우선순위: 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(4);
        pq.add(9);
        System.out.println(pq); // 좀 이상한데?

        // 우선순위: 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(4);
        pq2.add(9);
        System.out.println(pq2); // 좀 이상한데?
    }
}
