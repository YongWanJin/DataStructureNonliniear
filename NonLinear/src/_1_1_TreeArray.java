import java.util.*;
// ### 배열을 통해 구현한 이진 트리
class BinaryTree{
    char[] arr;

    // # 생성자 호출하면서 미리 구성된 값 입력
    BinaryTree(char[] data){
        this.arr = data.clone();
    }

    // # 전위 순회
    public void preOrder(int cur){

        System.out.print(this.arr[cur] + " "); // <코드 맨 처음>에서 방문 => 전(pre)

        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        if (left < this.arr.length){
            this.preOrder(left);
        }

        if (right < this.arr.length){
            this.preOrder(right);
        }
    }

    // # 중위 순회
    public void inOrder(int cur){
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;

        if (left < this.arr.length){
            this.inOrder(left);
        }

        System.out.print(this.arr[cur] + " "); // <코드 한 가운데>에서 방문 => 중(in)

        if (right < this.arr.length){
            this.inOrder(right);
        }
    }

    // # 후위 순회
    public void postOrder(int cur){
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;

        if (left < this.arr.length){
            this.postOrder(left);
        }

        if (right < this.arr.length){
            this.postOrder(right);
        }

        System.out.print(this.arr[cur] + " "); // <코드 맨 마지막>에서 방문 -> 후(post)
    }

    // # 레벨 순회
    public void levelOrder(int cur){
        for(int i = 0; i < this.arr.length; i++){
            System.out.print(this.arr[i] + " ");
        }
    }
}

public class _1_1_TreeArray {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}