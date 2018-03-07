package com.facebook.common.hardware;

import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: spherical_metadata */
public class CarrierMethodAutoProvider extends AbstractProvider<Carrier> {
    private static Carrier m3712b(InjectorLike injectorLike) {
        return CarrierProvider.m3713a(TelephonyManagerMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return CarrierProvider.m3713a(TelephonyManagerMethodAutoProvider.b(this));
    }
}
