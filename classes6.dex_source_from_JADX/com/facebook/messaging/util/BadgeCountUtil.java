package com.facebook.messaging.util;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: totalItemCount */
public class BadgeCountUtil {
    private final Context f2826a;

    public static BadgeCountUtil m3945b(InjectorLike injectorLike) {
        return new BadgeCountUtil((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BadgeCountUtil(Context context) {
        this.f2826a = context;
    }

    public final CharSequence m3946a(int i) {
        if (i <= 0) {
            return "";
        }
        if (i <= 99) {
            return String.valueOf(i);
        }
        return this.f2826a.getString(2131231778, new Object[]{Integer.valueOf(99)});
    }
}
