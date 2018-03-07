package com.facebook.timeline;

import android.os.Parcelable;
import android.support.v4.util.LongSparseArray;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: groups_seeds_composer_sell_item */
public class TimelineFetchFutures {
    private static volatile TimelineFetchFutures f10204f;
    private final Provider<String> f10205a;
    public final LongSparseArray<Integer> f10206b = new LongSparseArray();
    private String f10207c;
    public long f10208d;
    public GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> f10209e;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: groups_seeds_composer_sell_item */
    public @interface FetchState {
    }

    public static com.facebook.timeline.TimelineFetchFutures m10267a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10204f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.TimelineFetchFutures.class;
        monitor-enter(r1);
        r0 = f10204f;	 Catch:{ all -> 0x003a }
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
        r0 = m10269b(r0);	 Catch:{ all -> 0x0035 }
        f10204f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10204f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.TimelineFetchFutures.a(com.facebook.inject.InjectorLike):com.facebook.timeline.TimelineFetchFutures");
    }

    private static TimelineFetchFutures m10269b(InjectorLike injectorLike) {
        return new TimelineFetchFutures(IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    private TimelineFetchFutures(Provider<String> provider) {
        this.f10205a = provider;
        this.f10207c = (String) provider.get();
    }

    public final boolean m10272a(long j, GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> graphQLQueryFuture) {
        m10268a();
        if (this.f10208d != 0) {
            return false;
        }
        this.f10208d = j;
        this.f10209e = graphQLQueryFuture;
        this.f10206b.b(j, Integer.valueOf(0));
        return true;
    }

    @Nullable
    public final GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> m10270a(long j) {
        m10268a();
        if (j != this.f10208d) {
            return null;
        }
        GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> graphQLQueryFuture = this.f10209e;
        this.f10208d = 0;
        this.f10209e = null;
        return graphQLQueryFuture;
    }

    public final int m10273b(long j) {
        if (this.f10206b.a(j) != null) {
            return ((Integer) this.f10206b.a(j)).intValue();
        }
        return 2;
    }

    public final void m10271a(long j, int i) {
        if (i == 2) {
            this.f10206b.b(j);
        } else {
            this.f10206b.b(j, Integer.valueOf(i));
        }
    }

    private void m10268a() {
        if (!((String) this.f10205a.get()).equals(this.f10207c)) {
            this.f10206b.b();
            this.f10208d = 0;
            if (this.f10209e != null) {
                this.f10209e.cancel(true);
                this.f10209e = null;
            }
            this.f10207c = (String) this.f10205a.get();
        }
    }
}
