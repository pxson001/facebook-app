package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: upcoming_hosted_count */
public class ThreadsCollection implements Parcelable {
    public static final Creator<ThreadsCollection> CREATOR = new C01271();
    public static final Class<?> f2392a = ThreadsCollection.class;
    public static final ThreadsCollection f2393b = new ThreadsCollection(RegularImmutableList.a, true);
    public final ImmutableList<ThreadSummary> f2394c;
    public final boolean f2395d;

    /* compiled from: upcoming_hosted_count */
    final class C01271 implements Creator<ThreadsCollection> {
        C01271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadsCollection(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadsCollection[i];
        }
    }

    public ThreadsCollection(ImmutableList<ThreadSummary> immutableList, boolean z) {
        this.f2394c = immutableList;
        this.f2395d = z;
        int size = immutableList.size();
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
            if (threadSummary.f2329k > j) {
                BLog.c(f2392a, String.format("Threads were not in order, this timestamp=%d, lastTimestampMs=%d", new Object[]{Long.valueOf(threadSummary.f2329k), Long.valueOf(j)}));
                return;
            }
            j = threadSummary.f2329k;
        }
    }

    public ThreadsCollection(Parcel parcel) {
        this.f2394c = ImmutableList.copyOf(parcel.readArrayList(ThreadSummary.class.getClassLoader()));
        this.f2395d = parcel.readInt() != 0;
    }

    public final ImmutableList<ThreadSummary> m3626b() {
        return this.f2394c;
    }

    public final boolean m3627c() {
        return this.f2395d;
    }

    public final boolean m3628d() {
        return this.f2394c.isEmpty();
    }

    public final int m3629e() {
        return this.f2394c.size();
    }

    public final ThreadSummary m3625a(int i) {
        return (ThreadSummary) this.f2394c.get(i);
    }

    public static ThreadsCollection m3624a(ThreadsCollection threadsCollection, ThreadsCollection threadsCollection2) {
        int i = 0;
        if (threadsCollection.m3628d() && threadsCollection2.m3628d()) {
            return threadsCollection;
        }
        if (threadsCollection.m3628d()) {
            return threadsCollection2;
        }
        if (threadsCollection2.m3628d()) {
            return threadsCollection;
        }
        Set a = Sets.a();
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = threadsCollection.f2394c;
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i2);
            builder.c(threadSummary);
            a.add(threadSummary.f2319a);
        }
        ImmutableList immutableList2 = threadsCollection2.f2394c;
        int size2 = immutableList2.size();
        while (i < size2) {
            threadSummary = (ThreadSummary) immutableList2.get(i);
            if (!a.contains(threadSummary.f2319a)) {
                builder.c(threadSummary);
            }
            i++;
        }
        return new ThreadsCollection(builder.b(), threadsCollection2.f2395d);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f2394c);
        parcel.writeInt(this.f2395d ? 1 : 0);
    }
}
