package com.pms.query;

public interface QueryConstants {

    public String STUDENT_INSERT_QUERY="INSERT INTO Student (sname,saddress) VALUES (?,?)";

    public String STUDENT_SELECT_QUERY="SELECT * FROM Student";
    public String STUDENT_SELECT_QUERY_with_sno="select*from Student where sno=?";
    public String STUDENT_updateQuerysname = "UPDATE Student SET sname = ? WHERE sno =?";
    public String STUDENT_updateQuerysaddress = "UPDATE Student SET saddress = ? WHERE sno =?";
    public String STUDENT_deleteQuery = "DELETE FROM Student WHERE sno=?";






}
