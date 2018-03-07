package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* compiled from: carrier */
public class MinimalClassNameIdResolver extends ClassNameIdResolver {
    protected final String f6124a;
    protected final String f6125b;

    protected MinimalClassNameIdResolver(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
        String name = javaType._class.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this.f6124a = "";
            this.f6125b = ".";
            return;
        }
        this.f6125b = name.substring(0, lastIndexOf + 1);
        this.f6124a = name.substring(0, lastIndexOf);
    }

    public final String mo716a(Object obj) {
        String name = obj.getClass().getName();
        if (name.startsWith(this.f6125b)) {
            return name.substring(this.f6125b.length() - 1);
        }
        return name;
    }

    public final JavaType mo715a(String str) {
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder(str.length() + this.f6124a.length());
            if (this.f6124a.length() == 0) {
                stringBuilder.append(str.substring(1));
            } else {
                stringBuilder.append(this.f6124a).append(str);
            }
            str = stringBuilder.toString();
        }
        return super.mo715a(str);
    }
}
