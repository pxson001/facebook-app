package com.facebook.messaging.ui.name;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: checkout_fragment */
public class ThreadNameViewData {
    public final boolean f18233a;
    public final String f18234b;
    public final ImmutableList<String> f18235c;

    public ThreadNameViewData(boolean z, @Nullable String str, ImmutableList<String> immutableList) {
        this.f18233a = z;
        this.f18234b = str;
        this.f18235c = immutableList;
    }

    public final boolean m18190c() {
        return this.f18233a;
    }

    public final String m18191d() {
        return this.f18234b;
    }

    public final ImmutableList<String> m18192e() {
        return this.f18235c;
    }

    public String toString() {
        return this.f18234b;
    }
}
