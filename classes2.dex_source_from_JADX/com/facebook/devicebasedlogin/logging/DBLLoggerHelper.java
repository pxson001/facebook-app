package com.facebook.devicebasedlogin.logging;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

/* compiled from: sms_takeover_readonly_killswitch */
public class DBLLoggerHelper {
    private FbSharedPreferences f4529a;
    private AnalyticsLogger f4530b;
    private XConfigReader f4531c;

    public static DBLLoggerHelper m8231b(InjectorLike injectorLike) {
        return new DBLLoggerHelper(FbSharedPreferencesImpl.m1826a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public DBLLoggerHelper(FbSharedPreferences fbSharedPreferences, AnalyticsLogger analyticsLogger, XConfigReader xConfigReader) {
        this.f4529a = fbSharedPreferences;
        this.f4530b = analyticsLogger;
        this.f4531c = xConfigReader;
    }

    public final void m8232a(String str, Bundle bundle) {
        if (str != null) {
            HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
            honeyClientEvent.m5090b("source_datr", this.f4529a.mo278a(AuthPrefKeys.f2951f, null));
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    honeyClientEvent.m5086a(str2, bundle.get(str2));
                }
            }
            this.f4530b.mo532b(honeyClientEvent, this.f4531c.m2683a(DeviceBasedLoginXConfig.d, 1));
        }
    }

    public static DBLLoggerHelper m8230a(InjectorLike injectorLike) {
        return m8231b(injectorLike);
    }
}
