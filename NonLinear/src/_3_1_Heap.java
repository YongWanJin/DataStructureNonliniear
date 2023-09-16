import java.util.*;

// [ 최소힙 구현 ]
class MinHeap {
    ArrayList<Integer> heap; // 완전 이진 트리 -> 데이터의 연속성 보장

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);  // 인덱스가 1부터 시작하도록 (부모노드 위치 계산을 위해)
    }

    // # 데이터 입력 메서드
    public void insert(int data) {
        // 1. 일단 맨 끝에 입력
        heap.add(data);

        // 2. 현재 작업 위치 설정
        // (방금 입력한 데이터의 위치 ,맨 끝으로 설정)
        int cur = heap.size() - 1;
        System.out.println(heap);

        // 3. <부모 노드>와 입력한 데이터 노드의 값 서로 비교
        // cur>1 : 부모 노드 존재 여부
        // heap.get(cur/2) > heap.get(cur) : 부모 노드가 입력한 노드보다 더 큰지 여부
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) {

            // 4. 자리를 맞바꿈
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);
            System.out.println(heap);

            // 5. 현재 작업 위치 갱신
            cur /= 2;
            // while문 반복
        }
    }

    // # 데이터 삭제(Root Node 삭제) 메서드
    public Integer delete() {

        // 0. 예외처리 (heap이 비었을 때)
        if (heap.size() == 1) {
            System.out.println("Empty!");
            return null;
        }

        // 1. 기존 Root Node와 맨 마지막 노드 맞바꿈
        int target = heap.get(1); // 삭제될 노드 == RootNode (리턴 용도)
        heap.set(1, heap.get(heap.size() - 1));

        // 2. 맨 마지막 노드 삭제
        heap.remove(heap.size() - 1);
        System.out.println(heap);

        // 3. 노드 재정렬에 쓰일 변수들 생성
        int cur = 1; // 현재 작업중인 노드(cur노드)의 인덱스
        while (true) {
            int leftIndex = cur * 2;      // cur노드의 왼쪽 자식노드의 인덱스
            int rightIndex = cur * 2 + 1; // cur노드의 오른쪽 자식노드의 인섹스
            int targetIndex = -1;         // 최종으로 지목한 노드의 인덱스

            // 4. cur노드와 맞바꿀 자식노드의 인덱스 지목(targetIndex값 지정)
            if (rightIndex < heap.size()) {       // 두 자식노드가 모두 존재하는 경우
                targetIndex = heap.get(leftIndex) < heap.get(rightIndex) ? leftIndex : rightIndex;
            } else if (leftIndex < heap.size()) { // 한쪽 자식노드만 존재할 경우
                targetIndex = cur * 2;
            } else { // 자식노드가 없는 경우
                break;
            }

            // 5. 지목한 인덱스의 자식노드와 cur노드의 값을 맞바꿈
            if (heap.get(cur) < heap.get(targetIndex)) { // 맞바꿀 수 없는 지점 도달
                break;
            } else { // 맞바꿀 수 있는 지점 (cur노드(부모노드)가 targetIndex의 자식노드보다 큼)
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIndex));
                heap.set(targetIndex, parentVal);
                cur = targetIndex;
            }
            // break구문에 도달할때까지 재정렬 과정 반복
        }
        // 6. 삭제된 노드(최초의 Root Node) 반환
        System.out.println(heap);
        return target;
    }

    // 전체 데이터 출력
    public void printTree() {
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}


// [ 최대힙 구현 ]
// : 최소힙에서 부등호만 몆개 바꿔주면 된다.
class MaxHeap{
    ArrayList<Integer> heap;

    MaxHeap(){
        heap = new ArrayList<>();
        heap.add(0);
    }

    // # 데이터 삽입 메서드
    public void insert(int data) {

        heap.add(data);

        int cur = heap.size() - 1;

        System.out.println(heap);

        while (cur > 1 && heap.get(cur / 2) < heap.get(cur)) { // 부등호 바꾸기

            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
        System.out.println(heap);
    }

    // # 데이터 삭제(Root Node 삭제) 메서드
    public Integer delete() {

        if (heap.size() == 1) {
            System.out.println("Empty!");
            return null;
        }

        int target = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));

        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIndex = cur * 2;
            int rightIndex = cur * 2 + 1;
            int targetIndex = -1;

            if (rightIndex < heap.size()) {
                targetIndex = heap.get(leftIndex) > heap.get(rightIndex) ? leftIndex : rightIndex;
                // ↑ 부등호 바꾸기
            } else if (leftIndex < heap.size()) {
                targetIndex = cur * 2;
            } else {
                break;
            }

            if (heap.get(cur) > heap.get(targetIndex)) { // 부등호 바꾸기
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIndex));
                heap.set(targetIndex, parentVal);
                cur = targetIndex;
            }
        }
        System.out.println(heap);
        return target;
    }

    // 전체 데이터 출력
    public void printTree() {
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class _3_1_Heap {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap();

        System.out.println("\n# 입력");

        mh.insert(30);
        mh.printTree();
        mh.insert(40);
        mh.printTree();
        mh.insert(10);
        mh.printTree();
        mh.insert(50);
        mh.printTree();
        mh.insert(60);
        mh.printTree();
        mh.insert(70);
        mh.printTree();
        mh.insert(20);
        mh.printTree();
        mh.insert(30);
        mh.printTree();

        System.out.println("\n# 삭제");

        mh.delete();
        mh.printTree();
        mh.delete();
        mh.printTree();
        mh.delete();
        mh.printTree();

    }
}
