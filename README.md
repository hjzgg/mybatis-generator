# mybatis-generator
MyBatis-generator 自动生成MyBatis代码

如果想要自动生成注释，请修改 generatorConfig.xml配置

 <!-- 生成文件的注释，type里写的是你的实现类的类全路径 -->
<commentGenerator type="com.hjzgg.generate.MyCommentGenerator">
    <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
    <property name="suppressAllComments" value="true"/>
    <property name="suppressDate" value="true"/>
</commentGenerator>
