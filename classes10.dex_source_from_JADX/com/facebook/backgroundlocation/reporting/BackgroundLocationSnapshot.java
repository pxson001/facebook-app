package com.facebook.backgroundlocation.reporting;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import com.facebook.common.time.MonotonicClock;
import com.facebook.wifiscan.ScanResultAgeUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@JsonType
/* compiled from: diode_qp_module */
public class BackgroundLocationSnapshot {
    String f14934a;
    Coordinates f14935b;
    Long f14936c;
    Float f14937d;
    Double f14938e;
    Float f14939f;
    Float f14940g;
    Long f14941h;
    Long f14942i;
    Integer f14943j;
    WifiInfo f14944k;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: diode_qp_module */
    @interface AuraLocationUpdateType {
    }

    /* compiled from: diode_qp_module */
    public class Builder {
        String f14910a;
        Coordinates f14911b;
        Long f14912c;
        Float f14913d;
        Double f14914e;
        Float f14915f;
        Float f14916g;
        Long f14917h;
        Long f14918i;
        Integer f14919j;
        WifiInfo f14920k;

        public Builder(String str, Coordinates coordinates, Long l, Float f) {
            this.f14910a = str;
            this.f14911b = coordinates;
            this.f14912c = l;
            this.f14913d = f;
        }

        public final Builder m15363a(@Nullable Double d) {
            this.f14914e = d;
            return this;
        }

        public final Builder m15364a(@Nullable Float f) {
            this.f14915f = f;
            return this;
        }

        public final Builder m15368b(@Nullable Float f) {
            this.f14916g = f;
            return this;
        }

        public final Builder m15366a(@Nullable Long l) {
            this.f14917h = l;
            return this;
        }

        public final Builder m15369b(@Nullable Long l) {
            this.f14918i = l;
            return this;
        }

        public final Builder m15365a(Integer num) {
            this.f14919j = num;
            return this;
        }

        public final Builder m15362a(@Nullable WifiInfo wifiInfo) {
            this.f14920k = wifiInfo;
            return this;
        }

        public final BackgroundLocationSnapshot m15367a() {
            return new BackgroundLocationSnapshot(this);
        }
    }

    @JsonType
    /* compiled from: diode_qp_module */
    public class ConnectedWifi {
        public String f14921a;
        public Integer f14922b;
        public String f14923c;
        public Integer f14924d;

        public ConnectedWifi() {
            this.f14921a = null;
            this.f14922b = null;
            this.f14923c = null;
            this.f14924d = null;
        }

        private ConnectedWifi(String str, Integer num, String str2, Integer num2) {
            this.f14921a = str;
            this.f14922b = num;
            this.f14923c = str2;
            this.f14924d = num2;
        }

        public static ConnectedWifi m15370a(@Nullable android.net.wifi.WifiInfo wifiInfo) {
            Integer num = null;
            if (wifiInfo == null) {
                return null;
            }
            String bssid = wifiInfo.getBSSID();
            Integer valueOf = Integer.valueOf(wifiInfo.getRssi());
            String ssid = wifiInfo.getSSID();
            if (VERSION.SDK_INT >= 21) {
                Preconditions.checkState(VERSION.SDK_INT >= 21);
                num = Integer.valueOf(wifiInfo.getFrequency());
            }
            return new ConnectedWifi(bssid, valueOf, ssid, num);
        }
    }

    @JsonType
    /* compiled from: diode_qp_module */
    public class Coordinates {
        public double f14925a;
        public double f14926b;

        public Coordinates() {
            this(0.0d, 0.0d);
        }

        public Coordinates(double d, double d2) {
            this.f14925a = d;
            this.f14926b = d2;
        }
    }

    @JsonType
    /* compiled from: diode_qp_module */
    public class WifiInfo {
        List<WifiScanResult> f14927a;
        ConnectedWifi f14928b;

        public WifiInfo() {
            this.f14927a = null;
            this.f14928b = null;
        }

        private WifiInfo(@Nullable List<WifiScanResult> list, @Nullable ConnectedWifi connectedWifi) {
            this.f14927a = list;
            this.f14928b = connectedWifi;
        }

        @Nullable
        public static WifiInfo m15371a(@Nullable List<ScanResult> list, @Nullable android.net.wifi.WifiInfo wifiInfo, MonotonicClock monotonicClock) {
            if (list == null && wifiInfo == null) {
                return null;
            }
            ImmutableList immutableList;
            if (list == null) {
                immutableList = null;
            } else {
                Collection arrayList = new ArrayList();
                for (ScanResult scanResult : list) {
                    Long valueOf = Long.valueOf(0);
                    if (VERSION.SDK_INT >= 17) {
                        valueOf = Long.valueOf(ScanResultAgeUtil.a(scanResult, monotonicClock.now()));
                    }
                    arrayList.add(new WifiScanResult(valueOf, scanResult.BSSID, Integer.valueOf(scanResult.level), scanResult.SSID, Integer.valueOf(scanResult.frequency)));
                }
                immutableList = ImmutableList.copyOf(arrayList);
            }
            return new WifiInfo(immutableList, ConnectedWifi.m15370a(wifiInfo));
        }
    }

    @JsonType
    /* compiled from: diode_qp_module */
    public class WifiScanResult {
        public Long f14929a;
        public String f14930b;
        public Integer f14931c;
        public String f14932d;
        public Integer f14933e;

        public WifiScanResult() {
            this.f14929a = null;
            this.f14930b = null;
            this.f14931c = null;
            this.f14932d = null;
            this.f14933e = null;
        }

        public WifiScanResult(Long l, String str, Integer num, String str2, Integer num2) {
            this.f14929a = l;
            this.f14930b = str;
            this.f14931c = num;
            this.f14932d = str2;
            this.f14933e = num2;
        }
    }

    public BackgroundLocationSnapshot() {
        this.f14934a = null;
        this.f14935b = null;
        this.f14936c = null;
        this.f14937d = null;
        this.f14938e = null;
        this.f14939f = null;
        this.f14940g = null;
        this.f14941h = null;
        this.f14942i = null;
        this.f14943j = null;
        this.f14944k = null;
    }

    public BackgroundLocationSnapshot(Builder builder) {
        this.f14934a = builder.f14910a;
        this.f14935b = builder.f14911b;
        this.f14936c = builder.f14912c;
        this.f14937d = builder.f14913d;
        this.f14938e = builder.f14914e;
        this.f14939f = builder.f14915f;
        this.f14940g = builder.f14916g;
        this.f14941h = builder.f14917h;
        this.f14942i = builder.f14918i;
        this.f14943j = builder.f14919j;
        this.f14944k = builder.f14920k;
    }
}
