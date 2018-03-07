package com.facebook.katana.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.login.ComponentName_LogoutActivityComponentMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: p2p_initiate_settings */
public class LogoutHelper {
    private SecureContextHelper f7580a;
    private final ComponentName f7581b;

    public static LogoutHelper m7873b(InjectorLike injectorLike) {
        return new LogoutHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ComponentName_LogoutActivityComponentMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public LogoutHelper(SecureContextHelper secureContextHelper, ComponentName componentName) {
        this.f7580a = secureContextHelper;
        this.f7581b = componentName;
    }

    public final void m7875a(final Activity activity, boolean z) {
        if (z) {
            m7874a(activity);
            return;
        }
        Context context = activity;
        AlertDialogs.a(context, activity.getString(2131236553), 0, activity.getString(2131240008), activity.getString(2131236553), new OnClickListener(this) {
            final /* synthetic */ LogoutHelper f7579b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7579b.m7874a(activity);
            }
        }, activity.getString(2131237528), null, null, true).show();
    }

    public static LogoutHelper m7872a(InjectorLike injectorLike) {
        return m7873b(injectorLike);
    }

    public final void m7874a(Activity activity) {
        this.f7580a.a(new Intent().setComponent(this.f7581b), activity);
        activity.finish();
    }
}
