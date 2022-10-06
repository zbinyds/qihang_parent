/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 8.0.22 : Database - qihang
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qihang` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `qihang`;

/*Table structure for table `acl_permission` */

DROP TABLE IF EXISTS `acl_permission`;

CREATE TABLE `acl_permission` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '编号',
  `pid` char(19) NOT NULL DEFAULT '' COMMENT '所属上级',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型(1:菜单,2:按钮)',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限值',
  `path` varchar(100) DEFAULT NULL COMMENT '访问路径',
  `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '图标',
  `status` tinyint DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限';

/*Data for the table `acl_permission` */

insert  into `acl_permission`(`id`,`pid`,`name`,`type`,`permission_value`,`path`,`component`,`icon`,`status`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1','0','全部数据',0,NULL,NULL,NULL,NULL,NULL,0,'2019-11-15 17:13:06','2019-11-15 17:13:06'),
('1195268474480156673','1','权限管理',1,NULL,'/acl','Layout','example',NULL,0,'2019-11-15 17:13:06','2019-11-18 13:54:25'),
('1195268616021139457','1195268474480156673','用户管理',1,NULL,'user/list','/edu/acl/user/list',NULL,NULL,0,'2019-11-15 17:13:40','2019-11-18 13:53:12'),
('1195268788138598401','1195268474480156673','角色管理',1,NULL,'role/list','/edu/acl/role/list',NULL,NULL,0,'2019-11-15 17:14:21','2019-11-15 17:14:21'),
('1195268893830864898','1195268474480156673','菜单管理',1,NULL,'menu/list','/edu/acl/menu/list',NULL,NULL,0,'2019-11-15 17:14:46','2019-11-15 17:14:46'),
('1195269143060602882','1195268616021139457','查看',2,'user.list','','',NULL,NULL,0,'2019-11-15 17:15:45','2019-11-17 21:57:16'),
('1195269295926206466','1195268616021139457','添加',2,'user.add','user/add','/edu/acl/user/form',NULL,NULL,0,'2019-11-15 17:16:22','2019-11-15 17:16:22'),
('1195269473479483394','1195268616021139457','修改',2,'user.update','user/update/:id','/edu/acl/user/form',NULL,NULL,0,'2019-11-15 17:17:04','2019-11-15 17:17:04'),
('1195269547269873666','1195268616021139457','删除',2,'user.remove','','',NULL,NULL,0,'2019-11-15 17:17:22','2019-11-15 17:17:22'),
('1195269821262782465','1195268788138598401','修改',2,'role.update','role/update/:id','/edu/acl/role/form',NULL,NULL,0,'2019-11-15 17:18:27','2019-11-15 17:19:53'),
('1195269903542444034','1195268788138598401','查看',2,'role.list','','',NULL,NULL,0,'2019-11-15 17:18:47','2019-11-15 17:18:47'),
('1195270037005197313','1195268788138598401','添加',2,'role.add','role/add','/edu/acl/role/form',NULL,NULL,0,'2019-11-15 17:19:19','2019-11-18 11:05:42'),
('1195270442602782721','1195268788138598401','删除',2,'role.remove','','',NULL,NULL,0,'2019-11-15 17:20:55','2019-11-15 17:20:55'),
('1195270621548568578','1195268788138598401','角色权限',2,'role.acl','role/distribution/:id','/edu/acl/role/roleForm',NULL,NULL,0,'2019-11-15 17:21:38','2019-11-15 17:21:38'),
('1195270744097742849','1195268893830864898','查看',2,'permission.list','','',NULL,NULL,0,'2019-11-15 17:22:07','2019-11-15 17:22:07'),
('1195270810560684034','1195268893830864898','添加',2,'permission.add','','',NULL,NULL,0,'2019-11-15 17:22:23','2019-11-15 17:22:23'),
('1195270862100291586','1195268893830864898','修改',2,'permission.update','','',NULL,NULL,0,'2019-11-15 17:22:35','2019-11-15 17:22:35'),
('1195270887933009922','1195268893830864898','删除',2,'permission.remove','','',NULL,NULL,0,'2019-11-15 17:22:41','2019-11-15 17:22:41'),
('1195349439240048642','1','讲师管理',1,NULL,'/edu/teacher','Layout','peoples',NULL,0,'2019-11-15 22:34:49','2019-11-15 22:34:49'),
('1195349699995734017','1195349439240048642','讲师列表',1,NULL,'list','/edu/teacher/list',NULL,NULL,0,'2019-11-15 22:35:52','2019-11-15 22:35:52'),
('1195349810561781761','1195349439240048642','添加讲师',1,NULL,'save','/edu/teacher/add',NULL,NULL,0,'2019-11-15 22:36:18','2019-11-15 22:36:18'),
('1195349876252971010','1195349810561781761','添加',2,'teacher.add','','',NULL,NULL,0,'2019-11-15 22:36:34','2019-11-15 22:36:34'),
('1195349979797753857','1195349699995734017','查看',2,'teacher.list','','',NULL,NULL,0,'2019-11-15 22:36:58','2019-11-15 22:36:58'),
('1195350117270261762','1195349699995734017','修改',2,'teacher.update','edit/:id','/edu/teacher/add',NULL,NULL,0,'2019-11-15 22:37:31','2019-11-15 22:37:31'),
('1195350188359520258','1195349699995734017','删除',2,'teacher.remove','','',NULL,NULL,0,'2019-11-15 22:37:48','2019-11-15 22:37:48'),
('1195350299365969922','1','课程分类',1,NULL,'/edu/subject','Layout','tree',NULL,0,'2019-11-15 22:38:15','2019-11-15 22:38:15'),
('1195350397751758850','1195350299365969922','课程分类列表',1,NULL,'list','/edu/subject/list',NULL,NULL,0,'2019-11-15 22:38:38','2019-11-15 22:38:38'),
('1195350500512206850','1195350299365969922','导入课程分类',1,NULL,'import','/edu/subject/import',NULL,NULL,0,'2019-11-15 22:39:03','2019-11-15 22:39:03'),
('1195350612172967938','1195350397751758850','查看',2,'subject.list','','',NULL,NULL,0,'2019-11-15 22:39:29','2019-11-15 22:39:29'),
('1195350687590748161','1195350500512206850','导入',2,'subject.import','','',NULL,NULL,0,'2019-11-15 22:39:47','2019-11-15 22:39:47'),
('1195350831744782337','1','课程管理',1,NULL,'/edu/course','Layout','table',NULL,0,'2019-11-15 22:40:21','2019-11-15 22:40:21'),
('1195350919074385921','1195350831744782337','课程列表',1,NULL,'list','/edu/course/list',NULL,NULL,0,'2019-11-15 22:40:42','2019-11-15 22:40:42'),
('1195351020463296513','1195350831744782337','发布课程',1,NULL,'info','/edu/course/info',NULL,NULL,0,'2019-11-15 22:41:06','2019-11-15 22:41:06'),
('1195351159672246274','1195350919074385921','发布提交',2,'course.publish','publish/:id','/edu/course/publish',NULL,NULL,0,'2019-11-15 22:41:40','2019-11-15 22:44:01'),
('1195351326706208770','1195350919074385921','编辑课程',2,'course.update','info/:id','/edu/course/info',NULL,NULL,0,'2019-11-15 22:42:19','2019-11-15 22:42:19'),
('1195351566221938690','1195350919074385921','编辑课程大纲',2,'chapter.update','chapter/:id','/edu/course/chapter',NULL,NULL,0,'2019-11-15 22:43:17','2019-11-15 22:43:17'),
('1195351862889254913','1','统计管理',1,NULL,'/statistics','Layout','chart',NULL,0,'2019-11-15 22:44:27','2019-11-15 22:44:27'),
('1195351968841568257','1195351862889254913','数据统计',1,NULL,'create','/edu/statistics/create',NULL,NULL,0,'2019-11-15 22:44:53','2019-11-15 22:44:53'),
('1195352054917074946','1195351862889254913','图表显示',1,NULL,'show','/edu/statistics/show',NULL,NULL,0,'2019-11-15 22:45:13','2019-11-15 22:45:13'),
('1195352127734386690','1195352054917074946','查看',2,'daily.list','','',NULL,NULL,0,'2019-11-15 22:45:30','2019-11-15 22:45:30'),
('1195352215768633346','1195351968841568257','生成',2,'daily.add','','',NULL,NULL,0,'2019-11-15 22:45:51','2019-11-15 22:45:51'),
('1195352547621965825','1','前台管理',1,NULL,'/front','Layout','user',NULL,0,'2019-11-15 22:47:11','2019-11-18 10:51:46'),
('1195352856645701633','1195353513549205505','查看',2,'banner.list','',NULL,NULL,NULL,0,'2019-11-15 22:48:24','2019-11-15 22:48:24'),
('1195352909401657346','1195353513549205505','添加',2,'banner.add','banner/save','/edu/banner/add',NULL,NULL,0,'2019-11-15 22:48:37','2019-11-18 10:52:10'),
('1195353051395624961','1195353513549205505','修改',2,'banner.update','banner/edit/:id','/edu/banner/add',NULL,NULL,0,'2019-11-15 22:49:11','2019-11-18 10:52:05'),
('1195353513549205505','1195352547621965825','轮播图管理',1,NULL,'banner/list','/edu/banner/list',NULL,NULL,0,'2019-11-15 22:51:01','2019-11-18 10:51:29'),
('1195353672110673921','1195353513549205505','删除',2,'banner.remove','','',NULL,NULL,0,'2019-11-15 22:51:39','2019-11-15 22:51:39'),
('1196301740985311234','1195268616021139457','分配角色',2,'user.assgin','user/role/:id','/edu/acl/user/roleForm',NULL,NULL,0,'2019-11-18 13:38:56','2022-10-04 10:22:46'),
('1577164572589088769','1195352547621965825','评论管理',1,NULL,'comment/list','/edu/comment/list',NULL,NULL,0,'2022-10-04 13:11:51','2022-10-04 13:11:51'),
('1577165136878166018','1195352547621965825','订单管理',1,NULL,'order/list','/edu/order/list',NULL,NULL,0,'2022-10-04 13:14:06','2022-10-04 13:14:06');

/*Table structure for table `acl_role` */

DROP TABLE IF EXISTS `acl_role`;

CREATE TABLE `acl_role` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '角色id',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `acl_role` */

insert  into `acl_role`(`id`,`role_name`,`role_code`,`remark`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1','普通管理员',NULL,NULL,0,'2019-11-11 13:09:32','2019-11-18 10:27:18'),
('1193757683205607426','课程管理员',NULL,NULL,0,'2019-11-11 13:09:45','2019-11-18 10:25:44'),
('1196300996034977794','test',NULL,NULL,0,'2019-11-18 13:35:58','2019-11-18 13:35:58');

/*Table structure for table `acl_role_permission` */

DROP TABLE IF EXISTS `acl_role_permission`;

CREATE TABLE `acl_role_permission` (
  `id` char(19) NOT NULL DEFAULT '',
  `role_id` char(19) NOT NULL DEFAULT '',
  `permission_id` char(19) NOT NULL DEFAULT '',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

/*Data for the table `acl_role_permission` */

insert  into `acl_role_permission`(`id`,`role_id`,`permission_id`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1577112798784147458','1','1',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147459','1','1195268474480156673',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147460','1','1195268616021139457',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147461','1','1195269143060602882',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147462','1','1195269295926206466',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147463','1','1195269473479483394',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147464','1','1195269547269873666',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147465','1','1196301740985311234',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147466','1','1195268788138598401',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147467','1','1195269821262782465',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147468','1','1195269903542444034',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147469','1','1195270037005197313',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147470','1','1195270442602782721',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798784147471','1','1195270621548568578',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924673','1','1195268893830864898',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924674','1','1195270744097742849',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924675','1','1195270810560684034',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924676','1','1195270862100291586',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924677','1','1195270887933009922',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924678','1','1195349439240048642',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924679','1','1195349699995734017',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924680','1','1195349979797753857',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924681','1','1195350117270261762',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924682','1','1195350188359520258',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924683','1','1195349810561781761',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924684','1','1195349876252971010',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924685','1','1195350299365969922',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924686','1','1195350397751758850',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924687','1','1195350612172967938',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924688','1','1195350500512206850',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798800924689','1','1195350687590748161',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798901587969','1','1195350831744782337',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798905782274','1','1195350919074385921',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798905782275','1','1195351159672246274',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798905782276','1','1195351326706208770',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798905782277','1','1195351566221938690',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798909976578','1','1195351862889254913',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798909976579','1','1195351968841568257',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798909976580','1','1195352215768633346',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798909976581','1','1195352054917074946',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798914170882','1','1195352127734386690',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798914170883','1','1195352547621965825',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798914170884','1','1195353513549205505',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798914170885','1','1195352856645701633',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798914170886','1','1195352909401657346',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798918365186','1','1195353051395624961',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798918365187','1','1195353672110673921',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798918365188','1','1195354076890370050',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798918365189','1','1195354153482555393',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577112798918365190','1','1195354315093282817',0,'2022-10-04 09:46:07','2022-10-04 09:46:07'),
('1577119641837240322','1577119578029293569','1',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641845628929','1577119578029293569','1195268474480156673',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641849823234','1577119578029293569','1195268616021139457',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641849823235','1577119578029293569','1195269143060602882',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641854017537','1577119578029293569','1195269295926206466',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641858211842','1577119578029293569','1195269473479483394',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641862406145','1577119578029293569','1195269547269873666',0,'2022-10-04 10:13:19','2022-10-04 10:13:19'),
('1577119641866600449','1577119578029293569','1196301740985311234',0,'2022-10-04 10:13:19','2022-10-04 10:13:19');

/*Table structure for table `acl_user` */

DROP TABLE IF EXISTS `acl_user`;

CREATE TABLE `acl_user` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '微信openid',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `salt` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `token` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

/*Data for the table `acl_user` */

insert  into `acl_user`(`id`,`username`,`password`,`nick_name`,`salt`,`token`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1','admin','96e79218965eb72c92a549dd5a330112','admin','',NULL,0,'2019-11-01 10:39:47','2019-11-01 10:39:47'),
('2','test','96e79218965eb72c92a549dd5a330112','test',NULL,NULL,0,'2019-11-01 16:36:07','2019-11-01 16:40:08');

/*Table structure for table `acl_user_role` */

DROP TABLE IF EXISTS `acl_user_role`;

CREATE TABLE `acl_user_role` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT '主键id',
  `role_id` char(19) NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` char(19) NOT NULL DEFAULT '0' COMMENT '用户id',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `acl_user_role` */

insert  into `acl_user_role`(`id`,`role_id`,`user_id`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1577152957873446913','1577119578029293569','2',0,'2022-10-04 12:25:42','2022-10-04 12:25:42'),
('1577192347140141057','1','1',0,'2022-10-04 15:02:13','2022-10-04 15:02:13');

/*Table structure for table `crm_banner` */

DROP TABLE IF EXISTS `crm_banner`;

CREATE TABLE `crm_banner` (
  `id` char(19) NOT NULL DEFAULT '' COMMENT 'ID',
  `title` varchar(20) DEFAULT '' COMMENT '标题',
  `image_url` varchar(500) NOT NULL DEFAULT '' COMMENT '图片地址',
  `link_url` varchar(500) DEFAULT '' COMMENT '链接地址',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='首页banner表';

/*Data for the table `crm_banner` */

insert  into `crm_banner`(`id`,`title`,`image_url`,`link_url`,`sort`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1194556896025845762','Java后端','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/banner/20224420104426868.jpg','/course',1,0,'2019-11-13 18:05:32','2022-10-01 21:58:50'),
('1194607458461216769','Html/Css/JS前端','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/banner/20222821102825440.jpg','/course',2,0,'2019-11-13 21:26:27','2019-11-14 09:12:15'),
('1573581156383772889','Python大数据','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/banner/20224630134624948.jpg','/course',4,0,'2022-09-23 19:44:27','2022-09-24 19:44:16'),
('1573581156383772984','UI/UE设计','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/banner/20224210184240487.jpg','/course',3,0,'2022-09-24 15:52:38','2022-09-24 15:53:21');

/*Table structure for table `edu_chapter` */

DROP TABLE IF EXISTS `edu_chapter`;

CREATE TABLE `edu_chapter` (
  `id` char(19) NOT NULL COMMENT '章节ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `title` varchar(50) NOT NULL COMMENT '章节名称',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '显示排序',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程';

/*Data for the table `edu_chapter` */

insert  into `edu_chapter`(`id`,`course_id`,`title`,`sort`,`gmt_create`,`gmt_modified`) values 
('1573651168704364546','1573651118867644417','第一章',0,'2022-09-24 20:30:50','2022-09-24 20:30:50'),
('1573657216643268610','1573652657841668098','第一章 Java概述',0,'2022-09-24 20:54:52','2022-09-24 20:54:52'),
('1573657272700141570','1573652657841668098','第二章 变量',0,'2022-09-24 20:55:06','2022-09-24 20:55:06'),
('1573657379931717634','1573652657841668098','第三章 运算符与流程控制',0,'2022-09-24 20:55:31','2022-09-24 20:56:03'),
('1573657483895930881','1573652657841668098','第四章 数组排序与查找',0,'2022-09-24 20:55:56','2022-09-24 20:55:56'),
('1573657583846195202','1573652657841668098','第五章 面向对象核心',0,'2022-09-24 20:56:20','2022-09-24 20:56:20'),
('1573657651789725698','1573652657841668098','第六章 异常',0,'2022-09-24 20:56:36','2022-09-24 20:56:36'),
('1573657705430679554','1573652657841668098','第七章 常用类',0,'2022-09-24 20:56:49','2022-09-24 20:56:49'),
('1573657777383964674','1573652657841668098','第八章 集合',0,'2022-09-24 20:57:06','2022-09-24 20:57:06'),
('1573657835860951042','1573652657841668098','第九章 泛型与注解',0,'2022-09-24 20:57:20','2022-09-24 20:57:20'),
('1573657907512246273','1573652657841668098','第十章 IO流',0,'2022-09-24 20:57:37','2022-09-24 20:57:37'),
('1573658004178370561','1573652657841668098','第十一章 网络编程',0,'2022-09-24 20:58:00','2022-09-24 20:58:00'),
('1573658056519090177','1573652657841668098','第十二章 反射',0,'2022-09-24 20:58:12','2022-09-24 20:58:12'),
('1573658113133805569','1573652657841668098','第十三章 JDBC',0,'2022-09-24 20:58:26','2022-09-24 20:58:26'),
('1573877164783263745','1573877141882363905','测试',0,'2022-09-25 11:28:52','2022-09-25 11:28:52'),
('1577175014719889410','1576968409407623169','测试章节',2,'2022-10-04 13:53:21','2022-10-04 13:53:21');

/*Table structure for table `edu_comment` */

DROP TABLE IF EXISTS `edu_comment`;

CREATE TABLE `edu_comment` (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论id',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `teacher_id` char(19) NOT NULL DEFAULT '' COMMENT '讲师id',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '会员头像',
  `content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_teacher_id` (`teacher_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论';

/*Data for the table `edu_comment` */

insert  into `edu_comment`(`id`,`course_id`,`teacher_id`,`member_id`,`nickname`,`avatar`,`content`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1','1573652657841668098','1573649616975462401','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','课程很好，希望继续出品更多高质量视频课程',0,'2022-09-29 11:35:32','2022-09-29 11:35:34'),
('10','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:05:29','2022-09-29 12:05:29'),
('11','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:06:40','2022-09-29 12:06:40'),
('1575354876295200770','1573652657841668098','1573649616975462401','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','已三刷，老师讲课逻辑思维很清晰，很赞！！',0,'2022-09-29 13:20:46','2022-09-29 13:20:46'),
('1575355560734310401','1573652657841668098','1573649616975462401','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','强烈推荐，每次看都有不同收获！',0,'2022-09-29 13:23:29','2022-09-29 13:23:29'),
('1575355825642356737','1573652657841668098','1573649616975462401','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','不是托哦！！',0,'2022-09-29 13:24:32','2022-09-29 13:24:32'),
('1575356712095924225','1573652405998878722','1573648439693049857','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','<script>alert(123)</script>',0,'2022-09-29 13:28:04','2022-09-29 13:28:04'),
('1575387991294164993','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 15:32:21','2022-09-29 15:32:21'),
('1575398878541332482','1573653459914227714','1573648123996176385','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','测试1',0,'2022-09-29 16:15:37','2022-09-29 16:15:37'),
('1575399875523198978','1573653459914227714','1573648123996176385','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','测试2',0,'2022-09-29 16:19:34','2022-09-29 16:19:34'),
('1575399890673025025','1573653459914227714','1573648123996176385','1574691085966422018','渡己','https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132','123',0,'2022-09-29 16:19:38','2022-09-29 16:19:38'),
('1575428766941954050','1573651118867644417','1573647275467505666','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试评论1',0,'2022-09-29 18:14:23','2022-09-29 18:14:23'),
('1575428823544086529','1573653202107138050','1573647848350711809','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试评论1',0,'2022-09-29 18:14:36','2022-09-29 18:14:36'),
('1575428838953959425','1573653202107138050','1573647848350711809','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试评论2',0,'2022-09-29 18:14:40','2022-09-29 18:14:40'),
('1575428854154117122','1573653202107138050','1573647848350711809','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试评论3',0,'2022-09-29 18:14:44','2022-09-29 18:14:44'),
('1575697718465044481','1573652894169726977','1573648743633289218','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','hello！',0,'2022-09-30 12:03:06','2022-09-30 12:03:06'),
('1575873525493846018','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','123',0,'2022-09-30 23:41:41','2022-09-30 23:41:41'),
('1577255237704523777','1573652657841668098','','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-10-04 19:12:07','2022-10-04 19:12:07'),
('1577260121757622274','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','123',0,'2022-10-04 19:31:32','2022-10-04 19:31:32'),
('1577512587547922434','1573653459914227714','1573648123996176385','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','123',0,'2022-10-05 12:14:44','2022-10-05 12:14:44'),
('1577627886649683969','1573653737187082242','1573647848350711809','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-10-05 19:52:54','2022-10-05 19:52:54'),
('1577675487428243457','1573655633515806721','1573648439693049857','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','已购买！',0,'2022-10-05 23:02:03','2022-10-05 23:02:03'),
('2','1573652657841668098','1573649616975462401','1106833021442510849','食物链终结者','http://thirdwx.qlogo.cn/mmopen/vi_32/MQ7qUmCprK9am16M1Ia1Cs3RK0qiarRrl9y8gsssBjIZeS2GwKSrnq7ZYhmrzuzDwBxSMMAofrXeLic9IBlW4M3Q/132','课程通俗易懂，强烈推荐！！',0,'2022-09-29 11:59:52','2022-09-29 11:59:52'),
('3','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:04:41','2022-09-29 12:04:41'),
('4','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','课程通俗易懂，强烈推荐！！',0,'2022-09-29 12:04:12','2022-09-29 12:04:12'),
('5','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:04:47','2022-09-29 12:04:47'),
('6','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:04:58','2022-09-29 12:04:58'),
('7','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:05:05','2022-09-29 12:05:05'),
('8','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:05:11','2022-09-29 12:05:11'),
('9','1573652657841668098','1573649616975462401','1574379079539421185','zbinyds','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg','测试',0,'2022-09-29 12:05:17','2022-09-29 12:05:17');

/*Table structure for table `edu_course` */

DROP TABLE IF EXISTS `edu_course`;

CREATE TABLE `edu_course` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `teacher_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `subject_id` char(19) NOT NULL COMMENT '课程专业ID',
  `subject_parent_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '课程专业父级ID',
  `title` varchar(50) NOT NULL COMMENT '课程标题',
  `price` decimal(10,2) unsigned NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
  `lesson_num` int unsigned NOT NULL DEFAULT '0' COMMENT '总课时',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程封面图片路径',
  `buy_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '销售数量',
  `view_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '浏览数量',
  `version` bigint unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `status` varchar(10) NOT NULL DEFAULT 'Draft' COMMENT '课程状态 Draft未发布  Normal已发布',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_title` (`title`),
  KEY `idx_subject_id` (`subject_id`),
  KEY `idx_teacher_id` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程';

/*Data for the table `edu_course` */

insert  into `edu_course`(`id`,`teacher_id`,`subject_id`,`subject_parent_id`,`title`,`price`,`lesson_num`,`cover`,`buy_count`,`view_count`,`version`,`status`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1573651118867644417','1573647275467505666','1573643340656705538','1573643340421824513','SpringCloud-自学上岸秘籍！',0.00,168,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/3b9d25ae38e369d8ba5516f988be15d3c187a4dc.jpg',0,77,1,'Normal',0,'2022-09-24 20:30:38','2022-09-24 20:31:05'),
('1573652405998878722','1573648439693049857','1573643341021609985','1573643340983861250','MySQL从菜鸟到大牛',0.00,199,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/1504320cbe2b246514.jpg',0,533,1,'Normal',0,'2022-09-24 20:35:45','2022-09-24 20:35:52'),
('1573652657841668098','1573649616975462401','1573643340656705538','1573643340421824513','Java经典入门教程',0.01,599,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/24dbedc9b4dacbed6c79d767b448cfea01d49c55.jpg',12985,98887,1,'Normal',0,'2022-09-24 20:36:45','2022-09-24 21:17:11'),
('1573652894169726977','1573648743633289218','1573643341168410625','1573643341092913153','spark教程',0.00,99,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/39e51c23-e2fa-4a8a-9239-3c0d5268f34d.jpg',0,221,1,'Normal',0,'2022-09-24 20:37:42','2022-09-24 20:37:44'),
('1573653202107138050','1573647848350711809','1573643340832866305','1573643340757368833','JavaScript一套搞定',0.00,168,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/0035660795e1456fae0249e8b0ab8950e8b5fc65.jpg',0,278,1,'Normal',0,'2022-09-24 20:38:55','2022-09-24 20:38:58'),
('1573653459914227714','1573648123996176385','1573643340656705538','1573643340421824513','Mybatis-2022最新定制',0.00,84,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/3dfe0671afb8155628d860f81440f16585ca45c1.jpg',0,7,1,'Normal',0,'2022-09-24 20:39:57','2022-09-24 20:39:59'),
('1573653737187082242','1573647848350711809','1573643340656705538','1573643340421824513','SpringMVC一套通透',0.00,124,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/4a7efd697e911f0ba0df6afd613bcc1b17d0868d.jpg',0,22,1,'Normal',0,'2022-09-24 20:41:03','2022-09-24 20:41:05'),
('1573653929500114946','1573648439693049857','1573643340656705538','1573643340421824513','SSM一套通关',0.00,189,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/4bbddbf0a589472b71fcc1ff2b4d506ec72a2243.jpg',0,1,1,'Normal',0,'2022-09-24 20:41:49','2022-09-24 20:41:51'),
('1573654174350999553','1573649616975462401','1573643340656705538','1573643340421824513','Spring实战+5天快速入门',0.00,56,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/5b138eb3b20e73c2a3610e8e2019e5c2745f3bd1.jpg',0,10,1,'Normal',0,'2022-09-24 20:42:47','2022-09-24 20:42:52'),
('1573654506091085826','1573648439693049857','1573643341021609985','1573643340983861250','10天精讲+MySQL+全程高能',0.00,114,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/7e15bb1dc75f9933f9cbe4feac9a0bfbd570e5c0.jpg',0,13,1,'Normal',0,'2022-09-24 20:44:06','2022-09-24 20:44:09'),
('1573654829727776770','1573648743633289218','1573643340790923265','1573643340757368833','前端html/css/js一套精通+全网1000w播放量',0.00,685,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/8a334edc5a07afef88d62e8c938682a03e2f695d.jpg',0,0,1,'Normal',0,'2022-09-24 20:45:23','2022-09-24 20:45:27'),
('1573655145969909762','1573647848350711809','1573643340958695426','1573643340883197954','史上最细最全Linux-从入门到精通',0.01,164,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/8ba880ffa77203da7b48fc8b654fdfdf11d4dad2.jpg',98,566,1,'Normal',0,'2022-09-24 20:46:39','2022-10-04 14:26:09'),
('1573655383333961729','1573648743633289218','1573643340908363777','1573643340883197954','Docker容器化技术之深入解析',0.01,177,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/9778d9384a30fb07ecc3738c83b7282505a915df.jpg',66,56,1,'Normal',0,'2022-09-24 20:47:35','2022-09-24 21:17:45'),
('1573655633515806721','1573648439693049857','1573643340656705538','1573643340421824513','全新技术栈+JavaWeb+企业主流技术',0.01,68,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/c7bb9299d013db11a4d03cea247ba24268160b97.jpg',699,255,1,'Normal',0,'2022-09-24 20:48:35','2022-09-24 21:17:22'),
('1573655922956337153','1573648123996176385','1573643340656705538','1573643340421824513','2022全新定制+MybatisPlus精讲',0.00,52,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/dee69a57eaa1d102aa88c904a8291e11a554dcbd.jpg',0,336,1,'Normal',0,'2022-09-24 20:49:44','2022-09-24 20:49:47'),
('1573655922956337177','1573648123996176385','1573643340656705538','1573643340421824513','测试',0.00,99,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/default.gif',0,22,1,'Draft',1,'2022-09-28 13:19:01','2022-09-28 13:19:04'),
('1576968409407623169','1573649616976112435','1573643340656705538','1573643340421824513','测试123',18.00,0,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/2022/10/04/541507c9ac8f497cac3f6227134fef23.jpg',0,0,1,'Draft',0,'2022-10-04 00:12:22','2022-10-04 14:27:22');

/*Table structure for table `edu_course_collect` */

DROP TABLE IF EXISTS `edu_course_collect`;

CREATE TABLE `edu_course_collect` (
  `id` char(19) NOT NULL COMMENT '收藏ID',
  `course_id` char(19) NOT NULL COMMENT '课程讲师ID',
  `member_id` char(19) NOT NULL DEFAULT '' COMMENT '课程专业ID',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程收藏';

/*Data for the table `edu_course_collect` */

insert  into `edu_course_collect`(`id`,`course_id`,`member_id`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1577502465442557953','1573652657841668098','1574379079539421185',0,'2022-10-05 11:34:31','2022-10-05 11:34:31'),
('1577507624662880257','1573652894169726977','1574379079539421185',0,'2022-10-05 11:55:01','2022-10-05 11:55:01'),
('1577508673821888514','1573652405998878722','1574379079539421185',0,'2022-10-05 11:59:11','2022-10-05 11:59:11'),
('1577627818064424962','1573653737187082242','1574379079539421185',0,'2022-10-05 19:52:37','2022-10-05 19:52:37'),
('1577675803917840386','1573651118867644417','1574379079539421185',0,'2022-10-05 23:03:18','2022-10-05 23:03:18');

/*Table structure for table `edu_course_description` */

DROP TABLE IF EXISTS `edu_course_description`;

CREATE TABLE `edu_course_description` (
  `id` char(19) NOT NULL COMMENT '课程ID',
  `description` text COMMENT '课程简介',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程简介';

/*Data for the table `edu_course_description` */

insert  into `edu_course_description`(`id`,`description`,`gmt_create`,`gmt_modified`) values 
('1573651118867644417','<p>课程简介</p>','2022-09-24 20:30:38','2022-09-24 20:30:38'),
('1573652405998878722','<p>课程简介</p>','2022-09-24 20:35:45','2022-09-24 20:35:45'),
('1573652657841668098','<p>课程简介</p>','2022-09-24 20:36:45','2022-09-24 21:17:11'),
('1573652894169726977','<p>课程简介</p>','2022-09-24 20:37:42','2022-09-24 20:37:42'),
('1573653202107138050','<p>课程简介</p>','2022-09-24 20:38:55','2022-09-24 20:38:55'),
('1573653459914227714','<p>课程简介</p>','2022-09-24 20:39:57','2022-09-24 20:39:57'),
('1573653737187082242','<p><strong>课程简介</strong></p>','2022-09-24 20:41:03','2022-09-24 20:41:03'),
('1573653929500114946','<p><em><strong>课程简介</strong></em></p>','2022-09-24 20:41:49','2022-09-24 20:41:49'),
('1573654174350999553','<p>课程简介</p>','2022-09-24 20:42:47','2022-09-24 20:42:47'),
('1573654506091085826','<p>课程简介</p>','2022-09-24 20:44:06','2022-09-24 20:44:06'),
('1573654829727776770','<p>课程简介</p>','2022-09-24 20:45:23','2022-09-24 20:45:23'),
('1573655145969909762','<p>课程简介</p>','2022-09-24 20:46:39','2022-10-04 14:25:16'),
('1573655383333961729','<p>课程简介</p>','2022-09-24 20:47:35','2022-09-24 21:17:45'),
('1573655633515806721','<p>课程简介</p>','2022-09-24 20:48:35','2022-09-24 21:17:22'),
('1573655922956337153','<p>课程简介</p>','2022-09-24 20:49:44','2022-09-24 20:49:44'),
('1573877141882363905','<p>测试</p>','2022-09-25 11:28:47','2022-09-25 11:28:47'),
('1576968409407623169','<p><em><strong>123</strong></em></p>','2022-10-04 00:12:22','2022-10-04 14:27:22');

/*Table structure for table `edu_subject` */

DROP TABLE IF EXISTS `edu_subject`;

CREATE TABLE `edu_subject` (
  `id` char(19) NOT NULL COMMENT '课程类别ID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类别名称',
  `parent_id` char(19) NOT NULL DEFAULT '0' COMMENT '父ID',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程科目';

/*Data for the table `edu_subject` */

insert  into `edu_subject`(`id`,`title`,`parent_id`,`sort`,`gmt_create`,`gmt_modified`) values 
('1573643340421824513','后端开发','0',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340656705538','Java','1573643340421824513',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340707037185','Python','1573643340421824513',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340757368833','前端开发','0',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340790923265','Html/Css/Js','1573643340757368833',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340832866305','JavaScript','1573643340757368833',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340883197954','运维','0',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340908363777','Docker','1573643340883197954',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340958695426','Linux','1573643340883197954',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643340983861250','数据库','0',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643341021609985','MySQL','1573643340983861250',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643341067747330','MongoDB','1573643340983861250',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643341092913153','大数据','0',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643341122273281','Hadoop','1573643341092913153',0,'2022-09-24 19:59:44','2022-09-24 19:59:44'),
('1573643341168410625','Spark','1573643341092913153',0,'2022-09-24 19:59:44','2022-09-24 19:59:44');

/*Table structure for table `edu_teacher` */

DROP TABLE IF EXISTS `edu_teacher`;

CREATE TABLE `edu_teacher` (
  `id` char(19) NOT NULL COMMENT '讲师ID',
  `name` varchar(20) NOT NULL COMMENT '讲师姓名',
  `intro` varchar(500) NOT NULL DEFAULT '' COMMENT '讲师简介',
  `career` varchar(500) DEFAULT NULL COMMENT '讲师资历,一句话说明讲师',
  `level` int unsigned NOT NULL COMMENT '头衔 1高级讲师 2首席讲师',
  `avatar` varchar(255) DEFAULT NULL COMMENT '讲师头像',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='讲师';

/*Data for the table `edu_teacher` */

insert  into `edu_teacher`(`id`,`name`,`intro`,`career`,`level`,`avatar`,`sort`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1573647275467505666','雷老师','具有多年软件开发经验，熟悉 Java、C/C++等多种开发语言，对主流框架Spring、Struts2、Hibernate、MyBatis、SpringMVC等具有丰富的开发经验。曾参与大型物联网系统（智能物流）、智慧城市系统的开发，并主持开发某社交软件的移动端（Android/iOS）、服务端（openfire）、桌面端（swing）、网页端（webIM），对即时通讯、图像处理、流媒体领域等有深入研究。','前阿里资深架构师',2,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/leifengyang.png',10,0,'2022-09-24 20:15:22','2022-10-04 13:49:07'),
('1573647848350711809','李老师','具有多年项目开发和教育培训经验，曾在日本野村证券主持开发金融证券项目，对金融数据处理具有丰富的经验。曾为北京积水潭医院主持开发过网络预约，挂号，分诊系统等。熟悉各种 Web 前端技术，熟练跨浏览器、跨终端的开发；包括熟练掌握JavaScript、jQuery，对angularJS，vueJS，ReactJS有深入研究并熟练掌握底层原理。','高级前端开发工程师',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/liyuting.png',11,0,'2022-09-24 20:17:39','2022-09-24 20:17:39'),
('1573648123996176385','毛老师','从事Java程序及移动安卓开发及IT培训事业十余年，曾就职于伊利集团作为开发团队主力开发了伊利集团人力资源管理系统、经销商管理系统等项目。后在上海京颐股份参与了公司移动医疗、医疗云、医疗物联网的开发，并在其子公司趣护网负责安卓端应用趣户APP的研发。转型为IT培训讲师后负责MySQL、JavaWeb、SSM框架、Android等课程的研发讲解。','高级安卓开发工程师',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/miaochuanhai.png',12,0,'2022-09-24 20:18:44','2022-09-24 20:18:44'),
('1573648439693049857','宋老师','多年软件开发及软件培训经验，曾就职于一路捞互联网科技、智康通达等知名企业，从事Java方向的软件研发及教学工作，曾培训东北大学、武汉大学、兰州大学等近百所高校教师及学生近万名。参与大型在线教育（O2O）、新闻发布、车联网等系统；曾担任高级Java工程师、项目经理等职务。精通C/C++、Java核心技术、JVM、SSH、SSM、数据库、Maven、大数据等技术。','北航遗憾康师傅',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/songhongkang.png',13,0,'2022-09-24 20:20:00','2022-09-24 20:20:00'),
('1573648743633289218','武老师','中国人民大学软件工程硕士。精通java核心框架、大数据Hadoop、Spark技术，曾先后就职于南天软件、用友金融、中植集团、百合贷，任技术经理、项目经理、技术部负责人。主持开发了中信银行、国家电网、中植集团、东方资产等大型企业的金融类系统，也对时下流行的互联网金融有深入的研究。 十余年的项目经历，练就了纯厚的技术底蕴和丰富的职场经验。','高级大数据开发工程师',2,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/wushengran.png',14,0,'2022-09-24 20:21:12','2022-09-24 20:21:12'),
('1573649004388974593','周老师','多年软件开发及软件培训经验，曾就职于一路捞互联网科技、智康通达等知名企业，从事Java方向的软件研发及教学工作，曾培训东北大学、武汉大学、兰州大学等近百所高校教师及学生近万名。参与大型在线教育（O2O）、新闻发布、车联网等系统；曾担任高级Java工程师、项目经理等职务。精通C/C++、Java核心技术、JVM、SSH、SSM、数据库、Maven、大数据等技术。','高级Java开发工程师',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/zhouyang.png',15,0,'2022-09-24 20:22:14','2022-09-24 20:22:14'),
('1573649616884256632','张老师','从事JavaEE技术多年，一直致力于Java技术培训，热爱教育。深入掌握Struts、Hibernate、Spring、SpringMVC、MyBatis、EJB等主流框架,通过分析源码，讲解框架设计原理。授课细致，深入浅出，深受学生喜爱。曾参与开发了首钢集团OA系统；CMMI项目管理系统；eGov电子政务系统等。对学生寄语：既然选择就别轻言放弃！','中级Java开发工程师',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/wangteacher.png',17,0,'2022-09-27 20:07:29','2022-09-27 20:07:36'),
('1573649616975462401','赵老师','Sun认证Web组件开发员（SCWCD），长期致力于Java技术的研究和培训工作，具有丰富的实训教育经验和项目开发经验。曾就职于三星SDS，参与SERP-Flex—Pilot开发，韩国三星员工健康管理系统HCMS维护和管理，门禁系统GCS的开发，以及三星分公司指定高层使用的监控管理系统C-SAMS开发。','前Sun公司资深开发工程师',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/zhangxiaofei.png',16,0,'2022-09-24 20:24:40','2022-09-24 20:24:40'),
('1573649616975462422','测试1','测试','测试',2,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/2022/10/04/88bc148f72934844b93fb83f738a0a94.png',0,0,'2022-09-27 20:51:05','2022-10-04 13:49:16'),
('1573649616976112435','测试2','测试','测试',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/2022/09/21/8da8268689414d3da980a70440daf435.jpeg',0,0,'2022-09-27 21:11:16','2022-10-04 13:49:35'),
('1573649616976123345','测试3','测试','测试',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/2022/09/17/7f20d12d94ae4ab9912e4d63a73bf148.png',0,0,'2022-09-27 21:12:12','2022-10-04 13:49:20'),
('1577174275788382210','测试4','测试','测试',1,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/2022/10/04/bbde82d985e1492d8d5212fcd215fe5d.png',0,0,'2022-10-04 13:50:25','2022-10-04 13:50:25');

/*Table structure for table `edu_video` */

DROP TABLE IF EXISTS `edu_video`;

CREATE TABLE `edu_video` (
  `id` char(19) NOT NULL COMMENT '视频ID',
  `course_id` char(19) NOT NULL COMMENT '课程ID',
  `chapter_id` char(19) NOT NULL COMMENT '章节ID',
  `title` varchar(50) NOT NULL COMMENT '节点名称',
  `video_source_id` varchar(100) DEFAULT NULL COMMENT '云端视频资源',
  `video_original_name` varchar(100) DEFAULT NULL COMMENT '原始文件名称',
  `sort` int unsigned NOT NULL DEFAULT '0' COMMENT '排序字段',
  `play_count` bigint unsigned NOT NULL DEFAULT '0' COMMENT '播放次数',
  `is_free` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费 1免费',
  `duration` float NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Normal' COMMENT 'Empty未上传 Transcoding转码中  Normal正常',
  `size` bigint unsigned NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
  `version` bigint unsigned NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_chapter_id` (`chapter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='课程视频';

/*Data for the table `edu_video` */

insert  into `edu_video`(`id`,`course_id`,`chapter_id`,`title`,`video_source_id`,`video_original_name`,`sort`,`play_count`,`is_free`,`duration`,`status`,`size`,`version`,`gmt_create`,`gmt_modified`) values 
('1573658237994041345','1573652657841668098','1573657216643268610','第一节 什么是程序？','86b64198581e469bb743db3b8d1a7229','6 - What If I Want to Move Faster.mp4',0,0,0,16,'Empty',2211663,1,'2022-09-24 20:58:56','2022-09-28 22:34:46'),
('1573658357036777473','1573652657841668098','1573657216643268610','第二节 Java的运行机制与运行过程','86b64198581e469bb743db3b8d1a7229','6 - What If I Want to Move Faster.mp4',0,0,0,16,'Empty',2211663,1,'2022-09-24 20:59:24','2022-09-24 20:59:24'),
('1573658505448030209','1573652657841668098','1573657216643268610','第三节 什么是JDK、JRE、JVM','86b64198581e469bb743db3b8d1a7229','6 - What If I Want to Move Faster.mp4',0,0,0,16,'Empty',2211663,1,'2022-09-24 21:00:00','2022-09-24 21:00:00'),
('1573658638994669570','1573652657841668098','1573657216643268610','第四节 Java快速入门','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:00:31','2022-09-24 21:00:31'),
('1573658774516826113','1573652657841668098','1573657272700141570','第一节 变量快速入门','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:01:04','2022-09-24 21:01:04'),
('1573658892796198914','1573652657841668098','1573657272700141570','第二节 Java中八大基本数据类型','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:01:32','2022-09-24 21:01:32'),
('1573658990536065025','1573652657841668098','1573657272700141570','第三节 基本数据类型转换','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:01:55','2022-09-24 21:01:55'),
('1573659180345098241','1573652657841668098','1573657379931717634','第一节 多种运算符概述','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:02:40','2022-09-24 21:02:40'),
('1573659300381884417','1573652657841668098','1573657379931717634','第二节 关键字与保留字','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:03:09','2022-09-24 21:03:09'),
('1573659458402287617','1573652657841668098','1573657379931717634','第三节 进制与转换','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:03:47','2022-09-24 21:05:54'),
('1573659561716383746','1573652657841668098','1573657379931717634','第四节 位运算符','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:04:11','2022-09-24 21:04:11'),
('1573659807410323458','1573652657841668098','1573657379931717634','第五节 流程控制之if、else、switch','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:05:10','2022-09-24 21:05:48'),
('1573659952415801346','1573652657841668098','1573657379931717634','第六节 循环控制之for、while、do-while','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:05:45','2022-09-24 21:05:45'),
('1573660179575111681','1573652657841668098','1573657483895930881','第一节 数组概述','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:06:39','2022-09-24 21:06:39'),
('1573660325297815553','1573652657841668098','1573657483895930881','第二节 数组之反转、拷贝、扩容','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:07:13','2022-09-24 21:07:13'),
('1573660430360936450','1573652657841668098','1573657483895930881','第三节 冒泡排序','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:07:38','2022-09-24 21:07:38'),
('1573660632677384194','1573652657841668098','1573657583846195202','第一节 面向对象编程（初级）','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:08:27','2022-09-24 21:08:27'),
('1573660690160320514','1573652657841668098','1573657583846195202','第二节 面向对象编程（中级）','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:08:40','2022-09-24 21:08:40'),
('1573660728924078081','1573652657841668098','1573657583846195202','第三节 面向对象编程（高级）','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:08:50','2022-09-24 21:08:50'),
('1573660875926044673','1573652657841668098','1573657651789725698','第一节 异常概述','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:09:25','2022-09-24 21:09:25'),
('1573660941193609218','1573652657841668098','1573657651789725698','第二节 异常体系说明','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:09:40','2022-09-24 21:09:40'),
('1573661058290188290','1573652657841668098','1573657651789725698','第三节 异常处理的两种方式','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:10:08','2022-09-24 21:10:08'),
('1573661113529171969','1573652657841668098','1573657651789725698','第四节 自定义异常','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:10:21','2022-09-24 21:10:21'),
('1573661187353116674','1573652657841668098','1573657705430679554','第一节 String、StringBuffer、StringBuilder类','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:10:39','2022-09-24 21:11:32'),
('1573661232982949890','1573652657841668098','1573657705430679554','第二节 包装类','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:10:50','2022-09-24 21:10:50'),
('1573661484347588610','1573652657841668098','1573657705430679554','第三节 日期类','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:11:50','2022-09-24 21:11:50'),
('1573661595349843970','1573652657841668098','1573657705430679554','第四节 Math、Arrays、System类','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:12:16','2022-09-24 21:12:16'),
('1573661692661891073','1573652657841668098','1573657777383964674','第一节 集合框架体系','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:12:39','2022-09-24 21:12:39'),
('1573661779710476289','1573652657841668098','1573657777383964674','第二节 单例集合和双例集合','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:13:00','2022-09-24 21:13:00'),
('1573661912191762433','1573652657841668098','1573657777383964674','第三节 ArrayList源码解析','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:13:32','2022-09-24 21:13:32'),
('1573661974485565442','1573652657841668098','1573657777383964674','第四节 Vector源码解析','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:13:47','2022-09-24 21:13:47'),
('1573662050993864706','1573652657841668098','1573657777383964674','第五节 HashSet源码解析','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:14:05','2022-09-24 21:14:32'),
('1573662093746405377','1573652657841668098','1573657777383964674','第六节 HashMap源码解析','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:14:15','2022-09-24 21:14:40'),
('1573662258976817154','1573652657841668098','1573657835860951042','第一节 泛型','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:14:54','2022-09-24 21:15:04'),
('1573662288609574914','1573652657841668098','1573657835860951042','第二节 注解','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:15:01','2022-09-24 21:15:06'),
('1573662400463273986','1573652657841668098','1573657907512246273','第一节 IO流体系','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:15:28','2022-09-24 21:15:28'),
('1573662478036926466','1573652657841668098','1573657907512246273','第二节 节点流和处理流','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:15:47','2022-09-24 21:15:47'),
('1573662550925541378','1573652657841668098','1573657907512246273','第三节 打印流','','',0,0,0,0,'Empty',0,1,'2022-09-24 21:16:04','2022-09-24 21:16:04'),
('1573905963793080321','1573877141882363905','1573877164783263745','测试','','',0,0,0,0,'Empty',0,1,'2022-09-25 13:23:18','2022-09-25 13:24:00'),
('1577175213706059777','1576968409407623169','1577175014719889410','测试小节','6a6457c7f80d4d08b6c9e8f559b539bb','6 - What If I Want to Move Faster.mp4',2,0,1,0,'Normal',2211663,1,'2022-10-04 13:54:08','2022-10-04 13:54:08'),
('1577185666332333333','1573651118867644417','1573651168704364546','第一节','6a6457c7f80d4d08b6c9e8f559b539bb','6 - What If I Want to Move Faster.mp4',0,0,0,0,'Normal',2211663,1,'2022-10-05 22:51:12','2022-10-05 22:51:13');

/*Table structure for table `statistics_daily` */

DROP TABLE IF EXISTS `statistics_daily`;

CREATE TABLE `statistics_daily` (
  `id` char(19) NOT NULL COMMENT '主键',
  `date_calculated` varchar(20) NOT NULL COMMENT '统计日期',
  `register_num` int NOT NULL DEFAULT '0' COMMENT '注册人数',
  `login_num` int NOT NULL DEFAULT '0' COMMENT '登录人数',
  `video_view_num` int NOT NULL DEFAULT '0' COMMENT '每日播放视频数',
  `course_num` int NOT NULL DEFAULT '0' COMMENT '每日新增课程数',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `statistics_day` (`date_calculated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站统计日数据';

/*Data for the table `statistics_daily` */

insert  into `statistics_daily`(`id`,`date_calculated`,`register_num`,`login_num`,`video_view_num`,`course_num`,`gmt_create`,`gmt_modified`) values 
('1576102691380203524','2022-09-28',0,20,97,186,'2022-10-01 20:37:03','2022-10-01 20:37:06'),
('1576102691380203525','2022-09-29',0,5,45,120,'2022-10-01 20:37:58','2022-10-01 20:37:59'),
('1576189841127809026','2022-09-30',0,197,38,138,'2022-10-01 20:38:37','2022-10-01 20:38:37'),
('1576213702120652802','2022-09-27',1,114,153,82,'2022-10-01 22:13:26','2022-10-01 22:13:26'),
('1576213767446937602','2022-9-27',1,197,119,32,'2022-10-01 22:13:41','2022-10-01 22:13:41'),
('1576482831448707073','2022-10-01',1,35,133,179,'2022-10-02 16:02:51','2022-10-02 16:02:51'),
('1576483725397495810','2022-10-02',0,53,51,176,'2022-10-02 16:06:24','2022-10-02 16:06:24'),
('1577186214631473154','2022-10-03',0,97,128,165,'2022-10-04 14:37:51','2022-10-04 14:37:51');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `course_id` varchar(19) NOT NULL DEFAULT '' COMMENT '课程id',
  `course_title` varchar(100) DEFAULT NULL COMMENT '课程名称',
  `course_cover` varchar(255) DEFAULT NULL COMMENT '课程封面',
  `teacher_name` varchar(20) DEFAULT NULL COMMENT '讲师名称',
  `member_id` varchar(19) NOT NULL DEFAULT '' COMMENT '会员id',
  `nickname` varchar(50) DEFAULT NULL COMMENT '会员昵称',
  `mobile` varchar(11) DEFAULT NULL COMMENT '会员手机',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '订单金额（分）',
  `pay_type` tinyint DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
  `status` tinyint DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_order_no` (`order_no`),
  KEY `idx_course_id` (`course_id`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单';

/*Data for the table `t_order` */

insert  into `t_order`(`id`,`order_no`,`course_id`,`course_title`,`course_cover`,`teacher_name`,`member_id`,`nickname`,`mobile`,`total_fee`,`pay_type`,`status`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1577849805948882946','20221006103443566','1573652657841668098','Java经典入门教程','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/24dbedc9b4dacbed6c79d767b448cfea01d49c55.jpg','1573649616975462401','1574379079539421185','zbinyds','17674782491',0.01,1,0,0,'2022-10-06 10:34:43','2022-10-06 10:34:43'),
('1577850506934521857','20221006103730778','1573652657841668098','Java经典入门教程','https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/course/24dbedc9b4dacbed6c79d767b448cfea01d49c55.jpg','1573649616975462401','1574379079539421185','zbinyds','17674782491',0.01,1,0,0,'2022-10-06 10:37:31','2022-10-06 10:37:31');

/*Table structure for table `t_pay_log` */

DROP TABLE IF EXISTS `t_pay_log`;

CREATE TABLE `t_pay_log` (
  `id` char(19) NOT NULL DEFAULT '',
  `order_no` varchar(20) NOT NULL DEFAULT '' COMMENT '订单号',
  `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `total_fee` decimal(10,2) DEFAULT '0.01' COMMENT '支付金额（分）',
  `transaction_id` varchar(30) DEFAULT NULL COMMENT '交易流水号',
  `trade_state` char(20) DEFAULT NULL COMMENT '交易状态',
  `pay_type` tinyint NOT NULL DEFAULT '0' COMMENT '支付类型（1：微信 2：支付宝）',
  `attr` text COMMENT '其他属性',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_order_no` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支付日志表';

/*Data for the table `t_pay_log` */

/*Table structure for table `ucenter_member` */

DROP TABLE IF EXISTS `ucenter_member`;

CREATE TABLE `ucenter_member` (
  `id` char(19) NOT NULL COMMENT '会员id',
  `openid` varchar(128) DEFAULT NULL COMMENT '微信openid',
  `mobile` varchar(11) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint unsigned DEFAULT NULL COMMENT '性别 1 女，2 男',
  `age` tinyint unsigned DEFAULT NULL COMMENT '年龄',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `sign` varchar(100) DEFAULT NULL COMMENT '用户签名',
  `is_disabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否禁用 1（true）已禁用，  0（false）未禁用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员表';

/*Data for the table `ucenter_member` */

insert  into `ucenter_member`(`id`,`openid`,`mobile`,`password`,`nickname`,`sex`,`age`,`avatar`,`sign`,`is_disabled`,`is_deleted`,`gmt_create`,`gmt_modified`) values 
('1',NULL,'13700000001','96e79218965eb72c92a549dd5a330112','小三123',1,5,'http://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83eoj0hHXhgJNOTSOFsS4uZs8x1ConecaVOB8eIl115xmJZcT4oCicvia7wMEufibKtTLqiaJeanU2Lpg3w/132',NULL,0,0,'2019-01-01 12:11:33','2019-11-08 11:56:01'),
('1106833021442510849','o1R-t5lsGc3I8P5bDpHj7m_AIRvQ',NULL,NULL,'食物链终结者',NULL,NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/MQ7qUmCprK9am16M1Ia1Cs3RK0qiarRrl9y8gsssBjIZeS2GwKSrnq7ZYhmrzuzDwBxSMMAofrXeLic9IBlW4M3Q/132',NULL,0,0,'2019-03-16 16:22:11','2019-03-16 16:22:11'),
('1574379079539421185',NULL,'17674782491','96e79218965eb72c92a549dd5a330112','zbinyds',NULL,NULL,'https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg',NULL,0,0,'2022-09-26 20:43:18','2022-09-26 20:43:18'),
('1574691085966422018','o3_SC536iUoqFrcOdRsWs-KEX1Yo','',NULL,'渡己',NULL,NULL,'https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132',NULL,0,0,'2022-09-27 17:23:06','2022-09-27 17:23:06'),
('2',NULL,'15580215018','96e79218965eb72c92a549dd5a330112','小绵羊',NULL,NULL,'https://thirdwx.qlogo.cn/mmopen/vi_32/Z2g1ooEFJd3K0o7ESeIdzVVZL2ojibia0YPmTRTDAcicdqPkJQbyx8JGxne350SSlQLzs344HDnAicakyrRwBL9CGg/132',NULL,0,0,'2022-10-01 17:22:35','2022-10-01 17:22:37');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
