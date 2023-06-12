# kotlin-spring-batch
코프링 및 스케줄링을 통한 스프링 배치 (공부용)

## Batch
서버 작동 시작 3초 후부터 5초 간격으로 Job 수행하도록 스케줄링을 설정했다
- Job은 아래 세 요소를 가진 하나의 Step으로 구성
  - itemReader -> Post 엔티티를 하나 생성/DB삽입 후 전체 조회
  - itemProcessor -> Post 마다의 content의 끝에 !를 String으로 하나씩 추가
  - itemWriter ->  Processor에서의 변경사항을 저장 (Dirty Checking 사용하지 않음)

## 결과
<img width="300" alt="image" src="https://github.com/ohksj77/kotlin-spring-batch/assets/89020004/35bef7fd-ca74-4d7c-8d9d-689b7ff98f3d">
<img width="300" alt="image" src="https://github.com/ohksj77/kotlin-spring-batch/assets/89020004/7f6e7c59-f6a0-4964-ae81-71e8c50b5a72">
