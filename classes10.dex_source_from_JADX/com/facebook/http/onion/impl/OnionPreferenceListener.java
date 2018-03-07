package com.facebook.http.onion.impl;

import android.content.Intent;
import com.facebook.http.onion.OnionRewriter;
import com.facebook.http.onion.OnionRewriter.RuleChangeListener;
import com.facebook.http.onion.prefs.OnionPrefKeys;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.PrefKey;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SurveyPromotionBannerView_Uninitialized_Controller */
public class OnionPreferenceListener implements OnSharedPreferenceChangeListener {
    private static volatile OnionPreferenceListener f23358f;
    private final Lazy<OnionRewriter> f23359a;
    public final Lazy<OnionUtils> f23360b;
    public final Lazy<FbSharedPreferences> f23361c;
    public final Lazy<OnionAnalyticsLogger> f23362d;
    public final Lazy<OrbotLauncher> f23363e;

    /* compiled from: SurveyPromotionBannerView_Uninitialized_Controller */
    public class C33681 implements Runnable {
        final /* synthetic */ OnionPreferenceListener f23357a;

        public C33681(OnionPreferenceListener onionPreferenceListener) {
            this.f23357a = onionPreferenceListener;
        }

        public void run() {
            if (((OnionUtils) this.f23357a.f23360b.get()).g() && ((OnionUtils) this.f23357a.f23360b.get()).c()) {
                OnionPreferenceListener.m24685a(this.f23357a, OnionPrefKeys.c, false);
            }
        }
    }

    public static com.facebook.http.onion.impl.OnionPreferenceListener m24684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f23358f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.impl.OnionPreferenceListener.class;
        monitor-enter(r1);
        r0 = f23358f;	 Catch:{ all -> 0x003a }
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
        r0 = m24686b(r0);	 Catch:{ all -> 0x0035 }
        f23358f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23358f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.OnionPreferenceListener.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.impl.OnionPreferenceListener");
    }

    private static OnionPreferenceListener m24686b(InjectorLike injectorLike) {
        return new OnionPreferenceListener(IdBasedSingletonScopeProvider.b(injectorLike, 3078), IdBasedSingletonScopeProvider.b(injectorLike, 2273), IdBasedSingletonScopeProvider.b(injectorLike, 2271), IdBasedSingletonScopeProvider.b(injectorLike, 7194), IdBasedLazy.a(injectorLike, 7191));
    }

    @Inject
    public OnionPreferenceListener(Lazy<FbSharedPreferences> lazy, Lazy<OnionUtils> lazy2, Lazy<OnionRewriter> lazy3, Lazy<OrbotLauncher> lazy4, Lazy<OnionAnalyticsLogger> lazy5) {
        this.f23359a = lazy3;
        this.f23360b = lazy2;
        this.f23361c = lazy;
        this.f23363e = lazy4;
        this.f23362d = lazy5;
    }

    public final void m24688a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        m24685a(this, prefKey, true);
    }

    public static void m24685a(OnionPreferenceListener onionPreferenceListener, PrefKey prefKey, boolean z) {
        boolean c = ((OnionUtils) onionPreferenceListener.f23360b.get()).c();
        boolean z2 = c && ((OnionUtils) onionPreferenceListener.f23360b.get()).d();
        if (prefKey.equals(OnionPrefKeys.c)) {
            OrbotLauncher orbotLauncher;
            if (c) {
                orbotLauncher = (OrbotLauncher) onionPreferenceListener.f23363e.get();
                orbotLauncher.f23369e.b();
                orbotLauncher.f23366b.m24668f();
                Intent intent = new Intent("org.torproject.android.intent.action.START");
                intent.setPackage("org.torproject.android");
                intent.putExtra("org.torproject.android.intent.extra.PACKAGE_NAME", orbotLauncher.f23368d);
                orbotLauncher.f23367c.a(intent);
            } else {
                orbotLauncher = (OrbotLauncher) onionPreferenceListener.f23363e.get();
                orbotLauncher.f23369e.c();
                orbotLauncher.f23366b.m24670h();
            }
            onionPreferenceListener.m24687b(z2);
            if (z) {
                ((OnionAnalyticsLogger) onionPreferenceListener.f23362d.get()).m24680a(c);
            }
        } else if (prefKey.equals(OnionPrefKeys.b)) {
            onionPreferenceListener.m24687b(z2);
            if (z) {
                ((OnionAnalyticsLogger) onionPreferenceListener.f23362d.get()).m24682b(z2);
            }
        }
    }

    private void m24687b(boolean z) {
        FbOnionRewriter fbOnionRewriter = (FbOnionRewriter) this.f23359a.get();
        fbOnionRewriter.b = z;
        for (RuleChangeListener e : fbOnionRewriter.g) {
            e.e();
        }
    }
}
