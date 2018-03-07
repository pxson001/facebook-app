package com.facebook.graphql.modelutil;

/* compiled from: eglCreateContext */
public class ConsistencyIndexValue {
    public String f4780a;
    public String f4781b;
    public Object f4782c;
    public int f4783d;
    public int f4784e;

    public ConsistencyIndexValue(String str, String str2, Object obj, int i, int i2) {
        this.f4780a = str;
        this.f4781b = str2;
        this.f4782c = obj;
        this.f4783d = i;
        this.f4784e = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConsistencyIndexValue consistencyIndexValue = (ConsistencyIndexValue) obj;
        if (this.f4783d != consistencyIndexValue.f4783d) {
            return false;
        }
        if (this.f4784e != consistencyIndexValue.f4784e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f4783d * 31) + this.f4784e;
    }
}
