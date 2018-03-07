package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThreadList (CSH). */
public class FetchMoreTransactionsResult implements Parcelable {
    public static final Creator<FetchMoreTransactionsResult> CREATOR = new C17021();
    public final ImmutableList<PaymentTransaction> f14740a;
    public final boolean f14741b;

    /* compiled from: fetchThreadList (CSH). */
    final class C17021 implements Creator<FetchMoreTransactionsResult> {
        C17021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreTransactionsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreTransactionsResult[i];
        }
    }

    public FetchMoreTransactionsResult(ImmutableList<PaymentTransaction> immutableList, boolean z) {
        this.f14740a = immutableList;
        this.f14741b = z;
    }

    public FetchMoreTransactionsResult(Parcel parcel) {
        this.f14740a = ImmutableList.copyOf(parcel.readArrayList(PaymentTransaction.class.getClassLoader()));
        this.f14741b = ParcelUtil.a(parcel);
    }

    public final ImmutableList<PaymentTransaction> m15200a() {
        return this.f14740a;
    }

    public final boolean m15201b() {
        return this.f14741b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f14740a);
        ParcelUtil.a(parcel, this.f14741b);
    }
}
