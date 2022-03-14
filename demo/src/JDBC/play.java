package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class play {
    public static void main(String[] args) throws Exception {
        //1、注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2、获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1", "root", "111111");

        //3、定义sql语句
        String sql = "update user set number=20115132 where name=\"张奥运\"";

        //4、获取执行sql的对象Statement
        Statement stmt = connection.createStatement();

        //5、执行sql语句
        int count = stmt.executeUpdate(sql);

        //6、处理结果
        System.out.println(count);
        System.out.println(count);

        //7、释放资源
        stmt.close();
        connection.close();

    }
}
