# BaseBall 프로그램

### DB 글자가 깨질경우 
alter table 테이블명 convert to character set utf8;
를 넣어준다.
### 테이블 생성
```sql
create table stadium(
    id int primary KEY auto_increment,
    name varchar(20),
    created_at TIMESTAMP
);
create table team(
    id int primary KEY auto_increment,
    name varchar(20),
    stadium_id INT,
    created_at TIMESTAMP
);
create table player(
    id int primary KEY auto_increment,
    name varchar(20),
    position varchar(20),
    team_id INT,
    is_outer BOOLEAN,
    created_at TIMESTAMP
);

```

### 더미데이터 추가
```sql

INSERT INTO stadium(NAME, created_at) VALUES('사직야구장',NOW());
INSERT INTO stadium(NAME, created_at) VALUES('잠실야구장',NOW());
INSERT INTO stadium(NAME, created_at) VALUES('고척야구장',NOW());

INSERT INTO team(NAME, stadium_id, created_at) VALUES('롯데','1',NOW());
INSERT INTO team(NAME, stadium_id, created_at) VALUES('두산','2',NOW());
INSERT INTO team(NAME, stadium_id, created_at) VALUES('키움','3',NOW());

INSERT INTO player(NAME,POSITION, team_id, is_outer, created_at) VALUES('이대호','1루수',1,0,NOW());
INSERT INTO player(NAME,POSITION, team_id, is_outer, created_at) VALUES('홍길동','외야수',2,0,NOW());
INSERT INTO player(NAME,POSITION, team_id, is_outer, created_at) VALUES('장보고','내야수',3,0,NOW());
COMMIT;
```