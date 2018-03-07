package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: viewability_percentage */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C00171();
    public int f254a;
    public int f255b;
    public int f256c;
    public int f257d;
    public int f258e;

    /* compiled from: viewability_percentage */
    final class C00171 implements Creator<ParcelableVolumeInfo> {
        C00171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f254a = parcel.readInt();
        this.f256c = parcel.readInt();
        this.f257d = parcel.readInt();
        this.f258e = parcel.readInt();
        this.f255b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f254a);
        parcel.writeInt(this.f256c);
        parcel.writeInt(this.f257d);
        parcel.writeInt(this.f258e);
        parcel.writeInt(this.f255b);
    }
}
