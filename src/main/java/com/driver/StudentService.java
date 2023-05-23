package com.driver;

import java.util.List;
import java.util.Optional;

public class StudentService {
    StudentRepository studentRepository=new StudentRepository();
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        Optional<Student>StudentOpt=studentRepository.getStudent(student);
        Optional<Teacher>TeacherOpt=studentRepository.getTeacher(teacher);
        if(TeacherOpt.isEmpty()){
            throw new TeacherNotFoundException();
        }
        if(StudentOpt.isEmpty()){
            throw  new StudentNotFoundException();
        }
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentbyName(String name) {
       Optional<Student> studentOptional =studentRepository.getStudentByName(name);
       if(studentOptional.isEmpty()){
           throw new StudentNotFoundException();
       }
       return studentOptional.get();
    }

    public Teacher getTeacherByName(String name) {
        Optional<Teacher> teacherOptional =studentRepository.getTeacherByName(name);
        if(teacherOptional.isEmpty()){
            throw new TeacherNotFoundException();
        }
        return teacherOptional.get();
    }

    public List<String> getStudentbyTeacherName(String teacher) {
        List<String> list=studentRepository.getStudentByTeacherName(teacher);
        return list;
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        List<String> studentslist=studentRepository.getStudentsList(teacher);
        studentRepository.remove(teacher);
        for(String student:studentslist){
            studentRepository.deleteStudent(student);
        }
    }

    public void deleteAllTeachers() {
        List<String> TeachersList=studentRepository.getAllTeacher();
        for(String TeacherName:TeachersList){
            deleteTeacherByName(TeacherName);
        }
    }
}
