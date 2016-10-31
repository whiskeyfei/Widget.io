package com.whiskeyfei.love.design.builder;

/**
 * Created by whiskeyfei on 16/10/27.
 */
public class ConcreteBuilderB extends Builder{
    private Product mProduct = new Product();

    @Override
    public void BuildPartA() {
        mProduct.Add("1");
    }

    @Override
    public void BuildPartB() {
        mProduct.Add("2");
    }

    @Override
    public Product GetResult() {
        return mProduct;
    }
}
