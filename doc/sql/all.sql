-- 课程大章表
drop table if exists `chapter`;
create table `chapter` (
    `id` bigint comment 'ID',
    `course_id` bigint comment '课程ID',
    `name` varchar(50) comment '名称',
    primary key (`id`)
)engine = innodb charset = utf8mb4 comment = '大章';

-- 课程小节表
drop table if exists `section`;
CREATE TABLE `section` (
    `id` bigint comment  'ID',
    `title` varchar (50) NOT NULL comment '标题',
    `course_id` bigint comment '课程ID|course_id',
    `chapter_id` bigint comment '大章ID|chapter_id',
    `video` varchar(200) comment '视频',
    `time` bigint comment '课程时长|秒',
    `charge` boolean comment '收费|true or false',
    `sort` int comment '顺序',
    `create_time` datetime not null comment '创建时间',
    `update_time` DATETIME not null comment '修改时间',
    primary key (`id`)
)engine = innodb charset = utf8mb4 comment = '小节';

-- 用户表
drop table if exists `user`;
create TABLE `user` (
    id  bigint comment '主键|id',
    username varchar(100) comment '用户名',
    phone varchar(11) comment '手机号',
    email varchar(100) comment '邮箱',
    password varchar(255) comment '用户密码',
    salt varchar(50) comment '盐值',
    `create_time` datetime not null comment '创建时间',
    `update_time` DATETIME not null comment '修改时间',
    primary key (`id`)
)engine = innodb charset = utf8mb4 comment = '用户账号信息';

-- 用户信息表
drop table if exists `user_info`;
create TABLE `user_info`(
    id bigint comment '主键|id',
    uerId bigint default null comment '用户id',
    nick varchar(100) comment '昵称',
    avatar varchar(255) comment '头像',
    sign text comment '签名',
    gender varchar(2) default null comment '性别:男 1 女 0 未知 2',
    `create_time` datetime not null comment '创建时间',
    `update_time` DATETIME not null comment '修改时间',
    primary key (`id`)
)engine = innodb charset = utf8mb4 comment = '用户账号信息';
