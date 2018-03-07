package com.facebook.messaging.payment.pin.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: handleTimeout onFailure */
public class CheckPaymentPinParams implements Parcelable {
    public static final Creator<CheckPaymentPinParams> CREATOR = new C15411();
    public static String f13702a = "checkPaymentPinParams";
    public final String f13703b;
    public final long f13704c;

    /* compiled from: handleTimeout onFailure */
    final class C15411 implements Creator<CheckPaymentPinParams> {
        C15411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckPaymentPinParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CheckPaymentPinParams[i];
        }
    }

    public CheckPaymentPinParams(long j, String str) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
        this.f13703b = str;
        this.f13704c = j;
    }

    public CheckPaymentPinParams(Parcel parcel) {
        this.f13703b = parcel.readString();
        this.f13704c = parcel.readLong();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("pin", this.f13703b).add("pinId", this.f13704c).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13703b);
        parcel.writeLong(this.f13704c);
    }
}
