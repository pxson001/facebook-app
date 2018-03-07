package com.facebook.search.suggestions;

import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.marketplace.tab.fragment.MarketplaceHomeFragment;
import com.facebook.search.module.TypeaheadDispatchStrategyMethodAutoProvider;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.loader.GraphSearchTypeaheadSuggestionDeduper;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.SynchronousTypeaheadFetchStrategy;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;

/* compiled from: PHONE_ACQUIRED */
public class ReactSearchSugestionsTypeaheadControllerProvider extends AbstractAssistedProvider<ReactSearchSugestionsTypeaheadController> {
    public final ReactSearchSugestionsTypeaheadController m28622a(MarketplaceHomeFragment marketplaceHomeFragment) {
        return new ReactSearchSugestionsTypeaheadController(marketplaceHomeFragment, SynchronousTypeaheadFetchStrategy.b(this), DefaultTypeaheadQueryCachePolicy.b(this), (TypeaheadSuggestionDeduper) GraphSearchTypeaheadSuggestionDeduper.a(this), (TypeaheadSuggestionListUtilProvider) getOnDemandAssistedProviderForStaticDi(TypeaheadSuggestionListUtilProvider.class), TypeaheadQueryCacheManager.b(this), TypeaheadDispatchStrategyMethodAutoProvider.m25836b(this), SearchBugReportExtraDataProvider.a(this), FbReactInstanceHolder.a(this), ReactSearchEventBus.a(this), GraphSearchTitleSearchBoxSupplier.m28576a(this));
    }
}
