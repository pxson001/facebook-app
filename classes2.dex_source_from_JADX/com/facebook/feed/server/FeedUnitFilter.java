package com.facebook.feed.server;

import android.text.TextUtils;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.platformads.AppAdsInvalidator;
import com.facebook.feed.prefs.keys.FeedPrefKeys;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.feed.util.StoryAttachmentUtil;
import com.facebook.feed.xconfig.FeedUnitInvalidateTimeXConfig;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLCreativePagesYouMayLikeFeedUnitItem;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLHoldoutAdFeedUnit;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnit;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.graphql.model.GraphQLResearchPollSurvey;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnitItem;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLStorySetStoriesConnection;
import com.facebook.graphql.model.GraphQLStructuredSurvey;
import com.facebook.graphql.model.GraphQLStructuredSurveyQuestion;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
import com.facebook.graphql.model.GraphQLUnknownFeedUnit;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.SavedCollectionFeedUnitHelper;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.VisibleItemHelper;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

@Deprecated
/* compiled from: loom_id */
public class FeedUnitFilter {
    private final NewsFeedAnalyticsEventBuilder f15934a;
    private final AnalyticsLogger f15935b;
    private StoryAttachmentUtil f15936c;
    public final FbSharedPreferences f15937d;
    private final InstagramUtils f15938e;
    private final AppAdsInvalidator f15939f;
    private final XConfigReader f15940g;
    private final Clock f15941h;

    @Inject
    public FeedUnitFilter(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, StoryAttachmentUtil storyAttachmentUtil, FbSharedPreferences fbSharedPreferences, InstagramUtils instagramUtils, AppAdsInvalidator appAdsInvalidator, XConfigReader xConfigReader, Clock clock) {
        this.f15934a = newsFeedAnalyticsEventBuilder;
        this.f15935b = analyticsLogger;
        this.f15936c = storyAttachmentUtil;
        this.f15937d = fbSharedPreferences;
        this.f15938e = instagramUtils;
        this.f15939f = appAdsInvalidator;
        this.f15940g = xConfigReader;
        this.f15941h = clock;
    }

