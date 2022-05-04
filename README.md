
## Blog V2 - Ajax를 이용한 비동기적 서버 구현 (async - fetch)

### 구현 기능
#### 1. 회원가입, 로그인, remember me, 로그아웃
- 쿠키값 체크 
- 세션에 로그인정보 저장
#### 2. 회원정보 수정
- Ajax를 이용한 비동기 처리
- 트랜잭션 이용
#### 3. 글 쓰기
- 섬머노트 에디터 사용
#### 4. 글 삭제
- 권한처리 완료
#### 5. 글 목록보기
- 페이징 및 DESC 정렬
#### 6. 글 상세보기
#### 7. 댓글 작성, 삭제
#### 8. 글로벌 Exception 처리하여 StackTrace 노출 방지
#### 9. 필터 설정을 통해 모든 권한처리 완료
<br>

### Github 주소
[https://github.com/coehoan/springboot-green-blog-v2](https://github.com/coehoan/springboot-green-blog-v2)

### 블로그 주소
[https://blog.naver.com/coehoan/222712550449](https://blog.naver.com/coehoan/222712550449)
<br>


## 페이지 구성

<details>
<summary>더보기</summary>

### 기본화면
![image](https://user-images.githubusercontent.com/97711652/166662166-cc05a40c-c4ef-41e2-9a9c-432fe62f9cab.png)

### 회원가입 페이지
![image](https://user-images.githubusercontent.com/97711652/166662246-4436ae30-d2d3-4d2c-ade2-67100424d759.png)

### 로그인 후
![image](https://user-images.githubusercontent.com/97711652/166662361-9dcf90da-65f7-4761-aded-1e2a7b9d000f.png)

### 회원정보 페이지
![image](https://user-images.githubusercontent.com/97711652/166662422-7fb6bcdc-452d-43d9-ac2c-c423ccfcfa52.png)

### 회원정보 수정 후
![image](https://user-images.githubusercontent.com/97711652/166662500-e7a908a5-c6b9-40b7-b500-e819071805b8.png)

### 글쓰기 페이지
![image](https://user-images.githubusercontent.com/97711652/166662601-3dff2eba-181a-4989-a9a6-a48e2449c228.png)

### 글 목록 페이징(최신순)
![image](https://user-images.githubusercontent.com/97711652/166662687-aa22fc86-03d6-408f-b1d9-476e75ddd824.png)

### 글 상세보기(권한체크 후 수정, 삭제버튼 제공)
![image](https://user-images.githubusercontent.com/97711652/166662778-500e6e9d-fdba-4c79-adab-f81296b6b832.png)
![image](https://user-images.githubusercontent.com/97711652/166662746-b08783d1-e232-4c4e-bd09-62cafdcade62.png)


### 글 삭제
![image](https://user-images.githubusercontent.com/97711652/166662880-b33246c4-091c-4223-99a4-0dcfbc32147e.png)

### 댓글 작성
![image](https://user-images.githubusercontent.com/97711652/166662937-24596cd3-2abf-43f0-9e8c-5f2e3d32a7d8.png)

### 댓글삭제 (권한처리) 
![image](https://user-images.githubusercontent.com/97711652/166662982-11f5bbae-6fef-411e-89c5-10db6098bd68.png)
![image](https://user-images.githubusercontent.com/97711652/166663027-2b8a5104-9ce5-424b-ba86-45e34e0f014b.png)
</details>

## 참고사항

### DB 및 사용자 생성

```sql

CREATE user 'green'@'%' IDENTIFIED BY  'green1234';

CREATE  DATABASE greendb;

GRANT ALL PRIVILEGES ON greendb.* TO  'green'@'%';

```

### 사용 기술
- Java
- SpringBoot
- MariaDB
- JavaScript

 ### 사용 라이브러리
 - JPA
 - Spring-Web
 - Devtools
 - JDBC
 - Lombok
 - JQuery
 - Bootstrap5
 - Summernote