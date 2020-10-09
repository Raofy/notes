 echo -e "========================开始安装mysql5.7.25========================"
	  yum install -C -y mysql-community-server
	  systemctl start mysqld
	  systemctl enable mysqld
	  systemctl daemon-reload
	  grep 'temporary password' /var/log/mysqld.log
	  echo && read -e -p "请输入mysql初始化的随机密码（在root@localhost:后为初始密码）：" mysql_pwd
	  echo && read -e -p "请输入要设置的数据库密码：" mysql_new_pwd
	  echo -e "开始设置数据库密码"
	  
	  
	  
	  mysql --connect-expired-password -uroot -p$mysql_pwd <<EOF

SET PASSWORD = PASSWORD('$mysql_new_pwd');
ALTER USER 'root'@'localhost' PASSWORD EXPIRE NEVER;
FLUSH PRIVILEGES;
EOF
	  if [ $? -ne 0 ]; then

			echo "数据库密码设置失败，请检查初始随机密码是否输入错误（注意大小写），请重试"

	  else

			echo "========================设置数据库密码成功========================"

	  fi
	  
	  echo -e "========================开始设置数据库远程连接访问========================"
	  mysql --connect-expired-password -uroot -p$mysql_new_pwd <<EOF
USE mysql;
update user set host = '%' where user = 'root';	  
FLUSH PRIVILEGES;
EOF
	  
	  echo -e "========================开始创建数据库========================"
	  mysql --connect-expired-password -uroot -p$mysql_new_pwd <<EOF
CREATE DATABASE IF NOT EXISTS datafilter;
USE datafilter;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `page` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `extra` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
EOF