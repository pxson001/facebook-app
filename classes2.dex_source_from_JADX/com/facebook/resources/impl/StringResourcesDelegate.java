package com.facebook.resources.impl;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.init.INeedInit;
import com.facebook.common.locale.Locales;
import com.facebook.common.locale.SupportedLanguages;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.languages.Fb4aSupportedLanguages;
import com.facebook.resources.Resources_BaseResourcesMethodAutoProvider;
import com.facebook.resources.impl.loading.AssetLanguagePackLoaderDelegate;
import com.facebook.resources.impl.loading.DownloadableLanguagePackLoaderDelegate;
import com.facebook.resources.impl.loading.LanguagePackLoader;
import com.facebook.resources.impl.loading.LanguagePackLoader.Delegate;
import com.facebook.resources.impl.loading.LanguagePackLoaderProvider;
import com.facebook.resources.impl.loading.LanguageRequest;
import com.facebook.resources.impl.loading.LanguageRequest.Type;
import com.facebook.resources.impl.model.PluralCategory;
import com.facebook.resources.impl.model.StringResources;
import com.facebook.resources.impl.model.StringResources.ResourceNotFoundException;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.gender.Gender;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: value_model_holder-jni */
public class StringResourcesDelegate implements INeedInit {
    private static volatile StringResourcesDelegate f1318z;
    private final Context f1319a;
    public final Resources f1320b;
    private final Lazy<AppVersionInfo> f1321c;
    public final FbResourcesLogger f1322d;
    public final Lazy<TranslationsPolicyProvider> f1323e;
    private final LanguagePackLoaderProvider f1324f;
    private final Lazy<AssetLanguagePackLoaderDelegate> f1325g;
    private final Lazy<DownloadableLanguagePackLoaderDelegate> f1326h;
    private final Provider<Gender> f1327i;
    private AtomicReference<Locale> f1328j = new AtomicReference();
    private final C01001 f1329k = new C01001(this);
    private volatile boolean f1330l = true;
    private volatile boolean f1331m = false;
    public final AtomicReference<StringResources> f1332n = new AtomicReference();
    public final AtomicReference<StringResources> f1333o = new AtomicReference();
    private final AtomicReference<LanguagePackLoader> f1334p = new AtomicReference();
    private final AtomicReference<LanguagePackLoader> f1335q = new AtomicReference();
    @GuardedBy("this")
    public SettableFuture<Void> f1336r;
    public final SettableFuture<Void> f1337s = SettableFuture.m1547f();
    private final AbstractFbErrorReporter f1338t;
    private final Locales f1339u;
    private final SupportedLanguages f1340v;
    private final Fetcher<String> f1341w = new C01013(this);
    private final Fetcher<String> f1342x = new C01024(this);
    private final Fetcher<String[]> f1343y = new C01035(this);

    /* compiled from: value_model_holder-jni */
    public class C01001 {
        final /* synthetic */ StringResourcesDelegate f1435a;

        C01001(StringResourcesDelegate stringResourcesDelegate) {
            this.f1435a = stringResourcesDelegate;
        }
    }

    /* compiled from: value_model_holder-jni */
    class C01013 implements Fetcher<String> {
        final /* synthetic */ StringResourcesDelegate f1436a;

        C01013(StringResourcesDelegate stringResourcesDelegate) {
            this.f1436a = stringResourcesDelegate;
        }

        public final Object mo372b(int i, PluralCategory pluralCategory, Gender gender) {
            return ((StringResources) this.f1436a.f1333o.get()).m5062a(i, gender);
        }

        public final Object mo371a(int i, PluralCategory pluralCategory, Gender gender) {
            return ((StringResources) this.f1436a.f1332n.get()).m5062a(i, gender);
        }

        public final Object mo370a(int i, int i2) {
            return this.f1436a.f1320b.getString(i);
        }
    }

    /* compiled from: value_model_holder-jni */
    interface Fetcher<T> {
        T mo370a(int i, int i2);

