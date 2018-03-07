package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;

/* compiled from: survey unit index out of bound */
public class FetchAppNotificationSettingResult extends BaseResult implements Parcelable {
    public static final Creator<FetchAppNotificationSettingResult> CREATOR = new C01611();
    private final long f1208a;

    /* compiled from: survey unit index out of bound */
    final class C01611 implements Creator<FetchAppNotificationSettingResult> {
        C01611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchAppNotificationSettingResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchAppNotificationSettingResult[i];
        }
    }

    protected FetchAppNotificationSettingResult(Parcel parcel) {
        super(parcel);
        this.f1208a = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.f1208a);
    }
}
