public class MyDateClass {
    private int month;
    private int day;
    private int year;

    // set the date
    public void setDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // get the date in "month/day/year" format
    public String getDate() {
        return month + "/" + day + "/" + String.format("%02d", year); 
    }
}
