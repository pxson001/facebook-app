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
/* compiled from: check_approved_machine */
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final JavaType _collectionType;
    protected final JsonDeserializer<Object> _delegateDeserializer;
    protected final JsonDeserializer<String> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;

    public final /* synthetic */ Object m11349a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11352b(jsonParser, deserializationContext);
    }

    public StringCollectionDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer, ValueInstantiator valueInstantiator) {
        this(javaType, valueInstantiator, null, jsonDeserializer);
    }

    private StringCollectionDeserializer m11344a(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2) {
        return (this._valueDeserializer == jsonDeserializer2 && this._delegateDeserializer == jsonDeserializer) ? this : new StringCollectionDeserializer(this._collectionType, this._valueInstantiator, jsonDeserializer, jsonDeserializer2);
    }

    public final JsonDeserializer<?> m11348a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer jsonDeserializer;
        JsonDeserializer jsonDeserializer2 = null;
        if (this._valueInstantiator == null || this._valueInstantiator.mo690n() == null) {
            jsonDeserializer = null;
        } else {
            jsonDeserializer = StdDeserializer.a(deserializationContext, this._valueInstantiator.mo687k(), beanProperty);
        }
        JsonDeserializer jsonDeserializer3 = this._valueDeserializer;
        if (jsonDeserializer3 == null) {
            jsonDeserializer3 = StdDeserializer.a(deserializationContext, beanProperty, jsonDeserializer3);
            if (jsonDeserializer3 == null) {
                jsonDeserializer3 = deserializationContext.a(this._collectionType.r(), beanProperty);
            }
        } else if (jsonDeserializer3 instanceof ContextualDeserializer) {
            jsonDeserializer3 = ((ContextualDeserializer) jsonDeserializer3).a(deserializationContext, beanProperty);
        }
        if (!StdDeserializer.a(jsonDeserializer3)) {
            jsonDeserializer2 = jsonDeserializer3;
        }
        return m11344a(jsonDeserializer, jsonDeserializer2);
    }

    public final JsonDeserializer<Object> mo662e() {
        return this._valueDeserializer;
    }

    public final Collection<String> m11352b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (this._delegateDeserializer != null) {
            return (Collection) this._valueInstantiator.mo677a(deserializationContext, this._delegateDeserializer.a(jsonParser, deserializationContext));
        }
        return m11345a(jsonParser, deserializationContext, (Collection) this._valueInstantiator.mo688l());
    }

    private Collection<String> m11345a(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) {
        if (!jsonParser.m()) {
            return m11347b(jsonParser, deserializationContext, collection);
        }
        if (this._valueDeserializer != null) {
            return m11346a(jsonParser, deserializationContext, collection, this._valueDeserializer);
        }
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                return collection;
            }
            collection.add(c == JsonToken.VALUE_NULL ? null : StdDeserializer.x(jsonParser, deserializationContext));
        }
    }

    private static Collection<String> m11346a(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection, JsonDeserializer<String> jsonDeserializer) {
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                return collection;
            }
            Object obj;
            if (c == JsonToken.VALUE_NULL) {
                obj = null;
            } else {
                String str = (String) jsonDeserializer.a(jsonParser, deserializationContext);
            }
            collection.add(obj);
        }
    }

    public final Object m11350a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }

    private final Collection<String> m11347b(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) {
        if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            Object obj;
            JsonDeserializer jsonDeserializer = this._valueDeserializer;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (jsonDeserializer == null) {
                obj = StdDeserializer.x(jsonParser, deserializationContext);
            } else {
                String str = (String) jsonDeserializer.a(jsonParser, deserializationContext);
            }
            collection.add(obj);
            return collection;
        }
        throw deserializationContext.b(this._collectionType._class);
    }

    private StringCollectionDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2) {
        super(javaType._class);
        this._collectionType = javaType;
        this._valueDeserializer = jsonDeserializer2;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = jsonDeserializer;
    }
}
