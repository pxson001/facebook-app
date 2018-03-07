package com.facebook.messaging.sms;

import android.content.Context;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.defaultapp.SmsDefaultAppManager;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;

/* compiled from: sms_takeover_device_status */
public class SmsTakeoverKillSwitch {
    public final Context f2026a;
    public final FbSharedPreferences f2027b;
    public final DefaultAndroidThreadUtil f2028c;
    public final SmsDefaultAppManager f2029d;
    private final SmsTakeoverAnalyticsLogger f2030e;
    public SmsGatekeepers f2031f;

    @Inject
    public SmsTakeoverKillSwitch(Context context, FbSharedPreferences fbSharedPreferences, DefaultAndroidThreadUtil defaultAndroidThreadUtil, SmsDefaultAppManager smsDefaultAppManager, SmsTakeoverAnalyticsLogger smsTakeoverAnalyticsLogger, SmsGatekeepers smsGatekeepers) {
        this.f2026a = context;
        this.f2027b = fbSharedPreferences;
        this.f2028c = defaultAndroidThreadUtil;
        this.f2029d = smsDefaultAppManager;
        this.f2030e = smsTakeoverAnalyticsLogger;
        this.f2031f = smsGatekeepers;
    }
}
