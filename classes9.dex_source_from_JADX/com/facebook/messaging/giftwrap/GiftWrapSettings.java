package com.facebook.messaging.giftwrap;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mSellerInfo */
public class GiftWrapSettings {
    public final int f11127a;
    @Nullable
    public final String f11128b;
    public final int f11129c;
    public final int f11130d;

    /* compiled from: mSellerInfo */
    public class Builder {
        public int f11123a;
        @Nullable
        public String f11124b;
        public int f11125c;
        public int f11126d;
    }

    public GiftWrapSettings(Builder builder) {
        this.f11127a = builder.f11123a;
        this.f11128b = builder.f11124b;
        this.f11129c = builder.f11125c;
        this.f11130d = builder.f11126d;
    }
}
