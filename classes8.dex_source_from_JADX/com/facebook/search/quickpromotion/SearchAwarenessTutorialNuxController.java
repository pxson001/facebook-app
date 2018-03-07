package com.facebook.search.quickpromotion;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxConfigurationLoader.OnConfigurationFetchedListener;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Preconditions;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: TE2;>; */
public class SearchAwarenessTutorialNuxController implements OnConfigurationFetchedListener {
    private static volatile SearchAwarenessTutorialNuxController f22460m;
    @Inject
    volatile Provider<FbErrorReporter> f22461a = UltralightRuntime.a;
    @Inject
    public volatile Provider<FbSharedPreferences> f22462b = UltralightRuntime.a;
    @Inject
    volatile Provider<GatekeeperStore> f22463c = UltralightRuntime.a;
    @Inject
    volatile Provider<SecureContextHelper> f22464d = UltralightRuntime.a;
    @Inject
    private SearchAwarenessTutorialNuxAssetManagerProvider f22465e;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessTutorialNuxConfigurationLoader> f22466f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessTutorialNuxConfigurationValidator> f22467g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessOptOutController> f22468h = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<InterstitialManager> f22469i = UltralightRuntime.b;
    private final Context f22470j;
    private SearchAwarenessTutorialNuxAssetManager f22471k;
    public TutorialNuxConfigurationModel f22472l;

    public static com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController m25941a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22460m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController.class;
        monitor-enter(r1);
        r0 = f22460m;	 Catch:{ all -> 0x003a }
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
        r0 = m25944b(r0);	 Catch:{ all -> 0x0035 }
        f22460m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22460m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController.a(com.facebook.inject.InjectorLike):com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxController");
    }

    private static SearchAwarenessTutorialNuxController m25944b(InjectorLike injectorLike) {
        SearchAwarenessTutorialNuxController searchAwarenessTutorialNuxController = new SearchAwarenessTutorialNuxController((Context) injectorLike.getInstance(Context.class));
        searchAwarenessTutorialNuxController.m25943a(IdBasedSingletonScopeProvider.a(injectorLike, 494), IdBasedSingletonScopeProvider.a(injectorLike, 3078), IdBasedSingletonScopeProvider.a(injectorLike, 2128), IdBasedSingletonScopeProvider.a(injectorLike, 968), (SearchAwarenessTutorialNuxAssetManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessTutorialNuxAssetManagerProvider.class), IdBasedLazy.a(injectorLike, 10521), IdBasedLazy.a(injectorLike, 10522), IdBasedSingletonScopeProvider.b(injectorLike, 10520), IdBasedSingletonScopeProvider.b(injectorLike, 2360));
        return searchAwarenessTutorialNuxController;
    }

    private void m25943a(Provider<FbErrorReporter> provider, Provider<FbSharedPreferences> provider2, Provider<GatekeeperStore> provider3, Provider<SecureContextHelper> provider4, SearchAwarenessTutorialNuxAssetManagerProvider searchAwarenessTutorialNuxAssetManagerProvider, com.facebook.inject.Lazy<SearchAwarenessTutorialNuxConfigurationLoader> lazy, com.facebook.inject.Lazy<SearchAwarenessTutorialNuxConfigurationValidator> lazy2, com.facebook.inject.Lazy<SearchAwarenessOptOutController> lazy3, com.facebook.inject.Lazy<InterstitialManager> lazy4) {
        this.f22461a = provider;
        this.f22462b = provider2;
        this.f22463c = provider3;
        this.f22464d = provider4;
        this.f22465e = searchAwarenessTutorialNuxAssetManagerProvider;
        this.f22466f = lazy;
        this.f22467g = lazy2;
        this.f22468h = lazy3;
        this.f22469i = lazy4;
    }

    @Inject
    private SearchAwarenessTutorialNuxController(Context context) {
        this.f22470j = context;
    }

    public final void m25948a() {
        if (m25952c()) {
            InterstitialTrigger interstitialTrigger = new InterstitialTrigger(Action.SEARCH_TUTORIAL_NUX);
            if (((InterstitialManager) this.f22469i.get()).b(interstitialTrigger, TutorialNuxInterstitialController.class)) {
                m25946d();
                m25942a(interstitialTrigger);
            }
        }
    }

    private void m25942a(InterstitialTrigger interstitialTrigger) {
        Preconditions.checkArgument(m25952c());
        if (m25947e().m25930a()) {
            InterstitialIntentController interstitialIntentController = (InterstitialIntentController) ((InterstitialManager) this.f22469i.get()).a(interstitialTrigger, TutorialNuxInterstitialController.class);
            if (interstitialIntentController != null) {
                Intent a = interstitialIntentController.a(this.f22470j);
                if (a != null) {
                    ((InterstitialManager) this.f22469i.get()).a().a(interstitialIntentController.b());
                    FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) this.f22462b.get();
                    PrefKey a2 = SearchAwarenessPrefKeys.a(interstitialIntentController.b());
                    fbSharedPreferences.edit().a(a2, fbSharedPreferences.a(a2, 0) + 1).commit();
                    SecureContextHelper secureContextHelper = (SecureContextHelper) this.f22464d.get();
                    a.addFlags(268435456);
                    secureContextHelper.a(a, this.f22470j);
                }
            }
        }
    }

    private void m25946d() {
        if (this.f22472l == null) {
            ((SearchAwarenessTutorialNuxConfigurationLoader) this.f22466f.get()).f22455d = this;
            ((SearchAwarenessTutorialNuxConfigurationLoader) this.f22466f.get()).m25933a();
        } else if (!m25947e().m25930a()) {
            m25947e().m25929a(this.f22472l);
        }
    }

    public final boolean m25952c() {
        return ((GatekeeperStoreImpl) this.f22463c.get()).a(SearchAbTestGatekeepers.m, false) && !((SearchAwarenessOptOutController) this.f22468h.get()).m25894a(AwarenessType.TUTORIAL_NUX);
    }

    private boolean m25945c(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        return ((SearchAwarenessTutorialNuxConfigurationValidator) this.f22467g.get()).m25940a(tutorialNuxConfigurationModel);
    }

    public final void m25950a(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        if (m25945c(tutorialNuxConfigurationModel)) {
            this.f22472l = tutorialNuxConfigurationModel;
            m25947e().m25929a(tutorialNuxConfigurationModel);
            m25942a(new InterstitialTrigger(Action.SEARCH_TUTORIAL_NUX));
        }
    }

    public final void m25949a(GraphSearchException graphSearchException) {
        ((AbstractFbErrorReporter) this.f22461a.get()).a("SearchAwareness", graphSearchException);
    }

    public final boolean m25951b(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        boolean c = m25945c(tutorialNuxConfigurationModel);
        if (c) {
            this.f22472l = tutorialNuxConfigurationModel;
        }
        return c;
    }

    private SearchAwarenessTutorialNuxAssetManager m25947e() {
        if (this.f22471k == null) {
            this.f22471k = this.f22465e.m25931a(this.f22470j.getResources().getDisplayMetrics().densityDpi);
        }
        return this.f22471k;
    }
}
