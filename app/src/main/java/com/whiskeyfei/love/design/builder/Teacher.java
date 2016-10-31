package com.whiskeyfei.love.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whiskeyfei on 16/10/27.
 */
public class Teacher {
    private List<Student> mStudentList = new ArrayList<>();

    public void add(Student student) {
        mStudentList.add(student);
    }

    public void start() {
        for (Student student : mStudentList) {
            student.setp1();
            student.setp2();
            student.setp3();
        }
    }
}
