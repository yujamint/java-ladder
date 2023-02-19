# java-ladder

사다리 타기 미션 저장소

## 기능 목록

### 입력
- [x] 참여한 사람 이름 입력
  - [x] 최대 5자
  - [x] ','로 구분하여 입력
- [x] 사다리 높이 입력
    - [x] 1 이상

### 출력
- [x] 실행결과
  - [x] 사람 이름이 5자 미만이어도 출력 형식에 맞춰 공백 출력
  - [x] 첫 번째 사다리의 경우, 첫 번째로 입력한 사용자 이름의 길이에 맞게 공백 출력

### 게임
- [x] 선 생성
  - [x] 난수를 통해 판단
  - [x] 라인 생성
    - [x] 사다리 높이만큼 생성
    - [x] True를 연속으로 가질 수 없다.


## 테스트
- [x] domain
   - [x] User
     - [x] 이름은 5자 이하이다.
     - [x] 이름은 1자 이상이다.
     - [x] 이름은 공백이 포함될 수 없다.
     - [x] 이름은 빈 문자열일 수 없다.
   - [x] Ladder
     - [x] 선이 연속될 수 없다.
     - [x] 사다리의 높이는 1 이상이어야 한다.

### 리팩터링
- [x] enum 사용
- [x] 메소드 분리
- [x] 원시 값, 문자열 포장
- [x] indent 1
- [x] 메소드 10 라인 이내로 작성
---
**1단계 리뷰에 따른 리팩터링**
- [x] 불필요한 Wrapping Class 제거
- [x] public으로 선언되어 있지만, 외부에서 사용하지 않는 메소드 접근제어자 private으로 변경
- [x] `Name.validateNameLength()` 메소드 분리
- [x] 현재 상수 final로 선언 -> static final로 수정
- [x] `@ParameterizedTest` 활용한 테스트 작성
- [x] 잘못된 입력 받으면 종료하지 않고, 올바른 값을 입력할 때까지 재입력

### 추후 고려사항
- 참가자
  - 이름
    - 공백 금지
    - 빈 문자열 금지
    
## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
