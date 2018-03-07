package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: viewer_content_safety_restrictions */
public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new C00151();
    private final int f248a;
    private final float f249b;

    /* compiled from: viewer_content_safety_restrictions */
    final class C00151 implements Creator<RatingCompat> {
        C00151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public final Object[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    public RatingCompat(int i, float f) {
        this.f248a = i;
        this.f249b = f;
    }

    public final String toString() {
        return "Rating:style=" + this.f248a + " rating=" + (this.f249b < 0.0f ? "unrated" : String.valueOf(this.f249b));
    }

    public final int describeContents() {
        return this.f248a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f248a);
        parcel.writeFloat(this.f249b);
    }
}
