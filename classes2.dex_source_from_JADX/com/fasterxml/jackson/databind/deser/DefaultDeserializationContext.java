package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerator.IdKey;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;

/* compiled from: statusCode */
public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient LinkedHashMap<IdKey, ReadableObjectId> f4141e;

    /* compiled from: statusCode */
    public final class Impl extends DefaultDeserializationContext {
        private static final long serialVersionUID = 1;

        public Impl(DeserializerFactory deserializerFactory) {
            super(deserializerFactory, null);
        }

        private Impl(Impl impl, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
            super(impl, deserializationConfig, jsonParser, injectableValues);
        }

        private Impl(Impl impl, DeserializerFactory deserializerFactory) {
            super((DefaultDeserializationContext) impl, deserializerFactory);
        }

        public final DefaultDeserializationContext mo1075a(DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
            return new Impl(this, deserializationConfig, jsonParser, injectableValues);
        }

        public final DefaultDeserializationContext mo1076a(DeserializerFactory deserializerFactory) {
            return new Impl(this, deserializerFactory);
        }
    }

    public abstract DefaultDeserializationContext mo1075a(DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues);

    public abstract DefaultDeserializationContext mo1076a(DeserializerFactory deserializerFactory);

    protected DefaultDeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        super(deserializerFactory, deserializerCache);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser, InjectableValues injectableValues) {
        super(defaultDeserializationContext, deserializationConfig, jsonParser, injectableValues);
    }

    protected DefaultDeserializationContext(DefaultDeserializationContext defaultDeserializationContext, DeserializerFactory deserializerFactory) {
        super((DeserializationContext) defaultDeserializationContext, deserializerFactory);
    }

    public final ReadableObjectId mo1077a(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        ReadableObjectId readableObjectId;
        IdKey a = objectIdGenerator.a(obj);
        if (this.f4141e == null) {
            this.f4141e = new LinkedHashMap();
        } else {
            readableObjectId = (ReadableObjectId) this.f4141e.get(a);
            if (readableObjectId != null) {
                return readableObjectId;
            }
        }
        readableObjectId = new ReadableObjectId(obj);
        this.f4141e.put(a, readableObjectId);
        return readableObjectId;
    }

    public final JsonDeserializer<Object> mo1078b(Annotated annotated, Object obj) {
        JsonDeserializer<Object> jsonDeserializer = null;
        if (obj != null) {
            if (obj instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) obj;
            } else if (obj instanceof Class) {
                Class cls = (Class) obj;
                if (!(cls == None.class || cls == NoClass.class)) {
                    if (JsonDeserializer.class.isAssignableFrom(cls)) {
                        HandlerInstantiator l = this._config.m7267l();
                        if (l != null) {
                            jsonDeserializer = l.a();
                        }
                        if (jsonDeserializer == null) {
                            jsonDeserializer = (JsonDeserializer) ClassUtil.b(cls, this._config.m7263h());
                        }
                    } else {
                        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
                    }
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            if (jsonDeserializer instanceof ResolvableDeserializer) {
                ((ResolvableDeserializer) jsonDeserializer).a(this);
            }
        }
        return jsonDeserializer;
    }

    public final KeyDeserializer mo1079c(Annotated annotated, Object obj) {
        KeyDeserializer keyDeserializer = null;
        if (obj != null) {
            if (obj instanceof KeyDeserializer) {
                keyDeserializer = (KeyDeserializer) obj;
            } else if (obj instanceof Class) {
                Class cls = (Class) obj;
                if (!(cls == KeyDeserializer.None.class || cls == NoClass.class)) {
                    if (KeyDeserializer.class.isAssignableFrom(cls)) {
                        HandlerInstantiator l = this._config.m7267l();
                        if (l != null) {
                            keyDeserializer = l.b();
                        }
                        if (keyDeserializer == null) {
                            keyDeserializer = (KeyDeserializer) ClassUtil.b(cls, this._config.m7263h());
                        }
                    } else {
                        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
                    }
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            if (keyDeserializer instanceof ResolvableDeserializer) {
                ((ResolvableDeserializer) keyDeserializer).a(this);
            }
        }
        return keyDeserializer;
    }
}
