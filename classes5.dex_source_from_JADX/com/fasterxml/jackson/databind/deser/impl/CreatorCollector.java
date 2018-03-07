package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Member;
import java.util.HashMap;

/* compiled from: class_instances */
public class CreatorCollector {
    protected final BeanDescription f6012a;
    protected final boolean f6013b;
    protected AnnotatedWithParams f6014c;
    protected AnnotatedWithParams f6015d;
    protected AnnotatedWithParams f6016e;
    protected AnnotatedWithParams f6017f;
    protected AnnotatedWithParams f6018g;
    protected AnnotatedWithParams f6019h;
    protected AnnotatedWithParams f6020i;
    protected CreatorProperty[] f6021j;
    protected AnnotatedWithParams f6022k;
    protected CreatorProperty[] f6023l = null;
    protected AnnotatedParameter f6024m;

    public CreatorCollector(BeanDescription beanDescription, boolean z) {
        this.f6012a = beanDescription;
        this.f6013b = z;
    }

    public final ValueInstantiator m11025a(DeserializationConfig deserializationConfig) {
        JavaType javaType;
        ValueInstantiator stdValueInstantiator = new StdValueInstantiator(deserializationConfig, this.f6012a.a);
        if (this.f6020i == null) {
            javaType = null;
        } else {
            int i;
            if (this.f6021j != null) {
                int length = this.f6021j.length;
                i = 0;
                while (i < length) {
                    if (this.f6021j[i] == null) {
                        break;
                    }
                    i++;
                }
            }
            i = 0;
            javaType = this.f6012a.f().a(this.f6020i.b(i));
        }
        stdValueInstantiator.m11319a(this.f6014c, this.f6020i, javaType, this.f6021j, this.f6022k, this.f6023l);
        stdValueInstantiator._fromStringCreator = this.f6015d;
        stdValueInstantiator._fromIntCreator = this.f6016e;
        stdValueInstantiator._fromLongCreator = this.f6017f;
        stdValueInstantiator._fromDoubleCreator = this.f6018g;
        stdValueInstantiator._fromBooleanCreator = this.f6019h;
        stdValueInstantiator._incompleteParameter = this.f6024m;
        return stdValueInstantiator;
    }

    @Deprecated
    private void m11024a(AnnotatedConstructor annotatedConstructor) {
        this.f6014c = (AnnotatedWithParams) m11022a((AnnotatedMember) annotatedConstructor);
    }

    public final void m11027a(AnnotatedWithParams annotatedWithParams) {
        if (annotatedWithParams instanceof AnnotatedConstructor) {
            m11024a((AnnotatedConstructor) annotatedWithParams);
        } else {
            this.f6014c = (AnnotatedWithParams) m11022a((AnnotatedMember) annotatedWithParams);
        }
    }

    public final void m11030b(AnnotatedWithParams annotatedWithParams) {
        this.f6015d = m11023a(annotatedWithParams, this.f6015d, "String");
    }

    public final void m11032c(AnnotatedWithParams annotatedWithParams) {
        this.f6016e = m11023a(annotatedWithParams, this.f6016e, "int");
    }

    public final void m11033d(AnnotatedWithParams annotatedWithParams) {
        this.f6017f = m11023a(annotatedWithParams, this.f6017f, "long");
    }

    public final void m11034e(AnnotatedWithParams annotatedWithParams) {
        this.f6018g = m11023a(annotatedWithParams, this.f6018g, "double");
    }

    public final void m11035f(AnnotatedWithParams annotatedWithParams) {
        this.f6019h = m11023a(annotatedWithParams, this.f6019h, "boolean");
    }

    public final void m11028a(AnnotatedWithParams annotatedWithParams, CreatorProperty[] creatorPropertyArr) {
        this.f6020i = m11023a(annotatedWithParams, this.f6020i, "delegate");
        this.f6021j = creatorPropertyArr;
    }

    public final void m11031b(AnnotatedWithParams annotatedWithParams, CreatorProperty[] creatorPropertyArr) {
        this.f6022k = m11023a(annotatedWithParams, this.f6022k, "property-based");
        if (creatorPropertyArr.length > 1) {
            HashMap hashMap = new HashMap();
            int length = creatorPropertyArr.length;
            int i = 0;
            while (i < length) {
                String str = creatorPropertyArr[i]._propName;
                if (str.length() != 0 || creatorPropertyArr[i].mo655d() == null) {
                    Integer num = (Integer) hashMap.put(str, Integer.valueOf(i));
                    if (num != null) {
                        throw new IllegalArgumentException("Duplicate creator property \"" + str + "\" (index " + num + " vs " + i + ")");
                    }
                }
                i++;
            }
        }
        this.f6023l = creatorPropertyArr;
    }

    public final void m11026a(AnnotatedParameter annotatedParameter) {
        if (this.f6024m == null) {
            this.f6024m = annotatedParameter;
        }
    }

    public final boolean m11029a() {
        return this.f6014c != null;
    }

    private <T extends AnnotatedMember> T m11022a(T t) {
        if (t != null && this.f6013b) {
            ClassUtil.a((Member) t.a());
        }
        return t;
    }

    private AnnotatedWithParams m11023a(AnnotatedWithParams annotatedWithParams, AnnotatedWithParams annotatedWithParams2, String str) {
        if (annotatedWithParams2 == null || annotatedWithParams2.getClass() != annotatedWithParams.getClass()) {
            return (AnnotatedWithParams) m11022a((AnnotatedMember) annotatedWithParams);
        }
        throw new IllegalArgumentException("Conflicting " + str + " creators: already had " + annotatedWithParams2 + ", encountered " + annotatedWithParams);
    }
}
