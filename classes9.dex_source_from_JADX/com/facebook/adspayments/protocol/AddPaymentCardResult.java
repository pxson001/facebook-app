package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.util.TriState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AddPaymentCardResultDeserializer.class)
/* compiled from: first_contacts */
public class AddPaymentCardResult implements Parcelable {
    public static final Creator<AddPaymentCardResult> CREATOR = new C28601();
    @JsonProperty("id")
    private final String mCredentialId;
    @JsonProperty("cached_csc_token")
    private final String mCvvToken;
    @JsonProperty("is_prepay_eligible")
    private final Boolean mIsPrepayEligible;

    /* compiled from: first_contacts */
    final class C28601 implements Creator<AddPaymentCardResult> {
        C28601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPaymentCardResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPaymentCardResult[i];
        }
    }

    private AddPaymentCardResult() {
        this(null, null, null);
    }

    private AddPaymentCardResult(String str, Boolean bool, String str2) {
        this.mCredentialId = str;
        this.mIsPrepayEligible = bool;
        this.mCvvToken = str2;
    }

    public AddPaymentCardResult(Parcel parcel) {
        this(parcel.readString(), (Boolean) parcel.readSerializable(), parcel.readString());
    }

    public final String m25704a() {
        return this.mCredentialId;
    }

    public final TriState m25705b() {
        return TriState.valueOf(this.mIsPrepayEligible);
    }

    @Nullable
    public final String m25706c() {
        return this.mCvvToken;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCredentialId);
        parcel.writeSerializable(this.mIsPrepayEligible);
        parcel.writeString(this.mCvvToken);
    }
}
