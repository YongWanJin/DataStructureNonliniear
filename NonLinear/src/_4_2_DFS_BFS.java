import java.util.*;

// ### 인접행렬 그래프
class GraphMatrix2 extends GraphMatrix{

    public GraphMatrix2(int size){
        super(size);
    }

    // # 깊이 우선 탐색 (DFS, Deep First Search) 메서드
    // : stack 자료구조 사용
    public void dfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while(!stack.isEmpty()){
            int curId = stack.pop();
            System.out.print(this.vertexes[curId] + " ");

            for (int i = this.elemCnt - 1; i >= 0; i--){ // 역순 탐색 (교안에 맞게)
                if ( (this.adjMat[curId][i] == 1) && (visited[i] == false) ){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    // # 너비 우선 탐색(BFS, Breath First Search) 메서드
    // stack 대신 queue 자료구조 사용하는 점만 달라졌다.
    public void bfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while(!queue.isEmpty()){
            int curId = queue.poll();
            System.out.print(this.vertexes[curId] + " ");

            for(int i = this.elemCnt-1; i >= 0; i--){
                if( (this.adjMat[curId][i] == 1) && (visited[i] == false) ){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}

// ### 인접리스트 그래프
class GraphList2 extends GraphList{

    public GraphList2(int size){
        super(size);
    }

    // # 깊이 우선 탐색(DFS) 메서드
    public void dfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()){
            int curId = stack.pop();
            System.out.print(vertexes[curId] + " ");

            Node cur = this.adjList[curId];
            while(cur != null){
                if (visited[cur.id] == false) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }

    // # 너비 우선 탐색(BFS) 메서드
    public void bfs(int id){
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while(!queue.isEmpty()){
            int curId = queue.poll();
            System.out.print(this.vertexes[curId] + " ");

            Node cur = this.adjList[curId];
            while(cur != null){
                if (visited[cur.id] == false){
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();

    }
}

public class _4_2_DFS_BFS {
    public static void main(String[] args) {

        // ### 인접행렬 생성
        System.out.println("\n### 인접행렬 그래프");
        System.out.println("\n# 그래프 생성");
        GraphMatrix2 graph = new GraphMatrix2(7);
        graph.addVertex('A');   // id : 0
        graph.addVertex('B');   // id : 1
        graph.addVertex('C');   // id : 2
        graph.addVertex('D');   // id : 3
        graph.addVertex('E');   // id : 4
        graph.addVertex('F');   // id : 5
        graph.addVertex('G');   // id : 6

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        System.out.println();
        graph.printAdjacentMatrix();

        // # 깊이 우선 탐색(DFS) 시행
        System.out.println("\n# 깊이 우선 탐색(DFS) 시행");
        graph.dfs(0);

        // # 너비 우선 탐색(BFS) 시행
        System.out.println("\n# 너비 우선 탐색(BFS) 시행");
        graph.bfs(0);


        // ### 인접리스트 생성
        System.out.println("\n\n### 인접리스트 그래프");
        System.out.println("\n# 그래프 생성");
        GraphList2 graph2 = new GraphList2(7);
        graph2.addVertex('A');   // id : 0
        graph2.addVertex('B');   // id : 1
        graph2.addVertex('C');   // id : 2
        graph2.addVertex('D');   // id : 3
        graph2.addVertex('E');   // id : 4
        graph2.addVertex('F');   // id : 5
        graph2.addVertex('G');   // id : 6

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(0, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 5);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 6);
        graph2.addEdge(5, 6);
        System.out.println();
        graph2.printAdjacentList();

        // # 깊이 우선 탐색(DFS) 시행
        System.out.println("\n# 깊이 우선 탐색(DFS) 시행");
        graph2.dfs(0);

        // # 너비 우선 탐색(BFS) 시행
        System.out.println("\n# 너비 우선 탐색(BFS) 시행");
        graph2.bfs(0);
    }

}
