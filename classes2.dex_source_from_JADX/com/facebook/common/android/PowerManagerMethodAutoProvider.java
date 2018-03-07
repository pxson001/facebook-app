package com.facebook.common.android;

import android.content.Context;
import android.os.PowerManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tag_table_tags_index */
public class PowerManagerMethodAutoProvider extends AbstractProvider<PowerManager> {
    public static PowerManager m5525b(InjectorLike injectorLike) {
        return AndroidModule.m2407e((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2407e((Context) getInstance(Context.class));
    }

    public static PowerManager m5524a(InjectorLike injectorLike) {
        return m5525b(injectorLike);
    }
}
