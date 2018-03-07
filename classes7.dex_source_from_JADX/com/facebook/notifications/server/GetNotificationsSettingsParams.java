package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;

/* compiled from: moov */
public class GetNotificationsSettingsParams implements Parcelable {
    public static final Creator<GetNotificationsSettingsParams> CREATOR = new C06991();
    public final String f8688a = "me()";
    public final String f8689b;
    private final DataFreshnessParam f8690c;

    /* compiled from: moov */
    final class C06991 implements Creator<GetNotificationsSettingsParams> {
        C06991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetNotificationsSettingsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetNotificationsSettingsParams[i];
        }
    }

    public GetNotificationsSettingsParams(Parcel parcel) {
        this.f8690c = DataFreshnessParam.valueOf(parcel.readString());
        this.f8689b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8690c.toString());
        parcel.writeString(this.f8689b);
    }
}
