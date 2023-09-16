// Practice4
// 문자열 s 가 주어졌을 때, 문자열 내에 동일한 알파벳이 연속적으로 배치되지 않도록 재배치 하세요.
// 재배치가 가능한 경우 재정렬한 문자열을 반환하고 불가능한 경우 null 을 반환하세요.

// 입출력 예시
// 입력: "aabb"
// 출력: "abab"

// 입력: "aaca"
// 출력: null


// # 문제 접근
// * 도대체 무엇을 우선순위 기준으로 삼아야하는가?
// : 빈도수
//
// * 가장 많은 빈도수 순으로 출력
// -> 우선순위 큐 갱신
// -> 그다음 빈도수 많은 것을 출력
// -> 우선순위 큐 갱신
// -> 반복...
//
// *

public class PriorityQueuePractice4 {
    public static String solution(String s) {




        return null;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("aabb"));
        System.out.println(solution("aaaaabccd"));
        System.out.println(solution("aaca"));
    }
}
