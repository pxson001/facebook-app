package com.facebook.photos.albums.protocols;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: invalid operation */
public class FetchSingleAlbumParams implements Parcelable {
    public static final Creator<FetchSingleAlbumParams> CREATOR = new C08001();
    public final String f12362a;
    public final String f12363b;
    public final String f12364c;
    public final int f12365d;
    public final int f12366e;
    public final int f12367f;
    public final int f12368g;
    public final int f12369h;
    public final int f12370i;

    /* compiled from: invalid operation */
    final class C08001 implements Creator<FetchSingleAlbumParams> {
        C08001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchSingleAlbumParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchSingleAlbumParams[i];
        }
    }

    public FetchSingleAlbumParams(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, AlbumQueryType albumQueryType) {
        this.f12362a = str;
        this.f12363b = str2;
        this.f12364c = str3;
        this.f12365d = i;
        this.f12366e = i2;
        this.f12367f = i3;
        this.f12368g = i4;
        this.f12369h = i5;
        this.f12370i = albumQueryType.ordinal();
    }

    public FetchSingleAlbumParams(Parcel parcel) {
        this.f12362a = parcel.readString();
        this.f12363b = parcel.readString();
        this.f12364c = parcel.readString();
        this.f12365d = parcel.readInt();
        this.f12366e = parcel.readInt();
        this.f12367f = parcel.readInt();
        this.f12368g = parcel.readInt();
        this.f12369h = parcel.readInt();
        this.f12370i = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12362a);
        parcel.writeString(this.f12363b);
        parcel.writeString(this.f12364c);
        parcel.writeInt(this.f12365d);
        parcel.writeInt(this.f12366e);
        parcel.writeInt(this.f12367f);
        parcel.writeInt(this.f12368g);
        parcel.writeInt(this.f12369h);
        parcel.writeInt(this.f12370i);
    }
}
