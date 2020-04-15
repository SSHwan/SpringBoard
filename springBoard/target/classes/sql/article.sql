create table article(
articleId INT AUTO_INCREMENT PRIMARY KEY,
userId VARCHAR(20) NOT NULL,
userName VARCHAR(20) NOT NULL,
articleTitle VARCHAR(100),
articleContent VARCHAR(3000),
articleDate DATETIME DEFAULT NOW(),
access INT DEFAULT 0,
articleHit INT DEFAULT 0,
articleGroup INT,
articleStep INT,
articleIndent INT
);
--auto increment 초기화
alter table article auto_increment=1;

--게시글 500개 만드는 프로시져
DELIMITER $$
DROP procedure if exists whileProc$$
Create procedure whileProc()
begin
declare userId varchar(20);
declare userName varchar(20);
declare articleTitle varchar(100);
declare articleContent varchar(3000);
declare i int;
set i = 1;
while(i<=500) DO
	set userId = 'user00',
	userName = '송승환',
    articleTitle = concat(i,'번 글 제목.'),
    articleContent = concat(i,'번 글 내용...');
    set i = i + 1;
    INSERT INTO article(userId, userName, articleTitle, articleContent, access, articleHit, articleGroup, articleStep, articleIndent) VALUES (userId, userName, articleTitle, articleContent, 0, 0,
		 IFNULL((SELECT MAX(articleId) + 1 from article a), 1), 0, 0);
	end while;
End $$
DELIMITER ;
call whileProc();