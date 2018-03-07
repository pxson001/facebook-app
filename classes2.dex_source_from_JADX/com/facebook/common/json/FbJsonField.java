package com.facebook.common.json;

import com.facebook.proguard.annotations.DoNotStrip;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: profile/%s/activitylog */
public abstract class FbJsonField {
    public static final TypeFactory f8946c = TypeFactory.f4051a;
    protected final Field f8947a;
    protected final Method f8948b;
    private volatile boolean f8949d = false;
    private volatile boolean f8950e = false;

    @DoNotStrip
    /* compiled from: profile/%s/activitylog */
    final class StringJsonField extends FbJsonField {
        public StringJsonField(Field field, @Nullable Method method) {
            super(field, method);
        }

        @DoNotStrip
        public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
            Object obj2 = null;
            try {
                if (jsonParser.mo1794g() == JsonToken.VALUE_NULL) {
                    jsonParser.mo1793f();
                } else {
                    obj2 = jsonParser.mo1769o();
                    if (obj2 == null) {
                        throw new JsonParseException("Failed to read text from Json stream", jsonParser.mo1781l());
                    }
                }
                if (this.f8948b != null) {
                    this.f8948b.setAccessible(true);
                    this.f8948b.invoke(obj, new Object[]{obj2});
                    return;
                }
                this.f8947a.setAccessible(true);
                this.f8947a.set(obj, obj2);
            } catch (Throwable e) {
                Throwables.propagateIfPossible(e, IOException.class);
                throw Throwables.propagate(e);
            }
        }
    }

    @DoNotStrip
    /* compiled from: profile/%s/activitylog */
    final class IntJsonField extends FbJsonField {
        public IntJsonField(Field field, @Nullable Method method) {
            super(field, method);
        }

        @DoNotStrip
        public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
            try {
                int E = jsonParser.m13246E();
                if (this.f8948b != null) {
                    this.f8948b.setAccessible(true);
                    this.f8948b.invoke(obj, new Object[]{Integer.valueOf(E)});
                    return;
                }
                this.f8947a.setAccessible(true);
                this.f8947a.setInt(obj, E);
            } catch (Throwable e) {
                Throwables.propagateIfPossible(e, IOException.class);
                throw Throwables.propagate(e);
            }
        }
    }

    @DoNotStrip
    @VisibleForTesting
    /* compiled from: profile/%s/activitylog */
    public class BeanJsonField extends FbJsonField {
        private JsonDeserializer<?> f21419c;

        public BeanJsonField(Field field, @Nullable Method method) {
            super(field, method);
        }

        @DoNotStrip
        public void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
            try {
                Object a = m29141a(jsonParser, deserializationContext);
                if (a != null) {
                    if (this.f8948b != null) {
                        this.f8948b.setAccessible(true);
                        this.f8948b.invoke(obj, new Object[]{a});
                        return;
                    }
                    this.f8947a.setAccessible(true);
                    this.f8947a.set(obj, a);
                }
            } catch (Throwable e) {
                Throwables.propagateIfPossible(e, IOException.class);
                throw Throwables.propagate(e);
            }
        }

        @VisibleForTesting
        private Object m29141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.mo1794g() == JsonToken.VALUE_NULL) {
                jsonParser.mo1793f();
                return null;
            }
            if (this.f21419c == null) {
                FbObjectMapper fbObjectMapper = (FbObjectMapper) jsonParser.mo1761a();
                if (this.f8948b == null) {
                    CollectionType a;
                    Type genericType = this.f8947a.getGenericType();
                    if (genericType instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) genericType;
                        Class cls = (Class) parameterizedType.getRawType();
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        if (ImmutableList.class.isAssignableFrom(cls)) {
                            Preconditions.checkState(actualTypeArguments.length == 1);
                            a = CollectionType.a(cls, FbJsonField.f8946c.m7109a(actualTypeArguments[0]));
                            this.f21419c = fbObjectMapper.m6618b(deserializationContext, (JavaType) a);
                        }
                    }
                    a = FbJsonField.f8946c.m7109a(genericType);
                    this.f21419c = fbObjectMapper.m6618b(deserializationContext, (JavaType) a);
                } else {
                    this.f21419c = fbObjectMapper.m6615a(deserializationContext, this.f8948b.getGenericParameterTypes()[0]);
                }
            }
            return this.f21419c.mo1797a(jsonParser, deserializationContext);
        }
    }

    @DoNotStrip
    /* compiled from: profile/%s/activitylog */
    public final class ListJsonField extends FbJsonField {
        private JsonDeserializer<List<?>> f21420c;
        private Class<?> f21421d;
        private TypeReference<?> f21422e;

        public ListJsonField(@Nullable Field field, @Nullable Method method, Class<?> cls, @Nullable TypeReference<?> typeReference) {
            super(field, method);
            this.f21421d = cls;
            this.f21422e = typeReference;
        }

        @DoNotStrip
        public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
            try {
                Object a;
                if (jsonParser.mo1794g() == JsonToken.VALUE_NULL) {
                    a = Lists.m1296a();
                } else {
                    if (this.f21420c == null) {
                        if (this.f21421d != null) {
                            this.f21420c = new ArrayListDeserializer(this.f21421d);
                        } else if (this.f21422e != null) {
                            this.f21420c = new ArrayListDeserializer(((FbObjectMapper) jsonParser.mo1761a()).m6615a(deserializationContext, this.f21422e.a()));
                        } else {
                            throw new IllegalArgumentException("Need to set simple or generic inner list type!");
                        }
                    }
                    List list = (List) this.f21420c.mo1797a(jsonParser, deserializationContext);
                }
                if (this.f8948b != null) {
                    this.f8948b.setAccessible(true);
                    this.f8948b.invoke(obj, new Object[]{a});
                    return;
                }
                this.f8947a.setAccessible(true);
                this.f8947a.set(obj, a);
            } catch (Throwable e) {
                Throwables.propagateIfPossible(e, IOException.class);
                throw Throwables.propagate(e);
            }
        }
    }

    @DoNotStrip
    /* compiled from: profile/%s/activitylog */
    final class FloatJsonField extends FbJsonField {
        public FloatJsonField(Field field, @Nullable Method method) {
            super(field, method);
        }

        @DoNotStrip
        public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
            float f = 0.0f;
            try {
                if (jsonParser.mo1794g() == JsonToken.VALUE_NULL) {
                    jsonParser.mo1793f();
                } else {
                    f = jsonParser.mo1773A();
                }
                if (this.f8948b != null) {
                    this.f8948b.setAccessible(true);
                    this.f8948b.invoke(obj, new Object[]{Float.valueOf(f)});
                    return;
                }
                this.f8947a.setAccessible(true);
                this.f8947a.setFloat(obj, f);
            } catch (Throwable e) {
                Throwables.propagateIfPossible(e, IOException.class);
                throw Throwables.propagate(e);
            }
        }
    }

    @DoNotStrip
    public abstract void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext);

    @DoNotStrip
    public static FbJsonField jsonField(Field field) {
        return jsonField(field, null, null);
    }

    @DoNotStrip
    public static FbJsonField jsonField(Field field, Class<?> cls) {
        return jsonField(field, (Class) cls, null);
    }

    @DoNotStrip
    public static FbJsonField jsonField(Field field, TypeReference<?> typeReference) {
        return jsonField(field, null, (TypeReference) typeReference);
    }

    @DoNotStrip
    private static FbJsonField jsonField(Field field, @Nullable Class<?> cls, @Nullable TypeReference<?> typeReference) {
        Class type = field.getType();
        if (type == String.class) {
            return new StringJsonField(field, null);
        }
        if (type == Integer.TYPE) {
            return new IntJsonField(field, null);
        }
        if (type == Long.TYPE) {
            return new LongJsonField(field, null);
        }
        if (type == Boolean.TYPE) {
            return new BoolJsonField(field, null);
        }
        if (type == Float.TYPE) {
            return new FloatJsonField(field, null);
        }
        if (type == Double.TYPE) {
            return new DoubleJsonField(field, null);
        }
        if (type == ImmutableList.class) {
            return new ImmutableListJsonField(field, null, cls, typeReference);
        }
        if (type == List.class || type == ArrayList.class) {
            return new ListJsonField(field, null, cls, typeReference);
        }
        return new BeanJsonField(field, null);
    }

    @DoNotStrip
    public static FbJsonField jsonField(Method method) {
        return jsonField(method, null, null);
    }

    @DoNotStrip
    public static FbJsonField jsonField(Method method, Class<?> cls) {
        return jsonField(method, (Class) cls, null);
    }

    @DoNotStrip
    public static FbJsonField jsonField(Method method, TypeReference<?> typeReference) {
        return jsonField(method, null, (TypeReference) typeReference);
    }

    @DoNotStrip
    private static FbJsonField jsonField(Method method, @Nullable Class<?> cls, @Nullable TypeReference<?> typeReference) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            throw new RuntimeException("Invalid setter type " + method.getName() + " Only setter with on input parameter is supported.");
        } else if (parameterTypes[0] == String.class) {
            return new StringJsonField(null, method);
        } else {
            if (parameterTypes[0] == Integer.TYPE) {
                return new IntJsonField(null, method);
            }
            if (parameterTypes[0] == Long.TYPE) {
                return new LongJsonField(null, method);
            }
            if (parameterTypes[0] == Boolean.TYPE) {
                return new BoolJsonField(null, method);
            }
            if (parameterTypes[0] == Float.TYPE) {
                return new FloatJsonField(null, method);
            }
            if (parameterTypes[0] == Double.TYPE) {
                return new DoubleJsonField(null, method);
            }
            if (parameterTypes[0] == ImmutableList.class) {
                return new ImmutableListJsonField(null, method, cls, typeReference);
            }
            if (parameterTypes[0] == List.class || parameterTypes[0] == ArrayList.class) {
                return new ListJsonField(null, method, cls, typeReference);
            }
            return new BeanJsonField(null, method);
        }
    }

    @DoNotStrip
    public static FbJsonField jsonFieldWithCreator(Field field) {
        return new BeanJsonField(field, null);
    }

    protected FbJsonField(@Nullable Field field, @Nullable Method method) {
        this.f8947a = field;
        this.f8948b = method;
    }
}
