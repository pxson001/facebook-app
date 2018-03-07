package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ZeroOptinResultDeserializer.class)
@Immutable
/* compiled from: com.facebook.adsmanager */
public class ZeroOptinResult implements Parcelable {
    public static final Creator<ZeroOptinResult> CREATOR = new C05441();
    @JsonProperty("status")
    private final String mStatus;

    /* compiled from: com.facebook.adsmanager */
    final class C05441 implements Creator<ZeroOptinResult> {
        C05441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroOptinResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroOptinResult[i];
        }
    }

    public ZeroOptinResult() {
        this.mStatus = null;
    }

    public ZeroOptinResult(Parcel parcel) {
        this.mStatus = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStatus);
    }

    public final String m10687a() {
        return this.mStatus;
    }
}
