package com.facebook.orca.threadview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: minutiae_og_action */
public class ForwardMenuItemExtraData implements Parcelable {
    public static final Creator<ForwardMenuItemExtraData> CREATOR = new C10411();
    public String f6926a;

    /* compiled from: minutiae_og_action */
    final class C10411 implements Creator<ForwardMenuItemExtraData> {
        C10411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ForwardMenuItemExtraData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ForwardMenuItemExtraData[i];
        }
    }

    public ForwardMenuItemExtraData(String str) {
        this.f6926a = str;
    }

    public ForwardMenuItemExtraData(Parcel parcel) {
        this.f6926a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6926a);
    }
}
