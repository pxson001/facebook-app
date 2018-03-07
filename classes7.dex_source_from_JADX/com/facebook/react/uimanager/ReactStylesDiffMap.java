package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import javax.annotation.Nullable;

/* compiled from: friend_finder_add_friends_manage */
public class ReactStylesDiffMap {
    final ReadableMap f11766a;

    public ReactStylesDiffMap(ReadableMap readableMap) {
        this.f11766a = readableMap;
    }

    public final boolean m13942a(String str) {
        return this.f11766a.hasKey(str);
    }

    public final boolean m13944b(String str) {
        return this.f11766a.isNull(str);
    }

    public final boolean m13943a(String str, boolean z) {
        return this.f11766a.isNull(str) ? z : this.f11766a.getBoolean(str);
    }

    public final double m13939a(String str, double d) {
        return this.f11766a.isNull(str) ? d : this.f11766a.getDouble(str);
    }

    public final float m13940a(String str, float f) {
        return this.f11766a.isNull(str) ? f : (float) this.f11766a.getDouble(str);
    }

    public final int m13941a(String str, int i) {
        return this.f11766a.isNull(str) ? i : this.f11766a.getInt(str);
    }

    @Nullable
    public final String m13945c(String str) {
        return this.f11766a.getString(str);
    }

    @Nullable
    public final ReadableArray m13946d(String str) {
        return this.f11766a.mo678a(str);
    }

    @Nullable
    public final ReadableMap m13947e(String str) {
        return this.f11766a.mo680b(str);
    }

    public String toString() {
        return "{ " + getClass().getSimpleName() + ": " + this.f11766a.toString() + " }";
    }
}
