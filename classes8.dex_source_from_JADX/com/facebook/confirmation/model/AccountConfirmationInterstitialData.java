package com.facebook.confirmation.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.model.ContactpointType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AccountConfirmationInterstitialDataDeserializer.class)
@Immutable
/* compiled from: instantshopping_document_fetch_query?product_id= */
public class AccountConfirmationInterstitialData implements Parcelable {
    public static final Creator<AccountConfirmationInterstitialData> CREATOR = new C11631();
    @JsonProperty("contactpoint_type")
    public final ContactpointType contactpointType;
    @JsonProperty("interstitial_type")
    public final AccountConfirmationInterstitialType interstitialType;
    @JsonProperty("iso_country_code")
    public final String isoCountryCode;
    @JsonProperty("min_impression_delay_ms")
    public final long minImpressionDelayMs;
    @JsonProperty("normalized_contactpoint")
    public final String normalizedContactpoint;

    /* compiled from: instantshopping_document_fetch_query?product_id= */
    final class C11631 implements Creator<AccountConfirmationInterstitialData> {
        C11631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountConfirmationInterstitialData(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountConfirmationInterstitialData[i];
        }
    }

    private AccountConfirmationInterstitialData() {
        this.normalizedContactpoint = null;
        this.contactpointType = ContactpointType.UNKNOWN;
        this.isoCountryCode = null;
        this.interstitialType = AccountConfirmationInterstitialType.UNKNOWN;
        this.minImpressionDelayMs = 0;
    }

    public AccountConfirmationInterstitialData(Parcel parcel) {
        this.normalizedContactpoint = parcel.readString();
        this.contactpointType = ContactpointType.valueOf(parcel.readString());
        this.isoCountryCode = parcel.readString();
        this.interstitialType = AccountConfirmationInterstitialType.valueOf(parcel.readString());
        this.minImpressionDelayMs = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.normalizedContactpoint);
        parcel.writeString(this.contactpointType.name());
        parcel.writeString(this.isoCountryCode);
        parcel.writeString(this.interstitialType.name());
        parcel.writeLong(this.minImpressionDelayMs);
    }

    public final Contactpoint m12727a() {
        if (this.contactpointType == ContactpointType.PHONE) {
            return Contactpoint.m17344a(this.normalizedContactpoint, this.isoCountryCode);
        }
        if (this.contactpointType == ContactpointType.EMAIL) {
            return Contactpoint.m17343a(this.normalizedContactpoint);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountConfirmationInterstitialData)) {
            return false;
        }
        AccountConfirmationInterstitialData accountConfirmationInterstitialData = (AccountConfirmationInterstitialData) obj;
        if (Objects.equal(this.contactpointType, accountConfirmationInterstitialData.contactpointType) && Objects.equal(this.isoCountryCode, accountConfirmationInterstitialData.isoCountryCode) && Objects.equal(this.normalizedContactpoint, accountConfirmationInterstitialData.normalizedContactpoint) && Objects.equal(this.interstitialType, accountConfirmationInterstitialData.interstitialType) && Objects.equal(Long.valueOf(this.minImpressionDelayMs), Long.valueOf(accountConfirmationInterstitialData.minImpressionDelayMs))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.contactpointType, this.normalizedContactpoint, this.isoCountryCode, this.interstitialType, Long.valueOf(this.minImpressionDelayMs)});
    }
}
