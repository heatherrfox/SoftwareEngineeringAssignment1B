import ie.nuigalway.obrien.ct417ass1a.CourseProgramme;
import ie.nuigalway.obrien.ct417ass1a.Lecturer;
import ie.nuigalway.obrien.ct417ass1a.Module;
import ie.nuigalway.obrien.ct417ass1a.Student;
import ie.nuigalway.obrien.ct417ass1b.RegistrySystem;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class RegistrySystemTest {

    RegistrySystem registrySystem = new RegistrySystem();

    @Test
    public void testRegistrySystem() {

        //create Students
        Student s1 = new Student("Heather", "OBrien", LocalDate.of(2001, 10,1));
        Student s2 = new Student("Mary", "Fox", LocalDate.of(2002, 12,20));
        Student s3 = new Student("Alison", "Mcmanus", LocalDate.of(1998, 6,12));
        Student s4 = new Student("Laura", "Carr", LocalDate.of(1999, 2,7));

        //add students to the registry
        registrySystem.addStudent(s1);
        registrySystem.addStudent(s2);
        registrySystem.addStudent(s3);
        registrySystem.addStudent(s4);

        //create Lecturers
        Lecturer l1 = new Lecturer("Michael", "Schukat", LocalDate.of(1970, 9, 20));
        Lecturer l2 = new Lecturer("Jim", "Duggan", LocalDate.of(1967, 3, 12));
        Lecturer l3 = new Lecturer("Attracta", "Brennan", LocalDate.of(1961, 5, 19));

        //add lecturers to the registry
        registrySystem.addLecturer(l1);
        registrySystem.addLecturer(l2);
        registrySystem.addLecturer(l3);

        //Create modules
        Module m1 = new Module("Software Engineering III", "CT417", l1);
        Module m2 = new Module("System Modelling", "CT516", l2);
        Module m3 = new Module("Advanced Professional Skills", "CT436", l3);

        //add modules to the registry
        registrySystem.addModule(m1);
        registrySystem.addModule(m2);
        registrySystem.addModule(m3);

        //Create courses
        CourseProgramme c1 = new CourseProgramme("Computer Science & IT", new DateTime(2022,9,3,0,0),
                new DateTime(2022, 12, 12, 0,0));
        CourseProgramme c2 = new CourseProgramme("Electronic Engineering", new DateTime(2022,9,3,0,0),
                new DateTime(2022, 12, 12, 0,0));

        //add courses to the registry
        registrySystem.addCourse(c1);
        registrySystem.addCourse(c2);


        //adding the students to a number of modules
        m1.addStudent(s1);
        m1.addStudent(s2);

        m2.addStudent(s2);
        m2.addStudent(s3);

        m3.addStudent(s3);
        m3.addStudent(s4);

        //adding a number of modules to a number of courses
        c1.addModule(m1);
        c1.addModule(m2);

        c2.addModule(m2);
        c2.addModule(m3);

        listCourses();

        updateStudentInformation();
        listStudents();
    }

    public void updateStudentInformation() {
            for(CourseProgramme course : registrySystem.getAllCourses()) {
                for(Module module : course.getModules()) {
                    for(Student student : module.getStudents()) {
                        student.addModule(module);
                        student.addCourseProgramme(course);
                    }
                }
            }
    }

    public void listCourses() {
        //print a list of all the courses and their respective modules
        registrySystem.getAllCourses()
                .forEach(courseProgramme -> {
                    System.out.println("-------------------------------");
                    System.out.println("[Course Name]: " + courseProgramme.getCourseName());
                    System.out.println("[Modules in " + courseProgramme.getCourseName() + "]: ");
                    courseProgramme.getModules()
                            .forEach(module -> {
                                System.out.println(module.getModuleName());
                            });
                });
    }

    public void listStudents() {
        registrySystem.getAllStudents()
                .forEach(student -> {
                    System.out.println("-------------------------------");
                    System.out.println("[Student Username]: " + student.getUsername());
                    System.out.println("[Assigned module(s)]: ");
                    student.getModules()
                            .forEach(module -> {
                                System.out.println(module.getModuleName());
                            });
                    System.out.println("[Registered course(s)]: ");
                    student.getCourseProgrammes()
                            .forEach(courseProgramme -> {
                                System.out.println(courseProgramme.getCourseName());
                            });
                });
    }
}
