import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Instructor instructor1 = new Instructor(1, "Bandara Kumara", "banda@edu.com", "Computer Science");

        
        Student student1 = new Student(2, "Sirisena Gamage", "sirisena@edu.com", "Computer Science");
        Student student2 = new Student(3, "Sajith Premadasa", "sajith@edu.com", "Engineering");

        Course course1 = new Course(101, "Java Programming");
        Course course2 = new Course(102, "Data Structures");

        // Assign Courses to Instructor
        instructor1.assignCourse(course1);
        instructor1.assignCourse(course2);

        // Enroll Students in Courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);

        student2.enrollCourse(course2);

        System.out.println("Instructor Details:");
        instructor1.displayInfo();

        System.out.println("\nStudent Details:");
        student1.displayInfo();
        student2.displayInfo();

        // Static Variable Usage
        System.out.println("\nTotal Persons in the System: " + Person.getTotalPersons());
    }
}

class Person {
    private int id;
    private String name;
    private String email;
    private static int totalPersons = 0; 

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        totalPersons++; // Increment total persons when a new Person is created
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Static Method to Get Total Persons
    public static int getTotalPersons() {
        return totalPersons;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

class Instructor extends Person {
    private String department;
    private List<Course> courses;

    public Instructor(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
        this.courses = new ArrayList<>();
    }

    // Assign Course to Instructor
    public void assignCourse(Course course) {
        courses.add(course);
    }

    // Display Info (Polymorphism)
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Courses Taught:");
        for (Course course : courses) {
            System.out.println(" - " + course.getName());
        }
    }
}

class Student extends Person {
    private String major;
    private List<Course> enrolledCourses;

    public Student(int id, String name, String email, String major) {
        super(id, name, email);
        this.major = major;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Display Info (Polymorphism)
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Major: " + major);
        System.out.println("Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println(" - " + course.getName());
        }
    }
}

class Course {
    private int courseId;
    private String name;

    public Course(int courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }
}
