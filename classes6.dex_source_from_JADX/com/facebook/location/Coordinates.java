package com.facebook.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: 他 */
public class Coordinates implements Parcelable {
    public static final Creator<Coordinates> CREATOR = new C00001();
    public final double f9a;
    public final double f10b;
    public final Float f11c;

    /* compiled from: 他 */
    final class C00001 implements Creator<Coordinates> {
        C00001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Coordinates(parcel);
        }

        public final Object[] newArray(int i) {
            return new Coordinates[i];
        }
    }

    Coordinates(CoordinatesBuilder coordinatesBuilder) {
        boolean z;
        if (coordinatesBuilder.f12a == null || coordinatesBuilder.f13b == null) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f9a = coordinatesBuilder.f12a.doubleValue();
        this.f10b = coordinatesBuilder.f13b.doubleValue();
        this.f11c = coordinatesBuilder.f14c;
    }

    public Coordinates(Parcel parcel) {
        this.f9a = parcel.readDouble();
        this.f10b = parcel.readDouble();
        this.f11c = (Float) parcel.readValue(null);
    }

    public static CoordinatesBuilder newBuilder() {
        return new CoordinatesBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f9a);
        parcel.writeDouble(this.f10b);
        parcel.writeValue(this.f11c);
    }
}
