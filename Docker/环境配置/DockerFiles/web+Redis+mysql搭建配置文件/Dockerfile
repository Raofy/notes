#引入MySQL基础镜像
FROM mysql:5.7

#添加工程文件
ADD ./spider-server-datafiltration-1.0.0.jar .

#添加jdk
COPY ./jdk-8u251-linux-x64.tar.gz /usr/local/java/

#添加Redis配置文件
ADD ./redis.conf /usr/local/etc/redis/

#安装Redis
# add our user and group first to make sure their IDs get assigned consistently, regardless of whatever dependencies get added
#RUN groupadd -r -g 100 redis && useradd -r -g redis -u 100 redis

# grab gosu for easy step-down from root
# https://github.com/tianon/gosu/releases
ENV GOSU_VERSION 1.12
RUN set -eux; \
	savedAptMark="$(apt-mark showmanual)"; \
	apt-get update; \
	apt-get install -y --no-install-recommends ca-certificates dirmngr gnupg wget; \
	rm -rf /var/lib/apt/lists/*; \
	dpkgArch="$(dpkg --print-architecture | awk -F- '{ print $NF }')"; \
	wget -O /usr/local/bin/gosu "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch"; \
	wget -O /usr/local/bin/gosu.asc "https://github.com/tianon/gosu/releases/download/$GOSU_VERSION/gosu-$dpkgArch.asc"; \
	export GNUPGHOME="$(mktemp -d)"; \
	gpg --batch --keyserver hkps://keys.openpgp.org --recv-keys B42F6819007F00F88E364FD4036A9C25BF357DD4; \
	gpg --batch --verify /usr/local/bin/gosu.asc /usr/local/bin/gosu; \
	gpgconf --kill all; \
	rm -rf "$GNUPGHOME" /usr/local/bin/gosu.asc; \
	apt-mark auto '.*' > /dev/null; \
	[ -z "$savedAptMark" ] || apt-mark manual $savedAptMark > /dev/null; \
	apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false; \
	chmod +x /usr/local/bin/gosu; \
	gosu --version; \
	gosu nobody true

ENV REDIS_VERSION 6.0.5
ENV REDIS_DOWNLOAD_URL http://download.redis.io/releases/redis-6.0.5.tar.gz
ENV REDIS_DOWNLOAD_SHA 42cf86a114d2a451b898fcda96acd4d01062a7dbaaad2801d9164a36f898f596

RUN set -eux; \
	\
	savedAptMark="$(apt-mark showmanual)"; \
	apt-get update; \
	apt-get install -y --no-install-recommends \
		ca-certificates \
		wget \
		\
		gcc \
		libc6-dev \
		libssl-dev \
		make \
	; \
	rm -rf /var/lib/apt/lists/*; \
	\
	wget -O redis.tar.gz "$REDIS_DOWNLOAD_URL"; \
	echo "$REDIS_DOWNLOAD_SHA *redis.tar.gz" | sha256sum -c -; \
	mkdir -p /usr/src/redis; \
	tar -xzf redis.tar.gz -C /usr/src/redis --strip-components=1; \
	rm redis.tar.gz; \
	\
# disable Redis protected mode [1] as it is unnecessary in context of Docker
# (ports are not automatically exposed when running inside Docker, but rather explicitly by specifying -p / -P)
# [1]: https://github.com/antirez/redis/commit/edd4d555df57dc84265fdfb4ef59a4678832f6da
	grep -E '^ *createBoolConfig[(]"protected-mode",.*, *1 *,.*[)],$' /usr/src/redis/src/config.c; \
	sed -ri 's!^( *createBoolConfig[(]"protected-mode",.*, *)1( *,.*[)],)$!\10\2!' /usr/src/redis/src/config.c; \
	grep -E '^ *createBoolConfig[(]"protected-mode",.*, *0 *,.*[)],$' /usr/src/redis/src/config.c; \
# for future reference, we modify this directly in the source instead of just supplying a default configuration flag because apparently "if you specify any argument to redis-server, [it assumes] you are going to specify everything"
# see also https://github.com/docker-library/redis/issues/4#issuecomment-50780840
# (more exactly, this makes sure the default behavior of "save on SIGTERM" stays functional by default)
	\
	export BUILD_TLS=yes; \
	make -C /usr/src/redis -j "$(nproc)" all; \
	make -C /usr/src/redis install; \
	\
# TODO https://github.com/antirez/redis/pull/3494 (deduplicate "redis-server" copies)
	serverMd5="$(md5sum /usr/local/bin/redis-server | cut -d' ' -f1)"; export serverMd5; \
	find /usr/local/bin/redis* -maxdepth 0 \
		-type f -not -name redis-server \
		-exec sh -eux -c ' \
			md5="$(md5sum "$1" | cut -d" " -f1)"; \
			test "$md5" = "$serverMd5"; \
		' -- '{}' ';' \
		-exec ln -svfT 'redis-server' '{}' ';' \
	; \
	\
	rm -r /usr/src/redis; \
	\
	apt-mark auto '.*' > /dev/null; \
	[ -z "$savedAptMark" ] || apt-mark manual $savedAptMark > /dev/null; \
	find /usr/local -type f -executable -exec ldd '{}' ';' \
		| awk '/=>/ { print $(NF-1) }' \
		| sort -u \
		| xargs -r dpkg-query --search \
		| cut -d: -f1 \
		| sort -u \
		| xargs -r apt-mark manual \
	; \
	apt-get purge -y --auto-remove -o APT::AutoRemove::RecommendsImportant=false; \
	\
	redis-cli --version; \
	redis-server --version

#RUN mkdir /data
#RUN mkdir /data/redis && chmod -R 777 /data/redis
#RUN mkdir /data/mysql && chmod -R 777 /data/mysql
#VOLUME /data/redis
#VOLUME /data/mysql
#WORKDIR /data

#COPY ./docker-entrypoint.sh /usr/local/bin/


#添加jdk安装配置脚本
ADD ./jdk-install.sh .
#安装配置jdk
RUN ./jdk-install.sh /usr/local/java/jdk-8u251-linux-x64.tar.gz
ENV JAVA_HOME=/usr/local/jdk/jdk1.8.0_251
ENV PATH=$PATH:/usr/local/jdk/jdk1.8.0_251/bin
ENV CLASSPATH=.:/usr/local/jdk/jdk1.8.0_251/lib/dt.jar:/usr/local/jdk/jdk1.8.0_251/lib/tools.jar
#RUN tar -zxvf ./jdk-8u251-linux-x64.tar.gz /usr/local/jdk/
#RUN echo "export JAVA_HOME=/usr/local/jdk/1.8.0_251" >> /etc/profile
#RUN echo "export PATH=\$PATH:/usr/local/jdk/1.8.0_251/bin" >> /etc/profile
#RUN echo "export CLASSPATH=.:/usr/local/jdk/1.8.0_251/lib/dt.jar:/usr/local/jdk/1.8.0_251/lib/tools.jar" >> /etc/profile

#RUN echo "JDK 安装配置完成"
#RUN source /etc/profile
#RUN echo `java -version`

#赋予全部权限
RUN chmod 777 jdk-install.sh
RUN chmod 777 *.sh
RUN chmod 777 ./*.sh
RUN mkdir /home/mysql
RUN chmod 777 -R /home/mysql
RUN chmod 777 /etc/profile
RUN . /etc/profile

#设置不需要密码登录root
#ENV MYSQL_ALLOW_EMPTY_PASSWORD yes
#ENV MYSQL_ROOT_HOST "127.0.0.1"
#ENV MYSQL_ROOT_PASSWORD "123456"

#添加数据库设置的脚本文件
#ADD ./setup.sh .
#ADD ./schema.sql .
#ADD ./privileges.sql .
#ADD ./mysql.sh .
#初始化建立数据库和数据表
#RUN ./mysql.sh
#ADD ./init.sql /docker-entrypoint-initdb.d/
ADD ./init.sql .
ADD ./init.sh .


#mysql配置文件
ADD ./mysqld.cnf /etc/mysql/mysql.conf.d/

COPY ./docker-entrypoint.sh /usr/local/bin/
ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]

EXPOSE 6379
EXPOSE 5000
EXPOSE 3306

#启动项目工程
#CMD ["java", "-jar", "spider-server-datafiltration-1.0.0.jar"]

