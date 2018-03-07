package com.facebook.api.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: response */
public class FeedOffScreenAdsFetchXConfig extends XConfig {
    public static final XConfigName f7023c = new XConfigName("fb4a_feed_offscreen_ads_fetch_xconfig");
    public static final XConfigSetting f7024d = new XConfigSetting(f7023c, "max_hscroll_ads_in_feed_fetch");
    public static final XConfigSetting f7025e = new XConfigSetting(f7023c, "off_screen_ads_storyset_using_graphql_batch");
    public static final XConfigSetting f7026f = new XConfigSetting(f7023c, "num_ads_in_first_fetch_storyset");
    public static final XConfigSetting f7027g = new XConfigSetting(f7023c, "off_screen_ads_pyml_using_graphql_batch");
    public static final XConfigSetting f7028h = new XConfigSetting(f7023c, "num_ads_in_first_fetch_pyml");
    public static final ImmutableSet<XConfigSetting> f7029i = ImmutableSet.of(f7024d, f7025e, f7026f, f7027g, f7028h);
    private static volatile FeedOffScreenAdsFetchXConfig f7030j;

    public static com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig m11579a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7030j;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig.class;
        monitor-enter(r1);
        r0 = f7030j;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m11578a();	 Catch:{ all -> 0x0034 }
        f7030j = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f7030j;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig");
    }

    private static FeedOffScreenAdsFetchXConfig m11578a() {
        return new FeedOffScreenAdsFetchXConfig();
    }

    @Inject
    public FeedOffScreenAdsFetchXConfig() {
        super(f7023c, f7029i);
    }
}
