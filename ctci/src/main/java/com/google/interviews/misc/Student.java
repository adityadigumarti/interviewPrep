package com.google.interviews.misc;

import java.util.Set;
import java.util.TreeSet;

public class Student implements Comparable<Student> {

    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public Student(int id, int age) {
        super();
        this.id = id;
        this.age = age;
    }

    public static void main(String args[]) {
        Set<Student> set = new TreeSet<Student>();

        Student s1 = new Student(1, 1);
        Student s2 = new Student(1, 2);
        Student s3 = new Student(1, 3);
        Student s4 = new Student(2, 3);

        set.add(s1);
        System.out.println(set.size());

        set.add(s2);
        System.out.println(set.size());

        set.add(s3);
        System.out.println(set.size());

        set.add(s4);
        System.out.println(set.size());
    }

    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
