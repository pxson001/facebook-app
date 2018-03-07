package com.facebook.photos.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: home */
public class PhotoSetSlice implements Parcelable {
    public static final Creator<PhotoSetSlice> CREATOR = new C08451();
    private final String f12975a;
    private final long f12976b;
    private final boolean f12977c;
    private final ImmutableList<PhotoPlaceholder> f12978d;
    private final ImmutableList<Long> f12979e = PhotoSet.m20332a(this.f12978d);

    /* compiled from: home */
    final class C08451 implements Creator<PhotoSetSlice> {
        C08451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoSetSlice(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoSetSlice[i];
        }
    }

    public PhotoSetSlice(Parcel parcel) {
        this.f12975a = parcel.readString();
        this.f12976b = parcel.readLong();
        this.f12977c = ParcelUtil.a(parcel);
        Collection a = Lists.a();
        parcel.readList(a, getClass().getClassLoader());
        this.f12978d = ImmutableList.copyOf(a);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12975a);
        parcel.writeLong(this.f12976b);
        ParcelUtil.a(parcel, this.f12977c);
        parcel.writeList(this.f12978d);
    }

    public int describeContents() {
        return 0;
    }
}
