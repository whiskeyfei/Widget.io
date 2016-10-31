package com.whiskeyfei.love.design.builder;

/**
 * Created by whiskeyfei on 16/10/27.
 */
public class Director {
    public void Constuct(Builder builder){
        builder.BuildPartA();
        builder.BuildPartB();
    }
}
