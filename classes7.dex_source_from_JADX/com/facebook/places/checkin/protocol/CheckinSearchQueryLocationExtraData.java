package com.facebook.places.checkin.protocol;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = CheckinSearchQueryLocationExtraDataDeserializer.class)
@JsonSerialize(using = CheckinSearchQueryLocationExtraDataSerializer.class)
/* compiled from: inner_error_class */
public class CheckinSearchQueryLocationExtraData {
    @JsonProperty("ble")
    final String mBle;
    @JsonProperty("wifi")
    final CheckinSearchQueryLocationExtraDataWifi mWifi;

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = C0967x9ef0614d.class)
    @JsonSerialize(using = C0970xd96e188c.class)
    /* compiled from: inner_error_class */
    public class CheckinSearchQueryLocationExtraDataWifi {
        @JsonProperty("ambient_wifis")
        final ImmutableList<CheckinSearchQueryLocationExtraDataWifiObject> mAmbientWifis;
        @JsonProperty("connected_wifi")
        final CheckinSearchQueryLocationExtraDataWifiObject mConnectedWifi;

        public CheckinSearchQueryLocationExtraDataWifi() {
            this.mConnectedWifi = null;
            this.mAmbientWifis = RegularImmutableList.a;
        }

        public CheckinSearchQueryLocationExtraDataWifi(CheckinSearchQueryLocationExtraDataWifiObject checkinSearchQueryLocationExtraDataWifiObject, @Nullable List<CheckinSearchQueryLocationExtraDataWifiObject> list) {
            ImmutableList immutableList;
            this.mConnectedWifi = checkinSearchQueryLocationExtraDataWifiObject;
            if (list == null) {
                immutableList = RegularImmutableList.a;
            } else {
                immutableList = ImmutableList.copyOf(list);
            }
            this.mAmbientWifis = immutableList;
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = C0968xec4daeac.class)
    @JsonSerialize(using = C0969x5a2d31ab.class)
    /* compiled from: inner_error_class */
    public class CheckinSearchQueryLocationExtraDataWifiObject {
        @JsonProperty("stale_time")
        final Long mAge;
        @JsonProperty("BSSID")
        final String mBssid;
        @JsonProperty("frequency")
        final int mFrequency;
        @JsonProperty("name")
        final String mName;
        @JsonProperty("strength")
        final int mStrength;

        public CheckinSearchQueryLocationExtraDataWifiObject() {
            this.mBssid = null;
            this.mName = null;
            this.mStrength = 0;
            this.mFrequency = 0;
            this.mAge = null;
        }

        public CheckinSearchQueryLocationExtraDataWifiObject(String str, String str2, int i, int i2, Long l) {
            this.mBssid = str;
            this.mName = str2;
            this.mStrength = i;
            this.mFrequency = i2;
            this.mAge = l;
        }
    }

    public CheckinSearchQueryLocationExtraData() {
        this.mWifi = null;
        this.mBle = null;
    }

    public CheckinSearchQueryLocationExtraData(CheckinSearchQueryLocationExtraDataWifi checkinSearchQueryLocationExtraDataWifi, String str) {
        this.mWifi = checkinSearchQueryLocationExtraDataWifi;
        this.mBle = str;
    }
}
