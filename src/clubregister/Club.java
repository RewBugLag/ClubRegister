package clubregister;

public class Club {

    private String clubName;
    private String shortName;
    private int count;
    private int maximum;
    private Status status;
    private Student[] members;

    public Club(String clubName, String shortName, int maximum) {
        this.clubName = clubName;
        this.shortName = shortName;
        this.maximum = maximum;
        this.status = Status.OPEN;
        if (maximum <= 0) {
            this.maximum = 0;
            this.status = Status.CLOSE;
        }
        System.out.println(status);
    }
}