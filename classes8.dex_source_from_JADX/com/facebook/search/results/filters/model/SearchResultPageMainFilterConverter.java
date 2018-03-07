package com.facebook.search.results.filters.model;

import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment.MainFilter;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValueNodeFragmentModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel.EdgesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Singleton;

@Singleton
/* compiled from: SLIDESHOW_PREVIEW_STOP */
public class SearchResultPageMainFilterConverter {
    private static volatile SearchResultPageMainFilterConverter f22859a;

    public static com.facebook.search.results.filters.model.SearchResultPageMainFilterConverter m26515a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f22859a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.results.filters.model.SearchResultPageMainFilterConverter.class;
        monitor-enter(r1);
        r0 = f22859a;	 Catch:{ all -> 0x0039 }
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
        r0 = m26514a();	 Catch:{ all -> 0x0034 }
        f22859a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22859a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.results.filters.model.SearchResultPageMainFilterConverter.a(com.facebook.inject.InjectorLike):com.facebook.search.results.filters.model.SearchResultPageMainFilterConverter");
    }

    private static SearchResultPageMainFilterConverter m26514a() {
        return new SearchResultPageMainFilterConverter();
    }

    public static ImmutableList<? extends MainFilter> m26516a(ImmutableList<? extends SearchResultPageMainFilterFragment> immutableList) {
        if (immutableList == null) {
            return null;
        }
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(m26517b(((SearchResultPageMainFilterFragmentModel) immutableList.get(i)).m10196a()));
        }
        return builder.b();
    }

    private static MainFilterModel m26517b(MainFilterModel mainFilterModel) {
        boolean z = true;
        int i = 0;
        if (mainFilterModel.m10186c() == null) {
            return mainFilterModel;
        }
        ImmutableList a = mainFilterModel.m10187d().m10165a();
        int size = a.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            if (((EdgesModel) a.get(i2)).m10160a().m10147a()) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        SearchResultPageFilterValueNodeFragmentModel.Builder builder = new SearchResultPageFilterValueNodeFragmentModel.Builder();
        if (z2) {
            z = false;
        }
        builder.f8695a = z;
        builder.f8696b = mainFilterModel.m10186c();
        builder.f8697c = "default";
        SearchResultPageFilterValueNodeFragmentModel a2 = builder.m10140a();
        EdgesModel.Builder builder2 = new EdgesModel.Builder();
        builder2.f8702a = a2;
        EdgesModel a3 = builder2.m10153a();
        Builder builder3 = new Builder();
        builder3.c(a3);
        ImmutableList a4 = mainFilterModel.m10187d().m10165a();
        i2 = a4.size();
        while (i < i2) {
            builder3.c(EdgesModel.m10156a((EdgesModel) a4.get(i)));
            i++;
        }
        FilterValuesModel.Builder builder4 = new FilterValuesModel.Builder();
        builder4.f8701a = builder3.b();
        FilterValuesModel a5 = builder4.m10151a();
        MainFilterModel.Builder a6 = MainFilterModel.Builder.m10177a(MainFilterModel.m10181a(mainFilterModel));
        a6.f8710c = a5;
        return a6.m10178a();
    }
}
