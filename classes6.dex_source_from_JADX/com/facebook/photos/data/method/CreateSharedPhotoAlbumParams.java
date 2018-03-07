package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: imageURIMapFormat */
public class CreateSharedPhotoAlbumParams implements Parcelable {
    public static final Creator<CreateSharedPhotoAlbumParams> CREATOR = new C08261();
    public final String f12903a;
    public final String f12904b;

    /* compiled from: imageURIMapFormat */
    final class C08261 implements Creator<CreateSharedPhotoAlbumParams> {
        C08261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreateSharedPhotoAlbumParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreateSharedPhotoAlbumParams[i];
        }
    }

    public CreateSharedPhotoAlbumParams(String str, String str2) {
        boolean z;
        boolean z2 = true;
        if (StringUtil.a(str)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(str2)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f12903a = str;
        this.f12904b = str2;
    }

    public CreateSharedPhotoAlbumParams(Parcel parcel) {
        this.f12903a = parcel.readString();
        this.f12904b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12903a);
        parcel.writeString(this.f12904b);
    }
}
