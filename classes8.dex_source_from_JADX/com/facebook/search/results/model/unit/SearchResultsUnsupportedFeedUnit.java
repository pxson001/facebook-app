package com.facebook.search.results.model.unit;

import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import java.util.Locale;

/* compiled from: Refresh Bootstrap Entities */
public class SearchResultsUnsupportedFeedUnit extends SearchResultsBaseFeedUnit {
    public final String f23549a;

    public SearchResultsUnsupportedFeedUnit(KeywordSearchModuleFragmentModel keywordSearchModuleFragmentModel) {
        this.f23549a = String.format(Locale.US, "[Employees Only] Unsupported Module\nDisplayStyle: %s\nRole: %s\nPlease rage shake and file report", new Object[]{keywordSearchModuleFragmentModel.m8536a(), keywordSearchModuleFragmentModel.jx_()});
    }
}