    @Deprecated
    public final FeedUnit m22698a(FeedUnit feedUnit, Optional<FeedType> optional) {
        if (feedUnit == null) {
            return null;
        }
        if (feedUnit instanceof GraphQLStory) {
            return m22692a(FeedProps.m19802c((GraphQLStory) feedUnit));
        }
        if (feedUnit instanceof GraphQLStorySet) {
            return m22693a((GraphQLStorySet) feedUnit);
        }
        if (feedUnit instanceof GraphQLFriendsLocationsFeedUnit) {
            return m22685a((GraphQLFriendsLocationsFeedUnit) feedUnit, (Optional) optional);
        }
        if (feedUnit instanceof GraphQLPagesYouMayLikeFeedUnit) {
            return m22687a((GraphQLPagesYouMayLikeFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLSavedCollectionFeedUnit) {
            return m22689a((GraphQLSavedCollectionFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLCreativePagesYouMayLikeFeedUnit) {
            return m22684a((GraphQLCreativePagesYouMayLikeFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLPYMLWithLargeImageFeedUnit) {
            return m22686a((GraphQLPYMLWithLargeImageFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLHoldoutAdFeedUnit) {
            return m22691a((GraphQLHoldoutAdFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLSurveyFeedUnit) {
            return m22690a((GraphQLSurveyFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLResearchPollFeedUnit) {
            return m22688a((GraphQLResearchPollFeedUnit) feedUnit);
        }
        if (feedUnit instanceof GraphQLInstagramPhotosFromFriendsFeedUnit) {
            return m22697b(feedUnit);
        }
        ImmutableList a;
        Object obj;
        int size;
        int i;
        if (feedUnit instanceof GraphQLGroupsYouShouldJoinFeedUnit) {
            GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) feedUnit;
            a = ItemListFeedUnitImpl.m30141a(graphQLGroupsYouShouldJoinFeedUnit);
            if (graphQLGroupsYouShouldJoinFeedUnit.mo2878m() == null || a == null || a.size() == 0) {
                obj = null;
            } else {
                size = a.size();
                for (i = 0; i < size; i++) {
                    if (!IsValidUtil.m22947a((GraphQLGroupsYouShouldJoinFeedUnitItem) a.get(i))) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
            }
            if (obj == null) {
                return null;
            }
            return feedUnit;
        } else if (feedUnit instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnit) {
            GraphQLPaginatedGroupsYouShouldJoinFeedUnit graphQLPaginatedGroupsYouShouldJoinFeedUnit = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) feedUnit;
            if (graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25303r() == null || graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25300o() == null || graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25300o().m23858a() == null || graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25300o().m23858a().isEmpty()) {
                obj = null;
            } else {
                a = graphQLPaginatedGroupsYouShouldJoinFeedUnit.m25300o().m23858a();
                size = a.size();
                for (i = 0; i < size; i++) {
                    if (!IsValidUtil.m22957a((GraphQLPaginatedGroupsYouShouldJoinFeedUnitGroupsEdge) a.get(i))) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
            }
            if (obj == null) {
                return null;
            }
            return feedUnit;
        } else if (feedUnit instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit) {
            GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersConnection o = ((GraphQLPaginatedPeopleYouMayKnowFeedUnit) feedUnit).m25696o();
            if (o == null) {
                obj = null;
            } else {
                List<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> a2 = o.m23876a();
                if (a2 == null || a2.isEmpty()) {
                    obj = null;
                } else {
                    for (GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge j : a2) {
                        if (!j.m31478j()) {
                            obj = null;
                            break;
                        }
                    }
                    obj = 1;
                }
            }
            if (obj == null) {
                return null;
            }
            return feedUnit;
        } else if (feedUnit instanceof GraphQLGoodwillAnniversaryCampaignFeedUnit) {
            if (IsValidUtil.m22945a((GraphQLGoodwillAnniversaryCampaignFeedUnit) feedUnit)) {
                return feedUnit;
            }
            return null;
        } else if (feedUnit instanceof GraphQLGoodwillThrowbackPromotionFeedUnit) {
            if (GoodwillFeedUnitHelper.b((GraphQLGoodwillThrowbackPromotionFeedUnit) feedUnit)) {
                return feedUnit;
            }
            return null;
        } else if (feedUnit instanceof GraphQLMobilePageAdminPanelFeedUnit) {
            if (((GraphQLMobilePageAdminPanelFeedUnit) feedUnit).m25537p().isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                return null;
            }
            return feedUnit;
        } else if (!(feedUnit instanceof GraphQLUnknownFeedUnit) || BuildConstants.i) {
            return feedUnit;
        } else {
            return null;
        }
    }

    @Deprecated
    private FeedUnit m22697b(FeedUnit feedUnit) {
        if (!this.f15938e.m22716a() || this.f15938e.m22727l()) {
            return feedUnit;
        }
        AnalyticsLogger analyticsLogger = this.f15935b;
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("ig_pff_invalidation");
        honeyClientEvent.f3099c = "native_newsfeed";
        analyticsLogger.mo533c(honeyClientEvent);
        return null;
    }

    private FeedUnit m22685a(GraphQLFriendsLocationsFeedUnit graphQLFriendsLocationsFeedUnit, Optional<FeedType> optional) {
        long l = graphQLFriendsLocationsFeedUnit.m22799l() * 1000;
        if (this.f15941h.mo211a() - l <= 3600000 * ((long) this.f15940g.m2683a(FeedUnitInvalidateTimeXConfig.c, 1))) {
            return graphQLFriendsLocationsFeedUnit;
        }
        m22694a(new ArrayNode(JsonNodeFactory.f3121a).m13394h(graphQLFriendsLocationsFeedUnit.mo2877k()), graphQLFriendsLocationsFeedUnit.getType(), optional, "invalid_data");
        return null;
    }

    @Deprecated
    private FeedUnit m22687a(GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit) {
        if (IsValidUtil.m22955a(graphQLPagesYouMayLikeFeedUnit)) {
            return graphQLPagesYouMayLikeFeedUnit;
        }
        m22695a(VisibleItemHelper.m26982c(graphQLPagesYouMayLikeFeedUnit), graphQLPagesYouMayLikeFeedUnit.getType(), "invalid_data");
        return null;
    }

    @Deprecated
    private FeedUnit m22689a(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit) {
        Object obj;
        if (SavedCollectionFeedUnitHelper.c(graphQLSavedCollectionFeedUnit) == null || SavedCollectionFeedUnitHelper.c(graphQLSavedCollectionFeedUnit).mo2911a() == null || SavedCollectionFeedUnitHelper.a(graphQLSavedCollectionFeedUnit) == null || SavedCollectionFeedUnitHelper.a(graphQLSavedCollectionFeedUnit).isEmpty() || graphQLSavedCollectionFeedUnit.m22282y() == null || StringUtil.m3589a(graphQLSavedCollectionFeedUnit.m22282y().mo2915b()) || graphQLSavedCollectionFeedUnit.m22275r() == null) {
            obj = null;
        } else {
            ImmutableList a = SavedCollectionFeedUnitHelper.a(graphQLSavedCollectionFeedUnit);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (!IsValidUtil.m22965a((GraphQLSavedCollectionFeedUnitItem) a.get(i))) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        }
        if (obj != null) {
            return graphQLSavedCollectionFeedUnit;
        }
        m22695a(null, graphQLSavedCollectionFeedUnit.getType(), "invalid_data");
        return null;
    }

    @Deprecated
    private FeedUnit m22684a(GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit) {
        Object obj;
        ImmutableList x = graphQLCreativePagesYouMayLikeFeedUnit.m25788x();
        if (x == null || x.isEmpty()) {
            obj = null;
        } else {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                if (!IsValidUtil.m22944a((GraphQLCreativePagesYouMayLikeFeedUnitItem) x.get(i))) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        }
        if (obj != null) {
            return graphQLCreativePagesYouMayLikeFeedUnit;
        }
        m22695a(VisibleItemHelper.m26982c(graphQLCreativePagesYouMayLikeFeedUnit), graphQLCreativePagesYouMayLikeFeedUnit.getType(), "invalid_data");
        return null;
    }

    @Deprecated
    private FeedUnit m22686a(GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit) {
        if (IsValidUtil.m22950a(graphQLPYMLWithLargeImageFeedUnit)) {
            return graphQLPYMLWithLargeImageFeedUnit;
        }
        m22695a(VisibleItemHelper.m26982c(graphQLPYMLWithLargeImageFeedUnit), graphQLPYMLWithLargeImageFeedUnit.getType(), "invalid_data");
        return null;
    }

    @Deprecated
    private GraphQLHoldoutAdFeedUnit m22691a(GraphQLHoldoutAdFeedUnit graphQLHoldoutAdFeedUnit) {
        if ((graphQLHoldoutAdFeedUnit.mo2994A() != null ? 1 : null) != null) {
            return graphQLHoldoutAdFeedUnit;
        }
        m22695a(null, graphQLHoldoutAdFeedUnit.getType(), "invalid_data");
        return null;
    }

    @Deprecated
    private FeedUnit m22690a(GraphQLSurveyFeedUnit graphQLSurveyFeedUnit) {
        if (graphQLSurveyFeedUnit.m26062E().f20931b) {
            return null;
        }
        Object obj;
        if (graphQLSurveyFeedUnit.m26080s() != null) {
            Object obj2;
            GraphQLStructuredSurvey s = graphQLSurveyFeedUnit.m26080s();
            if (StringUtil.m3589a(s.m24880k()) || s.m24879j() == null || s.m24882m() == null) {
                obj2 = null;
            } else {
                Iterator it = s.m24882m().a().iterator();
                while (it.hasNext()) {
                    GraphQLStructuredSurveyQuestion graphQLStructuredSurveyQuestion = (GraphQLStructuredSurveyQuestion) it.next();
                    if (graphQLStructuredSurveyQuestion != null) {
                        Object obj3;
                        if (graphQLStructuredSurveyQuestion.k() == null || graphQLStructuredSurveyQuestion.j() == null || (!(graphQLStructuredSurveyQuestion.n() == GraphQLStructuredSurveyQuestionType.RADIO || graphQLStructuredSurveyQuestion.n() == GraphQLStructuredSurveyQuestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) || graphQLStructuredSurveyQuestion.o() == null || graphQLStructuredSurveyQuestion.o().size() > 5)) {
                            obj3 = null;
                        } else {
                            obj3 = 1;
                        }
                        if (obj3 == null) {
                        }
                    }
                    obj2 = null;
                }
                obj2 = 1;
            }
            if (obj2 != null) {
                obj = 1;
                if (obj == null) {
                    return graphQLSurveyFeedUnit;
                }
                m22695a(FeedTrackableUtil.m27151a((CachedFeedTrackable) graphQLSurveyFeedUnit), graphQLSurveyFeedUnit.getType(), "invalid_data");
                return null;
            }
        }
        obj = null;
        if (obj == null) {
            return graphQLSurveyFeedUnit;
        }
        m22695a(FeedTrackableUtil.m27151a((CachedFeedTrackable) graphQLSurveyFeedUnit), graphQLSurveyFeedUnit.getType(), "invalid_data");
        return null;
    }

    @Deprecated
    private FeedUnit m22688a(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit) {
        if (graphQLResearchPollFeedUnit.m25874U().f20931b) {
            return null;
        }
        Object obj;
        if (graphQLResearchPollFeedUnit.m25861H() != null) {
            Object obj2;
            GraphQLResearchPollSurvey H = graphQLResearchPollFeedUnit.m25861H();
            if (StringUtil.m3589a(H.l()) || H.k() == null || H.m() == null) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                obj = 1;
                if (obj == null) {
                    return graphQLResearchPollFeedUnit;
                }
                m22695a(FeedTrackableUtil.m27151a((CachedFeedTrackable) graphQLResearchPollFeedUnit), graphQLResearchPollFeedUnit.getType(), "invalid_data");
                return null;
            }
        }
        obj = null;
        if (obj == null) {
            return graphQLResearchPollFeedUnit;
        }
        m22695a(FeedTrackableUtil.m27151a((CachedFeedTrackable) graphQLResearchPollFeedUnit), graphQLResearchPollFeedUnit.getType(), "invalid_data");
        return null;
    }

    private void m22695a(ArrayNode arrayNode, GraphQLObjectType graphQLObjectType, String str) {
        this.f15935b.mo533c(this.f15934a.m14127a((JsonNode) arrayNode, graphQLObjectType, str));
    }

    private GraphQLStory m22692a(FeedProps<GraphQLStory> feedProps) {
        int i = 0;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.ay() != null && graphQLStory.ay().mo2963b()) {
            boolean z = false;
            if (!this.f15937d.mo286a(FeedPrefKeys.f5751o, false)) {
                z = true;
            }
            if (z) {
                return graphQLStory;
            }
        }
        if (graphQLStory.m22327M().isEmpty()) {
            return graphQLStory;
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) graphQLStory.m22327M().get(0);
        if (m22696a(graphQLStoryAttachment, (FeedProps) feedProps)) {
            return null;
        }
        if (graphQLStoryAttachment.m23985x() == null || graphQLStoryAttachment.m23985x().isEmpty()) {
            return graphQLStory;
        }
        ImmutableList x = graphQLStoryAttachment.m23985x();
        int size = x.size();
        while (i < size) {
            if (m22696a((GraphQLStoryAttachment) x.get(i), (FeedProps) feedProps)) {
                return null;
            }
            i++;
        }
        return graphQLStory;
    }

    private boolean m22696a(GraphQLStoryAttachment graphQLStoryAttachment, FeedProps<GraphQLStory> feedProps) {
        String str;
        String str2;
        if (graphQLStoryAttachment == null) {
            str = null;
        } else {
            ImmutableList j = graphQLStoryAttachment.m23971j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) j.get(i);
                if (graphQLStoryActionLink != null && graphQLStoryActionLink.m22901a() != null && graphQLStoryActionLink.m22901a().m22301g() == -508788748) {
                    str = graphQLStoryActionLink.aE();
                    break;
                }
            }
            str = null;
        }
        String str3 = str;
        if (!TextUtils.isEmpty(str3) || graphQLStoryAttachment.m23987z() == null) {
            str2 = str3;
        } else {
            str2 = graphQLStoryAttachment.m23987z().iR();
        }
        return this.f15939f.m22750a(str2, TrackableFeedProps.m27451a(feedProps), ((GraphQLStory) feedProps.f13444a).getType());
    }

    private GraphQLStorySet m22693a(GraphQLStorySet graphQLStorySet) {
        if (graphQLStorySet != null) {
            Object obj;
            if (graphQLStorySet.m22788z() == null || graphQLStorySet.m22788z().m23872j() == null || graphQLStorySet.m22788z().m23872j().isEmpty()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                FeedProps c = FeedProps.m19802c(graphQLStorySet);
                Builder builder = ImmutableList.builder();
                ImmutableList b = StorySetHelper.b(graphQLStorySet);
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    GraphQLStory graphQLStory = (GraphQLStory) b.get(i);
                    if (m22692a(c.m19803a(graphQLStory)) != null) {
                        builder.m1069c(graphQLStory);
                    }
                }
                ImmutableList b2 = builder.m1068b();
                if (b2.isEmpty()) {
                    return null;
                }
                if (b2.size() == StorySetHelper.b(graphQLStorySet).size()) {
                    return graphQLStorySet;
                }
                GraphQLStorySet.Builder a = GraphQLStorySet.Builder.a(graphQLStorySet);
                GraphQLStorySetStoriesConnection.Builder a2 = GraphQLStorySetStoriesConnection.Builder.a(graphQLStorySet.m22788z());
                a2.e = GraphQLHelper.m22469a(b2);
                a.e = a2.a();
                return a.a();
            }
        }
        return null;
    }

    private void m22694a(ArrayNode arrayNode, GraphQLObjectType graphQLObjectType, Optional<FeedType> optional, String str) {
        HoneyAnalyticsEvent b = new HoneyClientEvent("feed_unit_dropped").m5085a("tracking", (JsonNode) arrayNode).m5090b("unit_type", graphQLObjectType.m22299e()).m5090b("reason", str);
        b.f3099c = "native_newsfeed";
        HoneyAnalyticsEvent honeyAnalyticsEvent = b;
        if (optional.isPresent()) {
            honeyAnalyticsEvent.m5090b("feed_type", ((FeedType) optional.get()).m8961a()).m5090b("feed_name", ((FeedType) optional.get()).f5044g.f5072A);
        }
        this.f15935b.mo533c(honeyAnalyticsEvent);
    }
}
