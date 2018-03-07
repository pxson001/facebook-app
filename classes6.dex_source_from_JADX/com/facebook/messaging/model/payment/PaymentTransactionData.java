package com.facebook.messaging.model.payment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_method */
public class PaymentTransactionData implements Parcelable {
    public static final Creator<PaymentTransactionData> CREATOR = new C01031();
    public final String f2139a;
    public final long f2140b;
    public final long f2141c;
    public final int f2142d;
    public final String f2143e;

    /* compiled from: upload_method */
    final class C01031 implements Creator<PaymentTransactionData> {
        C01031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentTransactionData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentTransactionData[i];
        }
    }

    public PaymentTransactionData(String str, long j, long j2, int i, String str2) {
        this.f2139a = str;
        this.f2140b = j;
        this.f2141c = j2;
        this.f2142d = i;
        this.f2143e = str2;
    }

    public PaymentTransactionData(Parcel parcel) {
        this.f2139a = parcel.readString();
        this.f2140b = parcel.readLong();
        this.f2141c = parcel.readLong();
        this.f2142d = parcel.readInt();
        this.f2143e = parcel.readString();
    }

    public final long m3461c() {
        return this.f2141c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2139a);
        parcel.writeLong(this.f2140b);
        parcel.writeLong(this.f2141c);
        parcel.writeInt(this.f2142d);
        parcel.writeString(this.f2143e);
    }
}
