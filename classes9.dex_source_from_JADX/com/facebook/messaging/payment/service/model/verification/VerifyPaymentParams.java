package com.facebook.messaging.payment.service.model.verification;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.payment.model.verification.UserInput;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchPaymentPlatformContextsMethod */
public class VerifyPaymentParams implements Parcelable {
    public static final Creator<VerifyPaymentParams> CREATOR = new C17121();
    public static String f14789a = "verifyPaymentParams";
    public final String f14790b;
    public final String f14791c;
    public final UserInput f14792d;
    public final String f14793e;
    public final String f14794f;

    /* compiled from: fetchPaymentPlatformContextsMethod */
    final class C17121 implements Creator<VerifyPaymentParams> {
        C17121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VerifyPaymentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new VerifyPaymentParams[i];
        }
    }

    public VerifyPaymentParams(String str, @Nullable String str2, @Nullable UserInput userInput, @Nullable String str3, String str4) {
        this.f14790b = str;
        this.f14791c = str2;
        this.f14792d = userInput;
        this.f14793e = str3;
        this.f14794f = str4;
    }

    public VerifyPaymentParams(Parcel parcel) {
        this.f14790b = parcel.readString();
        this.f14791c = parcel.readString();
        this.f14793e = parcel.readString();
        this.f14794f = parcel.readString();
        this.f14792d = (UserInput) parcel.readParcelable(UserInput.class.getClassLoader());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("transfer_id", this.f14790b).add("submitted_screen", this.f14791c).add("user_input", this.f14792d).add("csc", this.f14793e).add("userid", this.f14794f).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14790b);
        parcel.writeString(this.f14791c);
        parcel.writeString(this.f14793e);
        parcel.writeString(this.f14794f);
        parcel.writeParcelable(this.f14792d, 0);
    }
}
