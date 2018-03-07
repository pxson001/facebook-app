package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.MoreObjects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: first_devices */
public class AddPaymentCardParams implements Parcelable {
    public static final Creator<AddPaymentCardParams> CREATOR = new C16671();
    public final String f14617a;
    public final int f14618b;
    public final int f14619c;
    public final String f14620d;
    public final String f14621e;
    public final String f14622f;
    public final String f14623g;
    public final String f14624h;

    /* compiled from: first_devices */
    final class C16671 implements Creator<AddPaymentCardParams> {
        C16671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddPaymentCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddPaymentCardParams[i];
        }
    }

    public AddPaymentCardParams(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        this.f14617a = str;
        this.f14618b = i;
        this.f14619c = i2;
        this.f14620d = str2;
        this.f14621e = str3;
        this.f14622f = str4;
        this.f14623g = str5;
        this.f14624h = str6;
    }

    public AddPaymentCardParams(Parcel parcel) {
        this.f14617a = parcel.readString();
        this.f14618b = parcel.readInt();
        this.f14619c = parcel.readInt();
        this.f14620d = parcel.readString();
        this.f14621e = parcel.readString();
        this.f14622f = parcel.readString();
        this.f14623g = parcel.readString();
        this.f14624h = parcel.readString();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("creditCardNumber", this.f14617a).add("month", this.f14618b).add("year", this.f14619c).add("csc", this.f14620d).add("zip", this.f14621e).add("userid", this.f14622f).add("productType", this.f14623g).add("productId", this.f14624h).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14617a);
        parcel.writeInt(this.f14618b);
        parcel.writeInt(this.f14619c);
        parcel.writeString(this.f14620d);
        parcel.writeString(this.f14621e);
        parcel.writeString(this.f14622f);
        parcel.writeString(this.f14623g);
        parcel.writeString(this.f14624h);
    }
}
