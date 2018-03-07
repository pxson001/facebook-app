package com.facebook.platform.server.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: fetch_real_story_ */
public class GetAppPermissionsMethod$Params implements Parcelable {
    public static final Creator<GetAppPermissionsMethod$Params> CREATOR = new C09861();
    public final String f14936a;

    /* compiled from: fetch_real_story_ */
    final class C09861 implements Creator<GetAppPermissionsMethod$Params> {
        C09861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetAppPermissionsMethod$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetAppPermissionsMethod$Params[i];
        }
    }

    public GetAppPermissionsMethod$Params(String str) {
        this.f14936a = str;
    }

    public GetAppPermissionsMethod$Params(Parcel parcel) {
        this.f14936a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14936a);
    }
}
