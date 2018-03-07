package com.facebook.common.json;

import com.facebook.proguard.annotations.DoNotStrip;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: getTopOnMessenger */
final class FbJsonField$BoolJsonField extends FbJsonField {
    public FbJsonField$BoolJsonField(Field field, @Nullable Method method) {
        super(field, method);
    }

    @DoNotStrip
    public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            boolean H = jsonParser.H();
            if (this.b != null) {
                this.b.setAccessible(true);
                this.b.invoke(obj, new Object[]{Boolean.valueOf(H)});
                return;
            }
            this.a.setAccessible(true);
            this.a.setBoolean(obj, H);
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, IOException.class);
            throw Throwables.propagate(e);
        }
    }
}
