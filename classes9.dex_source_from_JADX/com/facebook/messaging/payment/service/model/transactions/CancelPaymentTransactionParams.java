package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThreadList deprecated (GQL) */
public class CancelPaymentTransactionParams implements Parcelable {
    public static final Creator<CancelPaymentTransactionParams> CREATOR = new C16991();
    public static String f14732a = CancelPaymentTransactionParams.class.getSimpleName();
    public final String f14733b;

    /* compiled from: fetchThreadList deprecated (GQL) */
    final class C16991 implements Creator<CancelPaymentTransactionParams> {
        C16991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CancelPaymentTransactionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CancelPaymentTransactionParams[i];
        }
    }

    public CancelPaymentTransactionParams(String str) {
        this.f14733b = str;
    }

    public CancelPaymentTransactionParams(Parcel parcel) {
        this.f14733b = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("paymentTransactionId", this.f14733b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14733b);
    }
}
