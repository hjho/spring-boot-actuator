## Spring Boot Actuator 파헤치기
- 일자: 2026년 2월 7일-8일
- 강의: 18개, 5시간 30분, 초급
- 인프런, Hello World
- 주소: https://www.inflearn.com/course/spring-boot-actuator-%ED%8C%8C%ED%97%A4%EC%B9%98%EA%B8%B0

## Spring Boot Actuator란.
- Spring Boot Actuator는 애플리케이션의 상태 모니터링, 메트릭 수집, 트래픽 추적 등 운영(Production) 환경에 필요한 기능을 제공하는 관리 도구입니다.
- HTTP 엔드포인트나 JMX를 통해 JVM 메모리, CPU 사용량, 로그백 이벤트, DB 연결 상태 등의 정보를 JSON 형식으로 손쉽게 확인하여 애플리케이션의 동작을 제어하고 분석할 수 있게 합니다.
- 주로 Prometheus, Grafana, Spring Boot Admin 등과 연동하여 시각화된 모니터링 환경을 구축하는 데 필수적으로 사용됩니다.
- 핵심 특징 및 기능:
  - 간편한 모니터링: 별도 코드 구현 없이 의존성 추가만으로 다양한 운영 지표 제공.
  - 엔드포인트(Endpoint) 제공: http://localhost:8080/actuator를 통해 헬스 체크(health), 메트릭(metrics), 빈 목록(beans) 등 데이터 접근.
  - 상태 정보: jvm.memory.used(메모리 사용량), system.cpu.count(CPU 개수), http.server.requests(요청 처리) 등의 지표 수집.
  - 운영 최적화: 시스템의 건강 상태를 진단하여 안정적인 서비스 운영 지원.
  - 주요 활용 엔드포인트:
    - /health: 애플리케이션의 상태(Up/Down)를 확인.
    - /metrics: 애플리케이션의 메트릭 데이터(메모리, CPU 등)를 보여줌.
    - /loggers: 로그 레벨을 조회하거나 운영 중에 변경 가능.
