package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

/* compiled from: viewability_duration */
public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C00181();
    private final int f259a;
    private final long f260b;
    private final long f261c;
    private final float f262d;
    private final long f263e;
    private final CharSequence f264f;
    private final long f265g;

    /* compiled from: viewability_duration */
    final class C00181 implements Creator<PlaybackStateCompat> {
        C00181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f259a = parcel.readInt();
        this.f260b = parcel.readLong();
        this.f262d = parcel.readFloat();
        this.f265g = parcel.readLong();
        this.f261c = parcel.readLong();
        this.f263e = parcel.readLong();
        this.f264f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f259a);
        stringBuilder.append(", position=").append(this.f260b);
        stringBuilder.append(", buffered position=").append(this.f261c);
        stringBuilder.append(", speed=").append(this.f262d);
        stringBuilder.append(", updated=").append(this.f265g);
        stringBuilder.append(", actions=").append(this.f263e);
        stringBuilder.append(", error=").append(this.f264f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f259a);
        parcel.writeLong(this.f260b);
        parcel.writeFloat(this.f262d);
        parcel.writeLong(this.f265g);
        parcel.writeLong(this.f261c);
        parcel.writeLong(this.f263e);
        TextUtils.writeToParcel(this.f264f, parcel, i);
    }
}
