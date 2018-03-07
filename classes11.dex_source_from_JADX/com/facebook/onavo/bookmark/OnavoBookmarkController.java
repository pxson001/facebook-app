package com.facebook.onavo.bookmark;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: text_lines */
public class OnavoBookmarkController {
    public final Context f1032a;
    private final SecureContextHelper f1033b;
    private final AbstractFbErrorReporter f1034c;
    private final PackageManager f1035d;
    public Provider<TriState> f1036e;

    /* compiled from: text_lines */
    public enum ClickTarget {
        ONAVO_COUNT,
        PROMOTION
    }

    public static OnavoBookmarkController m1393a(InjectorLike injectorLike) {
        return new OnavoBookmarkController((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 721));
    }

    @Inject
    public OnavoBookmarkController(Context context, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, PackageManager packageManager, Provider<TriState> provider) {
        this.f1032a = context;
        this.f1033b = secureContextHelper;
        this.f1034c = fbErrorReporter;
        this.f1035d = packageManager;
        this.f1036e = provider;
    }

    public final boolean m1394c() {
        try {
            Intent launchIntentForPackage = this.f1035d.getLaunchIntentForPackage("com.onavo.android.onavoid");
            if (launchIntentForPackage != null) {
                this.f1033b.b(launchIntentForPackage, this.f1032a);
                return true;
            }
        } catch (Throwable e) {
            this.f1034c.a("Onavo_bookmark_click", e);
        }
        return false;
    }
}
