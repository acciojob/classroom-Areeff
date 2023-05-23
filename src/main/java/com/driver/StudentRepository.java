package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private HashMap<String,Student> Studentdata=new HashMap<>();
    private HashMap<String,Teacher>Teacherdata=new HashMap<>();
    private HashMap<String, ArrayList<String>> StudentTeacherPair=new HashMap<>();

    public void addStudent(Student student) {
        Studentdata.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        Teacherdata.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        ArrayList<String> students=StudentTeacherPair.getOrDefault(teacher,new ArrayList<>());
        students.add(student);
        StudentTeacherPair.put(teacher,students);
    }

    public Optional<Student> getStudent(String student) {
        if(Studentdata.containsKey(student)){
            return Optional.of(Studentdata.get(student));
        }
        return Optional.empty();
    }

    public Optional<Teacher> getTeacher(String teacher) {
        if(Teacherdata.containsKey(teacher)){
            return Optional.of(Teacherdata.get(teacher));
        }
        return Optional.empty();
    }


    public Optional<Student> getStudentByName(String name) {
        if(Studentdata.containsKey(name)){
            return Optional.of(Studentdata.get(name));
        }
        return Optional.empty();
    }

    public Optional<Teacher> getTeacherByName(String name) {
        if(Teacherdata.containsKey(name)){
            return Optional.of(Teacherdata.get(name));
        }
        return Optional.empty();
    }

    public List<String> getStudentByTeacherName(String teacher) {
        return StudentTeacherPair.getOrDefault(teacher,new ArrayList<>());
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(Studentdata.keySet());
    }

    public List<String> getStudentsList(String teacher) {
        return new ArrayList<>(StudentTeacherPair.getOrDefault(teacher,new ArrayList<>()));
    }

    public void remove(String teacher) {
        Teacherdata.remove(teacher);
        StudentTeacherPair.remove(teacher);
    }

    public void deleteStudent(String student) {
        Studentdata.remove(student);
    }

    public List<String> getAllTeacher() {
        return new ArrayList<>(Teacherdata.keySet());
    }
}
