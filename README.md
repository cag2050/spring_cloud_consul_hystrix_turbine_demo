### 使用 Hystrix Turbine，聚合多个服务的Hystrix Dashboard的数据

### 步骤一：创建项目
1.参考：https://www.fangzhipeng.com/springcloud/2018/08/13/sc-f13-turbine.html

### 步骤二：编写代码
1. 启动类加入注解：@EnableHystrixDashboard、@EnableTurbine；
2. 编写 src/main/resources/application.properties 文件
3. 

### 步骤三：创建 Consul 容器
1.镜像官方网址：https://hub.docker.com/_/consul

2.pull 镜像：
```
docker pull consul:1.6.0
```
3.创建容器（默认http管理端口：8500）
```
docker run -p 8500:8500 consul:1.6.0
```
4.访问管理网址
```
http://localhost:8500/
```

### 步骤四：改造2个服务消费者
1. 2个服务消费者：https://github.com/cag2050/spring_cloud_consul_consumer2_ribbon_demo ，https://github.com/cag2050
/spring_cloud_consul_consumer3_feign_demo ，都做下面的操作
2. 引入依赖 spring-boot-starter-actuator、spring-cloud-starter-netflix-hystrix、spring-cloud-starter-netflix-hystrix-dashboard
3. src/main/resources/application.properties 中：1.配置 Actuator 监控；2.注释行`spring.cloud.consul.discovery.register=false
`，让应用注册到 consul
4. 启动类添加注解：@EnableHystrixDashboard


### 步骤五：使用 Hystrix Turbine，聚合多个服务的 Hystrix Dashboard 数据
1.项目：https://github.com/cag2050/spring_cloud_consul_consumer2_ribbon_demo，stream 数据：http://localhost:8504/actuator/hystrix.stream，dashboard地址：http://localhost:8504/hystrix

2.项目：https://github.com/cag2050/spring_cloud_consul_consumer3_feign_demo，stream 数据：http://localhost:8505/actuator/hystrix.stream，dashboard地址：http://localhost:8505/hystrix

3.启动本项目，打开浏览器输入：http://localhost:8506/turbine.stream ，可以不断出现类似文字：
```
: ping
data: {"reportingHostsLast10Seconds":0,"name":"meta","type":"meta","timestamp":1571651780736}
```
4.打开浏览器输入：http://127.0.0.1:8506/hystrix ，在界面Hystrix Dashboard文字下方输入框输入：http://localhost:8506/turbine.stream
 ，在图形化界面中，可以看到2个项目对应的dashboard。

### 注意点
1. Turbine 默认使用 Eureka 作为注册中心；如果使用 Consul 作为注册中心，需要排除掉 Eureka

### 参考
参考资料 | 网址
--- | ---
SpringCloud教程第13篇：Turbine(F版本) | https://www.fangzhipeng.com/springcloud/2018/08/13/sc-f13-turbine.html