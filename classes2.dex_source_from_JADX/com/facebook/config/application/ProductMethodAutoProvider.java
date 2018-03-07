package com.facebook.config.application;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: total_mqtt_bytes_sent_background */
public class ProductMethodAutoProvider extends AbstractProvider<Product> {
    public static Product m4524b(InjectorLike injectorLike) {
        return FbAppTypeModule.m1444a((FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    public Object get() {
        return FbAppTypeModule.m1444a((FbAppType) getInstance(FbAppType.class));
    }

    public static Product m4523a(InjectorLike injectorLike) {
        return m4524b(injectorLike);
    }
}
