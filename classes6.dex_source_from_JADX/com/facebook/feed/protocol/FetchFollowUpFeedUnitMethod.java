package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFollowUpFeedUnitParams;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams.1;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchFollowUpFeedUnitGraphQL.FetchFollowUpFeedUnitQueryString;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLArticleChainingFeedUnit;
import com.facebook.graphql.model.GraphQLEventCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLFollowUpFeedUnitsConnection;
import com.facebook.graphql.model.GraphQLFollowUpFeedUnitsEdge;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLUnseenStoriesFeedUnit;
import com.facebook.graphql.model.GraphQLVideoChainingFeedUnit;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import javax.inject.Inject;

/* compiled from: moved */
public class FetchFollowUpFeedUnitMethod extends AbstractPersistedGraphQlApiMethod<FetchFollowUpFeedUnitParams, FeedUnit> {
    private final GraphQLStoryHelper f10199c;
    private final GraphQLImageHelper f10200d;
    private final FetchFeedQueryUtil f10201e;
    private final GatekeeperStoreImpl f10202f;
    private final Clock f10203g;
    private final FetchVideoChannelParamBuilderUtil f10204h;

    /* compiled from: moved */
    /* synthetic */ class C06181 {
        static final /* synthetic */ int[] f10198a = new int[GraphQLFollowUpFeedUnitActionType.values().length];

        static {
            try {
                f10198a[GraphQLFollowUpFeedUnitActionType.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10198a[GraphQLFollowUpFeedUnitActionType.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10198a[GraphQLFollowUpFeedUnitActionType.OUTBOUND_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10198a[GraphQLFollowUpFeedUnitActionType.SHARE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10198a[GraphQLFollowUpFeedUnitActionType.PAGE_LIKE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static FetchFollowUpFeedUnitMethod m15930b(InjectorLike injectorLike) {
        return new FetchFollowUpFeedUnitMethod(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), GraphQLProtocolHelper.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike));
    }

    public final Object m15931a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        GraphQLNode graphQLNode = (GraphQLNode) jsonParser.a(GraphQLNode.class);
        return graphQLNode != null ? m15928a(((FetchFollowUpFeedUnitParams) obj).d, graphQLNode.cM()) : null;
    }

    public final GraphQlQueryString m15933f(Object obj) {
        FetchFollowUpFeedUnitParams fetchFollowUpFeedUnitParams = (FetchFollowUpFeedUnitParams) obj;
        GraphQlQueryString fetchFollowUpFeedUnitQueryString = new FetchFollowUpFeedUnitQueryString();
        fetchFollowUpFeedUnitQueryString.a(true);
        this.f10201e.a(fetchFollowUpFeedUnitQueryString);
        this.f10201e.b(fetchFollowUpFeedUnitQueryString);
        fetchFollowUpFeedUnitQueryString.a("node_id", fetchFollowUpFeedUnitParams.b).a("followup_action_type", fetchFollowUpFeedUnitParams.d.toString()).a("followup_feed_unit_type", Lists.a(fetchFollowUpFeedUnitParams.a, new 1(fetchFollowUpFeedUnitParams))).a("profile_pic_swipe_size_param", this.f10199c.l()).a("pymk_size_param", this.f10199c.g()).a("ad_media_type", this.f10200d.a()).a("num_related_stories", String.valueOf(fetchFollowUpFeedUnitParams.e));
        this.f10204h.a(fetchFollowUpFeedUnitQueryString);
        return fetchFollowUpFeedUnitQueryString;
    }

    @Inject
    public FetchFollowUpFeedUnitMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLProtocolHelper graphQLProtocolHelper, GatekeeperStoreImpl gatekeeperStoreImpl, Clock clock, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil) {
        super(graphQLProtocolHelper);
        this.f10199c = graphQLStoryHelper;
        this.f10200d = graphQLImageHelper;
        this.f10201e = fetchFeedQueryUtil;
        this.f10202f = gatekeeperStoreImpl;
        this.f10203g = clock;
        this.f10204h = fetchVideoChannelParamBuilderUtil;
    }

    private FeedUnit m15928a(GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType, GraphQLFollowUpFeedUnitsConnection graphQLFollowUpFeedUnitsConnection) {
        FeedUnit feedUnit = null;
        if (!(graphQLFollowUpFeedUnitsConnection == null || graphQLFollowUpFeedUnitsConnection.a() == null)) {
            ImmutableList a = graphQLFollowUpFeedUnitsConnection.a();
            int size = a.size();
            int i = 0;
            while (i < size) {
                GraphQLFollowUpFeedUnitsEdge graphQLFollowUpFeedUnitsEdge = (GraphQLFollowUpFeedUnitsEdge) a.get(i);
                if (graphQLFollowUpFeedUnitsEdge.j() == null || graphQLFollowUpFeedUnitsEdge.a() == null || graphQLFollowUpFeedUnitsEdge.a().getType() == null || !graphQLFollowUpFeedUnitsEdge.j().contains(graphQLFollowUpFeedUnitActionType)) {
                    i++;
                } else {
                    feedUnit = graphQLFollowUpFeedUnitsEdge.a();
                    i = graphQLFollowUpFeedUnitsEdge.a().getType().g();
                    if (i == -1396660317) {
                        FeedUnit feedUnit2 = (GraphQLPagesYouMayLikeFeedUnit) graphQLFollowUpFeedUnitsEdge.a();
                        m15929a(feedUnit2, graphQLFollowUpFeedUnitActionType);
                        feedUnit = feedUnit2;
                    } else if (i == -2066307870) {
                        feedUnit = (GraphQLPeopleYouMayKnowFeedUnit) graphQLFollowUpFeedUnitsEdge.a();
                    } else if (i == -1459322407) {
                        feedUnit = (GraphQLArticleChainingFeedUnit) graphQLFollowUpFeedUnitsEdge.a();
                    } else if (i == 88250206) {
                        feedUnit = (GraphQLVideoChainingFeedUnit) graphQLFollowUpFeedUnitsEdge.a();
                    } else if (i == 1782386509) {
                        feedUnit = (GraphQLStorySet) graphQLFollowUpFeedUnitsEdge.a();
                    } else if (i == -1322509030) {
                        feedUnit = (GraphQLEventCollectionFeedUnit) graphQLFollowUpFeedUnitsEdge.a();
                    } else if (i == -1080337823) {
                        feedUnit = (GraphQLUnseenStoriesFeedUnit) graphQLFollowUpFeedUnitsEdge.a();
                    }
                    FetchTimeMsHelper.a(feedUnit, this.f10203g.a());
                    if (feedUnit instanceof FollowUpFeedUnit) {
                        PropertyHelper.a((FollowUpFeedUnit) feedUnit).p = true;
                    }
                }
            }
        }
        return feedUnit;
    }

    private void m15929a(FeedUnit feedUnit, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType) {
        if (feedUnit instanceof GraphQLPagesYouMayLikeFeedUnit) {
            String str;
            GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) feedUnit;
            switch (C06181.f10198a[graphQLFollowUpFeedUnitActionType.ordinal()]) {
                case 1:
                    str = "feed_chaining";
                    break;
                case 2:
                    str = "comment_chaining";
                    break;
                case 3:
                    str = "outbound_click_chaining";
                    break;
                case 4:
                    str = "share_chaining";
                    break;
                case 5:
                    if (!this.f10202f.a(830, false)) {
                        str = "mobile_page_suggestions_on_liking";
                        break;
                    } else {
                        str = "timeline_like_chaining";
                        break;
                    }
                default:
                    return;
            }
            PropertyHelper.a(graphQLPagesYouMayLikeFeedUnit).k = str;
        }
    }

    public final int m15932b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    public final RequestPriority m15934j(Object obj) {
        return RequestPriority.INTERACTIVE;
    }
}
