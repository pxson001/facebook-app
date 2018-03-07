package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: stop_pri */
public abstract class MapperConfig<T extends MapperConfig<T>> implements MixInResolver, Serializable {
    private static final long serialVersionUID = 8891625428805876137L;
    protected final BaseSettings _base;
    protected final int _mapperFeatures;

    public abstract BeanDescription mo1062a(JavaType javaType);

    protected MapperConfig(BaseSettings baseSettings, int i) {
        this._base = baseSettings;
        this._mapperFeatures = i;
    }

    protected MapperConfig(MapperConfig<T> mapperConfig) {
        this._base = mapperConfig._base;
        this._mapperFeatures = mapperConfig._mapperFeatures;
    }

    public static <F extends Enum<F> & ConfigFeature> int m7252a(Class<F> cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int length = enumArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int mask;
            Enum enumR = enumArr[i];
            if (((ConfigFeature) enumR).enabledByDefault()) {
                mask = ((ConfigFeature) enumR).getMask() | i2;
            } else {
                mask = i2;
            }
            i++;
            i2 = mask;
        }
        return i2;
    }

    public final boolean m7257a(MapperFeature mapperFeature) {
        return (this._mapperFeatures & mapperFeature.getMask()) != 0;
    }

    public final boolean m7262g() {
        return m7257a(MapperFeature.USE_ANNOTATIONS);
    }

    public final boolean m7263h() {
        return m7257a(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public final boolean m7264i() {
        return m7257a(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public final ClassIntrospector m7265j() {
        return this._base._classIntrospector;
    }

    public AnnotationIntrospector mo1061a() {
        return this._base._annotationIntrospector;
    }

    public VisibilityChecker<?> mo1063c() {
        return this._base._visibilityChecker;
    }

    public final PropertyNamingStrategy m7266k() {
        return this._base._propertyNamingStrategy;
    }

    public final HandlerInstantiator m7267l() {
        return this._base._handlerInstantiator;
    }

    public final TypeResolverBuilder<?> m7268m() {
        return this._base._typeResolverBuilder;
    }

    public final TypeFactory m7269n() {
        return this._base._typeFactory;
    }

    public final JavaType m7258b(Class<?> cls) {
        return m7269n().m7110a((Type) cls, null);
    }

    public final JavaType m7255a(JavaType javaType, Class<?> cls) {
        return m7269n().m7106a(javaType, (Class) cls);
    }

    public final BeanDescription m7260c(Class<?> cls) {
        return mo1062a(m7258b(cls));
    }

    public final DateFormat m7270o() {
        return this._base._dateFormat;
    }

    public final Locale m7271p() {
        return this._base._locale;
    }

    public final TimeZone m7272q() {
        return this._base._timeZone;
    }

    public final Base64Variant m7273r() {
        return this._base._defaultBase64;
    }

    public final TypeResolverBuilder<?> m7256a(Annotated annotated, Class<? extends TypeResolverBuilder<?>> cls) {
        HandlerInstantiator l = m7267l();
        if (l != null) {
            TypeResolverBuilder<?> d = l.d();
            if (d != null) {
                return d;
            }
        }
        return (TypeResolverBuilder) ClassUtil.b(cls, m7263h());
    }

    public final TypeIdResolver m7259b(Annotated annotated, Class<? extends TypeIdResolver> cls) {
        HandlerInstantiator l = m7267l();
        if (l != null) {
            TypeIdResolver e = l.e();
            if (e != null) {
                return e;
            }
        }
        return (TypeIdResolver) ClassUtil.b(cls, m7263h());
    }
}
