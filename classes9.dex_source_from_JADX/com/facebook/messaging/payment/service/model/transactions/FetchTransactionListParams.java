package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThread (GQL).  */
public class FetchTransactionListParams implements Parcelable {
    public static final Creator<FetchTransactionListParams> CREATOR = new C17041();
    public static final PaymentTransactionQueryType f14744a = PaymentTransactionQueryType.ALL;
    private final int f14745b = 1;
    public final PaymentTransactionQueryType f14746c;
    public final int f14747d;

    /* compiled from: fetchThread (GQL).  */
    final class C17041 implements Creator<FetchTransactionListParams> {
        C17041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTransactionListParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTransactionListParams[i];
        }
    }

    public FetchTransactionListParams(PaymentTransactionQueryType paymentTransactionQueryType, int i) {
        boolean z = true;
        Preconditions.checkNotNull(paymentTransactionQueryType);
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f14746c = paymentTransactionQueryType;
        this.f14747d = i;
    }

    public FetchTransactionListParams(Parcel parcel) {
        this.f14746c = (PaymentTransactionQueryType) parcel.readSerializable();
        this.f14747d = parcel.readInt();
    }

    public final PaymentTransactionQueryType m15202a() {
        return this.f14746c;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("transactionsQueryType", this.f14746c).add("maxTransactionsToFetch", this.f14747d).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14746c);
        parcel.writeInt(this.f14747d);
    }
}
