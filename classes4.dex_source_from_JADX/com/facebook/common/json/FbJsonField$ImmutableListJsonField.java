package com.facebook.common.json;

import com.facebook.proguard.annotations.DoNotStrip;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: getTopOnMessenger */
public final class FbJsonField$ImmutableListJsonField extends FbJsonField {
    private JsonDeserializer<ImmutableList<?>> f11109c;
    private Class<?> f11110d;
    private TypeReference<?> f11111e;

    public FbJsonField$ImmutableListJsonField(Field field, @Nullable Method method, Class<?> cls, @Nullable TypeReference<?> typeReference) {
        super(field, method);
        this.f11110d = cls;
        this.f11111e = typeReference;
    }

    @DoNotStrip
    public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            Object of;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                of = ImmutableList.of();
            } else {
                if (this.f11109c == null) {
                    if (this.f11110d != null) {
                        this.f11109c = new ImmutableListDeserializer(this.f11110d);
                    } else if (this.f11111e != null) {
                        this.f11109c = new ImmutableListDeserializer(((FbObjectMapper) jsonParser.a()).a(deserializationContext, this.f11111e.m1240a()));
                    } else {
                        throw new IllegalArgumentException("Need to set simple or generic inner list type!");
                    }
                }
                ImmutableList immutableList = (ImmutableList) this.f11109c.a(jsonParser, deserializationContext);
            }
            if (this.b != null) {
                this.b.setAccessible(true);
                this.b.invoke(obj, new Object[]{of});
                return;
            }
            this.a.setAccessible(true);
            this.a.set(obj, of);
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, IOException.class);
            throw Throwables.propagate(e);
        }
    }
}
