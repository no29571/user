--ログインテスト用ユーザ（パスワードはtest）
--insertしたユーザでログインエラーになる（暗号文が異なる）場合は
--プログラムから作成する（SecurityConfigの調整要）
insert into local_user
(name, email, password)
select 'テスト用', 'test@example.com'
, '$2a$10$JOAJlyjjJ3UhT1e5wFkj0uMMRKe1rNik2K1eDDL5Kf.kGAX6kVxWm'
where not exists (select * from local_user);
