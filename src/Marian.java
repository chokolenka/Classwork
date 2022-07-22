package com.company;

public class Marian {
    public static void main(String[] args) throws CloneNotSupportedException {
        Girl marian = new Girl("Marian", true, true, true);
        System.out.println(marian);
        Girl notMarian = (Girl) marian.clone();
        notMarian.setName("notMarian");
        notMarian.setSilly(false);
        notMarian.setLazy(false);
        System.out.println(notMarian);
    }
}
class Girl implements Cloneable{
    private String name;// задаем имя
    private boolean silly;// выбор
    private boolean little;
    private boolean lazy;



    public Girl(String name, boolean silly, boolean little, boolean lazy) {
        this.name = name;//  мы получаем объект
        this.silly = silly;
        this.little = little;
        this.lazy = lazy;
    }

    public Girl() {
        super();
    }

    public String getName() {
        return name;
    }

    public boolean isSilly() {
        return silly;
    }

    public boolean isLittle() {
        return little;
    }

    public boolean isLazy() {
        return lazy;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", silly=" + silly +
                ", little=" + little +
                ", lazy=" + lazy +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSilly(boolean silly) {
        this.silly = silly;
    }

    public void setLittle(boolean little) {
        this.little = little;
    }

    public void setLazy(boolean lazy) {
        this.lazy = lazy;
    }
}