package com.facebook.api.feed.xconfig;

import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: set_privacy_education_state */
public class FreshFeedConfigReader extends BaseFeedConfigReader {
    private static volatile FreshFeedConfigReader f5189a;

    public static com.facebook.api.feed.xconfig.FreshFeedConfigReader m9080a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5189a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feed.xconfig.FreshFeedConfigReader.class;
        monitor-enter(r1);
        r0 = f5189a;	 Catch:{ all -> 0x003a }
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
        r0 = m9081b(r0);	 Catch:{ all -> 0x0035 }
        f5189a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5189a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.xconfig.FreshFeedConfigReader.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.xconfig.FreshFeedConfigReader");
    }

    private static FreshFeedConfigReader m9081b(InjectorLike injectorLike) {
        return new FreshFeedConfigReader(XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public FreshFeedConfigReader(XConfigReader xConfigReader) {
        super(xConfigReader, FreshFeedConfig.f5220v.size(), FreshFeedConfig.f5221w.size(), FreshFeedConfig.f5222x.size(), 0, FreshFeedConfig.f5223y.size());
    }

    public final String m9082a(String str) {
        return m9088a(FreshFeedConfig.f5204f, 0, str);
    }

    public final int m9085e(int i) {
        return m9087a(FreshFeedConfig.f5208j, 5, i);
    }

    public final int m9086f(int i) {
        return m9087a(FreshFeedConfig.f5210l, 7, i);
    }

    public final boolean m9083b(boolean z) {
        return m9089a(FreshFeedConfig.f5217s, 1, z);
    }

    public final boolean m9084c(boolean z) {
        return m9089a(FreshFeedConfig.f5218t, 2, z);
    }
}
