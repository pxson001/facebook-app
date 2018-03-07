package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/* compiled from: fetchThread (CSH).  */
public class FetchTransactionPaymentCardParams implements Parcelable {
    public static final Creator<FetchTransactionPaymentCardParams> CREATOR = new C17061();
    public final String f14750a;

    /* compiled from: fetchThread (CSH).  */
    final class C17061 implements Creator<FetchTransactionPaymentCardParams> {
        C17061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTransactionPaymentCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTransactionPaymentCardParams[i];
        }
    }

    public FetchTransactionPaymentCardParams(String str) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f14750a = str;
    }

    public FetchTransactionPaymentCardParams(Parcel parcel) {
        Preconditions.checkNotNull(parcel);
        this.f14750a = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("transactionId", this.f14750a).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14750a);
    }
}
