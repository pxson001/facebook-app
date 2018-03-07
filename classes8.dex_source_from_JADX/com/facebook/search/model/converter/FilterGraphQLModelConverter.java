package com.facebook.search.model.converter;

import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.model.NeedleFilter.Builder;
import com.facebook.search.protocol.FB4AGraphSearchUserWithFiltersGraphQLModels.FB4AGraphSearchFilterInfoFragmentModel.MainFilterModel;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TF;>;>;)V */
public class FilterGraphQLModelConverter {
    private static volatile FilterGraphQLModelConverter f22321b;
    private final FilterValueGraphQLModelConverter f22322a;

    public static com.facebook.search.model.converter.FilterGraphQLModelConverter m25802a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22321b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.model.converter.FilterGraphQLModelConverter.class;
        monitor-enter(r1);
        r0 = f22321b;	 Catch:{ all -> 0x003a }
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
        r0 = m25803b(r0);	 Catch:{ all -> 0x0035 }
        f22321b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22321b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.converter.FilterGraphQLModelConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.model.converter.FilterGraphQLModelConverter");
    }

    private static FilterGraphQLModelConverter m25803b(InjectorLike injectorLike) {
        return new FilterGraphQLModelConverter(FilterValueGraphQLModelConverter.m25805a(injectorLike));
    }

    @Inject
    public FilterGraphQLModelConverter(FilterValueGraphQLModelConverter filterValueGraphQLModelConverter) {
        this.f22322a = filterValueGraphQLModelConverter;
    }

    public final NeedleFilter m25804a(MainFilterModel mainFilterModel) {
        Preconditions.checkNotNull(mainFilterModel);
        if (Strings.isNullOrEmpty(mainFilterModel.m8274c())) {
            throw new GraphSearchException(GraphSearchError.FETCH_NEEDLE_FILTERS_FAIL, "Missing ID for needle filter");
        } else if (Strings.isNullOrEmpty(mainFilterModel.m8275d())) {
            throw new GraphSearchException(GraphSearchError.FETCH_NEEDLE_FILTERS_FAIL, "Missing Name for needle filter with id: " + mainFilterModel.m8274c());
        } else if (Strings.isNullOrEmpty(mainFilterModel.ju_())) {
            throw new GraphSearchException(GraphSearchError.FETCH_NEEDLE_FILTERS_FAIL, "Missing Text for needle filter with id: " + mainFilterModel.m8274c());
        } else {
            FilterValue a = mainFilterModel.m8273b() != null ? FilterValueGraphQLModelConverter.m25806a(mainFilterModel.m8273b()) : null;
            Builder builder = new Builder();
            builder.f22167a = mainFilterModel.m8274c();
            builder = builder;
            builder.f22168b = mainFilterModel.m8275d();
            builder = builder;
            builder.f22169c = mainFilterModel.ju_();
            builder = builder;
            builder.f22170d = a;
            return builder.m25678a();
        }
    }
}
