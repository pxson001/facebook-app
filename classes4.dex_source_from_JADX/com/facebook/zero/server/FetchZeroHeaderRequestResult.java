package com.facebook.zero.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FetchZeroHeaderRequestResultDeserializer.class)
@Immutable
/* compiled from: single-context-buckets-table */
public class FetchZeroHeaderRequestResult implements Parcelable {
    public static final Creator<FetchZeroHeaderRequestResult> CREATOR = new C01121();
    @JsonProperty("id")
    private final String mCampaignId;
    @JsonProperty("eid")
    private final String mEId;
    @JsonProperty("emid")
    private final String mEncryptedMachineId;
    @JsonProperty("header_app_id")
    private final String mHeaderAppId;
    @JsonProperty("nonce")
    private final String mNonce;
    @JsonProperty("status")
    private final String mStatus;
    @JsonProperty("ttl")
    private final int mTtl;

    /* compiled from: single-context-buckets-table */
    final class C01121 implements Creator<FetchZeroHeaderRequestResult> {
        C01121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchZeroHeaderRequestResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchZeroHeaderRequestResult[0];
        }
    }

    public FetchZeroHeaderRequestResult() {
        this.mCampaignId = null;
        this.mStatus = null;
        this.mEId = null;
        this.mNonce = null;
        this.mHeaderAppId = null;
        this.mEncryptedMachineId = null;
        this.mTtl = 0;
    }

    public FetchZeroHeaderRequestResult(Parcel parcel) {
        this.mCampaignId = parcel.readString();
        this.mStatus = parcel.readString();
        this.mEId = parcel.readString();
        this.mNonce = parcel.readString();
        this.mHeaderAppId = parcel.readString();
        this.mEncryptedMachineId = parcel.readString();
        this.mTtl = parcel.readInt();
    }

    private String m2301g() {
        return this.mCampaignId;
    }

    public final String m2302a() {
        return this.mStatus;
    }

    public final String m2303b() {
        return this.mEId;
    }

    public final String m2304c() {
        return this.mNonce;
    }

    public final String m2305d() {
        return this.mHeaderAppId;
    }

    public final String m2306e() {
        return this.mEncryptedMachineId;
    }

    public final int m2307f() {
        return this.mTtl;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCampaignId);
        parcel.writeString(this.mStatus);
        parcel.writeString(this.mEId);
        parcel.writeString(this.mNonce);
        parcel.writeString(this.mHeaderAppId);
        parcel.writeString(this.mEncryptedMachineId);
        parcel.writeInt(this.mTtl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FetchZeroHeaderRequestResult)) {
            return false;
        }
        FetchZeroHeaderRequestResult fetchZeroHeaderRequestResult = (FetchZeroHeaderRequestResult) obj;
        if (Objects.equal(this.mCampaignId, fetchZeroHeaderRequestResult.m2301g()) && Objects.equal(this.mStatus, fetchZeroHeaderRequestResult.m2302a()) && Objects.equal(this.mEId, fetchZeroHeaderRequestResult.m2303b()) && Objects.equal(this.mNonce, fetchZeroHeaderRequestResult.m2304c()) && Objects.equal(this.mHeaderAppId, fetchZeroHeaderRequestResult.m2305d()) && Objects.equal(this.mEncryptedMachineId, fetchZeroHeaderRequestResult.m2306e()) && this.mTtl == fetchZeroHeaderRequestResult.m2307f()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mCampaignId, this.mStatus, this.mEId, this.mNonce, this.mHeaderAppId, this.mEncryptedMachineId, Integer.valueOf(this.mTtl)});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("campaignId", this.mCampaignId).add("status", this.mStatus).add("eid", this.mEId).add("nonce", this.mNonce).add("appHeaderId", this.mHeaderAppId).add("encryptedMachineId", this.mEncryptedMachineId).add("ttl", this.mTtl).toString();
    }
}
