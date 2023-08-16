package sg.edu.rp.c346.id22021421.demoenrolment;

public class Enrolment {


    private String year;
    private String study;
    private int enrolment;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public int getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(int enrolment) {
        this.enrolment = enrolment;
    }

    public Enrolment(String year, String study, int enrolment) {
        this.year = year;
        this.study = study;
        this.enrolment = enrolment;
    }


    @Override
    public String toString() {
        return "Year: " + year + "\nStudy Type: " + study+"\nEnrolment: "+enrolment;
    }
}
