package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = GetAccountDetailsResultDeserializer.class)
/* compiled from: USE_PASSCODE */
public class GetAccountDetailsResult implements Parcelable {
    public static final Creator<GetAccountDetailsResult> CREATOR = new C28631();
    @JsonProperty("business_country_code")
    private final String mBusinessCountry;
    @JsonProperty("currency")
    private final String mCurrency;
    @JsonProperty("stored_balance_status")
    private final String mStoredBalanceStatus;

    /* compiled from: USE_PASSCODE */
    final class C28631 implements Creator<GetAccountDetailsResult> {
        C28631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetAccountDetailsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetAccountDetailsResult[i];
        }
    }

    private GetAccountDetailsResult() {
        this(null, null, null);
    }

    private GetAccountDetailsResult(String str, String str2, String str3) {
        this.mStoredBalanceStatus = str;
        this.mBusinessCountry = str2;
        this.mCurrency = str3;
    }

    public GetAccountDetailsResult(Parcel parcel) {
        this.mStoredBalanceStatus = parcel.readString();
        this.mBusinessCountry = parcel.readString();
        this.mCurrency = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStoredBalanceStatus);
    }
}
