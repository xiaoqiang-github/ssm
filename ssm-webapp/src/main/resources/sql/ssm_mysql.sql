/**********问卷调查****************/
create table ssm_survey(
	survey_id VARCHAR(32) not null,
	survey_name VARCHAR(50),
	memo varchar(1024),
	start_time date,
	end_time date,
	creator VARCHAR(32),
	create_time timestamp,
	modify_time timestamp,
	primary key (survey_id)
);

/**********题目****************/
create table ssm_optic(
	optic_id VARCHAR(32) not null,
	survey_id VARCHAR(32) not null,
	optic_name VARCHAR(50),
	optic_index INT,
	optic_weight decimal(3),
	score decimal(3),
	PRIMARY key (optic_id)
);

/**********题目选项****************/
create table ssm_option(
	option_id VARCHAR(32) not null,
	optic_id VARCHAR(32) not null,
	option_name varchar(50) not null,
	option_index int,
	option_weight decimal(2,1),
	primary key(option_id)
);

/**********用户****************/
CREATE TABLE ssm_user (
  user_id varchar(32) NOT NULL,
  user_name varchar(50) DEFAULT NULL,
  nick_name varchar(50) DEFAULT NULL,
  password varchar(32) DEFAULT NULL,
  address varchar(100) DEFAULT NULL,
  birthday date DEFAULT NULL,
  sex char(1) DEFAULT NULL,
  dept_id varchar(32) DEFAULT NULL,
  PRIMARY KEY (user_id)
);
insert into ssm_user
values('2b','xiaoming2','xiaoming2','111111','tian tong yuan ','2014-09-17',1,1);
insert into ssm_user
values('3c','xiaoming3','xiaoming3','111111','tian tong yuan ','2014-09-17',1,1);
insert into ssm_user
values('4d','xiaoming4','xiaoming4','111111','tian tong yuan ','2014-09-17',1,1);

/**********部门****************/
CREATE TABLE ssm_dept (
  dept_id varchar(32) NOT NULL,
  dept_name varchar(50) DEFAULT NULL,
  parent_id varchar(32) DEFAULT NULL,
  PRIMARY KEY (dept_id)
);



/********** INIT START ***********/
insert into ssm_survey(survey_id,survey_name,memo,start_time,end_time,creator,create_time)
values('111','大众饮食安全问题','您的饮食卫生吗？','2015-07-01','2015-07-31','admin','2015-07-01 13:11:12');

insert into ssm_optic(optic_id,survey_id,optic_name,optic_index,optic_weight,score)
values('222','111','您平时是自己做饭吗？',1,40,30);
insert into ssm_optic(optic_id,survey_id,optic_name,optic_index,optic_weight,score)
values('333','111','您会吃路边的小吃吗？',2,30,20);

insert into ssm_option(option_id,optic_id,option_name,option_index,option_weight)
value('444','222','做',1,0.7);
insert into ssm_option(option_id,optic_id,option_name,option_index,option_weight)
value('555','222','不做',2,0.3);
insert into ssm_option(option_id,optic_id,option_name,option_index,option_weight)
value('666','333','会',1,0.4);
insert into ssm_option(option_id,optic_id,option_name,option_index,option_weight)
value('777','333','不会',1,0.6);
/********** INIT END ***********/


