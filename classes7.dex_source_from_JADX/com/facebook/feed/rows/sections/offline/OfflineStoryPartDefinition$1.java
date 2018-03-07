package com.facebook.feed.rows.sections.offline;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.offline.OfflineAnimationGroupPartDefinition.Callbacks;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.BaseMultiRowSubParts;

/* compiled from: UPDATED_ASSET_COUNT */
public class OfflineStoryPartDefinition$1 implements Callbacks<FeedEnvironment> {
    final /* synthetic */ OfflineStoryPartDefinition f21561a;

    public final void mo1502a(BaseMultiRowSubParts baseMultiRowSubParts, FeedProps feedProps, HasPersistentState hasPersistentState) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        baseMultiRowSubParts.a(this.f21561a.t, feedProps);
        baseMultiRowSubParts.a(this.f21561a.i, feedProps);
        baseMultiRowSubParts.a(this.f21561a.j, feedProps);
        baseMultiRowSubParts.a(this.f21561a.k, feedProps);
        baseMultiRowSubParts.a(this.f21561a.l, feedProps);
        baseMultiRowSubParts.a(this.f21561a.m, feedProps);
        baseMultiRowSubParts.a(this.f21561a.q, feedProps);
        if (!this.f21561a.b.m25804a(graphQLStory)) {
            baseMultiRowSubParts.a(this.f21561a.n, feedProps);
            baseMultiRowSubParts.a(this.f21561a.o, feedProps);
        }
    }

    public OfflineStoryPartDefinition$1(OfflineStoryPartDefinition offlineStoryPartDefinition) {
        this.f21561a = offlineStoryPartDefinition;
    }
}
