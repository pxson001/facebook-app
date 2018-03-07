package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.CollectionType;

/* compiled from: can_viewer_comment */
public abstract class GuavaCollectionDeserializer<T> extends StdDeserializer<T> implements ContextualDeserializer {
    protected final CollectionType _containerType;
    protected final TypeDeserializer _typeDeserializerForValue;
    protected final JsonDeserializer<?> _valueDeserializer;

    public abstract GuavaCollectionDeserializer<T> mo731a(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer);

    protected abstract T mo730b(JsonParser jsonParser, DeserializationContext deserializationContext);

    protected GuavaCollectionDeserializer(CollectionType collectionType, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        super(collectionType);
        this._containerType = collectionType;
        this._typeDeserializerForValue = typeDeserializer;
        this._valueDeserializer = jsonDeserializer;
    }

    public final JsonDeserializer<?> m12005a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer jsonDeserializer = this._valueDeserializer;
        TypeDeserializer typeDeserializer = this._typeDeserializerForValue;
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.a(this._containerType.r(), beanProperty);
        }
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.mo698a(beanProperty);
        }
        return (jsonDeserializer == this._valueDeserializer && typeDeserializer == this._typeDeserializerForValue) ? this : mo731a(typeDeserializer, jsonDeserializer);
    }

    public final Object m12008a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }

    public T m12007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.START_ARRAY) {
            return mo730b(jsonParser, deserializationContext);
        }
        throw deserializationContext.b(this._containerType._class);
    }
}
