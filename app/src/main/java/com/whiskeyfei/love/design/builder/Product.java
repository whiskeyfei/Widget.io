package com.whiskeyfei.love.design.builder;

import java.util.ArrayList;

/**
 * Created by whiskeyfei on 16/10/27.
 */
public class Product {
    private ArrayList<String> mArrayList = new ArrayList<String>();

    public void Add(String part){
        mArrayList.add(part);
    }

    public void show(){
        for (String s:mArrayList){
            System.out.println(s);
        }
    }
}
