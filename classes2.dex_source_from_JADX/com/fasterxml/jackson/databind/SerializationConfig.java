package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.util.Map;

/* compiled from: store/ */
public final class SerializationConfig extends MapperConfigBase<SerializationFeature, SerializationConfig> implements Serializable {
    private static final long serialVersionUID = 8849092838541724233L;
    public final FilterProvider _filterProvider;
    protected final int _serFeatures;
    protected JsonInclude$Include _serializationInclusion;

    public SerializationConfig(BaseSettings baseSettings, SubtypeResolver subtypeResolver, Map<ClassKey, Class<?>> map) {
        super(baseSettings, subtypeResolver, map);
        this._serializationInclusion = null;
        this._serFeatures = MapperConfig.m7252a(SerializationFeature.class);
        this._filterProvider = null;
    }

    private SerializationConfig(SerializationConfig serializationConfig, int i, int i2) {
        super((MapperConfigBase) serializationConfig, i);
        this._serializationInclusion = null;
        this._serFeatures = i2;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
    }

    private SerializationConfig(SerializationConfig serializationConfig, BaseSettings baseSettings) {
        super((MapperConfigBase) serializationConfig, baseSettings);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = serializationConfig._serializationInclusion;
        this._filterProvider = serializationConfig._filterProvider;
    }

    private SerializationConfig(SerializationConfig serializationConfig, JsonInclude$Include jsonInclude$Include) {
        super(serializationConfig);
        this._serializationInclusion = null;
        this._serFeatures = serializationConfig._serFeatures;
        this._serializationInclusion = jsonInclude$Include;
        this._filterProvider = serializationConfig._filterProvider;
    }

    public final SerializationConfig m7241a(TypeFactory typeFactory) {
        return m7235a(this._base.m7072a(typeFactory));
    }

    public final SerializationConfig m7239a(PropertyAccessor propertyAccessor, Visibility visibility) {
        return m7235a(this._base.m7071a(propertyAccessor, visibility));
    }

    private final SerializationConfig m7235a(BaseSettings baseSettings) {
        return this._base == baseSettings ? this : new SerializationConfig(this, baseSettings);
    }

    public final SerializationConfig m7240a(SerializationFeature serializationFeature) {
        int mask = serializationFeature.getMask() | this._serFeatures;
        return mask == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, mask);
    }

    public final SerializationConfig m7244b(SerializationFeature serializationFeature) {
        int mask = (serializationFeature.getMask() ^ -1) & this._serFeatures;
        return mask == this._serFeatures ? this : new SerializationConfig(this, this._mapperFeatures, mask);
    }

    public final SerializationConfig m7238a(JsonInclude$Include jsonInclude$Include) {
        return this._serializationInclusion == jsonInclude$Include ? this : new SerializationConfig(this, jsonInclude$Include);
    }

    public final AnnotationIntrospector mo1061a() {
        if (m7257a(MapperFeature.USE_ANNOTATIONS)) {
            return super.mo1061a();
        }
        return NopAnnotationIntrospector.a;
    }

    public final BeanDescription mo1062a(JavaType javaType) {
        return m7265j().mo933b((MapperConfig) this, javaType, (MixInResolver) this);
    }

    public final VisibilityChecker<?> mo1063c() {
        VisibilityChecker<?> c = super.mo1063c();
        if (!m7257a(MapperFeature.AUTO_DETECT_GETTERS)) {
            c = c.mo1026a(Visibility.NONE);
        }
        if (!m7257a(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
            c = c.mo1032b(Visibility.NONE);
        }
        if (m7257a(MapperFeature.AUTO_DETECT_FIELDS)) {
            return c;
        }
        return c.mo1037e(Visibility.NONE);
    }

    public final boolean m7246c(SerializationFeature serializationFeature) {
        return (this._serFeatures & serializationFeature.getMask()) != 0;
    }

    public final JsonInclude$Include m7242b() {
        if (this._serializationInclusion != null) {
            return this._serializationInclusion;
        }
        return JsonInclude$Include.ALWAYS;
    }

    public final FilterProvider m7247d() {
        return this._filterProvider;
    }

    public final <T extends BeanDescription> T m7243b(JavaType javaType) {
        return m7265j().mo932b(this, javaType, (MixInResolver) this);
    }

    public final String toString() {
        return "[SerializationConfig: flags=0x" + Integer.toHexString(this._serFeatures) + "]";
    }
}
