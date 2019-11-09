package pers.jiangyinzuo.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类, 作用同bean.xml
 * Spring中的新注解
 * @Configuration: 指定当前类是配置类
 *      细节: 当配置类作为AnnotationConfigApplicationContext对象创建的参数时, 该对象可以不写注解
 * @ComponentScan: 用于通过注解指定Spring在创建容器中要扫描的包
 *      属性:
 *          value(basePackages)用于指定创建容器时要扫描的包
 *          使用此注解等同于在XML中配置了
 *          <context:component-scan base-package="pers.jiangyinzuo.learn" />
 *
 * @Bean: 用于把当前方法的返回值作为bean对象存入spring的IOC容器中
 *      属性:
 *          name: 指定bean的id, 默认值是当前方法名
 *      细节: 使用注解配置方法时, 若方法有参数, spring将从容器中查找有无可用的bean对象。
 *            查找方式和@Autowired一样。
 * @Import: 用于导入其它的配置类
 *      属性:
 *          value: 用于指定其它配置类的字节码
 *                 当我们使用Import的注解之后, 有Import注解的类就是父配置类, 导入的类是子配置类
 * @Value
 *
 * @PropertySource: 用于指定properties文件的位置
 *      属性:
 *          value: 指定文件的名称和路径。
 *              关键字:
 *                  classpath: 表示类路径下
 */

@Configuration
@Import(value = {JDBCConfig.class})
@ComponentScan("pers.jiangyinzuo.learn")
@PropertySource("classpath:JDBCConfig.properties")
public class SpringConfiguration {

}
