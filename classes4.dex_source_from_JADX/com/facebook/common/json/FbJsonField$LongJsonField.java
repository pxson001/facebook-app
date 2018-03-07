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
final class FbJsonField$LongJsonField extends FbJsonField {
    public FbJsonField$LongJsonField(@Nullable Field field, @Nullable Method method) {
        super(field, method);
    }

    @DoNotStrip
    public final void deserialize(Object obj, JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            long F = jsonParser.F();
            if (this.b != null) {
                this.b.setAccessible(true);
                this.b.invoke(obj, new Object[]{Long.valueOf(F)});
                return;
            }
            this.a.setAccessible(true);
            this.a.setLong(obj, F);
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, IOException.class);
            throw Throwables.propagate(e);
        }
    }
}
