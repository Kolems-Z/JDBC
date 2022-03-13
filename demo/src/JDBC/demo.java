package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ctrl+b 可以察看源码
 */

public class demo {
    public static void main(String[] args) throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2、建立连接          //ctrl+d 可以向下复制
        String url = "jdbc:mysql:///db1";     //jdbc:mysql://127.0.0.1:3306/db1(连接本机mysql服务器可以简写)
        String username = "root";
        String password = "111111";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3、定义sql语句
        String sql = "select * from user";
        //4、创建执行sql语句的statement对象
        Statement statement = connection.createStatement();
        //5、执行sql语句
        ResultSet resultSet = statement.executeQuery(sql);
        //6、处理结果
        while(resultSet.next()) {
            System.out.print(resultSet.getString(1));
            System.out.print(" ");
            System.out.print(resultSet.getInt(2));
            System.out.print(" ");
            System.out.print(resultSet.getInt(3));
            System.out.print(" ");
            System.out.print(resultSet.getString(4));
            System.out.print(" ");
            System.out.print(resultSet.getString(5));
            System.out.print(" ");
            System.out.println(resultSet.getInt(6));
        }
        //7、释放资源（关闭资源）
        statement.close();
        connection.close();
    }
}
