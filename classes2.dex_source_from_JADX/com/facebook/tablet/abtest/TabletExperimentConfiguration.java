package com.facebook.tablet.abtest;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sponsored */
public class TabletExperimentConfiguration {
    private static volatile TabletExperimentConfiguration f4248c;
    private final Boolean f4249a;
    private final boolean f4250b;

    public static com.facebook.tablet.abtest.TabletExperimentConfiguration m7856a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4248c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.abtest.TabletExperimentConfiguration.class;
        monitor-enter(r1);
        r0 = f4248c;	 Catch:{ all -> 0x003a }
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
        r0 = m7857b(r0);	 Catch:{ all -> 0x0035 }
        f4248c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4248c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.abtest.TabletExperimentConfiguration.a(com.facebook.inject.InjectorLike):com.facebook.tablet.abtest.TabletExperimentConfiguration");
    }

    private static TabletExperimentConfiguration m7857b(InjectorLike injectorLike) {
        return new TabletExperimentConfiguration(Boolean_IsTabletMethodAutoProvider.m7864a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike));
    }

    @Inject
    public TabletExperimentConfiguration(Boolean bool, Boolean bool2) {
        this.f4249a = bool;
        this.f4250b = bool2.booleanValue();
    }

    public final boolean m7858a() {
        return this.f4249a.booleanValue();
    }

    public final boolean m7859b() {
        return m7858a();
    }

    public final boolean m7860c() {
        return m7859b();
    }

    public final boolean m7861e() {
        return m7859b();
    }

    public final boolean m7862h() {
        return m7859b();
    }

    public final boolean m7863i() {
        return m7858a() && !this.f4250b;
    }
}
