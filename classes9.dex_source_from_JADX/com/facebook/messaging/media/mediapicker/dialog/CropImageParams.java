package com.facebook.messaging.media.mediapicker.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mAll */
public class CropImageParams implements Parcelable {
    public static final Creator<CropImageParams> CREATOR = new C13151();
    public final int f11751a;
    public final int f11752b;
    public final int f11753c;
    public final int f11754d;

    /* compiled from: mAll */
    final class C13151 implements Creator<CropImageParams> {
        C13151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CropImageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CropImageParams[i];
        }
    }

    public CropImageParams(CropImageParamsBuilder cropImageParamsBuilder) {
        this.f11751a = cropImageParamsBuilder.f11755a;
        this.f11752b = cropImageParamsBuilder.f11756b;
        this.f11753c = cropImageParamsBuilder.f11757c;
        this.f11754d = cropImageParamsBuilder.f11758d;
    }

    public CropImageParams(Parcel parcel) {
        this.f11751a = parcel.readInt();
        this.f11752b = parcel.readInt();
        this.f11753c = parcel.readInt();
        this.f11754d = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11751a);
        parcel.writeInt(this.f11752b);
        parcel.writeInt(this.f11753c);
        parcel.writeInt(this.f11754d);
    }
}
