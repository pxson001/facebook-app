package com.facebook.tablet.sideshow.nux;

import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onPageSelected */
public class NuxSideshowUnitType implements SideshowUnitType {
    public static final PrefKey f4700a = ((PrefKey) ((PrefKey) ((PrefKey) SharedPrefKeys.h.a("tablet/")).a("sideshow/")).a("nux_seen"));
    private static volatile NuxSideshowUnitType f4701d;
    private FbSharedPreferences f4702b;
    private TabletExperimentConfiguration f4703c;

    public static com.facebook.tablet.sideshow.nux.NuxSideshowUnitType m5885a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4701d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.nux.NuxSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f4701d;	 Catch:{ all -> 0x003a }
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
        r0 = m5886b(r0);	 Catch:{ all -> 0x0035 }
        f4701d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4701d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.nux.NuxSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.nux.NuxSideshowUnitType");
    }

    private static NuxSideshowUnitType m5886b(InjectorLike injectorLike) {
        return new NuxSideshowUnitType(TabletExperimentConfiguration.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public NuxSideshowUnitType(TabletExperimentConfiguration tabletExperimentConfiguration, FbSharedPreferences fbSharedPreferences) {
        this.f4703c = tabletExperimentConfiguration;
        this.f4702b = fbSharedPreferences;
    }

    public final SideshowUnit m5888a(HostInterfaceImpl hostInterfaceImpl) {
        return new NuxSideshowUnit(hostInterfaceImpl, this.f4702b);
    }

    public final int m5887a(ContentFragmentType contentFragmentType) {
        if (this.f4703c.b() && !this.f4702b.a(f4700a, false) && contentFragmentType == ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT) {
            return 1;
        }
        return 0;
    }
}
