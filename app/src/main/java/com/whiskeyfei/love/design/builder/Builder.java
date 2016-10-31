package com.whiskeyfei.love.design.builder;

/**
 * Created by whiskeyfei on 16/10/27.
 *
 * 建造者模式  Builder Pattern
 *
 * 建造模式是对
 *
 * 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。 [构建与表示分离，同构建不同表示]
 *
 * 象的创建模式。建造模式可以将一个产品的内部表象（internal representation）与产品的生产过程分割开来，从而可以使一个建造过程生成具有不同的内部表象的产品对象。
 *
 *
 * 建造者模式的关键特性是它将一个建造过程分解成很多步骤，也可以说，每个产品的建造会遵循同样的流程，不过流程内的每一个步骤都不尽相同。
 *
 * StringBuilder类库使用了建造者模式
 *
 *
 * 建造者模式和工厂模式的区别

 当创造一个对象需要很多步骤时适合使用建造者模式

 当只需调用一个方法就可以简单地创建整个对象时适合使用工厂模式。

 */
public abstract class Builder {
    public abstract  void BuildPartA();
    public abstract  void BuildPartB();

    public abstract Product GetResult();
}
