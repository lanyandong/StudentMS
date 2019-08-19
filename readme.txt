利用 hibernate+struts2 框架完成学生信息管理项目

准备环境：
Struts2.3 + hibernate3.0 + MySQL5.0

实现功能：
1、管理员用户的登录注册
2、学生信息的增删改查


具体做法：
1、准备好需要的核心jar包
  包括：hibernate-core包，struts2-core包，mysql驱动包 junit单元测试包。


2、使用eclipse创建动态web项目
  注意配置web容器（tomcat），以及生成对应的web.xml

3、导入jar包
  直接将需要的jar包导入WEB-INF目录下的lib中

4、配置struts环境
  修改web.xml,配置过滤器
  创建struts.xml 并将文件保存在Java Resources 下的src目录下.

5、hibernate相关配置
  创建hibernate.cfg.xml文件,并将文件保存在Java Resources 下的src目录下, 配置property属性。


6、创建实体类User和Students
  User（uid， username， password）
  Students（sid，sname，gender，birthday，address）
  将属性封装，保留不带参数的构造方法，生成一个带参数的构造方法。

7、将实体类的属性映射到数据库中（entity）
  在实体类的包下新建对应的hbm.xml文件，再配置hbm.xml的属性
  hibernate.cfg.xml中的mapping需要指定到两个实体类的xml中


8、管理员用户登录模块

   设计用户接口和实现类（service）
	用户接口：用户登录方法，用户注销方法      
	用户实现类：重写接口中的方法（try-catch-finally）       
	用@test 来测试用户的功能（junit）

   设计Action父类
	继承ActionSupport 并且实现接口ServletRequestAware, ServletResponseAware, ServletContextAware
	可以用web的内置对象

   创建MyHibernateSessionFactory 
	通过构造方法保证单例模式，创建公有的静态方法来获得工厂对象。

   设计用户的Action类（继承Action父类），
	使用模型驱动接受表单数据，并注册Struts2.xml。
	修改JSP页面提交，通过过滤执行对应的Action方法，并返回对应的视图

   表单的提交的action用绝对路径
	action="<%=path%>/users/Users_login.action"这要和功能的名字相同（UserAction下的login方法）
	用户登录验证用validate方法 但是会对所有的action都验证 可以通过在方法前加@SkiValidation来避免验证
	

11、学生信息管理模块

  设计学生接口和实现类
	学生接口包括学生信息的查询，添加，修改，删除
	实现接口，重写接口中的方法（注意面向接口编程的的特点），并通过创建单元测试用例进行验证
	注意hql语句的编写

  创建学生Action，同样继承自Action父类
	创建业务逻辑的实现方法，调用学生接口实现类对象，并执行对应的方法。

  基本过程流程
 	设计学生业务逻辑接口
        设计学生接口实现类（接口方法）（try - catch - finally）
        设计学生Action动作（显示学生资料,添加，修改，删除）
        注册Struts2.xml
        页面调用

   

	














