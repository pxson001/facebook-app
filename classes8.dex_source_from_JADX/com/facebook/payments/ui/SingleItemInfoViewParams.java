package com.facebook.payments.ui;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: string is empty or null */
public class SingleItemInfoViewParams {
    @Nullable
    public final String f1992a;
    public final float f1993b;
    @Nullable
    public final String f1994c;
    @Nullable
    public final String f1995d;
    @Nullable
    public final String f1996e;

    public SingleItemInfoViewParams(SingleItemInfoViewParamsBuilder singleItemInfoViewParamsBuilder) {
        this.f1992a = singleItemInfoViewParamsBuilder.f1997a;
        this.f1993b = singleItemInfoViewParamsBuilder.f1998b;
        this.f1994c = singleItemInfoViewParamsBuilder.f1999c;
        this.f1995d = singleItemInfoViewParamsBuilder.f2000d;
        this.f1996e = singleItemInfoViewParamsBuilder.f2001e;
    }

    public static SingleItemInfoViewParamsBuilder newBuilder() {
        return new SingleItemInfoViewParamsBuilder();
    }
}
