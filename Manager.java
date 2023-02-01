package org.example.Day34PracticProblem;

import org.example.classByAmolMateSir.sqlDemo.Bridglab;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Manager {

    public static void quryRunnur(Employee employee) throws SQLException {

        Connection con = MyConnection.connection();
        String q = "select * from emplyeePayroll";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(q);

        List<Employee> employeeList = new ArrayList<>();

        while (resultSet.next()) {
            employee = new Employee();
            employee.setEmpID(resultSet.getInt(1));
            employee.setEmpName(resultSet.getString(2));
            employee.setPhoneNumber(resultSet.getString(3));
            employee.setAdress(resultSet.getString(4));
            employee.setDepartment(resultSet.getString(5));
            employee.setBasicPay(resultSet.getFloat(7));
            employee.setStartDate(resultSet.getDate(8));
            employee.setCity(resultSet.getString(9));
            employee.setContry(resultSet.getString(10));
            employeeList.add(employee);
        }
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
    }
}
