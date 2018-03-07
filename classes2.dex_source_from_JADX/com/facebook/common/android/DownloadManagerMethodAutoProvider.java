package com.facebook.common.android;

import android.app.DownloadManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: reaction/session/%s/chrome */
public class DownloadManagerMethodAutoProvider extends AbstractProvider<DownloadManager> {
    public static DownloadManager m12723b(InjectorLike injectorLike) {
        return AndroidModule.m2424u((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2424u((Context) getInstance(Context.class));
    }
}
