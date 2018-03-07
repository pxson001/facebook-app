package com.facebook.messaging.model.mms;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: upload_op */
public class MmsData implements Parcelable {
    public static final Creator<MmsData> CREATOR = new C01011();
    public static final MmsData f2129a = new MmsData(-1, -1, f2130e);
    private static final ImmutableList<MediaResource> f2130e = RegularImmutableList.a;
    public final long f2131b;
    public final long f2132c;
    public final ImmutableList<MediaResource> f2133d;

    /* compiled from: upload_op */
    final class C01011 implements Creator<MmsData> {
        C01011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MmsData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MmsData[i];
        }
    }

    private MmsData(long j, long j2, ImmutableList<MediaResource> immutableList) {
        this.f2131b = j;
        this.f2132c = j2;
        this.f2133d = immutableList;
    }

    public static MmsData m3455a(long j, long j2) {
        return new MmsData(j, j2, f2130e);
    }

    public static MmsData m3456a(ImmutableList<MediaResource> immutableList) {
        boolean z;
        boolean z2 = true;
        if (immutableList != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (immutableList.isEmpty()) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return new MmsData(0, 0, immutableList);
    }

    public final boolean m3458b() {
        if (this.f2133d.size() > 0) {
            return "text/x-vCard".equalsIgnoreCase(((MediaResource) this.f2133d.get(0)).f5178o);
        }
        return false;
    }

    public final boolean m3457a() {
        Object obj = (this.f2131b == f2129a.f2131b && this.f2132c == f2129a.f2132c && this.f2133d.isEmpty()) ? 1 : null;
        return obj == null && this.f2133d.isEmpty();
    }

    public MmsData(Parcel parcel) {
        this.f2131b = parcel.readLong();
        this.f2132c = parcel.readLong();
        this.f2133d = ImmutableList.copyOf(parcel.readArrayList(MediaResource.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f2131b);
        parcel.writeLong(this.f2132c);
        parcel.writeList(this.f2133d);
    }

    @Nullable
    public final String m3459c() {
        if (this.f2133d.isEmpty()) {
            return null;
        }
        MediaResource mediaResource = (MediaResource) this.f2133d.get(0);
        return !Strings.isNullOrEmpty(mediaResource.f5178o) ? mediaResource.f5178o : mediaResource.f5167d.name();
    }
}
