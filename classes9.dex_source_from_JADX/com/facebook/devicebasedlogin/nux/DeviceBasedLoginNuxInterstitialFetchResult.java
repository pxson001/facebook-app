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
@JsonDeserialize(using = DeviceBasedLoginNuxInterstitialFetchResultDeserializer.class)
@Immutable
/* compiled from: Thread Priority */
public class DeviceBasedLoginNuxInterstitialFetchResult implements Parcelable {
    public static final Creator<DeviceBasedLoginNuxInterstitialFetchResult> CREATOR = new C29151();
    @JsonProperty("triggerGeneration")
    public final int triggerGeneration;

    /* compiled from: Thread Priority */
    final class C29151 implements Creator<DeviceBasedLoginNuxInterstitialFetchResult> {
        C29151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeviceBasedLoginNuxInterstitialFetchResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeviceBasedLoginNuxInterstitialFetchResult[0];
        }
    }

    public DeviceBasedLoginNuxInterstitialFetchResult() {
        this.triggerGeneration = 0;
    }

    public DeviceBasedLoginNuxInterstitialFetchResult(Parcel parcel) {
        this.triggerGeneration = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.triggerGeneration);
    }
}
