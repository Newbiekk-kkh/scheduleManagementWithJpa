# 일정관리 앱
바쁜 현대사회에서 자신의 일정을 체계적으로 관리해보자 !
회원가입을 하고 로그인을 하면 일정관리와 댓글을 달 수 있다!


# 주요기능
- ### 일정관리
  
  - 일정 등록
  - 일정 조회
  - 일정 수정
  - 일정 삭제

- ### 회원가입 및 로그인

  - 회원 등록
  - 회원 조회
  - 회원 삭제

- ### 댓글 기능

  - 댓글 등록
  - 댓글 조회
  - 댓글 수정
  - 댓글 삭제


# 사용언어 
- Java 17
- SpringBoot 3.3.5
- JPA
- MySql 8.0

# API 명세서
<details>
<summary> 일정 API </summary>

| 기능 | Method | **URL** | **request** | **response** | **상태코드** |
| --- | --- | --- | --- | --- | --- |
| 일정 등록 | POST | /api/schedules  | 요청 body | 등록 정보 | 200 OK, 400 비정상 값 |
| 전체 일정 조회 | GET | /api/schedules |  | 다건 응답 정보 | 200 OK |
| 선택 일정 조회 | GET | /api/schedules/{schedules_id} | 요청 param(id) | 단건 응답 정보 | 200 OK, 404 선택한 일정이 사라짐 |
| 일정 수정 | PATCH | /api/schedules/{schedules_id}  | 요청 param(id), 요청 body | 수정 정보 | 200 OK, 400 비정상 값, 403 비밀번호 틀림 |
| 일정 삭제 | DELETE | /api/schedules/{schedules_id}  | 요청 param(id) | 삭제 정보 | 200 OK, 403 비밀번호 틀림, 404 선택한 일정이 사라짐 |

1. 일정등록
  - 요청(request) : POST /api/schedules
  ```
{
	"userName" : "박영배",
	"title" : "제목",
	"content" : "내용"
}
  ```
  - 응답(response)
```
{
  "schedule_id" : "1",
  "title" : "제목",
  "contents" : "내용"
}
```
2. 전체 일정 조회
- 요청(request) : GET /api/schedules
- 응답(response)
```
{
  "schedules" :[ {
    "schedule_id": "1",
    "userName" : "박영배"
    "title" : "제목",
    "content" : "내용"
}, {
        "schedule_id": "2",
        "userName" : "고강혁"
        "title" : "제목",
        "content" : "내용"
    },
]
}
```
3. 선택 일정 조회
- 요청(request) : GET /api/schedules/{schedule_id}
- 응답(response)
```
{
    "schedule_id": "1",
    "title" : "일정1",
    "content" : "공부",
}
```
4. 일정 수정
- 요청(request) : PATCH /api/schedules/{schedule_id}
```
{
    "title" : "수정된 제목",
    "content" : "수정된 내용"
}
```
- 응답(response)
```
{
  "schedule_id": "2",
  "title": "수정된 제목",
  "contents": "수정된 내용"
}
```
5. 일정 삭제
- 요청(request) : DELETE /api/schedules/{schedule_id}
- 응답(response) : 200 OK

</details>

<details>
<summary> 유저 API </summary>

| 기능 | Method | **URL** | **request** | **response** | **상태코드** |
| --- | --- | --- | --- | --- | --- |
| 유저 등록 | POST | /api/users  | 요청 body | 등록 정보 | 200 OK, 400 비정상 값 |
| 전체 유저 조회 | GET | /api/users |  | 다건 응답 정보 | 200 OK |
| 선택 유저 조회 | GET | /api/users/{user_id} | 요청 param(id) | 단건 응답 정보 | 200 OK, 404 선택한 유저가 사라짐 |
| 유저 삭제 | DELETE | /api/users/{user_id}  | 요청 param(id) | 삭제 정보 | 200 OK, 404 선택한 유저가 사라짐 |

1. 유저 등록
  - 요청(request) : POST /api/users
  ```
{
    "username" : "김창배",
    "password" : "123123",
    "email" : "ABCD@gmail.com"
}
  ```
  - 응답(response)
