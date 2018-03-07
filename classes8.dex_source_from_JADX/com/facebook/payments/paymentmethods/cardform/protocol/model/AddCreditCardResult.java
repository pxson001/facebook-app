package com.facebook.payments.paymentmethods.cardform.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AddCreditCardResultDeserializer.class)
@Immutable
/* compiled from: swipe-down */
public class AddCreditCardResult implements Parcelable {
    public static final Creator<AddCreditCardResult> CREATOR = new C02131();
    @JsonProperty("id")
    private final String mCredentialId;

    /* compiled from: swipe-down */
    final class C02131 implements Creator<AddCreditCardResult> {
        C02131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddCreditCardResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddCreditCardResult[i];
        }
    }

    private AddCreditCardResult() {
        this.mCredentialId = null;
    }

    public AddCreditCardResult(Parcel parcel) {
        this.mCredentialId = parcel.readString();
    }

    public final String m2119a() {
        return this.mCredentialId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCredentialId);
    }
}
