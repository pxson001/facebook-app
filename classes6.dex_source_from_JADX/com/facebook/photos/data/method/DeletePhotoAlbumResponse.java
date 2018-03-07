package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: imageHeight */
public class DeletePhotoAlbumResponse implements Parcelable {
    public static final Creator<DeletePhotoAlbumResponse> CREATOR = new C08291();
    private final boolean f12913a;

    /* compiled from: imageHeight */
    final class C08291 implements Creator<DeletePhotoAlbumResponse> {
        C08291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePhotoAlbumResponse(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePhotoAlbumResponse[i];
        }
    }

    public DeletePhotoAlbumResponse(boolean z) {
        this.f12913a = z;
    }

    public DeletePhotoAlbumResponse(Parcel parcel) {
        this.f12913a = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f12913a);
    }
}
