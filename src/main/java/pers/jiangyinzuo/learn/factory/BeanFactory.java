package pers.jiangyinzuo.learn.factory;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean: 可重用组件
 * JavaBean: 用Java语言编写的可重用组件，包括实体类等
 * <p>
 * BeanFactory: 创建service和dao对象
 * <p>
 * 1. 需要一个配置文件配置service和dao
 * 配置内容：唯一标识->全限定类名(key->value)
 * 配置文件可以是xml或者properties
 * 2. 通过读取配置文件中配置的内容，反射创建对象
 */
public class BeanFactory {

    // 定义一个properties对象
    private static Properties props = new Properties();

    // 定义一个Map, 用于存放要创建的对象，称之为容器
    private static Map<String, Object> beans = new HashMap<>();

    // 使用静态代码块为Properties对象赋值
    static {
        // 获取properties流对象
        try (InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties")) {

            assert in != null;
            props.load(in);

            // 取出配置文件中所有的key
            Enumeration keys = props.keys();

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }

    /**
     * 工厂模式根据Bean名称获取bean对象
     * 单例的对象
     *
     * @return
     */
    public static Object getBean(String beanName) {
        if (beans.get(beanName) == null) {
            try {
                createBean(beanName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return beans.get(beanName);
    }

    private static void createBean(String beanName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String beanPath = props.getProperty(beanName);

        // 反射创建对象
        Object value = Class.forName(beanPath).getConstructor().newInstance();

        // 把key和value存入容器中
        beans.put(beanName, value);
    }
}
