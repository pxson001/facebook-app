package com.facebook.thrift;

/* compiled from: flow_control_pauses */
public class ShortStack {
    public short[] f23598a;
    private int f23599b = -1;

    public ShortStack(int i) {
        this.f23598a = new short[i];
    }

    public final short m31999a() {
        short[] sArr = this.f23598a;
        int i = this.f23599b;
        this.f23599b = i - 1;
        return sArr[i];
    }

    public final void m32000a(short s) {
        if (this.f23598a.length == this.f23599b + 1) {
            Object obj = new short[(this.f23598a.length * 2)];
            System.arraycopy(this.f23598a, 0, obj, 0, this.f23598a.length);
            this.f23598a = obj;
        }
        short[] sArr = this.f23598a;
        int i = this.f23599b + 1;
        this.f23599b = i;
        sArr[i] = s;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ShortStack vector:[");
        for (int i = 0; i < this.f23598a.length; i++) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            if (i == this.f23599b) {
                stringBuilder.append(">>");
            }
            stringBuilder.append(this.f23598a[i]);
            if (i == this.f23599b) {
                stringBuilder.append("<<");
            }
        }
        stringBuilder.append("]>");
        return stringBuilder.toString();
    }
}
