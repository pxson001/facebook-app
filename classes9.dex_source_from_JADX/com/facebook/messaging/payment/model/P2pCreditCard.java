package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = P2pCreditCardDeserializer.class)
@Immutable
/* compiled from: ignoreMessageRequests */
public class P2pCreditCard implements Parcelable, Postprocessable<P2pCreditCard> {
    public static final Creator<P2pCreditCard> CREATOR = new C14811();
    @JsonProperty("address")
    private final Address mAddress;
    @JsonProperty("association")
    private final String mAssociation;
    @JsonProperty("credential_id")
    private final long mCredentialId;
    @JsonProperty("expire_month")
    private final int mExpirationMonth;
    @JsonProperty("expire_year")
    private final int mExpirationYear;
    @JsonProperty("number")
    private final String mLastFourDigits;

    /* compiled from: ignoreMessageRequests */
    final class C14811 implements Creator<P2pCreditCard> {
        C14811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new P2pCreditCard(parcel);
        }

        public final Object[] newArray(int i) {
            return new P2pCreditCard[i];
        }
    }

    public final Object m13479a() {
        boolean z;
        boolean z2 = true;
        if (Strings.isNullOrEmpty(this.mLastFourDigits)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (Strings.isNullOrEmpty(this.mAssociation)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return this;
    }

    public P2pCreditCard(Parcel parcel) {
        this.mCredentialId = parcel.readLong();
        this.mLastFourDigits = parcel.readString();
        this.mExpirationMonth = parcel.readInt();
        this.mExpirationYear = parcel.readInt();
        this.mAddress = (Address) parcel.readParcelable(Address.class.getClassLoader());
        this.mAssociation = parcel.readString();
    }

    private P2pCreditCard() {
        this.mCredentialId = -1;
        this.mLastFourDigits = null;
        this.mExpirationMonth = -1;
        this.mExpirationYear = -1;
        this.mAddress = null;
        this.mAssociation = null;
    }

    public final long m13480b() {
        return this.mCredentialId;
    }

    public final String m13481c() {
        return this.mLastFourDigits;
    }

    public final int m13482d() {
        return this.mExpirationMonth;
    }

    public final int m13483e() {
        return this.mExpirationYear;
    }

    public final Address m13484f() {
        return this.mAddress;
    }

    public final String m13485g() {
        return FbPaymentCardType.forValue(this.mAssociation).getHumanReadableName();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("credential_id", this.mCredentialId).add("number", this.mLastFourDigits).add("expire_month", this.mExpirationMonth).add("expire_year", this.mExpirationYear).add("address", this.mAddress.toString()).add("association", this.mAssociation).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mCredentialId);
        parcel.writeString(this.mLastFourDigits);
        parcel.writeInt(this.mExpirationMonth);
        parcel.writeInt(this.mExpirationYear);
        parcel.writeParcelable(this.mAddress, i);
        parcel.writeString(this.mAssociation);
    }
}
