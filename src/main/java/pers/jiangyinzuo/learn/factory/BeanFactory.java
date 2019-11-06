package pers.jiangyinzuo.learn.factory;

import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean: 可重用组件
 * JavaBean: 用Java语言编写的可重用组件，包括实体类等
 *
 * BeanFactory: 创建service和dao对象
 *
 * 1. 需要一个配置文件配置service和dao
 *      配置内容：唯一标识->全限定类名(key->value)
 *      配置文件可以是xml或者properties
 * 2. 通过读取配置文件中配置的内容，反射创建对象
 */
public class BeanFactory {

    // 定义一个properties对象
    private static Properties props;

    // 使用静态代码块为Properties对象赋值
    static {
        // 实例化对象
        props = new Properties();
        try {
            // 获取properties流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            assert in != null;
            props.load(in);
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 工厂模式根据Bean名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
