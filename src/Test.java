import java.util.*;

class MyMinHeap{
    ArrayList<Integer> heap;

    MyMinHeap(){
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int data){
        heap.add(data);
        int cur = heap.size()-1;
        while( heap.get(cur) < heap.get(cur/2) && cur > 1 ){
            int parentValue = heap.get(cur/2);
            heap.set(cur/2, heap.get(cur));
            heap.set(cur, parentValue);
            cur /= 2;
        }
        System.out.println(heap);
    }

    public Integer delete(){
        if (heap.size()==1){
            System.out.println("Empty!");
            return null;
        }

        int delNode = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));

        heap.remove(heap.size()-1);

        int cur = 1;
        while(true){
            int leftIndex = cur*2;
            int rightIndex = cur*2 + 1;
            int targetIndex = -1;

            if(rightIndex < heap.size()){
                targetIndex = heap.get(leftIndex) < heap.get(rightIndex) ? leftIndex : rightIndex;
            } else if(leftIndex < heap.size()){
                targetIndex = leftIndex;
            } else {
                break;
            }

            if(heap.get(cur) < heap.get(targetIndex)){
                break;
            } else {
                int parentValue = heap.get(cur);
                heap.set(cur, heap.get(targetIndex));
                heap.set(targetIndex, parentValue);
                cur = targetIndex;
            }
        }
        System.out.println(heap);
        return delNode;
    }

    // # 데이터 전체 출력 메서드
    public void printTree(){
        for(int i = 1; i < heap.size(); i++){
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
}

class MyMaxHeap{
    ArrayList<Integer> heap;

    MyMaxHeap(){
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int data){

        heap.add(data);

        int cur = heap.size()-1;

        while( cur > 1 && heap.get(cur) > heap.get(cur/2) ){

            int parentValue = heap.get(cur/2);
            heap.set(cur/2, heap.get(cur));
            heap.set(cur, parentValue);

            cur /= 2;
        }
        System.out.println(heap);
    }

    public Integer delete(){

        if (heap.size()==1){
            System.out.println("Empty!");
            return null;
        }

        int delNode = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));

        heap.remove(heap.size()-1);

        int cur = 1;
        while(true){
            int leftIndex = cur*2;
            int rightIndex = cur*2 + 1;
            int targetIndex = -1;

            if(rightIndex < heap.size()){
                targetIndex = heap.get(leftIndex) < heap.get(rightIndex) ? rightIndex : leftIndex;
            } else if(leftIndex < heap.size()){
                targetIndex = heap.size()-1;
            } else {
                break;
            }

            if (heap.get(cur) > heap.get(targetIndex)){
                break;
            } else {
                int parentValue = heap.get(cur);
                heap.set(cur, heap.get(targetIndex));
                heap.set(targetIndex, parentValue);
                cur = targetIndex;
            }
        }
        System.out.println(heap);
        return delNode;
    }

    public void printTree(){
        for(int i = 1; i<heap.size(); i++){
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

}

public class Test {
    public static void main(String[] args) {
//        MyMinHeap h = new MyMinHeap();
        MyMaxHeap h = new MyMaxHeap();
        h.insert(30);
        h.insert(40);
        h.insert(10);
        h.insert(50);
        h.insert(60);
        h.insert(70);
        h.insert(20);
        h.insert(30);
        h.printTree();

        h.delete();
        h.delete();
        h.delete();
        h.printTree();
    }
}
