package com.facebook.securitycheckup.password;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.content.SecureContextHelper;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: http.keepAlive */
public class SecurityCheckupPasswordChangeActivityLauncher {
    public final SecureContextHelper f9899a;
    public final Provider<ComponentName> f9900b;
    public final Context f9901c;

    @Inject
    public SecurityCheckupPasswordChangeActivityLauncher(Context context, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider) {
        this.f9901c = context;
        this.f9899a = secureContextHelper;
        this.f9900b = provider;
    }
}
