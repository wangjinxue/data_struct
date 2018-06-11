package me.wjx.set;

/**
 * @author wjx
 * @date 2018/6/5 14:14
 */
public class Person {
    private String name;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        Person other= (Person) obj;
        return name.equals(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
