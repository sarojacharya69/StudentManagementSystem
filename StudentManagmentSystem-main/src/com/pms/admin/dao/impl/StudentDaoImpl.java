package com.pms.admin.dao.impl;

import com.pms.admin.dao.StudentDAO;

import com.pms.configure.ConnectionManager;
import com.pms.exception.ExceptionSMS;
import com.pms.model.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static com.pms.query.QueryConstants.*;

public class StudentDaoImpl implements StudentDAO {

    private Connection connection=null;//(I)
    private ResultSet resultSet = null;//(I)
    private PreparedStatement preparedStatement = null;//(I)
    Scanner sc = new Scanner(System.in);
    static List<Student> studentList = new LinkedList<>();
    int row = 0;

    @Override
    public String addStudent(Student student) throws SQLException {
             String sms="";
        try {
            connection= ConnectionManager.getConnection();//Connection
            preparedStatement =connection.prepareStatement(STUDENT_INSERT_QUERY);//Statement
            preparedStatement.setString(1, student.getSname());//set value
            preparedStatement.setString(2, student.getSaddress());
            row = preparedStatement.executeUpdate();//Execute

            if (row > 0) {
                throw new ExceptionSMS("Student Added Successfully");
            } else {
                throw new ExceptionSMS("Student Failed to Add");
            }
        } catch (ExceptionSMS e) {
            sms=e.getMessage();
            System.out.println(sms);
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }

        return sms;
    }

    @Override
    public List<Student> viewAllUserInfo() throws SQLException {
        try {
            connection=ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(STUDENT_SELECT_QUERY);//2
            resultSet = preparedStatement.executeQuery();//3
            while (resultSet.next()) {
                int sno = resultSet.getInt(1);
                String sname = resultSet.getString(2);
                String sadds = resultSet.getString(3);
                Student stu = new Student(sno, sname, sadds);
                studentList.add(stu);
                row++;
            }
            if (row != 0) {
                throw new ExceptionSMS("View All Student Successfully");
            } else {
                throw new ExceptionSMS("Student  are not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());

        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }

        return studentList;
    }

    @Override
    public Student viewStudent(int no) throws SQLException {
        String student = null;
        try {
            connection=ConnectionManager.getConnection();//1
            preparedStatement = connection.prepareStatement(STUDENT_SELECT_QUERY_with_sno);//2
            preparedStatement.setInt(1, no);//set value to sno
            resultSet = preparedStatement.executeQuery();//3
            if (resultSet.next()) {
                int sno = resultSet.getInt(1);
                String sname = resultSet.getString(2);
                String sadds = resultSet.getString(3);
                System.out.println("sno: " + sno + ", Name: " + sname + ", Address: " +
                        sadds);
                throw new ExceptionSMS("Student View Successfully");
            } else {
                throw new ExceptionSMS("Student not exit");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(resultSet, preparedStatement, connection);
        }
        return null;
    }
    @Override
    public int updateStudent(int sn) throws SQLException {

        try {
            connection=ConnectionManager.getConnection();//1
            System.out.println("Enter 1 for  for update name 2 for address=");
            int ch = sc.nextInt();
            if (ch == 1) {
                preparedStatement = connection.prepareStatement(STUDENT_updateQuerysname);//2
                System.out.println("Enter New Student name for update=");
                String sna = sc.next();
                preparedStatement.setString(1, sna);
                preparedStatement.setInt(2, sn);
            } else {
                preparedStatement = connection.prepareStatement(STUDENT_updateQuerysaddress);//2
                System.out.println("Enter New Student Address for update=");
                String address = sc.next();
                preparedStatement.setString(1, address);
                preparedStatement.setInt(2, sn);
            }

            row = preparedStatement.executeUpdate();//row update count//3
            if (row > 0) {
                throw new ExceptionSMS("Student info update Successfully");
            } else {
                throw new ExceptionSMS("Student info Failed to update");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }

        return row;
    }
    @Override
    public int deleteStudent(int sno) throws SQLException {
        try {
            connection=ConnectionManager.getConnection();//1
            final String deleteQuery = "DELETE FROM Student WHERE sno=?";
            preparedStatement = connection.prepareStatement(deleteQuery);//2
            preparedStatement.setInt(1, sno);
            row = preparedStatement.executeUpdate();//3
            if (row > 0) {
                throw new ExceptionSMS("Student Delete Successfully");
            } else {
                throw new ExceptionSMS("Student Failed to Delete");
            }
        } catch (ExceptionSMS e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionManager.closeconnection(connection, preparedStatement);
        }
        return 0;
    }
}

