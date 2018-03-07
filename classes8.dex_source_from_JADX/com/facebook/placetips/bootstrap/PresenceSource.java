package com.facebook.placetips.bootstrap;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PresenceSourceDeserializer.class)
@JsonSerialize(using = PresenceSourceSerializer.class)
/* compiled from: search_results_loader_task */
public class PresenceSource {
    @JsonProperty("accuracy")
    final Float mAccuracy;
    @JsonProperty("latitude")
    final Double mLatitude;
    @JsonProperty("longitude")
    final Double mLongitude;
    @JsonProperty("type")
    final PresenceSourceType mPresenceSourceType;
    @JsonProperty("pulsar_rssi")
    final Integer mPulsarRssi;

    public static PresenceSource m3710a(PresenceSourceType presenceSourceType) {
        return new PresenceSource(presenceSourceType, null, null, null, null);
    }

    public static PresenceSource m3709a(int i) {
        return new PresenceSource(PresenceSourceType.BLE, Integer.valueOf(i), null, null, null);
    }

    public static PresenceSource m3708a(double d, double d2, Float f) {
        return new PresenceSource(PresenceSourceType.GPS, null, Double.valueOf(d), Double.valueOf(d2), f);
    }

    private PresenceSource(PresenceSourceType presenceSourceType, Integer num, Double d, Double d2, Float f) {
        this.mPresenceSourceType = presenceSourceType;
        this.mPulsarRssi = num;
        this.mLatitude = d;
        this.mLongitude = d2;
        this.mAccuracy = f;
    }

    public PresenceSource() {
        this.mPresenceSourceType = null;
        this.mPulsarRssi = null;
        this.mLatitude = null;
        this.mLongitude = null;
        this.mAccuracy = null;
    }

    public final PresenceSourceType m3711a() {
        return this.mPresenceSourceType;
    }

    public final Integer m3712b() {
        return this.mPulsarRssi;
    }

    public final Double m3713c() {
        return this.mLatitude;
    }

    public final Double m3714d() {
        return this.mLongitude;
    }

    public final Float m3715e() {
        return this.mAccuracy;
    }
}
