package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.model.FacebookUser;

/* compiled from: THROWBACK_PROMOTION */
public class FacebookStatus implements Parcelable {
    public static final Creator<FacebookStatus> CREATOR = new C13461();
    private final String f14070a;
    private final long f14071b;
    private FacebookUser f14072c;
    private final long f14073d;

    /* compiled from: THROWBACK_PROMOTION */
    final class C13461 implements Creator<FacebookStatus> {
        C13461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookStatus(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookStatus[i];
        }
    }

    public FacebookStatus(Parcel parcel) {
        this.f14070a = parcel.readString();
        this.f14071b = parcel.readLong();
        this.f14072c = (FacebookUser) parcel.readParcelable(FacebookUser.class.getClassLoader());
        this.f14073d = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14070a);
        parcel.writeLong(this.f14071b);
        parcel.writeParcelable(this.f14072c, i);
        parcel.writeLong(this.f14073d);
    }
}
