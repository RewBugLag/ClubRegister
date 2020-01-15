/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubregister;

/**
 *
 * @author rewbuglag
 */
public class Student {
    
    private long studentId;
    private String firstName;
    private String lastName;
    private String faculty;
    
    public Student(long studentId, String firstName, String lastName, String faculty) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
    }

    //Constrcutor create obj
    public Student(Student st){
        this.studentId = st.studentId;
        this.firstName = st.firstName;
        this.lastName = st.lastName;
        this.faculty = st.faculty;
    }

    //Edit
    public void setFirstName(String firstName) {
        if(this.firstName != null)this.firstName = firstName;
    }
    //Edit
    public void setLastName(String lastName) {
        if(this.lastName != null)this.lastName = lastName;
    }
    //Edit
    public void setFaculty(String faculty) {
        if(this.faculty != null)this.faculty = faculty;
    }

    public boolean equals(Student st) {
        if (st == null) {
            return false;
        }
        return (this.studentId == st.studentId) ? true : false;
    }

    public long getStudentId() {
        return studentId;
    }
    
    @Override
    public String toString() {
        return "Student { studentId: " + studentId + ", firstName: " + firstName + ", lastName: " + lastName + ", faculty: " + faculty + " }";
    }
    
}