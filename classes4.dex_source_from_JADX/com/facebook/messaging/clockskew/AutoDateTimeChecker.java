package com.facebook.messaging.clockskew;

import android.content.ContentResolver;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: favorite_item_id */
public class AutoDateTimeChecker {
    private static final Boolean f12197a = Boolean.valueOf(VERSION.SDK_INT >= 17);
    private ContentResolver f12198b;

    public static AutoDateTimeChecker m12865b(InjectorLike injectorLike) {
        return new AutoDateTimeChecker(ContentResolverMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public AutoDateTimeChecker(ContentResolver contentResolver) {
        this.f12198b = contentResolver;
    }

    public final boolean m12866a() {
        if (f12197a.booleanValue()) {
            if (Global.getInt(this.f12198b, "auto_time", 0) != 0) {
                return true;
            }
            return false;
        } else if (System.getInt(this.f12198b, "auto_time", 0) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
