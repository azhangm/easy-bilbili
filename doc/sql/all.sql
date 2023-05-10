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