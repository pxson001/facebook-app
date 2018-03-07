package com.facebook.dialtone;

import com.facebook.common.util.TriState;
import com.facebook.dialtone.gk.IsDialtoneEligibleGK;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import com.facebook.zero.common.UiFeaturesAccessor;
import com.facebook.zero.common.constants.DialtonePrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: today_on_this_day_feed_type */
public class DialtoneUiFeaturesAccessor extends UiFeaturesAccessor {
    public static final PrefKey f2465d = DialtonePrefKeys.f2492o;
    private static volatile DialtoneUiFeaturesAccessor f2466f;
    @IsDialtoneEligibleGK
    private final Provider<TriState> f2467e;

    @Singleton
    /* compiled from: today_on_this_day_feed_type */
    public class OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration extends INeedInitForSharedPrefsListenerRegistration<DialtoneUiFeaturesAccessor> {
        private static volatile OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration f2458b;

        public static com.facebook.dialtone.DialtoneUiFeaturesAccessor.OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration m4670a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f2458b;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.dialtone.DialtoneUiFeaturesAccessor.OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration.class;
            monitor-enter(r1);
            r0 = f2458b;	 Catch:{ all -> 0x003a }
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
            r0 = m4671b(r0);	 Catch:{ all -> 0x0035 }
            f2458b = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2458b;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneUiFeaturesAccessor.OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneUiFeaturesAccessor$OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration");
        }

        private static OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration m4671b(InjectorLike injectorLike) {
            return new OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 1093));
        }

        protected final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
            DialtoneUiFeaturesAccessor dialtoneUiFeaturesAccessor = (DialtoneUiFeaturesAccessor) obj;
            if (prefKey.equals(DialtoneUiFeaturesAccessor.f2465d)) {
                dialtoneUiFeaturesAccessor.m4683b();
            }
        }

        @Inject
        public OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration(Lazy<DialtoneUiFeaturesAccessor> lazy) {
            super((Lazy) lazy, DialtoneUiFeaturesAccessor.f2465d);
        }
    }

    public static com.facebook.dialtone.DialtoneUiFeaturesAccessor m4677a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2466f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.DialtoneUiFeaturesAccessor.class;
        monitor-enter(r1);
        r0 = f2466f;	 Catch:{ all -> 0x003a }
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
        r0 = m4678b(r0);	 Catch:{ all -> 0x0035 }
        f2466f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2466f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneUiFeaturesAccessor.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneUiFeaturesAccessor");
    }

    private static DialtoneUiFeaturesAccessor m4678b(InjectorLike injectorLike) {
        return new DialtoneUiFeaturesAccessor(UiFeatureDataSerializer.m8053b(injectorLike), IdBasedProvider.m1811a(injectorLike, 664));
    }

    @Inject
    public DialtoneUiFeaturesAccessor(UiFeatureDataSerializer uiFeatureDataSerializer, Provider<TriState> provider) {
        super(f2465d, uiFeatureDataSerializer);
        this.f2467e = provider;
    }

    public final boolean m4680c() {
        for (ZeroFeatureKey contains : ZeroFeatureKey.sDialtoneFeatureKeys) {
            if (mo669a().contains(contains)) {
                return true;
            }
        }
        return false;
    }

    protected final ImmutableSet<ZeroFeatureKey> mo669a() {
        if (((TriState) this.f2467e.get()).asBoolean(false)) {
            return super.mo669a();
        }
        this.b = null;
        return RegularImmutableSet.f688a;
    }
}
