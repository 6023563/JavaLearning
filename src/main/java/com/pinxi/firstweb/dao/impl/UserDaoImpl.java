package com.pinxi.firstweb.dao.impl;

import com.pinxi.firstweb.dao.UserDao;
import com.pinxi.firstweb.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        User resultUser = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb", "root", "123456");
            pstmt = conn.prepareStatement("select * from user where name = ? and password = ?");
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            rs = pstmt.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    resultUser = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultUser;
    }
}
