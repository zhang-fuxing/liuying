
## 一个支持达梦数据库和mysql数据库的springboot3的使用docker-compose的项目框架
描述：
使用springboot3.x 和 mybatis-plus

支持多数据库多数据源，多数据源配置在commons/db下，使用动态数据源需要在启动类添加 `@Import(DataSourceProvide.class)`

支持使用模板引擎进行数据交互

使用docker-compose进行环境搭建，搭建环境简单

使用maven版本为3.8.x

使用jdk为17

> 如果使用达梦数据库（或者其他只有驱动jar的数据库）需要，执行一下命令将jar安装到本地maven仓库，方便在项目中使用它
```shell
mvn install:install-file -Dfile=./lib/DmJdbcDriver18.jar -DgroupId=com.dameng -DartifactId=DmJdbcDriver18 -Dversion=18.x -Dpackaging=jar
```

> 启动compose.yaml中配置的docker镜像环境
```shell
# 启动docker安装的数据库服务
docker-compose -f compose.yaml up -d
```
> 停止并删除 compose.yaml 中配置的容器实例
```shell
# 关闭docker安装的数据库服务
docker-compose -f compose.yaml down
```

> 如果修改了启动类的类路径，那么对应启动类模块下的打包插件也需要修改