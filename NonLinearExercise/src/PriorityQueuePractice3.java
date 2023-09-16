// Practice3
// nums 배열에 주어진 정수들 중에서 가장 많이 발생한 숫자들 순으로 k 번째 까지 출력하세요.
// 빈도가 같은 경우에는 값이 작은 숫자가 먼저 출력되도록 구현하세요.

// 입출력 예시
// 입력: 1, 1, 1, 2, 2, 3
// k: 2
// 출력: 1, 2

// 입력: 3, 1, 5, 5, 3, 3, 1, 2, 2, 1, 3
// k: 3
// 출력: 3, 1, 2

// # 문제 접근
// * 우선순위 기준 : '가장'많이 발생한 숫자들 순(빈도수)


import java.util.*;

public class PriorityQueuePractice3 {
    public static void solution1(int[] nums, int k) {
        // 우선순위를 기준으로 정렬할 수 있도록 전처리
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);
        }

        // 우선순위 큐 생성
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y)
                        -> x.getValue() >= y.getValue() ? -1 : 1  // 내림차순
//                (x, y) -> y.getValue() == x.getValue() ?
//                x.getKey() - y.getKey() : y.getValue() - x.getValue() // 수업 버전
        );

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            pq.offer(entry);
//            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
//        int pqSize = pq.size();

        for(int i = 0; i < k; i++){
            Map.Entry<Integer, Integer> cur = pq.poll();
            System.out.print(cur.getKey() + " ");

        }

        System.out.println();
    }

    public static void solution2(int[] nums, int k) {

    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {1, 1, 1, 2, 2, 3};
        solution1(nums, 2);
        solution2(nums, 2);
        System.out.println();

        nums = new int[]{3, 1, 5, 5, 3, 3, 1, 2, 2, 1, 3};
        solution1(nums, 3);
        solution2(nums, 3);
    }
}
