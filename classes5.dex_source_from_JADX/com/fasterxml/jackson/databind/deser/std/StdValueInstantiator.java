package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.Serializable;

/* compiled from: checkbox */
public class StdValueInstantiator extends ValueInstantiator implements Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _cfgEmptyStringsAsObjects;
    protected CreatorProperty[] _constructorArguments;
    protected AnnotatedWithParams _defaultCreator;
    protected CreatorProperty[] _delegateArguments;
    protected AnnotatedWithParams _delegateCreator;
    protected JavaType _delegateType;
    public AnnotatedWithParams _fromBooleanCreator;
    public AnnotatedWithParams _fromDoubleCreator;
    public AnnotatedWithParams _fromIntCreator;
    public AnnotatedWithParams _fromLongCreator;
    public AnnotatedWithParams _fromStringCreator;
    public AnnotatedParameter _incompleteParameter;
    protected final String _valueTypeDesc;
    protected AnnotatedWithParams _withArgsCreator;

    public StdValueInstantiator(DeserializationConfig deserializationConfig, JavaType javaType) {
        boolean z;
        if (deserializationConfig == null) {
            z = false;
        } else {
            z = deserializationConfig.c(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        }
        this._cfgEmptyStringsAsObjects = z;
        this._valueTypeDesc = javaType == null ? "UNKNOWN TYPE" : javaType.toString();
    }

    public final void m11319a(AnnotatedWithParams annotatedWithParams, AnnotatedWithParams annotatedWithParams2, JavaType javaType, CreatorProperty[] creatorPropertyArr, AnnotatedWithParams annotatedWithParams3, CreatorProperty[] creatorPropertyArr2) {
        this._defaultCreator = annotatedWithParams;
        this._delegateCreator = annotatedWithParams2;
        this._delegateType = javaType;
        this._delegateArguments = creatorPropertyArr;
        this._withArgsCreator = annotatedWithParams3;
        this._constructorArguments = creatorPropertyArr2;
    }

    public final void m11318a(AnnotatedWithParams annotatedWithParams) {
        this._fromStringCreator = annotatedWithParams;
    }

    public final void m11321b(AnnotatedWithParams annotatedWithParams) {
        this._fromIntCreator = annotatedWithParams;
    }

    public final void m11322c(AnnotatedWithParams annotatedWithParams) {
        this._fromLongCreator = annotatedWithParams;
    }

    public final void m11324d(AnnotatedWithParams annotatedWithParams) {
        this._fromDoubleCreator = annotatedWithParams;
    }

    public final void m11326e(AnnotatedWithParams annotatedWithParams) {
        this._fromBooleanCreator = annotatedWithParams;
    }

    public final void m11317a(AnnotatedParameter annotatedParameter) {
        this._incompleteParameter = annotatedParameter;
    }

    public final String mo671a() {
        return this._valueTypeDesc;
    }

    public final boolean mo680c() {
        return this._fromStringCreator != null;
    }

    public final boolean mo681d() {
        return this._fromIntCreator != null;
    }

    public final boolean mo682e() {
        return this._fromLongCreator != null;
    }

    public final boolean mo683f() {
        return this._fromDoubleCreator != null;
    }

    public final boolean mo684g() {
        return this._fromBooleanCreator != null;
    }

    public final boolean mo685h() {
        return this._defaultCreator != null;
    }

    public final boolean mo686i() {
        return this._delegateType != null;
    }

    public final boolean mo673j() {
        return this._withArgsCreator != null;
    }

    public final JavaType mo687k() {
        return this._delegateType;
    }

    public final SettableBeanProperty[] mo672a(DeserializationConfig deserializationConfig) {
        return (SettableBeanProperty[]) this._constructorArguments;
    }

    public final Object mo688l() {
        if (this._defaultCreator == null) {
            throw new IllegalStateException("No default constructor for " + mo671a());
        }
        try {
            return this._defaultCreator.h();
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo670a(Object[] objArr) {
        if (this._withArgsCreator == null) {
            throw new IllegalStateException("No with-args constructor for " + mo671a());
        }
        try {
            return this._withArgsCreator.a(objArr);
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo677a(DeserializationContext deserializationContext, Object obj) {
        if (this._delegateCreator == null) {
            throw new IllegalStateException("No delegate constructor for " + mo671a());
        }
        try {
            if (this._delegateArguments == null) {
                return this._delegateCreator.a(obj);
            }
            int length = this._delegateArguments.length;
            Object[] objArr = new Object[length];
            for (int i = 0; i < length; i++) {
                SettableBeanProperty settableBeanProperty = this._delegateArguments[i];
                if (settableBeanProperty == null) {
                    objArr[i] = obj;
                } else {
                    objArr[i] = deserializationContext.a(settableBeanProperty.mo655d(), settableBeanProperty, null);
                }
            }
            return this._delegateCreator.a(objArr);
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo678a(DeserializationContext deserializationContext, String str) {
        if (this._fromStringCreator == null) {
            return m11308b(deserializationContext, str);
        }
        try {
            return this._fromStringCreator.a(str);
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo675a(int i) {
        try {
            if (this._fromIntCreator != null) {
                return this._fromIntCreator.a(Integer.valueOf(i));
            }
            if (this._fromLongCreator != null) {
                return this._fromLongCreator.a(Long.valueOf((long) i));
            }
            throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Integral number; no single-int-arg constructor/factory method");
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo676a(long j) {
        try {
            if (this._fromLongCreator != null) {
                return this._fromLongCreator.a(Long.valueOf(j));
            }
            throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Long integral number; no single-long-arg constructor/factory method");
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo674a(double d) {
        try {
            if (this._fromDoubleCreator != null) {
                return this._fromDoubleCreator.a(Double.valueOf(d));
            }
            throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Floating-point number; no one-double/Double-arg constructor/factory method");
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final Object mo679a(boolean z) {
        try {
            if (this._fromBooleanCreator != null) {
                return this._fromBooleanCreator.a(Boolean.valueOf(z));
            }
            throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from Boolean value; no single-boolean/Boolean-arg constructor/factory method");
        } catch (Throwable e) {
            throw m11307a(e);
        } catch (Throwable e2) {
            throw m11307a(e2);
        }
    }

    public final AnnotatedWithParams mo690n() {
        return this._delegateCreator;
    }

    public final AnnotatedWithParams mo689m() {
        return this._defaultCreator;
    }

    public final AnnotatedParameter mo691o() {
        return this._incompleteParameter;
    }

    private Object m11308b(DeserializationContext deserializationContext, String str) {
        if (this._fromBooleanCreator != null) {
            String trim = str.trim();
            if ("true".equals(trim)) {
                return mo679a(true);
            }
            if ("false".equals(trim)) {
                return mo679a(false);
            }
        }
        if (this._cfgEmptyStringsAsObjects && str.length() == 0) {
            return null;
        }
        throw new JsonMappingException("Can not instantiate value of type " + mo671a() + " from String value; no single-String constructor/factory method");
    }

    private JsonMappingException m11307a(Throwable th) {
        Throwable th2 = th;
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof JsonMappingException) {
            return (JsonMappingException) th2;
        }
        return new JsonMappingException("Instantiation of " + mo671a() + " value failed: " + th2.getMessage(), th2);
    }
}
