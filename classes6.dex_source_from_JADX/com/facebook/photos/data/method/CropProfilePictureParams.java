package com.facebook.photos.data.method;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: imageSpec */
public class CropProfilePictureParams implements Parcelable {
    public static final Creator<CropProfilePictureParams> CREATOR = new C08271();
    public final String f12906a;
    public final RectF f12907b;
    public final long f12908c;
    @Nullable
    public final String f12909d;
    public final String f12910e;

    /* compiled from: imageSpec */
    final class C08271 implements Creator<CropProfilePictureParams> {
        C08271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CropProfilePictureParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CropProfilePictureParams[i];
        }
    }

    public CropProfilePictureParams(String str, RectF rectF, String str2, long j, @Nullable String str3) {
        this.f12906a = str;
        this.f12907b = rectF;
        this.f12910e = str2;
        this.f12908c = j;
        this.f12909d = str3;
    }

    public CropProfilePictureParams(Parcel parcel) {
        this.f12906a = parcel.readString();
        this.f12907b = new RectF();
        this.f12907b.readFromParcel(parcel);
        this.f12910e = parcel.readString();
        this.f12908c = parcel.readLong();
        this.f12909d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12906a);
        this.f12907b.writeToParcel(parcel, i);
        parcel.writeString(this.f12910e);
        parcel.writeLong(this.f12908c);
        parcel.writeString(this.f12909d);
    }
}
