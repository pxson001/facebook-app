package com.facebook.pages.browser.data.fetcher;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.browser.data.methods.FetchRecommendedPagesInCategory.Params;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: subtopic_id */
public class PagesBrowserDataFetcher {
    private static volatile PagesBrowserDataFetcher f1251c;
    private final DefaultBlueServiceOperationFactory f1252a;
    private final FeedbackGraphQLGenerator f1253b;

    public static com.facebook.pages.browser.data.fetcher.PagesBrowserDataFetcher m1813a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1251c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.browser.data.fetcher.PagesBrowserDataFetcher.class;
        monitor-enter(r1);
        r0 = f1251c;	 Catch:{ all -> 0x003a }
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
        r0 = m1815b(r0);	 Catch:{ all -> 0x0035 }
        f1251c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1251c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.browser.data.fetcher.PagesBrowserDataFetcher.a(com.facebook.inject.InjectorLike):com.facebook.pages.browser.data.fetcher.PagesBrowserDataFetcher");
    }

    private static PagesBrowserDataFetcher m1815b(InjectorLike injectorLike) {
        return new PagesBrowserDataFetcher(DefaultBlueServiceOperationFactory.b(injectorLike), FeedbackGraphQLGenerator.a(injectorLike));
    }

    @Inject
    public PagesBrowserDataFetcher(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, FeedbackGraphQLGenerator feedbackGraphQLGenerator) {
        this.f1252a = defaultBlueServiceOperationFactory;
        this.f1253b = feedbackGraphQLGenerator;
    }

    private ListenableFuture<OperationResult> m1814a(Parcelable parcelable, String str, String str2) {
        Bundle bundle = new Bundle();
        if (parcelable != null) {
            bundle.putParcelable(str, parcelable);
        }
        return BlueServiceOperationFactoryDetour.a(this.f1252a, str2, bundle, 1830530088).a();
    }

    public final ListenableFuture<OperationResult> m1816a() {
        return m1814a(null, null, "fetch_initial_recommended_pages");
    }

    public final ListenableFuture<OperationResult> m1817a(Params params) {
        return m1814a(params, "fetchRecommendedPagesInCategory", "fetch_recommended_pages_in_category");
    }
}
