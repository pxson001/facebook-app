package com.facebook.katana.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: traveling nux does not have profile pic uri or viewer name */
final class LoginApprovalResendCodeParams$1 implements Creator<LoginApprovalResendCodeParams> {
    LoginApprovalResendCodeParams$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new LoginApprovalResendCodeParams(parcel);
    }

    public final Object[] newArray(int i) {
        return new LoginApprovalResendCodeParams[i];
    }
}
