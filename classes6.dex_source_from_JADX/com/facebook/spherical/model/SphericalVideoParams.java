package com.facebook.spherical.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;

/* compiled from: error_user_title */
public class SphericalVideoParams implements Parcelable, SphericalParams {
    public static final Creator<SphericalVideoParams> CREATOR = new C11401();
    public final String f16203a;
    public final String f16204b;
    public final int f16205c;
    public final int f16206d;
    public final int f16207e;
    public final int f16208f;
    public final double f16209g;
    public final double f16210h;
    public final GuidedTourParams f16211i;

    /* compiled from: error_user_title */
    final class C11401 implements Creator<SphericalVideoParams> {
        C11401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SphericalVideoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SphericalVideoParams[i];
        }
    }

    /* compiled from: error_user_title */
    public class Builder {
        public String f16194a = "equirectangular";
        public String f16195b;
        public int f16196c = 0;
        public int f16197d = 0;
        public int f16198e = 0;
        public int f16199f = 0;
        public double f16200g = 0.0d;
        public double f16201h = 0.0d;
        public GuidedTourParams f16202i;

        public final Builder m23744a(String str) {
            this.f16194a = str;
            return this;
        }

        public final Builder m23748b(String str) {
            this.f16195b = str;
            return this;
        }

        public final Builder m23743a(int i) {
            this.f16196c = i;
            return this;
        }

        public final Builder m23747b(int i) {
            this.f16197d = i;
            return this;
        }

        public final Builder m23749c(int i) {
            this.f16198e = i;
            return this;
        }

        public final Builder m23750d(int i) {
            this.f16199f = i;
            return this;
        }

        public final Builder m23742a(double d) {
            this.f16200g = d;
            return this;
        }

        public final Builder m23746b(double d) {
            this.f16201h = d;
            return this;
        }

        public final SphericalVideoParams m23745a() {
            return new SphericalVideoParams(this);
        }
    }

    SphericalVideoParams(Builder builder) {
        this.f16203a = builder.f16194a;
        this.f16204b = builder.f16195b;
        this.f16205c = builder.f16196c;
        this.f16206d = builder.f16197d;
        this.f16207e = builder.f16198e;
        this.f16208f = builder.f16199f;
        this.f16209g = builder.f16200g;
        this.f16210h = builder.f16201h;
        this.f16211i = builder.f16202i;
    }

    SphericalVideoParams(Parcel parcel) {
        this.f16203a = parcel.readString();
        this.f16204b = parcel.readString();
        this.f16205c = parcel.readInt();
        this.f16206d = parcel.readInt();
        this.f16207e = parcel.readInt();
        this.f16208f = parcel.readInt();
        this.f16209g = parcel.readDouble();
        this.f16210h = parcel.readDouble();
        this.f16211i = (GuidedTourParams) parcel.readParcelable(GuidedTourParams.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16203a);
        parcel.writeString(this.f16204b);
        parcel.writeInt(this.f16205c);
        parcel.writeInt(this.f16206d);
        parcel.writeInt(this.f16207e);
        parcel.writeInt(this.f16208f);
        parcel.writeDouble(this.f16209g);
        parcel.writeDouble(this.f16210h);
        parcel.writeParcelable(this.f16211i, i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SphericalVideoParams)) {
            return false;
        }
        SphericalVideoParams sphericalVideoParams = (SphericalVideoParams) obj;
        if (StringUtil.a(this.f16203a, sphericalVideoParams.f16203a) && StringUtil.a(this.f16204b, sphericalVideoParams.f16204b) && this.f16205c == sphericalVideoParams.f16205c && this.f16206d == sphericalVideoParams.f16206d && this.f16207e == sphericalVideoParams.f16207e && this.f16208f == sphericalVideoParams.f16208f && this.f16209g == sphericalVideoParams.f16209g && this.f16210h == sphericalVideoParams.f16210h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f16203a, this.f16204b, Integer.valueOf(this.f16205c), Integer.valueOf(this.f16206d), Integer.valueOf(this.f16207e), Integer.valueOf(this.f16208f), Double.valueOf(this.f16209g), Double.valueOf(this.f16210h)});
    }

    public final float mo1242a() {
        return (float) this.f16208f;
    }

    public final float mo1243b() {
        return (float) this.f16206d;
    }

    public final float mo1244c() {
        return (float) this.f16205c;
    }

    public final GuidedTourParams mo1245d() {
        return this.f16211i;
    }
}
