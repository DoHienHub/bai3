package iuh.fit.se;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CourseList {
    private List<Course> courses;
    private int capacity;

    public CourseList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        this.capacity = capacity;
        this.courses = new ArrayList<>(capacity);
    }

    public boolean addCourse(Course course) {
        if (findCourseById(course.getId()) != null) {
            return false; // Course with the same ID already exists
        }
        if (courses.size() < capacity) {
            return courses.add(course);
        }
        return false; // Capacity reached
    }

    public boolean removeCourse(String id) {
        Course course = findCourseById(id);
        if (course != null) {
            return courses.remove(course);
        }
        return false; // Course with the given ID not found
    }

    public Course findCourseById(String id) {
        return courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Course> findCoursesByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().contains(title)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> findCoursesByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getDepartment().equals(department)) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public List<Course> findCoursesWithMaxCredit() {
        int maxCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .max()
                .orElse(0);
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCredit() == maxCredit) {
                result.add(course);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public String findDepartmentWithMostCourses() {
        return courses.stream()
                .map(Course::getDepartment)
                .reduce((a, b) -> a)
                .orElse(null);
    }

    public List<Course> getCoursesSortedByTitle() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        sortedCourses.sort((c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
        return sortedCourses;
    }

    // New method to return sorted list of courses by title
    public List<Course> getCoursesSortedByTitleCopy() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        Collections.sort(sortedCourses, (c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
        return sortedCourses;
    }
}
