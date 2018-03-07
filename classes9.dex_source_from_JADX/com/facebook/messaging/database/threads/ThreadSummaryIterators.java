package com.facebook.messaging.database.threads;

import android.content.ContentResolver;
import android.database.DatabaseUtils;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.ConjunctionExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.google.common.collect.ObjectArrays;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_hours_back */
public class ThreadSummaryIterators {
    private static final Class<?> f10646a = ThreadSummaryIterators.class;
    private static final String[] f10647e = ((String[]) ObjectArrays.a(ThreadSummaryCursorUtil.a, "timestamp_in_folder_ms"));
    private static final String[] f10648f = ((String[]) ObjectArrays.a(ThreadSummaryCursorUtil.a, "pinned_threads_display_order"));
    private static volatile ThreadSummaryIterators f10649g;
    private final ContentResolver f10650b;
    private final Provider<MessagesDbContract> f10651c;
    private final ThreadSummaryCursorUtil f10652d;

    public static com.facebook.messaging.database.threads.ThreadSummaryIterators m11164a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10649g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.database.threads.ThreadSummaryIterators.class;
        monitor-enter(r1);
        r0 = f10649g;	 Catch:{ all -> 0x003a }
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
        r0 = m11165b(r0);	 Catch:{ all -> 0x0035 }
        f10649g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10649g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.database.threads.ThreadSummaryIterators.a(com.facebook.inject.InjectorLike):com.facebook.messaging.database.threads.ThreadSummaryIterators");
    }

    private static ThreadSummaryIterators m11165b(InjectorLike injectorLike) {
        return new ThreadSummaryIterators(ContentResolverMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 7810), ThreadSummaryCursorUtil.a(injectorLike));
    }

    @Inject
    public ThreadSummaryIterators(ContentResolver contentResolver, Provider<MessagesDbContract> provider, ThreadSummaryCursorUtil threadSummaryCursorUtil) {
        this.f10650b = contentResolver;
        this.f10651c = provider;
        this.f10652d = threadSummaryCursorUtil;
    }

    public final ThreadSummaryCursorUtil$Iterator m11167a(FolderName folderName, long j, int i) {
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.a("folder", folderName.dbName));
        if (j > 0) {
            a.a(SqlExpression.c("timestamp_in_folder_ms", Long.toString(j)));
        }
        String str = "timestamp_in_folder_ms DESC";
        if (i > 0) {
            str = str + " LIMIT " + i;
        }
        return this.f10652d.a(this.f10650b.query(((MessagesDbContract) this.f10651c.get()).f10547c.m11142a(), f10647e, a.a(), a.b(), str), true);
    }

    public final ThreadSummaryCursorUtil$Iterator m11169a(String str, @Nullable Collection<ThreadKey> collection) {
        ConjunctionExpression a = SqlExpression.a();
        a.a(SqlExpression.a("folder", FolderName.INBOX.dbName));
        if (!(collection == null || collection.isEmpty())) {
            a.a(SqlExpression.a("thread_key", collection));
        }
        a.a(SqlExpression.b("name LIKE " + DatabaseUtils.sqlEscapeString("%" + str + '%')));
        a.a();
        return this.f10652d.a(this.f10650b.query(((MessagesDbContract) this.f10651c.get()).f10547c.m11142a(), f10647e, a.a(), a.b(), "timestamp_in_folder_ms DESC"), true);
    }

    public final ThreadSummaryCursorUtil$Iterator m11166a() {
        return this.f10652d.a(this.f10650b.query(((MessagesDbContract) this.f10651c.get()).f10547c.m11142a(), f10648f, null, null, "pinned_threads_display_order"), false);
    }

    public final ThreadSummaryCursorUtil$Iterator m11168a(String str, int i) {
        Expression d = SqlExpression.d("thread_key", Type.GROUP.dbValue + "%");
        String str2 = str + " DESC";
        if (i > 0) {
            str2 = str2 + " LIMIT " + i;
        }
        return this.f10652d.a(this.f10650b.query(((MessagesDbContract) this.f10651c.get()).f10547c.m11142a(), ThreadSummaryCursorUtil.a, d.a(), d.b(), str2), false);
    }

    public final ThreadSummaryCursorUtil$Iterator m11170a(Set<ThreadKey> set) {
        Expression a = SqlExpression.a("thread_key", set);
        return this.f10652d.a(this.f10650b.query(((MessagesDbContract) this.f10651c.get()).f10547c.m11142a(), ThreadSummaryCursorUtil.a, a.a(), a.b(), null), false);
    }
}
