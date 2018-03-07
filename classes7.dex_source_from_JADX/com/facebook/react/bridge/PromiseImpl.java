package com.facebook.react.bridge;

import javax.annotation.Nullable;

/* compiled from: graphNotificationsUpdateSeenState */
public class PromiseImpl implements Promise {
    @Nullable
    private Callback f11532a;
    @Nullable
    private Callback f11533b;

    public PromiseImpl(@Nullable Callback callback, @Nullable Callback callback2) {
        this.f11532a = callback;
        this.f11533b = callback2;
    }

    public final void mo663a(Object obj) {
        if (this.f11532a != null) {
            this.f11532a.mo642a(obj);
        }
    }

    public final void mo664a(String str, String str2) {
        mo666b(str, str2);
    }

    public final void mo665a(Throwable th) {
        mo666b("EUNSPECIFIED", th.getMessage());
    }

    public final void mo666b(String str, String str2) {
        if (this.f11533b != null) {
            if (str == null) {
                str = "EUNSPECIFIED";
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("code", str);
            writableNativeMap.putString("message", str2);
            this.f11533b.mo642a(writableNativeMap);
        }
    }
}
