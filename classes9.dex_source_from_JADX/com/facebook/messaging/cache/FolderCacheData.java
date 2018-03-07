package com.facebook.messaging.cache;

import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadSummaryByDateComparator;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: method/messaging.setsettings */
public class FolderCacheData {
    private static final String f9491a = FolderCacheData.class.getSimpleName();
    private final FolderName f9492b;
    public final ThreadsCacheLock f9493c;
    public final MapWithSecondaryOrdering<ThreadKey, ThreadSummary> f9494d;
    private boolean f9495e;
    private boolean f9496f;
    private boolean f9497g;
    private long f9498h = -1;
    private FolderCounts f9499i = FolderCounts.a;

    FolderCacheData(FolderName folderName, ThreadsCacheLock threadsCacheLock) {
        this.f9492b = folderName;
        this.f9493c = threadsCacheLock;
        this.f9494d = new MapWithSecondaryOrdering(new ThreadSummaryByDateComparator());
    }

    public final MapWithSecondaryOrdering<ThreadKey, ThreadSummary> m10077a() {
        this.f9493c.b();
        return this.f9494d;
    }

    public final boolean m10085b() {
        this.f9493c.b();
        return this.f9495e;
    }

    public final void m10082a(boolean z) {
        this.f9493c.b();
        this.f9495e = z;
    }

    public final boolean m10087c() {
        this.f9493c.b();
        return this.f9496f;
    }

    public final void m10084b(boolean z) {
        this.f9493c.b();
        this.f9496f = z;
    }

    public final boolean m10088d() {
        this.f9493c.b();
        return this.f9497g;
    }

    public final void m10086c(boolean z) {
        this.f9493c.b();
        this.f9497g = z;
    }

    public final long m10089e() {
        this.f9493c.b();
        return this.f9498h;
    }

    public final void m10079a(long j) {
        this.f9493c.b();
        this.f9498h = j;
    }

    public final FolderCounts m10090f() {
        this.f9493c.b();
        return this.f9499i;
    }

    public final void m10080a(FolderCounts folderCounts) {
        this.f9493c.b();
        if (folderCounts == null) {
            BLog.c(f9491a, "Passed in null folder counts!");
            this.f9499i = FolderCounts.a;
            return;
        }
        this.f9499i = folderCounts;
    }

    public final void m10091g() {
        this.f9493c.b();
        this.f9494d.clear();
    }

    public final void m10081a(ThreadSummary threadSummary) {
        this.f9493c.b();
        Preconditions.checkArgument(this.f9492b.equals(threadSummary.A));
        this.f9494d.put(threadSummary.a, threadSummary);
    }

    final void m10083b(ThreadSummary threadSummary) {
        long j;
        this.f9493c.b();
        Preconditions.checkArgument(this.f9492b.equals(threadSummary.A));
        this.f9493c.b();
        List list = this.f9494d.e;
        if (list.isEmpty()) {
            j = -1;
        } else {
            j = ((ThreadSummary) list.get(list.size() - 1)).k;
        }
        long j2 = j;
        if (threadSummary.k > j2) {
            this.f9494d.put(threadSummary.a, threadSummary);
        } else if (threadSummary.k == j2 && m10078a(threadSummary.a) != null) {
            this.f9494d.put(threadSummary.a, threadSummary);
        }
    }

    @Nullable
    public final ThreadSummary m10078a(ThreadKey threadKey) {
        this.f9493c.b();
        return (ThreadSummary) this.f9494d.remove(threadKey);
    }

    public final void m10092h() {
        this.f9493c.b();
        this.f9494d.clear();
        this.f9496f = false;
        this.f9498h = -1;
        this.f9497g = false;
        this.f9499i = FolderCounts.a;
    }
}
