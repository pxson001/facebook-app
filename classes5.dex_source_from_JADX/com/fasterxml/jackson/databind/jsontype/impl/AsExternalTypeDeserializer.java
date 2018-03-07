package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo$As;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

/* compiled from: category_discover_landing */
public class AsExternalTypeDeserializer extends AsArrayTypeDeserializer {
    private static final long serialVersionUID = 1;

    public AsExternalTypeDeserializer(JavaType javaType, TypeIdResolver typeIdResolver, String str, boolean z, Class<?> cls) {
        super(javaType, typeIdResolver, str, z, cls);
    }

    private AsExternalTypeDeserializer(AsExternalTypeDeserializer asExternalTypeDeserializer, BeanProperty beanProperty) {
        super(asExternalTypeDeserializer, beanProperty);
    }

    public final TypeDeserializer mo698a(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsExternalTypeDeserializer(this, beanProperty);
    }

    public final JsonTypeInfo$As mo697a() {
        return JsonTypeInfo$As.EXTERNAL_PROPERTY;
    }
}
