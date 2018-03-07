package com.facebook.sideloading;

import android.accounts.AccountManager;
import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.google.android.gms.common.GoogleApiAvailability;
import javax.inject.Inject;

/* compiled from: has_clicked_on_cover_photo_themes */
public class SideloadingChecker {
    public final Context f10028a;

    public static SideloadingChecker m10113b(InjectorLike injectorLike) {
        return new SideloadingChecker((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public SideloadingChecker(Context context) {
        this.f10028a = context;
    }

    public final boolean m10114a() {
        Object obj;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.b;
        if (GoogleApiAvailability.a(this.f10028a) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            if ((AccountManager.get(this.f10028a).getAccountsByType("com.google").length > 0 ? 1 : null) != null) {
                return false;
            }
        }
        return true;
    }
}
