package me.wjx.array;

/**
 * @author wjx
 * @date 2018/6/20 17:19
 */
public class Student {
    private int age;
    private String name;

    public Student(int i, String s) {
        this.age=i;
        this.name=s;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
