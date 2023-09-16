// [ 프리코딩테스트 2-5  5번문제 ]
// : binary min heap 자료구조인지 판별하는 메서드 작성

// 나의 답안은 작성하는데 너무 오래걸렸고 지나치게 복잡했다.
// 이렇게 푸는게 아닐것이다.
// 모범 답안을 복기함.

public class TreeExercise3 {

    public static String isHeap(int[] arr){
        boolean answer = true;
        int len = arr.length;

        for(int i = 1; i < len; i++){
            if( i*2 < len && arr[i*2] < arr[i]){
                answer = false;
                break;
            }
            if ( i*2+1 < len && arr[i*2+1] < arr[i]){
                answer = false;
                break;
            }
        }

        return answer ? "YES" : "NO";
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 9, 4, 7, 11, 13, 7, 4, 12, 10, 12};
        System.out.println(isHeap(arr));

    }
}
