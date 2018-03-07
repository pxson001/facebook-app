package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = ValidatePaymentCardBinResultDeserializer.class)
/* compiled from: fetch_users_time */
public class ValidatePaymentCardBinResult implements Parcelable {
    public static final Creator<ValidatePaymentCardBinResult> CREATOR = new C16801();
    @JsonProperty("id")
    private final String mCardBinId;

    /* compiled from: fetch_users_time */
    final class C16801 implements Creator<ValidatePaymentCardBinResult> {
        C16801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ValidatePaymentCardBinResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new ValidatePaymentCardBinResult[i];
        }
    }

    public ValidatePaymentCardBinResult(Parcel parcel) {
        this.mCardBinId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCardBinId);
    }

    private ValidatePaymentCardBinResult() {
        this.mCardBinId = null;
    }
}
