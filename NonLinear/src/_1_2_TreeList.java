import java.util.*;
// ### 연결리스트로 구현한 이진 트리
class NodeBin{
    char data;
    NodeBin left;
    NodeBin right;

    NodeBin(){}
    NodeBin(char data, NodeBin left, NodeBin right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree2{

    // # 데이터 추가 및 링크 연결 작업
    NodeBin head;
    BinaryTree2(){}
    BinaryTree2(char[] data){
        NodeBin[] nodes = new NodeBin[data.length];
        // * 값 추가
        for (int i = 0; i < data.length; i++) {
            nodes[i] = new NodeBin(data[i], null, null);
        }
        // * 링크 연결 작업
        for (int i = 0; i < data.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < data.length){
                nodes[i].left = nodes[left];
            }
            if(right < data.length){
                nodes[i].right = nodes[right];
            }
        }
        // * head 노드 설정
        this.head = nodes[0];
    }

    // # 전위 순회
    public void preOrder(NodeBin cur){
        if (cur == null) {
            return;
        }
        System.out.print(cur.data + " ");
        this.preOrder(cur.left);
        this.preOrder(cur.right);
    }

    // # 중위 순회
    public void inOrder(NodeBin cur){
        if (cur == null){
            return;
        }
        this.inOrder(cur.left);
        System.out.print(cur.data + " ");
        this.inOrder(cur.right);
    }

    // # 후위 순회
    public void postOrder(NodeBin cur){
        if(cur == null){
            return;
        }
        this.postOrder(cur.left);
        this.postOrder(cur.right);
        System.out.print(cur.data + " ");
    }

    // # 레벨 순회
    public void levelOrder(NodeBin node){
        Queue<NodeBin> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            NodeBin cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null){
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}





public class _1_2_TreeList {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree2 bt = new BinaryTree2(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(bt.head);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(bt.head);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(bt.head);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(bt.head);
        System.out.println();
    }
}
