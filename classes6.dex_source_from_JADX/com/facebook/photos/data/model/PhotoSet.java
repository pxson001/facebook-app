package com.facebook.photos.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: home_creation */
public class PhotoSet implements Parcelable {
    public static final Creator<PhotoSet> CREATOR = new C08441();
    private final ImmutableList<PhotoPlaceholder> f12971a;
    private final ImmutableList<Long> f12972b = m20332a(this.f12971a);
    private final String f12973c;
    private final boolean f12974d;

    /* compiled from: home_creation */
    final class C08441 implements Creator<PhotoSet> {
        C08441() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoSet(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoSet[i];
        }
    }

    public static String m20333a(long j) {
        return "t." + j;
    }

    public static String m20334b(long j) {
        return "pb." + j;
    }

    public static String m20335c(long j) {
        return "a." + j;
    }

    public static ImmutableList<Long> m20332a(ImmutableList<PhotoPlaceholder> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(Long.valueOf(((PhotoPlaceholder) immutableList.get(i)).f12966a));
        }
        return builder.b();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12973c);
        parcel.writeList(this.f12971a);
        ParcelUtil.a(parcel, this.f12974d);
    }

    public PhotoSet(Parcel parcel) {
        this.f12973c = parcel.readString();
        Collection a = Lists.a();
        parcel.readList(a, getClass().getClassLoader());
        this.f12971a = ImmutableList.copyOf(a);
        this.f12974d = ParcelUtil.a(parcel);
    }
}
