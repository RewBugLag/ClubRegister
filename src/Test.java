import java.util.InputMismatchException;
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

    public static void main(String[] args) {
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    newClub();
                    System.out.println("---Create New Club---");
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
        System.out.print("Enter Your Menu[1-6]: ");

        int selected = inputInt();
        sc.nextLine(); // for clearing ENTER hitted by nextInt()
        return selected;
    }

    public static boolean newClub() {
        if (c1 != null) {
            System.out.println("Club has already been created!");
            return false;
        }

        String clubName;
        do {
            System.out.print("Enter clubname: ");
            clubName = sc.nextLine();
        } while (clubName.equals(""));

        String shortName;
        do {
            System.out.print("Enter shortname: ");
            shortName = sc.nextLine();
        } while (shortName.equals(""));

        int maximum;
        do {
            System.out.print("Enter maximum: ");
            maximum = inputInt();
            if (maximum <= 0) {
                System.out.println("Please enter maximum's number again.");
            }
        } while (maximum <= 0);

        c1 = new Club(clubName, shortName, maximum);
        return true;
    }

    public static boolean join() {
        if (c1 == null) {
            System.out.println("Sorry, there is no club to join here.");
            return false;
        } if (c1.isFull()) {
            System.out.println("Sorry, our club still close.");
            return false;
        }
        
        System.out.print("Enter studentId: ");
        long studentId = inputStudentId();
        sc.nextLine(); // for clearing ENTER hitted by nextInt()
        if (c1.findMember(studentId)) {
            System.out.println("Sorry, You have already subscribed our club.");
            return false;
        }
        
        String firstName;
        do {
            System.out.print("Enter firstName: ");
            firstName = sc.nextLine();
        } while (firstName.equals(""));
        
        String lastName;
        do {
            System.out.print("Enter lastName: ");
            lastName = sc.nextLine();
        } while (lastName.equals(""));
        
        String faculty;
        do {
            System.out.print("Enter faculty: ");
            faculty = sc.nextLine();
        } while (faculty.equals(""));
        
        
        if (c1 != null && c1.subscribe(studentId, firstName, lastName, faculty)) {
            System.out.println("You have subscribed our club!");
        }
        return true;
    }

    public static boolean leave() {
        if (c1 == null) {
            System.out.println("Sorry, there is no club here.");
            return false;
        }
        System.out.print("Enter studentId: ");
        long studentId = inputStudentId();
        sc.nextLine(); // for clearing ENTER hitted by nextInt()

        if (c1.unsubscribe(studentId)) {
            System.out.println("You have unsubscribed our club. :(");
            return true;
        }
        System.out.println("Sorry, You haven't subcribed our club yet.");
        return false;
    }

    public static boolean edit() {
        if (c1 == null) {
            System.out.println("Sorry, there is no club here.");
            return false;
        }

        System.out.print("Enter studentId: ");
        long studentId = inputStudentId();
        sc.nextLine(); // for clearing ENTER hitted by nextInt()
        if (!c1.findMember(studentId)) {
            System.out.println("Sorry, You haven't subscribed our club yet.");
            return false;
        }
        
        String firstName;
        do {
            System.out.print("Enter firstName: ");
            firstName = sc.nextLine();
        } while (firstName.equals(""));
        
        String lastName;
        do {
            System.out.print("Enter lastName: ");
            lastName = sc.nextLine();
        } while (lastName.equals(""));
        
        String faculty;
        do {
            System.out.print("Enter faculty: ");
            faculty = sc.nextLine();
        } while (faculty.equals(""));

        c1.editInformation(studentId, firstName, lastName, faculty);
        System.out.println("Your information has been edited!");
        return true;
    }

    public static void list() {
        if (c1 != null) {
            c1.listAllMember();
        }
    }

    public static int inputInt() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Please enter a number: ");
                sc.next(); // clear scanner wrong input
                continue;
            }
        }
    }

    public static long inputStudentId() {
        while (true) {
            try {
                long input;
                do {
                    input = sc.nextLong();
                    if (input < 0) {
                        System.out.println("Invalid student ID!");
                        System.out.print("Enter studentId: ");
                    }
                } while (input < 0);
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a number: ");
                sc.next(); // clear scanner wrong input
                continue;
            }
        }
    }
}