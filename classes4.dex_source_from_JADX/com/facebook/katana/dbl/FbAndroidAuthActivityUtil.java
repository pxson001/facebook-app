package com.facebook.katana.dbl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.login.ComponentName_LogoutActivityComponentMethodAutoProvider;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.service.AppSession$LogoutReason;
import com.facebook.katana.service.AppSession.LoginStatus;
import javax.inject.Inject;

/* compiled from: extra_new_state */
public class FbAndroidAuthActivityUtil {
    private final SecureContextHelper f12489a;
    private final FacebookLoginIntentManager f12490b;
    private final ComponentName f12491c;
    private final AuthLoginHelper f12492d;

    public static FbAndroidAuthActivityUtil m13234b(InjectorLike injectorLike) {
        return new FbAndroidAuthActivityUtil((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FacebookLoginIntentManager.m13240b(injectorLike), ComponentName_LogoutActivityComponentMethodAutoProvider.m13246b(injectorLike), AuthLoginHelper.b(injectorLike));
    }

    @Inject
    public FbAndroidAuthActivityUtil(SecureContextHelper secureContextHelper, FacebookLoginIntentManager facebookLoginIntentManager, ComponentName componentName, AuthLoginHelper authLoginHelper) {
        this.f12489a = secureContextHelper;
        this.f12490b = facebookLoginIntentManager;
        this.f12491c = componentName;
        this.f12492d = authLoginHelper;
    }

    public final void m13235a(Activity activity) {
        m13236a(activity, null);
    }

    public final void m13236a(Activity activity, Bundle bundle) {
        this.f12490b.m13244a(activity, bundle);
    }

    public final void m13238a(Context context) {
        this.f12489a.a(new Intent().setComponent(this.f12491c), context);
    }

    public final void m13239b(Activity activity) {
        this.f12490b.m13245b(activity);
    }

    public final void m13237a(Activity activity, boolean z) {
        if (z) {
            AppSession a = AppSession.a(activity);
            if (a.f == LoginStatus.STATUS_LOGGED_OUT) {
                m13239b(activity);
                return;
            }
            a.a(new 1(this, a, activity));
            a.a(activity, AppSession$LogoutReason.FORCED_ERROR_INVALID_SESSION);
            return;
        }
        m13239b(activity);
    }
}
