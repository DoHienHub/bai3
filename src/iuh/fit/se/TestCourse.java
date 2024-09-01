import iuh.fit.se.Course;
import iuh.fit.se.CourseList;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TestCourse{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find course by ID");
            System.out.println("5. Find courses by title");
            System.out.println("6. Find courses by department");
            System.out.println("7. Find courses with maximum credit");
            System.out.println("8. Find department with most courses");
            System.out.println("9. Display sorted courses by title");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            try {
                switch (choice) {
                    case 1 -> addCourse(sc, courseList);
                    case 2 -> displayCourses(courseList);
                    case 3 -> removeCourse(sc, courseList);
                    case 4 -> findCourseById(sc, courseList);
                    case 5 -> findCoursesByTitle(sc, courseList);
                    case 6 -> findCoursesByDepartment(sc, courseList);
                    case 7 -> findCoursesWithMaxCredit(courseList);
                    case 8 -> findDepartmentWithMostCourses(courseList);
                    case 9 -> sortedCourseListByTitle(courseList);
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice! Please enter a number between 0 and 9.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);

        sc.close();
    }

    private static void addCourse(Scanner sc, CourseList courseList) {
        try {
            System.out.print("Enter course id: ");
            String id = sc.nextLine();
            System.out.print("Enter course title: ");
            String title = sc.nextLine();
            System.out.print("Enter course credit: ");
            int credit = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            System.out.print("Enter course department: ");
            String department = sc.nextLine();

            Course course = new Course(id, title, credit, department);
            if (courseList.addCourse(course)) {
                System.out.println("Course added successfully!");
            } else {
                System.out.println("Course not added!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Credit must be a number.");
            sc.next(); // Clear invalid input
        }
    }

    private static void displayCourses(CourseList courseList) {
        System.out.println("Course List");
        System.out.println("-------------------------------------------------------------");
        System.out.println(String.format("%-10s%-30s%5s %-10s", "ID", "Title", "Credit", "Department"));
        System.out.println("-------------------------------------------------------------");

        // Display courses
        for (Course c : courseList.getCoursesSortedByTitleCopy()) {
            if (c != null) {
                System.out.println(c);
            }
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void removeCourse(Scanner sc, CourseList courseList) {
        System.out.print("Enter course id to remove: ");
        String id = sc.nextLine();
        if (courseList.removeCourse(id)) {
            System.out.println("Course removed successfully!");
        } else {
            System.out.println("Course ID not found!");
        }
    }

    private static void findCourseById(Scanner sc, CourseList courseList) {
        System.out.print("Enter course id to find: ");
        String id = sc.nextLine();
        Course course = courseList.findCourseById(id);
        if (course != null) {
            System.out.println("Course found:");
            System.out.println(course);
        } else {
            System.out.println("Course ID not found!");
        }
    }

    private static void findCoursesByTitle(Scanner sc, CourseList courseList) {
        System.out.print("Enter course title to search: ");
        String title = sc.nextLine();
        List<Course> courses = courseList.findCoursesByTitle(title);
        if (courses != null) {
            System.out.println("Courses found:");
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found with the given title!");
        }
    }

    private static void findCoursesByDepartment(Scanner sc, CourseList courseList) {
        System.out.print("Enter department to search: ");
        String department = sc.nextLine();
        List<Course> courses = courseList.findCoursesByDepartment(department);
        if (courses != null) {
            System.out.println("Courses found:");
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found for the given department!");
        }
    }

    private static void findCoursesWithMaxCredit(CourseList courseList) {
        List<Course> courses = courseList.findCoursesWithMaxCredit();
        if (courses != null) {
            System.out.println("Courses with maximum credit:");
            for (Course course : courses) {
                System.out.println(course);
            }
        } else {
            System.out.println("No courses found!");
        }
    }

    private static void findDepartmentWithMostCourses(CourseList courseList) {
        String department = courseList.findDepartmentWithMostCourses();
        if (department != null) {
            System.out.println("Department with most courses: " + department);
        } else {
            System.out.println("No departments found!");
        }
    }

    private static void sortedCourseListByTitle(CourseList courseList) {
        System.out.println("Sorted Course List by Title");
        System.out.println("-------------------------------------------------------------");
        System.out.println(String.format("%-10s%-30s%5s %-10s", "ID", "Title", "Credit", "Department"));
        System.out.println("-------------------------------------------------------------");

        // Display sorted courses by title
        for (Course c : courseList.getCoursesSortedByTitleCopy()) {
            if (c != null) {
                System.out.println(c);
            }
        }
        System.out.println("-------------------------------------------------------------");
    }

    private static void initData(CourseList courseList) {
        try {
            Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
            Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
            Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
            Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
            Course course5 = new Course("FIT105", "Software Engineering", 3, "FIT");
            Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
            Course course7 = new Course("FIT107", "Machine Learning", 3, "FIT");
            Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "FIT");

            courseList.addCourse(course1);
            courseList.addCourse(course2);
            courseList.addCourse(course3);
            courseList.addCourse(course4);
            courseList.addCourse(course5);
            courseList.addCourse(course6);
            courseList.addCourse(course7);
            courseList.addCourse(course8);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding initial data: " + e.getMessage());
        }
    }
}
