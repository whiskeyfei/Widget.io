package com.whiskeyfei.love.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whiskeyfei on 16/10/31.
 */
public class ConcreteDepartment extends Department {

    private List<Department> mDepartmentList = new ArrayList<>();

    public ConcreteDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Department department) {
        if (department != null)
            mDepartmentList.add(department);
    }

    @Override
    public void remove(Department department) {
        if (department != null)
            mDepartmentList.remove(department);
    }

    @Override
    public void show(int depth) {
        for (int i =0;i<depth;i++){
            System.out.print("+");
        }
        System.out.println(name);
        for (int i =0;i<mDepartmentList.size();i++){
            mDepartmentList.get(i).show(depth + 2);
        }
    }

    @Override
    public void reportWork() {
        for (int i = 0; i < mDepartmentList.size(); i++){
            mDepartmentList.get(i).reportWork();
        }
    }
}
