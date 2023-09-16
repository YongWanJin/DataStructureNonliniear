
import java.util.*;

// [ 이진 트리 기능 확장 - 연결 리스트 ]

class Node3 {
    char data;
    Node3 left;
    Node3 right;
    Node3 parent;

    public Node3(char data, Node3 left, Node3 right, Node3 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Node3 head;

    // # 생성자 - 데이터 구축
    BinaryTree3(char[] data){
        Node3[] nodes = new Node3[data.length]; // 크기 지정
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new Node3(data[i], null, null, null); // 각 노드 초기화
        }

        for (int i = 0; i < data.length; i++) {
            // nodes[i] : 현재 작업중인 노드
            int left = 2 * i + 1;  // 현재 노드의 왼쪽 자식 노드 인덱스
            int right = 2 * i + 2; // 현재 노드의 오른쪽 자식 노드 인덱스

            if (left<data.length) { // 왼쪽 자식 노드가 존재하면
                nodes[i].left = nodes[left];   // 현재 노드에서 왼쪽 자식 노드 가리키는 링크 연결
                nodes[left].parent = nodes[i]; // 왼쪽 자식 노드에서 부모 노드(현재 노드) 가리키는 링크 연결
            }

            if (right<data.length){ // 오른쪽 자식 노드가 존재하면
                nodes[i].right = nodes[right]; // 현재 노드에서 오른쪽 자식 노드 가리키는 링크 설정
                nodes[right].parent = nodes[i];// 오른쪽 자식 노드에서 부모 노드(현재 노드) 가리키는 링크 설정
            }
        }
        this.head = nodes[0]; // 헤드 노드 지정
    }

    // # 노드 탐색하는 메서드
    public Node3 searchNode(char data){
        Queue<Node3> queue = new LinkedList<>();

        // * 레벨 탐색 방식 사용
        queue.add(this.head);
        while(!queue.isEmpty()){
            Node3 cur = queue.poll();
            if (cur.data == data){
                return cur;  // 계속 순회하다가 찾고자하는 노드가 나타나면 멈춤, 리턴
            }

            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null){
                queue.offer(cur.right);
            }
        }
        return null;
    }

    // # 노드의 크기를 반환하는 메서드
    public Integer checkSize(char data){
        Node3 node = this.searchNode(data);
        // 아이디어
        // : 해당 노드부터 시작, 순회가 가능한 노드가 등장할때마다 size++
        Queue<Node3> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;
        while(!queue.isEmpty()){
            Node3 cur = queue.poll();
            if(cur.left != null){
                queue.offer(cur.left);
                size++;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1;
    }
}


public class _1_3_TreePractice {
    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);
        Node3 node;

        // # 루트 노드
        node = bt.head;
        System.out.println("루트 노드 : " + node.data);


        // # 노드 'B'의 자식 노드
        node = bt.searchNode('B');
        System.out.println("노드 'B'의 왼쪽 자식 노드 : " + node.left.data);
        System.out.println("노드 'B'의 오른쪽 자식 노드 : " + node.right.data);


        // # 노드 'F'의 부모 노드
        node = bt.searchNode('F');
        System.out.println("노드 'F'의 부모 노드 : " + node.parent.data);


        // # 리프 노드(Leaf node)
        System.out.print("리프 노드(Leaf Node) : ");
        for (int i = 0; i < arr.length; i++) {
            Node3 cur = bt.searchNode( (char)('A' + i) );
            if ( (cur.left == null) && (cur.right == null) ){
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();


        // # 노드 'E'의 깊이(Depth)
        // 즉, 루트 노드로부터 노드 'E' 까지 가는데에 거치는 간선의 개수(cnt)
        Node3 nodeE = bt.searchNode('E');
        Node3 cur = nodeE;
        int cnt = 0;
        while(cur.parent!=null){
//            if(cur.parent==null) break;
            cur = cur.parent;
            cnt++;
        }
        System.out.println("노드 'E'의 깊이(Depth) : " + cnt);


        // # Level 2에 있는 노드들
        // : 노드에서 루트노드까지의 간선 개수(cnt)를 가지고 해당 노드의 레벨을 측정한다.
        // (모든 노드에 대해 cnt 계산 시행 후, cnt==2 조건에 맞는 노드들만 출력)
        // - 주의! 레벨은 0부터 시작한다! (루트 노드는 0레벨)
        System.out.print("Level 2에 있는 노드들 : ");
        for (int i = 0; i < arr.length; i++) {
            Node3 target = bt.searchNode( (char)('A' + i) );
            cur = target;
            cnt = 0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }
            if (cnt == 2){
                System.out.print(target.data + " ");
            }
        }
        System.out.println();


        // # 이 트리의 높이(Height)
        // : 깊이(Depth)가 가장 깊은 노드의 cnt값 계산
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node3 target = bt.searchNode((char)('A'+i));
            cur = target;
            cnt = 0;
            while(cur.parent != null){
                cur = cur.parent;
                cnt++;
            }

            if(maxCnt < cnt){
                maxCnt = cnt;
            }
        }
        System.out.println("이 트리의 높이(Height) : " + maxCnt);


        // 노드 'B'의 크기(Size, 자신을 포함한 자식 노드의 개수)
        int size = bt.checkSize('B');
        System.out.println("노드 'B'의 크기 : " + size);

    }
}
