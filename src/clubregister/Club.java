package clubregister;

public class Club {

    private String clubName;
    private String shortName;
    private int count;
    private int maximum;
    private int index;
    private Status status;
    private Student[] members;

    public Club(String clubName, String shortName, int maximum) {
        this.clubName = clubName;
        this.shortName = shortName;
        this.maximum = maximum;
        this.status = Status.OPEN;
        this.members = new Student[this.maximum];
    }

    public boolean subscribe(long studentId, String firstName, String lastName, String faculty) {
        if (status == Status.CLOSE || findMember(studentId)) {
            return false;
        }
        members[count++] = new Student(studentId, firstName, lastName, faculty);
        isFull();
        return true;
    }

    public boolean unsubscribe(long studentId) {
        for (int i = 0; i < count; i++) {
            if (studentId == members[i].getStudentId()) {
                for (int j = i; j < count; j++) {
                    try {
                        members[j] = members[j+1];
                    } catch (IndexOutOfBoundsException e) {
                        members[j] = null;
                        count --;
                        return true;
                    }
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public boolean editInformation(long studentId, String firstName, String lastName, String faculty) {
        if (!findMember(studentId)) {
            return false;
        }
        members[index].setFirstName(firstName);
        members[index].setLastName(lastName);
        members[index].setFaculty(faculty);
        return true;
    }

    public boolean isFull() {
        boolean full = (count == maximum) ? true : false;
        status = (full) ? Status.CLOSE : Status.OPEN;
        return full;
    }

    public boolean findMember(long studentId) {
        for (int i = 0; i < count; i++) {
            if (studentId == members[i].getStudentId()) {
                index = i;
                return true;
            }
        }
        index = -1;
        return false;
    }

    public void listAllMember() {
        for (int i = 0; i < count; i++) {
            System.out.println(members[i]);
        }
    }

    @Override
    public String toString() {
        return "{ clubName: " + clubName + ", shortName: " + shortName + ", status: " + status + " }";
    }
}