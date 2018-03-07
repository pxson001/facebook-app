package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThreadList (GQL) */
public class DeclinePaymentParams implements Parcelable {
    public static final Creator<DeclinePaymentParams> CREATOR = new C17001();
    public static String f14734a = "declinePaymentParams";
    public final String f14735b;
    public final String f14736c;

    /* compiled from: fetchThreadList (GQL) */
    final class C17001 implements Creator<DeclinePaymentParams> {
        C17001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeclinePaymentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeclinePaymentParams[i];
        }
    }

    public DeclinePaymentParams(String str, String str2) {
        this.f14735b = str;
        this.f14736c = str2;
    }

    public DeclinePaymentParams(Parcel parcel) {
        this.f14735b = parcel.readString();
        this.f14736c = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("recipientId", this.f14735b).add("mPaymentTransactionId", this.f14736c).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14735b);
        parcel.writeString(this.f14736c);
    }
}
