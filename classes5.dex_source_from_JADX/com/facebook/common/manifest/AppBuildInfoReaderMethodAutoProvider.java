package com.facebook.common.manifest;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: shutterAnimationComplete while  */
public class AppBuildInfoReaderMethodAutoProvider extends AbstractProvider<AppBuildInfoReader> {
    public static AppBuildInfoReader m3814b(InjectorLike injectorLike) {
        return ManifestModule.a((Context) injectorLike.getInstance(Context.class), ManifestReaderMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return ManifestModule.a((Context) getInstance(Context.class), ManifestReaderMethodAutoProvider.b(this));
    }
}
