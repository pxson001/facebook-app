package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.deser.std.NullifyingDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: category_name */
public abstract class TypeDeserializerBase extends TypeDeserializer implements Serializable {
    private static final long serialVersionUID = 278445030337366675L;
    protected final JavaType _baseType;
    protected final JavaType _defaultImpl;
    protected JsonDeserializer<Object> _defaultImplDeserializer;
    protected final HashMap<String, JsonDeserializer<Object>> _deserializers;
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;
    protected final boolean _typeIdVisible;
    protected final String _typePropertyName;

    protected TypeDeserializerBase(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, Class<?> cls) {
        this._baseType = javaType;
        this._idResolver = typeIdResolver;
        this._typePropertyName = str;
        this._typeIdVisible = z;
        this._deserializers = new HashMap();
        if (cls == null) {
            this._defaultImpl = null;
        } else {
            this._defaultImpl = javaType.b(cls);
        }
        this._property = null;
    }

    protected TypeDeserializerBase(TypeDeserializerBase typeDeserializerBase, BeanProperty beanProperty) {
        this._baseType = typeDeserializerBase._baseType;
        this._idResolver = typeDeserializerBase._idResolver;
        this._typePropertyName = typeDeserializerBase._typePropertyName;
        this._typeIdVisible = typeDeserializerBase._typeIdVisible;
        this._deserializers = typeDeserializerBase._deserializers;
        this._defaultImpl = typeDeserializerBase._defaultImpl;
        this._defaultImplDeserializer = typeDeserializerBase._defaultImplDeserializer;
        this._property = beanProperty;
    }

    public final String m11418e() {
        return this._baseType._class.getName();
    }

    public final String mo694b() {
        return this._typePropertyName;
    }

    public final TypeIdResolver mo695c() {
        return this._idResolver;
    }

    public final Class<?> mo696d() {
        return this._defaultImpl == null ? null : this._defaultImpl._class;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(getClass().getName());
        stringBuilder.append("; base-type:").append(this._baseType);
        stringBuilder.append("; id-resolver: ").append(this._idResolver);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    protected final JsonDeserializer<Object> m11414a(DeserializationContext deserializationContext, String str) {
        JsonDeserializer<Object> jsonDeserializer;
        synchronized (this._deserializers) {
            jsonDeserializer = (JsonDeserializer) this._deserializers.get(str);
            if (jsonDeserializer == null) {
                JavaType a = this._idResolver.mo715a(str);
                if (a != null) {
                    if (this._baseType != null && this._baseType.getClass() == a.getClass()) {
                        a = this._baseType.a(a.c());
                    }
                    jsonDeserializer = deserializationContext.a(a, this._property);
                } else if (this._defaultImpl == null) {
                    throw deserializationContext.a(this._baseType, str);
                } else {
                    jsonDeserializer = m11413a(deserializationContext);
                }
                this._deserializers.put(str, jsonDeserializer);
            }
        }
        return jsonDeserializer;
    }

    protected final JsonDeserializer<Object> m11413a(DeserializationContext deserializationContext) {
        if (this._defaultImpl == null) {
            if (deserializationContext.a(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
                return null;
            }
            return NullifyingDeserializer.f6085a;
        } else if (this._defaultImpl.c() == NoClass.class) {
            return NullifyingDeserializer.f6085a;
        } else {
            JsonDeserializer<Object> jsonDeserializer;
            synchronized (this._defaultImpl) {
                if (this._defaultImplDeserializer == null) {
                    this._defaultImplDeserializer = deserializationContext.a(this._defaultImpl, this._property);
                }
                jsonDeserializer = this._defaultImplDeserializer;
            }
            return jsonDeserializer;
        }
    }
}
