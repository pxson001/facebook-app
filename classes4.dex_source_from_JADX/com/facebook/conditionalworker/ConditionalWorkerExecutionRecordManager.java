package com.facebook.conditionalworker;

import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_c2dm */
public class ConditionalWorkerExecutionRecordManager implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f10099a;
    public static final PrefKey f10100b;
    public static final PrefKey f10101c = ((PrefKey) f10099a.a("executed/"));
    private static volatile ConditionalWorkerExecutionRecordManager f10102e;
    public final FbSharedPreferences f10103d;

    public static com.facebook.conditionalworker.ConditionalWorkerExecutionRecordManager m10561a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10102e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.conditionalworker.ConditionalWorkerExecutionRecordManager.class;
        monitor-enter(r1);
        r0 = f10102e;	 Catch:{ all -> 0x003a }
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
        r0 = m10562b(r0);	 Catch:{ all -> 0x0035 }
        f10102e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10102e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.conditionalworker.ConditionalWorkerExecutionRecordManager.a(com.facebook.inject.InjectorLike):com.facebook.conditionalworker.ConditionalWorkerExecutionRecordManager");
    }

    private static ConditionalWorkerExecutionRecordManager m10562b(InjectorLike injectorLike) {
        return new ConditionalWorkerExecutionRecordManager((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a(ConditionalWorkerExecutionRecordManager.class.getName() + "/");
        f10099a = prefKey;
        f10100b = (PrefKey) prefKey.a("failures/");
    }

    @Inject
    public ConditionalWorkerExecutionRecordManager(FbSharedPreferences fbSharedPreferences) {
        this.f10103d = fbSharedPreferences;
    }

    public final int m10563b(@Nonnull ConditionalWorkerInfo conditionalWorkerInfo) {
        return this.f10103d.a((PrefKey) f10100b.a(conditionalWorkerInfo.getClass().getName()), 0);
    }

    public final void m10565d(@Nonnull ConditionalWorkerInfo conditionalWorkerInfo) {
        this.f10103d.edit().a((PrefKey) f10100b.a(conditionalWorkerInfo.getClass().getName())).commit();
    }

    public final boolean m10566g(@Nonnull ConditionalWorkerInfo conditionalWorkerInfo) {
        return this.f10103d.a((PrefKey) f10101c.a(conditionalWorkerInfo.getClass().getName()), false);
    }

    public final ImmutableSet<PrefKey> m10564b() {
        return ImmutableSet.of(f10099a);
    }
}
