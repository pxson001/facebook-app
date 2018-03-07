package com.facebook.entitycards.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: horizontal_constraint */
public class ScrollLoadError implements Parcelable {
    public static final Creator<ScrollLoadError> CREATOR = new C11971();
    public final String f11078a;

    /* compiled from: horizontal_constraint */
    final class C11971 implements Creator<ScrollLoadError> {
        C11971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ScrollLoadError(parcel);
        }

        public final Object[] newArray(int i) {
            return new ScrollLoadError[i];
        }
    }

    public ScrollLoadError(String str) {
        this.f11078a = str;
    }

    public ScrollLoadError(Parcel parcel) {
        this.f11078a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11078a);
    }
}
