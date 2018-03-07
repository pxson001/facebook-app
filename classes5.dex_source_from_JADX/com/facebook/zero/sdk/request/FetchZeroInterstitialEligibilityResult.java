package com.facebook.zero.sdk.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchZeroInterstitialEligibilityResultDeserializer.class)
@Immutable
/* compiled from: com.facebook.bugreporter.scheduler.AlarmsBroadcastReceiver.RETRY_UPLOAD */
public class FetchZeroInterstitialEligibilityResult implements Parcelable {
    public static final Creator<FetchZeroInterstitialEligibilityResult> CREATOR = new C05391();
    @JsonProperty("id")
    private final String mCampaignId;
    @JsonProperty("delay_interval")
    private final int mDelayInterval;
    @JsonProperty("ttl")
    private final int mTtl;
    @JsonProperty("type")
    private final String mType;

    /* compiled from: com.facebook.bugreporter.scheduler.AlarmsBroadcastReceiver.RETRY_UPLOAD */
    final class C05391 implements Creator<FetchZeroInterstitialEligibilityResult> {
        C05391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroInterstitialEligibilityResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroInterstitialEligibilityResult[i];
        }
    }

    public FetchZeroInterstitialEligibilityResult() {
        this.mCampaignId = null;
        this.mType = null;
        this.mTtl = 0;
        this.mDelayInterval = 0;
    }

    public FetchZeroInterstitialEligibilityResult(Parcel parcel) {
        this.mCampaignId = parcel.readString();
        this.mType = parcel.readString();
        this.mTtl = parcel.readInt();
        this.mDelayInterval = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCampaignId);
        parcel.writeString(this.mType);
        parcel.writeInt(this.mTtl);
        parcel.writeInt(this.mDelayInterval);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroInterstitialEligibilityResult)) {
            return false;
        }
        FetchZeroInterstitialEligibilityResult fetchZeroInterstitialEligibilityResult = (FetchZeroInterstitialEligibilityResult) obj;
        if (Objects.equal(this.mCampaignId, fetchZeroInterstitialEligibilityResult.m10657d()) && Objects.equal(this.mType, fetchZeroInterstitialEligibilityResult.m10658a()) && Objects.equal(Integer.valueOf(this.mTtl), Integer.valueOf(fetchZeroInterstitialEligibilityResult.m10659b())) && Objects.equal(Integer.valueOf(this.mDelayInterval), Integer.valueOf(fetchZeroInterstitialEligibilityResult.m10660c()))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mCampaignId, this.mType, Integer.valueOf(this.mTtl)});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("campaignId", this.mCampaignId).add("type", this.mType).add("ttl", this.mTtl).add("delayInterval", this.mDelayInterval).toString();
    }

    private String m10657d() {
        return this.mCampaignId;
    }

    public final String m10658a() {
        return this.mType;
    }

    public final int m10659b() {
        return this.mTtl;
    }

    public final int m10660c() {
        return this.mDelayInterval;
    }
}
