package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: story/%s/%s */
public class TypeParser implements Serializable {
    private static final long serialVersionUID = 1;
    protected final TypeFactory _factory;

    public TypeParser(TypeFactory typeFactory) {
        this._factory = typeFactory;
    }

    public final JavaType m7121a(String str) {
        MyTokenizer myTokenizer = new MyTokenizer(str.trim());
        JavaType a = m7117a(myTokenizer);
        if (!myTokenizer.hasMoreTokens()) {
            return a;
        }
        throw m7119a(myTokenizer, "Unexpected tokens after complete type");
    }

    private JavaType m7117a(MyTokenizer myTokenizer) {
        if (myTokenizer.hasMoreTokens()) {
            Class a = m7118a(myTokenizer.nextToken(), myTokenizer);
            if (myTokenizer.hasMoreTokens()) {
                String nextToken = myTokenizer.nextToken();
                if ("<".equals(nextToken)) {
                    return this._factory.m7107a(a, m7120b(myTokenizer));
                }
                myTokenizer.a(nextToken);
            }
            return this._factory.m7114b(a);
        }
        throw m7119a(myTokenizer, "Unexpected end-of-string");
    }

    private List<JavaType> m7120b(MyTokenizer myTokenizer) {
        List arrayList = new ArrayList();
        while (myTokenizer.hasMoreTokens()) {
            arrayList.add(m7117a(myTokenizer));
            if (!myTokenizer.hasMoreTokens()) {
                break;
            }
            String nextToken = myTokenizer.nextToken();
            if (">".equals(nextToken)) {
                return arrayList;
            }
            if (!",".equals(nextToken)) {
                throw m7119a(myTokenizer, "Unexpected token '" + nextToken + "', expected ',' or '>')");
            }
        }
        throw m7119a(myTokenizer, "Unexpected end-of-string");
    }

    private Class<?> m7118a(String str, MyTokenizer myTokenizer) {
        try {
            return ClassUtil.a(str);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            throw m7119a(myTokenizer, "Can not locate class '" + str + "', problem: " + e.getMessage());
        }
    }

    private static IllegalArgumentException m7119a(MyTokenizer myTokenizer, String str) {
        return new IllegalArgumentException("Failed to parse type '" + myTokenizer.a + "' (remaining: '" + myTokenizer.b() + "'): " + str);
    }
}
