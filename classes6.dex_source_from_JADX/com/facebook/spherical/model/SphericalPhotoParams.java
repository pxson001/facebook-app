package com.facebook.spherical.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: estimated_resized_file_size */
public class SphericalPhotoParams implements Parcelable, SphericalParams {
    public static final Creator<SphericalPhotoParams> CREATOR = new C11391();
    public final int f16174a;
    public final int f16175b;
    public final int f16176c;
    public final int f16177d;
    public final double f16178e;
    public final double f16179f;
    public final double f16180g;
    public final double f16181h;

    /* compiled from: estimated_resized_file_size */
    final class C11391 implements Creator<SphericalPhotoParams> {
        C11391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SphericalPhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SphericalPhotoParams[i];
        }
    }

    /* compiled from: estimated_resized_file_size */
    public class Builder {
        public int f16166a = 0;
        public int f16167b = 0;
        public int f16168c = 0;
        public int f16169d = 0;
        public double f16170e = 0.0d;
        public double f16171f = 0.0d;
        public double f16172g = 0.0d;
        public double f16173h = 70.0d;

        public final SphericalPhotoParams m23735a() {
            return new SphericalPhotoParams(this);
        }
    }

    SphericalPhotoParams(Builder builder) {
        this.f16174a = builder.f16166a;
        this.f16175b = builder.f16167b;
        this.f16176c = builder.f16168c;
        this.f16177d = builder.f16169d;
        this.f16178e = builder.f16170e;
        this.f16179f = builder.f16171f;
        this.f16180g = builder.f16172g;
        this.f16181h = builder.f16173h;
    }

    SphericalPhotoParams(Parcel parcel) {
        this.f16174a = parcel.readInt();
        this.f16175b = parcel.readInt();
        this.f16176c = parcel.readInt();
        this.f16177d = parcel.readInt();
        this.f16178e = parcel.readDouble();
        this.f16179f = parcel.readDouble();
        this.f16180g = parcel.readDouble();
        this.f16181h = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16174a);
        parcel.writeInt(this.f16175b);
        parcel.writeInt(this.f16176c);
        parcel.writeInt(this.f16177d);
        parcel.writeDouble(this.f16178e);
        parcel.writeDouble(this.f16179f);
        parcel.writeDouble(this.f16180g);
        parcel.writeDouble(this.f16181h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SphericalPhotoParams)) {
            return false;
        }
        SphericalPhotoParams sphericalPhotoParams = (SphericalPhotoParams) obj;
        if (this.f16174a == sphericalPhotoParams.f16174a && this.f16175b == sphericalPhotoParams.f16175b && this.f16176c == sphericalPhotoParams.f16176c && this.f16177d == sphericalPhotoParams.f16177d && this.f16178e == sphericalPhotoParams.f16178e && this.f16179f == sphericalPhotoParams.f16179f && this.f16180g == sphericalPhotoParams.f16180g && this.f16181h == sphericalPhotoParams.f16181h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f16176c), Integer.valueOf(this.f16175b), Integer.valueOf(this.f16176c), Integer.valueOf(this.f16177d), Double.valueOf(this.f16178e), Double.valueOf(this.f16179f), Double.valueOf(this.f16180g), Double.valueOf(this.f16181h)});
    }

    public final float mo1242a() {
        return (float) this.f16181h;
    }

    public final float mo1243b() {
        return (float) this.f16179f;
    }

    public final float mo1244c() {
        return (float) this.f16178e;
    }

    public final GuidedTourParams mo1245d() {
        return null;
    }
}
