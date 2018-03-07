package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: can_viewer_change_name */
public final class GuavaOptionalDeserializer extends StdDeserializer<Optional<?>> {
    private final JavaType _referenceType;

    public final /* synthetic */ Object m12015a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m12016b(jsonParser, deserializationContext);
    }

    public GuavaOptionalDeserializer(JavaType javaType) {
        super(javaType);
        this._referenceType = javaType.a(0);
    }

    public final Optional<?> m12016b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return Optional.of(deserializationContext.a(this._referenceType).a(jsonParser, deserializationContext));
    }

    public final Object m12014a() {
        return Absent.INSTANCE;
    }
}
