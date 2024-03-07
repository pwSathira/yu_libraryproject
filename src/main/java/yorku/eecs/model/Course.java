package yorku.eecs.model;
import yorku.eecs.model.item.Book;

import java.util.Date;

public class Course {
    private String courseName;
    private String courseCode;
    private Date startDate;
    private Date endDate;
    private Book textbook;

    public Course(String courseName, String courseCode, Date startDate, Date endDate, Book textbook) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.textbook = textbook;
    }

    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Book getTextbook() {
        return textbook;
    }
    public void setTextbook(Book textbook) {
        this.textbook = textbook;
    }



}