        T mo371a(int i, PluralCategory pluralCategory, Gender gender);

        T mo372b(int i, PluralCategory pluralCategory, Gender gender);
    }

    /* compiled from: value_model_holder-jni */
    class C01024 implements Fetcher<String> {
        final /* synthetic */ StringResourcesDelegate f1437a;

        C01024(StringResourcesDelegate stringResourcesDelegate) {
            this.f1437a = stringResourcesDelegate;
        }

        public final Object mo372b(int i, PluralCategory pluralCategory, Gender gender) {
            return ((StringResources) this.f1437a.f1333o.get()).m5063a(i, gender, pluralCategory);
        }

        public final Object mo371a(int i, PluralCategory pluralCategory, Gender gender) {
            return ((StringResources) this.f1437a.f1332n.get()).m5063a(i, gender, pluralCategory);
        }

        public final Object mo370a(int i, int i2) {
            return this.f1437a.f1320b.getQuantityString(i, i2);
        }
    }

    /* compiled from: value_model_holder-jni */
    class C01035 implements Fetcher<String[]> {
        final /* synthetic */ StringResourcesDelegate f1438a;

        C01035(StringResourcesDelegate stringResourcesDelegate) {
            this.f1438a = stringResourcesDelegate;
        }

        public final Object mo372b(int i, PluralCategory pluralCategory, Gender gender) {
            return ((StringResources) this.f1438a.f1333o.get()).m5064b(i, gender);
        }

        public final Object mo371a(int i, PluralCategory pluralCategory, Gender gender) {
            return ((StringResources) this.f1438a.f1332n.get()).m5064b(i, gender);
        }

        public final Object mo370a(int i, int i2) {
            return this.f1438a.f1320b.getStringArray(i);
        }
    }

    /* compiled from: value_model_holder-jni */
    public enum Source {
        DOWNLOADED("downloaded"),
        ASSET("asset");
        
        private final String mLoggingValue;

        private Source(String str) {
            this.mLoggingValue = str;
        }

        public final String getLoggingValue() {
            return this.mLoggingValue;
        }
    }

