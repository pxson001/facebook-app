package com.facebook.search.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;
import com.facebook.search.prefs.SearchAwarenessPrefKeys;
import com.facebook.search.protocol.awareness.SearchAwareness.LearningNuxConfigurationString;
import com.facebook.search.protocol.awareness.SearchAwarenessInterfaces.SearchAwarenessSuggestionFieldsFragment;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.LearningNuxConfigurationModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.SearchAwarenessRootSuggestionFieldsFragmentModel;
import com.facebook.search.quickpromotion.SearchAwarenessLearningNuxConfigurationLoader.1;
import com.facebook.search.quickpromotion.SearchAwarenessLearningNuxConfigurationLoader.2;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Singleton;

@Singleton
/* compiled from: show_grey_facebook_badge_nux */
public class SearchAwarenessController {
    private static volatile SearchAwarenessController f4877q;
    private final SearchBarTooltipControllerProvider f4878a;
    private final SearchBarFormattedTooltipControllerProvider f4879b;
    private SearchAwarenessNullStateControllerProvider f4880c;
    private final SearchAwarenessSearchResultsUnitControllerProvider f4881d;
    private final SearchAwarenessUnitValidator f4882e;
    public final QeAccessor f4883f;
    public final Map<GraphQLSearchAwarenessTemplatesEnum, SearchAwarenessUnitProperties> f4884g;
    public final Map<GraphQLSearchAwarenessTemplatesEnum, AwarenessUnitController> f4885h;
    private View f4886i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchQPTooltipController> f4887j = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchAwarenessTutorialNuxController> f4888k = UltralightRuntime.f368b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SearchAwarenessLearningNuxConfigurationLoader> f4889l = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f4890m = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbSharedPreferences> f4891n = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f4892o = UltralightRuntime.f368b;
    public LearningNuxConfigurationModel f4893p;

