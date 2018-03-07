package com.facebook.timeline.cache.db;

import android.content.Context;
import com.facebook.database.advancedsupplier.AdvancedAbstractDatabaseSupplier;
import com.facebook.database.threadchecker.DbThreadChecker;
import com.facebook.database.threadchecker.DbThreadCheckerDisallowUiThread;
import com.facebook.database.userchecker.DbUserChecker;
import com.facebook.database.userchecker.DbUserCheckerDefault;
import com.facebook.graphql.executor.filemap.FlatBufferDirectorySizeLimiter;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: us-ascii */
public class TimelineDatabaseSupplier extends AdvancedAbstractDatabaseSupplier {
    private static volatile TimelineDatabaseSupplier f808b;
    private final FlatBufferDirectorySizeLimiter f809a;

    public static com.facebook.timeline.cache.db.TimelineDatabaseSupplier m845a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f808b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.cache.db.TimelineDatabaseSupplier.class;
        monitor-enter(r1);
        r0 = f808b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m846b(r0);	 Catch:{ all -> 0x0035 }
        f808b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f808b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.cache.db.TimelineDatabaseSupplier.a(com.facebook.inject.InjectorLike):com.facebook.timeline.cache.db.TimelineDatabaseSupplier");
    }

    private static TimelineDatabaseSupplier m846b(InjectorLike injectorLike) {
        return new TimelineDatabaseSupplier((Context) injectorLike.getInstance(Context.class), (DbThreadChecker) DbThreadCheckerDisallowUiThread.a(injectorLike), (DbUserChecker) DbUserCheckerDefault.a(injectorLike), TimelineDbSchemaPart.m869a(injectorLike), FlatBufferDirectorySizeLimiter.a(injectorLike));
    }

    @Inject
    public TimelineDatabaseSupplier(Context context, DbThreadChecker dbThreadChecker, DbUserChecker dbUserChecker, TimelineDbSchemaPart timelineDbSchemaPart, FlatBufferDirectorySizeLimiter flatBufferDirectorySizeLimiter) {
        super(context, dbThreadChecker, dbUserChecker, ImmutableList.of(timelineDbSchemaPart), "timeline_db");
        this.f809a = flatBufferDirectorySizeLimiter;
    }

    protected final int m848c() {
        return 51200;
    }

    public final long m847b() {
        return this.f809a.a(2097152, 6291456);
    }
}
