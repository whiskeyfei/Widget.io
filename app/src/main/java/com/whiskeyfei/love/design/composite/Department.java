package com.whiskeyfei.love.design.composite;

/**
 * Created by whiskeyfei on 16/10/31.
 * 组合模式
 *
 */
public abstract class Department {

    protected String name;

    public Department(String name){
        this.name = name;
    }

    public abstract void add(Department department);
    public abstract void remove(Department department);
    public abstract void show(int depth);
    public abstract void reportWork();
}
