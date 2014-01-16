drop table if exists USER;

	/*==============================================================*/
	/* Table: USER                                                  */
	/*==============================================================*/
	create table USER
	(
	ID                   varchar(32) not null,
	USER_NAME            varchar(20) comment '用户名',
	LOGIN_NAME           varchar(20) comment '登陆名',
	PASS_WORD            varchar(32) comment '登陆密码',
	AGE                  int comment '年龄',
	primary key (ID)
	);
	
	alter table USER comment '用户表';