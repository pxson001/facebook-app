package com.facebook.search.suggestions;

import com.facebook.search.logging.SuggestionsTypeaheadAnalyticHelper;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.util.bugreporter.SearchBugReportExtraDataProvider;
import com.facebook.ui.typeahead.BaseTypeaheadController;
import com.facebook.ui.typeahead.DefaultTypeaheadDispatchStrategy;
import com.facebook.ui.typeahead.SynchronousTypeaheadFetchStrategy;
import com.facebook.ui.typeahead.TypeaheadSuggestionDeduper;
import com.facebook.ui.typeahead.TypeaheadSuggestionListUtilProvider;
import com.facebook.ui.typeahead.querycache.DefaultTypeaheadQueryCachePolicy;
import com.facebook.ui.typeahead.querycache.TypeaheadQueryCacheManager;
import com.google.common.collect.ImmutableMap;

/* compiled from: PHOTO_FLOW_GALLERY */
public abstract class BaseSuggestionsTypeaheadController extends BaseTypeaheadController<TypeaheadUnit> {
    private SingleSearchSuggestionListController f25338c;

    public abstract void mo1337a(SuggestionsTypeaheadAnalyticHelper suggestionsTypeaheadAnalyticHelper);

    public BaseSuggestionsTypeaheadController(SynchronousTypeaheadFetchStrategy synchronousTypeaheadFetchStrategy, DefaultTypeaheadQueryCachePolicy defaultTypeaheadQueryCachePolicy, TypeaheadSuggestionDeduper typeaheadSuggestionDeduper, TypeaheadSuggestionListUtilProvider typeaheadSuggestionListUtilProvider, TypeaheadQueryCacheManager typeaheadQueryCacheManager, DefaultTypeaheadDispatchStrategy defaultTypeaheadDispatchStrategy, SearchBugReportExtraDataProvider searchBugReportExtraDataProvider) {
        super(synchronousTypeaheadFetchStrategy, defaultTypeaheadQueryCachePolicy, typeaheadSuggestionDeduper, typeaheadSuggestionListUtilProvider, typeaheadQueryCacheManager, defaultTypeaheadDispatchStrategy, searchBugReportExtraDataProvider);
    }

    public void mo1339b(ImmutableMap<String, String> immutableMap) {
        a(immutableMap);
    }

    protected void mo1336a() {
        if (this.f25338c != null) {
            this.f25338c.a();
        }
    }

    public void mo1340h() {
        mo1336a();
    }

    public void mo1338a(SingleSearchSuggestionListController singleSearchSuggestionListController) {
        this.f25338c = singleSearchSuggestionListController;
    }

    public TypeaheadUnit mo1341i() {
        return (TypeaheadUnit) this.a;
    }
}
