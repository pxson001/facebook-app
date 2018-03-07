package com.facebook.push.registration;

import android.content.Context;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.push.analytics.PushNotifAnalyticsLogger;
import com.facebook.push.fbpushtoken.PushPrefKeys;
import com.facebook.push.fbpushtoken.PushTokenHolder;

/* compiled from: initial_count */
public class RegistrarHelperProvider extends AbstractAssistedProvider<RegistrarHelper> {
    public final RegistrarHelper m10868a(ServiceType serviceType, PushPrefKeys pushPrefKeys, PushTokenHolder pushTokenHolder) {
        return new RegistrarHelper((Context) getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), PushNotifAnalyticsLogger.m10876a((InjectorLike) this), FbAlarmManagerImpl.a(this), (Clock) SystemClockMethodAutoProvider.a(this), serviceType, pushPrefKeys, pushTokenHolder);
    }
}
