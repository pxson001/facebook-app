package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLLightweightEventGuestStatus;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import java.util.Map.Entry;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateNuxStatusParams */
public class ThreadEventReminder implements Parcelable, Comparable<ThreadEventReminder> {
    public static final Creator<ThreadEventReminder> CREATOR = new C01211();
    public final String f2267a;
    public final long f2268b;
    public final String f2269c;
    public final boolean f2270d;
    public final ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> f2271e;
    public final boolean f2272f;

    /* compiled from: updateNuxStatusParams */
    final class C01211 implements Creator<ThreadEventReminder> {
        C01211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadEventReminder(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadEventReminder[i];
        }
    }

    /* compiled from: updateNuxStatusParams */
    public class Builder {
        public String f2261a;
        public long f2262b;
        public String f2263c;
        public boolean f2264d;
        public ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> f2265e;
        public boolean f2266f;

        public Builder(ThreadEventReminder threadEventReminder) {
            this.f2261a = threadEventReminder.f2267a;
            this.f2262b = threadEventReminder.f2268b;
            this.f2263c = threadEventReminder.f2269c;
            this.f2264d = threadEventReminder.f2270d;
            this.f2265e = threadEventReminder.f2271e;
            this.f2266f = threadEventReminder.f2272f;
        }

        public final Builder m3541a(String str) {
            this.f2261a = str;
            return this;
        }

        public final Builder m3539a(long j) {
            this.f2262b = j;
            return this;
        }

        public final Builder m3543b(String str) {
            this.f2263c = str;
            return this;
        }

        public final Builder m3542a(boolean z) {
            this.f2264d = z;
            return this;
        }

        public final Builder m3540a(ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> immutableMap) {
            this.f2265e = immutableMap;
            return this;
        }

        public final Builder m3544b(boolean z) {
            this.f2266f = z;
            return this;
        }

        public final ThreadEventReminder m3545g() {
            return new ThreadEventReminder(this);
        }
    }

    public int compareTo(Object obj) {
        ThreadEventReminder threadEventReminder = (ThreadEventReminder) obj;
        long j = this.f2268b;
        long j2 = threadEventReminder.f2268b;
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public ThreadEventReminder(Builder builder) {
        this.f2267a = builder.f2261a;
        this.f2268b = builder.f2262b;
        this.f2269c = builder.f2263c;
        this.f2270d = builder.f2264d;
        this.f2271e = builder.f2265e;
        this.f2272f = builder.f2266f;
    }

    protected ThreadEventReminder(Parcel parcel) {
        ImmutableMap immutableMap;
        boolean z = true;
        this.f2267a = parcel.readString();
        this.f2268b = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f2270d = z;
        this.f2269c = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            immutableMap = null;
        } else {
            com.google.common.collect.ImmutableMap.Builder builder = new com.google.common.collect.ImmutableMap.Builder();
            for (int i = 0; i < readInt; i++) {
                builder.b((UserKey) parcel.readParcelable(UserKey.class.getClassLoader()), GraphQLLightweightEventGuestStatus.fromString(parcel.readString()));
            }
            immutableMap = builder.b();
        }
        this.f2271e = immutableMap;
        this.f2272f = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2267a);
        parcel.writeLong(this.f2268b);
        parcel.writeInt(this.f2270d ? 1 : 0);
        parcel.writeString(this.f2269c);
        ImmutableMap immutableMap = this.f2271e;
        if (immutableMap == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(immutableMap.size());
            for (Entry entry : immutableMap.entrySet()) {
                parcel.writeParcelable((Parcelable) entry.getKey(), i);
                parcel.writeString(entry.getValue() == null ? GraphQLLightweightEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.toString() : ((GraphQLLightweightEventGuestStatus) entry.getValue()).toString());
            }
        }
        ParcelUtil.a(parcel, this.f2272f);
    }

    public final String m3546a() {
        return this.f2267a;
    }

    public final boolean m3547d() {
        return this.f2270d;
    }

    public final ImmutableMap<UserKey, GraphQLLightweightEventGuestStatus> m3548e() {
        return this.f2271e;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ThreadEventReminder) && Objects.equal(this.f2267a, ((ThreadEventReminder) obj).f2267a));
    }

    public int hashCode() {
        return this.f2267a != null ? this.f2267a.hashCode() : 0;
    }
}
