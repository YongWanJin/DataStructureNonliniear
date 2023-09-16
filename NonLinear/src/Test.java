
import java.util.*;
public class Test{
    public static void main(String[] args) {
        System.out.println("\n### 인접행렬로 구현한 그래프");
        GraphMatrix graph = new GraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1); // 첫번째 정점과 두번째 정점을 연결하는 무방향 간선 생성
        graph.addEdge(0, 2); // 첫번째 정점과 세번째 정점을 연결하는 무방향 간선 생성
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();

    }
}