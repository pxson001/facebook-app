package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: findfriends?ci_flow={%s %s}&ccu_ref={%s %s}&force_show_legal_screen={!%s false} */
public class EditPaymentCardParams implements Parcelable {
    public static final Creator<EditPaymentCardParams> CREATOR = new C16701();
    public final String f14628a;
    public final int f14629b;
    public final int f14630c;
    public final String f14631d;
    public final String f14632e;
    public final boolean f14633f;

    /* compiled from: findfriends?ci_flow={%s %s}&ccu_ref={%s %s}&force_show_legal_screen={!%s false} */
    final class C16701 implements Creator<EditPaymentCardParams> {
        C16701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditPaymentCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditPaymentCardParams[i];
        }
    }

    public EditPaymentCardParams(String str, int i, int i2, String str2, @Nullable String str3, boolean z) {
        this.f14628a = str;
        this.f14629b = i;
        this.f14630c = i2;
        this.f14631d = str2;
        this.f14632e = str3;
        this.f14633f = z;
    }

    public EditPaymentCardParams(Parcel parcel) {
        this.f14628a = parcel.readString();
        this.f14629b = parcel.readInt();
        this.f14630c = parcel.readInt();
        this.f14631d = parcel.readString();
        this.f14632e = parcel.readString();
        this.f14633f = ParcelUtil.a(parcel);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("credentialId", this.f14628a).add("month", this.f14629b).add("year", this.f14630c).add("csc", this.f14631d).add("zip", this.f14632e).add("shouldVerifyMobileEligibility", this.f14633f).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14628a);
        parcel.writeInt(this.f14629b);
        parcel.writeInt(this.f14630c);
        parcel.writeString(this.f14631d);
        parcel.writeString(this.f14632e);
        ParcelUtil.a(parcel, this.f14633f);
    }
}
