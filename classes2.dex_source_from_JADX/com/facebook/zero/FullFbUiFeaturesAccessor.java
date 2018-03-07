package com.facebook.zero;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.init.INeedInitForSharedPrefsListenerRegistration;
import com.facebook.zero.common.UiFeaturesAccessor;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.util.UiFeatureDataSerializer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tincan_out_dev */
public class FullFbUiFeaturesAccessor extends UiFeaturesAccessor {
    public static final PrefKey f2653d = ZeroPrefKeys.f2625Z;
    private static volatile FullFbUiFeaturesAccessor f2654e;

    @Singleton
    /* compiled from: tincan_out_dev */
    public class OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration extends INeedInitForSharedPrefsListenerRegistration<FullFbUiFeaturesAccessor> {
        private static volatile OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration f2652b;

        public static com.facebook.zero.FullFbUiFeaturesAccessor.OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration m4713a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2652b;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.zero.FullFbUiFeaturesAccessor.OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration.class;
            monitor-enter(r1);
            r0 = f2652b;	 Catch:{ all -> 0x003a }
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
            r0 = m4714b(r0);	 Catch:{ all -> 0x0035 }
            f2652b = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2652b;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.FullFbUiFeaturesAccessor.OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration.a(com.facebook.inject.InjectorLike):com.facebook.zero.FullFbUiFeaturesAccessor$OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration");
        }

        private static OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration m4714b(InjectorLike injectorLike) {
            return new OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3756));
        }

        protected final void mo667a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, Object obj) {
            FullFbUiFeaturesAccessor fullFbUiFeaturesAccessor = (FullFbUiFeaturesAccessor) obj;
            if (prefKey.equals(FullFbUiFeaturesAccessor.f2653d)) {
                fullFbUiFeaturesAccessor.m4683b();
            }
        }

        @Inject
        public OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration(Lazy<FullFbUiFeaturesAccessor> lazy) {
            super((Lazy) lazy, FullFbUiFeaturesAccessor.f2653d);
        }
    }

    public static com.facebook.zero.FullFbUiFeaturesAccessor m4716a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2654e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.FullFbUiFeaturesAccessor.class;
        monitor-enter(r1);
        r0 = f2654e;	 Catch:{ all -> 0x003a }
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
        r0 = m4717b(r0);	 Catch:{ all -> 0x0035 }
        f2654e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2654e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.FullFbUiFeaturesAccessor.a(com.facebook.inject.InjectorLike):com.facebook.zero.FullFbUiFeaturesAccessor");
    }

    private static FullFbUiFeaturesAccessor m4717b(InjectorLike injectorLike) {
        return new FullFbUiFeaturesAccessor(UiFeatureDataSerializer.m8053b(injectorLike));
    }

    @Inject
    public FullFbUiFeaturesAccessor(UiFeatureDataSerializer uiFeatureDataSerializer) {
        super(f2653d, uiFeatureDataSerializer);
    }
}
