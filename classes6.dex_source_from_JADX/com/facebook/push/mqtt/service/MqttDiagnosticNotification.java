package com.facebook.push.mqtt.service;

import android.app.NotificationManager;
import android.content.Context;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;

/* compiled from: snowflake */
public class MqttDiagnosticNotification {
    private static final PrefKey f4288a = ((PrefKey) SharedPrefKeys.c.a("mqtt_notif"));
    private final FbAppType f4289b;
    private final Context f4290c;
    private final NotificationManager f4291d;
    private final FbSharedPreferences f4292e;

    private static MqttDiagnosticNotification m6397b(InjectorLike injectorLike) {
        return new MqttDiagnosticNotification((Context) injectorLike.getInstance(Context.class), (FbAppType) injectorLike.getInstance(FbAppType.class), NotificationManagerMethodAutoProvider.b(injectorLike.getApplicationInjector()), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public MqttDiagnosticNotification(Context context, FbAppType fbAppType, @NeedsApplicationInjector NotificationManager notificationManager, FbSharedPreferences fbSharedPreferences) {
        this.f4290c = context;
        this.f4289b = fbAppType;
        this.f4291d = notificationManager;
        this.f4292e = fbSharedPreferences;
    }
}
