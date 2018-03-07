package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ZeroOptoutResultDeserializer.class)
@Immutable
/* compiled from: com.facebook.GET_PHONE_ID */
public class ZeroOptoutResult implements Parcelable {
    public static final Creator<ZeroOptoutResult> CREATOR = new C05461();
    @JsonProperty("status")
    private final String mStatus;

    /* compiled from: com.facebook.GET_PHONE_ID */
    final class C05461 implements Creator<ZeroOptoutResult> {
        C05461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ZeroOptoutResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ZeroOptoutResult[i];
        }
    }

    public ZeroOptoutResult() {
        this.mStatus = null;
    }

    public ZeroOptoutResult(Parcel parcel) {
        this.mStatus = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStatus);
    }

    public final String m10691a() {
        return this.mStatus;
    }
}
