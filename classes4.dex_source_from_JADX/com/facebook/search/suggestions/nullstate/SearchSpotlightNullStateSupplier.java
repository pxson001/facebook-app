package com.facebook.search.suggestions.nullstate;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.NullStateStatus;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.model.GapTypeaheadUnit;
import com.facebook.search.model.GapTypeaheadUnit.BackgroundType;
import com.facebook.search.model.SearchSpotlightCollectionUnit;
import com.facebook.search.model.SuggestionGroup.Builder;
import com.facebook.search.model.SuggestionGroup.Type;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.model.converter.SearchSpotlightGraphQLModelConverter;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.TutorialNuxConfigurationModel;
import com.facebook.search.quickpromotion.C0428xd9b074b7;
import com.facebook.search.quickpromotion.SearchAwarenessTutorialNuxConfigurationLoader;
import com.facebook.search.quickpromotion.SearchSpotlightConfigurationValidator;
import com.facebook.search.suggestions.SuggestionsListRowItemFactory;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: liveCommentLogDelayParamsKey */
public class SearchSpotlightNullStateSupplier extends NullStateSupplier implements C0428xd9b074b7 {
    private static volatile SearchSpotlightNullStateSupplier f9285k;
    private final GatekeeperStoreImpl f9286a;
    private final Context f9287b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessTutorialNuxConfigurationLoader> f9288c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchSpotlightConfigurationValidator> f9289d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SuggestionsListRowItemFactory> f9290e = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchSpotlightGraphQLModelConverter> f9291f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphSearchErrorReporter> f9292g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<Clock> f9293h = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbSharedPreferences> f9294i = UltralightRuntime.b;
    private ImmutableList<TypeaheadUnit> f9295j;

    public static com.facebook.search.suggestions.nullstate.SearchSpotlightNullStateSupplier m9665a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9285k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.nullstate.SearchSpotlightNullStateSupplier.class;
        monitor-enter(r1);
        r0 = f9285k;	 Catch:{ all -> 0x003a }
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
        r0 = m9667b(r0);	 Catch:{ all -> 0x0035 }
        f9285k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9285k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.nullstate.SearchSpotlightNullStateSupplier.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.nullstate.SearchSpotlightNullStateSupplier");
    }

    private static SearchSpotlightNullStateSupplier m9667b(InjectorLike injectorLike) {
        SearchSpotlightNullStateSupplier searchSpotlightNullStateSupplier = new SearchSpotlightNullStateSupplier(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
        searchSpotlightNullStateSupplier.m9666a(IdBasedLazy.a(injectorLike, 10521), IdBasedLazy.a(injectorLike, 10525), IdBasedSingletonScopeProvider.b(injectorLike, 3387), IdBasedSingletonScopeProvider.b(injectorLike, 10506), IdBasedSingletonScopeProvider.b(injectorLike, 3374), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedSingletonScopeProvider.b(injectorLike, 3078));
        return searchSpotlightNullStateSupplier;
    }

    @Inject
    private SearchSpotlightNullStateSupplier(GatekeeperStoreImpl gatekeeperStoreImpl, Context context) {
        this.f9286a = gatekeeperStoreImpl;
        this.f9287b = context;
    }

    public final NullStateStatus m9673c() {
        return this.f9295j == null ? NullStateStatus.NOT_READY : NullStateStatus.READY;
    }

    public final boolean m9671a() {
        return this.f9286a.a(SearchAbTestGatekeepers.y, false);
    }

    public final void m9668a(@Nullable CallerContext callerContext, NullStateSupplier$RefreshPolicy nullStateSupplier$RefreshPolicy) {
        if (((FbSharedPreferences) this.f9294i.get()).a(SearchAwarenessPrefKeys.h, 0) <= ((Clock) this.f9293h.get()).a()) {
            ((SearchAwarenessTutorialNuxConfigurationLoader) this.f9288c.get()).d = this;
            ((SearchAwarenessTutorialNuxConfigurationLoader) this.f9288c.get()).b();
            return;
        }
        this.f9295j = RegularImmutableList.a;
    }

    public final void m9672b() {
        this.f9295j = null;
    }

    public Object get() {
        return this.f9295j;
    }

    public final void mo747a(TutorialNuxConfigurationModel tutorialNuxConfigurationModel) {
        long a;
        Editor edit = ((FbSharedPreferences) this.f9294i.get()).edit();
        PrefKey prefKey = SearchAwarenessPrefKeys.h;
        if (tutorialNuxConfigurationModel.l()) {
            a = ((Clock) this.f9293h.get()).a() + 86400000;
        } else {
            a = ((Clock) this.f9293h.get()).a() + (((long) tutorialNuxConfigurationModel.j()) * 3600000);
        }
        edit.a(prefKey, a).commit();
        if (((SearchSpotlightConfigurationValidator) this.f9289d.get()).a(tutorialNuxConfigurationModel)) {
            ImmutableList a2 = ((SearchSpotlightGraphQLModelConverter) this.f9291f.get()).a(tutorialNuxConfigurationModel.a());
            if (a2 == null || a2.isEmpty()) {
                this.f9295j = RegularImmutableList.a;
                return;
            }
            this.f9290e.get();
            Builder builder = new Builder();
            builder.a = Type.NS_SEARCH_SPOTLIGHT;
            builder = builder;
            builder.c = this.f9287b.getResources().getString(2131237427);
            builder = builder;
            builder.b = ImmutableList.of(new SearchSpotlightCollectionUnit(a2), new GapTypeaheadUnit(BackgroundType.GRAY));
            this.f9295j = SuggestionsListRowItemFactory.m9621b(ImmutableList.of(builder.a()));
        }
    }

    private void m9666a(com.facebook.inject.Lazy<SearchAwarenessTutorialNuxConfigurationLoader> lazy, com.facebook.inject.Lazy<SearchSpotlightConfigurationValidator> lazy2, com.facebook.inject.Lazy<SuggestionsListRowItemFactory> lazy3, com.facebook.inject.Lazy<SearchSpotlightGraphQLModelConverter> lazy4, com.facebook.inject.Lazy<GraphSearchErrorReporter> lazy5, com.facebook.inject.Lazy<Clock> lazy6, com.facebook.inject.Lazy<FbSharedPreferences> lazy7) {
        this.f9288c = lazy;
        this.f9289d = lazy2;
        this.f9290e = lazy3;
        this.f9291f = lazy4;
        this.f9292g = lazy5;
        this.f9293h = lazy6;
        this.f9294i = lazy7;
    }

    public final void mo746a(GraphSearchException graphSearchException) {
        ((GraphSearchErrorReporter) this.f9292g.get()).a(graphSearchException);
    }
}
