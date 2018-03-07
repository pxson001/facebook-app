package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RKStorage */
final class SouvenirModel$1 implements Creator<SouvenirModel> {
    SouvenirModel$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new SouvenirModel(parcel);
    }

    public final Object[] newArray(int i) {
        return new SouvenirModel[i];
    }
}
