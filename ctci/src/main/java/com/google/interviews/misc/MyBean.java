package com.google.interviews.misc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class MyBean implements Serializable {

    private static final long serialVersionUID = 999;

    private Integer i;

    public MyBean(Integer i) {
        super();
        this.i = i;
    }

    @Override
    public String toString() {
        return "MyBean [i=" + i + "]";
    }

    public static void main(String args[]) {
        // try {
        // OutputStream file = new FileOutputStream("quarks33.ser");
        // OutputStream buffer = new BufferedOutputStream(file);
        // ObjectOutput output = new ObjectOutputStream(buffer);
        // output.writeObject(new MyBean(44));
        // buffer.close();
        // file.close();
        //
        // } catch (IOException ex) {
        // ex.printStackTrace();
        // }

        try {
            InputStream file = new FileInputStream("quarks33.ser");
            InputStream buffer = new BufferedInputStream(file);

            System.out.print(buffer.toString());
            ObjectInput input = new ObjectInputStream(buffer);

            MyBean bean = (MyBean) input.readObject();

            buffer.close();
            file.close();
            System.out.println(bean.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
