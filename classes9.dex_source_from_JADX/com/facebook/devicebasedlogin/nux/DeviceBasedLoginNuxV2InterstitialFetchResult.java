package com.facebook.devicebasedlogin.nux;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = DeviceBasedLoginNuxV2InterstitialFetchResultDeserializer.class)
@Immutable
/* compiled from: This must be called after nextView is bound */
public class DeviceBasedLoginNuxV2InterstitialFetchResult implements Parcelable {
    public static final Creator<DeviceBasedLoginNuxInterstitialFetchResult> CREATOR = new C29161();
    @JsonProperty("targeted_nux")
    public final String targetedNux = null;

    /* compiled from: This must be called after nextView is bound */
    final class C29161 implements Creator<DeviceBasedLoginNuxInterstitialFetchResult> {
        C29161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeviceBasedLoginNuxInterstitialFetchResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeviceBasedLoginNuxInterstitialFetchResult[0];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.targetedNux);
    }
}
