drop table if exists `chapter`;
create table `chapter` (
    `id` int comment 'ID',
    `course_id` int comment '课程ID',
    `name` varchar(50) comment '名称',
    primary key (`id`)
)engine = innodb charset = utf8mb4 comment = '大章';