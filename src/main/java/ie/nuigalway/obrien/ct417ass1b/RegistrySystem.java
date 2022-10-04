package ie.nuigalway.obrien.ct417ass1b;

import ie.nuigalway.obrien.ct417ass1a.CourseProgramme;
import ie.nuigalway.obrien.ct417ass1a.Lecturer;
import ie.nuigalway.obrien.ct417ass1a.Module;
import ie.nuigalway.obrien.ct417ass1a.Student;

import java.util.HashSet;

public class RegistrySystem {
    final private HashSet<CourseProgramme> allCourses;
    final private HashSet<Module> allModules;
    final private HashSet<Student> allStudents;
    final private HashSet<Lecturer> allLecturers;

    public RegistrySystem() {
        allCourses = new HashSet<CourseProgramme>();
        allModules = new HashSet<Module>();
        allStudents = new HashSet<Student>();
        allLecturers = new HashSet<Lecturer>();
    }

    public void addCourse(CourseProgramme c) {
        allCourses.add(c);
    }

    public HashSet<CourseProgramme> getAllCourses() {
        return this.allCourses;
    }

    public void addStudent(Student s) {
        allStudents.add(s);
    }

    public HashSet<Student> getAllStudents() {
        return allStudents;
    }

    public void addLecturer(Lecturer l) {
        allLecturers.add(l);
    }

    public HashSet<Lecturer> getAllLecturers() {
        return allLecturers;
    }

    public void addModule(Module m) {
        allModules.add(m);
    }

    public HashSet<Module> getAllModules() {
        return allModules;
    }
}
