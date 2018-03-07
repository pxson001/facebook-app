package com.facebook.search.loader;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.search.protocol.FetchGraphSearchResultDataParams;
import com.facebook.search.protocol.FetchGraphSearchResultDataParams.Builder;
import com.facebook.search.protocol.LogSelectedSuggestionToActivityLogParams;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: There shouldn't be any cache result for PaginationReactionRequestTracker. */
public class GraphSearchDataLoader {
    private static volatile GraphSearchDataLoader f21933b;
    private final DefaultBlueServiceOperationFactory f21934a;

    public static com.facebook.search.loader.GraphSearchDataLoader m25439a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21933b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.loader.GraphSearchDataLoader.class;
        monitor-enter(r1);
        r0 = f21933b;	 Catch:{ all -> 0x003a }
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
        r0 = m25441b(r0);	 Catch:{ all -> 0x0035 }
        f21933b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21933b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.loader.GraphSearchDataLoader.a(com.facebook.inject.InjectorLike):com.facebook.search.loader.GraphSearchDataLoader");
    }

    private static GraphSearchDataLoader m25441b(InjectorLike injectorLike) {
        return new GraphSearchDataLoader(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public GraphSearchDataLoader(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f21934a = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<OperationResult> m25443a(SearchResultsContext searchResultsContext, int i, @Nullable String str) {
        Builder builder = new Builder();
        builder.f7936a = searchResultsContext.mo1212b();
        builder = builder;
        builder.f7939d = i;
        builder = builder;
        builder.f7938c = searchResultsContext.f23369d.b;
        builder = builder;
        if (!Strings.isNullOrEmpty(str)) {
            builder.f7937b = str;
        }
        return m25440a("graph_search_query_result_data", "FetchGraphSearchResultDataParams", (Parcelable) new FetchGraphSearchResultDataParams(builder));
    }

    public final ListenableFuture<OperationResult> m25442a(LogSelectedSuggestionToActivityLogParams logSelectedSuggestionToActivityLogParams) {
        return m25440a("graph_search_log_selected_suggestion_to_activity_log", "logSelectedSuggestionToActivityLogParams", (Parcelable) logSelectedSuggestionToActivityLogParams);
    }

    private ListenableFuture<OperationResult> m25440a(String str, String str2, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(str2, parcelable);
        return BlueServiceOperationFactoryDetour.a(this.f21934a, str, bundle, -825418393).a();
    }
}
