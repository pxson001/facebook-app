package com.facebook.messaging.database.serialization;

import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;

/* compiled from: login_longitude */
public class DbMessageCustomizationSerialization {
    public static DbMessageCustomizationSerialization m9192a(InjectorLike injectorLike) {
        return new DbMessageCustomizationSerialization();
    }

    @Nullable
    public static String m9193a(boolean z) {
        return z ? "{\"border\":\"flowers\"}" : null;
    }

    public static boolean m9194a(@Nullable String str) {
        return str != null && str.equals("{\"border\":\"flowers\"}");
    }
}
