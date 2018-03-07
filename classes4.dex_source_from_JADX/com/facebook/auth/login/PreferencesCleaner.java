package com.facebook.auth.login;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.STATICDI_MULTIBIND_PROVIDER$IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.STATICDI_MULTIBIND_PROVIDER$IHavePrivacyCriticalKeysToClear;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: sys_storage_threshold_percentage */
public class PreferencesCleaner extends AbstractAuthComponent {
    private static final Class<?> f1389a = PreferencesCleaner.class;
    private static volatile PreferencesCleaner f1390e;
    private final FbSharedPreferences f1391b;
    private final Set<IHavePrivacyCriticalKeysToClear> f1392c;
    private final Set<IHaveNonCriticalKeysToClear> f1393d;

    public static com.facebook.auth.login.PreferencesCleaner m1627a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1390e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.login.PreferencesCleaner.class;
        monitor-enter(r1);
        r0 = f1390e;	 Catch:{ all -> 0x003a }
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
        r0 = m1628b(r0);	 Catch:{ all -> 0x0035 }
        f1390e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1390e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.login.PreferencesCleaner.a(com.facebook.inject.InjectorLike):com.facebook.auth.login.PreferencesCleaner");
    }

    private static PreferencesCleaner m1628b(InjectorLike injectorLike) {
        return new PreferencesCleaner((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$IHavePrivacyCriticalKeysToClear(injectorLike)), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$IHaveNonCriticalKeysToClear(injectorLike)));
    }

    @Inject
    public PreferencesCleaner(FbSharedPreferences fbSharedPreferences, Set<IHavePrivacyCriticalKeysToClear> set, Set<IHaveNonCriticalKeysToClear> set2) {
        this.f1391b = fbSharedPreferences;
        this.f1392c = set;
        this.f1393d = set2;
    }

    public final void m1629e() {
        Set hashSet = new HashSet();
        for (IHavePrivacyCriticalKeysToClear b : this.f1392c) {
            hashSet.addAll(b.b());
        }
        this.f1391b.a(hashSet);
    }

    public final void m1630f() {
        Set hashSet = new HashSet();
        for (IHaveNonCriticalKeysToClear a : this.f1393d) {
            hashSet.addAll(a.a());
        }
        this.f1391b.a(hashSet);
    }
}
