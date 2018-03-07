package com.facebook.messaging.business.commerceui.connectivity;

import android.net.NetworkInfo.State;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.messaging.business.commerceui.analytics.MessengerCommerceAnalyticsLogger;
import com.facebook.messaging.business.commerceui.config.WifiNotificationConfigHelper;
import com.facebook.messaging.business.commerceui.config.WifiNotificationConfigHelper.LocalNotification;
import com.facebook.messaging.business.commerceui.config.WifiNotificationXConfig;
import com.facebook.messaging.business.common.BusinessPrefKeys;
import com.facebook.messaging.connectivity.ConnectivityBroadcastReceiver.WifiNetwork;
import com.facebook.messaging.connectivity.LocalNotificationHelper;
import com.facebook.orca.notify.CommerceLocalNotificationHelper;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: numberlabel */
public class CommerceWifiConnectivityListener {
    public final WifiNotificationConfigHelper f8370a;
    private final Provider<LocalNotificationHelper> f8371b;
    public final Provider<Boolean> f8372c;
    private final Provider<Boolean> f8373d;
    public final FbSharedPreferences f8374e;
    public final MonotonicClock f8375f;
    private final FbLocationStatusUtil f8376g;
    private final MessengerCommerceAnalyticsLogger f8377h;

    public static CommerceWifiConnectivityListener m8665b(InjectorLike injectorLike) {
        return new CommerceWifiConnectivityListener(new WifiNotificationConfigHelper(XConfigReader.a(injectorLike), IdBasedProvider.a(injectorLike, 3595)), IdBasedProvider.a(injectorLike, 8802), IdBasedProvider.a(injectorLike, 4117), IdBasedProvider.a(injectorLike, 4118), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FbLocationStatusUtil.a(injectorLike), MessengerCommerceAnalyticsLogger.m8651b(injectorLike));
    }

    @Inject
    CommerceWifiConnectivityListener(WifiNotificationConfigHelper wifiNotificationConfigHelper, Provider<LocalNotificationHelper> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, FbSharedPreferences fbSharedPreferences, MonotonicClock monotonicClock, FbLocationStatusUtil fbLocationStatusUtil, MessengerCommerceAnalyticsLogger messengerCommerceAnalyticsLogger) {
        this.f8370a = wifiNotificationConfigHelper;
        this.f8371b = provider;
        this.f8372c = provider2;
        this.f8373d = provider3;
        this.f8374e = fbSharedPreferences;
        this.f8375f = monotonicClock;
        this.f8376g = fbLocationStatusUtil;
        this.f8377h = messengerCommerceAnalyticsLogger;
    }

    public final void m8667a(WifiNetwork wifiNetwork) {
        String str;
        if (((Boolean) this.f8372c.get()).booleanValue()) {
            if (this.f8375f.now() < this.f8374e.a(BusinessPrefKeys.f8675d, 0)) {
                str = null;
            } else {
                str = WifiNotificationConfigHelper.m8660a(wifiNetwork.b);
                Map a = this.f8370a.m8661a();
                str = (!Strings.isNullOrEmpty(str) && wifiNetwork.d.equals(State.CONNECTED) && a.keySet().contains(str)) ? (String) a.get(str) : null;
            }
        } else {
            str = null;
        }
        String str2 = str;
        if (!Strings.isNullOrEmpty(str2)) {
            m8663a(str2, "connect");
        }
    }

    public final void m8668a(ImmutableList<WifiNetwork> immutableList) {
        if (!immutableList.isEmpty()) {
            String b = m8666b((ImmutableList) immutableList);
            if (!Strings.isNullOrEmpty(b)) {
                m8663a(b, "scan");
            }
        }
    }

    @Nullable
    private String m8666b(ImmutableList<WifiNetwork> immutableList) {
        if (!((Boolean) this.f8372c.get()).booleanValue() || !((Boolean) this.f8373d.get()).booleanValue() || this.f8376g.a() != FbLocationStatus.State.OKAY) {
            return null;
        }
        long a = this.f8374e.a(BusinessPrefKeys.f8675d, 0);
        long now = this.f8375f.now();
        if (now < a) {
            return null;
        }
        Map a2 = this.f8370a.m8661a();
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            WifiNetwork wifiNetwork = (WifiNetwork) immutableList.get(i);
            String a3 = WifiNotificationConfigHelper.m8660a(wifiNetwork.b);
            if (!Strings.isNullOrEmpty(a3) && wifiNetwork.c > this.f8370a.f8368a.a(WifiNotificationXConfig.d, 50) && a2.keySet().contains(a3)) {
                return m8664a(Long.valueOf(now), Long.valueOf(a)) ? (String) a2.get(a3) : null;
            } else {
                i++;
            }
        }
        return null;
    }

    private boolean m8664a(Long l, Long l2) {
        if (l2.longValue() == 0) {
            this.f8374e.edit().a(BusinessPrefKeys.f8675d, l.longValue()).commit();
            return false;
        }
        long a = ((long) this.f8370a.f8368a.a(WifiNotificationXConfig.e, 2)) * 60000;
        if (Math.abs((l.longValue() - l2.longValue()) - a) < 30000) {
            return true;
        }
        if (l.longValue() - l2.longValue() <= a) {
            return false;
        }
        this.f8374e.edit().a(BusinessPrefKeys.f8675d, l.longValue()).commit();
        return false;
    }

    private void m8663a(String str, String str2) {
        LocalNotification d = this.f8370a.m8662d();
        if (d != null) {
            this.f8374e.edit().a(BusinessPrefKeys.f8675d, this.f8375f.now() + 43200000).commit();
            this.f8377h.m8656a(str, str2);
            ((CommerceLocalNotificationHelper) this.f8371b.get()).a(str, d.f8366a, d.f8367b);
        }
    }
}
