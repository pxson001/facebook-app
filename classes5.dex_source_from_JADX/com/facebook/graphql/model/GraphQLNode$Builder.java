package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLAdsExperienceStatusEnum;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLCommerceCheckoutStyle;
import com.facebook.graphql.enums.GraphQLCommercePageType;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLCouponClaimLocation;
import com.facebook.graphql.enums.GraphQLEditPostFeatureCapability;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventPrivacyType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupCommercePriceType;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLMessengerCommerceBubbleType;
import com.facebook.graphql.enums.GraphQLMessengerRetailItemStatus;
import com.facebook.graphql.enums.GraphQLMovieBotMovieListStyle;
import com.facebook.graphql.enums.GraphQLMusicType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.graphql.enums.GraphQLPageProductTransactionOrderStatusEnum;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPermanentlyClosedStatus;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLQuestionPollAnswersState;
import com.facebook.graphql.enums.GraphQLQuestionResponseMethod;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLShipmentTrackingEventType;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubstoriesGroupingReason;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.enums.GraphQLTimelineContactItemType;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: event_privacy_type */
public class GraphQLNode$Builder extends Builder {
    @Nullable
    public GraphQLSubstoriesConnection f4563A;
    @Nullable
    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection f4564B;
    @Nullable
    public GraphQLCurrencyQuantity f4565C;
    @Nullable
    public String f4566D;
    @Nullable
    public GraphQLAndroidAppConfig f4567E;
    public int f4568F;
    @Nullable
    public String f4569G;
    public ImmutableList<String> f4570H;
    @Nullable
    public GraphQLImage f4571I;
    @Nullable
    public GraphQLImage f4572J;
    public ImmutableList<String> f4573K;
    @Nullable
    public GraphQLImage f4574L;
    @Nullable
    public GraphQLImage f4575M;
    @Nullable
    public GraphQLUser f4576N;
    @Nullable
    public String f4577O;
    @Nullable
    public String f4578P;
    @Nullable
    public GraphQLAppStoreApplication f4579Q;
    @Nullable
    public GraphQLApplication f4580R;
    @Nullable
    public String f4581S;
    @Nullable
    public String f4582T;
    public ImmutableList<String> f4583U;
    public ImmutableList<GraphQLProfile> f4584V;
    public int f4585W;
    public ImmutableList<GraphQLStoryActionLink> f4586X;
    @Nullable
    public GraphQLStory f4587Y;
    public ImmutableList<GraphQLStoryAttachment> f4588Z;
    public boolean aA;
    public boolean aB;
    public boolean aC;
    public boolean aD;
    public boolean aE;
    public boolean aF;
    public boolean aG;
    public boolean aH;
    public boolean aI;
    public boolean aJ;
    public boolean aK;
    public boolean aL;
    public boolean aM;
    public boolean aN;
    public boolean aO;
    public boolean aP;
    public boolean aQ;
    public boolean aR;
    public boolean aS;
    public boolean aT;
    public boolean aU;
    public boolean aV;
    public boolean aW;
    public boolean aX;
    public boolean aY;
    public boolean aZ;
    public ImmutableList<GraphQLAttributionEntry> aa;
    @Nullable
    public String ab;
    @Nullable
    public String ac;
    public double ad;
    @Nullable
    public String ae;
    @Nullable
    public String af;
    @Nullable
    public GraphQLImage ag;
    @Nullable
    public GraphQLTextWithEntities ah;
    public int ai;
    @Nullable
    public GraphQLFocusedPhoto aj;
    @Nullable
    public String ak;
    @Nullable
    public String al;
    @Nullable
    public String am;
    public GraphQLVideoBroadcastStatus an = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLMessengerCommerceBubbleType ao = GraphQLMessengerCommerceBubbleType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLBusinessInfo> ap;
    @Nullable
    public String aq;
    @Nullable
    public String ar;
    public ImmutableList<GraphQLBylineFragment> as;
    @Nullable
    public String at;
    @Nullable
    public String au;
    @Nullable
    public GraphQLFundraiserCampaign av;
    @Nullable
    public String aw;
    @Nullable
    public String ax;
    public boolean ay;
    public boolean az;
    @Nullable
    public GraphQLGroup bA;
    public long bB;
    @Nullable
    public GraphQLStory bC;
    public long bD;
    @Nullable
    public GraphQLActor bE;
    @Nullable
    public GraphQLImage bF;
    @Nullable
    public GraphQLVideo bG;
    @Nullable
    public String bH;
    @Nullable
    public GraphQLCurrencyQuantity bI;
    @Nullable
    public GraphQLGoodwillThrowbackDataPointsConnection bJ;
    @Nullable
    public String bK;
    @Nullable
    public String bL;
    @Nullable
    public String bM;
    @Nullable
    public String bN;
    @Nullable
    public String bO;
    @Nullable
    public GraphQLLocation bP;
    @Nullable
    public String bQ;
    @Nullable
    public String bR;
    @Nullable
    public String bS;
    @Nullable
    public GraphQLTextWithEntities bT;
    public boolean bU;
    @Nullable
    public String bV;
    public double bW;
    @Nullable
    public String bX;
    public boolean bY;
    @Nullable
    public String bZ;
    public boolean ba;
    @Nullable
    public String bb;
    @Nullable
    public String bc;
    public ImmutableList<String> bd;
    public ImmutableList<String> be;
    public GraphQLPageCategoryType bf = GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLFundraiserCharity bg;
    @Nullable
    public String bh;
    @Nullable
    public String bi;
    @Nullable
    public GraphQLPage bj;
    @Nullable
    public String bk;
    public long bl;
    public ImmutableList<String> bm;
    @Nullable
    public GraphQLCommentsConnection bn;
    @Nullable
    public String bo;
    public GraphQLCommerceCheckoutStyle bp = GraphQLCommerceCheckoutStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean bq;
    public GraphQLCommercePageType br = GraphQLCommercePageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLCommerceProductVisibility bs = GraphQLCommerceProductVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String bt;
    public GraphQLConnectionStyle bu = GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLLocation bv;
    @Nullable
    public String bw;
    public GraphQLCouponClaimLocation bx = GraphQLCouponClaimLocation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLFocusedPhoto by;
    @Nullable
    public String bz;
    @Nullable
    public String cA;
    public GraphQLEventType cB = GraphQLEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEventViewerCapability cC;
    public GraphQLEventVisibility cD = GraphQLEventVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String cE;
    public long cF;
    public long cG;
    @Nullable
    public GraphQLPlace cH;
    public boolean cI;
    @Nullable
    public String cJ;
    @Nullable
    public GraphQLImage cK;
    @Nullable
    public String cL;
    @Nullable
    public String cM;
    @Nullable
    public GraphQLFeedTopicContent cN;
    @Nullable
    public FeedUnit cO;
    @Nullable
    public GraphQLFeedback cP;
    @Nullable
    public GraphQLFeedbackContext cQ;
    @Nullable
    public GraphQLGraphSearchQueryFilterValuesConnection cR;
    public int cS;
    @Nullable
    public String cT;
    @Nullable
    public String cU;
    @Nullable
    public String cV;
    @Nullable
    public String cW;
    @Nullable
    public String cX;
    @Nullable
    public String cY;
    @Nullable
    public String cZ;
    @Nullable
    public GraphQLFundraiserPersonToCharityDonorsConnection ca;
    @Nullable
    public String cb;
    public int cc;
    @Nullable
    public GraphQLEditHistoryConnection cd;
    public ImmutableList<String> ce;
    @Nullable
    public GraphQLEmotionalAnalysis cf;
    @Nullable
    public GraphQLPage cg;
    public long ch;
    public ImmutableList<GraphQLLeadGenErrorNode> ci;
    @Nullable
    public String cj;
    @Nullable
    public String ck;
    @Nullable
    public String cl;
    public int cm;
    @Nullable
    public GraphQLEventCategoryData cn;
    @Nullable
    public GraphQLImage co;
    @Nullable
    public String cp;
    @Nullable
    public GraphQLLocation cq;
    @Nullable
    public GraphQLFocusedPhoto cr;
    @Nullable
    public GraphQLActor cs;
    @Nullable
    public GraphQLTextWithEntities ct;
    @Nullable
    public GraphQLEventHostsConnection cu;
    public GraphQLEventPrivacyType cv = GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLEventMembersConnection cw;
    @Nullable
    public GraphQLPlace cx;
    public GraphQLEventPrivacyType cy = GraphQLEventPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLBoostedPostStatus cz = GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLImage f4589d;
    public boolean dA;
    public int dB;
    public int dC;
    @Nullable
    public GraphQLPhoto dD;
    public int dE;
    @Nullable
    public String dF;
    public ImmutableList<GraphQLTimeRange> dG;
    @Nullable
    public String dH;
    @Nullable
    public GraphQLIcon dI;
    @Nullable
    public GraphQLImage dJ;
    @Nullable
    public String dK;
    @Nullable
    public GraphQLImage dL;
    @Nullable
    public GraphQLImage dM;
    @Nullable
    public GraphQLImage dN;
    @Nullable
    public GraphQLImage dO;
    @Nullable
    public String dP;
    @Nullable
    public String dQ;
    @Nullable
    public GraphQLPlace dR;
    @Nullable
    public GraphQLImportantReactorsConnection dS;
    public int dT;
    public int dU;
    public int dV;
    @Nullable
    public GraphQLInlineActivitiesConnection dW;
    @Nullable
    public GraphQLStoryInsights dX;
    @Nullable
    public GraphQLInstantArticle dY;
    public boolean dZ;
    @Nullable
    public String da;
    @Nullable
    public GraphQLFollowUpFeedUnitsConnection db;
    @Nullable
    public String dc;
    @Nullable
    public String dd;
    @Nullable
    public String de;
    @Nullable
    public String df;
    @Nullable
    public GraphQLEventMaybesConnection dg;
    @Nullable
    public GraphQLEventMembersConnection dh;
    @Nullable
    public GraphQLEventWatchersConnection di;
    @Nullable
    public GraphQLFriendsConnection dj;
    public GraphQLFriendshipStatus dk = GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities dl;
    @Nullable
    public GraphQLFundraiserPage dm;
    @Nullable
    public GraphQLExternalUrl dn;
    @Nullable
    public GraphQLTextWithEntities f4590do;
    @Nullable
    public String dp;
    @Nullable
    public GraphQLGreetingCardTemplate dq;
    @Nullable
    public GraphQLTextWithEntities dr;
    @Nullable
    public GraphQLGroupMembersConnection ds;
    @Nullable
    public GraphQLGroupOwnerAuthoredStoriesConnection dt;
    @Nullable
    public GraphQLImage du;
    @Nullable
    public GraphQLVideoGuidedTour dv;
    public boolean dw;
    public boolean dx;
    public boolean dy;
    public boolean dz;
    @Nullable
    public String f4591e;
    public boolean eA;
    public boolean eB;
    @Nullable
    public GraphQLCurrencyQuantity eC;
    public GraphQLTimelineContactItemType eD = GraphQLTimelineContactItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String eE;
    @Nullable
    public String eF;
    @Nullable
    public GraphQLInstantArticleVersion eG;
    @Nullable
    public GraphQLLeadGenData eH;
    @Nullable
    public GraphQLLeadGenDeepLinkUserStatus eI;
    @Nullable
    public String eJ;
    @Nullable
    public String eK;
    @Nullable
    public GraphQLTextWithEntities eL;
    @Nullable
    public GraphQLLikersOfContentConnection eM;
    @Nullable
    public GraphQLMedia eN;
    @Nullable
    public GraphQLFriendListFeedConnection eO;
    @Nullable
    public GraphQLPlaceListItemsFromPlaceListConnection eP;
    @Nullable
    public String eQ;
    public int eR;
    public int eS;
    @Nullable
    public String eT;
    @Nullable
    public GraphQLLocation eU;
    @Nullable
    public GraphQLImage eV;
    @Nullable
    public GraphQLImage eW;
    public int eX;
    public ImmutableList<GraphQLLocation> eY;
    public int eZ;
    public boolean ea;
    public boolean eb;
    public boolean ec;
    public boolean ed;
    public boolean ee;
    public boolean ef;
    public boolean eg;
    public boolean eh;
    public boolean ei;
    public boolean ej;
    public boolean ek;
    public boolean el;
    public boolean em;
    public boolean en;
    public boolean eo;
    public boolean ep;
    public boolean eq;
    public boolean er;
    public boolean es;
    public boolean et;
    public boolean eu;
    public boolean ev;
    public boolean ew;
    public boolean ex;
    public boolean ey;
    public boolean ez;
    public ImmutableList<GraphQLStoryActionLink> f4592f;
    @Nullable
    public GraphQLPage fA;
    public boolean fB;
    @Nullable
    public String fC;
    @Nullable
    public GraphQLStoryAttachment fD;
    @Nullable
    public GraphQLOpenGraphMetadata fE;
    @Nullable
    public GraphQLNode fF;
    @Nullable
    public GraphQLQuestionOptionsConnection fG;
    @Nullable
    public String fH;
    @Nullable
    public String fI;
    public double fJ;
    @Nullable
    public GraphQLRating fK;
    @Nullable
    public GraphQLActor fL;
    @Nullable
    public GraphQLPage fM;
    @Nullable
    public GraphQLPage fN;
    @Nullable
    public GraphQLPageCallToAction fO;
    @Nullable
    public GraphQLPageLikersConnection fP;
    public ImmutableList<GraphQLPagePaymentOption> fQ;
    public int fR;
    @Nullable
    public GraphQLGroup fS;
    @Nullable
    public GraphQLStory fT;
    @Nullable
    public GraphQLImage fU;
    @Nullable
    public String fV;
    @Nullable
    public String fW;
    @Nullable
    public String fX;
    @Nullable
    public String fY;
    @Nullable
    public String fZ;
    @Nullable
    public GraphQLMediaSetMediaConnection fa;
    @Nullable
    public GraphQLSouvenirMediaConnection fb;
    @Nullable
    public GraphQLMediaQuestionOptionsConnection fc;
    public ImmutableList<GraphQLPhoto> fd;
    @Nullable
    public String fe;
    @Nullable
    public GraphQLMediaSet ff;
    @Nullable
    public GraphQLPageMenuInfo fg;
    @Nullable
    public GraphQLTextWithEntities fh;
    @Nullable
    public String fi;
    @Nullable
    public String fj;
    @Nullable
    public GraphQLTextWithEntities fk;
    @Nullable
    public String fl;
    @Nullable
    public GraphQLContact fm;
    @Nullable
    public GraphQLMessengerContentSubscriptionOption fn;
    public long fo;
    public GraphQLMovieBotMovieListStyle fp = GraphQLMovieBotMovieListStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLStoryAttachment> fq;
    @Nullable
    public GraphQLOpenGraphObject fr;
    @Nullable
    public String fs;
    public GraphQLMusicType ft = GraphQLMusicType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLOpenGraphObject> fu;
    @Nullable
    public GraphQLMutualFriendsConnection fv;
    @Nullable
    public String fw;
    @Nullable
    public String fx;
    @Nullable
    public GraphQLNegativeFeedbackActionsConnection fy;
    @Nullable
    public String fz;
    public GraphQLEventActionStyle f4593g = GraphQLEventActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLBoostedComponent gA;
    @Nullable
    public GraphQLPostedPhotosConnection gB;
    @Nullable
    public String gC;
    @Nullable
    public GraphQLTaggableActivityPreviewTemplate gD;
    @Nullable
    public GraphQLTaggableActivityPreviewTemplate gE;
    @Nullable
    public GraphQLTaggableActivityPreviewTemplate gF;
    @Nullable
    public GraphQLTaggableActivityPreviewTemplate gG;
    @Nullable
    public GraphQLTaggableActivityPreviewTemplate gH;
    @Nullable
    public GraphQLTaggableActivityPreviewTemplate gI;
    @Nullable
    public GraphQLImage gJ;
    public ImmutableList<GraphQLAudio> gK;
    @Nullable
    public String gL;
    @Nullable
    public String gM;
    @Nullable
    public String gN;
    public GraphQLGroupCommercePriceType gO = GraphQLGroupCommercePriceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String gP;
    @Nullable
    public GraphQLImage gQ;
    @Nullable
    public GraphQLNode gR;
    @Nullable
    public GraphQLPrivacyOption gS;
    @Nullable
    public GraphQLPrivacyScope gT;
    @Nullable
    public String gU;
    public double gV;
    public double gW;
    @Nullable
    public GraphQLImage gX;
    @Nullable
    public GraphQLImage gY;
    @Nullable
    public GraphQLImage gZ;
    public ImmutableList<GraphQLPage> ga;
    public double gb;
    public GraphQLPermanentlyClosedStatus gc = GraphQLPermanentlyClosedStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPhoto gd;
    @Nullable
    public GraphQLMediaSetMediaConnection ge;
    public ImmutableList<GraphQLPhoto> gf;
    @Nullable
    public GraphQLPhrasesAnalysis gg;
    @Nullable
    public GraphQLTextWithEntities gh;
    @Nullable
    public GraphQLPlace gi;
    @Nullable
    public GraphQLCommentPlaceInfoToPlaceListItemsConnection gj;
    @Nullable
    public String gk;
    @Nullable
    public GraphQLTextWithEntities gl;
    public GraphQLPageOpenHoursDisplayDecisionEnum gm = GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLPlaceRecommendationPostInfo gn;
    public GraphQLPlaceType go = GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String gp;
    public int gq;
    @Nullable
    public String gr;
    @Nullable
    public String gs;
    public int gt;
    public int gu;
    @Nullable
    public String gv;
    @Nullable
    public String gw;
    @Nullable
    public String gx;
    public GraphQLQuestionPollAnswersState gy = GraphQLQuestionPollAnswersState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean gz;
    public ImmutableList<GraphQLOpenGraphAction> f4594h;
    @Nullable
    public String hA;
    @Nullable
    public GraphQLActor hB;
    @Nullable
    public GraphQLActor hC;
    @Nullable
    public GraphQLActor hD;
    public GraphQLQuestionResponseMethod hE = GraphQLQuestionResponseMethod.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String hF;
    @Nullable
    public GraphQLStory hG;
    @Nullable
    public GraphQLCurrencyQuantity hH;
    @Nullable
    public GraphQLStorySaveInfo hI;
    @Nullable
    public GraphQLTimelineAppCollection hJ;
    public long hK;
    @Nullable
    public GraphQLPage hL;
    @Nullable
    public GraphQLPage hM;
    @Nullable
    public String hN;
    public GraphQLSecondarySubscribeStatus hO = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLTimelineAppSectionType hP = GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String hQ;
    @Nullable
    public GraphQLSeenByConnection hR;
    public GraphQLStorySeenState hS = GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String hT;
    @Nullable
    public GraphQLActor hU;
    @Nullable
    public String hV;
    @Nullable
    public String hW;
    @Nullable
    public GraphQLUser hX;
    @Nullable
    public String hY;
    @Nullable
    public String hZ;
    @Nullable
    public GraphQLImage ha;
    @Nullable
    public GraphQLPhoto hb;
    @Nullable
    public GraphQLImage hc;
    public boolean hd;
    @Nullable
    public GraphQLProfileVideo he;
    @Nullable
    public String hf;
    @Nullable
    public String hg;
    @Nullable
    public GraphQLPagePostPromotionInfo hh;
    @Nullable
    public String hi;
    @Nullable
    public String hj;
    @Nullable
    public String hk;
    @Nullable
    public GraphQLGraphSearchQueryTitle hl;
    @Nullable
    public GraphQLTextWithEntities hm;
    @Nullable
    public GraphQLQuotesAnalysis hn;
    @Nullable
    public GraphQLRating ho;
    @Nullable
    public GraphQLReactorsOfContentConnection hp;
    @Nullable
    public String hq;
    @Nullable
    public GraphQLPhoto hr;
    @Nullable
    public String hs;
    @Nullable
    public GraphQLUser ht;
    @Nullable
    public GraphQLImage hu;
    @Nullable
    public String hv;
    @Nullable
    public String hw;
    public ImmutableList<GraphQLRedirectionInfo> hx;
    @Nullable
    public GraphQLRedSpaceStoryInfo hy;
    @Nullable
    public GraphQLSticker hz;
    @Nullable
    public GraphQLPageAdminInfo f4595i;
    @Nullable
    public String iA;
    @Nullable
    public GraphQLLocation iB;
    @Nullable
    public String iC;
    @Nullable
    public GraphQLPhoto iD;
    public double iE;
    public double iF;
    @Nullable
    public String iG;
    @Nullable
    public String iH;
    public int iI;
    @Nullable
    public String iJ;
    @Nullable
    public String iK;
    @Nullable
    public GraphQLSponsoredData iL;
    @Nullable
    public GraphQLSportsDataMatchData iM;
    @Nullable
    public GraphQLImage iN;
    public long iO;
    @Nullable
    public String iP;
    @Nullable
    public String iQ;
    public GraphQLMessengerRetailItemStatus iR = GraphQLMessengerRetailItemStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLStory iS;
    @Nullable
    public GraphQLStoryAttachment iT;
    @Nullable
    public GraphQLStoryHeader iU;
    @Nullable
    public GraphQLName iV;
    @Nullable
    public GraphQLStructuredSurvey iW;
    @Nullable
    public String iX;
    public GraphQLSubscribeStatus iY = GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLSubstoriesGroupingReason> iZ;
    @Nullable
    public String ia;
    @Nullable
    public GraphQLStory ib;
    @Nullable
    public GraphQLEntity ic;
    @Nullable
    public String id;
    public GraphQLShipmentTrackingEventType ie = GraphQLShipmentTrackingEventType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities f4596if;
    @Nullable
    public String ig;
    @Nullable
    public String ih;
    public boolean ii;
    public boolean ij;
    public boolean ik;
    public boolean il;
    public boolean im;
    public boolean in;
    public boolean io;
    public boolean ip;
    public boolean iq;
    public boolean ir;
    public boolean is;
    public boolean it;
    @Nullable
    public GraphQLGreetingCardSlidesConnection iu;
    @Nullable
    public String iv;
    @Nullable
    public GraphQLTextWithEntities iw;
    @Nullable
    public String ix;
    @Nullable
    public GraphQLTextWithEntities iy;
    @Nullable
    public GraphQLTextWithEntities iz;
    @Nullable
    public GraphQLActor f4597j;
    @Nullable
    public GraphQLImage jA;
    @Nullable
    public GraphQLTextWithEntities jB;
    @Nullable
    public GraphQLTextWithEntities jC;
    @Nullable
    public GraphQLProfile jD;
    @Nullable
    public GraphQLNode jE;
    @Nullable
    public GraphQLTopLevelCommentsConnection jF;
    @Nullable
    public GraphQLTopReactionsConnection jG;
    @Nullable
    public GraphQLImage jH;
    @Nullable
    public GraphQLStoryTopicsContext jI;
    @Nullable
    public String jJ;
    @Nullable
    public String jK;
    @Nullable
    public String jL;
    @Nullable
    public String jM;
    @Nullable
    public String jN;
    @Nullable
    public String jO;
    public int jP;
    @Nullable
    public String jQ;
    public GraphQLPageProductTransactionOrderStatusEnum jR = GraphQLPageProductTransactionOrderStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public String jS;
    public int jT;
    public int jU;
    @Nullable
    public GraphQLPostTranslatability jV;
    @Nullable
    public GraphQLTextWithEntities jW;
    @Nullable
    public GraphQLTextWithEntities jX;
    @Nullable
    public GraphQLTranslationMetaData jY;
    @Nullable
    public GraphQLTrendingTopicData jZ;
    public int ja;
    @Nullable
    public GraphQLTextWithEntities jb;
    @Nullable
    public GraphQLTextWithEntities jc;
    @Nullable
    public GraphQLTextWithEntities jd;
    public GraphQLPageSuperCategoryType je = GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLStory jf;
    public ImmutableList<GraphQLFeedbackReaction> jg;
    public boolean jh;
    @Nullable
    public String ji;
    @Nullable
    public String jj;
    @Nullable
    public String jk;
    @Nullable
    public String jl;
    @Nullable
    public String jm;
    @Nullable
    public String jn;
    @Nullable
    public GraphQLImage jo;
    @Nullable
    public GraphQLOpenGraphMetadata jp;
    @Nullable
    public String jq;
    @Nullable
    public GraphQLImage jr;
    public ImmutableList<GraphQLMedia> js;
    public ImmutableList<GraphQLStoryAttachment> jt;
    public int ju;
    @Nullable
    public GraphQLEventTimeRange jv;
    @Nullable
    public String jw;
    @Nullable
    public String jx;
    @Nullable
    public String jy;
    @Nullable
    public String jz;
    public ImmutableList<GraphQLActor> f4598k;
    public GraphQLGroupJoinState kA = GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities kB;
    public ImmutableList<String> kC;
    public boolean kD;
    @Nullable
    public GraphQLContactRecommendationField kE;
    public GraphQLSavedState kF = GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLTimelineAppCollection> kG;
    public ImmutableList<GraphQLTimelineAppCollection> kH;
    public GraphQLEventWatchStatus kI = GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public GraphQLGroupVisibility kJ = GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLTextWithEntities kK;
    public ImmutableList<String> kL;
    @Nullable
    public String kM;
    public int kN;
    @Nullable
    public GraphQLWithTagsConnection kO;
    @Nullable
    public GraphQLPage kP;
    @Nullable
    public GraphQLObjectType kQ = null;
    @Nullable
    public String ka;
    @Nullable
    public String kb;
    public int kc;
    @Nullable
    public String kd;
    @Nullable
    public String ke;
    @Nullable
    public String kf;
    @Nullable
    public String kg;
    @Nullable
    public GraphQLTextWithEntities kh;
    public GraphQLPageVerificationBadge ki = GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    @Nullable
    public GraphQLActor kj;
    public ImmutableList<String> kk;
    @Nullable
    public GraphQLVideoChannel kl;
    public int km;
    @Nullable
    public String kn;
    @Nullable
    public String ko;
    @Nullable
    public String kp;
    @Nullable
    public String kq;
    @Nullable
    public GraphQLPage kr;
    @Nullable
    public GraphQLUser ks;
    @Nullable
    public GraphQLTextWithEntities kt;
    public ImmutableList<GraphQLEditPostFeatureCapability> ku;
    public int kv;
    public GraphQLEventGuestStatus kw = GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public boolean kx;
    public boolean ky;
    public ImmutableList<GraphQLActor> kz;
    @Nullable
    public String f4599l;
    public GraphQLAdsExperienceStatusEnum f4600m = GraphQLAdsExperienceStatusEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    public ImmutableList<GraphQLImage> f4601n;
    @Nullable
    public GraphQLStreetAddress f4602o;
    @Nullable
    public GraphQLPageAdminInfo f4603p;
    @Nullable
    public String f4604q;
    @Nullable
    public String f4605r;
    @Nullable
    public GraphQLAlbum f4606s;
    public long f4607t;
    @Nullable
    public GraphQLAlbumsConnection f4608u;
    @Nullable
    public GraphQLPeopleYouMayInviteFeedUnitContactsConnection f4609v;
    @Nullable
    public GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsConnection f4610w;
    @Nullable
    public GraphQLSaleGroupsNearYouFeedUnitGroupsConnection f4611x;
    @Nullable
    public GraphQLAllShareStoriesConnection f4612y;
    @Nullable
    public GraphQLStorySetStoriesConnection f4613z;

