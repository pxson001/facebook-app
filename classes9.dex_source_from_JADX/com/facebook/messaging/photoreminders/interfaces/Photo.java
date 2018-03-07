package com.facebook.messaging.photoreminders.interfaces;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: done_button */
public class Photo implements Parcelable {
    public static final Creator<Photo> CREATOR = new C18731();
    private final double f16004a;
    private final double f16005b;
    private final double f16006c;
    private final Location f16007d;
    private final String f16008e;
    private final String f16009f;
    private final int f16010g;

    /* compiled from: done_button */
    final class C18731 implements Creator<Photo> {
        C18731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        public final Object[] newArray(int i) {
            return new Photo[i];
        }
    }

    /* compiled from: done_button */
    public class Builder {
    }

    /* compiled from: done_button */
    public class Location implements Parcelable {
        public static final Creator<Location> CREATOR = new C18741();
        private final double f16002a;
        private final double f16003b;

        /* compiled from: done_button */
        final class C18741 implements Creator<Location> {
            C18741() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Location(parcel);
            }

            public final Object[] newArray(int i) {
                return new Location[i];
            }
        }

        public Location(Parcel parcel) {
            this.f16002a = parcel.readDouble();
            this.f16003b = parcel.readDouble();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.f16002a);
            parcel.writeDouble(this.f16003b);
        }
    }

    public String toString() {
        return Objects.toStringHelper(Photo.class).add("width", this.f16004a).add("height", this.f16005b).add("date", this.f16006c).add("location", this.f16007d).add("localID", this.f16008e).add("localPath", this.f16009f).add("orientation", this.f16010g).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) obj;
        if (this.f16004a == photo.f16004a && this.f16005b == photo.f16005b && this.f16006c == photo.f16006c && Objects.equal(this.f16007d, photo.f16007d) && Objects.equal(this.f16008e, photo.f16008e) && Objects.equal(this.f16009f, photo.f16009f) && this.f16010g == photo.f16010g) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Double.valueOf(this.f16004a), Double.valueOf(this.f16005b), Double.valueOf(this.f16006c), this.f16007d, this.f16008e, this.f16009f, Integer.valueOf(this.f16010g)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f16004a);
        parcel.writeDouble(this.f16005b);
        parcel.writeDouble(this.f16006c);
        parcel.writeParcelable(this.f16007d, 0);
        parcel.writeString(this.f16008e);
        parcel.writeString(this.f16009f);
        parcel.writeInt(this.f16010g);
    }

    public Photo(Parcel parcel) {
        this.f16004a = parcel.readDouble();
        this.f16005b = parcel.readDouble();
        this.f16006c = parcel.readDouble();
        this.f16007d = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f16008e = parcel.readString();
        this.f16009f = parcel.readString();
        this.f16010g = parcel.readInt();
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
