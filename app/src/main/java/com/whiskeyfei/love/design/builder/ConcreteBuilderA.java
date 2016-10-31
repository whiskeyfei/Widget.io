package com.whiskeyfei.love.design.builder;

/**
 * Created by whiskeyfei on 16/10/27.
 */
public class ConcreteBuilderA extends Builder{
    private Product mProduct = new Product();

    @Override
    public void BuildPartA() {
        mProduct.Add("a");
    }

    @Override
    public void BuildPartB() {
        mProduct.Add("b");
    }

    @Override
    public Product GetResult() {
        return mProduct;
    }
}
