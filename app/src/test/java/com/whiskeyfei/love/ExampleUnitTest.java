package com.whiskeyfei.love;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Maps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test1(){
        String test = "test";
        Optional<String> s = Optional.of(test);
        System.out.println("test1:"+s.get());
    }

    @Test
    public void test2(){
        Optional<Object> o = Optional.fromNullable(null);
        System.out.println(o.get());
    }

    /**
     * @Title:test3
     * @Description:检查null
     * @throws: NullPointerException
     *
     */
    @Test
    public void test3(){
       String str = Preconditions.checkNotNull("","is null");
        int a = 10;
        Preconditions.checkArgument(a > 10, "参数必须大于10");
    }

    /**
     *
     * @Title: testMapJoiner
     * @Description: 将一个map型数据组合成一个由指定分隔符分开的key-value样式
     *
     *               输出结果为：
     *
     *               贝克汉姆:中场;罗纳尔多:前锋;布冯:门将;齐达内:中场
     *
     * @param 设定文件
     * @return void 返回类型
     * @throws
     */
    @Test
    public void testMapJoiner() {
        Map<String, String> map = Maps.newLinkedHashMap();
        String delimiter = ";";

        map.put("贝克汉姆", "中场");
        map.put("罗纳尔多", "前锋");
        map.put("布冯", "门将");
        map.put("齐达内", "中场");

        String returnString = Joiner.on(delimiter)// 创建了一个以delimiter作为分隔符的Joiner
                .withKeyValueSeparator(":")// 创建了一个以：作为键值间隔符的MapJoiner
                .join(map);// 将这个指定了MapJoiner样式的map连接成一个字符串
        System.out.println(returnString);
    }

    @Test
    public void testMapSplitter() {
        String text = "贝克汉姆:中场;罗纳尔多:前锋;布冯:门将;齐达内:中场";

        String delimiter = ";";

        Map<String, String> map = Splitter.on(delimiter)
                .withKeyValueSeparator(":").split(text);

        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println("key:" + e.getKey() + ",value:"+e.getValue());
        }
    }

    @Test
    public void testMoreObjects() {
        Student s = new Student(1, null, "male", 13);
        // 利用guava的toString格式化对象
        Assert.assertEquals(s.toString(), "Student{id=1, sex=male, age=13}");

        // 查找第一个不为空的元素，如果都是null，则抛出空指针异常
        Assert.assertEquals(MoreObjects.firstNonNull(null, "jack"), "jack");

        Student s1 = new Student(1, "jack", "female", 13);
        Student s2 = new Student(1, "jack", "male", 14);
        Assert.assertTrue("检查s1是否小于s2", s1.compareTo(s2) < 0);
    }

    @Test
    public void testCheck(){
        //检查boolean是否为true，用来检查传递给方法的参数。
        Preconditions.checkArgument(true);
        //检查value是否为null，该方法直接返回value，因此可以内嵌使用checkNotNull。
        Preconditions.checkNotNull("");
        //来检查对象的某些状态
        Preconditions.checkState(true);
        //检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size
        Preconditions.checkElementIndex(0,8);
        //检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size *
        Preconditions.checkPositionIndex(1,8);
        //检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效*
        Preconditions.checkPositionIndexes(2,5,9);
    }


    private class Student implements Comparable<Student> {
        public Student(int id, String name, String sex, int age) {
            super();
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        private int id;

        private String name;

        private String sex;

        private int age;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)// 创建ToStringHelper对象
                    .omitNullValues()// 忽略空值
                    .add("id", id)// 将id添加入内
                    .add("name", name)// 将name添加入内
                    .add("sex", sex)// 将sex添加入内
                    .add("age", age)// 将age添加入内----guava采用链表连接所有属性
                    .toString();// 将ToStringHelper格式化为字符串内容
        }

        @Override
        public int compareTo(Student s) {
            // 如果需要对多个值进行进行比较，以完成排序过程，典型写法为:
            // return typicalCompare(s);

            // 使用了guava，你就可以这样写了
            return ComparisonChain.start().compare(this.id, s.id)// 将id加入比较器
                    .compare(this.name, s.name)// 将name加入比较器
                    .compare(this.sex, s.sex)// 将sex加入比较器
                    .compare(this.age, s.age)// 将age加入比较器
                    .result();// 得出比较结果
        }

        @SuppressWarnings("unused")
        public int typicalCompare(Student s) {
            int result = this.id - s.id;
            // 优先级从高到低，如果某个属性比较结果相等，则继续将后面的元素进行比较
            if (result != 0)
                return result;
            result = this.name.compareTo(s.name);

            if (result != 0)
                return result;

            result = this.sex.compareTo(s.sex);

            if (result != 0)
                return result;

            return this.age - s.age;
        }
    }

}