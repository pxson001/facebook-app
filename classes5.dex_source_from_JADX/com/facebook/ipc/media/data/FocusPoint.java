package com.facebook.ipc.media.data;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: THEME_PARK */
public final class FocusPoint implements Parcelable {
    public static final Creator<FocusPoint> CREATOR = new C13521();
    public static final FocusPoint f14096a = new FocusPoint(0.5d, 0.5d);
    @JsonProperty(a = true, value = "x")
    final double mX;
    @JsonProperty(a = true, value = "y")
    final double mY;

    /* compiled from: THEME_PARK */
    final class C13521 implements Creator<FocusPoint> {
        C13521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FocusPoint(parcel);
        }

        public final Object[] newArray(int i) {
            return new FocusPoint[i];
        }
    }

    private FocusPoint(double d, double d2) {
        boolean z;
        boolean z2 = true;
        if (d < 0.0d || d > 1.0d) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (d2 < 0.0d || d2 > 1.0d) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.mX = d;
        this.mY = d2;
    }

    public final PointF m23468a() {
        return new PointF((float) this.mX, (float) this.mY);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FocusPoint focusPoint = (FocusPoint) obj;
        if (Double.compare(focusPoint.mX, this.mX) != 0) {
            return false;
        }
        if (Double.compare(focusPoint.mY, this.mY) != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits;
        long j = 0;
        if (this.mX != 0.0d) {
            doubleToLongBits = Double.doubleToLongBits(this.mX);
        } else {
            doubleToLongBits = 0;
        }
        doubleToLongBits *= 31;
        if (this.mY != 0.0d) {
            j = Double.doubleToLongBits(this.mY);
        }
        return (int) (doubleToLongBits + j);
    }

    public final String toString() {
        return String.format(Locale.US, "{FocusPoint %f, %f}", new Object[]{Double.valueOf(this.mX), Double.valueOf(this.mY)});
    }

    private FocusPoint() {
        this.mX = 0.0d;
        this.mY = 0.0d;
    }

    public FocusPoint(Parcel parcel) {
        this.mX = parcel.readDouble();
        this.mY = parcel.readDouble();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.mX);
        parcel.writeDouble(this.mY);
    }
}
