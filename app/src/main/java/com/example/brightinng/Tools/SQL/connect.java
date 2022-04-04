package com.example.brightinng.Tools.SQL;



import android.text.TextUtils;

import com.example.brightinng.Login_Activity;
import com.mysql.jdbc.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connect {
    public static Connection getConnection(String dbName) throws SQLException {
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver"); //加载驱动
            String ip = "180.76.227.211";
            conn =(Connection) DriverManager.getConnection(
                    "jdbc:mysql://" + ip + ":3306/" + dbName,
                    "rdsroot", "yxzh@1412");

           Login_Activity.conn_on=1;//用于向主函数传参，判断连接是否成功

        }catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

            Login_Activity.conn_on=2;//用于向主函数传参，判断连接是否成功
        }
        return conn;//返回Connection型变量conn用于后续连接
    }



    public static int insertIntoData(final String username, final String password) throws SQLException {//增加数据
        Connection  conn = null;
        conn = getConnection("yxzh");
        //使用DriverManager获取数据库连接
        Statement stmt = conn.createStatement();
        //使用Connection来创建一个Statment对象
        String sql = "insert INTO user (username,password)VALUES('"+username+"','"+password+"')";//把用户名和密码插入到数据库中
        stmt.executeUpdate(sql);
        return 0;
        //执行DML语句，返回受影响的记录条数
    }



    public static String querycol(final String id) throws SQLException {//读取某一行
        //加载数据库驱动
        String a;
        Connection  conn = null;
        conn = getConnection("yxzh");
        //使用DriverManager获取数据库连接
        Statement  stmt = conn.createStatement();
        //使用Connection来创建一个Statment对象
        ResultSet rs =stmt.executeQuery(
                "select password from user where username='"+id+"'");//从数据库中查询用户名对应的密码并返回
        rs.first();
        a=rs.getString("password");

        rs.close();
        return a;
        //把查询结果输出来
    }


    public static int updateData(final String col, final int key,final String name) throws SQLException {//修改数据
        Connection  conn = null;
        conn = getConnection("yxzh");
        //使用DriverManager获取数据库连接
        Statement  stmt = conn.createStatement();
        //使用Connection来创建一个Statment对象
        String sql = "UPDATE user SET "+col+"='"+key+"' WHERE number=name'";//修改的sql语句
        return stmt.executeUpdate(sql);//返回的同时执行sql语句，返回受影响的条目数量，一般不作处理
    }

    public static void delete(final String number1)throws SQLException{   //删除数据
        Connection  conn = null;
        conn = getConnection("yxzh");
        //使用DriverManager获取数据库连接
        Statement  stmt = conn.createStatement();
        //使用Connection来创建一个Statment对象
        String sql = "DELETE FROM user WHERE number='"+number1+"'";    // 写删除的SQL语句
        stmt.executeUpdate(sql);//返回的同时执行sql语句，返回受影响的条目数量，一般不作处理
    }


}
