package com.company;

import org.w3c.dom.ls.LSOutput;

public class Mouthology {
    public static void main(String[] args) {
        // это которые прописаны ниже new /new
        Person professor = Person.getBuilder()
                .setBiology(true)
                .setEcology(true)
                .setEscapology(false)
                .getPerson();
        System.out.println(professor.toString());
    }



}
class Person {
    private String profession="";//  у каждого своя профессия

    public String getProfession() {
        return profession;
    }

    public boolean isBiology() {
        return biology;
    }

    public boolean isEcology() {
        return ecology;
    }

    public boolean isGeograghy() {
        return geograghy;
    }

    public boolean isSwiminology() {
        return swiminology;
    }

    public boolean isEscapology() {
        return escapology;
    }

    public boolean isMoutology() {
        return mouthology;
    }
    public static Builder getBuilder(){// просим у person  вернуть builder
        return new Person().new Builder();
    }
    private boolean biology; // у каждого свои знания
    private boolean ecology;
    private boolean geograghy;
    private boolean swiminology;
    private boolean escapology;
    private boolean mouthology;

    // передаем право внутреннему строителю вложенному классу
    public class Builder{ // Inner class
        public void setProfession(String profession) {
            Person.this.profession = profession;// будет ссылаться на объект person
        }

        public Builder setBiology(boolean biology) {
            Person.this.biology = biology;
            return this;// вернуть строителя .. самого себя
        }

        public Builder setEcology(boolean ecology) {
            Person.this.ecology = ecology;
            return this;
        }

        public Builder setGeograghy(boolean geograghy) {
            Person.this.geograghy = geograghy;
            return this;
        }

        public Builder setSwiminology(boolean swiminology) {
            Person.this.swiminology = swiminology;
            return this;
        }

        public Builder setEscapology(boolean escapology) {
            Person.this.escapology = escapology;
            return this;
        }

        public Builder setMouthology(boolean mouthology) {
            Person.this.mouthology = mouthology;
            return this;
        }
        public Person getPerson(){
            return Person. this;// вернули person
        }
    }
}
