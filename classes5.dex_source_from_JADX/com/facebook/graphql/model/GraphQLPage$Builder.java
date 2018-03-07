package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLCommercePageSetting;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLReactionRequestedUnit;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: entry no longer in map */
public class GraphQLPage$Builder extends Builder {
    public ImmutableList<String> f4693A;
    public GraphQLPageCategoryType f4694B = GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPage f4695C;
    public ImmutableList<GraphQLCommercePageSetting> f4696D;
    public GraphQLCommercePageType f4697E = GraphQLCommercePageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLContact f4698F;
    @Nullable
    public String f4699G;
    @Nullable
    public GraphQLFocusedPhoto f4700H;
    @Nullable
    public String f4701I;
    public boolean f4702J;
    public ImmutableList<String> f4703K;
    @Nullable
    public GraphQLTextWithEntities f4704L;
    public boolean f4705M;
    public int f4706N;
    public GraphQLEventsCalendarSubscriptionStatus f4707O = GraphQLEventsCalendarSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEventsOccurringHereConnection f4708P;
    public boolean f4709Q;
    @Nullable
    public GraphQLVideo f4710R;
    @Nullable
    public GraphQLImage f4711S;
    @Nullable
    public GraphQLTimelineSectionsConnection f4712T;
    @Nullable
    public GraphQLFollowUpFeedUnitsConnection f4713U;
    @Nullable
    public GraphQLFriendsWhoLikeConnection f4714V;
    @Nullable
    public GraphQLFriendsWhoVisitedConnection f4715W;
    @Nullable
    public String f4716X;
    public ImmutableList<GraphQLTimeRange> f4717Y;
    @Nullable
    public String f4718Z;
    public int aA;
    @Nullable
    public GraphQLPageMenuInfo aB;
    @Nullable
    public String aC;
    @Nullable
    public String aD;
    @Nullable
    public GraphQLOpenGraphObject aE;
    @Nullable
    public String aF;
    public ImmutableList<String> aG;
    @Nullable
    public String aH;
    public int aI;
    @Nullable
    public GraphQLStoryAttachment aJ;
    public double aK;
    @Nullable
    public GraphQLRating aL;
    @Nullable
    public GraphQLOwnedEventsConnection aM;
    @Nullable
    public GraphQLImage aN;
    @Nullable
    public GraphQLPageCallToAction aO;
    @Nullable
    public GraphQLImage aP;
    @Nullable
    public GraphQLPageLikersConnection aQ;
    @Nullable
    public GraphQLImage aR;
    public GraphQLReactionRequestedUnit aS = GraphQLReactionRequestedUnit.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLPagePaymentOption> aT;
    @Nullable
    public GraphQLImage aU;
    @Nullable
    public GraphQLPageVisitsConnection aV;
    public int aW;
    public GraphQLPermanentlyClosedStatus aX = GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPhoneNumber aY;
    @Nullable
    public GraphQLImage aZ;
    @Nullable
    public GraphQLImage aa;
    @Nullable
    public GraphQLInlineActivitiesConnection ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public boolean af;
    public boolean ag;
    public boolean ah;
    public boolean ai;
    public boolean aj;
    public boolean ak;
    public boolean al;
    public boolean am;
    public boolean an;
    public boolean ao;
    public boolean ap;
    public boolean aq;
    public boolean ar;
    public boolean as;
    public boolean at;
    public boolean au;
    @Nullable
    public GraphQLLikedProfilesConnection av;
    public GraphQLLiveVideoSubscriptionStatus aw = GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String ax;
    @Nullable
    public GraphQLLocation ay;
    @Nullable
    public GraphQLGeoRectangle az;
    @Nullable
    public GraphQLImage bA;
    public ImmutableList<GraphQLRedirectionInfo> bB;
    @Nullable
    public String bC;
    public ImmutableList<GraphQLPhoto> bD;
    @Nullable
    public String bE;
    @Nullable
    public String bF;
    @Nullable
    public GraphQLTextWithEntities bG;
    @Nullable
    public GraphQLContactRecommendationField bH;
    @Nullable
    public GraphQLTimelineAppCollection bI;
    public GraphQLSecondarySubscribeStatus bJ = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<String> bK;
    public boolean bL;
    public boolean bM;
    public boolean bN;
    public boolean bO;
    public boolean bP;
    public boolean bQ;
    public boolean bR;
    public boolean bS;
    public boolean bT;
    public boolean bU;
    @Nullable
    public GraphQLSinglePublisherVideoChannelsConnection bV;
    @Nullable
    public GraphQLSportsDataMatchData bW;
    public ImmutableList<String> bX;
    @Nullable
    public GraphQLTextWithEntities bY;
    @Nullable
    public GraphQLImage bZ;
    @Nullable
    public GraphQLTextWithEntities ba;
    public GraphQLPageOpenHoursDisplayDecisionEnum bb = GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String bc;
    public GraphQLPlaceType bd = GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPrivacyScope be;
    @Nullable
    public GraphQLPostedPhotosConnection bf;
    @Nullable
    public String bg;
    @Nullable
    public GraphQLPrivacyOption bh;
    @Nullable
    public GraphQLImage bi;
    @Nullable
    public GraphQLImage bj;
    @Nullable
    public GraphQLImage bk;
    @Nullable
    public GraphQLImage bl;
    @Nullable
    public GraphQLImage bm;
    @Nullable
    public GraphQLImage bn;
    @Nullable
    public GraphQLImage bo;
    @Nullable
    public GraphQLImage bp;
    @Nullable
    public GraphQLImage bq;
    @Nullable
    public GraphQLPhoto br;
    @Nullable
    public GraphQLImage bs;
    @Nullable
    public GraphQLImage bt;
    @Nullable
    public GraphQLImage bu;
    @Nullable
    public GraphQLImage bv;
    public boolean bw;
    @Nullable
    public GraphQLProfileVideo bx;
    @Nullable
    public GraphQLPageStarRatersConnection by;
    public int bz;
    public int cA;
    public int cB;
    @Nullable
    public GraphQLTextWithEntities cC;
    @Nullable
    public GraphQLTextWithEntities cD;
    public boolean cE;
    public ImmutableList<String> cF;
    @Nullable
    public GraphQLContactRecommendationField cG;
    public GraphQLSavedState cH = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLRating cI;
    public ImmutableList<GraphQLTimelineAppCollection> cJ;
    public ImmutableList<GraphQLTimelineAppCollection> cK;
    @Nullable
    public GraphQLViewerVisitsConnection cL;
    public ImmutableList<String> cM;
    @Nullable
    public GraphQLImage ca;
    @Nullable
    public GraphQLImage cb;
    @Nullable
    public GraphQLStreamingImage cc;
    public GraphQLSubscribeStatus cd = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLPageSuperCategoryType ce = GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage cf;
    @Nullable
    public GraphQLStory cg;
    @Nullable
    public GraphQLTimelineSectionsConnection ch;
    @Nullable
    public GraphQLTimelineStoriesConnection ci;
    @Nullable
    public String cj;
    @Nullable
    public GraphQLNode ck;
    @Nullable
    public GraphQLImage cl;
    @Nullable
    public GraphQLTrendingTopicData cm;
    @Nullable
    public String cn;
    @Nullable
    public String co;
    public int cp;
    @Nullable
    public String cq;
    @Nullable
    public String cr;
    public GraphQLPageVerificationBadge cs = GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean ct;
    public boolean cu;
    @Nullable
    public GraphQLProfile cv;
    public boolean cw;
    public boolean cx;
    public boolean cy;
    public boolean cz;
    @Nullable
    public GraphQLTextWithEntities f4719d;
    @Nullable
    public GraphQLPageAdminInfo f4720e;
    @Nullable
    public GraphQLStreetAddress f4721f;
    @Nullable
    public GraphQLPageAdminInfo f4722g;
    @Nullable
    public GraphQLAlbumsConnection f4723h;
    public ImmutableList<String> f4724i;
    public ImmutableList<GraphQLAttributionEntry> f4725j;
    @Nullable
    public String f4726k;
    public int f4727l;
    @Nullable
    public GraphQLTextWithEntities f4728m;
    @Nullable
    public GraphQLFocusedPhoto f4729n;
    public ImmutableList<GraphQLBusinessInfo> f4730o;
    public boolean f4731p;
    public boolean f4732q;
    public boolean f4733r;
    public boolean f4734s;
    public boolean f4735t;
    public boolean f4736u;
    public boolean f4737v;
    public boolean f4738w;
    public boolean f4739x;
    public ImmutableList<String> f4740y;
    @Nullable
    public GraphQLImage f4741z;

    public GraphQLPage$Builder() {
        Preconditions.checkState(this instanceof GraphQLPage$Builder);
    }

    public final GraphQLPage m9460a() {
        return new GraphQLPage(this);
    }
}
