package com.facebook.messaging.model.payment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_notification */
public class PaymentRequestData implements Parcelable {
    public static final Creator<PaymentRequestData> CREATOR = new C01021();
    public final String f2134a;
    public final long f2135b;
    public final long f2136c;
    public final int f2137d;
    public final String f2138e;

    /* compiled from: upload_notification */
    final class C01021 implements Creator<PaymentRequestData> {
        C01021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentRequestData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentRequestData[i];
        }
    }

    public PaymentRequestData(String str, long j, long j2, int i, String str2) {
        this.f2134a = str;
        this.f2135b = j;
        this.f2136c = j2;
        this.f2137d = i;
        this.f2138e = str2;
    }

    public PaymentRequestData(Parcel parcel) {
        this.f2134a = parcel.readString();
        this.f2135b = parcel.readLong();
        this.f2136c = parcel.readLong();
        this.f2137d = parcel.readInt();
        this.f2138e = parcel.readString();
    }

    public final long m3460c() {
        return this.f2136c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2134a);
        parcel.writeLong(this.f2135b);
        parcel.writeLong(this.f2136c);
        parcel.writeInt(this.f2137d);
        parcel.writeString(this.f2138e);
    }
}
