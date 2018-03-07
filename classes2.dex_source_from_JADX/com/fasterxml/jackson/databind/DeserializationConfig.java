package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
import java.io.Serializable;
import java.util.Map;

/* compiled from: sticker_search */
public final class DeserializationConfig extends MapperConfigBase<DeserializationFeature, DeserializationConfig> implements Serializable {
    private static final long serialVersionUID = -4227480407273773599L;
    public final int _deserFeatures;
    public final JsonNodeFactory _nodeFactory;
    public final LinkedNode<DeserializationProblemHandler> _problemHandlers;

    public DeserializationConfig(BaseSettings baseSettings, SubtypeResolver subtypeResolver, Map<ClassKey, Class<?>> map) {
        super(baseSettings, subtypeResolver, map);
        this._deserFeatures = MapperConfig.m7252a(DeserializationFeature.class);
        this._nodeFactory = JsonNodeFactory.f3121a;
        this._problemHandlers = null;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, int i, int i2) {
        super((MapperConfigBase) deserializationConfig, i);
        this._deserFeatures = i2;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._problemHandlers = deserializationConfig._problemHandlers;
    }

    private DeserializationConfig(DeserializationConfig deserializationConfig, BaseSettings baseSettings) {
        super((MapperConfigBase) deserializationConfig, baseSettings);
        this._deserFeatures = deserializationConfig._deserFeatures;
        this._nodeFactory = deserializationConfig._nodeFactory;
        this._problemHandlers = deserializationConfig._problemHandlers;
    }

    public final DeserializationConfig m7278a(PropertyAccessor propertyAccessor, Visibility visibility) {
        return m7275a(this._base.m7071a(propertyAccessor, visibility));
    }

    public final DeserializationConfig m7280a(TypeFactory typeFactory) {
        return m7275a(this._base.m7072a(typeFactory));
    }

    private final DeserializationConfig m7275a(BaseSettings baseSettings) {
        return this._base == baseSettings ? this : new DeserializationConfig(this, baseSettings);
    }

    public final DeserializationConfig m7279a(DeserializationFeature deserializationFeature) {
        int mask = deserializationFeature.getMask() | this._deserFeatures;
        return mask == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, mask);
    }

    public final DeserializationConfig m7282b(DeserializationFeature deserializationFeature) {
        int mask = (deserializationFeature.getMask() ^ -1) & this._deserFeatures;
        return mask == this._deserFeatures ? this : new DeserializationConfig(this, this._mapperFeatures, mask);
    }

    public final AnnotationIntrospector mo1061a() {
        if (m7257a(MapperFeature.USE_ANNOTATIONS)) {
            return super.mo1061a();
        }
        return NopAnnotationIntrospector.a;
    }

    public final boolean m7283b() {
        if (this._rootName != null) {
            return this._rootName.length() > 0;
        } else {
            return m7286c(DeserializationFeature.UNWRAP_ROOT_VALUE);
        }
    }

    public final BeanDescription mo1062a(JavaType javaType) {
        return m7265j().mo933b((MapperConfig) this, javaType, (MixInResolver) this);
    }

    public final VisibilityChecker<?> mo1063c() {
        VisibilityChecker<?> c = super.mo1063c();
        if (!m7257a(MapperFeature.AUTO_DETECT_SETTERS)) {
            c = c.mo1034c(Visibility.NONE);
        }
        if (!m7257a(MapperFeature.AUTO_DETECT_CREATORS)) {
            c = c.mo1036d(Visibility.NONE);
        }
        if (m7257a(MapperFeature.AUTO_DETECT_FIELDS)) {
            return c;
        }
        return c.mo1037e(Visibility.NONE);
    }

    public final boolean m7286c(DeserializationFeature deserializationFeature) {
        return (this._deserFeatures & deserializationFeature.getMask()) != 0;
    }

    public final int m7287d() {
        return this._deserFeatures;
    }

    public final LinkedNode<DeserializationProblemHandler> m7289e() {
        return this._problemHandlers;
    }

    public final JsonNodeFactory m7290f() {
        return this._nodeFactory;
    }

    public final <T extends BeanDescription> T m7281b(JavaType javaType) {
        return m7265j().mo935d(this, javaType, this);
    }

    public final <T extends BeanDescription> T m7284c(JavaType javaType) {
        return m7265j().mo931b(this, javaType, (MixInResolver) this);
    }

    public final <T extends BeanDescription> T m7288d(JavaType javaType) {
        return m7265j().mo934c(this, javaType, this);
    }
}
