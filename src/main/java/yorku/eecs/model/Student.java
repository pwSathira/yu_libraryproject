package yorku.eecs.model;

import yorku.eecs.model.Course;
import java.util.ArrayList;
import java.util.List;


public class Student extends User {
    private ArrayList<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<Book> getCourseBook() {

        /* creates an ArrayList of Books that will add books
           to the ArrayList by getting the books from the CourseList
        * */

        ArrayList<Book> bookList = new ArrayList<Book>();
        for (Course course : courseList) {
            bookList.add(course.getTextbook());
        }
        return bookList;
    }

    public List<List<String>> toCSV(int newID) {
        List<List<String>> data = new ArrayList<>();
        List<String> row = new ArrayList<>();
        row.add(Integer.toString(newID));
        row.add(getUserName());
        row.add(getFirstName());
        row.add(getLastName());
        row.add(getPassword());
//        row.add(Integer.toString(getId()));
        row.add(getEmailAddress());
        data.add(row);
        return data;
    }
}
