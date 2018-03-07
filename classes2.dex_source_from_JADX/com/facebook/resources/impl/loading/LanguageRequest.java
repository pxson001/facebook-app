package com.facebook.resources.impl.loading;

import android.content.Context;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.http.interfaces.RequestPriority;
import com.google.common.base.Objects;
import java.util.Locale;

/* compiled from: threads/ */
public class LanguageRequest {
    public final Context f3009a;
    public final AppVersionInfo f3010b;
    private final Locale f3011c;
    public final Type f3012d;

    /* compiled from: threads/ */
    public enum Type {
        NORMAL,
        PREFETCH
    }

    public LanguageRequest(Type type, Context context, Locale locale, AppVersionInfo appVersionInfo) {
        this.f3012d = type;
        this.f3009a = context;
        this.f3011c = locale;
        this.f3010b = appVersionInfo;
    }

    public final int m4961c() {
        return this.f3010b.mo368b();
    }

    public final String m4962d() {
        return this.f3011c.toString();
    }

    public final RequestPriority m4963g() {
        return this.f3012d == Type.NORMAL ? RequestPriority.INTERACTIVE : RequestPriority.CAN_WAIT;
    }

    public int hashCode() {
        return Objects.hashCode(this.f3009a, this.f3011c, this.f3010b, this.f3012d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LanguageRequest)) {
            return false;
        }
        LanguageRequest languageRequest = (LanguageRequest) obj;
        if (Objects.equal(this.f3009a, languageRequest.f3009a) && Objects.equal(this.f3011c, languageRequest.f3011c) && Objects.equal(this.f3010b, languageRequest.f3010b) && Objects.equal(this.f3012d, languageRequest.f3012d)) {
            return true;
        }
        return false;
    }
}
