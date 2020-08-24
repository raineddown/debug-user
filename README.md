# debug-user
大三实训项目————建筑行业协会参评平台系统，个人负责的用户操作部分。前后端不分离，前端模板体积较大。涉及技术：spingMVC+springboot+mybatis+Thyemleaf
<font color=ff0000 size=12 face="宋体">注意：人脸识别接口调用的是百度的API且sk、ak、groupId都已删除。时间关系人脸识别的业务逻辑未对应到相应实体只做了人脸库匹配判断，人脸识别部分包路径：com.design.user.face_login</font>

## 项目技术介绍
项目使用ssm(springMVC+springBoot+mybatis)框架,restful风格,使用thymeleaf模板引擎进行对象传输，调用了百度云的人脸识别接口，对前端模板js进行了调控，部分页面动态显示数据库数据。

## 文件夹介绍
1.debug-user:java项目，其中分为2个modules,主体业务以及申报条件查询业务。
2.md-pictures:项目介绍图片。
3.demoVideo:项目演示视频。

## 演示图片
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/1.png)
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/2.png)
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/3.png)
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/4.png)
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/5.png)
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/6.png)
![Image](https://github.com/raineddown/debug-user/blob/master/md-pictures/7.png)
