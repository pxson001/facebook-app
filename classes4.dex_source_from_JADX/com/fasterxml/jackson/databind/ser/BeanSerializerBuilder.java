package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import java.util.List;

/* compiled from: vc */
public class BeanSerializerBuilder {
    private static final BeanPropertyWriter[] f308i = new BeanPropertyWriter[0];
    public final BeanDescription f309a;
    public SerializationConfig f310b;
    public List<BeanPropertyWriter> f311c;
    public BeanPropertyWriter[] f312d;
    public AnyGetterWriter f313e;
    public Object f314f;
    public AnnotatedMember f315g;
    public ObjectIdWriter f316h;

    public BeanSerializerBuilder(BeanDescription beanDescription) {
        this.f309a = beanDescription;
    }

    protected final void m538a(SerializationConfig serializationConfig) {
        this.f310b = serializationConfig;
    }

    public final void m543a(List<BeanPropertyWriter> list) {
        this.f311c = list;
    }

    public final void m544a(BeanPropertyWriter[] beanPropertyWriterArr) {
        this.f312d = beanPropertyWriterArr;
    }

    public final void m540a(AnyGetterWriter anyGetterWriter) {
        this.f313e = anyGetterWriter;
    }

    public final void m542a(Object obj) {
        this.f314f = obj;
    }

    public final void m539a(AnnotatedMember annotatedMember) {
        if (this.f315g != null) {
            throw new IllegalArgumentException("Multiple type ids specified with " + this.f315g + " and " + annotatedMember);
        }
        this.f315g = annotatedMember;
    }

    public final void m541a(ObjectIdWriter objectIdWriter) {
        this.f316h = objectIdWriter;
    }

    public final BeanDescription m537a() {
        return this.f309a;
    }

    public final List<BeanPropertyWriter> m545b() {
        return this.f311c;
    }

    public final AnyGetterWriter m546c() {
        return this.f313e;
    }

    public final Object m547d() {
        return this.f314f;
    }

    public final AnnotatedMember m548e() {
        return this.f315g;
    }

    public final ObjectIdWriter m549f() {
        return this.f316h;
    }

    public final JsonSerializer<?> m550g() {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.f311c != null && !this.f311c.isEmpty()) {
            beanPropertyWriterArr = (BeanPropertyWriter[]) this.f311c.toArray(new BeanPropertyWriter[this.f311c.size()]);
        } else if (this.f313e == null) {
            return null;
        } else {
            beanPropertyWriterArr = f308i;
        }
        return new BeanSerializer(this.f309a.a, this, beanPropertyWriterArr, this.f312d);
    }

    public final BeanSerializer m551h() {
        return BeanSerializer.m611a(this.f309a.a);
    }
}
