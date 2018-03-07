package com.facebook.common.hardware;

import android.content.Context;
import android.view.ViewConfiguration;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: sphericalPlaylist */
public class FbViewConfigurationCompat {
    private final Context f2604a;

    public static FbViewConfigurationCompat m3715a(InjectorLike injectorLike) {
        return new FbViewConfigurationCompat((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FbViewConfigurationCompat(Context context) {
        this.f2604a = context;
    }

    public final boolean m3716a() {
        return ViewConfiguration.get(this.f2604a).hasPermanentMenuKey();
    }
}
