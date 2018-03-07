package com.facebook.search.typeahead;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.search.suggestions.simplesearch.RemoteCombinedTypeaheadFetcher;
import com.facebook.ui.typeahead.SearchTypeaheadConfig;
import com.facebook.ui.typeahead.SynchronousTypeaheadFetchStrategy;
import javax.inject.Inject;

/* compiled from: video_duration_millis */
public class SearchSynchronousTypeaheadFetchStrategy<T> extends SynchronousTypeaheadFetchStrategy {
    public static SearchSynchronousTypeaheadFetchStrategy m524c(InjectorLike injectorLike) {
        return new SearchSynchronousTypeaheadFetchStrategy(DefaultAndroidThreadUtil.b(injectorLike), SearchTypeaheadConfig.b(injectorLike));
    }

    @Inject
    public SearchSynchronousTypeaheadFetchStrategy(DefaultAndroidThreadUtil defaultAndroidThreadUtil, SearchTypeaheadConfig searchTypeaheadConfig) {
        super(defaultAndroidThreadUtil, searchTypeaheadConfig);
    }

    public final void m525a(RemoteCombinedTypeaheadFetcher remoteCombinedTypeaheadFetcher) {
        a(remoteCombinedTypeaheadFetcher, 2);
    }
}
