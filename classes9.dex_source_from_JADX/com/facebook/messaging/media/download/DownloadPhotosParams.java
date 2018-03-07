package com.facebook.messaging.media.download;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mImage */
public class DownloadPhotosParams implements Parcelable {
    public static final Creator<DownloadPhotosParams> CREATOR = new C12861();
    public final ImmutableList<PhotoToDownload> f11512a;
    public final PhotoDownloadDestination f11513b;
    public final boolean f11514c;

    /* compiled from: mImage */
    final class C12861 implements Creator<DownloadPhotosParams> {
        C12861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DownloadPhotosParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DownloadPhotosParams[i];
        }
    }

    public DownloadPhotosParams(List<PhotoToDownload> list, PhotoDownloadDestination photoDownloadDestination, boolean z) {
        this.f11512a = ImmutableList.copyOf(list);
        this.f11513b = photoDownloadDestination;
        this.f11514c = z;
    }

    public DownloadPhotosParams(Parcel parcel) {
        this.f11512a = ImmutableList.copyOf(parcel.readArrayList(PhotoToDownload.class.getClassLoader()));
        this.f11513b = (PhotoDownloadDestination) parcel.readSerializable();
        this.f11514c = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f11512a);
        parcel.writeSerializable(this.f11513b);
        ParcelUtil.a(parcel, this.f11514c);
    }
}
