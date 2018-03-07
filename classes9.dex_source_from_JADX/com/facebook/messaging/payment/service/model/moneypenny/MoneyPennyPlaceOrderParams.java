package com.facebook.messaging.payment.service.model.moneypenny;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_thread_fail */
public class MoneyPennyPlaceOrderParams implements Parcelable {
    public static final Creator<MoneyPennyPlaceOrderParams> CREATOR = new C16831();
    public static String f14664a = "moneyPennyPlaceOrderParams";
    public final String f14665b;
    public final String f14666c;
    public final String f14667d;
    public final long f14668e;
    public final long f14669f;
    public final String f14670g;

    /* compiled from: fetch_thread_fail */
    final class C16831 implements Creator<MoneyPennyPlaceOrderParams> {
        C16831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MoneyPennyPlaceOrderParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MoneyPennyPlaceOrderParams[i];
        }
    }

    public MoneyPennyPlaceOrderParams(String str, String str2, String str3, long j, long j2, String str4) {
        this.f14665b = str;
        this.f14666c = str2;
        this.f14667d = str3;
        this.f14668e = j;
        this.f14669f = j2;
        this.f14670g = str4;
    }

    public MoneyPennyPlaceOrderParams(Parcel parcel) {
        this.f14665b = parcel.readString();
        this.f14666c = parcel.readString();
        this.f14667d = parcel.readString();
        this.f14668e = parcel.readLong();
        this.f14669f = parcel.readLong();
        this.f14670g = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("amount", this.f14665b).add("userCredential", this.f14666c).add("pin", this.f14667d).add("requestId", this.f14668e).add("itemId", this.f14669f).add("userId", this.f14670g).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14665b);
        parcel.writeString(this.f14666c);
        parcel.writeString(this.f14667d);
        parcel.writeLong(this.f14668e);
        parcel.writeLong(this.f14669f);
        parcel.writeString(this.f14670g);
    }
}
