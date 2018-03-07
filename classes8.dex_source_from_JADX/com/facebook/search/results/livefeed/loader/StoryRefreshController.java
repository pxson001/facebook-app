package com.facebook.search.results.livefeed.loader;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: SEARCH_NULL_STATE_VPV */
public interface StoryRefreshController {
    public static final LiveFeedDataHandler f23218a = new C25021();

    /* compiled from: SEARCH_NULL_STATE_VPV */
    final class C25021 implements LiveFeedDataHandler {
        C25021() {
        }

        public final void mo1296a(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
            BLog.a(StoryRefreshController.class, "No-op Data Handler Head Load.");
        }

        public final void mo1297b(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
            BLog.a(StoryRefreshController.class, "No-op Data Handler Tail Load.");
        }

        public final void mo1295a(GraphSearchException graphSearchException) {
            BLog.b(StoryRefreshController.class, "No-op Data Handler Failure.", graphSearchException);
        }
    }

    void mo1312a();

    void mo1313a(@Nullable LiveFeedDataHandler liveFeedDataHandler);

    void mo1314a(SearchResultsContext searchResultsContext, LiveFeedRefreshConfig liveFeedRefreshConfig, Optional<ImmutableList<GraphQLStory>> optional);

    void mo1315a(String str);

    void mo1316b();

    void mo1317c();

    void mo1318d();

    boolean mo1319e();
}
