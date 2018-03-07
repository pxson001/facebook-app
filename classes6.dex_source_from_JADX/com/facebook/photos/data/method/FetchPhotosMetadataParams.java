package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: iOSStoreId */
public class FetchPhotosMetadataParams implements Parcelable {
    public static final Creator<FetchPhotosMetadataParams> CREATOR = new C08371();
    public final List<Long> f12943a;
    public final PhotoFetchInfo f12944b;

    /* compiled from: iOSStoreId */
    final class C08371 implements Creator<FetchPhotosMetadataParams> {
        C08371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPhotosMetadataParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPhotosMetadataParams[i];
        }
    }

    public FetchPhotosMetadataParams(List<Long> list, PhotoFetchInfo photoFetchInfo) {
        this.f12943a = list;
        this.f12944b = photoFetchInfo;
    }

    public FetchPhotosMetadataParams(Parcel parcel) {
        this.f12943a = Lists.a();
        parcel.readList(this.f12943a, Long.class.getClassLoader());
        this.f12944b = (PhotoFetchInfo) parcel.readParcelable(PhotoFetchInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f12943a);
        parcel.writeParcelable(this.f12944b, i);
    }
}
