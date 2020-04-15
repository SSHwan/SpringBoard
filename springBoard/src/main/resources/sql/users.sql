CREATE TABLE users (
	user_id VARCHAR(20) PRIMARY KEY,
	user_pw VARCHAR(100) NOT NULL,
	user_name VARCHAR(20) NOT NULL,
	user_email VARCHAR(50),
	user_point INT NOT NULL DEFAULT 0,
	user_img VARCHAR(100) NULL,
	user_join_date TIMESTAMP NOT NULL DEFAULT NOW(),
	user_login_date TIMESTAMP NULL,
	user_enabled BOOLEAN NOT NULL DEFAULT TRUE
);