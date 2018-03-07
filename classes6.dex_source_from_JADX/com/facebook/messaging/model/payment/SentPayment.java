package com.facebook.messaging.model.payment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_message */
public class SentPayment implements Parcelable {
    public static final Creator<SentPayment> CREATOR = new C01041();
    public final String f2144a;
    public final String f2145b;
    public final long f2146c;
    public final String f2147d;
    @Nullable
    public final String f2148e;
    @Nullable
    public final String f2149f;
    public final boolean f2150g;
    @Nullable
    public final String f2151h;
    public final PaymentFlowType f2152i;
    @Nullable
    public final String f2153j;
    @Nullable
    public final String f2154k;

    /* compiled from: upload_message */
    final class C01041 implements Creator<SentPayment> {
        C01041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SentPayment(parcel);
        }

        public final Object[] newArray(int i) {
            return new SentPayment[i];
        }
    }

    public static SentPaymentBuilder newBuilder() {
        return new SentPaymentBuilder();
    }

    public SentPayment(SentPaymentBuilder sentPaymentBuilder) {
        boolean z;
        boolean z2 = true;
        if (StringUtil.a(sentPaymentBuilder.f2155a)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sentPaymentBuilder.f2156b)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (sentPaymentBuilder.f2157c > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sentPaymentBuilder.f2158d)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f2144a = sentPaymentBuilder.f2155a;
        this.f2145b = sentPaymentBuilder.f2156b;
        this.f2146c = sentPaymentBuilder.f2157c;
        this.f2147d = sentPaymentBuilder.f2158d;
        this.f2148e = sentPaymentBuilder.f2159e;
        this.f2149f = sentPaymentBuilder.f2160f;
        this.f2150g = sentPaymentBuilder.f2161g;
        this.f2151h = sentPaymentBuilder.f2162h;
        this.f2152i = sentPaymentBuilder.f2163i;
        this.f2153j = sentPaymentBuilder.f2164j;
        this.f2154k = sentPaymentBuilder.f2165k;
    }

    public SentPayment(Parcel parcel) {
        this.f2144a = parcel.readString();
        this.f2145b = parcel.readString();
        this.f2146c = parcel.readLong();
        this.f2147d = parcel.readString();
        this.f2148e = parcel.readString();
        this.f2149f = parcel.readString();
        this.f2150g = ParcelUtil.a(parcel);
        this.f2151h = parcel.readString();
        this.f2152i = (PaymentFlowType) parcel.readSerializable();
        this.f2153j = parcel.readString();
        this.f2154k = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2144a);
        parcel.writeString(this.f2145b);
        parcel.writeLong(this.f2146c);
        parcel.writeString(this.f2147d);
        parcel.writeString(this.f2148e);
        parcel.writeString(this.f2149f);
        ParcelUtil.a(parcel, this.f2150g);
        parcel.writeString(this.f2151h);
        parcel.writeSerializable(this.f2152i);
        parcel.writeString(this.f2153j);
        parcel.writeString(this.f2154k);
    }
}
