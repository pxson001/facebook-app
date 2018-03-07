package com.facebook.saved.loader;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.earlyfetch.EarlyFetchResult;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.saved.helper.SavedSectionHelper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: intent_result_has_message */
public class SavedDashboardEarlyFetcher extends EarlyFetcher<GraphQLSavedDashboardSectionType, EarlyFetchFutures> {
    private static volatile SavedDashboardEarlyFetcher f9217d;
    private final Lazy<SavedDashboardDataFetcher> f9218a;
    private final Lazy<SavedSectionHelper> f9219b;
    private final GatekeeperStoreImpl f9220c;

    /* compiled from: intent_result_has_message */
    public final class EarlyFetchFutures {
        public final ListenableFuture<SavedDashboardPaginatedSavedItems> f9215a;
        public final ListenableFuture<SavedDashboardPaginatedSavedItems> f9216b;

        public EarlyFetchFutures(ListenableFuture<SavedDashboardPaginatedSavedItems> listenableFuture, ListenableFuture<SavedDashboardPaginatedSavedItems> listenableFuture2) {
            this.f9215a = listenableFuture;
            this.f9216b = listenableFuture2;
        }
    }

    public static com.facebook.saved.loader.SavedDashboardEarlyFetcher m9225a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9217d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.loader.SavedDashboardEarlyFetcher.class;
        monitor-enter(r1);
        r0 = f9217d;	 Catch:{ all -> 0x003a }
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
        r0 = m9226b(r0);	 Catch:{ all -> 0x0035 }
        f9217d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9217d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.loader.SavedDashboardEarlyFetcher.a(com.facebook.inject.InjectorLike):com.facebook.saved.loader.SavedDashboardEarlyFetcher");
    }

    private static SavedDashboardEarlyFetcher m9226b(InjectorLike injectorLike) {
        return new SavedDashboardEarlyFetcher(IdBasedLazy.a(injectorLike, 10431), IdBasedSingletonScopeProvider.b(injectorLike, 10426), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    protected final void m9228a(Object obj) {
        EarlyFetchFutures earlyFetchFutures = (EarlyFetchFutures) obj;
        if (earlyFetchFutures != null) {
            earlyFetchFutures.f9215a.cancel(true);
            earlyFetchFutures.f9216b.cancel(true);
        }
    }

    @Inject
    public SavedDashboardEarlyFetcher(Lazy<SavedDashboardDataFetcher> lazy, Lazy<SavedSectionHelper> lazy2, GatekeeperStore gatekeeperStore) {
        this.f9218a = lazy;
        this.f9219b = lazy2;
        this.f9220c = gatekeeperStore;
    }

    protected final EarlyFetchResult<GraphQLSavedDashboardSectionType, EarlyFetchFutures> m9227a(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        this.f9219b.get();
        GraphQLSavedDashboardSectionType a = SavedSectionHelper.m9179a(extras.getString("extra_section_name"));
        SavedDashboardDataFetcher savedDashboardDataFetcher = (SavedDashboardDataFetcher) this.f9218a.get();
        return new EarlyFetchResult(a, new EarlyFetchFutures(savedDashboardDataFetcher.m9223a(Optional.of(a), Absent.INSTANCE), savedDashboardDataFetcher.m9224b(Optional.of(a), Absent.INSTANCE)));
    }

    protected final boolean m9229b() {
        return !this.f9220c.a(824, false);
    }
}
