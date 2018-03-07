package com.facebook.oxygen.preloads.sdk.common;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: reaction_android_multirow_attachments */
public class PreloadSdkPresenceMethodAutoProvider extends AbstractProvider<PreloadSdkPresence> {
    public static PreloadSdkPresence m12691b(InjectorLike injectorLike) {
        return PreloadSdkModule.m12692a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return PreloadSdkModule.m12692a((Context) getInstance(Context.class));
    }

    public static PreloadSdkPresence m12690a(InjectorLike injectorLike) {
        return m12691b(injectorLike);
    }
}
