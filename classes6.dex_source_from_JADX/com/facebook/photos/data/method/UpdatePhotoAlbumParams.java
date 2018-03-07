package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: http_4xx */
public class UpdatePhotoAlbumParams implements Parcelable {
    public static final Creator<UpdatePhotoAlbumParams> CREATOR = new C08411();
    public final String f12957a;
    public final String f12958b;
    public final String f12959c;
    public final String f12960d;
    public final String f12961e;
    public final ConversionType f12962f;
    public final Boolean f12963g;

    /* compiled from: http_4xx */
    final class C08411 implements Creator<UpdatePhotoAlbumParams> {
        C08411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdatePhotoAlbumParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdatePhotoAlbumParams[i];
        }
    }

    /* compiled from: http_4xx */
    public enum ConversionType {
        NO_CONVERSION,
        NORMAL_TO_SHARED
    }

    public UpdatePhotoAlbumParams(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ConversionType conversionType, @Nullable Boolean bool) {
        this.f12957a = (String) Preconditions.checkNotNull(str);
        this.f12958b = str2;
        this.f12959c = str3;
        this.f12960d = str4;
        this.f12961e = str5;
        this.f12962f = conversionType;
        this.f12963g = bool;
    }

    public UpdatePhotoAlbumParams(Parcel parcel) {
        this.f12957a = parcel.readString();
        this.f12958b = parcel.readString();
        this.f12959c = parcel.readString();
        this.f12960d = parcel.readString();
        this.f12961e = parcel.readString();
        this.f12962f = (ConversionType) parcel.readSerializable();
        this.f12963g = Boolean.valueOf(ParcelUtil.a(parcel));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12957a);
        parcel.writeString(this.f12958b);
        parcel.writeString(this.f12959c);
        parcel.writeString(this.f12960d);
        parcel.writeString(this.f12961e);
        parcel.writeSerializable(this.f12962f);
        ParcelUtil.a(parcel, this.f12963g.booleanValue());
    }
}
