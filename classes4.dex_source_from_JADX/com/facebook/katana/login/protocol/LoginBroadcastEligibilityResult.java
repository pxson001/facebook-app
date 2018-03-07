package com.facebook.katana.login.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: size_bytes */
public class LoginBroadcastEligibilityResult implements Parcelable {
    public static final Creator<LoginBroadcastEligibilityResult> CREATOR = new C01111();
    public boolean f2141a;

    /* compiled from: size_bytes */
    final class C01111 implements Creator<LoginBroadcastEligibilityResult> {
        C01111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoginBroadcastEligibilityResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoginBroadcastEligibilityResult[0];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.f2141a ? 1 : 0));
    }

    public LoginBroadcastEligibilityResult(boolean z) {
        this.f2141a = z;
    }

    public LoginBroadcastEligibilityResult(Parcel parcel) {
        this.f2141a = parcel.readByte() != (byte) 0;
    }
}
