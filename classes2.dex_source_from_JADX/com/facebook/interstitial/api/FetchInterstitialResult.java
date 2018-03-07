package com.facebook.interstitial.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonSerialize(using = FetchInterstitialResultSerializer.class)
/* compiled from: publish_review */
public class FetchInterstitialResult implements Parcelable {
    public static final Creator<FetchInterstitialResult> CREATOR = new C03781();
    @JsonProperty("nux_data")
    @Nullable
    public final Parcelable data;
    @JsonProperty("fetchTimeMs")
    public final long fetchTimeMs;
    @JsonProperty("nux_id")
    @Nullable
    public final String interstitialId;
    @JsonProperty("rank")
    public final int rank;

    /* compiled from: publish_review */
    final class C03781 implements Creator<FetchInterstitialResult> {
        C03781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchInterstitialResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchInterstitialResult[i];
        }
    }

    public FetchInterstitialResult(int i, @Nullable String str, @Nullable Parcelable parcelable, long j) {
        this.rank = i;
        this.interstitialId = str;
        this.data = parcelable;
        this.fetchTimeMs = j;
    }

    public FetchInterstitialResult() {
        this(-1, null, null, 0);
    }

    public FetchInterstitialResult(Parcel parcel) {
        this.rank = parcel.readInt();
        this.interstitialId = parcel.readString();
        this.data = parcel.readParcelable(getClass().getGenericSuperclass().getClass().getClassLoader());
        this.fetchTimeMs = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.rank);
        parcel.writeString(this.interstitialId);
        parcel.writeParcelable(this.data, i);
        parcel.writeLong(this.fetchTimeMs);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("interstitialId", this.interstitialId).add("rank", this.rank).add("data", this.data).add("fetchTimeMs", this.fetchTimeMs).toString();
    }
}
