package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: imageWidth */
public class CreatePhotoAlbumParams implements Parcelable {
    public static final Creator<CreatePhotoAlbumParams> CREATOR = new C08251();
    public final String f12896a;
    public final String f12897b;
    public final String f12898c;
    public final String f12899d;
    public final String f12900e;
    public final String f12901f;
    public final String f12902g;

    /* compiled from: imageWidth */
    final class C08251 implements Creator<CreatePhotoAlbumParams> {
        C08251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreatePhotoAlbumParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreatePhotoAlbumParams[i];
        }
    }

    public CreatePhotoAlbumParams(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Preconditions.checkArgument(!StringUtil.a(str));
        this.f12896a = str;
        this.f12897b = Strings.emptyToNull(str2);
        this.f12898c = str3;
        this.f12899d = Strings.emptyToNull(str4);
        this.f12900e = Strings.emptyToNull(str5);
        this.f12901f = Strings.emptyToNull(str6);
        this.f12902g = Strings.emptyToNull(str7);
    }

    public CreatePhotoAlbumParams(Parcel parcel) {
        this.f12896a = parcel.readString();
        this.f12897b = parcel.readString();
        this.f12898c = parcel.readString();
        this.f12899d = parcel.readString();
        this.f12900e = parcel.readString();
        this.f12901f = parcel.readString();
        this.f12902g = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12896a);
        parcel.writeString(this.f12897b);
        parcel.writeString(this.f12898c);
        parcel.writeString(this.f12899d);
        parcel.writeString(this.f12900e);
        parcel.writeString(this.f12901f);
        parcel.writeString(this.f12902g);
    }
}
