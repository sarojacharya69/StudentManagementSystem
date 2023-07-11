package com.pms.client;
import com.pms.exception.ExceptionSMS;
import com.pms.admin.dao.impl.StudentDaoImpl;
import com.pms.model.Student;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetails {

    static StudentDaoImpl studentDao=new StudentDaoImpl();
        public static void StudentDetailMenu() throws SQLException, ExceptionSMS {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("=====================================================");
                System.out.println("                1)AddStudent                         ");
                System.out.println("                2)ViewAllStudent                     ");
                System.out.println("                3)ViewStudent                         ");
                System.out.println("                4)UpdateStudent                       ");
                System.out.println("                5)DeleteStudent                       ");
                System.out.println("                6)Back                                ");
                System.out.println("======================================================");
                System.out.print("Enter the choice=");
                int choice = sc.nextInt();
                switch (choice) {


                    case 1:

                        System.out.println("Enter Student Name=");
                        String sname=sc.next();
                        System.out.println("Enter Student Address=");
                        String sadd=sc.next();
                        Student stu=new Student(sname,sadd);
                        studentDao.addStudent(stu);
                        break;
                    case 2:

                        for (Student pro : studentDao.viewAllUserInfo()){
                            System.out.println("sno: " + pro.getSno() + ", Name: " + pro.getSname() + ", Address: " +
                                    pro.getSaddress());

                        }

                        break;

                    case 3:
                        System.out.println("Enter Student sno=");
                        int no=sc.nextInt();
                        studentDao.viewStudent(no);
                        break;

                    case 4:

                        System.out.println("Enter Student sno for update");
                        int sno=sc.nextInt();
                        studentDao.updateStudent(sno);
                        break;
                    case 5:
                        System.out.println("Enter Student sno for Delete");
                        int ssno=sc.nextInt();
                        studentDao.deleteStudent(ssno);
                        break;

                    case 6:
                        StudentClient.main(null);
                        break;
                    default:
                        System.out.println("Choose 1 to 6 Between");

                }
            }
        }

    }




