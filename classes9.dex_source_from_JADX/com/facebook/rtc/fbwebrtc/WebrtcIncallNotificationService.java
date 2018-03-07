package com.facebook.rtc.fbwebrtc;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.base.service.FbService;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: audio/aac */
public class WebrtcIncallNotificationService extends FbService {
    private boolean f19390a = false;
    private String f19391b;
    private FacebookOnlyIntentActionFactory f19392c;
    private QeAccessor f19393d;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f19394e = UltralightRuntime.b;

    private static <T extends Context> void m19369a(Class<T> cls, T t) {
        m19370a((Object) t, (Context) t);
    }

    public static void m19370a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        WebrtcIncallNotificationService webrtcIncallNotificationService = (WebrtcIncallNotificationService) obj;
        webrtcIncallNotificationService.m19367a(FacebookOnlyIntentActionFactory.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
        webrtcIncallNotificationService.f19394e = IdBasedLazy.a(fbInjector, 10375);
    }

    public final int m19376a(Intent intent, int i, int i2) {
        if (((WebrtcUiHandler) this.f19394e.get()).ak == 0) {
            stopSelfResult(i2);
        } else {
            m19371a(intent.getStringExtra("CONTACT_NAME"));
        }
        return 2;
    }

    private void m19368a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f19394e = lazy;
    }

    public final void m19377a() {
        super.a();
        Class cls = WebrtcIncallNotificationService.class;
        m19370a((Object) this, (Context) this);
    }

    @Inject
    private void m19367a(FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory, QeAccessor qeAccessor) {
        this.f19392c = facebookOnlyIntentActionFactory;
        this.f19393d = qeAccessor;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void m19371a(String str) {
        if (!this.f19390a || !str.contentEquals(this.f19391b)) {
            startForeground(20002, m19372b(str));
            this.f19391b = str;
            this.f19390a = true;
        }
    }

    private Notification m19372b(String str) {
        try {
            m19373b().cancel();
            m19375d().cancel();
            m19374c().cancel();
        } catch (Throwable th) {
        }
        Builder a = new Builder(this).a(str).b(getString(2131231987)).a(true).a(m19373b());
        if (this.f19393d.a(Liveness.Cached, ExperimentsForRtcModule.D, false)) {
            a.a(2130843969, getString(2131231970), m19374c());
            a.d(2).a(0);
        }
        if (VERSION.SDK_INT > 19) {
            a.a(2130844003);
        } else {
            a.a(2130843998);
        }
        return a.c();
    }

    private PendingIntent m19373b() {
        return SecurePendingIntent.b(this, 0, new Intent(this.f19392c.a("RTC_SHOW_CALL_UI")), 134217728);
    }

    private PendingIntent m19374c() {
        return SecurePendingIntent.b(this, 0, new Intent(this.f19392c.a("RTC_END_CALL_ACTION")), 134217728);
    }

    private PendingIntent m19375d() {
        Intent intent = new Intent(this.f19392c.a("RTC_SHOW_THREAD_VIEW_ACTION"));
        intent.putExtra("IS_CONFERENCE_CALL", ((WebrtcUiHandler) this.f19394e.get()).m19473g());
        if (((WebrtcUiHandler) this.f19394e.get()).m19473g()) {
            ThreadKey threadKey = ((WebrtcUiHandler) this.f19394e.get()).aj;
            if (threadKey != null) {
                intent.putExtra("THREAD_ID", threadKey.i());
            }
        } else {
            intent.putExtra("CONTACT_ID", ((WebrtcUiHandler) this.f19394e.get()).ai);
        }
        return SecurePendingIntent.b(this, 0, intent, 134217728);
    }
}
