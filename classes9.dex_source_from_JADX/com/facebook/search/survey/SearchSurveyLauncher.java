package com.facebook.search.survey;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.results.model.SearchResultsLastContextProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: video_home_prefetch */
public class SearchSurveyLauncher {
    public static final ImmutableMap<String, String> f383a = ImmutableMap.of("news_v2", "754892314644399", "celebrity", "183217548708754", "content", "953209228106411", "hashtags", "1692301757676581", "scoped", "1679306519007010");
    public static final ImmutableSet<SearchResultsSource> f384b = ImmutableSet.of(SearchResultsSource.d, SearchResultsSource.e, SearchResultsSource.a, SearchResultsSource.c);
    public final Lazy<RapidFeedbackController> f385c;
    public final SearchResultsLastContextProvider f386d;

    public static SearchSurveyLauncher m507a(InjectorLike injectorLike) {
        return new SearchSurveyLauncher(IdBasedLazy.a(injectorLike, 3253), SearchResultsLastContextProvider.a(injectorLike));
    }

    @Inject
    public SearchSurveyLauncher(Lazy<RapidFeedbackController> lazy, SearchResultsLastContextProvider searchResultsLastContextProvider) {
        this.f385c = lazy;
        this.f386d = searchResultsLastContextProvider;
    }
}
