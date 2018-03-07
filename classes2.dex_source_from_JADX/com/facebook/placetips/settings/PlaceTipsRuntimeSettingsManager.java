package com.facebook.placetips.settings;

import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.placetips.settings.graphql.C0638x892114ef;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: maxEntries <= 0 */
public class PlaceTipsRuntimeSettingsManager implements PlaceTipsSettingsChangedListener {
    private static volatile PlaceTipsRuntimeSettingsManager f14965c;
    private final Set<PlaceTipsSettingsChangedListener> f14966a = new HashSet();
    @ForUiThread
    private final Executor f14967b;

    public static com.facebook.placetips.settings.PlaceTipsRuntimeSettingsManager m21404a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14965c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.settings.PlaceTipsRuntimeSettingsManager.class;
        monitor-enter(r1);
        r0 = f14965c;	 Catch:{ all -> 0x003a }
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
        r0 = m21405b(r0);	 Catch:{ all -> 0x0035 }
        f14965c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14965c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.settings.PlaceTipsRuntimeSettingsManager.a(com.facebook.inject.InjectorLike):com.facebook.placetips.settings.PlaceTipsRuntimeSettingsManager");
    }

    private static PlaceTipsRuntimeSettingsManager m21405b(InjectorLike injectorLike) {
        return new PlaceTipsRuntimeSettingsManager(ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike));
    }

    @Inject
    public PlaceTipsRuntimeSettingsManager(Executor executor) {
        this.f14967b = executor;
    }

    public final boolean m21408a(PlaceTipsSettingsChangedListener placeTipsSettingsChangedListener) {
        boolean add;
        Preconditions.checkNotNull(placeTipsSettingsChangedListener);
        synchronized (this.f14966a) {
            add = this.f14966a.add(placeTipsSettingsChangedListener);
        }
        return add;
    }

    public final boolean m21409b(PlaceTipsSettingsChangedListener placeTipsSettingsChangedListener) {
        boolean remove;
        Preconditions.checkNotNull(placeTipsSettingsChangedListener);
        synchronized (this.f14966a) {
            remove = this.f14966a.remove(placeTipsSettingsChangedListener);
        }
        return remove;
    }

    public final void mo2828a(@Nullable C0638x892114ef c0638x892114ef, C0638x892114ef c0638x892114ef2) {
        ExecutorDetour.a(this.f14967b, new 1(this, c0638x892114ef, c0638x892114ef2), 638690944);
    }

    public static void m21406b(@Nullable PlaceTipsRuntimeSettingsManager placeTipsRuntimeSettingsManager, C0638x892114ef c0638x892114ef, C0638x892114ef c0638x892114ef2) {
        synchronized (placeTipsRuntimeSettingsManager.f14966a) {
        }
        for (Object obj : placeTipsRuntimeSettingsManager.f14966a.toArray()) {
            ((PlaceTipsSettingsChangedListener) obj).mo2828a(c0638x892114ef, c0638x892114ef2);
        }
    }
}
