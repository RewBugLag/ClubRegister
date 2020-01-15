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
    
    public Student(long studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
