package com.facebook.pages.common.protocol.methods;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: setMinutiaeObject */
public class PageIdParam implements Parcelable {
    public static final Creator<PageIdParam> CREATOR = new C02441();
    public final String f1838a;

    /* compiled from: setMinutiaeObject */
    final class C02441 implements Creator<PageIdParam> {
        C02441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PageIdParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new PageIdParam[i];
        }
    }

    public PageIdParam(Parcel parcel) {
        this.f1838a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1838a);
    }

    public int describeContents() {
        return 0;
    }
}
