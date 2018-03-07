package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;

/* compiled from: clear_all_data */
public abstract class ValueInstantiator {
    public abstract String mo671a();

    public final boolean m10975b() {
        return mo685h() || mo686i() || mo673j() || mo680c() || mo681d() || mo682e() || mo683f() || mo684g();
    }

    public boolean mo680c() {
        return false;
    }

    public boolean mo681d() {
        return false;
    }

    public boolean mo682e() {
        return false;
    }

    public boolean mo683f() {
        return false;
    }

    public boolean mo684g() {
        return false;
    }

    public boolean mo685h() {
        return mo689m() != null;
    }

    public boolean mo686i() {
        return false;
    }

    public boolean mo673j() {
        return false;
    }

    public SettableBeanProperty[] mo672a(DeserializationConfig deserializationConfig) {
        return null;
    }

    public JavaType mo687k() {
        return null;
    }

    public Object mo688l() {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + "; no default creator found");
    }

    public Object mo670a(Object[] objArr) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " with arguments");
    }

    public Object mo677a(DeserializationContext deserializationContext, Object obj) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " using delegate");
    }

    public Object mo678a(DeserializationContext deserializationContext, String str) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from String value");
    }

    public Object mo675a(int i) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Integer number (int)");
    }

    public Object mo676a(long j) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Integer number (long)");
    }

    public Object mo674a(double d) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Floating-point number (double)");
    }

    public Object mo679a(boolean z) {
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Boolean value");
    }

    public AnnotatedWithParams mo689m() {
        return null;
    }

    public AnnotatedWithParams mo690n() {
        return null;
    }

    public AnnotatedParameter mo691o() {
        return null;
    }
}
