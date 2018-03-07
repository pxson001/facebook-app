package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.util.Collection;

@JacksonStdImpl
/* compiled from: chunked */
public class CollectionDeserializer extends ContainerDeserializerBase<Collection<Object>> implements ContextualDeserializer {
    private static final long serialVersionUID = -2003828398549708958L;
    protected final JavaType _collectionType;
    protected final JsonDeserializer<Object> _delegateDeserializer;
    protected final JsonDeserializer<Object> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final TypeDeserializer _valueTypeDeserializer;

    public /* synthetic */ Object mo664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return mo668b(jsonParser, deserializationContext);
    }

    public CollectionDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator) {
        this(javaType, jsonDeserializer, typeDeserializer, valueInstantiator, null);
    }

    protected CollectionDeserializer mo663a(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, TypeDeserializer typeDeserializer) {
        if (jsonDeserializer == this._delegateDeserializer && jsonDeserializer2 == this._valueDeserializer && typeDeserializer == this._valueTypeDeserializer) {
            return this;
        }
        return new CollectionDeserializer(this._collectionType, jsonDeserializer2, typeDeserializer, this._valueInstantiator, jsonDeserializer);
    }

    public final JsonDeserializer m11126a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer jsonDeserializer;
        if (this._valueInstantiator == null || !this._valueInstantiator.mo686i()) {
            jsonDeserializer = null;
        } else {
            JavaType k = this._valueInstantiator.mo687k();
            if (k == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this._collectionType + ": value instantiator (" + this._valueInstantiator.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            jsonDeserializer = StdDeserializer.a(deserializationContext, k, beanProperty);
        }
        JsonDeserializer a = StdDeserializer.a(deserializationContext, beanProperty, this._valueDeserializer);
        if (a == null) {
            a = deserializationContext.a(this._collectionType.r(), beanProperty);
        } else if (a instanceof ContextualDeserializer) {
            a = ((ContextualDeserializer) a).a(deserializationContext, beanProperty);
        }
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.mo698a(beanProperty);
        }
        return mo663a(jsonDeserializer, a, typeDeserializer);
    }

    public final JsonDeserializer<Object> mo662e() {
        return this._valueDeserializer;
    }

    public Collection<Object> mo668b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null) {
            return (Collection) this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        if (jsonParser.g() == JsonToken.VALUE_STRING) {
            String o = jsonParser.o();
            if (o.length() == 0) {
                return (Collection) this._valueInstantiator.mo678a(deserializationContext, o);
            }
        }
        return mo667a(jsonParser, deserializationContext, (Collection) this._valueInstantiator.mo688l());
    }

    public Collection<Object> mo667a(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) {
        if (!jsonParser.m()) {
            return m11133b(jsonParser, deserializationContext, collection);
        }
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                return collection;
            }
            Object obj;
            if (c == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            collection.add(obj);
        }
    }

    protected CollectionDeserializer(JavaType javaType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer, ValueInstantiator valueInstantiator, JsonDeserializer<Object> jsonDeserializer2) {
        super(javaType._class);
        this._collectionType = javaType;
        this._valueDeserializer = jsonDeserializer;
        this._valueTypeDeserializer = typeDeserializer;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = jsonDeserializer2;
    }

    public Object mo665a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }

    protected final Collection<Object> m11133b(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) {
        if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            Object obj;
            JsonDeserializer jsonDeserializer = this._valueDeserializer;
            TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = jsonDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = jsonDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            collection.add(obj);
            return collection;
        }
        throw deserializationContext.b(this._collectionType._class);
    }
}