    public static com.facebook.resources.impl.StringResourcesDelegate m2562a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1318z;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.StringResourcesDelegate.class;
        monitor-enter(r1);
        r0 = f1318z;	 Catch:{ all -> 0x003a }
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
        r0 = m2566b(r0);	 Catch:{ all -> 0x0035 }
        f1318z = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1318z;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.StringResourcesDelegate.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.StringResourcesDelegate");
    }

    private static StringResourcesDelegate m2566b(InjectorLike injectorLike) {
        return new StringResourcesDelegate((Context) injectorLike.getInstance(Context.class), Resources_BaseResourcesMethodAutoProvider.m2599b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 879), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3282), (LanguagePackLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(LanguagePackLoaderProvider.class), IdBasedLazy.m1808a(injectorLike, 3283), IdBasedLazy.m1808a(injectorLike, 3284), FbResourcesLogger.m2736a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), Locales.m2604a(injectorLike), Fb4aSupportedLanguages.m2617a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3594));
    }

    @Inject
    public StringResourcesDelegate(Context context, Resources resources, Lazy<AppVersionInfo> lazy, Lazy<TranslationsPolicyProvider> lazy2, LanguagePackLoaderProvider languagePackLoaderProvider, Lazy<AssetLanguagePackLoaderDelegate> lazy3, Lazy<DownloadableLanguagePackLoaderDelegate> lazy4, FbResourcesLogger fbResourcesLogger, FbErrorReporter fbErrorReporter, Locales locales, SupportedLanguages supportedLanguages, Provider<Gender> provider) {
        this.f1319a = context;
        this.f1320b = resources;
        this.f1321c = lazy;
        this.f1322d = fbResourcesLogger;
        this.f1324f = languagePackLoaderProvider;
        this.f1325g = lazy3;
        this.f1326h = lazy4;
        this.f1323e = lazy2;
        this.f1338t = fbErrorReporter;
        this.f1339u = locales;
        this.f1340v = supportedLanguages;
        this.f1327i = provider;
    }

    public void init() {
        this.f1339u.m2611a(this.f1329k);
        this.f1328j.set(m2573k());
        m2577a();
        this.f1331m = true;
        m2572j();
    }

    public final void m2577a() {
        boolean z;
        Locale b = m2578b();
        if (((TranslationsPolicyProvider) this.f1323e.get()).m4959a(m2578b()) || ((TranslationsPolicyProvider) this.f1323e.get()).m4960b(b)) {
            z = true;
        } else {
            z = false;
        }
        this.f1330l = z;
        m2564a(Source.ASSET);
        m2564a(Source.DOWNLOADED);
    }

    private void m2564a(Source source) {
        boolean a;
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        if (source == Source.ASSET) {
            a = ((TranslationsPolicyProvider) this.f1323e.get()).m4959a(m2578b());
            atomicReference = this.f1332n;
            atomicReference2 = this.f1334p;
        } else {
            a = ((TranslationsPolicyProvider) this.f1323e.get()).m4960b(m2578b());
            atomicReference = this.f1333o;
            atomicReference2 = this.f1335q;
        }
        if (a && atomicReference.get() == null) {
            synchronized (this) {
                if (atomicReference2.get() != null) {
                    return;
                }
                m2571i();
                final LanguageRequest languageRequest = new LanguageRequest(Type.NORMAL, this.f1319a, m2578b(), (AppVersionInfo) this.f1321c.get());
                atomicReference2.set(this.f1324f.m2734a(languageRequest, m2567b(source)));
                final Source source2 = source;
                Futures.m2458a(((LanguagePackLoader) atomicReference2.get()).m5042a(), new FutureCallback<StringResources>(this) {
                    final /* synthetic */ StringResourcesDelegate f3062e;

                    public void onSuccess(Object obj) {
                        StringResources stringResources = (StringResources) obj;
                        atomicReference2.set(null);
                        StringResourcesDelegate.m2565a(this.f3062e, source2, languageRequest, stringResources, atomicReference);
                    }

                    public void onFailure(Throwable th) {
                        atomicReference2.set(null);
                        StringResourcesDelegate stringResourcesDelegate = this.f3062e;
                        Source source = source2;
                        LanguageRequest languageRequest = languageRequest;
                        FbResourcesLogger fbResourcesLogger = stringResourcesDelegate.f1322d;
                        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("fbresources_loading_failure");
                        honeyClientEvent.m5090b("source", source.getLoggingValue());
                        honeyClientEvent.m5090b("locale", languageRequest.m4962d());
                        if (th != null) {
                            honeyClientEvent.m5090b("error", th.toString());
                        }
                        ((AnalyticsLogger) fbResourcesLogger.f1433b.get()).mo526a(honeyClientEvent);
                        stringResourcesDelegate.f1336r.mo222a(th);
                    }
                }, MoreExecutors.m1813a());
            }
        } else if (!a && atomicReference.get() != null) {
            atomicReference.set(null);
        }
    }

    private Delegate m2567b(Source source) {
        return source == Source.ASSET ? (Delegate) this.f1325g.get() : (Delegate) this.f1326h.get();
    }

    private synchronized void m2571i() {
        if (this.f1336r == null || this.f1336r.isDone()) {
            this.f1336r = SettableFuture.m1547f();
        }
    }

    private void m2572j() {
        if (this.f1331m && m2581e()) {
            FutureDetour.a(this.f1337s, null, -1586130467);
        }
    }

    public static synchronized void m2565a(StringResourcesDelegate stringResourcesDelegate, Source source, LanguageRequest languageRequest, StringResources stringResources, AtomicReference atomicReference) {
        synchronized (stringResourcesDelegate) {
            atomicReference.set(stringResources);
            stringResourcesDelegate.f1322d.m2743a(source, languageRequest);
            if (stringResourcesDelegate.m2581e()) {
                FutureDetour.a(stringResourcesDelegate.f1336r, null, 340578804);
            }
            stringResourcesDelegate.m2572j();
        }
    }

    public final Locale m2578b() {
        return (Locale) this.f1328j.get();
    }

    public final CharSequence m2575a(int i) {
        return (CharSequence) m2563a(this.f1341w, i, 0, null);
    }

    public final String[] m2579b(int i) {
        return (String[]) m2563a(this.f1343y, i, 0, null);
    }

    public final CharSequence m2576a(int i, int i2, PluralCategory pluralCategory) {
        return (CharSequence) m2563a(this.f1342x, i, i2, pluralCategory);
    }

    private <T> T m2563a(Fetcher<T> fetcher, int i, int i2, @Nullable PluralCategory pluralCategory) {
        if (!(this.f1331m || !m2568c(i) || m2569d(i))) {
            m2570e(i);
        }
        if (!this.f1330l || !m2568c(i)) {
            return fetcher.mo370a(i, i2);
        }
        StringResources stringResources = (StringResources) this.f1333o.get();
        StringResources stringResources2 = (StringResources) this.f1332n.get();
        if (stringResources2 == null && stringResources == null) {
            this.f1322d.m2764m();
            return fetcher.mo370a(i, i2);
        }
        if (stringResources != null) {
            try {
                return fetcher.mo372b(i, pluralCategory, (Gender) this.f1327i.get());
            } catch (ResourceNotFoundException e) {
            }
        }
        if (stringResources2 != null) {
            try {
                return fetcher.mo371a(i, pluralCategory, (Gender) this.f1327i.get());
            } catch (ResourceNotFoundException e2) {
            }
        }
        return fetcher.mo370a(i, i2);
    }

    public final synchronized ListenableFuture<Void> m2580c() {
        return this.f1336r;
    }

    public final boolean m2581e() {
        if (!this.f1330l) {
            return true;
        }
        boolean z;
        boolean z2;
        boolean b = ((TranslationsPolicyProvider) this.f1323e.get()).m4960b(m2578b());
        boolean a = ((TranslationsPolicyProvider) this.f1323e.get()).m4959a(m2578b());
        if (this.f1333o.get() != null) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1332n.get() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (b && a) {
            if (z2 || z) {
                return true;
            }
            return false;
        } else if (b) {
            return z;
        } else {
            if (a) {
                return z2;
            }
            return true;
        }
    }

    private boolean m2568c(int i) {
        return this.f1320b.getResourcePackageName(i).equals(this.f1319a.getPackageName());
    }

    private boolean m2569d(int i) {
        return this.f1320b.getResourceName(i).endsWith("string/common_google_play_services_unknown_issue");
    }

    private void m2570e(int i) {
        String a = StringFormatUtil.a("StringResourcesDelegate used before initialized: resource %s requested", new Object[]{this.f1320b.getResourceName(i)});
        AbstractFbErrorReporter abstractFbErrorReporter = this.f1338t;
        SoftErrorBuilder a2 = SoftError.a("string_resources_delegate", a);
        a2.d = true;
        abstractFbErrorReporter.mo336a(a2.g());
    }

    public final void m2582f() {
        Locale k = m2573k();
        if (this.f1331m && !k.equals(this.f1328j.getAndSet(k))) {
            m2574l();
        }
    }

    public final void m2583g() {
        ((TranslationsPolicyProvider) this.f1323e.get()).f3007b.set(Boolean.valueOf(true));
        m2574l();
    }

    private Locale m2573k() {
        Locale b = this.f1339u.m2612b();
        if ("fil".equals(b.getLanguage())) {
            return new Locale("tl", b.getCountry());
        }
        return b;
    }

    private void m2574l() {
        this.f1332n.set(null);
        this.f1333o.set(null);
        m2577a();
    }
}
