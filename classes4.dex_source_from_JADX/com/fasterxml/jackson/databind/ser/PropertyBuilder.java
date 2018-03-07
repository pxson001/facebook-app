package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;

/* compiled from: vault_table_cutoff_time */
public class PropertyBuilder {
    protected final SerializationConfig f336a;
    protected final BeanDescription f337b;
    protected final Include f338c;
    protected final AnnotationIntrospector f339d = this.f336a.a();
    protected Object f340e;

    /* compiled from: vault_table_cutoff_time */
    /* synthetic */ class C00341 {
        static final /* synthetic */ int[] f358a = new int[Include.values().length];

        static {
            try {
                f358a[Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f358a[Include.NON_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f358a[Include.NON_NULL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f358a[Include.ALWAYS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public PropertyBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        this.f336a = serializationConfig;
        this.f337b = beanDescription;
        this.f338c = beanDescription.a(serializationConfig.b());
    }

    public final Annotations m581a() {
        return this.f337b.g();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final com.fasterxml.jackson.databind.ser.BeanPropertyWriter m580a(com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition r13, com.fasterxml.jackson.databind.JavaType r14, com.fasterxml.jackson.databind.JsonSerializer<?> r15, com.fasterxml.jackson.databind.jsontype.TypeSerializer r16, com.fasterxml.jackson.databind.jsontype.TypeSerializer r17, com.fasterxml.jackson.databind.introspect.AnnotatedMember r18, boolean r19) {
        /*
        r12 = this;
        r0 = r18;
        r1 = r19;
        r2 = r12.m576a(r0, r1, r14);
        if (r17 == 0) goto L_0x00c6;
    L_0x000a:
        if (r2 != 0) goto L_0x000d;
    L_0x000c:
        r2 = r14;
    L_0x000d:
        r3 = r2.r();
        if (r3 != 0) goto L_0x004c;
    L_0x0013:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "Problem trying to create BeanPropertyWriter for property '";
        r4.<init>(r5);
        r5 = r13.mo22a();
        r4 = r4.append(r5);
        r5 = "' (of type ";
        r4 = r4.append(r5);
        r5 = r12.f337b;
        r5 = r5.a();
        r4 = r4.append(r5);
        r5 = "); serialization type ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " has no content";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x004c:
        r0 = r17;
        r9 = r2.b(r0);
    L_0x0052:
        r11 = 0;
        r2 = 0;
        r3 = r12.f339d;
        r4 = r12.f338c;
        r0 = r18;
        r3 = r3.a(r0, r4);
        if (r3 == 0) goto L_0x006b;
    L_0x0060:
        r4 = com.fasterxml.jackson.databind.ser.PropertyBuilder.C00341.f358a;
        r3 = r3.ordinal();
        r3 = r4[r3];
        switch(r3) {
            case 1: goto L_0x008d;
            case 2: goto L_0x00ac;
            case 3: goto L_0x00b1;
            case 4: goto L_0x00b2;
            default: goto L_0x006b;
        };
    L_0x006b:
        r10 = r2;
    L_0x006c:
        r2 = new com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
        r3 = r12.f337b;
        r5 = r3.g();
        r3 = r13;
        r4 = r18;
        r6 = r14;
        r7 = r15;
        r8 = r16;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        r3 = r12.f339d;
        r0 = r18;
        r3 = r3.b(r0);
        if (r3 == 0) goto L_0x008c;
    L_0x0088:
        r2 = r2.m562b(r3);
    L_0x008c:
        return r2;
    L_0x008d:
        r3 = r13.mo22a();
        r0 = r18;
        r11 = r12.m578a(r3, r0);
        if (r11 != 0) goto L_0x009c;
    L_0x0099:
        r2 = 1;
        r10 = r2;
        goto L_0x006c;
    L_0x009c:
        r3 = r11.getClass();
        r3 = r3.isArray();
        if (r3 == 0) goto L_0x006b;
    L_0x00a6:
        r11 = com.fasterxml.jackson.databind.util.ArrayBuilders.a(r11);
        r10 = r2;
        goto L_0x006c;
    L_0x00ac:
        r2 = 1;
        r11 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.f317a;
        r10 = r2;
        goto L_0x006c;
    L_0x00b1:
        r2 = 1;
    L_0x00b2:
        r3 = r14.l();
        if (r3 == 0) goto L_0x006b;
    L_0x00b8:
        r3 = r12.f336a;
        r4 = com.fasterxml.jackson.databind.SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
        r3 = r3.c(r4);
        if (r3 != 0) goto L_0x006b;
    L_0x00c2:
        r11 = com.fasterxml.jackson.databind.ser.BeanPropertyWriter.f317a;
        r10 = r2;
        goto L_0x006c;
    L_0x00c6:
        r9 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.PropertyBuilder.a(com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.JsonSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.introspect.AnnotatedMember, boolean):com.fasterxml.jackson.databind.ser.BeanPropertyWriter");
    }

    private JavaType m576a(Annotated annotated, boolean z, JavaType javaType) {
        JavaType c;
        boolean z2;
        boolean z3 = true;
        Class i = this.f339d.i(annotated);
        if (i != null) {
            Class cls = javaType._class;
            if (i.isAssignableFrom(cls)) {
                c = javaType.c(i);
            } else if (cls.isAssignableFrom(i)) {
                c = this.f336a.a(javaType, i);
            } else {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + annotated.b() + "': class " + i.getName() + " not a super-type of (declared) class " + cls.getName());
            }
            z = true;
        } else {
            c = javaType;
        }
        JavaType b = BasicSerializerFactory.b(this.f336a, annotated, c);
        if (b != c) {
            c = b;
            z2 = true;
        } else {
            z2 = z;
        }
        if (!z2) {
            Typing l = this.f339d.l(annotated);
            if (l != null) {
                if (l != Typing.STATIC) {
                    z3 = false;
                }
                if (z3) {
                    return null;
                }
                return c;
            }
        }
        z3 = z2;
        if (z3) {
            return null;
        }
        return c;
    }

    private Object m579b() {
        if (this.f340e == null) {
            this.f340e = this.f337b.a(this.f336a.h());
            if (this.f340e == null) {
                throw new IllegalArgumentException("Class " + this.f337b.c().a.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
            }
        }
        return this.f340e;
    }

    private Object m578a(String str, AnnotatedMember annotatedMember) {
        Object b = m579b();
        try {
            return annotatedMember.mo18b(b);
        } catch (Exception e) {
            return m577a(e, str, b);
        }
    }

    private static Object m577a(Exception exception, String str, Object obj) {
        Throwable th = exception;
        while (th.getCause() != null) {
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
        }
    }
}
