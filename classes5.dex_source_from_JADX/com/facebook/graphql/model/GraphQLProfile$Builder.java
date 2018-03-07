package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: VOIP_CALL */
public class GraphQLProfile$Builder extends Builder {
    @Nullable
    public GraphQLFeedback f12768A;
    @Nullable
    public GraphQLFriendsConnection f12769B;
    public GraphQLFriendshipStatus f12770C = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLExternalUrl f12771D;
    @Nullable
    public GraphQLGroupMembersConnection f12772E;
    public int f12773F;
    @Nullable
    public String f12774G;
    @Nullable
    public GraphQLUser f12775H;
    public boolean f12776I;
    public boolean f12777J;
    public boolean f12778K;
    public boolean f12779L;
    public boolean f12780M;
    public boolean f12781N;
    @Nullable
    public GraphQLLocation f12782O;
    @Nullable
    public GraphQLMutualFriendsConnection f12783P;
    @Nullable
    public String f12784Q;
    public ImmutableList<String> f12785R;
    public int f12786S;
    @Nullable
    public GraphQLStoryAttachment f12787T;
    @Nullable
    public GraphQLPage f12788U;
    @Nullable
    public GraphQLPageLikersConnection f12789V;
    @Nullable
    public GraphQLPageVisitsConnection f12790W;
    @Nullable
    public String f12791X;
    @Nullable
    public GraphQLPrivacyScope f12792Y;
    @Nullable
    public GraphQLImage f12793Z;
    public GraphQLEventWatchStatus aA = GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities aB;
    public ImmutableList<String> aC;
    @Nullable
    public GraphQLUserWorkExperiencesConnection aD;
    @Nullable
    public GraphQLObjectType aE = null;
    @Nullable
    public GraphQLImage aa;
    @Nullable
    public GraphQLImage ab;
    @Nullable
    public GraphQLImage ac;
    @Nullable
    public GraphQLImage ad;
    @Nullable
    public GraphQLImage ae;
    public boolean af;
    @Nullable
    public String ag;
    public GraphQLSecondarySubscribeStatus ah = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<String> ai;
    @Nullable
    public GraphQLTextWithEntities aj;
    @Nullable
    public GraphQLStreamingImage ak;
    @Nullable
    public GraphQLName al;
    public ImmutableList<GraphQLName> am;
    public GraphQLSubscribeStatus an = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage ao;
    @Nullable
    public GraphQLTextWithEntities ap;
    @Nullable
    public GraphQLTrendingTopicData aq;
    @Nullable
    public String ar;
    @Nullable
    public String as;
    @Nullable
    public String at;
    public double au;
    public GraphQLEventGuestStatus av = GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean aw;
    public GraphQLGroupJoinState ax = GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLContactRecommendationField ay;
    public GraphQLSavedState az = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLStreetAddress f12794d;
    @Nullable
    public String f12795e;
    @Nullable
    public GraphQLTextWithEntities f12796f;
    public ImmutableList<GraphQLBylineFragment> f12797g;
    public boolean f12798h;
    public boolean f12799i;
    public boolean f12800j;
    public boolean f12801k;
    public boolean f12802l;
    public boolean f12803m;
    public boolean f12804n;
    public boolean f12805o;
    public ImmutableList<String> f12806p;
    public double f12807q;
    public GraphQLConnectionStyle f12808r = GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLFocusedPhoto f12809s;
    public boolean f12810t;
    @Nullable
    public GraphQLUserEducationExperiencesConnection f12811u;
    public ImmutableList<String> f12812v;
    public GraphQLEventPrivacyType f12813w = GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public int f12814x;
    public GraphQLEventsCalendarSubscriptionStatus f12815y = GraphQLEventsCalendarSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage f12816z;

    public GraphQLProfile$Builder() {
        Preconditions.checkState(this instanceof GraphQLProfile$Builder);
    }

    public final GraphQLProfile$Builder m21093a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
        this.ah = graphQLSecondarySubscribeStatus;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 58, graphQLSecondarySubscribeStatus);
        }
        return this;
    }

    public final GraphQLProfile$Builder m21094a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
        this.an = graphQLSubscribeStatus;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 64, graphQLSubscribeStatus);
        }
        return this;
    }

    public final GraphQLProfile m21095a() {
        return new GraphQLProfile(this);
    }
}
