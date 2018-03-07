package com.facebook.messaging.media.download;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mHasThrownException */
public class DownloadedMedia implements Parcelable {
    public static final Creator<DownloadedMedia> CREATOR = new C12871();
    public final ResultCode f11515a;
    public final Uri f11516b;

    /* compiled from: mHasThrownException */
    final class C12871 implements Creator<DownloadedMedia> {
        C12871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DownloadedMedia(parcel);
        }

        public final Object[] newArray(int i) {
            return new DownloadedMedia[i];
        }
    }

    /* compiled from: mHasThrownException */
    public enum ResultCode {
        DOWNLOADED,
        PRE_EXISTING,
        FAILURE
    }

    public DownloadedMedia(ResultCode resultCode, @Nullable Uri uri) {
        this.f11515a = resultCode;
        this.f11516b = uri;
        if (resultCode != ResultCode.FAILURE) {
            Preconditions.checkNotNull(uri, "Must provide a URI for successful download");
        }
    }

    public DownloadedMedia(Parcel parcel) {
        this.f11515a = (ResultCode) parcel.readSerializable();
        this.f11516b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f11515a);
        parcel.writeParcelable(this.f11516b, i);
    }
}
