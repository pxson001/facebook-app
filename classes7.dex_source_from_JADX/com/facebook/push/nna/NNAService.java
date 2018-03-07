package com.facebook.push.nna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.PushSource;
import com.facebook.push.fbpushdata.FbPushDataHandlerService;
import javax.inject.Inject;

/* compiled from: hdlr */
public class NNAService extends FbIntentService {
    private static final Class<?> f11333a = NNAService.class;
    private NNARegistrar f11334b;
    private NNAReceiverWakeLockHolder f11335c;
    private FbSharedPreferences f11336d;
    private Clock f11337e;
    private NNAPushPrefKeys f11338f;

    private static <T extends Context> void m13210a(Class<T> cls, T t) {
        m13211a((Object) t, (Context) t);
    }

    public static void m13211a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((NNAService) obj).m13209a((Clock) SystemClockMethodAutoProvider.a(injectorLike), NNAPushPrefKeys.m13196a(injectorLike), NNAReceiverWakeLockHolder.m13199a(injectorLike), NNARegistrar.m13203a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    public NNAService() {
        super("NNAReceiver");
    }

    @Inject
    private void m13209a(Clock clock, NNAPushPrefKeys nNAPushPrefKeys, NNAReceiverWakeLockHolder nNAReceiverWakeLockHolder, NNARegistrar nNARegistrar, FbSharedPreferences fbSharedPreferences) {
        this.f11337e = clock;
        this.f11338f = nNAPushPrefKeys;
        this.f11334b = nNARegistrar;
        this.f11335c = nNAReceiverWakeLockHolder;
        this.f11336d = fbSharedPreferences;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -2087352742);
        super.onCreate();
        Class cls = NNAService.class;
        m13211a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -157866514, a);
    }

    protected final void m13215a(Intent intent) {
        AppInitLockHelper.a(this);
        if (intent != null) {
            try {
                if (intent.getAction() != null) {
                    if ("com.nokia.pushnotifications.intent.REGISTRATION".equals(intent.getAction())) {
                        m13213b(intent);
                    } else if ("com.nokia.pushnotifications.intent.RECEIVE".equals(intent.getAction())) {
                        m13214c(intent);
                    }
                    this.f11335c.a.d();
                    return;
                }
            } catch (Throwable th) {
                this.f11335c.a.d();
            }
        }
        this.f11335c.a.d();
    }

    private void m13213b(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        String stringExtra2 = intent.getStringExtra("registration_id");
        String stringExtra3 = intent.getStringExtra("unregistered");
        BLog.b(3);
        this.f11334b.m13207a(stringExtra2, stringExtra, stringExtra3 != null);
    }

    private void m13214c(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            m13212b();
            String string = extras.getString("notification");
            if (string != null) {
                m13212b();
                FbPushDataHandlerService.m13179a((Context) this, string, PushSource.NNA);
                return;
            }
            BLog.b(f11333a, "NNA payload missing or null");
        }
    }

    private void m13212b() {
        Editor edit = this.f11336d.edit();
        edit.a(this.f11338f.f, this.f11337e.a());
        edit.commit();
    }
}
