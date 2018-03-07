package com.facebook.push.registration;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.time.Clock;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.analytics.PushServerRegistrationClientEvent;
import com.facebook.push.fbpushtoken.PushPrefKeys;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: include_full_user_info */
public class RegistrarHelper {
    private static final Class<?> f10385a = RegistrarHelper.class;
    private final Context f10386b;
    private final FbSharedPreferences f10387c;
    private final PushNotifAnalyticsLogger f10388d;
    private final PushTokenHolder f10389e;
    private final FbAlarmManagerImpl f10390f;
    private final Clock f10391g;
    private final ServiceType f10392h;
    private final PushPrefKeys f10393i;

    @Inject
    public RegistrarHelper(Context context, FbSharedPreferences fbSharedPreferences, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, FbAlarmManagerImpl fbAlarmManagerImpl, Clock clock, @Assisted ServiceType serviceType, @Assisted PushPrefKeys pushPrefKeys, @Assisted PushTokenHolder pushTokenHolder) {
        this.f10386b = context;
        this.f10387c = fbSharedPreferences;
        this.f10388d = pushNotifAnalyticsLogger;
        this.f10389e = pushTokenHolder;
        this.f10390f = fbAlarmManagerImpl;
        this.f10391g = clock;
        this.f10392h = serviceType;
        this.f10393i = pushPrefKeys;
    }

    public final void m10935a(Registrar registrar) {
        m10936a(PushServerRegistrationClientEvent.INVALID_TOKEN.name(), null);
        if (this.f10391g.a() - this.f10389e.m10921l() >= 86400000) {
            this.f10389e.m10918h();
            registrar.mo799a();
        }
    }

    public final void m10936a(String str, @Nullable String str2) {
        this.f10388d.m10882a(this.f10392h.name(), str, this.f10389e.m10910a(), String.valueOf(m10931d()), str2);
    }

    public final void m10938b(String str, String str2) {
        this.f10388d.m10881a(this.f10392h.name(), str, this.f10389e.m10910a(), str2);
    }

    public final void m10933a() {
        long a = this.f10391g.a() + 10800000;
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f10390f;
        PendingIntent e = m10932e();
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(1, a, e);
        } else {
            fbAlarmManagerImpl.a.setExact(1, a, e);
        }
    }

    public final void m10934a(PendingIntent pendingIntent) {
        long d = m10931d();
        Long.valueOf(d);
        FbAlarmManagerImpl fbAlarmManagerImpl = this.f10390f;
        long elapsedRealtime = SystemClock.elapsedRealtime() + d;
        if (VERSION.SDK_INT < 19) {
            fbAlarmManagerImpl.a.set(3, elapsedRealtime, pendingIntent);
        } else {
            fbAlarmManagerImpl.a.setExact(3, elapsedRealtime, pendingIntent);
        }
        m10930a(d * 2);
    }

    public final void m10937b() {
        m10934a(m10932e());
    }

    public final void m10939c() {
        this.f10390f.a(m10932e());
    }

    private long m10931d() {
        return this.f10387c.a(this.f10393i.f10376e, 30000);
    }

    private void m10930a(long j) {
        if (j > 1800000) {
            j = 1800000;
        }
        Editor edit = this.f10387c.edit();
        edit.a(this.f10393i.f10376e, j);
        edit.commit();
    }

    private PendingIntent m10932e() {
        Intent intent = new Intent(this.f10386b, RegistrarHelperReceiver.class);
        intent.setAction("com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY");
        intent.putExtra("serviceType", this.f10392h.name());
        return SecurePendingIntent.m10163b(this.f10386b, -1, intent, 134217728);
    }
}
