package com.facebook.http.entity.mime.apache;

/* compiled from: disagree */
public class MinimalField {
    public final String f5040a;
    public final String f5041b;

    MinimalField(String str, String str2) {
        this.f5040a = str;
        this.f5041b = str2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f5040a);
        stringBuilder.append(": ");
        stringBuilder.append(this.f5041b);
        return stringBuilder.toString();
    }
}
