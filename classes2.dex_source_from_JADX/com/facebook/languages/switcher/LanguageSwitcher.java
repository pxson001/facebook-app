package com.facebook.languages.switcher;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.init.INeedInit;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.languages.switcher.protocol.SuggestedLocalesMethod;
import com.facebook.languages.switchercommon.LanguageSwitcherCommon;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.resources.FbResources;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_immersive */
public class LanguageSwitcher implements INeedInit, OnSharedPreferenceChangeListener {
    private static final String f2760a = LanguageSwitcher.class.getSimpleName();
    private static volatile LanguageSwitcher f2761p;
    private final Context f2762b;
    private final Lazy<LocaleChangeController> f2763c;
    public final Locales f2764d;
    private final AbstractFbErrorReporter f2765e;
    private final Lazy<FbResources> f2766f;
    private final FbSharedPreferences f2767g;
    private final ListeningExecutorService f2768h;
    private final SecureContextHelper f2769i;
    public final Provider<SingleMethodRunner> f2770j;
    public final SuggestedLocalesMethod f2771k;
    private final LanguageSwitcherCommon f2772l;
    private final LoggedInUserSessionManager f2773m;
    @Nullable
    private String f2774n = null;
    public ListenableFuture f2775o = Futures.m2452a(null);

    public static com.facebook.languages.switcher.LanguageSwitcher m4742a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2761p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.languages.switcher.LanguageSwitcher.class;
        monitor-enter(r1);
        r0 = f2761p;	 Catch:{ all -> 0x003a }
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
        r0 = m4744b(r0);	 Catch:{ all -> 0x0035 }
        f2761p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2761p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.languages.switcher.LanguageSwitcher.a(com.facebook.inject.InjectorLike):com.facebook.languages.switcher.LanguageSwitcher");
    }

    private static LanguageSwitcher m4744b(InjectorLike injectorLike) {
        return new LanguageSwitcher((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2461), Locales.m2604a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3278), FbSharedPreferencesImpl.m1826a(injectorLike), C0055x2995691a.m1881a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2289), SuggestedLocalesMethod.m4753b(injectorLike), LanguageSwitcherCommon.m4758a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike));
    }

    @Inject
    public LanguageSwitcher(Context context, Lazy<LocaleChangeController> lazy, Locales locales, FbErrorReporter fbErrorReporter, Lazy<FbResources> lazy2, FbSharedPreferences fbSharedPreferences, ListeningExecutorService listeningExecutorService, SecureContextHelper secureContextHelper, Provider<SingleMethodRunner> provider, SuggestedLocalesMethod suggestedLocalesMethod, LanguageSwitcherCommon languageSwitcherCommon, LoggedInUserAuthDataStore loggedInUserAuthDataStore) {
        this.f2762b = context;
        this.f2763c = lazy;
        this.f2764d = locales;
        this.f2765e = fbErrorReporter;
        this.f2766f = lazy2;
        this.f2767g = fbSharedPreferences;
        this.f2768h = listeningExecutorService;
        this.f2769i = secureContextHelper;
        this.f2770j = provider;
        this.f2771k = suggestedLocalesMethod;
        this.f2772l = languageSwitcherCommon;
        this.f2773m = loggedInUserAuthDataStore;
        this.f2767g.mo279a(LanguageSwitcherCommonExPrefKeys.f2785b, (OnSharedPreferenceChangeListener) this);
    }

    public void init() {
        m4752f();
    }

    public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        m4752f();
    }

    public static boolean m4743a() {
        if (VERSION.SDK_INT > 11) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String m4748b() {
        LanguageSwitcherCommon languageSwitcherCommon = this.f2772l;
        return LanguageSwitcherCommon.m4761a(languageSwitcherCommon.m4765c(), languageSwitcherCommon.f2779a.m2609a().toString());
    }

    @Nullable
    public final String m4749c() {
        return LanguageSwitcherCommon.m4761a(this.f2772l.m4765c(), Locales.m2607e().toString());
    }

    public final ImmutableCollection<Locale> m4750d() {
        return this.f2772l.m4765c();
    }

    public final ListenableFuture<ImmutableList<String>> m4751e() {
        return this.f2768h.mo271a(new 1(this));
    }

    public final void m4747a(String str) {
        this.f2767g.edit().mo1276a(LanguageSwitcherCommonExPrefKeys.f2785b, str).commit();
        m4752f();
    }

    @VisibleForTesting
    public final void m4752f() {
        if (this.f2767g.mo284a()) {
            Locale a = this.f2764d.m2609a();
            CharSequence locale = a.toString();
            String locale2 = this.f2764d.m2612b().toString();
            if (!StringUtil.m3589a(locale)) {
                ((FbResources) this.f2766f.get()).mo354a(a);
                this.f2772l.m4764a(a);
                this.f2765e.mo345c("app_locale", locale);
                if (!(this.f2774n == null || this.f2774n.equals(locale2))) {
                    this.f2775o = ((LocaleChangeController) this.f2763c.get()).m29102b();
                    if (this.f2773m.m2522b()) {
                        Intent intent = new Intent(this.f2762b, LanguageSwitchActivity.class);
                        intent.addFlags(268435456);
                        intent.addFlags(65536);
                        this.f2769i.mo662a(intent, this.f2762b);
                    }
                }
                this.f2774n = locale2;
                return;
            }
            return;
        }
        this.f2765e.m2340a(f2760a, "LanguageSwitcher.updateAppLocale called before shared prefs initialized.");
    }
}
