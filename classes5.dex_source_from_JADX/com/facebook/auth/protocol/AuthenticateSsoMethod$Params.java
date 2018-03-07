package com.facebook.auth.protocol;

import javax.annotation.Nullable;

/* compiled from: supports_city */
public class AuthenticateSsoMethod$Params {
    public final String f2309a;
    @Nullable
    public final String f2310b;
    @Nullable
    public final String f2311c;
    public final boolean f2312d;

    public AuthenticateSsoMethod$Params(String str, @Nullable String str2, boolean z) {
        this(str, str2, null, z);
    }

    public AuthenticateSsoMethod$Params(String str, @Nullable String str2, @Nullable String str3, boolean z) {
        this.f2309a = str;
        this.f2310b = str2;
        this.f2311c = str3;
        this.f2312d = z;
    }
}
