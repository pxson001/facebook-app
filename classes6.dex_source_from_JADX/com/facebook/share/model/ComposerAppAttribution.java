package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerAppAttributionDeserializer.class)
@JsonSerialize(using = ComposerAppAttributionSerializer.class)
/* compiled from: server_tracking_string */
public final class ComposerAppAttribution implements Parcelable {
    public static final Creator<ComposerAppAttribution> CREATOR = new C02951();
    @JsonProperty("app_id")
    final String appId;
    @JsonProperty("app_key_hash")
    final String appKeyHash;
    @JsonProperty("app_metadata")
    final String appMetadata;
    @JsonProperty("app_name")
    final String appName;

    /* compiled from: server_tracking_string */
    final class C02951 implements Creator<ComposerAppAttribution> {
        C02951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerAppAttribution(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerAppAttribution[i];
        }
    }

    @JsonIgnore
    private ComposerAppAttribution() {
        this(null, null, null, null);
    }

    @JsonIgnore
    public ComposerAppAttribution(Parcel parcel) {
        this.appId = parcel.readString();
        this.appName = parcel.readString();
        this.appKeyHash = parcel.readString();
        this.appMetadata = parcel.readString();
    }

    @JsonIgnore
    public ComposerAppAttribution(String str, String str2, String str3, String str4) {
        this.appId = str;
        this.appName = str2;
        this.appKeyHash = str3;
        this.appMetadata = str4;
    }

    @JsonIgnore
    public final String m7689a() {
        return this.appId;
    }

    @JsonIgnore
    public final String m7690b() {
        return this.appName;
    }

    @JsonIgnore
    public final String m7691c() {
        return this.appKeyHash;
    }

    @JsonIgnore
    public final String m7692d() {
        return this.appMetadata;
    }

    @JsonIgnore
    public final int describeContents() {
        return 0;
    }

    @JsonIgnore
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.appName);
        parcel.writeString(this.appKeyHash);
        parcel.writeString(this.appMetadata);
    }

    @JsonIgnore
    public final String toString() {
        return "ComposerAppAttribution{appId='" + this.appId + '\'' + ", appName='" + this.appName + '\'' + ", appKeyHash='" + this.appKeyHash + '\'' + ", appMetadata='" + this.appMetadata + '\'' + '}';
    }
}
