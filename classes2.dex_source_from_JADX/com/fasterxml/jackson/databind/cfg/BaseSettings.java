package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: story_cache_id */
public final class BaseSettings implements Serializable {
    private static final long serialVersionUID = 4939673998947122190L;
    public final AnnotationIntrospector _annotationIntrospector;
    public final ClassIntrospector _classIntrospector;
    public final DateFormat _dateFormat;
    public final Base64Variant _defaultBase64;
    public final HandlerInstantiator _handlerInstantiator;
    public final Locale _locale;
    public final PropertyNamingStrategy _propertyNamingStrategy;
    public final TimeZone _timeZone;
    public final TypeFactory _typeFactory;
    public final TypeResolverBuilder<?> _typeResolverBuilder;
    public final VisibilityChecker<?> _visibilityChecker;

    public BaseSettings(ClassIntrospector classIntrospector, AnnotationIntrospector annotationIntrospector, VisibilityChecker<?> visibilityChecker, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, TypeResolverBuilder<?> typeResolverBuilder, DateFormat dateFormat, HandlerInstantiator handlerInstantiator, Locale locale, TimeZone timeZone, Base64Variant base64Variant) {
        this._classIntrospector = classIntrospector;
        this._annotationIntrospector = annotationIntrospector;
        this._visibilityChecker = visibilityChecker;
        this._propertyNamingStrategy = propertyNamingStrategy;
        this._typeFactory = typeFactory;
        this._typeResolverBuilder = typeResolverBuilder;
        this._dateFormat = dateFormat;
        this._handlerInstantiator = handlerInstantiator;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = base64Variant;
    }

    public final BaseSettings m7071a(PropertyAccessor propertyAccessor, Visibility visibility) {
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker.mo1028a(propertyAccessor, visibility), this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public final BaseSettings m7072a(TypeFactory typeFactory) {
        if (this._typeFactory == typeFactory) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }

    public final ClassIntrospector m7073a() {
        return this._classIntrospector;
    }

    public final AnnotationIntrospector m7074b() {
        return this._annotationIntrospector;
    }

    public final VisibilityChecker<?> m7075c() {
        return this._visibilityChecker;
    }

    public final PropertyNamingStrategy m7076d() {
        return this._propertyNamingStrategy;
    }

    public final TypeFactory m7077e() {
        return this._typeFactory;
    }

    public final TypeResolverBuilder<?> m7078f() {
        return this._typeResolverBuilder;
    }

    public final DateFormat m7079g() {
        return this._dateFormat;
    }

    public final HandlerInstantiator m7080h() {
        return this._handlerInstantiator;
    }

    public final Locale m7081i() {
        return this._locale;
    }

    public final TimeZone m7082j() {
        return this._timeZone;
    }

    public final Base64Variant m7083k() {
        return this._defaultBase64;
    }
}
