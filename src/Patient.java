

public class Patient {
    /*
        Patient class is created for each row of EXCEL spreadsheet
        
    */


    public String last; // Patient's last name
    public String first; // Patient's first name

    // Age taken on date of diagnosis (dx)
    public int age;
    // public Date dxDate; // Exact date
    public int dxYear; // Just the year for easier computation

    // REVIEW INFO:
    public String employ; // the listed job (to help the reviewer)
    public boolean alive = true; // will only create object if patient is listed as alive
    public boolean result = false; // no results have been found as of construction
    public String sex; // might not implement

    // Constructor
    public Patient(String name, int dxAge, int dx, String employment) {
        first = getFirstName(name);
        last = getLastName(name);
        age = dxAge;
        employ = employment;
        dxYear = dx;
    }

    // Retrieve the string after the comma
    // TESTED: working
    private String getFirstName(String name) {
        int i = name.indexOf(',');
        return name.substring(i + 2);
    }

    // Retrieve the string before the comma
    // TESTED: working
    private String getLastName(String name) {
        int j = name.indexOf(',');
        return name.substring(0, j);
    }

}
