package com.facebook.feed.logging.impression;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder;
import com.facebook.feed.analytics.FriendsNearbyFeedUnitAnalyticsEventBuilder.FriendsNearbyEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLArticleChainingFeedUnit;
import com.facebook.graphql.model.GraphQLCelebrationsFeedUnit;
import com.facebook.graphql.model.GraphQLCelebrationsFeedUnitItem;
import com.facebook.graphql.model.GraphQLFriendLocationFeedUnitItem;
import com.facebook.graphql.model.GraphQLFriendsLocationsFeedUnit;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnitStoriesEdge;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnitItem;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLGroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLInstagramPhotosFromFriendsFeedUnit;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnit;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnitItem;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnitStoriesEdge;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedGroupsYouShouldJoinFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnitContactsEdge;
import com.facebook.graphql.model.GraphQLPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnitItem;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnitItem;
import com.facebook.graphql.model.GraphQLQuickPromotion;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnit;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnitItem;
import com.facebook.graphql.model.GraphQLSocialWifiFeedUnit;
import com.facebook.graphql.model.GraphQLSocialWifiFeedUnitItem;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryGallerySurveyFeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLSuggestedVideoConnection;
import com.facebook.graphql.model.GraphQLTopicCustomizationStory;
import com.facebook.graphql.model.GraphQLVideoChainingFeedUnit;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.ImpressionUtil;
import com.facebook.graphql.model.InstagramPhotosFromFriendsPhoto;
import com.facebook.graphql.model.IsValidUtil;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.QuickPromotionFeedUnitHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.ScrollableItemListFeedUnitImpl;
import com.facebook.graphql.model.Sponsorable;
import com.facebook.graphql.model.SponsoredImpression;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.quickpromotion.logger.QuickPromotionLogger;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.facebook.video.engine.VideoLoggingUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: invalid_id */
public class FeedUnitImpressionLogger {
    private static volatile FeedUnitImpressionLogger f19532f;
    public final AnalyticsLogger f19533a;
    private final NewsFeedAnalyticsEventBuilder f19534b;
    private final FriendsNearbyFeedUnitAnalyticsEventBuilder f19535c;
    private final Lazy<VideoLoggingUtils> f19536d;
    public final VideoChannelSessionManager f19537e;

