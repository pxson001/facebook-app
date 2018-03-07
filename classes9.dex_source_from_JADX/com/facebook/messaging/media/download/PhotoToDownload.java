package com.facebook.messaging.media.download;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mDobDay */
public class PhotoToDownload implements Parcelable {
    public static final Creator<PhotoToDownload> CREATOR = new C12981();
    public final String f11557a;
    @Nullable
    public final String f11558b;

    /* compiled from: mDobDay */
    final class C12981 implements Creator<PhotoToDownload> {
        C12981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoToDownload(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoToDownload[i];
        }
    }

    public PhotoToDownload(String str) {
        this(str, null);
    }

    public PhotoToDownload(String str, @Nullable String str2) {
        if (str == null) {
            BLog.c("PhotoToDownload", "FBID is null.");
        }
        this.f11557a = str;
        this.f11558b = str2;
    }

    public PhotoToDownload(Parcel parcel) {
        this.f11557a = parcel.readString();
        this.f11558b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11557a);
        parcel.writeString(this.f11558b);
    }
}
