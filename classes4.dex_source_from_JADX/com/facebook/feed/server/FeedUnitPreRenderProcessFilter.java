package com.facebook.feed.server;

import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FeedOperationTypes;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: privacy_selector_specific_friends_open */
public class FeedUnitPreRenderProcessFilter implements BlueServiceHandler$Filter {
    private final Lazy<FeedUnitPreRenderProcessor> f4162a;

    @Inject
    public FeedUnitPreRenderProcessFilter(Lazy<FeedUnitPreRenderProcessor> lazy) {
        this.f4162a = lazy;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        boolean z = false;
        if (FeedOperationTypes.m4701a(str)) {
            z = ((FetchFeedParams) operationParams.c.getParcelable("fetchFeedParams")).o;
        }
        OperationResult a = blueServiceHandler.a(!z ? operationParams : operationParams.a(new 1(this, str, operationParams)));
        m4702a(this, str, operationParams, a);
        return a;
    }

    public static void m4702a(FeedUnitPreRenderProcessFilter feedUnitPreRenderProcessFilter, String str, OperationParams operationParams, OperationResult operationResult) {
        if (operationResult.b) {
            FeedUnitPreRenderProcessor feedUnitPreRenderProcessor = (FeedUnitPreRenderProcessor) feedUnitPreRenderProcessFilter.f4162a.get();
            if (FeedOperationTypes.m4701a(str)) {
                FetchFeedResult fetchFeedResult = (FetchFeedResult) operationResult.k();
                if (fetchFeedResult != null && fetchFeedResult.b != null && fetchFeedResult.d() != null) {
                    FeedFetchContext feedFetchContext = ((FetchFeedParams) operationParams.c.getParcelable("fetchFeedParams")).h;
                    ImmutableList d = fetchFeedResult.d();
                    int size = d.size();
                    for (int i = 0; i < size; i++) {
                        feedUnitPreRenderProcessor.a(((GraphQLFeedUnitEdge) d.get(i)).c(), feedFetchContext);
                    }
                }
            } else if (str == "feed_fetch_followup_feed_unit") {
                FeedUnit feedUnit = (FeedUnit) operationResult.k();
                if (feedUnit != null) {
                    feedUnitPreRenderProcessor.a(feedUnit, FeedFetchContext.a);
                }
            } else if (str == "feed_fetch_paginated_related_story") {
                GraphQLStorySet graphQLStorySet = (GraphQLStorySet) operationResult.k();
                if (graphQLStorySet != null) {
                    feedUnitPreRenderProcessor.a(graphQLStorySet, FeedFetchContext.a);
                }
            }
        }
    }
}
