CREATE TABLE reply (
	reply_id INT AUTO_INCREMENT PRIMARY KEY,
	article_id INT NOT NULL DEFAULT 0,
	reply_content VARCHAR(1000) NOT NULL,
	user_id VARCHAR(20) NOT NULL,
	user_name VARCHAR(20) NOT NULL,
	reg_date TIMESTAMP NOT NULL DEFAULT NOW(),
	update_date TIMESTAMP NULL
);

ALTER TABLE reply AUTO_INCREMENT=1;

// 게시글이 삭제되면 댓글들도 삭제시키는 외래키 설정
ALTER TABLE reply ADD CONSTRAINT fk_article_reply
	FOREIGN KEY (article_id) REFERENCES article (articleId) ON DELETE CASCADE;
	
	--댓글 200개 만드는 프로시져
DELIMITER $$
DROP procedure if exists whileReplyProc$$
Create procedure whileReplyProc()
begin
declare reply_content varchar(1000);
declare user_id varchar(20);
declare user_name varchar(20);
declare article_id INT;
declare i int;
set i = 1;
while(i<=200) DO
	set user_id = 'user00',
	user_name = '송승환',
    reply_content = concat(i,'번 댓글입니다..'),
    article_id = 500;
    set i = i + 1;
    INSERT INTO reply (article_id, reply_content, user_id, user_name)
		VALUES (article_id, reply_content, user_id, user_name);
	end while;
End $$
DELIMITER ;
call whileReplyProc();