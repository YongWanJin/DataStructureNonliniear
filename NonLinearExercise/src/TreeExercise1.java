
// [ Tree 자료구조 Practice 1 ]
// : 종이 접기

// 종이를 반으로 접었을 때, 안으로 파인 부분은 0, 볼록 튀어나온 부분은 1이라고 하자.
// 종이를 접을 때는 오른쪽에서 왼쪽으로 접는다.
// 종이를 N번 접었을 때의 접힌 상태를 출력하는 문제를 작성하세요.

// 입출력 예시
// 입력: 1
// 출력: 0

// 입력: 2
// 출력: 0, 0, 1

// 입력: 3
// 출력: 0, 0, 1, 0, 0, 1, 1

public class TreeExercise1 {
    // # 트리 생성 및 노드 입력
    public static void solution(int n) {

        int[] binaryTree = new int[(int)Math.pow(2, n)]; // 맨 마지막 인덱스는 사용 안함
        binaryTree[0] = 0; // 루트 노드 입력
        for (int i = 0; i < (int) Math.pow(2, n-1) -1 ; i++) { // 자식 노드 입력
            binaryTree[i * 2 + 1] = 0; // 왼쪽 자식 노드
            binaryTree[i * 2 + 2] = 1; // 오른쪽 자식 노드
        }
        inOrder(binaryTree, 0);
        System.out.println();
    }

    // # inOrder 탐색 구현
    public static void inOrder(int[] arr, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if(left < arr.length - 1){ // 맨 마지막 인덱스는 사용하지 않을 것이므로
            inOrder(arr, left);
        }
        System.out.print(arr[index] + " ");
        if(right < arr.length - 1){
            inOrder(arr, right);
        }

    }

    public static void main(String[] args) {
        // Test code
        solution(1);
        solution(2);
        solution(3);
    }
}

// [ 나의 이해 ]
//
// # 1. 어떤 패턴에서 이진 트리 구조를 이용해야하는가?
// * 특정 기점(부모 노드)을 중심으로 두 갈래로 대칭(두 자식 노드)되는 형태,
// 그리고 그 형태가 프렉탈 구조(?)처럼 반복되는 형태
//
// # 2. 어떤 탐색 방식을 사용해야할까?
// * 나타나는 패턴을 처음부터 차례대로 나열한 것과
// 트리 구조로 표현된 패턴을 비교해보자.


