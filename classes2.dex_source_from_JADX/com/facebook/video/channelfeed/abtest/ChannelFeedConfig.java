package com.facebook.video.channelfeed.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: schedule_interval */
public class ChannelFeedConfig {
    private static volatile ChannelFeedConfig f6033r;
    public final boolean f6034a;
    public final int f6035b;
    public final int f6036c;
    public final int f6037d;
    public final int f6038e;
    public final int f6039f;
    public final boolean f6040g;
    public final boolean f6041h;
    public final boolean f6042i;
    public final boolean f6043j;
    public final boolean f6044k;
    public final boolean f6045l;
    public final boolean f6046m;
    public final boolean f6047n;
    public final boolean f6048o;
    public final boolean f6049p;
    public final boolean f6050q;

    public static com.facebook.video.channelfeed.abtest.ChannelFeedConfig m10184a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6033r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.channelfeed.abtest.ChannelFeedConfig.class;
        monitor-enter(r1);
        r0 = f6033r;	 Catch:{ all -> 0x003a }
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
        r0 = m10185b(r0);	 Catch:{ all -> 0x0035 }
        f6033r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6033r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.channelfeed.abtest.ChannelFeedConfig.a(com.facebook.inject.InjectorLike):com.facebook.video.channelfeed.abtest.ChannelFeedConfig");
    }

    private static ChannelFeedConfig m10185b(InjectorLike injectorLike) {
        return new ChannelFeedConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public ChannelFeedConfig(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6034a = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6054d, gatekeeperStoreImpl.m2189a(475, false));
        this.f6035b = qeAccessor.mo572a(ExperimentsForChannelFeedAbTestModule.f6059i, 20);
        this.f6036c = qeAccessor.mo572a(ExperimentsForChannelFeedAbTestModule.f6055e, 5);
        this.f6037d = qeAccessor.mo572a(ExperimentsForChannelFeedAbTestModule.f6061k, 20);
        this.f6038e = qeAccessor.mo572a(ExperimentsForChannelFeedAbTestModule.f6056f, 2);
        this.f6039f = qeAccessor.mo572a(ExperimentsForChannelFeedAbTestModule.f6060j, 3);
        this.f6040g = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6062l, false);
        this.f6041h = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6058h, false);
        this.f6042i = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6057g, false);
        this.f6043j = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6052b, gatekeeperStoreImpl.m2189a(25, false));
        this.f6044k = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6064n, false);
        this.f6045l = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6063m, false);
        this.f6046m = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6065o, false);
        this.f6047n = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6067q, false);
        this.f6048o = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6051a, gatekeeperStoreImpl.m2189a(27, false));
        this.f6049p = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6053c, true);
        this.f6050q = qeAccessor.mo596a(ExperimentsForChannelFeedAbTestModule.f6066p, gatekeeperStoreImpl.m2189a(26, false));
    }
}
