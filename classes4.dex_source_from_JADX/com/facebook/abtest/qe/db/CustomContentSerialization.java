package com.facebook.abtest.qe.db;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: throwable_class */
public class CustomContentSerialization {
    private static Class<CustomContentSerialization> f1099a = CustomContentSerialization.class;
    private final ObjectMapper f1100b;

    public static CustomContentSerialization m1380b(InjectorLike injectorLike) {
        return new CustomContentSerialization((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CustomContentSerialization(ObjectMapper objectMapper) {
        this.f1100b = objectMapper;
    }

    final ImmutableMap<String, String> m1381a(@Nullable String str) {
        if (str == null) {
            return ImmutableBiMap.a();
        }
        Builder builder = new Builder();
        try {
            JsonParser b = this.f1100b.a().b(str);
            b.c();
            while (b.c() != JsonToken.END_OBJECT) {
                String i = b.i();
                b.c();
                builder.b(i, b.o());
            }
        } catch (Throwable e) {
            BLog.a(f1099a, e, "Error parsing %s", new Object[]{str});
        } catch (Throwable e2) {
            BLog.a(f1099a, e2, "Error parsing %s: %s", new Object[]{str});
        }
        return builder.b();
    }
}