    public static com.facebook.feed.logging.impression.FeedUnitImpressionLogger m27214a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19532f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.impression.FeedUnitImpressionLogger.class;
        monitor-enter(r1);
        r0 = f19532f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m27219b(r0);	 Catch:{ all -> 0x0035 }
        f19532f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19532f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.impression.FeedUnitImpressionLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.impression.FeedUnitImpressionLogger");
    }

    private static FeedUnitImpressionLogger m27219b(InjectorLike injectorLike) {
        return new FeedUnitImpressionLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), FriendsNearbyFeedUnitAnalyticsEventBuilder.m27223a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3663), VideoChannelSessionManager.a(injectorLike));
    }

    @Inject
    public FeedUnitImpressionLogger(AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FriendsNearbyFeedUnitAnalyticsEventBuilder friendsNearbyFeedUnitAnalyticsEventBuilder, Lazy<VideoLoggingUtils> lazy, VideoChannelSessionManager videoChannelSessionManager) {
        this.f19533a = analyticsLogger;
        this.f19534b = newsFeedAnalyticsEventBuilder;
        this.f19535c = friendsNearbyFeedUnitAnalyticsEventBuilder;
        this.f19536d = lazy;
        this.f19537e = videoChannelSessionManager;
    }

    public final void m27220a(FeedUnit feedUnit, int i) {
        if (feedUnit instanceof Sponsorable) {
            SponsoredImpression ab_ = ((Sponsorable) feedUnit).ab_();
            if (ab_ != null && ab_.mo3121k()) {
                return;
            }
        }
        HasTracking hasTracking;
        JsonNode a;
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        if (feedUnit instanceof GraphQLPagesYouMayLikeFeedUnit) {
            hasTracking = (GraphQLPagesYouMayLikeFeedUnit) feedUnit;
            if (!(hasTracking == null || ImpressionUtil.m29326c(hasTracking))) {
                SuggestedPageUnitItem suggestedPageUnitItem;
                ImmutableList a2 = ScrollableItemListFeedUnitImpl.a(hasTracking);
                if (a2 == null || hasTracking.ac_() >= a2.size()) {
                    suggestedPageUnitItem = null;
                } else {
                    suggestedPageUnitItem = (SuggestedPageUnitItem) a2.get(hasTracking.ac_());
                }
                HasTracking hasTracking2 = suggestedPageUnitItem;
                if (hasTracking2 != null) {
                    boolean z;
                    if (hasTracking2.A() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a = GraphQLHelper.m22468a(hasTracking2, hasTracking);
                    if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                        honeyAnalyticsEvent = null;
                    } else {
                        honeyAnalyticsEvent = new HoneyClientEvent("pyml_imp").m5085a("tracking", a).mo699b(z);
                        honeyAnalyticsEvent.f3099c = "native_newsfeed";
                        honeyAnalyticsEvent = honeyAnalyticsEvent;
                    }
                    this.f19533a.mo533c(honeyAnalyticsEvent);
                    ImpressionUtil.m29325b(hasTracking);
                }
            }
        } else if (feedUnit instanceof GraphQLPeopleYouMayKnowFeedUnit) {
            hasTracking = (GraphQLPeopleYouMayKnowFeedUnit) feedUnit;
            r1 = ItemListFeedUnitImpl.m30148a((GraphQLPeopleYouMayKnowFeedUnit) hasTracking);
            if (hasTracking.ac_() >= 0 && hasTracking.ac_() < r1.size()) {
                r1 = (GraphQLPeopleYouMayKnowFeedUnitItem) r1.get(hasTracking.ac_());
                if (!ImpressionUtil.m29323a(r1)) {
                    this.f19533a.mo533c(NewsFeedAnalyticsEventBuilder.m14124h(GraphQLHelper.m22468a((HasTracking) r1, hasTracking)));
                    ImpressionUtil.m29321a(r1, true);
                }
            }
        } else if (feedUnit instanceof GraphQLInstagramPhotosFromFriendsFeedUnit) {
            r8 = (GraphQLInstagramPhotosFromFriendsFeedUnit) feedUnit;
            if (!PropertyHelper.m21261a(r8).f14868q) {
                List a3 = ScrollableItemListFeedUnitImpl.a(r8);
                if (!a3.isEmpty()) {
                    r1 = ((InstagramPhotosFromFriendsPhoto) a3.get(0)).a();
                    if (NewsFeedAnalyticsEventBuilder.m14092B(r1)) {
                        honeyAnalyticsEvent = null;
                    } else {
                        honeyAnalyticsEvent = new HoneyClientEvent("ig_pff_imp").m5085a("tracking", r1);
                        honeyAnalyticsEvent.f3099c = "native_newsfeed";
                        honeyAnalyticsEvent = honeyAnalyticsEvent;
                    }
                    this.f19533a.mo533c(honeyAnalyticsEvent);
                }
                PropertyHelper.m21261a(r8).f14868q = true;
            }
        } else if (feedUnit instanceof GraphQLArticleChainingFeedUnit) {
            GraphQLArticleChainingFeedUnit graphQLArticleChainingFeedUnit = (GraphQLArticleChainingFeedUnit) feedUnit;
            r1 = graphQLArticleChainingFeedUnit.ac_();
            if (r1 >= 0 && r1 < graphQLArticleChainingFeedUnit.m27274l().size()) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ItemListFeedUnitImpl.m30137a(graphQLArticleChainingFeedUnit).get(r1);
                FeedProps a4 = FeedProps.m19801a(graphQLStoryAttachment, ImmutableList.of(graphQLArticleChainingFeedUnit));
                if (!PropertyHelper.m21283a(graphQLStoryAttachment)) {
                    a = TrackableFeedProps.m27451a(a4);
                    r3 = Strings.nullToEmpty(graphQLStoryAttachment.m23966C());
                    if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                        r4 = null;
                    } else {
                        r4 = new HoneyClientEvent("chained_article_item_impression").m5085a("tracking", a).m5090b("URL", r3);
                        r4.f3099c = "native_newsfeed";
                        r4 = r4;
                    }
                    this.f19533a.mo533c(r4);
                    PropertyHelper.m21278a(graphQLStoryAttachment, true);
                }
            }
        } else if (feedUnit instanceof GraphQLVideoChainingFeedUnit) {
            m27218a((GraphQLVideoChainingFeedUnit) feedUnit);
        } else if ((feedUnit instanceof GraphQLStorySet) && PropertyHelper.m21286a((GraphQLStorySet) feedUnit)) {
            boolean c;
            GraphQLStorySet graphQLStorySet = (GraphQLStorySet) feedUnit;
            if (graphQLStorySet.ac_() < StorySetHelper.b(graphQLStorySet).size()) {
                c = ImpressionUtil.m29326c(graphQLStorySet);
            } else {
                c = false;
            }
            if (!c) {
                r1 = TrackableFeedProps.m27451a(FeedProps.m19802c(graphQLStorySet).m19803a((GraphQLStory) StorySetHelper.b(graphQLStorySet).get(graphQLStorySet.ac_())));
                if (NewsFeedAnalyticsEventBuilder.m14092B(r1)) {
                    honeyAnalyticsEvent = null;
                } else {
                    honeyAnalyticsEvent = new HoneyClientEvent("chained_story_item_impression").m5085a("tracking", r1);
                    honeyAnalyticsEvent.f3099c = "native_newsfeed";
                    honeyAnalyticsEvent = honeyAnalyticsEvent;
                }
                this.f19533a.mo533c(honeyAnalyticsEvent);
                if (graphQLStorySet.ac_() < StorySetHelper.b(graphQLStorySet).size()) {
                    ImpressionUtil.m29325b(graphQLStorySet);
                }
            }
        } else if (feedUnit instanceof GraphQLCelebrationsFeedUnit) {
            r8 = (GraphQLCelebrationsFeedUnit) feedUnit;
            if (!(r8 == null || r8.m27317l() == null || PropertyHelper.m21261a(r8).f14868q)) {
                int size = r8.m27317l().size();
                for (r2 = 0; r2 < size; r2++) {
                    HoneyAnalyticsEvent honeyAnalyticsEvent2;
                    r1 = GraphQLHelper.m22468a((GraphQLCelebrationsFeedUnitItem) ItemListFeedUnitImpl.m30138a((GraphQLCelebrationsFeedUnit) r8).get(r2), (HasTracking) r8);
                    if (NewsFeedAnalyticsEventBuilder.m14092B(r1)) {
                        honeyAnalyticsEvent2 = null;
                    } else {
                        honeyAnalyticsEvent2 = new HoneyClientEvent("gifts_imp").m5085a("tracking", r1);
                        honeyAnalyticsEvent2.f3099c = "native_newsfeed";
                        honeyAnalyticsEvent2 = honeyAnalyticsEvent2;
                    }
                    this.f19533a.mo533c(honeyAnalyticsEvent2);
                }
                PropertyHelper.m21261a(r8).f14868q = true;
            }
        } else if (feedUnit instanceof GraphQLPeopleYouMayInviteFeedUnit) {
            hasTracking = (GraphQLPeopleYouMayInviteFeedUnit) feedUnit;
            r1 = hasTracking.m25671r();
            r2 = hasTracking.ac_();
            if (r1 != null && r2 >= 0 && r2 < r1.size()) {
                r1 = (GraphQLPeopleYouMayInviteFeedUnitContactsEdge) r1.get(r2);
                if (!(r1 == null || PropertyHelper.m21261a(r1).f14868q)) {
                    a = GraphQLHelper.m22468a((HasTracking) r1, hasTracking);
                    if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                        r4 = null;
                    } else {
                        r4 = new HoneyClientEvent("pymi_imp").m5085a("tracking", a);
                        r4.f3099c = "native_newsfeed";
                        r4 = r4;
                    }
                    this.f19533a.mo533c(r4);
                    PropertyHelper.m21261a(r1).f14868q = true;
                }
            }
        } else if (feedUnit instanceof GraphQLPaginatedPeopleYouMayKnowFeedUnit) {
            hasTracking = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) feedUnit;
            r1 = ItemListFeedUnitImpl.m30146a((GraphQLPaginatedPeopleYouMayKnowFeedUnit) hasTracking);
            r2 = hasTracking.ac_();
            if (r1 != null && r2 >= 0 && r2 < r1.size()) {
                r1 = (PeopleYouMayKnowFeedUnitItem) r1.get(r2);
                if (!(r1 == null || ImpressionUtil.m29323a(r1))) {
                    this.f19533a.mo533c(NewsFeedAnalyticsEventBuilder.m14124h(GraphQLHelper.m22468a((HasTracking) r1, hasTracking)));
                    ImpressionUtil.m29321a(r1, true);
                }
            }
        } else if (feedUnit instanceof GraphQLPeopleYouShouldFollowFeedUnit) {
            hasTracking = (GraphQLPeopleYouShouldFollowFeedUnit) feedUnit;
            r1 = ItemListFeedUnitImpl.m30149a((GraphQLPeopleYouShouldFollowFeedUnit) hasTracking);
            if (hasTracking.ac_() >= 0 && hasTracking.ac_() < r1.size()) {
                r1 = (GraphQLPeopleYouShouldFollowFeedUnitItem) r1.get(hasTracking.ac_());
                if (!(r1 == null || PropertyHelper.m21261a(r1).f14868q)) {
                    a = GraphQLHelper.m22468a((HasTracking) r1, hasTracking);
                    if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                        r4 = null;
                    } else {
                        r4 = new HoneyClientEvent("pysf_imp").m5085a("tracking", a);
                        r4.f3099c = "native_newsfeed";
                        r4 = r4;
                    }
                    this.f19533a.mo533c(r4);
                    PropertyHelper.m21261a(r1).f14868q = true;
                }
            }
        } else if (feedUnit instanceof GraphQLGroupsYouShouldCreateFeedUnit) {
            m27216a((GraphQLGroupsYouShouldCreateFeedUnit) feedUnit);
        } else if (feedUnit instanceof GraphQLGroupsYouShouldJoinFeedUnit) {
            m27217a((GraphQLGroupsYouShouldJoinFeedUnit) feedUnit);
        } else if (feedUnit instanceof GraphQLPaginatedGroupsYouShouldJoinFeedUnit) {
            hasTracking = (GraphQLPaginatedGroupsYouShouldJoinFeedUnit) feedUnit;
            r1 = hasTracking.m25298l();
            r2 = hasTracking.ac_();
            if (r1 != null && r2 >= 0 && r2 < r1.size()) {
                r1 = (GroupsYouShouldJoinFeedUnitItem) r1.get(r2);
                if (!(r1 == null || PropertyHelper.m21261a(r1).f14868q)) {
                    this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14118c("gysj_imp", GraphQLHelper.m22468a((HasTracking) r1, hasTracking)));
                    PropertyHelper.m21261a(r1).f14868q = true;
                }
            }
        } else if (feedUnit instanceof GraphQLGroupTopStoriesFeedUnit) {
            m27215a((GraphQLGroupTopStoriesFeedUnit) feedUnit);
        } else if (feedUnit instanceof GraphQLSaleGroupsNearYouFeedUnit) {
            hasTracking = (GraphQLSaleGroupsNearYouFeedUnit) feedUnit;
            r1 = hasTracking.m25939l();
            r2 = hasTracking.ac_();
            if (r1 != null && r2 >= 0 && r2 < r1.size()) {
                r1 = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) r1.get(r2);
                if (!(r1 == null || PropertyHelper.m21261a(r1).f14868q)) {
                    this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14115b("sgny_imp", GraphQLHelper.m22468a((HasTracking) r1, hasTracking)));
                    PropertyHelper.m21261a(r1).f14868q = true;
                }
            }
        } else if (feedUnit instanceof GraphQLSavedCollectionFeedUnit) {
            hasTracking = (GraphQLSavedCollectionFeedUnit) feedUnit;
            if (!(hasTracking == null || hasTracking.m22282y() == null || i < 0)) {
                r1 = ScrollableItemListFeedUnitImpl.a(hasTracking);
                if (i < hasTracking.m22276s().size()) {
                    r1 = (GraphQLSavedCollectionFeedUnitItem) r1.get(i);
                    if (!PropertyHelper.m21261a(r1).f14868q) {
                        a = GraphQLHelper.m22468a((HasTracking) r1, hasTracking);
                        r3 = hasTracking.m22282y().mo2915b();
                        if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                            r4 = null;
                        } else {
                            r4 = new HoneyClientEvent("saved_collection_ego_imp").m5085a("tracking", a).m5090b("collection_id", r3);
                            r4.f3099c = "native_newsfeed";
                            r4 = r4;
                        }
                        this.f19533a.mo533c(r4);
                        PropertyHelper.m21261a(r1).f14868q = true;
                    }
                }
            }
        } else if (feedUnit instanceof GraphQLSocialWifiFeedUnit) {
            r8 = (GraphQLSocialWifiFeedUnit) feedUnit;
            if (!(r8 == null || ItemListFeedUnitImpl.m30154a((GraphQLSocialWifiFeedUnit) r8) == null || PropertyHelper.m21261a(r8).f14868q)) {
                for (r2 = 0; r2 < r8.m29850l().size(); r2++) {
                    r1 = GraphQLHelper.m22468a((GraphQLSocialWifiFeedUnitItem) ItemListFeedUnitImpl.m30154a((GraphQLSocialWifiFeedUnit) r8).get(r2), (HasTracking) r8);
                    if (NewsFeedAnalyticsEventBuilder.m14092B(r1)) {
                        r4 = null;
                    } else {
                        r4 = new HoneyClientEvent("social_wifi_ego_imp").m5085a("tracking", r1);
                        r4.f3099c = "native_newsfeed";
                        r4 = r4;
                    }
                    this.f19533a.mo533c(r4);
                }
                PropertyHelper.m21261a(r8).f14868q = true;
            }
        } else if (feedUnit instanceof GraphQLFriendsLocationsFeedUnit) {
            hasTracking = (GraphQLFriendsLocationsFeedUnit) feedUnit;
            r1 = hasTracking.ac_();
            List a5 = ScrollableItemListFeedUnitImpl.a(hasTracking);
            if (a5 != null && r1 < a5.size()) {
                r1 = (GraphQLFriendLocationFeedUnitItem) a5.get(r1);
                if (!PropertyHelper.m21261a(r1).f14868q) {
                    HoneyAnalyticsEvent a6 = FriendsNearbyFeedUnitAnalyticsEventBuilder.m27221a(FriendsNearbyEvent.FRIENDS_LOCATIONS_FEEDSTORY_ITEM_IMPRESSION, GraphQLHelper.m22468a((HasTracking) r1, hasTracking));
                    if (a6 != null) {
                        a6.m5086a("feed_type", hasTracking.m22807u());
                        a6.m5086a("location_category", r1.m());
                    }
                    this.f19533a.mo533c(a6);
                    PropertyHelper.m21261a(r1).f14868q = true;
                }
            }
        } else if (feedUnit instanceof GraphQLQuickPromotionFeedUnit) {
            GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) feedUnit;
            GraphQLQuickPromotion b = QuickPromotionFeedUnitHelper.b(graphQLQuickPromotionFeedUnit);
            if (!(b == null || QuickPromotionFeedUnitHelper.c(graphQLQuickPromotionFeedUnit) == null || PropertyHelper.m21261a((Object) graphQLQuickPromotionFeedUnit).f14868q)) {
                PropertyHelper.m21261a((Object) graphQLQuickPromotionFeedUnit).f14868q = true;
                honeyAnalyticsEvent = new HoneyClientEvent("quick_promotion_ego_imp").m5085a("tracking", FeedTrackableUtil.m27150a(graphQLQuickPromotionFeedUnit));
                honeyAnalyticsEvent.f3099c = "native_newsfeed";
                HoneyClientEvent honeyClientEvent = honeyAnalyticsEvent;
                QuickPromotionLogger.m12598a(honeyClientEvent, b.k());
                this.f19533a.mo533c(honeyClientEvent);
            }
        } else if (feedUnit instanceof GraphQLPlaceReviewFeedUnit) {
            GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) feedUnit;
            if (graphQLPlaceReviewFeedUnit != null) {
                ImmutableList a7 = ItemListFeedUnitImpl.m30150a(graphQLPlaceReviewFeedUnit);
                if (a7 != null && i >= 0 && i < a7.size() && ((GraphQLPlaceReviewFeedUnitItem) a7.get(i)).l() != null) {
                    r1 = (GraphQLPlaceReviewFeedUnitItem) a7.get(i);
                    if (!PropertyHelper.m21261a(r1).f14868q) {
                        a = new ArrayNode(JsonNodeFactory.f3121a);
                        a.m13382a(FeedTrackableUtil.m27151a((CachedFeedTrackable) r1));
                        a.m13394h(graphQLPlaceReviewFeedUnit.mo2877k());
                        r3 = r1.l().ae();
                        if (NewsFeedAnalyticsEventBuilder.m14092B(a)) {
                            r4 = null;
                        } else {
                            r4 = new HoneyClientEvent("place_review_imp").m5085a("tracking", a).m5090b("page_id", r3);
                            r4.f3099c = "native_newsfeed";
                            r4 = r4;
                        }
                        this.f19533a.mo531b(r4);
                        PropertyHelper.m21261a(r1).f14868q = true;
                    }
                }
            }
        } else if (feedUnit instanceof GraphQLStoryGallerySurveyFeedUnit) {
            r8 = (GraphQLStoryGallerySurveyFeedUnit) feedUnit;
            if (!(r8 == null || PropertyHelper.m21284a((GraphQLStoryGallerySurveyFeedUnit) r8) || r8.m25981v() == null)) {
                honeyAnalyticsEvent = new HoneyClientEvent("story_gallery_survey_feed_unit_impression").m5090b("tracking", r8.m25981v());
                honeyAnalyticsEvent.f3099c = "native_newsfeed";
                this.f19533a.mo533c(honeyAnalyticsEvent);
                PropertyHelper.m21261a(r8).f14868q = true;
            }
        } else if (feedUnit instanceof GraphQLMobilePageAdminPanelFeedUnit) {
            hasTracking = (GraphQLMobilePageAdminPanelFeedUnit) feedUnit;
            if (!(hasTracking == null || hasTracking.mo2877k() == null)) {
                r1 = ScrollableItemListFeedUnitImpl.a(hasTracking);
                r2 = hasTracking.ac_();
                if (r1 != null && r2 < r1.size()) {
                    r1 = (GraphQLMobilePageAdminPanelFeedUnitItem) r1.get(r2);
                    if (!(r1 == null || PropertyHelper.m21261a(r1).f14868q || r1.k() == null)) {
                        r4 = new HoneyClientEvent("page_admin_panel_imp").m5085a("tracking", GraphQLHelper.m22468a((HasTracking) r1, hasTracking));
                        r4.f3099c = "page_admin_panel";
                        this.f19533a.mo533c(r4);
                        PropertyHelper.m21261a(r1).f14868q = true;
                    }
                }
            }
        } else if (feedUnit instanceof GraphQLPagesYouMayAdvertiseFeedUnit) {
            r8 = (GraphQLPagesYouMayAdvertiseFeedUnit) feedUnit;
            if (!(r8 == null || PropertyHelper.m21261a(r8).f14868q)) {
                this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14103a(FeedTrackableUtil.m27149a((GraphQLPagesYouMayAdvertiseFeedUnit) r8), String.valueOf(r8.m25620r())));
                PropertyHelper.m21261a(r8).f14868q = true;
            }
        } else if (feedUnit instanceof GraphQLTopicCustomizationStory) {
            r8 = (GraphQLTopicCustomizationStory) feedUnit;
            if (!(r8 == null || r8.mo2877k() == null || PropertyHelper.m21261a(r8).f14868q)) {
                honeyAnalyticsEvent = new HoneyClientEvent("customization_subtopic_impression").m5085a("tracking", GraphQLHelper.m22467a((ScrollableItemListFeedUnit) r8));
                honeyAnalyticsEvent.f3099c = "native_newsfeed";
                this.f19533a.mo533c(honeyAnalyticsEvent);
                PropertyHelper.m21261a(r8).f14868q = true;
            }
        } else if (feedUnit instanceof GraphQLPageStoriesYouMissedFeedUnit) {
            r8 = (GraphQLPageStoriesYouMissedFeedUnit) feedUnit;
            if (IsValidUtil.m22953a((GraphQLPageStoriesYouMissedFeedUnit) r8)) {
                r1 = r8.m25584l().a();
                r2 = r8.ac_();
                if (r2 >= 0 && r2 < r1.size() && r1.get(r2) != null) {
                    HasTracking a8 = ((GraphQLPageStoriesYouMissedFeedUnitStoriesEdge) r1.get(r2)).a();
                    if (!(a8 == null || PropertyHelper.m21261a(r8).f14868q)) {
                        this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14118c("psym_imp", GraphQLHelper.m22468a(a8, (HasTracking) r8)));
                        PropertyHelper.m21261a(r8).f14868q = true;
                    }
                }
            }
        }
    }

    private void m27217a(GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit) {
        if (!PropertyHelper.m21261a((Object) graphQLGroupsYouShouldJoinFeedUnit).f14868q) {
            ImmutableList a = ItemListFeedUnitImpl.m30141a(graphQLGroupsYouShouldJoinFeedUnit);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14118c("gysj_imp", GraphQLHelper.m22468a((GraphQLGroupsYouShouldJoinFeedUnitItem) a.get(i), (HasTracking) graphQLGroupsYouShouldJoinFeedUnit)));
            }
            PropertyHelper.m21261a((Object) graphQLGroupsYouShouldJoinFeedUnit).f14868q = true;
        }
    }

    private void m27215a(GraphQLGroupTopStoriesFeedUnit graphQLGroupTopStoriesFeedUnit) {
        Object obj;
        if (graphQLGroupTopStoriesFeedUnit.m25490s() == null || graphQLGroupTopStoriesFeedUnit.m25484l() == null || graphQLGroupTopStoriesFeedUnit.m25484l().a() == null || graphQLGroupTopStoriesFeedUnit.m25484l().a().isEmpty()) {
            obj = null;
        } else {
            ImmutableList a = graphQLGroupTopStoriesFeedUnit.m25484l().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                if (!IsValidUtil.m22946a((GraphQLGroupTopStoriesFeedUnitStoriesEdge) a.get(i))) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
        }
        if (obj != null) {
            ImmutableList a2 = graphQLGroupTopStoriesFeedUnit.m25484l().a();
            int ac_ = graphQLGroupTopStoriesFeedUnit.ac_();
            if (ac_ >= 0 && ac_ < a2.size()) {
                Object obj2 = (GraphQLGroupTopStoriesFeedUnitStoriesEdge) a2.get(ac_);
                if (obj2 != null && !PropertyHelper.m21261a(obj2).f14868q) {
                    this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14118c("gsym_imp", GraphQLHelper.m22468a(obj2.j(), (HasTracking) graphQLGroupTopStoriesFeedUnit)));
                    PropertyHelper.m21261a(obj2).f14868q = true;
                }
            }
        }
    }

    private void m27216a(GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit) {
        if (graphQLGroupsYouShouldCreateFeedUnit != null && graphQLGroupsYouShouldCreateFeedUnit.m25510l() != null && !PropertyHelper.m21261a((Object) graphQLGroupsYouShouldCreateFeedUnit).f14868q) {
            ImmutableList l = graphQLGroupsYouShouldCreateFeedUnit.m25510l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                this.f19533a.mo526a(NewsFeedAnalyticsEventBuilder.m14118c("gysc_imp", GraphQLHelper.m22468a((GraphQLGroupsYouShouldCreateFeedUnitItem) l.get(i), (HasTracking) graphQLGroupsYouShouldCreateFeedUnit)));
            }
            PropertyHelper.m21261a((Object) graphQLGroupsYouShouldCreateFeedUnit).f14868q = true;
        }
    }

    private void m27218a(GraphQLVideoChainingFeedUnit graphQLVideoChainingFeedUnit) {
        int ac_ = graphQLVideoChainingFeedUnit.ac_();
        if (ac_ >= 0 && ac_ < graphQLVideoChainingFeedUnit.m27295l().size()) {
            if (!(graphQLVideoChainingFeedUnit == null || graphQLVideoChainingFeedUnit.m27298p() == null)) {
                String J = graphQLVideoChainingFeedUnit.m27298p().m24060J();
                List arrayList = new ArrayList();
                GraphQLSuggestedVideoConnection r = graphQLVideoChainingFeedUnit.m27300r();
                if (r != null) {
                    ImmutableList a = r.a();
                    if (a != null) {
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            GraphQLMedia r2 = ((GraphQLStoryAttachment) a.get(i)).m23979r();
                            if (r2 != null) {
                                arrayList.add(r2.m24452b());
                            }
                        }
                    }
                }
                this.f19537e.a(J, arrayList);
            }
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ItemListFeedUnitImpl.m30157a(graphQLVideoChainingFeedUnit).get(ac_);
            FeedProps a2 = FeedProps.m19801a(graphQLStoryAttachment, ImmutableList.of(graphQLVideoChainingFeedUnit));
            if (!PropertyHelper.m21283a(graphQLStoryAttachment)) {
                ((VideoLoggingUtils) this.f19536d.get()).m27092b(TrackableFeedProps.m27451a(a2), graphQLStoryAttachment.m23979r() != null ? graphQLStoryAttachment.m23979r().m24452b() : null, null, false);
                PropertyHelper.m21278a(graphQLStoryAttachment, true);
            }
        }
    }
}
