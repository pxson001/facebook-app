package com.facebook.common.json;

import com.facebook.proguard.annotations.DoNotStrip;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: snapshot_analytics */
final class FbJsonField$DoubleJsonField extends FbJsonField {
    public FbJsonField$DoubleJsonField(Field field, @Nullable Method method) {
        super(field, method);
    }

    @DoNotStrip
    public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
        double d = 0.0d;
        try {
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                jsonParser.f();
            } else {
                d = jsonParser.G();
            }
            if (this.b != null) {
                this.b.setAccessible(true);
                this.b.invoke(obj, new Object[]{Double.valueOf(d)});
                return;
            }
            this.a.setAccessible(true);
            this.a.setDouble(obj, d);
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, IOException.class);
            throw Throwables.propagate(e);
        }
    }
}
