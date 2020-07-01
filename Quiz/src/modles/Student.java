/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modles;

/**
 *
 * @author Md Ataullha
 */
public class Student {
    private String studentName;
    private String regNo;

    public Student(String studentName, String regNo) {
        this.studentName = studentName;
        this.regNo = regNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "Student{" + "studentName=" + studentName + ", regNo=" + regNo + '}';
    }
    
}
