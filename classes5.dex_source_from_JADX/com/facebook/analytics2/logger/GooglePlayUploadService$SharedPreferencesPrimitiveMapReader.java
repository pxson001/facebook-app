package com.facebook.analytics2.logger;

import android.content.SharedPreferences;
import com.facebook.analytics2.logger.UploadJobConfig.PrimitiveMapReader;

/* compiled from: themeListImage */
class GooglePlayUploadService$SharedPreferencesPrimitiveMapReader implements PrimitiveMapReader {
    private final SharedPreferences f2009a;

    public GooglePlayUploadService$SharedPreferencesPrimitiveMapReader(SharedPreferences sharedPreferences) {
        this.f2009a = sharedPreferences;
    }

    public final String m2708a(String str, String str2) {
        return this.f2009a.getString(str, str2);
    }

    public final int m2707a(String str, int i) {
        return this.f2009a.getInt(str, i);
    }
}
