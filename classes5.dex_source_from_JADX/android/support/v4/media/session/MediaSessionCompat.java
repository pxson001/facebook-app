package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.VolumeProviderCompat;

/* compiled from: viewer_added */
public class MediaSessionCompat {

    /* compiled from: viewer_added */
    public final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new C00161();
        private final Parcelable f253a;

        /* compiled from: viewer_added */
        final class C00161 implements Creator<Token> {
            C00161() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            public final Object[] newArray(int i) {
                return new Token[i];
            }
        }

        Token(Parcelable parcelable) {
            this.f253a = parcelable;
        }

        public final int describeContents() {
            return this.f253a.describeContents();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f253a, i);
        }
    }

    public final void m278a(VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
    }
}
