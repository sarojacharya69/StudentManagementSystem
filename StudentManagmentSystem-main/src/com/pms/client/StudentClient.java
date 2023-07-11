package com.pms.client;

import com.pms.exception.ExceptionSMS;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentClient{
public static void main(String[]args) throws SQLException,
        ExceptionSMS {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("======================================================");
        System.out.println("                1)Student                              ");
        System.out.println("                2)exit                                  ");
        System.out.println("========================================================");
        System.out.print("Enter the choice=");

        int choice=sc.nextInt();
        switch(choice){
        case 1:
        StudentDetails.StudentDetailMenu();
        break;
        case 2:
        System.out.println("*******************Thanks For Using Apps****************");
        System.exit(0);

default:
        System.out.println("Enter 1 to 2 ");
        }}}}




