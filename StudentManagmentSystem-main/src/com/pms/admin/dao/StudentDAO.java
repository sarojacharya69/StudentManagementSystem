package com.pms.admin.dao;

import com.pms.exception.ExceptionSMS;
import com.pms.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    public String addStudent(Student sb) throws SQLException, ExceptionSMS;

    public List<Student> viewAllUserInfo() throws SQLException, ExceptionSMS;
    Student viewStudent(int sno) throws SQLException, ExceptionSMS;
    int updateStudent(int sn) throws SQLException, ExceptionSMS;
    int deleteStudent(int sno) throws SQLException, ExceptionSMS;

}
