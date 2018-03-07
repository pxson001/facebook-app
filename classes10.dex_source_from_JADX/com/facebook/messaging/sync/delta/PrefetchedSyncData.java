package com.facebook.messaging.sync.delta;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: profile_relationship_type */
public class PrefetchedSyncData implements Parcelable {
    public static final Creator<PrefetchedSyncData> CREATOR = new C06501();
    public static final PrefetchedSyncData f4424a = new PrefetchedSyncData(RegularImmutableBiMap.a, RegularImmutableList.a, RegularImmutableSet.a);
    public final ImmutableMap<ThreadKey, ThreadSummary> f4425b;
    public final ImmutableList<ThreadKey> f4426c;
    public final ImmutableSet<ThreadKey> f4427d;

    /* compiled from: profile_relationship_type */
    final class C06501 implements Creator<PrefetchedSyncData> {
        C06501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PrefetchedSyncData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PrefetchedSyncData[i];
        }
    }

    public PrefetchedSyncData(ImmutableMap<ThreadKey, ThreadSummary> immutableMap, ImmutableList<ThreadKey> immutableList, ImmutableSet<ThreadKey> immutableSet) {
        this.f4425b = immutableMap;
        this.f4426c = immutableList;
        this.f4427d = immutableSet;
    }

    public PrefetchedSyncData(Parcel parcel) {
        this.f4425b = ImmutableMap.copyOf(parcel.readHashMap(PrefetchedSyncData.class.getClassLoader()));
        this.f4426c = ImmutableList.copyOf(parcel.readArrayList(PrefetchedSyncData.class.getClassLoader()));
        this.f4427d = ImmutableSet.copyOf(parcel.readArrayList(PrefetchedSyncData.class.getClassLoader()));
    }

    public final ThreadSummary m3994a(ThreadKey threadKey) {
        return (ThreadSummary) this.f4425b.get(threadKey);
    }

    public String toString() {
        return Objects.toStringHelper(PrefetchedSyncData.class).add("threadSummariesByThreadKey", this.f4425b).add("threadsFetchedFromServer", this.f4426c).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f4425b);
        parcel.writeList(this.f4426c);
        parcel.writeList(this.f4427d.asList());
    }
}
