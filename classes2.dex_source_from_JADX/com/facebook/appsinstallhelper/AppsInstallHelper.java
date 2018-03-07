package com.facebook.appsinstallhelper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.content.AppInfo;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: impl */
public class AppsInstallHelper {
    private final SecureContextHelper f20315a;
    private final GooglePlayIntentHelper f20316b;
    private final AppsInstallInfo f20317c;
    private final AppInfo f20318d;

    @Inject
    public AppsInstallHelper(SecureContextHelper secureContextHelper, GooglePlayIntentHelper googlePlayIntentHelper, AppInfo appInfo, @Assisted AppsInstallInfo appsInstallInfo) {
        this.f20315a = secureContextHelper;
        this.f20316b = googlePlayIntentHelper;
        this.f20317c = appsInstallInfo;
        this.f20318d = appInfo;
    }

    public final boolean m27977a() {
        if (this.f20318d.d(this.f20317c.mo3127a(), 1) != null) {
            return true;
        }
        return false;
    }

    public final void m27975a(Context context) {
        this.f20316b.m22736a(context, this.f20317c.mo3127a());
    }

    public final void m27976a(String str, Context context) {
        Intent a = this.f20316b.m22735a(str);
        if (a == null) {
            m27978b(str, context);
            return;
        }
        a.setFlags(268435456);
        this.f20315a.mo665b(a, context);
    }

    public final void m27978b(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(335544320);
        this.f20315a.mo665b(intent, context);
    }
}
