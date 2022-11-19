3단계 자동차 경주
===

## 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## 구현 기능 목록
### 자동차 경주 구현
* [x] 자동차 경주를 진행하고 결과를 반환하는 자동차 객체 설계
  * [x] 자동차 객체 속성 설계
    * id : 경주에 참여하는 자동차의 식별자
    * distance : 각 라운드 진행에 따른 누적 주행거리
  * [x] 자동차 객체 기능 구현 : 주어진 숫자에 따라 주행거리 누적 판별
  * [x] 주어진 숫자에 따라 차량의 주행거리 누적 여부 검증 TC 작성
  * [x] 단일 차량의 여러 라운드 진행 및 결과 검증 TC 작성
* [x] 게임에 참여하는 자동차 목록을 표현하는 일급 컬렉션 설계
  * 난수 주입 관여로 인해 테스트 하기 어려운 부분 제외
    * [-] 여러 차량으로 단일 라운드 진행 TC 작성
    * [-] 여러 차량으로 주어진 횟수만큼 라운드 진행 TC 작성

### 입/출력 구현
* [x] 제한된 범위의 난수 발생기 구현
* [x] 자동차 경주 시도 횟수와 경주에 참여할 자동차 수 입력 부
* [x] 자동차 경주 완료 후 결과 출력 부
* [x] 유효하지 못한 값을 입력하는 경우, 값 입력 재시도 처리

## 구현 참고 사항
* [x] 비지니스 로직과 입/출력 로직을 분리
* [x] `kotlin.io`의 `readLine()`을 이용한 값 입력 처리

## 코드 리뷰 피드백 내용 정리
* [x] 역할이 명확하지 않은 Cars 객체에 자동차 경주에 참여하는 자동차 목록을 생성하는 책임 부여
* [x] 가변 타입으로 선언된 필드 반환 시, 외부에서의 변경을 제한하기 위해 불변 객체로 반환 처리 
* [x] TC 추가
  * 자동차가 움직이는 경우
  * 자동차가 움직이지 않는 경우
* [x] 경기 진행 구현 방식 변경
  * AS-IS : 각 자동차의 라운드 결과를 별도의 응답 객체에 누적 후 경기 결과를 출력
  * TO-BE : 각 자동차에 거리를 표현하는 필드에 진행 정도를 누적 후 경기 결과를 출력 
* [x] 각 자동차가 경주 진행 후 별도의 응답객체를 반환하지 않고, 자동차 객체에 누적된 상태값을 이용하여 진행 정도를 표현
  - AS-IS : `Car`객체의 각 라운드 결과 목록을 저장하는 `RoundResults`객체를 이용하여 경기 결과를 표현
  - TO-BE : `Car`객체의 누적된 진행거리를 저장하는 distance 필드를 이용하여 경기 결과를 표현
* [x] repeat()를 이용하여 for문으로 작성된 반복문의 가독성 개선
* [x] Service에서 일부 객체 생성하는 책임을 Controller로 분리