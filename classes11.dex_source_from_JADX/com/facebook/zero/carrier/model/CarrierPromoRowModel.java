package com.facebook.zero.carrier.model;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

/* compiled from: music_pause */
public class CarrierPromoRowModel {
    public final int f5315a;
    public final String f5316b;
    public final String f5317c;
    public final boolean f5318d;
    public final List<CarrierPromoSubRowModel> f5319e = Lists.a();

    public CarrierPromoRowModel(int i, String str, String str2, boolean z, CarrierPromoSubRowModel... carrierPromoSubRowModelArr) {
        this.f5315a = i;
        this.f5316b = str;
        this.f5317c = str2;
        this.f5318d = z;
        this.f5319e.addAll(Arrays.asList(carrierPromoSubRowModelArr));
    }
}
