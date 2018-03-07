package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Empty;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@JacksonStdImpl
/* compiled from: can_viewer_promote_as_parent */
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> implements ContextualSerializer {
    protected final boolean f6202a;
    protected final JavaType f6203b;
    protected final TypeSerializer f6204d;
    protected JsonSerializer<Object> f6205e;
    protected PropertySerializerMap f6206f;

    public final boolean m11685a(Object obj) {
        Object[] objArr = (Object[]) obj;
        return objArr == null || objArr.length == 0;
    }

    public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length != 0) {
            if (this.f6205e != null) {
                m11682a(objArr, jsonGenerator, serializerProvider, this.f6205e);
            } else if (this.f6204d != null) {
                m11683b(objArr, jsonGenerator, serializerProvider);
            } else {
                int i = 0;
                try {
                    PropertySerializerMap propertySerializerMap = this.f6206f;
                    while (i < length) {
                        Object obj2 = objArr[i];
                        if (obj2 == null) {
                            serializerProvider.a(jsonGenerator);
                        } else {
                            Class cls = obj2.getClass();
                            JsonSerializer a = propertySerializerMap.a(cls);
                            if (a == null) {
                                if (this.f6203b.p()) {
                                    a = m11679a(propertySerializerMap, serializerProvider.a(this.f6203b, cls), serializerProvider);
                                } else {
                                    a = m11680a(propertySerializerMap, cls, serializerProvider);
                                }
                            }
                            a.a(obj2, jsonGenerator, serializerProvider);
                        }
                        i++;
                    }
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                    while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                        e3 = e3.getCause();
                    }
                    if (e3 instanceof Error) {
                        throw ((Error) e3);
                    }
                    throw JsonMappingException.a(e3, null, 0);
                }
            }
        }
    }

    public final boolean m11688b(Object obj) {
        return ((Object[]) obj).length == 1;
    }

    public ObjectArraySerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Object[].class, null);
        this.f6203b = javaType;
        this.f6202a = z;
        this.f6204d = typeSerializer;
        this.f6206f = Empty.a;
        this.f6205e = jsonSerializer;
    }

    private ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super((ArraySerializerBase) objectArraySerializer, beanProperty);
        this.f6203b = objectArraySerializer.f6203b;
        this.f6204d = typeSerializer;
        this.f6202a = objectArraySerializer.f6202a;
        this.f6206f = objectArraySerializer.f6206f;
        this.f6205e = jsonSerializer;
    }

    public final ContainerSerializer<?> m11686b(TypeSerializer typeSerializer) {
        return new ObjectArraySerializer(this.f6203b, this.f6202a, typeSerializer, this.f6205e);
    }

    private ObjectArraySerializer m11681a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        return (this.f6178c == beanProperty && jsonSerializer == this.f6205e && this.f6204d == typeSerializer) ? this : new ObjectArraySerializer(this, beanProperty, typeSerializer, (JsonSerializer) jsonSerializer);
    }

    public final JsonSerializer<?> m11684a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        TypeSerializer a;
        TypeSerializer typeSerializer = this.f6204d;
        if (typeSerializer != null) {
            a = typeSerializer.mo703a(beanProperty);
        } else {
            a = typeSerializer;
        }
        JsonSerializer jsonSerializer = null;
        if (beanProperty != null) {
            AnnotatedMember b = beanProperty.b();
            if (b != null) {
                Object h = serializerProvider.e().h(b);
                if (h != null) {
                    jsonSerializer = serializerProvider.b(b, h);
                }
            }
        }
        if (jsonSerializer == null) {
            jsonSerializer = this.f6205e;
        }
        jsonSerializer = StdSerializer.a(serializerProvider, beanProperty, jsonSerializer);
        if (jsonSerializer == null) {
            if (this.f6203b != null && (this.f6202a || ContainerSerializer.a_(serializerProvider, beanProperty))) {
                jsonSerializer = serializerProvider.a(this.f6203b, beanProperty);
            }
        } else if (jsonSerializer instanceof ContextualSerializer) {
            jsonSerializer = ((ContextualSerializer) jsonSerializer).a(serializerProvider, beanProperty);
        }
        return m11681a(beanProperty, a, jsonSerializer);
    }

    private void m11682a(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        int length = objArr.length;
        TypeSerializer typeSerializer = this.f6204d;
        Object obj = null;
        int i = 0;
        while (i < length) {
            try {
                obj = objArr[i];
                if (obj == null) {
                    serializerProvider.a(jsonGenerator);
                } else if (typeSerializer == null) {
                    jsonSerializer.a(obj, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.a(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                Throwable e3 = e2;
                while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                    e3 = e3.getCause();
                }
                if (e3 instanceof Error) {
                    throw ((Error) e3);
                }
                throw JsonMappingException.a(e3, obj, i);
            }
        }
    }

    private void m11683b(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int length = objArr.length;
        TypeSerializer typeSerializer = this.f6204d;
        int i = 0;
        try {
            PropertySerializerMap propertySerializerMap = this.f6206f;
            while (i < length) {
                Object obj = objArr[i];
                if (obj == null) {
                    serializerProvider.a(jsonGenerator);
                } else {
                    Class cls = obj.getClass();
                    JsonSerializer a = propertySerializerMap.a(cls);
                    if (a == null) {
                        a = m11680a(propertySerializerMap, cls, serializerProvider);
                    }
                    a.a(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            Throwable e3 = e2;
            while ((e3 instanceof InvocationTargetException) && e3.getCause() != null) {
                e3 = e3.getCause();
            }
            if (e3 instanceof Error) {
                throw ((Error) e3);
            }
            throw JsonMappingException.a(e3, null, 0);
        }
    }

    private JsonSerializer<Object> m11680a(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        SerializerAndMapResult a = propertySerializerMap.a(cls, serializerProvider, this.f6178c);
        if (propertySerializerMap != a.b) {
            this.f6206f = a.b;
        }
        return a.a;
    }

    private JsonSerializer<Object> m11679a(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) {
        SerializerAndMapResult a = propertySerializerMap.a(javaType, serializerProvider, this.f6178c);
        if (propertySerializerMap != a.b) {
            this.f6206f = a.b;
        }
        return a.a;
    }
}
