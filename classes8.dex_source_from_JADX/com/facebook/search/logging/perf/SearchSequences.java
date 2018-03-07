package com.facebook.search.logging.perf;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: TYPE_EXISTING_GROUP */
public final class SearchSequences {
    public static final ResultFetchSequence f22023a = new ResultFetchSequence();
    public static final SearchWaterfallSequence f22024b = new SearchWaterfallSequence();

    /* compiled from: TYPE_EXISTING_GROUP */
    public final class ResultFetchSequence extends AbstractSequenceDefinition {
        private static final ImmutableSet<String> f22022a = ImmutableSet.of("com.facebook.search.results.fragment.photos.SearchResultsPhotosFragment", "com.facebook.search.results.fragment.entities.SearchResultsEntitiesFragment", "com.facebook.feed.fragment.NewsFeedFragment");

        public ResultFetchSequence() {
            super(458767, "GraphSearchResultFetch", false, f22022a);
        }
    }

    /* compiled from: TYPE_EXISTING_GROUP */
    public final class SearchWaterfallSequence extends AbstractSequenceDefinition {
        public SearchWaterfallSequence() {
            super(458769, "SearchWaterfall");
        }
    }
}
