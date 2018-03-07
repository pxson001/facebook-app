package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: suggestions is null */
public class SetAdminSettingParams implements Parcelable {
    public static final Creator<SetAdminSettingParams> CREATOR = new C01671();
    public final String f1216a;
    public final String f1217b;

    /* compiled from: suggestions is null */
    final class C01671 implements Creator<SetAdminSettingParams> {
        C01671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetAdminSettingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetAdminSettingParams[i];
        }
    }

    public SetAdminSettingParams(Parcel parcel) {
        this.f1216a = parcel.readString();
        this.f1217b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1216a);
        parcel.writeString(this.f1217b);
    }
}
