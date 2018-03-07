package com.facebook.search.results.fragment.common;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.loader.GraphSearchDataLoader;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.perf.GraphSearchPerformanceLogger;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.widget.listview.FbListAdapter;

/* compiled from: SHOW_PASSWORD_UNCHECKED */
public class ResultsDataAndListStateControllerProvider extends AbstractAssistedProvider<ResultsDataAndListStateController> {
    public final ResultsDataAndListStateController m26623a(SearchResultsMutableContext searchResultsMutableContext, FbListAdapter fbListAdapter) {
        return new ResultsDataAndListStateController(searchResultsMutableContext, fbListAdapter, new ResultDataFetcher(DefaultAndroidThreadUtil.b(this), GraphSearchDataLoader.m25439a((InjectorLike) this), GraphSearchErrorReporter.a(this), GraphSearchPerformanceLogger.m25549a((InjectorLike) this)), GraphSearchPerformanceLogger.m25549a((InjectorLike) this), SearchResultsLogger.m25460a((InjectorLike) this), MultipleRowsStoriesRecycleCallback.a(this));
    }
}
