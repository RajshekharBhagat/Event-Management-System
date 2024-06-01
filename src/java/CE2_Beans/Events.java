package CE2_Beans;
public class Events {
    private String eventOwner;
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private String eventTime;

    public Events(String eventOwner, String eventName, String eventDescription, String eventDate, String eventTime) {
        this.eventOwner = eventOwner;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
    }
    @Override
    public String toString() {
        return "Event Owner: " + eventOwner + "\n" +
               "Event Name: " + eventName + "\n" +
               "Event Description: " + eventDescription + "\n" +
               "Event Date: " + eventDate + "\n" +
               "Event Time: " + eventTime;
    }
}
