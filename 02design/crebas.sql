/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/26 15:12:31                           */
/*==============================================================*/


drop table if exists summon_info;

/*==============================================================*/
/* Table: summon_info                                           */
/*==============================================================*/
create table summon_info
(
   id                   int not null auto_increment comment '传票ID',
   case_date            datetime not null comment '案件日期',
   excute_company       varchar(128) not null comment '执行单位',
   case_number          varchar(64) not null comment '案件号',
   case_reason          varchar(200) comment '案由',
   name                 varchar(64) not null comment '被传唤人',
   address              varchar(200) comment '工作单位或地址',
   discuss_reason       varchar(200) comment '传唤事由',
   set_time             datetime not null comment '应到时间',
   set_place            varchar(200) not null comment '应到住所',
   judge                varchar(64) not null comment '审判员',
   clerk                varchar(64) not null comment '书记员',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table summon_info comment '传票信息表';

