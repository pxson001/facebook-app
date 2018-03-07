package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.folders.FolderName;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: continuous_contact_upload_setting_update */
public class FetchUpdatedUserInfoParams implements Parcelable {
    public static final Creator<FetchUpdatedUserInfoParams> CREATOR = new C20331();
    public final FolderName f17189a;
    public final int f17190b;
    public final long f17191c;

    /* compiled from: continuous_contact_upload_setting_update */
    final class C20331 implements Creator<FetchUpdatedUserInfoParams> {
        C20331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchUpdatedUserInfoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchUpdatedUserInfoParams[i];
        }
    }

    public FetchUpdatedUserInfoParams(Parcel parcel) {
        this.f17189a = FolderName.fromDbName(parcel.readString());
        this.f17190b = parcel.readInt();
        this.f17191c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17189a.dbName);
        parcel.writeInt(this.f17190b);
        parcel.writeLong(this.f17191c);
    }
}
