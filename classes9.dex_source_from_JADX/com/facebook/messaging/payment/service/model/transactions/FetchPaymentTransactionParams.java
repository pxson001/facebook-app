package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchThreadList */
public class FetchPaymentTransactionParams implements Parcelable {
    public static final Creator<FetchPaymentTransactionParams> CREATOR = new C17031();
    public final String f14742a;
    public final DataFreshnessParam f14743b;

    /* compiled from: fetchThreadList */
    final class C17031 implements Creator<FetchPaymentTransactionParams> {
        C17031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaymentTransactionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaymentTransactionParams[i];
        }
    }

    public FetchPaymentTransactionParams(String str, DataFreshnessParam dataFreshnessParam) {
        Preconditions.checkNotNull(str);
        this.f14742a = str;
        this.f14743b = dataFreshnessParam;
    }

    public FetchPaymentTransactionParams(Parcel parcel) {
        this.f14742a = parcel.readString();
        this.f14743b = (DataFreshnessParam) parcel.readSerializable();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("transactionId", this.f14742a).add("dataFreshnessParam", this.f14743b.toString()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14742a);
        parcel.writeSerializable(this.f14743b);
    }
}
