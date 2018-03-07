package com.facebook.push.adm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.PushSource;
import com.facebook.push.fbpushdata.FbPushDataHandlerService;
import org.json.JSONObject;

/* compiled from: hue_colorize */
public class ADMService extends FbIntentService {
    private static final Class<?> f11227a = ADMService.class;
    private ADMRegistrar f11228b;
    private FbSharedPreferences f11229c;
    private ReliabilityAnalyticsLogger f11230d;
    private Clock f11231e;
    private ADMPushPrefKeys f11232f;

    public ADMService() {
        super("ADMService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 594748046);
        super.onCreate();
        AppInitLockHelper.a(this);
        FbInjector fbInjector = FbInjector.get(this);
        this.f11228b = ADMRegistrar.a(fbInjector);
        this.f11229c = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        this.f11230d = ReliabilityAnalyticsLogger.a(fbInjector);
        this.f11231e = (Clock) SystemClockMethodAutoProvider.a(fbInjector);
        this.f11232f = ADMPushPrefKeys.m13140a(fbInjector);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 955798924, a);
    }

    protected final void m13151a(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if (intent.getAction().equals("registration")) {
                m13148b(intent);
            } else if (intent.getAction().equals("registration_error")) {
                m13149c(intent);
            } else if (intent.getAction().equals("message_received")) {
                m13150d(intent);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -1397686120, Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -939748922));
    }

    private void m13148b(Intent intent) {
        this.f11228b.a(intent.getStringExtra("registration_id"), null, false);
    }

    private void m13149c(Intent intent) {
        this.f11228b.a(null, intent.getStringExtra("registration_error_id"), true);
    }

    private void m13150d(Intent intent) {
        String str = "ADM";
        String str2 = null;
        Bundle bundleExtra = intent.getBundleExtra("bundle");
        if (bundleExtra != null) {
            m13147b();
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str3 : bundleExtra.keySet()) {
                    String str32;
                    if (str32.equals("params")) {
                        jSONObject.put(str32, new JSONObject(bundleExtra.getString(str32)));
                    } else {
                        jSONObject.put(str32, bundleExtra.getString(str32));
                    }
                    if (str32 == null || !str32.equals("PushNotifId")) {
                        str32 = str2;
                    } else {
                        str32 = bundleExtra.getString("PushNotifId");
                    }
                    str2 = str32;
                }
                new StringBuilder("ADM JSON message: ").append(jSONObject.toString());
            } catch (Exception e) {
                BLog.b(f11227a, e.getMessage());
                this.f11230d.a(str, null, e);
            }
            FbPushDataHandlerService.m13179a((Context) this, jSONObject.toString(), PushSource.ADM);
        }
    }

    private void m13147b() {
        Editor edit = this.f11229c.edit();
        edit.a(this.f11232f.f, this.f11231e.a());
        edit.commit();
    }
}
