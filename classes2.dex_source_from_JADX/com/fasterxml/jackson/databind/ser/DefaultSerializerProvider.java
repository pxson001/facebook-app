package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* compiled from: sticker_in_comments_nux */
public abstract class DefaultSerializerProvider extends SerializerProvider implements Serializable {
    private static final long serialVersionUID = 1;
    protected transient IdentityHashMap<Object, WritableObjectId> f4131d;
    protected transient ArrayList<ObjectIdGenerator<?>> f4132e;

    /* compiled from: sticker_in_comments_nux */
    public final class Impl extends DefaultSerializerProvider {
        private static final long serialVersionUID = 1;

        private Impl(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
            super(serializerProvider, serializationConfig, serializerFactory);
        }

        public final DefaultSerializerProvider mo1067a(SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
            return new Impl(this, serializationConfig, serializerFactory);
        }
    }

    public abstract DefaultSerializerProvider mo1067a(SerializationConfig serializationConfig, SerializerFactory serializerFactory);

    protected DefaultSerializerProvider() {
    }

    protected DefaultSerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory serializerFactory) {
        super(serializerProvider, serializationConfig, serializerFactory);
    }

    public final void m7294a(JsonGenerator jsonGenerator, Object obj) {
        JsonSerializer j;
        boolean z = false;
        if (obj == null) {
            j = m7327j();
        } else {
            JsonSerializer a = m7309a(obj.getClass(), true, null);
            String t = this._config.m7250t();
            if (t == null) {
                z = this._config.m7246c(SerializationFeature.WRAP_ROOT_VALUE);
                if (z) {
                    jsonGenerator.mo1134f();
                    jsonGenerator.mo1122b(this._rootNames.m7234a(obj.getClass(), this._config));
                    j = a;
                } else {
                    j = a;
                }
            } else if (t.length() == 0) {
                j = a;
            } else {
                jsonGenerator.mo1134f();
                jsonGenerator.mo1115a(t);
                z = true;
                j = a;
            }
        }
        try {
            j.mo1072a(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.mo1136g();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, th);
        }
    }

    public final void m7295a(JsonGenerator jsonGenerator, Object obj, JavaType javaType, JsonSerializer<Object> jsonSerializer) {
        boolean z;
        if (obj == null) {
            jsonSerializer = m7327j();
            z = false;
        } else {
            if (!(javaType == null || javaType.m6708c().isAssignableFrom(obj.getClass()))) {
                SerializerProvider.m7300a(obj, javaType);
            }
            if (jsonSerializer == null) {
                jsonSerializer = m7306a(javaType, true, null);
            }
            z = this._config.m7246c(SerializationFeature.WRAP_ROOT_VALUE);
            if (z) {
                jsonGenerator.mo1134f();
                jsonGenerator.mo1122b(this._rootNames.m7233a(javaType, this._config));
            }
        }
        try {
            jsonSerializer.mo1072a(obj, jsonGenerator, this);
            if (z) {
                jsonGenerator.mo1136g();
            }
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwable th = e2;
            String message = th.getMessage();
            if (message == null) {
                message = "[no message for " + th.getClass().getName() + "]";
            }
            throw new JsonMappingException(message, th);
        }
    }

    public final WritableObjectId mo1068a(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        ObjectIdGenerator objectIdGenerator2;
        if (this.f4131d == null) {
            this.f4131d = new IdentityHashMap();
        } else {
            WritableObjectId writableObjectId = (WritableObjectId) this.f4131d.get(obj);
            if (writableObjectId != null) {
                return writableObjectId;
            }
        }
        if (this.f4132e == null) {
            this.f4132e = new ArrayList(8);
            objectIdGenerator2 = null;
        } else {
            int size = this.f4132e.size();
            for (int i = 0; i < size; i++) {
                objectIdGenerator2 = (ObjectIdGenerator) this.f4132e.get(i);
                if (objectIdGenerator2.a(objectIdGenerator)) {
                    break;
                }
            }
            objectIdGenerator2 = null;
        }
        if (objectIdGenerator2 == null) {
            objectIdGenerator2 = objectIdGenerator.b();
            this.f4132e.add(objectIdGenerator2);
        }
        WritableObjectId writableObjectId2 = new WritableObjectId(objectIdGenerator2);
        this.f4131d.put(obj, writableObjectId2);
        return writableObjectId2;
    }

    public final JsonSerializer<Object> mo1069b(Annotated annotated, Object obj) {
        JsonSerializer<Object> jsonSerializer = null;
        if (obj == null) {
            return null;
        }
        JsonSerializer jsonSerializer2;
        if (obj instanceof JsonSerializer) {
            jsonSerializer2 = (JsonSerializer) obj;
        } else if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == None.class || cls == NoClass.class) {
                return null;
            }
            if (JsonSerializer.class.isAssignableFrom(cls)) {
                HandlerInstantiator l = this._config.m7267l();
                if (l != null) {
                    jsonSerializer = l.c();
                }
                if (jsonSerializer == null) {
                    jsonSerializer2 = (JsonSerializer) ClassUtil.b(cls, this._config.m7263h());
                } else {
                    JsonSerializer<Object> jsonSerializer3 = jsonSerializer;
                }
            } else {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
            }
        } else {
            throw new IllegalStateException("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
        }
        return m7307a(jsonSerializer2);
    }
}
