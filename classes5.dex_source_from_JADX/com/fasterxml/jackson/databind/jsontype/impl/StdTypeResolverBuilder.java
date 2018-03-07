package com.fasterxml.jackson.databind.jsontype.impl;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.annotation.JsonTypeInfo$As;
import com.fasterxml.jackson.annotation.JsonTypeInfo$Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.Collection;

/* compiled from: captureStarted while  */
public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    protected JsonTypeInfo$Id f6128a;
    protected JsonTypeInfo$As f6129b;
    protected String f6130c;
    protected boolean f6131d = false;
    protected Class<?> f6132e;
    protected TypeIdResolver f6133f;

    /* compiled from: captureStarted while  */
    /* synthetic */ class C05551 {
        static final /* synthetic */ int[] f6126a = new int[JsonTypeInfo$As.values().length];
        static final /* synthetic */ int[] f6127b = new int[JsonTypeInfo$Id.values().length];

        static {
            try {
                f6127b[JsonTypeInfo$Id.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6127b[JsonTypeInfo$Id.MINIMAL_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6127b[JsonTypeInfo$Id.NAME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6127b[JsonTypeInfo$Id.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6127b[JsonTypeInfo$Id.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6126a[JsonTypeInfo$As.WRAPPER_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6126a[JsonTypeInfo$As.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6126a[JsonTypeInfo$As.WRAPPER_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6126a[JsonTypeInfo$As.EXTERNAL_PROPERTY.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public final /* synthetic */ TypeResolverBuilder mo720a(JsonTypeInfo$Id jsonTypeInfo$Id, TypeIdResolver typeIdResolver) {
        return m11497b(jsonTypeInfo$Id, typeIdResolver);
    }

    public static StdTypeResolverBuilder m11496b() {
        return new StdTypeResolverBuilder().m11497b(JsonTypeInfo$Id.NONE, null);
    }

    private StdTypeResolverBuilder m11497b(JsonTypeInfo$Id jsonTypeInfo$Id, TypeIdResolver typeIdResolver) {
        if (jsonTypeInfo$Id == null) {
            throw new IllegalArgumentException("idType can not be null");
        }
        this.f6128a = jsonTypeInfo$Id;
        this.f6133f = typeIdResolver;
        this.f6130c = jsonTypeInfo$Id.getDefaultPropertyName();
        return this;
    }

    public final TypeSerializer mo724a(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this.f6128a == JsonTypeInfo$Id.NONE) {
            return null;
        }
        TypeIdResolver a = m11495a(serializationConfig, javaType, collection, true, false);
        switch (C05551.f6126a[this.f6129b.ordinal()]) {
            case 1:
                return new AsArrayTypeSerializer(a, null);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return new AsPropertyTypeSerializer(a, null, this.f6130c);
            case 3:
                return new AsWrapperTypeSerializer(a, null);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return new AsExternalTypeSerializer(a, null, this.f6130c);
            default:
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f6129b);
        }
    }

    public final TypeDeserializer mo718a(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection) {
        if (this.f6128a == JsonTypeInfo$Id.NONE) {
            return null;
        }
        TypeIdResolver a = m11495a(deserializationConfig, javaType, collection, false, true);
        switch (C05551.f6126a[this.f6129b.ordinal()]) {
            case 1:
                return new AsArrayTypeDeserializer(javaType, a, this.f6130c, this.f6131d, this.f6132e);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return new AsPropertyTypeDeserializer(javaType, a, this.f6130c, this.f6131d, this.f6132e);
            case 3:
                return new AsWrapperTypeDeserializer(javaType, a, this.f6130c, this.f6131d);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return new AsExternalTypeDeserializer(javaType, a, this.f6130c, this.f6131d, this.f6132e);
            default:
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.f6129b);
        }
    }

    public final TypeResolverBuilder mo719a(JsonTypeInfo$As jsonTypeInfo$As) {
        if (jsonTypeInfo$As == null) {
            throw new IllegalArgumentException("includeAs can not be null");
        }
        this.f6129b = jsonTypeInfo$As;
        return this;
    }

    public final TypeResolverBuilder mo722a(String str) {
        if (str == null || str.length() == 0) {
            str = this.f6128a.getDefaultPropertyName();
        }
        this.f6130c = str;
        return this;
    }

    public final TypeResolverBuilder mo721a(Class cls) {
        this.f6132e = cls;
        return this;
    }

    public final TypeResolverBuilder mo723a(boolean z) {
        this.f6131d = z;
        return this;
    }

    public final Class<?> mo725a() {
        return this.f6132e;
    }

    private TypeIdResolver m11495a(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        if (this.f6133f != null) {
            return this.f6133f;
        }
        if (this.f6128a == null) {
            throw new IllegalStateException("Can not build, 'init()' not yet called");
        }
        switch (C05551.f6127b[this.f6128a.ordinal()]) {
            case 1:
                return new ClassNameIdResolver(javaType, mapperConfig.n());
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return new MinimalClassNameIdResolver(javaType, mapperConfig.n());
            case 3:
                return TypeNameIdResolver.m11506a(mapperConfig, javaType, collection, z, z2);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return null;
            default:
                throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.f6128a);
        }
    }
}
