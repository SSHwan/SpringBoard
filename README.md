## 안녕하세요
Spring Framework으로 회원가입, 로그인, 답글 게시판, 댓글 기능 등을 제작했습니다.

회원가입(유효성검사, 아이디 중복 체크, 비밀번호 Bcrypt로 암호화)

로그인(interceptor), 로그아웃 (게시판은 로그인을 해야 접근 가능하도록 interceptor 처리)

계층형 게시판(답글, 댓글(ajax), page, 검색(제목or내용or작성자 검색, MyBatis 동적 SQL 활용))

---스크린샷---

### 홈화면
![홈화면](https://user-images.githubusercontent.com/46616930/80090616-c08ac880-859a-11ea-9e7e-7c750c09f640.png)
### 회원가입
![회원가입](https://user-images.githubusercontent.com/46616930/80094819-e23b7e00-85a1-11ea-8393-19537d9f0c0b.png)
### 로그인
![로그인](https://user-images.githubusercontent.com/46616930/80091184-a43b5b80-859b-11ea-9248-9fa2a9d7d64e.png)
### 게시판
![게시판](https://user-images.githubusercontent.com/46616930/80091189-a6051f00-859b-11ea-9b67-20da2882f78a.png)
### 게시글, 댓글
![게시글 댓글](https://user-images.githubusercontent.com/46616930/80091205-abfb0000-859b-11ea-9ab9-bdcf0715bdc7.png)

---version---

-java 8  
-JDK 1.8

-Spring 5.0.7  
-Maven 2.9

-MySQL 5.7  
-MyBatis 3.4  
-Tomcat 8.5  
-validation 2.0  
-bcrypt 0.3  
-json 2.9  

-JQuery 3  
-Bootstrap 4

--- ---

gksl4157@naver.com
