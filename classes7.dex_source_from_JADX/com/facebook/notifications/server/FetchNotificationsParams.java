package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;

/* compiled from: moved_stickers_count */
public class FetchNotificationsParams implements Parcelable {
    public static final Creator<FetchNotificationsParams> CREATOR = new C06981();
    private DataFreshnessParam f8686a;
    private long f8687b;

    /* compiled from: moved_stickers_count */
    final class C06981 implements Creator<FetchNotificationsParams> {
        C06981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNotificationsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNotificationsParams[i];
        }
    }

    public FetchNotificationsParams(Parcel parcel) {
        this.f8686a = DataFreshnessParam.valueOf(parcel.readString());
        this.f8687b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8686a.toString());
        parcel.writeLong(this.f8687b);
    }
}
