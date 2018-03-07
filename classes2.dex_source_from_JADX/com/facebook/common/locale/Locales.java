package com.facebook.common.locale;

import android.content.res.Resources;
import android.util.LruCache;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.languages.Fb4aSupportedLanguages;
import com.facebook.resources.impl.StringResourcesDelegate.C01001;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Locale;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: validate_payment_card_bin */
public class Locales {
    @VisibleForTesting
    static final Locale f1355a = Locale.US;
    @VisibleForTesting
    static final Locale f1356b = Locale.ENGLISH;
    static final Locale f1357c = new Locale("fb", "HA");
    private static volatile Locales f1358j;
    private final SupportedLanguages f1359d;
    private final C00991 f1360e = new C00991(this);
    public final Provider<Locale> f1361f;
    private final Set<Listener> f1362g;
    private final LruCache<Locale, Locale> f1363h;
    private final LruCache<String, Locale> f1364i;

    /* compiled from: validate_payment_card_bin */
    public class C00991 {
        final /* synthetic */ Locales f1430a;

        C00991(Locales locales) {
            this.f1430a = locales;
        }
    }

    public static com.facebook.common.locale.Locales m2604a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1358j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.locale.Locales.class;
        monitor-enter(r1);
        r0 = f1358j;	 Catch:{ all -> 0x003a }
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
        r0 = m2605b(r0);	 Catch:{ all -> 0x0035 }
        f1358j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1358j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.locale.Locales.a(com.facebook.inject.InjectorLike):com.facebook.common.locale.Locales");
    }

    private static Locales m2605b(InjectorLike injectorLike) {
        return new Locales(Fb4aSupportedLanguages.m2617a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4483));
    }

    @Inject
    public Locales(SupportedLanguages supportedLanguages, Provider<Locale> provider) {
        this.f1359d = supportedLanguages;
        this.f1361f = provider;
        this.f1362g = Sets.m1313a();
        this.f1363h = new LruCache(5);
        this.f1364i = new LruCache(5);
    }

    public final Locale m2609a() {
        Locale h = m2608h();
        ImmutableSet a = this.f1359d.mo364a();
        return (a.isEmpty() || a.contains(h.getLanguage()) || a.contains(m2606b(h).toString()) || h.toString().equals(f1357c.toString())) ? h : f1355a;
    }

    public final Locale m2612b() {
        return m2610a(m2609a());
    }

    public final Locale m2610a(Locale locale) {
        ImmutableSet a = this.f1359d.mo364a();
        if (a.isEmpty()) {
            return locale;
        }
        Locale b = m2606b(locale);
        if (a.contains(b.toString())) {
            return b;
        }
        String language = locale.getLanguage();
        if (!a.contains(language)) {
            return f1356b;
        }
        b = (Locale) this.f1364i.get(language);
        if (b == null) {
            b = new Locale(language);
            this.f1364i.put(language, b);
        }
        return b;
    }

    private Locale m2608h() {
        return (Locale) this.f1361f.get();
    }

    public final String m2613c() {
        return FBLocaleMapper.m9532a(m2612b());
    }

    public final String m2614d() {
        return FBLocaleMapper.m9532a(m2608h());
    }

    public static Locale m2607e() {
        return Resources.getSystem().getConfiguration().locale;
    }

    public final ImmutableSet<String> m2615f() {
        return this.f1359d.mo364a();
    }

    @Deprecated
    public final String m2616g() {
        return ((Locale) this.f1361f.get()).toString();
    }

    public final synchronized void m2611a(C01001 c01001) {
        this.f1362g.add(c01001);
    }

    private Locale m2606b(Locale locale) {
        Locale locale2 = (Locale) this.f1363h.get(locale);
        if (locale2 != null) {
            return locale2;
        }
        locale2 = new Locale(locale.getLanguage(), locale.getCountry());
        this.f1363h.put(locale, locale2);
        return locale2;
    }
}
