package com.facebook.messaging.composer.triggers;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Inject;

/* compiled from: messenger_inbox_unit_items */
public class EmojiDictionaryLoader implements FbLoader<Void, ImmutableMultimap<String, String>, Throwable> {
    private final ObjectMapper f9864a;
    private final Resources f9865b;
    private Callback<Void, ImmutableMultimap<String, String>, Throwable> f9866c;

    private static EmojiDictionaryLoader m10427b(InjectorLike injectorLike) {
        return new EmojiDictionaryLoader((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final void m10430a(Object obj) {
        try {
            this.f9866c.a(null, m10428b());
        } catch (IOException e) {
            this.f9866c.c(null, e);
        }
    }

    @Inject
    public EmojiDictionaryLoader(ObjectMapper objectMapper, Resources resources) {
        this.f9864a = objectMapper;
        this.f9865b = resources;
    }

    public final void m10429a(Callback<Void, ImmutableMultimap<String, String>, Throwable> callback) {
        this.f9866c = callback;
    }

    @VisibleForTesting
    private ImmutableMultimap<String, String> m10428b() {
        char[] cArr = new char[8];
        Builder c = ImmutableMultimap.c();
        InputStream openRawResource = this.f9865b.openRawResource(2131165212);
        try {
            JsonParser a = this.f9864a.b().a(openRawResource);
            if (a.c() != JsonToken.START_OBJECT) {
                throw new IOException("Bad JSON");
            }
            while (a.c() != JsonToken.END_OBJECT) {
                JsonToken g = a.g();
                if (g != JsonToken.FIELD_NAME) {
                    throw new IOException("Unexpected token. Got " + g);
                }
                String i = a.i();
                g = a.c();
                if (g != JsonToken.VALUE_STRING) {
                    throw new IOException("Unexpected token. Got " + g);
                }
                String I = a.I();
                if (I != null) {
                    int length = I.length();
                    int i2 = 0;
                    while (i2 < length) {
                        int i3;
                        int i4 = 0;
                        while (i2 < length) {
                            i3 = i2 + 1;
                            char charAt = I.charAt(i2);
                            if (charAt == ' ') {
                                break;
                            }
                            i2 = i4 + 1;
                            cArr[i4] = charAt;
                            i4 = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        if (i4 != 0) {
                            c.b(i, new String(cArr, 0, i4));
                        }
                        i2 = i3;
                    }
                }
            }
            return c.b();
        } finally {
            openRawResource.close();
        }
    }
}
