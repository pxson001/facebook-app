package com.facebook.common.android;

import android.content.Context;
import android.media.AudioManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: previously_enabled */
public class AudioManagerMethodAutoProvider extends AbstractProvider<AudioManager> {
    public static AudioManager m13952b(InjectorLike injectorLike) {
        return AndroidModule.m2421r((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2421r((Context) getInstance(Context.class));
    }

    public static AudioManager m13951a(InjectorLike injectorLike) {
        return m13952b(injectorLike);
    }
}
