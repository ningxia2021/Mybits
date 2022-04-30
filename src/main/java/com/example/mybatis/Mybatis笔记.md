## 项目创建
1. 创建一个Spring项目 
    引入以下依赖：热加载、spring web、lombok、mybatis-framework、mysql-connector
2. 如果是已经开始的工程要加mybatis功能
    需要引入 mybatis-spring-boot-starter 依赖，spring可以实现灵活版本控制
3. 修改[application.properties]
    3.1 配置数据库连接信息
        [spring.datasource.url=jdbc:mysql://127.0.0.1:3306/mybatis?useUnicode=true&charactionEncoding=utf-8&useSSL=false]  
        [spring.datasource.username=root]  
        [spring.datasource.password=123456]  
        [spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver]  
    3.2 配置mybatis参数  (mapper.xml)
        在resource下新建mapper目录来存放mapper.xml 文件
        指定Mybatis表和实体映射关系的xml配置文件，包含表与实体映射，字段和属性的映射，以及各个sql语句.
        mybatis.mapper-locations 指定了映射文件路径
        [mybatis.mapper-locations=classpath:mapper/**Mapper.xml]
4. 添加Mybatis映射
    4.1 Dao层添加映射接口
        @Mapper -> 关联mapper.xml与接口
        接口中定义抽象方法
    4.2 定义xxxMapper.xml
        固定写法
            <?xml version="1.0" encoding="UTF-8" ?>
            <!DOCTYPE mapper
                    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
        定义映射关系，关联dao层被@Mapper接口
        [namespace] 是映射Dao层中的Mapper类
        [sql 中的id] 是用来映射接口方法名称
        [parameterType] 参数类型 (如果有多个参数，也可以不写参数类型)
        [定义sql语句 ,采用#{from}的方式实现动态传参 #{from}相当于 students.getName()]
            <mapper namespace = "com.example.mybatis.dao.studentMapper">
                <insert id="addStudent" parameterType="com.example.mybatis.dao.studentMapper">
                    insert into students values(#{id},#{name},#{age},#{sec});
                </insert>
            </mapper>     
5. 单元测试
    在dao层接口中，右键测试的方法->generate->Test 生成测试方法 -> 勾选Member中的测试方法-> OK
    此时还不可以直接执行，因为这个单元测试是依赖于Spring框架的
    因此，需要在测试类上加上@SpringBootTest, 这次再启动时就会加载spring框，加@Transactional 正常测试功能 但是不污染数据库
    
6. select
    [resultType 返回类型，如果实体类和数据库表的字段一致，则可以直接写引用对象的全路径,当然也可以不写]
        <select id="selectById" parameterType="com.example.mybatis.model.students" resultType="com.example.mybatis.model.students">
            select * from students where id = #{id};
        </select>
    [resultMap 结果的映射，针对表字段与实体类不统一的情况 这里的resultMap="BaseResultMap"  只是对这个xxMapper.xml中要操作的表与实体类映射进行命名
                        其映射关系需要单独构造]
        <select id="selectByName" resultMap="BaseResultMap">
            select * from students where name = #{name};
        </select>
    [resultMap的配置] 将表中字段(column) 与 实体类属性(property)相匹配 , 这就建立好了映射，表和实体类就一一对应了
        <resultMap id="BaseResultMap" type="com.example.mybatis.model.students">
                <id column="id" property="id"/>
                <result column="Student_Name" property="name"/>
                <result column="Student_Age" property="age"/>
                <result column="Student_Sec" property="sec"/>
        </resultMap>
7. #{} 与 ${} 的区别
    #{xx} 当转换成sql语句时，对里面的变量加了‘xx’，而${} 则 不会加''
    因此，当报错时候可以找一找这方面的原因，但是${}会引入sql 注入的问题!
8. [进阶]
    多表查询
        [一对一]
            
        [一对多]
        