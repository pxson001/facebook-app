package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.model.PaymentTransactionQueryType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThreadList (DSH). */
public class FetchMoreTransactionsParams implements Parcelable {
    public static final Creator<FetchMoreTransactionsParams> CREATOR = new C17011();
    private final int f14737a = 1;
    public final PaymentTransactionQueryType f14738b;
    public final long f14739c;

    /* compiled from: fetchThreadList (DSH). */
    final class C17011 implements Creator<FetchMoreTransactionsParams> {
        C17011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreTransactionsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreTransactionsParams[i];
        }
    }

    public FetchMoreTransactionsParams(PaymentTransactionQueryType paymentTransactionQueryType, long j) {
        boolean z = true;
        Preconditions.checkNotNull(paymentTransactionQueryType);
        if (j <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f14738b = paymentTransactionQueryType;
        this.f14739c = j;
    }

    public FetchMoreTransactionsParams(Parcel parcel) {
        this.f14738b = (PaymentTransactionQueryType) parcel.readSerializable();
        this.f14739c = parcel.readLong();
    }

    public final PaymentTransactionQueryType m15199a() {
        return this.f14738b;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("transactionsQueryType", this.f14738b).add("endTimeSeconds", this.f14739c).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f14738b);
        parcel.writeLong(this.f14739c);
    }
}
