package group6.controller;

import group6.module.student.StudentMap;
import group6.module.student.StudentManager;
import group6.IModule.IStudentLister;

/**
 * @author      Mojtaba Jafari
 * @version     1.0                 
 * Controller class
 * It used to populate the repository/also some sort of search is performed
 */

public class ListStudentsCTL {
    private StudentManager sm;
    public ListStudentsCTL() {sm = StudentManager.get();}
    public void listStudents( IStudentLister lister, String unitCode ) {
        lister.clearStudents();
        StudentMap students = sm.getStudentsByUnit( unitCode );
        for (Integer id : students.keySet() ) lister.addStudent(students.get(id));}}
