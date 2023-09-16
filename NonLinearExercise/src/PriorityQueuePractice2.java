// Practice2
// 돌의 무게 데이터로 이루어진 정수형 stones 배열이 주어졌을 때 다음의 내용에 따라 프로그램을 작성하세요.
// 해당 배열로부터 가장 무게가 많이 나가는 돌 두개를 꺼내세요.
// 두 개의 돌을 충돌시키는데, 무게가 같으면 둘다 소멸,
// 무게가 다르면 남은 무게만큼의 돌은 다시 추가합니다.
// (7과 8이 충돌하면, 7과 8 대신에 두 돌의 무게 차이 1만큼 무게가 나가는 돌을 다시 추가한다.)
// 이 과정을 반복하며 가장 마지막의 돌의 무게를 출력하세요.
// 유희왕 코테 문제와 완전히 똑같은 문제다.

// 입출력 예시
// 입력: 2, 7, 4, 1, 8, 1
// 출력: 1

// 입력: 5, 3, 5, 3, 4
// 출력: 2

// # 키워드
// "가장 ~~한 것" 또는 "n번째로 ~~한 것" 등, 우선순위를 판가름 할 수 있는 기준이 존재.


public class PriorityQueuePractice2 {
    public static void solution(int[] stones) {

    }

    public static void main(String[] args) {
        // Test code
        int[] stones = {2, 7, 4, 1, 8, 1};
        solution(stones);

        stones = new int[]{5, 3, 5, 3, 4};
        solution(stones);
    }
}
