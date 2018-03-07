package com.facebook.graphql.cursor;

import android.support.v4.util.LongSparseArray;
import com.facebook.flatbuffers.Flattenable;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Singleton;

@Singleton
/* compiled from: meta_info */
public class CursorModelCache {
    private static volatile CursorModelCache f7891b;
    @GuardedBy("mCache")
    private final LongSparseArray<Entry> f7892a = new LongSparseArray();

    public static com.facebook.graphql.cursor.CursorModelCache m8182a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7891b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.graphql.cursor.CursorModelCache.class;
        monitor-enter(r1);
        r0 = f7891b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m8183b();	 Catch:{ all -> 0x0034 }
        f7891b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7891b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.cursor.CursorModelCache.a(com.facebook.inject.InjectorLike):com.facebook.graphql.cursor.CursorModelCache");
    }

    private static CursorModelCache m8183b() {
        return new CursorModelCache();
    }

    final void m8186a(long j, long j2, Flattenable flattenable) {
        Preconditions.checkNotNull(Long.valueOf(j));
        synchronized (this.f7892a) {
            this.f7892a.b(j, new Entry(flattenable, j2));
        }
    }

    @Nullable
    final Flattenable m8184a(long j, long j2) {
        Preconditions.checkNotNull(Long.valueOf(j));
        synchronized (this.f7892a) {
            Entry entry = (Entry) this.f7892a.a(j);
        }
        if (entry == null) {
            return null;
        }
        Flattenable flattenable = (Flattenable) entry.a.get();
        if (flattenable == null) {
            synchronized (this.f7892a) {
                this.f7892a.c(j);
            }
            return null;
        } else if (j2 != entry.b) {
            return null;
        } else {
            return flattenable;
        }
    }

    public final void m8185a() {
        synchronized (this.f7892a) {
            this.f7892a.b();
        }
    }
}
