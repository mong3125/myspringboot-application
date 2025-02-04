# MySpringBoot Todo Application

이 프로젝트는 **Spring**의 동작 원리와 프로세스를 이해하기 위해, Spring과 유사하게 구현한 경량 웹 프레임워크 **myspringboot**를 활용하여 개발된 Todo 관리 애플리케이션입니다.

## 개요

이 애플리케이션은 Todo 항목의 생성, 조회, 수정, 완료 처리 및 삭제 기능을 제공합니다.  

## 주요 기능

- **Todo 단일 조회**: `/todo/id/{id}` 엔드포인트를 통해 특정 Todo 항목을 조회합니다.
- **Todo 전체 조회**: `/todo` 엔드포인트를 통해 모든 Todo 항목을 조회합니다.
- **Todo 생성**: `POST /todo` 요청으로 새 Todo 항목을 생성합니다.
- **Todo 수정**: `PUT /todo/id/{id}` 요청으로 기존 Todo 항목의 내용을 업데이트합니다.
- **Todo 완료 처리**: `PATCH /todo/done/id/{id}` 요청으로 Todo와 관련 SubTodo들을 완료 상태로 변경합니다.
- **Todo 삭제**: `DELETE /todo?id={id}` 요청을 통해 특정 Todo 항목을 삭제합니다.

## 프로젝트 구조

```
MySpringBootTodoApplication/
├── src/
│   ├── main/
│      ├── java/
│         └── com.example/
│             ├── MySpringBootApplication.java      // 애플리케이션 진입점
│             ├── controller/
│             │   └── TodoController.java           // REST API 엔드포인트
│             ├── dto/
│             │   ├── TodoRequest.java              // TODO 요청 데이터 객체
│             │   └── TodoResponse.java             // TODO 응답 데이터 객체
│             │   └── SubTodoRequest.java           // SubTodo 요청 데이터 객체
│             │   └── SubTodoResponse.java          // SubTodo 응답 데이터 객체
│             ├── exception/
│             │   └── TodoNotFoundException.java    // 예외 처리 클래스
│             ├── mapper/
│             │   └── TodoMapper.java               // 엔티티와 DTO 간 변환
│             ├── model/
│             │   ├── Todo.java                     // Todo 엔티티
│             │   └── SubTodo.java                  // SubTodo 엔티티
│             ├── repository/
│             │   └── TodoRepository.java           // in-memory 데이터 저장소
│             └── service/
│                 └── TodoService.java              // 비즈니스 로직 처리
│
└── build.gradle                                      // Gradle 빌드 파일
└── myspringboot-1.0-SNAPSHOT-all.jar                 // myspringboot jar 파일
```

## 사용 기술

- **Java**: 애플리케이션 로직 구현
- **myspringboot**: 경량 웹 프레임워크 (Spring과 유사한 구조 및 기능 제공)
  - https://github.com/mong3125/myspringboot
- **Gradle**: 빌드 및 의존성 관리

## 실행 방법

### 1. 프로젝트 클론

```bash
git clone https://github.com/mong3125/myspringboot-application
cd MySpringBootApplication
```

### 2. ShadowJar 생성 및 실행

ShadowJar 플러그인을 사용하여 단일 실행 가능한 JAR 파일을 생성한 후 실행합니다.
```bash
./gradlew shadowJar
java -jar build/libs/MySpringBootApplication-1.0-SNAPSHOT-all.jar
```
## API 엔드포인트

| HTTP 메서드 | URL                              | 설명                             |
|-------------|----------------------------------|----------------------------------|
| GET         | `/todo/id/{id}`                  | ID에 해당하는 Todo 항목 조회    |
| PATCH       | `/todo/id/{id}/done`             | Todo 및 관련 SubTodo 완료 처리   |
| GET         | `/todo`                          | 전체 Todo 항목 리스트 조회       |
| POST        | `/todo`                          | 새 Todo 항목 생성                |
| PUT         | `/todo/id/{id}`                  | 기존 Todo 항목 업데이트          |
| DELETE      | `/todo?id={id}`                  | Todo 항목 삭제                  |


