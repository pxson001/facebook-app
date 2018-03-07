package com.facebook.registration.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: lam */
public class RegError implements Serializable {
    public int code;
    public String message;

    public RegError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.code);
        objectOutputStream.writeObject(this.message);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.code = objectInputStream.readInt();
        this.message = (String) objectInputStream.readObject();
    }
}
