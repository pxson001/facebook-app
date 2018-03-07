package com.facebook.privacy.model;

import android.content.Context;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;

/* compiled from: feed-inject.json */
public class PrivacyLoadingToken extends BaseToken<String> {
    private final String f15091e;

    public PrivacyLoadingToken(Context context) {
        super(Type.LOADING);
        this.f15091e = context.getString(2131234226);
    }

    public final Object mo1186d() {
        return this.f15091e;
    }

    public final String mo1185b() {
        return this.f15091e;
    }

    public final int mo1187e() {
        return -1;
    }

    public final int mo1188f() {
        return -1;
    }

    public final int mo1189g() {
        return -1;
    }

    public final int mo1190h() {
        return -1;
    }

    public final String mo1191i() {
        return null;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Type.LOADING});
    }

    public boolean equals(Object obj) {
        return (obj instanceof BaseToken) && this.f15080a == ((BaseToken) obj).f15080a;
    }
}
