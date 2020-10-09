#!/bin/bash

mkdir /data
mkdir /data/redis && chmod -R 777 /data/redis
mkdir /data/mysql && chmod -R 777 /data/mysql
chmod -R 777 /var/lib/mysql
echo "启动Mysql"
service mysql start

echo "登录MySQL数据库"
mysql -u root -p123456<< EOF
use mysql;
set password =password('123456');
grant all privileges on *.* to 'root'@'%' identified by '123456';
set global time_zone = '+8:00';
set time_zone = '+8:00';
flush privileges;
CREATE DATABASE IF NOT EXISTS datafilter;
USE datafilter;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE IF NOT EXISTS records  (
  id int(11) NOT NULL AUTO_INCREMENT,
  page varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  value varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  extra varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  time timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (id) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;
exit;
EOF
echo "修改成功"

service mysql restart

echo "-------启动redis和工程文件-------"

exec redis-server /usr/local/etc/redis/redis.conf&
java -jar spider-server-datafiltration-1.0.0.jar
