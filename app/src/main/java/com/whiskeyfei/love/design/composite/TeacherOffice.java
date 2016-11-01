package com.whiskeyfei.love.design.composite;

/**
 * Created by whiskeyfei on 16/10/31.
 */
public class TeacherOffice extends Department {

    public TeacherOffice(String name) {
        super(name);
    }

    @Override
    public void add(Department department) {

    }

    @Override
    public void remove(Department department) {

    }

    @Override
    public void show(int depth) {
        for (int i =0;i<depth;i++){
            System.out.print("+");
        }
        System.out.println(name);
    }

    @Override
    public void reportWork() {
        System.out.println(name + "汇报了教师工作");
    }
}
