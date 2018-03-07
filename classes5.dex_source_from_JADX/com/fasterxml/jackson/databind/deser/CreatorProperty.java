package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;

/* compiled from: click */
public class CreatorProperty extends SettableBeanProperty {
    private static final long serialVersionUID = 1;
    protected final AnnotatedParameter _annotated;
    protected final int _creatorIndex;
    protected final Object _injectableValueId;

    public final /* synthetic */ SettableBeanProperty mo650b(JsonDeserializer jsonDeserializer) {
        return m10946a(jsonDeserializer);
    }

    public CreatorProperty(String str, JavaType javaType, PropertyName propertyName, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedParameter annotatedParameter, int i, Object obj, boolean z) {
        super(str, javaType, propertyName, typeDeserializer, annotations, z);
        this._annotated = annotatedParameter;
        this._creatorIndex = i;
        this._injectableValueId = obj;
    }

    private CreatorProperty(CreatorProperty creatorProperty, String str) {
        super((SettableBeanProperty) creatorProperty, str);
        this._annotated = creatorProperty._annotated;
        this._creatorIndex = creatorProperty._creatorIndex;
        this._injectableValueId = creatorProperty._injectableValueId;
    }

    private CreatorProperty(CreatorProperty creatorProperty, JsonDeserializer<?> jsonDeserializer) {
        super((SettableBeanProperty) creatorProperty, (JsonDeserializer) jsonDeserializer);
        this._annotated = creatorProperty._annotated;
        this._creatorIndex = creatorProperty._creatorIndex;
        this._injectableValueId = creatorProperty._injectableValueId;
    }

    public final SettableBeanProperty mo647a(String str) {
        return new CreatorProperty(this, str);
    }

    public final CreatorProperty m10946a(JsonDeserializer<?> jsonDeserializer) {
        return new CreatorProperty(this, (JsonDeserializer) jsonDeserializer);
    }

    public final AnnotatedMember mo651b() {
        return this._annotated;
    }

    public final int mo654c() {
        return this._creatorIndex;
    }

    public final void mo648a(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        mo649a(obj, m10922a(jsonParser, deserializationContext));
    }

    public final Object mo652b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return mo653b(obj, m10922a(jsonParser, deserializationContext));
    }

    public final void mo649a(Object obj, Object obj2) {
        throw new IllegalStateException("Method should never be called on a " + getClass().getName());
    }

    public final Object mo653b(Object obj, Object obj2) {
        return obj;
    }

    public final Object mo655d() {
        return this._injectableValueId;
    }

    public String toString() {
        return "[creator property, name '" + this._propName + "'; inject id '" + this._injectableValueId + "']";
    }
}
