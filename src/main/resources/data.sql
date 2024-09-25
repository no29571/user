--ログインテスト用ユーザ（パスワードはtest）
insert into local_user
(name, email, password)
select 'テスト用', 'test@example.com'
, '$2a$10$JOAJlyjjJ3UhT1e5wFkj0uMMRKe1rNik2K1eDDL5Kf.kGAX6kVxWm'
where not exists (select * from local_user);
