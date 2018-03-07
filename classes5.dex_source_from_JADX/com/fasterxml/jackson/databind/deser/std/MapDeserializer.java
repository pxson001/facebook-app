package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@JacksonStdImpl
/* compiled from: checkin_cta_label */
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements ContextualDeserializer, ResolvableDeserializer {
    private static final long serialVersionUID = -3378654289961736240L;
    protected JsonDeserializer<Object> _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected HashSet<String> _ignorableProperties;
    protected final KeyDeserializer _keyDeserializer;
    protected final JavaType _mapType;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public /* synthetic */ Object m11223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11228b(jsonParser, deserializationContext);
    }

    public final Object m11225a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Map map = (Map) obj;
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT || g == JsonToken.FIELD_NAME) {
            if (this._standardStringKey) {
                m11219c(jsonParser, deserializationContext, map);
            } else {
                m11218b(jsonParser, deserializationContext, map);
            }
            return map;
        }
        throw deserializationContext.b(m11221f());
    }

    public MapDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(Map.class);
        this._mapType = javaType;
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = valueInstantiator;
        this._hasDefaultCreator = valueInstantiator.mo685h();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = m11217a(javaType, keyDeserializer);
    }

    private MapDeserializer(MapDeserializer mapDeserializer, KeyDeserializer keyDeserializer, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, HashSet<String> hashSet) {
        super(mapDeserializer._valueClass);
        this._mapType = mapDeserializer._mapType;
        this._keyDeserializer = keyDeserializer;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = hashSet;
        this._standardStringKey = m11217a(this._mapType, keyDeserializer);
    }

    private MapDeserializer m11215a(KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer, HashSet<String> hashSet) {
        return (this._keyDeserializer == keyDeserializer && this._valueDeserializer == jsonDeserializer && this._valueTypeDeserializer == typeDeserializer && this._ignorableProperties == hashSet) ? this : new MapDeserializer(this, keyDeserializer, (JsonDeserializer) jsonDeserializer, typeDeserializer, (HashSet) hashSet);
    }

    private boolean m11217a(JavaType javaType, KeyDeserializer keyDeserializer) {
        if (keyDeserializer == null) {
            return true;
        }
        JavaType q = javaType.q();
        if (q == null) {
            return true;
        }
        Class cls = q._class;
        if ((cls == String.class || cls == Object.class) && StdDeserializer.a(keyDeserializer)) {
            return true;
        }
        return false;
    }

    public final void m11227a(String[] strArr) {
        HashSet hashSet;
        if (strArr == null || strArr.length == 0) {
            hashSet = null;
        } else {
            hashSet = ArrayBuilders.a(strArr);
        }
        this._ignorableProperties = hashSet;
    }

    public final void m11226a(DeserializationContext deserializationContext) {
        if (this._valueInstantiator.mo686i()) {
            JavaType k = this._valueInstantiator.mo687k();
            if (k == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._mapType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this._delegateDeserializer = StdDeserializer.a(deserializationContext, k, null);
        }
        if (this._valueInstantiator.mo673j()) {
            this._propertyBasedCreator = PropertyBasedCreator.m11087a(deserializationContext, this._valueInstantiator, this._valueInstantiator.mo672a(deserializationContext._config));
        }
        this._standardStringKey = m11217a(this._mapType, this._keyDeserializer);
    }

    public final JsonDeserializer<?> m11222a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        KeyDeserializer b;
        HashSet hashSet;
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        if (keyDeserializer == null) {
            b = deserializationContext.b(this._mapType.q(), beanProperty);
        } else if (keyDeserializer instanceof ContextualKeyDeserializer) {
            b = ((ContextualKeyDeserializer) keyDeserializer).a();
        } else {
            b = keyDeserializer;
        }
        JsonDeserializer a = StdDeserializer.a(deserializationContext, beanProperty, this._valueDeserializer);
        if (a == null) {
            a = deserializationContext.a(this._mapType.r(), beanProperty);
        } else if (a instanceof ContextualDeserializer) {
            a = ((ContextualDeserializer) a).a(deserializationContext, beanProperty);
        }
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.mo698a(beanProperty);
        }
        Collection collection = this._ignorableProperties;
        AnnotationIntrospector f = deserializationContext.f();
        if (!(f == null || beanProperty == null)) {
            String[] b2 = f.b(beanProperty.b());
            if (b2 != null) {
                hashSet = collection == null ? new HashSet() : new HashSet(collection);
                for (Object add : b2) {
                    hashSet.add(add);
                }
                return m11215a(b, typeDeserializer, a, hashSet);
            }
        }
        hashSet = collection;
        return m11215a(b, typeDeserializer, a, hashSet);
    }

    public final JsonDeserializer<Object> mo662e() {
        return this._valueDeserializer;
    }

    public Map<Object, Object> m11228b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._propertyBasedCreator != null) {
            return m11220d(jsonParser, deserializationContext);
        }
        if (this._delegateDeserializer != null) {
            return (Map) this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        if (this._hasDefaultCreator) {
            JsonToken g = jsonParser.g();
            if (g == JsonToken.START_OBJECT || g == JsonToken.FIELD_NAME || g == JsonToken.END_OBJECT) {
                Map<Object, Object> map = (Map) this._valueInstantiator.mo688l();
                if (this._standardStringKey) {
                    m11219c(jsonParser, deserializationContext, map);
                    return map;
                }
                m11218b(jsonParser, deserializationContext, map);
                return map;
            } else if (g == JsonToken.VALUE_STRING) {
                return (Map) this._valueInstantiator.mo678a(deserializationContext, jsonParser.o());
            } else {
                throw deserializationContext.b(m11221f());
            }
        }
        throw deserializationContext.a(m11221f(), "No default constructor found");
    }

    public final Object m11224a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo699a(jsonParser, deserializationContext);
    }

    private Class<?> m11221f() {
        return this._mapType._class;
    }

    private void m11218b(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
        }
        KeyDeserializer keyDeserializer = this._keyDeserializer;
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            Object a = keyDeserializer.a(i, deserializationContext);
            JsonToken c = jsonParser.c();
            if (this._ignorableProperties == null || !this._ignorableProperties.contains(i)) {
                Object obj;
                if (c == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (typeDeserializer == null) {
                    obj = jsonDeserializer.a(jsonParser, deserializationContext);
                } else {
                    obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
                }
                map.put(a, obj);
            } else {
                jsonParser.f();
            }
            g = jsonParser.c();
        }
    }

    private void m11219c(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
        }
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            g = jsonParser.c();
            if (this._ignorableProperties == null || !this._ignorableProperties.contains(i)) {
                Object obj;
                if (g == JsonToken.VALUE_NULL) {
                    obj = null;
                } else if (typeDeserializer == null) {
                    obj = jsonDeserializer.a(jsonParser, deserializationContext);
                } else {
                    obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
                }
                map.put(i, obj);
            } else {
                jsonParser.f();
            }
            g = jsonParser.c();
        }
    }

    private Map<Object, Object> m11220d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        PropertyValueBuffer a = propertyBasedCreator.m11089a(jsonParser, deserializationContext, null);
        JsonToken g = jsonParser.g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.c();
        }
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (g == JsonToken.FIELD_NAME) {
            String i = jsonParser.i();
            JsonToken c = jsonParser.c();
            if (this._ignorableProperties == null || !this._ignorableProperties.contains(i)) {
                SettableBeanProperty a2 = propertyBasedCreator.m11088a(i);
                if (a2 != null) {
                    if (a.m11106a(a2.mo654c(), a2.m10922a(jsonParser, deserializationContext))) {
                        jsonParser.c();
                        try {
                            Map<Object, Object> map = (Map) propertyBasedCreator.m11090a(deserializationContext, a);
                            m11218b(jsonParser, deserializationContext, map);
                            return map;
                        } catch (Throwable e) {
                            m11216a(e, this._mapType.c());
                            return null;
                        }
                    }
                } else {
                    Object obj;
                    Object a3 = this._keyDeserializer.a(jsonParser.i(), deserializationContext);
                    if (c == JsonToken.VALUE_NULL) {
                        obj = null;
                    } else if (typeDeserializer == null) {
                        obj = jsonDeserializer.a(jsonParser, deserializationContext);
                    } else {
                        obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
                    }
                    a.m11104a(a3, obj);
                }
            } else {
                jsonParser.f();
            }
            g = jsonParser.c();
        }
        try {
            return (Map) propertyBasedCreator.m11090a(deserializationContext, a);
        } catch (Throwable e2) {
            m11216a(e2, this._mapType.c());
            return null;
        }
    }

    private static void m11216a(Throwable th, Object obj) {
        Throwable th2 = th;
        while ((th2 instanceof InvocationTargetException) && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (!(th2 instanceof IOException) || (th2 instanceof JsonMappingException)) {
            throw JsonMappingException.a(th2, obj, null);
        } else {
            throw ((IOException) th2);
        }
    }
}
