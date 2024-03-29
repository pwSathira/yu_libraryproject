package yorku.eecs.model.user;

import yorku.eecs.model.Course;
import yorku.eecs.model.item.Book;

import java.util.ArrayList;
import java.util.List;


public class Student extends User {
    private ArrayList<Course> courseList;

    //GETTERS
    public List<Course> getCourseList() {
        return courseList;
    }

    //SETTERS
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

}
