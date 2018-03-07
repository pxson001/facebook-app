package com.facebook.runtimepermissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: prompt_state */
public class RuntimePermissionsUtil {
    public final Context f8748a;
    public final SecureContextHelper f8749b;

    public static RuntimePermissionsUtil m13589b(InjectorLike injectorLike) {
        return new RuntimePermissionsUtil((Context) injectorLike.getInstance(Context.class, ForAppContext.class), DefaultSecureContextHelper.m4636a(injectorLike));
    }

    @Inject
    public RuntimePermissionsUtil(@ForAppContext Context context, SecureContextHelper secureContextHelper) {
        this.f8748a = context;
        this.f8749b = secureContextHelper;
    }

    public final boolean m13592a() {
        if (VERSION.SDK_INT < 23) {
            return m13593a("android.permission.SYSTEM_ALERT_WINDOW");
        }
        return Settings.canDrawOverlays(this.f8748a);
    }

    public static RuntimePermissionsUtil m13588a(InjectorLike injectorLike) {
        return m13589b(injectorLike);
    }

    public final boolean m13594a(String[] strArr) {
        for (String a : strArr) {
            if (!m13593a(a)) {
                return false;
            }
        }
        return true;
    }

    public final boolean m13593a(String str) {
        try {
            if (str.equalsIgnoreCase("android.permission.SYSTEM_ALERT_WINDOW") && VERSION.SDK_INT >= 23) {
                return m13592a();
            }
            if (this.f8748a.checkCallingOrSelfPermission(str) == 0) {
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public final void m13595b() {
        Intent d = m13590d();
        d.addFlags(268435456);
        this.f8749b.mo665b(d, this.f8748a);
    }

    public final void m13591a(int i, Activity activity) {
        this.f8749b.mo663b(m13590d(), i, activity);
    }

    private Intent m13590d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f8748a.getPackageName()));
        return intent;
    }
}
