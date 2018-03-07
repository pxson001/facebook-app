package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: image_cache_size_bytes */
public class CreatePagePhotoAlbumParams implements Parcelable {
    public static final Creator<CreatePagePhotoAlbumParams> CREATOR = new C08241();
    public final long f12892a;
    public final String f12893b;
    public final String f12894c;
    public final String f12895d;

    /* compiled from: image_cache_size_bytes */
    final class C08241 implements Creator<CreatePagePhotoAlbumParams> {
        C08241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreatePagePhotoAlbumParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreatePagePhotoAlbumParams[i];
        }
    }

    public CreatePagePhotoAlbumParams(long j, String str, @Nullable String str2, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        this.f12892a = j;
        this.f12893b = str;
        this.f12894c = str2;
        this.f12895d = str3;
    }

    public CreatePagePhotoAlbumParams(Parcel parcel) {
        this.f12892a = parcel.readLong();
        this.f12893b = parcel.readString();
        this.f12894c = parcel.readString();
        this.f12895d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12892a);
        parcel.writeString(this.f12893b);
        parcel.writeString(this.f12894c);
        parcel.writeString(this.f12895d);
    }
}
