package com.facebook.goodwill.feed.rows;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.HasFeedProps;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.HasFeedUnit;

/* compiled from: fdfd709523d835600b876c8eba917224 */
public class ThrowbackFriendversaryAggregatedFriendListProps implements HasFeedProps<FeedUnit>, HasFeedUnit {
    private FeedProps<? extends FeedUnit> f13626a;
    public GraphQLUser f13627b;
    private GraphQLTextWithEntities f13628c;
    public boolean f13629d;

    public ThrowbackFriendversaryAggregatedFriendListProps(FeedProps<? extends FeedUnit> feedProps, GraphQLUser graphQLUser, GraphQLTextWithEntities graphQLTextWithEntities, boolean z) {
        this.f13626a = feedProps;
        this.f13627b = graphQLUser;
        this.f13628c = graphQLTextWithEntities;
        this.f13629d = z;
    }

    public final GraphQLTextWithEntities m15355b() {
        return this.f13628c;
    }

    public final FeedUnit m15356c() {
        return (FeedUnit) this.f13626a.a;
    }

    public final FeedProps<? extends FeedUnit> m15357f() {
        return this.f13626a;
    }
}
