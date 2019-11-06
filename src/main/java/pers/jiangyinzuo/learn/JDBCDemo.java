package pers.jiangyinzuo.learn;


import java.sql.*;

/**
 * 程序的耦合
 * 耦合：程序间的依赖关系，包括
 *      1. 类之间的依赖
 *      2. 方法间的依赖
 * 解耦：降低程序间的依赖
 *      做到编译期不依赖，运行时才依赖
 *      解耦思路：
 *          1. 使用反射创建类对象，避免使用new关键字
 *          2. 通过读取配置文件获取要创建的对象全限定类名
 */
public class JDBCDemo {
    public static void main(String[] args) throws SQLException {

        // 1. 注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        // 2. 获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_learning?serverTimezone=GMT%2B8", "root", "ABCabc123!@#");

        // 3. 获取操作数据库的预处理对象
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM `account`");

        // 4. 执行SQL, 得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();

        // 5. 遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }

        // 6. 释放资源
        resultSet.close();
        preparedStatement.close();
        conn.close();

    }
}
