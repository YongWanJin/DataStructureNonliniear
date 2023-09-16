

// ### 행렬 인접 행렬로 구현
class GraphMatrix {

    char[] vertexes; // 정점들
    int[][] adjMat;  // 인접 행렬
    int elemCnt;     // 정점 개수

    GraphMatrix() {}
    GraphMatrix(int size) {
        this.vertexes = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }


    // # 꽉 찼는지 판별하는 메서드
    public boolean isFull(){
        return (this.elemCnt == this.vertexes.length);
    }


    // # 정점을 추가하는 메서드
    public void addVertex(char data){
        if (isFull()){
            System.out.println("This Graph is Full!");
            return;
        }
        this.vertexes[this.elemCnt++] = data;
    }


    // # 간선 추가 메서드
    // * 무방향 그래프
    public void addEdge(int x, int y){
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }
    // * 방향 그래프
    public void addDirectedEdge(int x, int y){
        this.adjMat[x][y] = 1;
    }


    // # 간선 삭제 메서드
    // * 무방향 그래프
    public void deleteEdge(int x, int y){
        adjMat[x][y] = 0;
        adjMat[y][x] = 0;
    }
    // * 방향 그래프
    public void deleteDirectedEdge(int x, int y){
        adjMat[x][y] = 0;
    }


    // # 인접 행렬 출력 메서드
    public void printAdjacentMatrix(){
        System.out.print("  ");
        for (char item : this.vertexes) {
            System.out.print(item + " ");
        }
        System.out.println();

        for(int row = 0; row < this.elemCnt; row++){
            System.out.print(this.vertexes[row] + " ");
            for(int col = 0; col < this.elemCnt; col ++){
                System.out.print(this.adjMat[row][col] + " ");
            }
            System.out.println();
        }
    }
}


// ### 인접 리스트로 구현
class Node{
    int id;
    Node next;

    Node(int id, Node next){
        this.id = id;
        this.next = next;
    }
}

class GraphList{
    char[] vertexes;
    Node[] adjList;
    int elemCnt;

    GraphList(){}
    GraphList(int size){
        this.vertexes = new char[size];
        this.adjList = new Node[size];
        elemCnt = 0;
    }

    // # 그래프가 꽉 차있는지 판별하는 메서드
    public boolean isFull(){
        return (this.elemCnt == this.vertexes.length);
    }

    // # 정점을 추가하는 메서드
    public void addVertex(char data){
        if (isFull()){
            System.out.println("This Graph is Full!");
            return;
        }
        this.vertexes[this.elemCnt++] = data;
    }

    // # 간선을 추가하는 메서드
    // * 무방향 그래프
    public void addEdge(int x, int y){
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);

        // this.adjList[x]
        // : 배열 adjList의 인덱스 x에 저장된 <Head Node> (초기값은 id도 next도 null.)
        //
        // new Node(y, this.adjList[x])
        // : id가 y이고 next는 Head Node를 가리킴.
        //
        // 이 노드를 this.adjList[x]에 할당함으로써, 이제 이 노드가 Head Node가 됨.
        // 맨 첫번째에 새로운 노드를 삽입하는 로직과 동일함.
        //
        // 무방향(양방향) 간선이므로, 반대쪽 방향으로도 똑같이 수행해줌.
    }

    // * 방향 그래프
    public void addDirectedEdge(int x, int y){
        this.adjList[x] = new Node(y, this.adjList[x]);
    }


    // # 간선을 삭제하는 메서드
    // * 무방향 그래프
    public void deleteEdge(){

    }

    // * 방향 그래프
    public void deleteDirectedEdge(){

    }


    // # 전체 그래프를 출력하는 메서드
    public void printAdjacentList(){
        for (int i = 0; i < this.elemCnt; i++){
            System.out.print(this.vertexes[i] + ": ");

            Node cur = this.adjList[i];
            // cur 노드의 초기값은 해당 인덱스의 Head Node

            while(cur != null){
                // 맨 처음에 있던 노드,
                // 즉 id도 next도 null인 노드에 도착하기 전까지는 반복 수행

                System.out.print(this.vertexes[cur.id] + " ");
                // cur 노드의 id값을 인덱스 삼아 배열 vertexes로부터 정점 추출
                cur = cur.next;
                // 링크를 통해 다음 노드에 도착
            }
            System.out.println();
        }
    }
}




public class _4_1_Graph {
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

        System.out.println("\n### 인접리스트로 구현한 그래프");
        GraphList graph2 = new GraphList(4);

        graph2.addVertex('A');
        graph2.addVertex('B');
        graph2.addVertex('C');
        graph2.addVertex('D');

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(2, 3);
        graph2.printAdjacentList();
    }
}
