package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGender;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: TopicCustomizationStory */
public class GraphQLUser$Builder extends Builder {
    @Nullable
    public GraphQLUserEducationExperiencesConnection f13393A;
    public ImmutableList<String> f13394B;
    @Nullable
    public String f13395C;
    @Nullable
    public GraphQLEventsConnection f13396D;
    @Nullable
    public GraphQLImage f13397E;
    @Nullable
    public GraphQLTimelineSectionsConnection f13398F;
    @Nullable
    public String f13399G;
    @Nullable
    public GraphQLFollowUpFeedUnitsConnection f13400H;
    @Nullable
    public GraphQLFriendsConnection f13401I;
    public GraphQLFriendshipStatus f13402J = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGender f13403K = GraphQLGender.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean f13404L;
    @Nullable
    public GraphQLPage f13405M;
    @Nullable
    public String f13406N;
    @Nullable
    public GraphQLImage f13407O;
    @Nullable
    public GraphQLInlineActivitiesConnection f13408P;
    public boolean f13409Q;
    public boolean f13410R;
    public boolean f13411S;
    public boolean f13412T;
    public boolean f13413U;
    public boolean f13414V;
    public boolean f13415W;
    public boolean f13416X;
    public boolean f13417Y;
    public boolean f13418Z;
    @Nullable
    public GraphQLImage aA;
    @Nullable
    public GraphQLImage aB;
    @Nullable
    public GraphQLImage aC;
    @Nullable
    public GraphQLProfileBadge aD;
    @Nullable
    public GraphQLPhoto aE;
    @Nullable
    public GraphQLImage aF;
    @Nullable
    public GraphQLImage aG;
    @Nullable
    public GraphQLImage aH;
    @Nullable
    public GraphQLImage aI;
    public long aJ;
    public boolean aK;
    @Nullable
    public GraphQLProfileVideo aL;
    @Nullable
    public String aM;
    public long aN;
    @Nullable
    public String aO;
    @Nullable
    public String aP;
    public GraphQLSecondarySubscribeStatus aQ = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String aR;
    @Nullable
    public String aS;
    @Nullable
    public GraphQLSinglePublisherVideoChannelsConnection aT;
    @Nullable
    public GraphQLTextWithEntities aU;
    @Nullable
    public GraphQLImage aV;
    @Nullable
    public GraphQLImage aW;
    @Nullable
    public GraphQLImage aX;
    @Nullable
    public GraphQLStreamingImage aY;
    @Nullable
    public GraphQLName aZ;
    public boolean aa;
    public boolean ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public boolean af;
    public boolean ag;
    public boolean ah;
    @Nullable
    public GraphQLLikedProfilesConnection ai;
    public GraphQLLiveVideoSubscriptionStatus aj = GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage ak;
    @Nullable
    public GraphQLContact al;
    public long am;
    public double an;
    @Nullable
    public String ao;
    public int ap;
    @Nullable
    public GraphQLMutualFriendsConnection aq;
    @Nullable
    public String ar;
    public ImmutableList<String> as;
    @Nullable
    public GraphQLNewsFeedConnection at;
    @Nullable
    public GraphQLPrivacyScope au;
    @Nullable
    public GraphQLImage av;
    @Nullable
    public GraphQLImage aw;
    @Nullable
    public GraphQLImage ax;
    @Nullable
    public GraphQLImage ay;
    @Nullable
    public GraphQLImage az;
    public ImmutableList<GraphQLName> ba;
    public GraphQLSubscribeStatus bb = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage bc;
    @Nullable
    public GraphQLTextWithEntities bd;
    @Nullable
    public GraphQLTimelineSectionsConnection be;
    @Nullable
    public GraphQLTimelineStoriesConnection bf;
    @Nullable
    public GraphQLImage bg;
    public int bh;
    @Nullable
    public GraphQLUnseenStoriesConnection bi;
    @Nullable
    public String bj;
    @Nullable
    public String bk;
    public boolean bl;
    public boolean bm;
    @Nullable
    public GraphQLProfile bn;
    public boolean bo;
    public boolean bp;
    public boolean bq;
    public boolean br;
    public int bs;
    public int bt;
    @Nullable
    public GraphQLTextWithEntities bu;
    @Nullable
    public GraphQLTextWithEntities bv;
    public double bw;
    public ImmutableList<String> bx;
    public double by;
    @Nullable
    public GraphQLUserWorkExperiencesConnection bz;
    @Nullable
    public GraphQLImage f13419d;
    @Nullable
    public GraphQLStreetAddress f13420e;
    @Nullable
    public GraphQLImage f13421f;
    @Nullable
    public GraphQLAlbumsConnection f13422g;
    @Nullable
    public String f13423h;
    @Nullable
    public String f13424i;
    @Nullable
    public GraphQLImage f13425j;
    @Nullable
    public GraphQLTextWithEntities f13426k;
    @Nullable
    public GraphQLFriendsConnection f13427l;
    @Nullable
    public GraphQLFocusedPhoto f13428m;
    public ImmutableList<GraphQLBylineFragment> f13429n;
    public boolean f13430o;
    public boolean f13431p;
    public boolean f13432q;
    public boolean f13433r;
    public boolean f13434s;
    public boolean f13435t;
    public boolean f13436u;
    public double f13437v;
    @Nullable
    public GraphQLContact f13438w;
    @Nullable
    public GraphQLFocusedPhoto f13439x;
    public long f13440y;
    @Nullable
    public GraphQLPage f13441z;

    public GraphQLUser$Builder() {
        Preconditions.checkState(this instanceof GraphQLUser$Builder);
    }

    public final GraphQLUser m22381a() {
        return new GraphQLUser(this);
    }
}
