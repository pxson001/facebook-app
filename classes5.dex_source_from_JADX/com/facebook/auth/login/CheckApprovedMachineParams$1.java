package com.facebook.auth.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: t_profile */
final class CheckApprovedMachineParams$1 implements Creator<CheckApprovedMachineParams> {
    CheckApprovedMachineParams$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new CheckApprovedMachineParams(parcel);
    }

    public final Object[] newArray(int i) {
        return new CheckApprovedMachineParams[i];
    }
}
