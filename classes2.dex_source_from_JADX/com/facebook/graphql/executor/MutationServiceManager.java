package com.facebook.graphql.executor;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LongSparseArray;
import android.util.Pair;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: save_mms_photo */
public class MutationServiceManager {
    private static volatile MutationServiceManager f6262e;
    private final Context f6263a;
    private final Class f6264b;
    @GuardedBy("this")
    private final LongSparseArray<Pair<SettableFuture<GraphQLResult>, MutationRunnerParams>> f6265c = new LongSparseArray();
    @GuardedBy("this")
    private long f6266d = 0;

    public static com.facebook.graphql.executor.MutationServiceManager m10461a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f6262e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.MutationServiceManager.class;
        monitor-enter(r1);
        r0 = f6262e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10462b(r0);	 Catch:{ all -> 0x0035 }
        f6262e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6262e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.MutationServiceManager.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.MutationServiceManager");
    }

    private static MutationServiceManager m10462b(InjectorLike injectorLike) {
        return new MutationServiceManager((Context) injectorLike.getInstance(Context.class), GraphQLMutationService.class);
    }

    @Inject
    public MutationServiceManager(Context context, Class cls) {
        this.f6263a = context;
        Preconditions.checkState(GraphQLMutationService.class.isAssignableFrom(cls));
        this.f6264b = cls;
    }

    public final <T> ListenableFuture<GraphQLResult<T>> m10464a(MutationRunnerParams mutationRunnerParams) {
        ListenableFuture f = SettableFuture.m1547f();
        long a = m10460a(f, mutationRunnerParams);
        Intent intent = new Intent(this.f6263a, this.f6264b);
        intent.putExtra("MUTATION_ID_KEY", a);
        this.f6263a.startService(intent);
        return f;
    }

    private synchronized <T> long m10460a(SettableFuture<GraphQLResult<T>> settableFuture, MutationRunnerParams mutationRunnerParams) {
        this.f6266d++;
        this.f6265c.m4364b(this.f6266d, new Pair(settableFuture, mutationRunnerParams));
        return this.f6266d;
    }

    @Nullable
    public final synchronized Pair<SettableFuture<GraphQLResult>, MutationRunnerParams> m10463a(long j) {
        Pair<SettableFuture<GraphQLResult>, MutationRunnerParams> pair;
        pair = (Pair) this.f6265c.m4358a(j);
        this.f6265c.m4366c(j);
        return pair;
    }
}
