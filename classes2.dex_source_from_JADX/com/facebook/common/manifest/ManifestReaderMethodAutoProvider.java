package com.facebook.common.manifest;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: raw_rtt */
public class ManifestReaderMethodAutoProvider extends AbstractProvider<ManifestReader> {
    public static ManifestReader m12734b(InjectorLike injectorLike) {
        return ManifestModule.m12737a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return ManifestModule.m12737a((Context) getInstance(Context.class));
    }

    public static ManifestReader m12733a(InjectorLike injectorLike) {
        return m12734b(injectorLike);
    }
}
