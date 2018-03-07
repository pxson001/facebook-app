package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: updatePeopleYouMayKnowHistory */
public class ThreadCustomization implements Parcelable {
    public static final Creator<ThreadCustomization> CREATOR = new C01191();
    public static final ThreadCustomization f2252a = new ThreadCustomization();
    public final int f2253b;
    public final int f2254c;
    public final int f2255d;
    public final int f2256e;
    @Nullable
    public final String f2257f;
    public final NicknamesMap f2258g;

    /* compiled from: updatePeopleYouMayKnowHistory */
    final class C01191 implements Creator<ThreadCustomization> {
        C01191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadCustomization(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadCustomization[i];
        }
    }

    /* compiled from: updatePeopleYouMayKnowHistory */
    public class Builder {
        public int f2246a;
        public int f2247b;
        public int f2248c;
        public int f2249d;
        @Nullable
        public String f2250e;
        public NicknamesMap f2251f = new NicknamesMap();

        public final Builder m3532a(ThreadCustomization threadCustomization) {
            this.f2246a = threadCustomization.f2253b;
            this.f2247b = threadCustomization.f2254c;
            this.f2248c = threadCustomization.f2255d;
            this.f2249d = threadCustomization.f2256e;
            this.f2250e = threadCustomization.f2257f;
            this.f2251f = threadCustomization.f2258g;
            return this;
        }

        public final Builder m3530a(int i) {
            this.f2246a = i;
            return this;
        }

        public final Builder m3534b(int i) {
            this.f2247b = i;
            return this;
        }

        public final Builder m3535c(int i) {
            this.f2248c = i;
            return this;
        }

        public final Builder m3533a(String str) {
            this.f2250e = str;
            return this;
        }

        public final Builder m3531a(NicknamesMap nicknamesMap) {
            this.f2251f = nicknamesMap;
            return this;
        }

        public final ThreadCustomization m3536g() {
            return new ThreadCustomization(this);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ThreadCustomization() {
        this.f2253b = 0;
        this.f2254c = 0;
        this.f2255d = 0;
        this.f2256e = 0;
        this.f2257f = null;
        this.f2258g = new NicknamesMap();
    }

    public ThreadCustomization(Builder builder) {
        this.f2253b = builder.f2246a;
        this.f2254c = builder.f2247b;
        this.f2255d = builder.f2248c;
        this.f2256e = builder.f2249d;
        this.f2257f = builder.f2250e;
        this.f2258g = builder.f2251f;
    }

    public ThreadCustomization(Parcel parcel) {
        this.f2253b = parcel.readInt();
        this.f2254c = parcel.readInt();
        this.f2255d = parcel.readInt();
        this.f2256e = parcel.readInt();
        this.f2257f = parcel.readString();
        this.f2258g = (NicknamesMap) parcel.readParcelable(NicknamesMap.class.getClassLoader());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("wallpaperColor", StringFormatUtil.formatStrLocaleSafe("%x", Integer.valueOf(this.f2253b))).add("meBubbleColor", StringFormatUtil.formatStrLocaleSafe("%x", Integer.valueOf(this.f2254c))).add("otherBubbleColor", StringFormatUtil.formatStrLocaleSafe("%x", Integer.valueOf(this.f2255d))).add("emojilikeString", this.f2257f).add("nicknamesMap", this.f2258g).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ThreadCustomization threadCustomization = (ThreadCustomization) obj;
        if (this.f2253b == threadCustomization.f2253b && this.f2254c == threadCustomization.f2254c && this.f2255d == threadCustomization.f2255d && StringUtil.a(this.f2257f, threadCustomization.f2257f) && this.f2258g.equals(threadCustomization.f2258g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (((this.f2253b * 31) + this.f2254c) * 31) + this.f2255d;
        if (this.f2257f != null) {
            i = (i * 31) + this.f2257f.hashCode();
        }
        return (i * 31) + this.f2258g.hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2253b);
        parcel.writeInt(this.f2254c);
        parcel.writeInt(this.f2255d);
        parcel.writeInt(this.f2256e);
        parcel.writeString(this.f2257f);
        parcel.writeParcelable(this.f2258g, i);
    }
}
