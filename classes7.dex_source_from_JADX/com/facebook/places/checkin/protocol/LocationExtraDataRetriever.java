package com.facebook.places.checkin.protocol;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.graphql.calls.CheckinSearchQueryInputCheckinSearchQuery;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifi;
import com.facebook.places.checkin.protocol.CheckinSearchQueryLocationExtraData.CheckinSearchQueryLocationExtraDataWifiObject;
import com.facebook.wifiscan.ScanResultAgeUtil;
import com.facebook.wifiscan.WifiScanCache;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: infrastructure */
public class LocationExtraDataRetriever {
    public final Provider<WifiManager> f11097a;
    private final Lazy<WifiScanCache> f11098b;
    private final Provider<FbObjectMapper> f11099c;

    public static LocationExtraDataRetriever m13051b(InjectorLike injectorLike) {
        return new LocationExtraDataRetriever(IdBasedProvider.a(injectorLike, 40), IdBasedSingletonScopeProvider.b(injectorLike, 3741), IdBasedSingletonScopeProvider.a(injectorLike, 572));
    }

    @Inject
    public LocationExtraDataRetriever(Provider<WifiManager> provider, Lazy<WifiScanCache> lazy, Provider<FbObjectMapper> provider2) {
        this.f11097a = provider;
        this.f11098b = lazy;
        this.f11099c = provider2;
    }

    public final boolean m13053a(CheckinSearchQueryInputCheckinSearchQuery checkinSearchQueryInputCheckinSearchQuery) {
        CheckinSearchQueryLocationExtraData a = m13050a();
        if (a == null) {
            return false;
        }
        try {
            checkinSearchQueryInputCheckinSearchQuery.b(((FbObjectMapper) this.f11099c.get()).a(a));
            return true;
        } catch (JsonProcessingException e) {
            throw Throwables.propagate(e);
        }
    }

    private CheckinSearchQueryLocationExtraData m13050a() {
        CheckinSearchQueryLocationExtraDataWifiObject checkinSearchQueryLocationExtraDataWifiObject;
        WifiManager wifiManager = (WifiManager) this.f11097a.get();
        if (wifiManager.isWifiEnabled()) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                checkinSearchQueryLocationExtraDataWifiObject = null;
            } else {
                String str;
                int i;
                String bssid = connectionInfo.getBSSID();
                String ssid = connectionInfo.getSSID();
                if (ssid == null) {
                    str = null;
                } else {
                    str = ssid.replaceAll("\"", "");
                }
                ssid = str;
                int rssi = connectionInfo.getRssi();
                if (VERSION.SDK_INT < 21) {
                    i = 0;
                } else {
                    i = connectionInfo.getFrequency();
                }
                checkinSearchQueryLocationExtraDataWifiObject = new CheckinSearchQueryLocationExtraDataWifiObject(bssid, ssid, rssi, i, Long.valueOf(0));
            }
        } else {
            checkinSearchQueryLocationExtraDataWifiObject = null;
        }
        return new CheckinSearchQueryLocationExtraData(new CheckinSearchQueryLocationExtraDataWifi(checkinSearchQueryLocationExtraDataWifiObject, m13052c()), null);
    }

    @Nullable
    private List<CheckinSearchQueryLocationExtraDataWifiObject> m13052c() {
        List a = ((WifiScanCache) this.f11098b.get()).a(60000);
        if (a == null || a.isEmpty()) {
            return null;
        }
        final long uptimeMillis = SystemClock.uptimeMillis();
        return Lists.a(a, new Function<ScanResult, CheckinSearchQueryLocationExtraDataWifiObject>(this) {
            final /* synthetic */ LocationExtraDataRetriever f11096b;

            public Object apply(Object obj) {
                ScanResult scanResult = (ScanResult) obj;
                return new CheckinSearchQueryLocationExtraDataWifiObject(scanResult.BSSID, scanResult.SSID, scanResult.level, scanResult.frequency, Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(ScanResultAgeUtil.a(scanResult, uptimeMillis))));
            }
        });
    }
}
