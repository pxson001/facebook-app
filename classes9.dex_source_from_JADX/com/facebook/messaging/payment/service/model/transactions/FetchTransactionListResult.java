package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThread (DSH).  */
public class FetchTransactionListResult implements Parcelable {
    public static final Creator<FetchTransactionListResult> CREATOR = new C17051();
    public final ImmutableList<PaymentTransaction> f14748a;
    public final boolean f14749b;

    /* compiled from: fetchThread (DSH).  */
    final class C17051 implements Creator<FetchTransactionListResult> {
        C17051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTransactionListResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTransactionListResult[i];
        }
    }

    public FetchTransactionListResult(ImmutableList<PaymentTransaction> immutableList, boolean z) {
        this.f14748a = immutableList;
        this.f14749b = z;
    }

    public FetchTransactionListResult(Parcel parcel) {
        this.f14748a = ImmutableList.copyOf(parcel.readArrayList(PaymentTransaction.class.getClassLoader()));
        this.f14749b = ParcelUtil.a(parcel);
    }

    public final ImmutableList<PaymentTransaction> m15203a() {
        return this.f14748a;
    }

    public final boolean m15204b() {
        return this.f14749b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f14748a);
        ParcelUtil.a(parcel, this.f14749b);
    }
}