    public GraphQLNode$Builder() {
        Preconditions.checkState(this instanceof GraphQLNode$Builder);
    }

    public static GraphQLNode$Builder m9282a(GraphQLNode graphQLNode) {
        GraphQLNode$Builder graphQLNode$Builder = new GraphQLNode$Builder();
        graphQLNode.h();
        graphQLNode$Builder.f4589d = graphQLNode.k();
        graphQLNode$Builder.f4591e = graphQLNode.ko();
        graphQLNode$Builder.f4592f = graphQLNode.l();
        graphQLNode$Builder.f4593g = graphQLNode.m();
        graphQLNode$Builder.f4594h = graphQLNode.n();
        graphQLNode$Builder.f4595i = graphQLNode.o();
        graphQLNode$Builder.f4597j = graphQLNode.p();
        graphQLNode$Builder.f4598k = graphQLNode.q();
        graphQLNode$Builder.f4599l = graphQLNode.kE();
        graphQLNode$Builder.f4600m = graphQLNode.kF();
        graphQLNode$Builder.f4601n = graphQLNode.r();
        graphQLNode$Builder.f4602o = graphQLNode.s();
        graphQLNode$Builder.f4603p = graphQLNode.t();
        graphQLNode$Builder.f4604q = graphQLNode.u();
        graphQLNode$Builder.f4605r = graphQLNode.v();
        graphQLNode$Builder.f4606s = graphQLNode.w();
        graphQLNode$Builder.f4607t = graphQLNode.x();
        graphQLNode$Builder.f4608u = graphQLNode.y();
        graphQLNode$Builder.f4609v = graphQLNode.z();
        graphQLNode$Builder.f4610w = graphQLNode.A();
        graphQLNode$Builder.f4611x = graphQLNode.jE();
        graphQLNode$Builder.f4612y = graphQLNode.B();
        graphQLNode$Builder.f4613z = graphQLNode.C();
        graphQLNode$Builder.f4563A = graphQLNode.D();
        graphQLNode$Builder.f4564B = graphQLNode.E();
        graphQLNode$Builder.f4565C = graphQLNode.F();
        graphQLNode$Builder.f4566D = graphQLNode.jJ();
        graphQLNode$Builder.f4567E = graphQLNode.G();
        graphQLNode$Builder.f4568F = graphQLNode.H();
        graphQLNode$Builder.f4569G = graphQLNode.I();
        graphQLNode$Builder.f4570H = graphQLNode.J();
        graphQLNode$Builder.f4571I = graphQLNode.K();
        graphQLNode$Builder.f4572J = graphQLNode.L();
        graphQLNode$Builder.f4573K = graphQLNode.M();
        graphQLNode$Builder.f4574L = graphQLNode.N();
        graphQLNode$Builder.f4575M = graphQLNode.O();
        graphQLNode$Builder.f4576N = graphQLNode.P();
        graphQLNode$Builder.f4577O = graphQLNode.Q();
        graphQLNode$Builder.f4578P = graphQLNode.R();
        graphQLNode$Builder.f4579Q = graphQLNode.S();
        graphQLNode$Builder.f4580R = graphQLNode.T();
        graphQLNode$Builder.f4581S = graphQLNode.U();
        graphQLNode$Builder.f4582T = graphQLNode.V();
        graphQLNode$Builder.f4583U = graphQLNode.W();
        graphQLNode$Builder.f4584V = graphQLNode.X();
        graphQLNode$Builder.f4585W = graphQLNode.Y();
        graphQLNode$Builder.f4586X = graphQLNode.Z();
        graphQLNode$Builder.f4587Y = graphQLNode.aa();
        graphQLNode$Builder.f4588Z = graphQLNode.ab();
        graphQLNode$Builder.aa = graphQLNode.ac();
        graphQLNode$Builder.ab = graphQLNode.ad();
        graphQLNode$Builder.ac = graphQLNode.ae();
        graphQLNode$Builder.ad = graphQLNode.af();
        graphQLNode$Builder.ae = graphQLNode.ag();
        graphQLNode$Builder.af = graphQLNode.ah();
        graphQLNode$Builder.ag = graphQLNode.jP();
        graphQLNode$Builder.ah = graphQLNode.ai();
        graphQLNode$Builder.ai = graphQLNode.aj();
        graphQLNode$Builder.aj = graphQLNode.ak();
        graphQLNode$Builder.ak = graphQLNode.al();
        graphQLNode$Builder.al = graphQLNode.am();
        graphQLNode$Builder.am = graphQLNode.an();
        graphQLNode$Builder.an = graphQLNode.ao();
        graphQLNode$Builder.ao = graphQLNode.ap();
        graphQLNode$Builder.ap = graphQLNode.aq();
        graphQLNode$Builder.aq = graphQLNode.kg();
        graphQLNode$Builder.ar = graphQLNode.kh();
        graphQLNode$Builder.as = graphQLNode.ar();
        graphQLNode$Builder.at = graphQLNode.as();
        graphQLNode$Builder.au = graphQLNode.at();
        graphQLNode$Builder.av = graphQLNode.au();
        graphQLNode$Builder.aw = graphQLNode.jK();
        graphQLNode$Builder.ax = graphQLNode.av();
        graphQLNode$Builder.ay = graphQLNode.aw();
        graphQLNode$Builder.az = graphQLNode.ax();
        graphQLNode$Builder.aA = graphQLNode.ay();
        graphQLNode$Builder.aB = graphQLNode.az();
        graphQLNode$Builder.aC = graphQLNode.aA();
        graphQLNode$Builder.aD = graphQLNode.aB();
        graphQLNode$Builder.aE = graphQLNode.aC();
        graphQLNode$Builder.aF = graphQLNode.aD();
        graphQLNode$Builder.aG = graphQLNode.aE();
        graphQLNode$Builder.aH = graphQLNode.aF();
        graphQLNode$Builder.aI = graphQLNode.aG();
        graphQLNode$Builder.aJ = graphQLNode.aH();
        graphQLNode$Builder.aK = graphQLNode.aI();
        graphQLNode$Builder.aL = graphQLNode.aJ();
        graphQLNode$Builder.aM = graphQLNode.aK();
        graphQLNode$Builder.aN = graphQLNode.kO();
        graphQLNode$Builder.aO = graphQLNode.aL();
        graphQLNode$Builder.aP = graphQLNode.aM();
        graphQLNode$Builder.aQ = graphQLNode.aN();
        graphQLNode$Builder.aR = graphQLNode.kc();
        graphQLNode$Builder.aS = graphQLNode.aO();
        graphQLNode$Builder.aT = graphQLNode.aP();
        graphQLNode$Builder.aU = graphQLNode.aQ();
        graphQLNode$Builder.aV = graphQLNode.aR();
        graphQLNode$Builder.aW = graphQLNode.aS();
        graphQLNode$Builder.aX = graphQLNode.aT();
        graphQLNode$Builder.aY = graphQLNode.aU();
        graphQLNode$Builder.aZ = graphQLNode.kW();
        graphQLNode$Builder.ba = graphQLNode.aV();
        graphQLNode$Builder.bb = graphQLNode.aW();
        graphQLNode$Builder.bc = graphQLNode.aX();
        graphQLNode$Builder.bd = graphQLNode.aY();
        graphQLNode$Builder.be = graphQLNode.aZ();
        graphQLNode$Builder.bf = graphQLNode.ba();
        graphQLNode$Builder.bg = graphQLNode.jH();
        graphQLNode$Builder.bh = graphQLNode.bb();
        graphQLNode$Builder.bi = graphQLNode.bc();
        graphQLNode$Builder.bj = graphQLNode.bd();
        graphQLNode$Builder.bk = graphQLNode.jV();
        graphQLNode$Builder.bl = graphQLNode.be();
        graphQLNode$Builder.bm = graphQLNode.bf();
        graphQLNode$Builder.bn = graphQLNode.bg();
        graphQLNode$Builder.bo = graphQLNode.bh();
        graphQLNode$Builder.bp = graphQLNode.bi();
        graphQLNode$Builder.bq = graphQLNode.bj();
        graphQLNode$Builder.br = graphQLNode.bk();
        graphQLNode$Builder.bs = graphQLNode.bl();
        graphQLNode$Builder.bt = graphQLNode.bm();
        graphQLNode$Builder.bu = graphQLNode.bn();
        graphQLNode$Builder.bv = graphQLNode.bo();
        graphQLNode$Builder.bw = graphQLNode.bp();
        graphQLNode$Builder.bx = graphQLNode.bq();
        graphQLNode$Builder.by = graphQLNode.br();
        graphQLNode$Builder.bz = graphQLNode.bs();
        graphQLNode$Builder.bA = graphQLNode.bt();
        graphQLNode$Builder.bB = graphQLNode.bu();
        graphQLNode$Builder.bC = graphQLNode.bv();
        graphQLNode$Builder.bD = graphQLNode.bw();
        graphQLNode$Builder.bE = graphQLNode.bx();
        graphQLNode$Builder.bF = graphQLNode.by();
        graphQLNode$Builder.bG = graphQLNode.kV();
        graphQLNode$Builder.bH = graphQLNode.jx();
        graphQLNode$Builder.bI = graphQLNode.bz();
        graphQLNode$Builder.bJ = graphQLNode.bA();
        graphQLNode$Builder.bK = graphQLNode.bB();
        graphQLNode$Builder.bL = graphQLNode.bC();
        graphQLNode$Builder.bM = graphQLNode.bD();
        graphQLNode$Builder.bN = graphQLNode.bE();
        graphQLNode$Builder.bO = graphQLNode.bF();
        graphQLNode$Builder.bP = graphQLNode.bG();
        graphQLNode$Builder.bQ = graphQLNode.bH();
        graphQLNode$Builder.bR = graphQLNode.bI();
        graphQLNode$Builder.bS = graphQLNode.bJ();
        graphQLNode$Builder.bT = graphQLNode.bK();
        graphQLNode$Builder.bU = graphQLNode.bL();
        graphQLNode$Builder.bV = graphQLNode.bM();
        graphQLNode$Builder.bW = graphQLNode.bN();
        graphQLNode$Builder.bX = graphQLNode.bO();
        graphQLNode$Builder.bY = graphQLNode.bP();
        graphQLNode$Builder.bZ = graphQLNode.kQ();
        graphQLNode$Builder.ca = graphQLNode.jR();
        graphQLNode$Builder.cb = graphQLNode.bQ();
        graphQLNode$Builder.cc = graphQLNode.bR();
        graphQLNode$Builder.cd = graphQLNode.bS();
        graphQLNode$Builder.ce = graphQLNode.bT();
        graphQLNode$Builder.cf = graphQLNode.bU();
        graphQLNode$Builder.cg = graphQLNode.bV();
        graphQLNode$Builder.ch = graphQLNode.bW();
        graphQLNode$Builder.ci = graphQLNode.bX();
        graphQLNode$Builder.cj = graphQLNode.bY();
        graphQLNode$Builder.ck = graphQLNode.bZ();
        graphQLNode$Builder.cl = graphQLNode.ca();
        graphQLNode$Builder.cm = graphQLNode.kI();
        graphQLNode$Builder.cn = graphQLNode.cb();
        graphQLNode$Builder.co = graphQLNode.cc();
        graphQLNode$Builder.cp = graphQLNode.cd();
        graphQLNode$Builder.cq = graphQLNode.ce();
        graphQLNode$Builder.cr = graphQLNode.cf();
        graphQLNode$Builder.cs = graphQLNode.cg();
        graphQLNode$Builder.ct = graphQLNode.ch();
        graphQLNode$Builder.cu = graphQLNode.ci();
        graphQLNode$Builder.cv = graphQLNode.cj();
        graphQLNode$Builder.cw = graphQLNode.ck();
        graphQLNode$Builder.cx = graphQLNode.cl();
        graphQLNode$Builder.cy = graphQLNode.cm();
        graphQLNode$Builder.cz = graphQLNode.jD();
        graphQLNode$Builder.cA = graphQLNode.cn();
        graphQLNode$Builder.cB = graphQLNode.co();
        graphQLNode$Builder.cC = graphQLNode.cp();
        graphQLNode$Builder.cD = graphQLNode.cq();
        graphQLNode$Builder.cE = graphQLNode.kG();
        graphQLNode$Builder.cF = graphQLNode.cr();
        graphQLNode$Builder.cG = graphQLNode.cs();
        graphQLNode$Builder.cH = graphQLNode.ct();
        graphQLNode$Builder.cI = graphQLNode.cu();
        graphQLNode$Builder.cJ = graphQLNode.cv();
        graphQLNode$Builder.cK = graphQLNode.cw();
        graphQLNode$Builder.cL = graphQLNode.cx();
        graphQLNode$Builder.cM = graphQLNode.cy();
        graphQLNode$Builder.cN = graphQLNode.cz();
        graphQLNode$Builder.cO = graphQLNode.cA();
        graphQLNode$Builder.cP = graphQLNode.cB();
        graphQLNode$Builder.cQ = graphQLNode.kf();
        graphQLNode$Builder.cR = graphQLNode.cC();
        graphQLNode$Builder.cS = graphQLNode.cD();
        graphQLNode$Builder.cT = graphQLNode.cE();
        graphQLNode$Builder.cU = graphQLNode.cF();
        graphQLNode$Builder.cV = graphQLNode.cG();
        graphQLNode$Builder.cW = graphQLNode.cH();
        graphQLNode$Builder.cX = graphQLNode.cI();
        graphQLNode$Builder.cY = graphQLNode.cJ();
        graphQLNode$Builder.cZ = graphQLNode.cK();
        graphQLNode$Builder.da = graphQLNode.cL();
        graphQLNode$Builder.db = graphQLNode.cM();
        graphQLNode$Builder.dc = graphQLNode.cN();
        graphQLNode$Builder.dd = graphQLNode.kd();
        graphQLNode$Builder.de = graphQLNode.cO();
        graphQLNode$Builder.df = graphQLNode.cP();
        graphQLNode$Builder.dg = graphQLNode.cQ();
        graphQLNode$Builder.dh = graphQLNode.cR();
        graphQLNode$Builder.di = graphQLNode.cS();
        graphQLNode$Builder.dj = graphQLNode.cT();
        graphQLNode$Builder.dk = graphQLNode.cU();
        graphQLNode$Builder.dl = graphQLNode.cV();
        graphQLNode$Builder.dm = graphQLNode.cW();
        graphQLNode$Builder.dn = graphQLNode.cX();
        graphQLNode$Builder.f4590do = graphQLNode.cY();
        graphQLNode$Builder.dp = graphQLNode.cZ();
        graphQLNode$Builder.dq = graphQLNode.da();
        graphQLNode$Builder.dr = graphQLNode.db();
        graphQLNode$Builder.ds = graphQLNode.dc();
        graphQLNode$Builder.dt = graphQLNode.dd();
        graphQLNode$Builder.du = graphQLNode.de();
        graphQLNode$Builder.dv = graphQLNode.df();
        graphQLNode$Builder.dw = graphQLNode.dg();
        graphQLNode$Builder.dx = graphQLNode.jL();
        graphQLNode$Builder.dy = graphQLNode.dh();
        graphQLNode$Builder.dz = graphQLNode.kq();
        graphQLNode$Builder.dA = graphQLNode.kr();
        graphQLNode$Builder.dB = graphQLNode.di();
        graphQLNode$Builder.dC = graphQLNode.dj();
        graphQLNode$Builder.dD = graphQLNode.jI();
        graphQLNode$Builder.dE = graphQLNode.ks();
        graphQLNode$Builder.dF = graphQLNode.dk();
        graphQLNode$Builder.dG = graphQLNode.dl();
        graphQLNode$Builder.dH = graphQLNode.dm();
        graphQLNode$Builder.dI = graphQLNode.dn();
        graphQLNode$Builder.dJ = graphQLNode.do();
        graphQLNode$Builder.dK = graphQLNode.dp();
        graphQLNode$Builder.dL = graphQLNode.dq();
        graphQLNode$Builder.dM = graphQLNode.dr();
        graphQLNode$Builder.dN = graphQLNode.ds();
        graphQLNode$Builder.dO = graphQLNode.kt();
        graphQLNode$Builder.dP = graphQLNode.dt();
        graphQLNode$Builder.dQ = graphQLNode.du();
        graphQLNode$Builder.dR = graphQLNode.dv();
        graphQLNode$Builder.dS = graphQLNode.kj();
        graphQLNode$Builder.dT = graphQLNode.dw();
        graphQLNode$Builder.dU = graphQLNode.dx();
        graphQLNode$Builder.dV = graphQLNode.dy();
        graphQLNode$Builder.dW = graphQLNode.dz();
        graphQLNode$Builder.dX = graphQLNode.dA();
        graphQLNode$Builder.dY = graphQLNode.dB();
        graphQLNode$Builder.dZ = graphQLNode.dC();
        graphQLNode$Builder.ea = graphQLNode.dD();
        graphQLNode$Builder.eb = graphQLNode.dE();
        graphQLNode$Builder.ec = graphQLNode.dF();
        graphQLNode$Builder.ed = graphQLNode.dG();
        graphQLNode$Builder.ee = graphQLNode.dH();
        graphQLNode$Builder.ef = graphQLNode.dI();
        graphQLNode$Builder.eg = graphQLNode.dJ();
        graphQLNode$Builder.eh = graphQLNode.dK();
        graphQLNode$Builder.ei = graphQLNode.dL();
        graphQLNode$Builder.ej = graphQLNode.dM();
        graphQLNode$Builder.ek = graphQLNode.dN();
        graphQLNode$Builder.el = graphQLNode.ku();
        graphQLNode$Builder.em = graphQLNode.dO();
        graphQLNode$Builder.en = graphQLNode.dP();
        graphQLNode$Builder.eo = graphQLNode.dQ();
        graphQLNode$Builder.ep = graphQLNode.dR();
        graphQLNode$Builder.eq = graphQLNode.dS();
        graphQLNode$Builder.er = graphQLNode.dT();
        graphQLNode$Builder.es = graphQLNode.dU();
        graphQLNode$Builder.et = graphQLNode.dV();
        graphQLNode$Builder.eu = graphQLNode.dW();
        graphQLNode$Builder.ev = graphQLNode.dX();
        graphQLNode$Builder.ew = graphQLNode.dY();
        graphQLNode$Builder.ex = graphQLNode.dZ();
        graphQLNode$Builder.ey = graphQLNode.kv();
        graphQLNode$Builder.ez = graphQLNode.ea();
        graphQLNode$Builder.eA = graphQLNode.eb();
        graphQLNode$Builder.eB = graphQLNode.ke();
        graphQLNode$Builder.eC = graphQLNode.ec();
        graphQLNode$Builder.eD = graphQLNode.ed();
        graphQLNode$Builder.eE = graphQLNode.ee();
        graphQLNode$Builder.eF = graphQLNode.ef();
        graphQLNode$Builder.eG = graphQLNode.kR();
        graphQLNode$Builder.eH = graphQLNode.eg();
        graphQLNode$Builder.eI = graphQLNode.eh();
        graphQLNode$Builder.eJ = graphQLNode.ei();
        graphQLNode$Builder.eK = graphQLNode.ej();
        graphQLNode$Builder.eL = graphQLNode.ek();
        graphQLNode$Builder.eM = graphQLNode.el();
        graphQLNode$Builder.eN = graphQLNode.em();
        graphQLNode$Builder.eO = graphQLNode.en();
        graphQLNode$Builder.eP = graphQLNode.jF();
        graphQLNode$Builder.eQ = graphQLNode.eo();
        graphQLNode$Builder.eR = graphQLNode.ep();
        graphQLNode$Builder.eS = graphQLNode.eq();
        graphQLNode$Builder.eT = graphQLNode.kB();
        graphQLNode$Builder.eU = graphQLNode.er();
        graphQLNode$Builder.eV = graphQLNode.es();
        graphQLNode$Builder.eW = graphQLNode.et();
        graphQLNode$Builder.eX = graphQLNode.kw();
        graphQLNode$Builder.eY = graphQLNode.eu();
        graphQLNode$Builder.eZ = graphQLNode.ev();
        graphQLNode$Builder.fa = graphQLNode.ew();
        graphQLNode$Builder.fb = graphQLNode.ex();
        graphQLNode$Builder.fc = graphQLNode.ey();
        graphQLNode$Builder.fd = graphQLNode.ez();
        graphQLNode$Builder.fe = graphQLNode.eA();
        graphQLNode$Builder.ff = graphQLNode.eB();
        graphQLNode$Builder.fg = graphQLNode.eC();
        graphQLNode$Builder.fh = graphQLNode.eD();
        graphQLNode$Builder.fi = graphQLNode.jw();
        graphQLNode$Builder.fj = graphQLNode.eE();
        graphQLNode$Builder.fk = graphQLNode.kD();
        graphQLNode$Builder.fl = graphQLNode.eF();
        graphQLNode$Builder.fm = graphQLNode.eG();
        graphQLNode$Builder.fn = graphQLNode.jX();
        graphQLNode$Builder.fo = graphQLNode.eH();
        graphQLNode$Builder.fp = graphQLNode.eI();
        graphQLNode$Builder.fq = graphQLNode.eJ();
        graphQLNode$Builder.fr = graphQLNode.eK();
        graphQLNode$Builder.fs = graphQLNode.eL();
        graphQLNode$Builder.ft = graphQLNode.eM();
        graphQLNode$Builder.fu = graphQLNode.eN();
        graphQLNode$Builder.fv = graphQLNode.eO();
        graphQLNode$Builder.fw = graphQLNode.eP();
        graphQLNode$Builder.fx = graphQLNode.kU();
        graphQLNode$Builder.fy = graphQLNode.eQ();
        graphQLNode$Builder.fz = graphQLNode.eR();
        graphQLNode$Builder.fA = graphQLNode.jG();
        graphQLNode$Builder.fB = graphQLNode.kH();
        graphQLNode$Builder.fC = graphQLNode.jW();
        graphQLNode$Builder.fD = graphQLNode.eS();
        graphQLNode$Builder.fE = graphQLNode.eT();
        graphQLNode$Builder.fF = graphQLNode.eU();
        graphQLNode$Builder.fG = graphQLNode.eV();
        graphQLNode$Builder.fH = graphQLNode.eW();
        graphQLNode$Builder.fI = graphQLNode.eX();
        graphQLNode$Builder.fJ = graphQLNode.eY();
        graphQLNode$Builder.fK = graphQLNode.eZ();
        graphQLNode$Builder.fL = graphQLNode.fa();
        graphQLNode$Builder.fM = graphQLNode.fb();
        graphQLNode$Builder.fN = graphQLNode.fc();
        graphQLNode$Builder.fO = graphQLNode.kN();
        graphQLNode$Builder.fP = graphQLNode.fd();
        graphQLNode$Builder.fQ = graphQLNode.fe();
        graphQLNode$Builder.fR = graphQLNode.ff();
        graphQLNode$Builder.fS = graphQLNode.fg();
        graphQLNode$Builder.fT = graphQLNode.jT();
        graphQLNode$Builder.fU = graphQLNode.fh();
        graphQLNode$Builder.fV = graphQLNode.fi();
        graphQLNode$Builder.fW = graphQLNode.fj();
        graphQLNode$Builder.fX = graphQLNode.fk();
        graphQLNode$Builder.fY = graphQLNode.fl();
        graphQLNode$Builder.fZ = graphQLNode.fm();
        graphQLNode$Builder.ga = graphQLNode.kJ();
        graphQLNode$Builder.gb = graphQLNode.jM();
        graphQLNode$Builder.gc = graphQLNode.fn();
        graphQLNode$Builder.gd = graphQLNode.fo();
        graphQLNode$Builder.ge = graphQLNode.fp();
        graphQLNode$Builder.gf = graphQLNode.fq();
        graphQLNode$Builder.gg = graphQLNode.fr();
        graphQLNode$Builder.gh = graphQLNode.fs();
        graphQLNode$Builder.gi = graphQLNode.ft();
        graphQLNode$Builder.gj = graphQLNode.fu();
        graphQLNode$Builder.gk = graphQLNode.fv();
        graphQLNode$Builder.gl = graphQLNode.fw();
        graphQLNode$Builder.gm = graphQLNode.fx();
        graphQLNode$Builder.gn = graphQLNode.fy();
        graphQLNode$Builder.go = graphQLNode.fz();
        graphQLNode$Builder.gp = graphQLNode.fA();
        graphQLNode$Builder.gq = graphQLNode.fB();
        graphQLNode$Builder.gr = graphQLNode.fC();
        graphQLNode$Builder.gs = graphQLNode.fD();
        graphQLNode$Builder.gt = graphQLNode.kx();
        graphQLNode$Builder.gu = graphQLNode.fE();
        graphQLNode$Builder.gv = graphQLNode.fF();
        graphQLNode$Builder.gw = graphQLNode.ky();
        graphQLNode$Builder.gx = graphQLNode.fG();
        graphQLNode$Builder.gy = graphQLNode.fH();
        graphQLNode$Builder.gz = graphQLNode.fI();
        graphQLNode$Builder.gA = graphQLNode.fJ();
        graphQLNode$Builder.gB = graphQLNode.fK();
        graphQLNode$Builder.gC = graphQLNode.fL();
        graphQLNode$Builder.gD = graphQLNode.fM();
        graphQLNode$Builder.gE = graphQLNode.fN();
        graphQLNode$Builder.gF = graphQLNode.fO();
        graphQLNode$Builder.gG = graphQLNode.fP();
        graphQLNode$Builder.gH = graphQLNode.fQ();
        graphQLNode$Builder.gI = graphQLNode.fR();
        graphQLNode$Builder.gJ = graphQLNode.fS();
        graphQLNode$Builder.gK = graphQLNode.fT();
        graphQLNode$Builder.gL = graphQLNode.fU();
        graphQLNode$Builder.gM = graphQLNode.fV();
        graphQLNode$Builder.gN = graphQLNode.jY();
        graphQLNode$Builder.gO = graphQLNode.fW();
        graphQLNode$Builder.gP = graphQLNode.fX();
        graphQLNode$Builder.gQ = graphQLNode.fY();
        graphQLNode$Builder.gR = graphQLNode.fZ();
        graphQLNode$Builder.gS = graphQLNode.ga();
        graphQLNode$Builder.gT = graphQLNode.gb();
        graphQLNode$Builder.gU = graphQLNode.gc();
        graphQLNode$Builder.gV = graphQLNode.kl();
        graphQLNode$Builder.gW = graphQLNode.km();
        graphQLNode$Builder.gX = graphQLNode.gd();
        graphQLNode$Builder.gY = graphQLNode.ge();
        graphQLNode$Builder.gZ = graphQLNode.gf();
        graphQLNode$Builder.ha = graphQLNode.gg();
        graphQLNode$Builder.hb = graphQLNode.gh();
        graphQLNode$Builder.hc = graphQLNode.gi();
        graphQLNode$Builder.hd = graphQLNode.gj();
        graphQLNode$Builder.he = graphQLNode.kC();
        graphQLNode$Builder.hf = graphQLNode.gk();
        graphQLNode$Builder.hg = graphQLNode.gl();
        graphQLNode$Builder.hh = graphQLNode.gm();
        graphQLNode$Builder.hi = graphQLNode.gn();
        graphQLNode$Builder.hj = graphQLNode.jZ();
        graphQLNode$Builder.hk = graphQLNode.ka();
        graphQLNode$Builder.hl = graphQLNode.kb();
        graphQLNode$Builder.hm = graphQLNode.go();
        graphQLNode$Builder.hn = graphQLNode.gp();
        graphQLNode$Builder.ho = graphQLNode.gq();
        graphQLNode$Builder.hp = graphQLNode.gr();
        graphQLNode$Builder.hq = graphQLNode.gs();
        graphQLNode$Builder.hr = graphQLNode.jU();
        graphQLNode$Builder.hs = graphQLNode.gt();
        graphQLNode$Builder.ht = graphQLNode.gu();
        graphQLNode$Builder.hu = graphQLNode.gv();
        graphQLNode$Builder.hv = graphQLNode.gw();
        graphQLNode$Builder.hw = graphQLNode.gx();
        graphQLNode$Builder.hx = graphQLNode.gy();
        graphQLNode$Builder.hy = graphQLNode.gz();
        graphQLNode$Builder.hz = graphQLNode.gA();
        graphQLNode$Builder.hA = graphQLNode.gB();
        graphQLNode$Builder.hB = graphQLNode.gC();
        graphQLNode$Builder.hC = graphQLNode.gD();
        graphQLNode$Builder.hD = graphQLNode.gE();
        graphQLNode$Builder.hE = graphQLNode.gF();
        graphQLNode$Builder.hF = graphQLNode.gG();
        graphQLNode$Builder.hG = graphQLNode.gH();
        graphQLNode$Builder.hH = graphQLNode.gI();
        graphQLNode$Builder.hI = graphQLNode.gJ();
        graphQLNode$Builder.hJ = graphQLNode.gK();
        graphQLNode$Builder.hK = graphQLNode.kp();
        graphQLNode$Builder.hL = graphQLNode.gL();
        graphQLNode$Builder.hM = graphQLNode.gM();
        graphQLNode$Builder.hN = graphQLNode.gN();
        graphQLNode$Builder.hO = graphQLNode.gO();
        graphQLNode$Builder.hP = graphQLNode.gP();
        graphQLNode$Builder.hQ = graphQLNode.gQ();
        graphQLNode$Builder.hR = graphQLNode.gR();
        graphQLNode$Builder.hS = graphQLNode.gS();
        graphQLNode$Builder.hT = graphQLNode.gT();
        graphQLNode$Builder.hU = graphQLNode.gU();
        graphQLNode$Builder.hV = graphQLNode.gV();
        graphQLNode$Builder.hW = graphQLNode.gW();
        graphQLNode$Builder.hX = graphQLNode.gX();
        graphQLNode$Builder.hY = graphQLNode.gY();
        graphQLNode$Builder.hZ = graphQLNode.gZ();
        graphQLNode$Builder.ia = graphQLNode.ha();
        graphQLNode$Builder.ib = graphQLNode.hb();
        graphQLNode$Builder.ic = graphQLNode.hc();
        graphQLNode$Builder.id = graphQLNode.hd();
        graphQLNode$Builder.ie = graphQLNode.he();
        graphQLNode$Builder.f4596if = graphQLNode.hf();
        graphQLNode$Builder.ig = graphQLNode.kK();
        graphQLNode$Builder.ih = graphQLNode.hg();
        graphQLNode$Builder.ii = graphQLNode.hh();
        graphQLNode$Builder.ij = graphQLNode.hi();
        graphQLNode$Builder.ik = graphQLNode.hj();
        graphQLNode$Builder.il = graphQLNode.hk();
        graphQLNode$Builder.im = graphQLNode.hl();
        graphQLNode$Builder.in = graphQLNode.hm();
        graphQLNode$Builder.io = graphQLNode.hn();
        graphQLNode$Builder.ip = graphQLNode.ho();
        graphQLNode$Builder.iq = graphQLNode.hp();
        graphQLNode$Builder.ir = graphQLNode.jO();
        graphQLNode$Builder.is = graphQLNode.hq();
        graphQLNode$Builder.it = graphQLNode.hr();
        graphQLNode$Builder.iu = graphQLNode.hs();
        graphQLNode$Builder.iv = graphQLNode.ht();
        graphQLNode$Builder.iw = graphQLNode.hu();
        graphQLNode$Builder.ix = graphQLNode.jS();
        graphQLNode$Builder.iy = graphQLNode.hv();
        graphQLNode$Builder.iz = graphQLNode.hw();
        graphQLNode$Builder.iA = graphQLNode.hx();
        graphQLNode$Builder.iB = graphQLNode.hy();
        graphQLNode$Builder.iC = graphQLNode.kP();
        graphQLNode$Builder.iD = graphQLNode.hz();
        graphQLNode$Builder.iE = graphQLNode.hA();
        graphQLNode$Builder.iF = graphQLNode.hB();
        graphQLNode$Builder.iG = graphQLNode.hC();
        graphQLNode$Builder.iH = graphQLNode.hD();
        graphQLNode$Builder.iI = graphQLNode.hE();
        graphQLNode$Builder.iJ = graphQLNode.hF();
        graphQLNode$Builder.iK = graphQLNode.hG();
        graphQLNode$Builder.iL = graphQLNode.hH();
        graphQLNode$Builder.iM = graphQLNode.hI();
        graphQLNode$Builder.iN = graphQLNode.hJ();
        graphQLNode$Builder.iO = graphQLNode.hK();
        graphQLNode$Builder.iP = graphQLNode.hL();
        graphQLNode$Builder.iQ = graphQLNode.hM();
        graphQLNode$Builder.iR = graphQLNode.hN();
        graphQLNode$Builder.iS = graphQLNode.hO();
        graphQLNode$Builder.iT = graphQLNode.hP();
        graphQLNode$Builder.iU = graphQLNode.hQ();
        graphQLNode$Builder.iV = graphQLNode.kL();
        graphQLNode$Builder.iW = graphQLNode.hR();
        graphQLNode$Builder.iX = graphQLNode.hS();
        graphQLNode$Builder.iY = graphQLNode.hT();
        graphQLNode$Builder.iZ = graphQLNode.hU();
        graphQLNode$Builder.ja = graphQLNode.hV();
        graphQLNode$Builder.jb = graphQLNode.hW();
        graphQLNode$Builder.jc = graphQLNode.hX();
        graphQLNode$Builder.jd = graphQLNode.hY();
        graphQLNode$Builder.je = graphQLNode.hZ();
        graphQLNode$Builder.jf = graphQLNode.ia();
        graphQLNode$Builder.jg = graphQLNode.ib();
        graphQLNode$Builder.jh = graphQLNode.kz();
        graphQLNode$Builder.ji = graphQLNode.ic();
        graphQLNode$Builder.jj = graphQLNode.id();
        graphQLNode$Builder.jk = graphQLNode.ie();
        graphQLNode$Builder.jl = graphQLNode.if();
        graphQLNode$Builder.jm = graphQLNode.ig();
        graphQLNode$Builder.jn = graphQLNode.ih();
        graphQLNode$Builder.jo = graphQLNode.ii();
        graphQLNode$Builder.jp = graphQLNode.ij();
        graphQLNode$Builder.jq = graphQLNode.ik();
        graphQLNode$Builder.jr = graphQLNode.il();
        graphQLNode$Builder.js = graphQLNode.im();
        graphQLNode$Builder.jt = graphQLNode.in();
        graphQLNode$Builder.ju = graphQLNode.ki();
        graphQLNode$Builder.jv = graphQLNode.io();
        graphQLNode$Builder.jw = graphQLNode.ip();
        graphQLNode$Builder.jx = graphQLNode.iq();
        graphQLNode$Builder.jy = graphQLNode.ir();
        graphQLNode$Builder.jz = graphQLNode.is();
        graphQLNode$Builder.jA = graphQLNode.jQ();
        graphQLNode$Builder.jB = graphQLNode.it();
        graphQLNode$Builder.jC = graphQLNode.iu();
        graphQLNode$Builder.jD = graphQLNode.iv();
        graphQLNode$Builder.jE = graphQLNode.iw();
        graphQLNode$Builder.jF = graphQLNode.ix();
        graphQLNode$Builder.jG = graphQLNode.iy();
        graphQLNode$Builder.jH = graphQLNode.iz();
        graphQLNode$Builder.jI = graphQLNode.iA();
        graphQLNode$Builder.jJ = graphQLNode.iB();
        graphQLNode$Builder.jK = graphQLNode.iC();
        graphQLNode$Builder.jL = graphQLNode.iD();
        graphQLNode$Builder.jM = graphQLNode.iE();
        graphQLNode$Builder.jN = graphQLNode.iF();
        graphQLNode$Builder.jO = graphQLNode.iG();
        graphQLNode$Builder.jP = graphQLNode.jy();
        graphQLNode$Builder.jQ = graphQLNode.kM();
        graphQLNode$Builder.jR = graphQLNode.jz();
        graphQLNode$Builder.jS = graphQLNode.jA();
        graphQLNode$Builder.jT = graphQLNode.jB();
        graphQLNode$Builder.jU = graphQLNode.jC();
        graphQLNode$Builder.jV = graphQLNode.iH();
        graphQLNode$Builder.jW = graphQLNode.iI();
        graphQLNode$Builder.jX = graphQLNode.iJ();
        graphQLNode$Builder.jY = graphQLNode.iK();
        graphQLNode$Builder.jZ = graphQLNode.iL();
        graphQLNode$Builder.ka = graphQLNode.iM();
        graphQLNode$Builder.kb = graphQLNode.iN();
        graphQLNode$Builder.kc = graphQLNode.iO();
        graphQLNode$Builder.kd = graphQLNode.iP();
        graphQLNode$Builder.ke = graphQLNode.iQ();
        graphQLNode$Builder.kf = graphQLNode.iR();
        graphQLNode$Builder.kg = graphQLNode.iS();
        graphQLNode$Builder.kh = graphQLNode.iT();
        graphQLNode$Builder.ki = graphQLNode.iU();
        graphQLNode$Builder.kj = graphQLNode.iV();
        graphQLNode$Builder.kk = graphQLNode.kn();
        graphQLNode$Builder.kl = graphQLNode.iW();
        graphQLNode$Builder.km = graphQLNode.kS();
        graphQLNode$Builder.kn = graphQLNode.iX();
        graphQLNode$Builder.ko = graphQLNode.iY();
        graphQLNode$Builder.kp = graphQLNode.iZ();
        graphQLNode$Builder.kq = graphQLNode.ja();
        graphQLNode$Builder.kr = graphQLNode.jb();
        graphQLNode$Builder.ks = graphQLNode.kk();
        graphQLNode$Builder.kt = graphQLNode.jc();
        graphQLNode$Builder.ku = graphQLNode.jN();
        graphQLNode$Builder.kv = graphQLNode.jd();
        graphQLNode$Builder.kw = graphQLNode.je();
        graphQLNode$Builder.kx = graphQLNode.jf();
        graphQLNode$Builder.ky = graphQLNode.jg();
        graphQLNode$Builder.kz = graphQLNode.jh();
        graphQLNode$Builder.kA = graphQLNode.ji();
        graphQLNode$Builder.kB = graphQLNode.jj();
        graphQLNode$Builder.kC = graphQLNode.jk();
        graphQLNode$Builder.kD = graphQLNode.jl();
        graphQLNode$Builder.kE = graphQLNode.jm();
        graphQLNode$Builder.kF = graphQLNode.jn();
        graphQLNode$Builder.kG = graphQLNode.jo();
        graphQLNode$Builder.kH = graphQLNode.jp();
        graphQLNode$Builder.kI = graphQLNode.jq();
        graphQLNode$Builder.kJ = graphQLNode.kT();
        graphQLNode$Builder.kK = graphQLNode.jr();
        graphQLNode$Builder.kL = graphQLNode.js();
        graphQLNode$Builder.kM = graphQLNode.jt();
        graphQLNode$Builder.kN = graphQLNode.kA();
        graphQLNode$Builder.kO = graphQLNode.ju();
        graphQLNode$Builder.kP = graphQLNode.jv();
        Builder.a(graphQLNode$Builder, graphQLNode);
        graphQLNode$Builder.kQ = graphQLNode.j();
        return graphQLNode$Builder;
    }

    public final GraphQLNode$Builder m9285a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.dk = graphQLFriendshipStatus;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 198, graphQLFriendshipStatus);
        }
        return this;
    }

    public final GraphQLNode$Builder m9283a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
        this.kw = graphQLEventGuestStatus;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 528, graphQLEventGuestStatus);
        }
        return this;
    }

    public final GraphQLNode$Builder m9286a(GraphQLSavedState graphQLSavedState) {
        this.kF = graphQLSavedState;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 538, graphQLSavedState);
        }
        return this;
    }

    public final GraphQLNode$Builder m9284a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
        this.kI = graphQLEventWatchStatus;
        if (this.a != null && this.a.d) {
            this.a.a(this.b, 541, graphQLEventWatchStatus);
        }
        return this;
    }

    public final GraphQLNode m9287a() {
        return new GraphQLNode(this);
    }
}
