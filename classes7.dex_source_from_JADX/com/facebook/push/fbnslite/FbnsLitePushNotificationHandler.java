package com.facebook.push.fbnslite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.PushSource;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushdata.FbPushDataHandlerService;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.registration.FacebookPushServerRegistrar;
import com.facebook.push.registration.ServiceType;
import com.facebook.rti.common.sharedprefs.SharedPreferencesCompatHelper;
import com.facebook.rti.orca.MqttLiteInitializer;
import com.facebook.rti.push.client.FbnsCallbackHandlerBase;
import com.facebook.rti.push.client.FbnsCallbackReceiver;
import javax.inject.Inject;

/* compiled from: highlight_color */
public class FbnsLitePushNotificationHandler extends FbnsCallbackHandlerBase {
    private static final Class<?> f11258a = FbnsLitePushNotificationHandler.class;
    private PushNotifAnalyticsLogger f11259b;
    private PushTokenHolder f11260c;
    private FacebookPushServerRegistrar f11261d;
    private FbnsLiteRegistrar f11262e;
    private MqttLiteInitializer f11263f;
    private Context f11264g;

    /* compiled from: highlight_color */
    public class FbnsLiteCallbackReceiver extends FbnsCallbackReceiver {
        public FbnsLiteCallbackReceiver() {
            super(FbnsLitePushNotificationHandler.class);
        }
    }

    private static <T extends Context> void m13165a(Class<T> cls, T t) {
        m13166a((Object) t, (Context) t);
    }

    public static void m13166a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FbnsLitePushNotificationHandler) obj).m13164a((Context) fbInjector.getInstance(Context.class), PushNotifAnalyticsLogger.a(fbInjector), PushPreferenceSelector.a(fbInjector), FacebookPushServerRegistrar.a(fbInjector), FbnsLiteRegistrar.a(fbInjector), MqttLiteInitializer.a(fbInjector));
    }

    public FbnsLitePushNotificationHandler() {
        super(FbnsLitePushNotificationHandler.class.getName());
    }

    @Inject
    private void m13164a(Context context, PushNotifAnalyticsLogger pushNotifAnalyticsLogger, PushPreferenceSelector pushPreferenceSelector, FacebookPushServerRegistrar facebookPushServerRegistrar, FbnsLiteRegistrar fbnsLiteRegistrar, MqttLiteInitializer mqttLiteInitializer) {
        this.f11264g = context;
        this.f11259b = pushNotifAnalyticsLogger;
        this.f11260c = pushPreferenceSelector.a(ServiceType.FBNS_LITE);
        this.f11261d = facebookPushServerRegistrar;
        this.f11262e = fbnsLiteRegistrar;
        this.f11263f = mqttLiteInitializer;
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 2118260976);
        super.onCreate();
        AppInitLockHelper.a(this);
        Class cls = FbnsLitePushNotificationHandler.class;
        m13166a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1454525233, a);
    }

    protected final void m13167a(Intent intent) {
        FbPushDataHandlerService.m13179a((Context) this, intent.getStringExtra("data"), PushSource.FBNS_LITE);
    }

    protected final void m13168a(String str) {
        this.f11260c.a(str, ServiceType.FBNS_LITE);
        this.f11261d.a(ServiceType.FBNS_LITE, this.f11262e.a);
        this.f11262e.e();
        SharedPreferencesCompatHelper.a(m13163a().edit().putBoolean("register_and_stop", false));
        this.f11263f.i();
    }

    protected final void m13169b(String str) {
        this.f11259b.b(ServiceType.FBNS_LITE.name(), "onRegistrationError", str);
        this.f11262e.c.b();
    }

    private SharedPreferences m13163a() {
        return SharedPreferencesCompatHelper.a.a(this.f11264g, "rti.mqtt.flags", true);
    }
}
