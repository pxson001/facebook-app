package com.facebook.search.suggestions;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.util.StringUtil;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.fbreact.search.ReactSearchEvents.ReactNativeInfoHandler;
import com.facebook.fbreact.search.ReactSearchEvents.UpdateSearcyQueryEventSubscriberImpl;
import com.facebook.inject.Assisted;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.DefaultTypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.ui.typeahead.SuggestionFilter;
import com.facebook.ui.typeahead.SynchronousTypeaheadFetchStrategy;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;

/* compiled from: PHONE_SWITCH_TO_EMAIL */
public class ReactSearchSugestionsTypeaheadController extends BaseSuggestionsTypeaheadController {
    public final MarketplaceHomeFragment f25346c;
    private final FbReactInstanceHolder f25347d;
    private final ReactSearchEventBus f25348e;
    private final UpdateSearcyQueryEventSubscriberImpl f25349f;
    public String f25350g;

    @Inject
    public ReactSearchSugestionsTypeaheadController(@Assisted MarketplaceHomeFragment marketplaceHomeFragment, SynchronousTypeaheadFetchStrategy synchronousTypeaheadFetchStrategy, DefaultTypeaheadQueryCachePolicy defaultTypeaheadQueryCachePolicy, TypeaheadSuggestionDeduper typeaheadSuggestionDeduper, TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, TypeaheadQueryCacheManager typeaheadQueryCacheManager, DefaultTypeaheadDispatchStrategy defaultTypeaheadDispatchStrategy, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider, FbReactInstanceHolder fbReactInstanceHolder, ReactSearchEventBus reactSearchEventBus, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier) {
        super(synchronousTypeaheadFetchStrategy, defaultTypeaheadQueryCachePolicy, typeaheadSuggestionDeduper, typeaheadSuggestionListUtilProvider, typeaheadQueryCacheManager, defaultTypeaheadDispatchStrategy, searchBugReportExtraDataProvider);
        this.f25347d = fbReactInstanceHolder;
        this.f25346c = marketplaceHomeFragment;
        this.f25348e = reactSearchEventBus;
        final GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier2 = graphSearchTitleSearchBoxSupplier;
        this.f25349f = new UpdateSearcyQueryEventSubscriberImpl(new ReactNativeInfoHandler(this) {
            final /* synthetic */ ReactSearchSugestionsTypeaheadController f25345b;

            public final int m28594a() {
                return this.f25345b.f25346c.av();
            }

            public final void m28595a(String str) {
                graphSearchTitleSearchBoxSupplier2.f25334a.setSearchText(str);
            }

            public final void m28596a(String str, String str2) {
            }
        });
        this.f25348e.a(this.f25349f);
    }

    protected final SuggestionFilter<TypeaheadUnit> m28599a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse, String str) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final void mo1337a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper) {
    }

    public final void mo1339b(ImmutableMap<String, String> immutableMap) {
        this.f25348e.b(this.f25349f);
    }

    protected final void mo1336a() {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final ImmutableList<TypeaheadUnit> m28610b() {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final TypeaheadResponse<TypeaheadUnit> m28609b(TypeaheadResponse<TypeaheadUnit> typeaheadResponse, String str) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final void m28606a(ImmutableList<TypeaheadUnit> immutableList) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final void m28604a(TypeaheadRequest typeaheadRequest) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final boolean m28612b(TypeaheadRequest typeaheadRequest) {
        this.f25350g = typeaheadRequest.b;
        m28597a("kFBSearchContextSearchEvent");
        return true;
    }

    public final void m28605a(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final void m28615d() {
        m28597a("kFBSearchContextSearchClear");
    }

    public final void m28616e() {
        m28597a("kFBSearchContextSearchTapped");
    }

    public final void m28607a(boolean z) {
        if (z) {
            m28597a("kFBSearchContextSearchFocus");
        }
    }

    protected final Builder<String, String> m28618f() {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final void m28601a(MemoryTrimType memoryTrimType) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final SearchResponse<TypeaheadUnit> m28619g() {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final SearchResponse<TypeaheadUnit> m28608b(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final SearchResponse<TypeaheadUnit> m28613c(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final TypeaheadResponse<TypeaheadUnit> m28614d(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    protected final void m28617e(TypeaheadResponse<TypeaheadUnit> typeaheadResponse) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final void mo1340h() {
    }

    public final void mo1338a(SingleSearchSuggestionListController singleSearchSuggestionListController) {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    public final TypeaheadUnit mo1341i() {
        throw new RuntimeException("React typeahead doesn't support method");
    }

    private void m28597a(String str) {
        if (m28598j() != null) {
            RCTNativeAppEventEmitter rCTNativeAppEventEmitter = (RCTNativeAppEventEmitter) m28598j().a(RCTNativeAppEventEmitter.class);
            WritableMap b = Arguments.b();
            b.putInt("reactTag", this.f25346c.av());
            if (!StringUtil.a(this.f25350g)) {
                b.putString("query", this.f25350g);
            }
            b.putString("tabBarSelectedIndex", "0");
            rCTNativeAppEventEmitter.emit(str, b);
        }
    }

    private ReactContext m28598j() {
        return this.f25347d.c() != null ? this.f25347d.c().j() : null;
    }
}
