DELETE FROM bugs_user;

INSERT INTO bugs_user
(username, email, password, created_at, updated_at)
VALUES
('test_username1','test_email1','test_password1',now(),now());
