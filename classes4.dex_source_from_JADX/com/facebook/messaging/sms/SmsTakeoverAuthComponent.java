package com.facebook.messaging.sms;

import android.content.Context;
import android.os.Handler;
import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.inject.Inject;

/* compiled from: sync_photo_failure */
public class SmsTakeoverAuthComponent extends AbstractAuthComponent {
    private final String f1427a = "SmsTakeoverAuthComponent";
    public final Context f1428b;
    private final Handler f1429c;
    private final FbSharedPreferences f1430d;
    public final SmsDefaultAppManager f1431e;
    private final boolean f1432f;

    @Inject
    public SmsTakeoverAuthComponent(Context context, Handler handler, FbSharedPreferences fbSharedPreferences, SmsDefaultAppManager smsDefaultAppManager, Boolean bool) {
        this.f1428b = context;
        this.f1429c = handler;
        this.f1430d = fbSharedPreferences;
        this.f1431e = smsDefaultAppManager;
        this.f1432f = bool.booleanValue();
    }

    public final void m1671b() {
        if (this.f1430d.a(AuthPrefKeys.w, false)) {
            m1670i();
        }
    }

    public final void m1672h() {
        super.h();
        if (!this.f1430d.a(AuthPrefKeys.w, false)) {
            m1670i();
        }
    }

    private void m1670i() {
        if (!this.f1432f) {
            this.f1430d.edit().b(SmsPrefKeys.f13578a).commit();
            HandlerDetour.a(this.f1429c, new 1(this), 372704553);
        }
    }
}
