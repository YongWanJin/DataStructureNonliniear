
// [ Tree 자료구조 Practice 2 ]

// 각각의 에지에 가중치가 있는 포화 이진 트리가 있다.
// 루트에서 각 리프까지의 경로 길이를 모두 같게 설정하고,
// 이 때, 모든 가중치들의 총합이 최소가 되도록 하는 프로그램을 작성하세요.

// int h : 트리의 높이
// int[] w : 트리에서 각각 간선의 가중치

// 입력 예시1
// int h = 2;
// int[] w = {2, 2, 2, 1, 1, 3};
// solution(h, w) =

// # 나의 문제 이해
// * 문제의 의도 : 기존 경로를 변경하지 말고
// <무슨 수를 써서라든> 모든 가중치의 합이 최소가 되도록 만들어라.
// -> 기존 가중치들을 모종의 규칙을 통해 수정해야 한다.
//
// # 이해가 안가는 것
// 간선의 가중치들을 변경할 때,
// 루트 노드에서 리프 노드에 이르기까지 간선들의 가중치의 합들 중
// 가장 큰 쪽에 맞춰야하는 이유는 무엇인가?


public class TreeExercise2 {
    public static void solution(int h, int[] w) {

    }

    public static void main(String[] args) {
        // Test code
        int h = 2;
        int[] w = {2, 2, 2, 1, 1, 3};
        solution(h, w);
        System.out.println();

        h = 3;
        w = new int[]{1, 2, 1, 3, 2, 4, 1, 1, 1, 1, 1, 1, 1, 1};
        solution(h, w);
    }
}
