package com.facebook.crudolib.json;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import javax.annotation.Nullable;

@TargetApi(11)
@Deprecated
/* compiled from: Transaction-ID is null. */
public final class TranslatorHelper {
    private TranslatorHelper() {
    }

    @Nullable
    public static String m25953a(JsonReader jsonReader) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return jsonReader.nextString();
        }
        jsonReader.nextNull();
        return null;
    }

    public static int m25952a(JsonReader jsonReader, int i) {
        if (jsonReader.peek() != JsonToken.NULL) {
            return jsonReader.nextInt();
        }
        jsonReader.nextNull();
        return i;
    }
}