```
{
  "user_id" : "1",
  "username" : "김창배",
  "email" : "ABCD@gmail.com"
}
```
2. 전체 일정 조회
- 요청(request) : GET /api/users
- 응답(response)
```
[
    {
        "user_id": 1,
        "username": "김창배",
        "email": "ABCD@gmail.com"
    }, {
	"user_id": 2,
        "username": "박영배",
        "email": "ABCDE@gmail.com"
    }
]
```
3. 선택 일정 조회
- 요청(request) : GET /api/users/{user_id}
- 응답(response)
```
{
    "user_id": 1,
    "username": "김창배",
    "email": "ABCD@gmail.com"
}
```
4. 일정 삭제
- 요청(request) : DELETE /api/users/{user_id}
- 응답(response) : 200 OK

</details>

<details>
<summary> 댓글 API </summary>

| 기능 | Method | **URL** | **request** | **response** | **상태코드** |
| --- | --- | --- | --- | --- | --- |
| 댓글 등록 | POST | /api/comments  | 요청 body | 등록 정보 | 200 OK, 400 비정상 값 |
| 전체 댓글 조회 | GET | /api/comments |  | 다건 응답 정보 | 200 OK |
| 선택 댓글 조회 | GET | /api/comments/{comment_id} | 요청 param(id) | 단건 응답 정보 | 200 OK, 404 선택한 댓글이 사라짐 |
| 댓글 수정 | PATCH | /api/comments/{comment_id}  | 요청 param(id), 요청 body | 수정 정보 | 200 OK, 400 비정상 값 |
| 댓글 삭제 | DELETE | /api/comments/{comments_id}  | 요청 param(id) | 삭제 정보 | 200 OK, 404 선택한 댓글이 사라짐 |

1. 유저 등록
  - 요청(request) : POST /api/comments
  ```
{
    "schedule_id" : 1,
    "commentText" : "와! 대단해요!"
}
  ```
  - 응답(response)
```
{
  "comment_id" : "1",
  "commentText" : "와! 대단해요!"
}
```
2. 전체 일정 조회
- 요청(request) : GET /api/comments
- 응답(response)
```
[
    {
 	 "comment_id" : "1",
 	 "commentText" : "와! 대단해요!"
    }, {
	"comment_id" : "2",
        "commentText" : "와! 대단해요!"
    }
]
```
3. 선택 일정 조회
- 요청(request) : GET /api/comments/{comment_id}
- 응답(response)
```
{
  "comment_id" : "1",
  "commentText" : "와! 대단해요!"
}
```
4. 일정 수정
- 요청(request) : PATCH /api/comments/{comment_id}
```
{
    "commentText" : "수정된 댓글!"
}
```
- 응답(response)
```
{
    "comment_id" : "1"
    "commentText" : "수정된 댓글!"
}
```
5. 일정 삭제
- 요청(request) : DELETE /api/comments/{comment_id}
- 응답(response) : 200 OK

</details>




# ERD


![image](https://github.com/user-attachments/assets/2afd441e-87d7-44e4-8671-80867ef63d70)




# SQL


```
create table user
(
    created_at  datetime(6)  null,
    id          bigint       auto_increment primary key,
    modified_at datetime(6)  null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    username    varchar(255) not null,
    constraint UKob8kqyqqgmefl0aco34akdtpe
        unique (email)
);

create table schedule
(
    created_at  datetime(6)  null,
    id          bigint       auto_increment primary key,
    modified_at datetime(6)  null,
    user_id     bigint       null,
    contents    longtext     null,
    title       varchar(255) not null,
    constraint FKa50n59y1j4a6qwa42p8jiguds
        foreign key (user_id) references user (id)
);

create table comment
(
    created_at   datetime(6)    null,
    id           bigint         auto_increment primary key,
    modified_at  datetime(6)    null,
    schedule_id  bigint         null,
    user_id      bigint         null,
    comment_text varchar(255)   not null,
    constraint FK8kcum44fvpupyw6f5baccx25c
        foreign key (user_id)   references user (id),
    constraint FKsy51iks4dgapu66gfj3mnykch
        foreign key (schedule_id) references schedule (id)
);


```
