package com.facebook.controller.connectioncontroller.diskstore;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.support.v4.util.LruCache;
import com.facebook.controller.connectioncontroller.common.AbstractConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionChunk;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.graphql.cursor.database.PageInfo;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: memoText */
public final class CursorConnectionState<T> extends AbstractConnectionState<T> implements Closeable {
    public final ModelCursor f8149a;
    private final ImmutableList<ConnectionChunk> f8150b;
    public final TagTracker<T> f8151c = new TagTracker();
    private final LruCache<Long, T> f8152d;
    private final LookAheadReader f8153e;
    public int f8154f = -1;
    public int f8155g = -1;
    private long f8156h = 0;

    /* compiled from: memoText */
    public class TagTracker<TEdge> {
        @GuardedBy("this")
        private final HashMultimap<String, WeakReference<TEdge>> f8157a = HashMultimap.u();
        @GuardedBy("this")
        private final Set<Long> f8158b = new HashSet();

        TagTracker() {
        }

        public final synchronized ImmutableSet<TEdge> m8423a(String str) {
            Collection hashSet;
            Set<WeakReference> a = this.f8157a.a(str);
            hashSet = new HashSet();
            for (WeakReference weakReference : a) {
                Object obj = weakReference.get();
                if (obj != null) {
                    hashSet.add(obj);
                }
            }
            return ImmutableSet.copyOf(hashSet);
        }

        final synchronized void m8424a(TEdge tEdge, long j, ImmutableSet<String> immutableSet) {
            if (tEdge != null) {
                if (!this.f8158b.contains(Long.valueOf(j))) {
                    this.f8158b.add(Long.valueOf(j));
                    WeakReference weakReference = new WeakReference(tEdge);
                    Iterator it = immutableSet.iterator();
                    while (it.hasNext()) {
                        this.f8157a.a((String) it.next(), weakReference);
                    }
                }
            }
        }
    }

    CursorConnectionState(ModelCursor modelCursor, LruCache<Long, T> lruCache, ExecutorService executorService) {
        this.f8149a = (ModelCursor) Preconditions.checkNotNull(modelCursor);
        this.f8150b = m8413a(modelCursor);
        this.f8152d = lruCache;
        if (executorService == null || lruCache == null) {
            this.f8153e = null;
            return;
        }
        this.f8153e = new LookAheadReader(this, executorService);
        ExecutorDetour.a(executorService, this.f8153e, -1845773234);
    }

    final ModelCursor m8418f() {
        Preconditions.checkState(!this.f8149a.isClosed());
        return this.f8149a;
    }

    private static ImmutableList<ConnectionChunk> m8413a(ModelCursor modelCursor) {
        if (!modelCursor.moveToFirst()) {
            return RegularImmutableList.a;
        }
        ArrayList parcelableArrayList = modelCursor.getExtras().getParcelableArrayList("CHUNKS");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        int size = parcelableArrayList.size();
        for (int i = 0; i < size; i++) {
            PageInfo pageInfo = (PageInfo) parcelableArrayList.get(i);
            builder.c(new ConnectionChunk(new DiskConnectionLocation(pageInfo.a, pageInfo.c, LocationType.BEFORE, pageInfo.e), new DiskConnectionLocation(pageInfo.b, pageInfo.d, LocationType.AFTER, pageInfo.f)));
        }
        return builder.b();
    }

    public final synchronized long m8419g() {
        long j = 0;
        synchronized (this) {
            if (this.f8156h > 0) {
                j = this.f8156h;
            } else {
                ArrayList parcelableArrayList = this.f8149a.getExtras().getParcelableArrayList("CHUNKS");
                if (!(parcelableArrayList == null || parcelableArrayList.isEmpty())) {
                    this.f8156h = ((PageInfo) parcelableArrayList.get(0)).h;
                    j = this.f8156h;
                }
            }
        }
        return j;
    }

    public final synchronized T mo622a(int i) {
        return m8414a(this, i, false);
    }

    public static Object m8414a(CursorConnectionState cursorConnectionState, int i, boolean z) {
        Object a;
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (!z) {
            try {
                cursorConnectionState.f8154f = i;
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        if (i > cursorConnectionState.f8155g) {
            cursorConnectionState.f8155g = i;
        }
        Preconditions.checkState(cursorConnectionState.f8149a.moveToPosition(i));
        long b = cursorConnectionState.f8149a.m8326b();
        if (cursorConnectionState.f8152d != null) {
            a = cursorConnectionState.f8152d.a(Long.valueOf(b));
            if (a != null) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return a;
            }
        }
        a = cursorConnectionState.f8149a.m8328d();
        cursorConnectionState.f8151c.m8424a(a, b, ImmutableSet.copyOf(cursorConnectionState.f8149a.m8331g()));
        if (cursorConnectionState.f8152d != null) {
            cursorConnectionState.f8152d.a(Long.valueOf(b), a);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a;
    }

    public final int mo625d() {
        return this.f8149a.getCount();
    }

    public final ImmutableList<ConnectionChunk> mo626e() {
        return this.f8150b;
    }

    public final void close() {
        if (this.f8153e != null) {
            this.f8153e.a();
        }
        this.f8149a.close();
    }
}