    public static com.facebook.search.quickpromotion.SearchAwarenessController m8743a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4877q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.quickpromotion.SearchAwarenessController.class;
        monitor-enter(r1);
        r0 = f4877q;	 Catch:{ all -> 0x003a }
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
        r0 = m8745b(r0);	 Catch:{ all -> 0x0035 }
        f4877q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4877q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.quickpromotion.SearchAwarenessController.a(com.facebook.inject.InjectorLike):com.facebook.search.quickpromotion.SearchAwarenessController");
    }

    private static SearchAwarenessController m8745b(InjectorLike injectorLike) {
        SearchAwarenessController searchAwarenessController = new SearchAwarenessController((SearchBarTooltipControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchBarTooltipControllerProvider.class), (SearchBarFormattedTooltipControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchBarFormattedTooltipControllerProvider.class), (SearchAwarenessNullStateControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessNullStateControllerProvider.class), (SearchAwarenessSearchResultsUnitControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessSearchResultsUnitControllerProvider.class), new SearchAwarenessUnitValidator(FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike)), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
        searchAwarenessController.m8744a(IdBasedLazy.m1808a(injectorLike, 3386), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10523), IdBasedLazy.m1808a(injectorLike, 10519), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078), IdBasedSingletonScopeProvider.m1810b(injectorLike, 609));
        return searchAwarenessController;
    }

    private void m8744a(com.facebook.inject.Lazy<SearchQPTooltipController> lazy, com.facebook.inject.Lazy<SearchAwarenessTutorialNuxController> lazy2, com.facebook.inject.Lazy<SearchAwarenessLearningNuxConfigurationLoader> lazy3, com.facebook.inject.Lazy<FbErrorReporter> lazy4, com.facebook.inject.Lazy<FbSharedPreferences> lazy5, com.facebook.inject.Lazy<Clock> lazy6) {
        this.f4887j = lazy;
        this.f4888k = lazy2;
        this.f4889l = lazy3;
        this.f4890m = lazy4;
        this.f4891n = lazy5;
        this.f4892o = lazy6;
    }

    public final void m8756b(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum) {
        m8750a(graphQLSearchAwarenessTemplatesEnum, RegularImmutableBiMap.f695a);
    }

    @Inject
    private SearchAwarenessController(SearchBarTooltipControllerProvider searchBarTooltipControllerProvider, SearchBarFormattedTooltipControllerProvider searchBarFormattedTooltipControllerProvider, SearchAwarenessNullStateControllerProvider searchAwarenessNullStateControllerProvider, SearchAwarenessSearchResultsUnitControllerProvider searchAwarenessSearchResultsUnitControllerProvider, SearchAwarenessUnitValidator searchAwarenessUnitValidator, QeAccessor qeAccessor) {
        this.f4878a = searchBarTooltipControllerProvider;
        this.f4879b = searchBarFormattedTooltipControllerProvider;
        this.f4880c = searchAwarenessNullStateControllerProvider;
        this.f4881d = searchAwarenessSearchResultsUnitControllerProvider;
        this.f4882e = searchAwarenessUnitValidator;
        this.f4883f = qeAccessor;
        this.f4884g = new HashMap();
        this.f4885h = new HashMap();
    }

    public final void m8749a(View view) {
        this.f4886i = view;
    }

    public final boolean m8759c() {
        SearchAwarenessNullStateController searchAwarenessNullStateController = (SearchAwarenessNullStateController) this.f4885h.get(GraphQLSearchAwarenessTemplatesEnum.LEARNING_NUX_SECOND_STEP);
        return searchAwarenessNullStateController != null && searchAwarenessNullStateController.h;
    }

    public final boolean m8754a(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum) {
        AwarenessUnitController awarenessUnitController = (AwarenessUnitController) this.f4885h.get(graphQLSearchAwarenessTemplatesEnum);
        return awarenessUnitController != null && awarenessUnitController.c();
    }

    public final void m8750a(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum, ImmutableMap<String, ?> immutableMap) {
        AwarenessUnitController awarenessUnitController = (AwarenessUnitController) this.f4885h.get(graphQLSearchAwarenessTemplatesEnum);
        SearchAwarenessUnitProperties searchAwarenessUnitProperties = (SearchAwarenessUnitProperties) this.f4884g.get(graphQLSearchAwarenessTemplatesEnum);
        if (awarenessUnitController != null) {
            awarenessUnitController.a(immutableMap);
            if (searchAwarenessUnitProperties != null) {
                SearchAwarenessUnitProperties searchAwarenessUnitProperties2 = (SearchAwarenessUnitProperties) this.f4884g.get(searchAwarenessUnitProperties.a.jF_());
                if (searchAwarenessUnitProperties2 != null) {
                    searchAwarenessUnitProperties2 = (SearchAwarenessUnitProperties) this.f4884g.get(searchAwarenessUnitProperties2.b);
                    if (searchAwarenessUnitProperties2 != null) {
                        searchAwarenessUnitProperties2.d = ((Clock) this.f4892o.get()).mo211a();
                        searchAwarenessUnitProperties2.f = true;
                    }
                }
            }
        }
    }

    public final void m8751a(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum, boolean z) {
        AwarenessUnitController awarenessUnitController = (AwarenessUnitController) this.f4885h.get(graphQLSearchAwarenessTemplatesEnum);
        SearchAwarenessUnitProperties searchAwarenessUnitProperties = (SearchAwarenessUnitProperties) this.f4884g.get(graphQLSearchAwarenessTemplatesEnum);
        if (awarenessUnitController != null) {
            awarenessUnitController.d();
            if (searchAwarenessUnitProperties != null && z) {
                m8752a(searchAwarenessUnitProperties.a);
            }
        }
    }

    public final void m8758c(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum) {
        boolean z = false;
        if (this.f4883f.mo596a(ExperimentsForSearchAbTestModule.au, false) || this.f4883f.mo596a(ExperimentsForSearchAbTestModule.av, false)) {
            z = true;
        }
        if (z) {
            m8747d(graphQLSearchAwarenessTemplatesEnum);
        }
    }

    private void m8747d(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum) {
        AwarenessUnitController awarenessUnitController = (AwarenessUnitController) this.f4885h.get(graphQLSearchAwarenessTemplatesEnum);
        if (awarenessUnitController != null) {
            awarenessUnitController.e();
        }
    }

    public final void m8757b(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum, boolean z) {
        m8751a(graphQLSearchAwarenessTemplatesEnum, z);
        m8747d(graphQLSearchAwarenessTemplatesEnum);
    }

    public final boolean m8755a(SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel) {
        return this.f4882e.m8773a(searchAwarenessRootSuggestionFieldsFragmentModel);
    }

    public final void m8752a(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        SearchAwarenessUnitProperties searchAwarenessUnitProperties = (SearchAwarenessUnitProperties) this.f4884g.get(searchAwarenessSuggestionFieldsFragment.jF_());
        if (searchAwarenessUnitProperties != null) {
            searchAwarenessUnitProperties = (SearchAwarenessUnitProperties) this.f4884g.get(searchAwarenessUnitProperties.b);
            if (searchAwarenessUnitProperties != null) {
                searchAwarenessUnitProperties.f = false;
            }
        }
    }

    private void m8746c(GraphQLSearchAwarenessTemplatesEnum graphQLSearchAwarenessTemplatesEnum, boolean z) {
        SearchAwarenessUnitProperties searchAwarenessUnitProperties = (SearchAwarenessUnitProperties) this.f4884g.get(graphQLSearchAwarenessTemplatesEnum);
        switch (1.a[graphQLSearchAwarenessTemplatesEnum.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                Map map = this.f4885h;
                InjectorLike injectorLike = this.f4878a;
                map.put(graphQLSearchAwarenessTemplatesEnum, new SearchBarTooltipController((Context) injectorLike.getInstance(Context.class), this.f4886i, searchAwarenessUnitProperties, SearchAwarenessOptOutController.a(injectorLike), SearchAwarenessLogger.m12394b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike)));
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f4885h.put(graphQLSearchAwarenessTemplatesEnum, this.f4879b.m8760a(this.f4886i, searchAwarenessUnitProperties, this));
                return;
            case 3:
                this.f4885h.put(graphQLSearchAwarenessTemplatesEnum, this.f4880c.m8761a(searchAwarenessUnitProperties, z));
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                this.f4885h.put(graphQLSearchAwarenessTemplatesEnum, this.f4881d.m8762a(searchAwarenessUnitProperties));
                return;
            default:
                return;
        }
    }

    public final void m8748a() {
        if (this.f4883f.mo596a(ExperimentsForSearchAbTestModule.av, false)) {
            Object obj;
            for (SearchAwarenessUnitProperties searchAwarenessUnitProperties : this.f4884g.values()) {
                if (searchAwarenessUnitProperties.f) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                if (!(this.f4893p == null || this.f4893p.k() == null)) {
                    m8753a(this.f4893p.k(), false);
                    ((FbSharedPreferences) this.f4891n.get()).edit().putBoolean(SearchAwarenessPrefKeys.f, true).commit();
                    this.f4893p = null;
                }
                if (((FbSharedPreferences) this.f4891n.get()).mo277a(SearchAwarenessPrefKeys.e, 0) <= ((Clock) this.f4892o.get()).mo211a()) {
                    GraphQLCachePolicy graphQLCachePolicy;
                    SearchAwarenessLearningNuxConfigurationLoader searchAwarenessLearningNuxConfigurationLoader = (SearchAwarenessLearningNuxConfigurationLoader) this.f4889l.get();
                    if (searchAwarenessLearningNuxConfigurationLoader.d != null) {
                        searchAwarenessLearningNuxConfigurationLoader.b.m14561c("search_awareness_learning_nux_config_loader_key");
                    }
                    searchAwarenessLearningNuxConfigurationLoader.d = this;
                    searchAwarenessLearningNuxConfigurationLoader = (SearchAwarenessLearningNuxConfigurationLoader) this.f4889l.get();
                    boolean a = searchAwarenessLearningNuxConfigurationLoader.a.mo286a(SearchAwarenessPrefKeys.f, false);
                    GraphQLRequest a2 = GraphQLRequest.m11587a((TypedGraphQlQueryString) new LearningNuxConfigurationString());
                    if (a) {
                        graphQLCachePolicy = GraphQLCachePolicy.f7111c;
                    } else {
                        graphQLCachePolicy = GraphQLCachePolicy.f7109a;
                    }
                    Callable 1 = new 1(searchAwarenessLearningNuxConfigurationLoader, a2.m11594a(graphQLCachePolicy).m11596a(RequestPriority.NON_INTERACTIVE).m11590a(86400000));
                    DisposableFutureCallback 2 = new 2(searchAwarenessLearningNuxConfigurationLoader);
                    searchAwarenessLearningNuxConfigurationLoader.b.m14556a((Object) "search_awareness_learning_nux_config_loader_key", 1, 2);
                }
            }
        }
    }

    public final void m8753a(SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel, boolean z) {
        ImmutableList a;
        this.f4884g.clear();
        this.f4885h.clear();
        if (searchAwarenessRootSuggestionFieldsFragmentModel.j() != null) {
            a = searchAwarenessRootSuggestionFieldsFragmentModel.j().a();
        } else {
            a = RegularImmutableList.f535a;
        }
        SearchAwarenessUnitProperties searchAwarenessUnitProperties = new SearchAwarenessUnitProperties(searchAwarenessRootSuggestionFieldsFragmentModel, searchAwarenessRootSuggestionFieldsFragmentModel.b(), searchAwarenessRootSuggestionFieldsFragmentModel.k());
        searchAwarenessUnitProperties.f = true;
        searchAwarenessUnitProperties.d = ((Clock) this.f4892o.get()).mo211a();
        this.f4884g.put(searchAwarenessRootSuggestionFieldsFragmentModel.jF_(), searchAwarenessUnitProperties);
        m8746c(searchAwarenessRootSuggestionFieldsFragmentModel.jF_(), z);
        int size = a.size();
        SearchAwarenessUnitProperties searchAwarenessUnitProperties2 = searchAwarenessUnitProperties;
        for (int i = 0; i < size; i++) {
            SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment = (SearchAwarenessSuggestionFieldsFragment) a.get(i);
            searchAwarenessUnitProperties2.b = searchAwarenessSuggestionFieldsFragment.jF_();
            searchAwarenessUnitProperties2 = new SearchAwarenessUnitProperties(searchAwarenessSuggestionFieldsFragment, searchAwarenessRootSuggestionFieldsFragmentModel.b(), searchAwarenessRootSuggestionFieldsFragmentModel.k());
            this.f4884g.put(searchAwarenessSuggestionFieldsFragment.jF_(), searchAwarenessUnitProperties2);
            m8746c(searchAwarenessSuggestionFieldsFragment.jF_(), z);
        }
    }
}
