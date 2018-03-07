package com.facebook.payments.paymentmethods.cardform.protocol.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: survey/%s */
public class EditCreditCardParams extends CreditCardProtocolParams {
    public static final Creator<EditCreditCardParams> CREATOR = new C02141();
    public static final String f1926a = EditCreditCardParams.class.getSimpleName();
    public final String f1927b;

    /* compiled from: survey/%s */
    final class C02141 implements Creator<EditCreditCardParams> {
        C02141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditCreditCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditCreditCardParams[i];
        }
    }

    /* compiled from: survey/%s */
    public class Builder extends com.facebook.payments.paymentmethods.cardform.protocol.model.CreditCardProtocolParams.Builder<Builder> {
        public String f1925a;
    }

    public EditCreditCardParams(Builder builder) {
        super((com.facebook.payments.paymentmethods.cardform.protocol.model.CreditCardProtocolParams.Builder) builder);
        this.f1927b = (String) Preconditions.checkNotNull(builder.f1925a);
    }

    public EditCreditCardParams(Parcel parcel) {
        super(parcel);
        this.f1927b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f1927b);
    }
}
