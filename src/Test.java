import java.util.Scanner;
import clubregister.Club;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rewbuglag
 */
public class Test {

    private static Scanner sc = new Scanner(System.in);
    private static Club c1;
    // private static String clubName;
    // private static String shortName;
    // private static int maximum;

    public static void main(String[] args) {
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    newClub();
                    break;
                case 2:
                    join();
                    System.out.println("---Membership Subscribe---");
                    break;
                case 3:
                    edit();
                    System.out.println("---Edit Membership Information---");
                    break;
                case 4:
                    leave();
                    System.out.println("---Membership Unsubscribe---");
                    break;
                case 5:
                    list();
                    System.out.println("---List Members---");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice, please select 1-6 only");
            }
        } while (choice != 6);

    }
    
    //Menu
    private static int menu() {

        System.out.println("<<Menu>>");
        System.out.println("1. New Club");
        System.out.println("2. Membership Subscribe");
        System.out.println("3. Edit Membership Information");
        System.out.println("4. Membership Unsubscribe");
        System.out.println("5. List Members");
        System.out.println("6. Exit");
        System.out.println("");
        System.out.print("Enter Your Menu[1-6]:");
        int selected = sc.nextInt();

        return selected;
    }

    public static void newClub() {
        
        System.out.print("Enter clubname: ");
        String clubName = sc.next();

        System.out.print("Enter shortname: ");
        String shortName = sc.next();

        int maximum;
        while (true) {
            System.out.print("Enter maximum: ");
            maximum = sc.nextInt();
            if (maximum > 0) {
                break;
            }
        }
        
        c1 = new Club(clubName, shortName, maximum);

        System.out.println(clubName);
        System.out.println(shortName);
        System.out.println(maximum);
    }

    public static void join() {

        System.out.print("Enter studentId: ");
        long studentId = sc.nextLong();
        
        System.out.print("Enter firstName: ");
        String firstName = sc.next();

        System.out.print("Enter lastName: ");
        String lastName = sc.next();
        
        System.out.print("Enter faculty: ");
        String faculty = sc.next();
        
        if (c1 != null) {
            c1.subscribe(studentId, firstName, lastName, faculty);
        }
    }

    public static void leave() {
        System.out.print("Enter studentId: ");
        long studentId = sc.nextLong();

        if (c1 != null) {
            c1.unsubscribe(studentId);
        }
        
    }

    public static void edit() {
        
    }

    public static void list() {
        if (c1 != null) {
            c1.listAllMember();
        }
    }
}
// case 3 : edit() | edit specific studentId