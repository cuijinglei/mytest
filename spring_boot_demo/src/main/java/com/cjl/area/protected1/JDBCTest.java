package com.cjl.area.protected1;

import java.lang.reflect.Field;
import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, NoSuchFieldException, IllegalAccessException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/our?useCursorFetch=true","root","root");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from student",ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setFetchSize(Integer.MIN_VALUE);
        boolean execute = preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        System.out.println(resultSet.getClass());
        Field rowData = resultSet.getClass().getSuperclass().getDeclaredField("rowData");
        rowData.setAccessible(true);
        Object o = rowData.get(resultSet);
        System.out.println(o.getClass());

        switch (o.getClass().getName()){
            case "com.mysql.cj.protocol.a.result.ResultsetRowsStatic":
                System.out.println("普通查询");
                break;
            case "com.mysql.cj.protocol.a.result.ResultsetRowsStreaming":
                System.out.println("流式查询");
                break;
            case "com.mysql.cj.protocol.a.result.ResultsetRowsCursor":
                System.out.println("游标查询");
                break;
            default:
                System.out.println("---");
                break;
        }

        while (resultSet.next()){
            //System.out.println(resultSet.getString(2));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
