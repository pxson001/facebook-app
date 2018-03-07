package com.facebook.api.feed.data;

import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import java.util.List;

/* compiled from: send_delivery_receipt */
public interface LegacyFeedUnitUpdater {
    void mo1378a();

    void mo1379a(FeedUnit feedUnit);

    void mo1380a(GraphQLFeedUnitEdge graphQLFeedUnitEdge);

    void mo1381a(String str);

    GraphQLStory mo1382b(String str);

    GraphQLStory mo1383c(String str);

    List<FeedEdge> mo1384d(String str);

    GraphQLFeedUnitEdge mo1385e(String str);
}
