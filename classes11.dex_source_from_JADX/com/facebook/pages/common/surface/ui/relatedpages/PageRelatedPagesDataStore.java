package com.facebook.pages.common.surface.ui.relatedpages;

import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

@Singleton
/* compiled from: reg_native_app_open */
public class PageRelatedPagesDataStore {
    private static volatile PageRelatedPagesDataStore f2685b;
    public final Map<String, GraphQLPagesYouMayLikeFeedUnit> f2686a = new HashMap();

    public static com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesDataStore m3627a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2685b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesDataStore.class;
        monitor-enter(r1);
        r0 = f2685b;	 Catch:{ all -> 0x0039 }
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
        r0 = m3626a();	 Catch:{ all -> 0x0034 }
        f2685b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2685b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesDataStore.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.surface.ui.relatedpages.PageRelatedPagesDataStore");
    }

    private static PageRelatedPagesDataStore m3626a() {
        return new PageRelatedPagesDataStore();
    }

    public final void m3628a(String str) {
        this.f2686a.remove(str);
    }

    public final GraphQLPagesYouMayLikeFeedUnit m3629b(String str) {
        return (GraphQLPagesYouMayLikeFeedUnit) this.f2686a.get(str);
    }
}
