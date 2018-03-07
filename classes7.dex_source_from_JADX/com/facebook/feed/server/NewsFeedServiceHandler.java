package com.facebook.feed.server;

import android.os.Bundle;
import com.facebook.api.feed.DeleteStoryMethod;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feed.FeedOperationTypes;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams;
import com.facebook.api.feed.FetchPaginatedRelatedStoryParams;
import com.facebook.api.feed.HideFeedStoryMethod;
import com.facebook.api.feed.HideFeedStoryMethod.Params;
import com.facebook.api.feed.NegativeFeedbackActionOnFeedMethod;
import com.facebook.api.feed.SubmitResearchPollResponseMethod;
import com.facebook.api.feed.SubmitResearchPollResponseParams;
import com.facebook.api.feed.SubmitSurveyResponseMethod;
import com.facebook.api.feed.SubmitSurveyResponseParams;
import com.facebook.api.feed.SubmitSurveyResponseResult;
import com.facebook.api.feedcache.db.FeedBackendFetch;
import com.facebook.api.feedcache.db.FeedFetchCoordinator;
import com.facebook.api.feedcache.memory.ToggleSaveParams;
import com.facebook.facecastdisplay.protocol.LiveCommentDelayLoggingMethod;
import com.facebook.facecastdisplay.protocol.LiveVideoInviteFriendsMethod;
import com.facebook.facecastdisplay.protocol.LiveVideoInviteFriendsParams;
import com.facebook.facecastdisplay.protocol.LiveVideosWatchingEventsLoggingMethod;
import com.facebook.facecastdisplay.protocol.MutateLiveScribeMethod;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceProgressCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.feed.feedtype.FeedTypeDataItem;
import com.facebook.feed.feedtype.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.feed.protocol.FetchFollowUpFeedUnitMethod;
import com.facebook.feed.protocol.FetchPaginatedRelatedStoryMethod;
import com.facebook.feed.protocol.PlaceSaveMethod;
import com.facebook.feed.protocol.PlaceUnsaveMethod;
import com.facebook.feed.protocol.coupons.ClaimCouponMethod;
import com.facebook.feed.protocol.coupons.ClaimCouponParams;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.http.common.NetworkException;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.saved.common.protocol.UpdateSavedStateMethod;
import com.facebook.saved.common.protocol.UpdateSavedStateParams;
import com.facebook.saved.common.sync.SavedEventHandler;
import java.net.UnknownHostException;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: UIView */
public class NewsFeedServiceHandler implements BlueServiceHandler {
    public final ApiMethodRunnerImpl f21610a;
    public final Lazy<HideFeedStoryMethod> f21611b;
    public final Lazy<NegativeFeedbackActionOnFeedMethod> f21612c;
    private final Lazy<DeleteStoryMethod> f21613d;
    public final Lazy<ClaimCouponMethod> f21614e;
    public final Lazy<SubmitSurveyResponseMethod> f21615f;
    public final Lazy<SubmitResearchPollResponseMethod> f21616g;
    public final Lazy<FetchFollowUpFeedUnitMethod> f21617h;
    public final Lazy<FetchPaginatedRelatedStoryMethod> f21618i;
    public final Lazy<PlaceSaveMethod> f21619j;
    public final Lazy<PlaceUnsaveMethod> f21620k;
    private final Lazy<UpdateSavedStateMethod> f21621l;
    public final Lazy<LiveCommentDelayLoggingMethod> f21622m;
    public final Lazy<LiveVideosWatchingEventsLoggingMethod> f21623n;
    private final Lazy<Set<FeedTypeDataItem>> f21624o;
    public final NewsFeedServiceImplementation f21625p;
    private final FeedFetchCoordinator f21626q;
    private final Lazy<SavedEventHandler> f21627r;
    public final Lazy<MutateLiveScribeMethod> f21628s;
    public final Lazy<LiveVideoInviteFriendsMethod> f21629t;

    public static NewsFeedServiceHandler m24218b(InjectorLike injectorLike) {
        return new NewsFeedServiceHandler(ApiMethodRunnerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 5896), IdBasedLazy.a(injectorLike, 4796), IdBasedLazy.a(injectorLike, 4797), IdBasedSingletonScopeProvider.b(injectorLike, 4795), IdBasedLazy.a(injectorLike, 4799), IdBasedLazy.a(injectorLike, 4798), IdBasedLazy.a(injectorLike, 5883), IdBasedLazy.a(injectorLike, 5889), IdBasedLazy.a(injectorLike, 5893), IdBasedLazy.a(injectorLike, 5894), IdBasedLazy.a(injectorLike, 10401), IdBasedLazy.a(injectorLike, 5746), IdBasedLazy.a(injectorLike, 5748), STATICDI_MULTIBIND_PROVIDER.FeedTypeDataItem.a(injectorLike), NewsFeedServiceImplementation.m24226a(injectorLike), FeedFetchCoordinator.a(injectorLike), IdBasedLazy.a(injectorLike, 10403), IdBasedLazy.a(injectorLike, 5749), IdBasedLazy.a(injectorLike, 5747));
    }

    public final OperationResult m24221a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("init_feed_fetch_news_feed_before".equals(str) || "init_feed_fetch_news_feed_after".equals(str)) {
            return OperationResult.a;
        }
        if (FeedOperationTypes.a(str)) {
            return m24220g(operationParams);
        }
        OperationResult a;
        if ("feed_hide_story".equals(str)) {
            Params params = (Params) operationParams.c.getParcelable("hideFeedStoryParams");
            if (params.e && params.d.isHiddenOrVisible()) {
                a = OperationResult.a(Boolean.toString(((Boolean) this.f21610a.a((ApiMethod) this.f21611b.get(), params)).booleanValue()));
            } else {
                a = OperationResult.a;
            }
            return a;
        } else if ("feed_negative_feedback_story".equals(str)) {
            return OperationResult.a((String) this.f21610a.a((ApiMethod) this.f21612c.get(), (NegativeFeedbackActionOnFeedMethod.Params) operationParams.c.getParcelable("negativeFeedbackActionOnFeedParams")));
        } else if ("feed_delete_story".equals(str)) {
            return m24219f(operationParams);
        } else {
            if ("feed_claim_coupon".equals(str)) {
                return OperationResult.a(Boolean.toString(((Boolean) this.f21610a.a((ApiMethod) this.f21614e.get(), (ClaimCouponParams) operationParams.c.getParcelable("claimCouponParams"))).booleanValue()));
            } else if ("feed_clear_cache".equals(str)) {
                return OperationResult.a;
            } else {
                if ("feed_mark_impression_logged".equals(str)) {
                    return OperationResult.a;
                }
                if ("feed_submit_survey_response".equals(str)) {
                    return OperationResult.a((SubmitSurveyResponseResult) this.f21610a.a((ApiMethod) this.f21615f.get(), (SubmitSurveyResponseParams) operationParams.c.getParcelable("submitSurveyResponseParamsKey")));
                } else if ("feed_mark_survey_completed".equals(str)) {
                    return OperationResult.a;
                } else {
                    if ("feed_submit_research_poll_response".equals(str)) {
                        this.f21610a.a((ApiMethod) this.f21616g.get(), (SubmitResearchPollResponseParams) operationParams.c.getParcelable("submitResearchPollResponseParamsKey"));
                        return OperationResult.a;
                    } else if ("feed_mark_research_poll_completed".equals(str)) {
                        return OperationResult.a;
                    } else {
                        if ("feed_fetch_followup_feed_unit".equals(str)) {
                            return OperationResult.a((FeedUnit) this.f21610a.a((ApiMethod) this.f21617h.get(), (FetchFollowUpFeedUnitParams) operationParams.c.getParcelable("fetchFollowUpFeedUnitParamsKey")));
                        } else if ("feed_fetch_paginated_related_story".equals(str)) {
                            return OperationResult.a((GraphQLStorySet) this.f21610a.a((ApiMethod) this.f21618i.get(), (FetchPaginatedRelatedStoryParams) operationParams.c.getParcelable("fetchPaginatedRelatedStoryParamsKey")));
                        } else if ("toggle_save_place".equals(str)) {
                            ToggleSaveParams toggleSaveParams = (ToggleSaveParams) operationParams.c.getParcelable("togglePlaceParamsKey");
                            a = toggleSaveParams.e ? ((Boolean) this.f21610a.a((ApiMethod) this.f21619j.get(), toggleSaveParams)).booleanValue() ? OperationResult.a : OperationResult.a(ErrorCode.OTHER) : ((Boolean) this.f21610a.a((ApiMethod) this.f21620k.get(), toggleSaveParams)).booleanValue() ? OperationResult.a : OperationResult.a(ErrorCode.OTHER);
                            return a;
                        } else if ("update_story_saved_state".equals(str)) {
                            return m24217b(operationParams);
                        } else {
                            if ("live_comment_log_delay".equals(str)) {
                                this.f21610a.a((ApiMethod) this.f21622m.get(), (LiveCommentDelayLoggingMethod.Params) operationParams.c.getParcelable("liveCommentLogDelayParamsKey"));
                                return OperationResult.a;
                            } else if ("live_video_log_watch_time".equals(str)) {
                                this.f21610a.a((ApiMethod) this.f21623n.get(), (LiveVideosWatchingEventsLoggingMethod.Params) operationParams.c.getParcelable("liveVideoLogWatchTimeParamsKey"));
                                return OperationResult.a;
                            } else if ("mutate_live_scribe".equals(str)) {
                                this.f21610a.a((ApiMethod) this.f21628s.get(), (MutateLiveScribeMethod.Params) operationParams.c.getParcelable("mutateLiveScribeParamsKey"));
                                return OperationResult.a;
                            } else if ("live_video_invite_friends".equals(str)) {
                                this.f21610a.a((ApiMethod) this.f21629t.get(), (LiveVideoInviteFriendsParams) operationParams.c.getParcelable("liveVideoInviteFriendsParamKey"));
                                return OperationResult.a;
                            } else {
                                throw new ApiMethodNotFoundException(str);
                            }
                        }
                    }
                }
            }
        }
    }

    private OperationResult m24220g(OperationParams operationParams) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) operationParams.c.getParcelable("fetchFeedParams");
        final AbstractFeedTypeDataItem a = m24216a(fetchFeedParams);
        return OperationResult.a(this.f21626q.a(fetchFeedParams, operationParams.f, new FeedBackendFetch(this) {
            final /* synthetic */ NewsFeedServiceHandler f21609b;

            public final FetchFeedResult m24215a(FetchFeedParams fetchFeedParams, BlueServiceProgressCallback blueServiceProgressCallback) {
                return this.f21609b.f21625p.m24228a(fetchFeedParams, blueServiceProgressCallback, a.b());
            }
        }));
    }

    @Inject
    public NewsFeedServiceHandler(ApiMethodRunner apiMethodRunner, Lazy<ClaimCouponMethod> lazy, Lazy<HideFeedStoryMethod> lazy2, Lazy<NegativeFeedbackActionOnFeedMethod> lazy3, Lazy<DeleteStoryMethod> lazy4, Lazy<SubmitSurveyResponseMethod> lazy5, Lazy<SubmitResearchPollResponseMethod> lazy6, Lazy<FetchFollowUpFeedUnitMethod> lazy7, Lazy<FetchPaginatedRelatedStoryMethod> lazy8, Lazy<PlaceSaveMethod> lazy9, Lazy<PlaceUnsaveMethod> lazy10, Lazy<UpdateSavedStateMethod> lazy11, Lazy<LiveCommentDelayLoggingMethod> lazy12, Lazy<LiveVideosWatchingEventsLoggingMethod> lazy13, Lazy<Set<FeedTypeDataItem>> lazy14, NewsFeedServiceImplementation newsFeedServiceImplementation, FeedFetchCoordinator feedFetchCoordinator, Lazy<SavedEventHandler> lazy15, Lazy<MutateLiveScribeMethod> lazy16, Lazy<LiveVideoInviteFriendsMethod> lazy17) {
        this.f21610a = apiMethodRunner;
        this.f21611b = lazy2;
        this.f21612c = lazy3;
        this.f21613d = lazy4;
        this.f21614e = lazy;
        this.f21615f = lazy5;
        this.f21616g = lazy6;
        this.f21617h = lazy7;
        this.f21618i = lazy8;
        this.f21619j = lazy9;
        this.f21620k = lazy10;
        this.f21621l = lazy11;
        this.f21622m = lazy12;
        this.f21623n = lazy13;
        this.f21624o = lazy14;
        this.f21625p = newsFeedServiceImplementation;
        this.f21626q = feedFetchCoordinator;
        this.f21627r = lazy15;
        this.f21628s = lazy16;
        this.f21629t = lazy17;
    }

    private OperationResult m24217b(OperationParams operationParams) {
        Bundle b = operationParams.b();
        if (b == null) {
            return OperationResult.a(ErrorCode.OTHER);
        }
        try {
            if (!((Boolean) this.f21610a.a((ApiMethod) this.f21621l.get(), (UpdateSavedStateParams) b.getParcelable("updateStorySavedStateParamsKey"))).booleanValue()) {
                return OperationResult.a(ErrorCode.OTHER);
            }
            ((SavedEventHandler) this.f21627r.get()).a();
            return OperationResult.a();
        } catch (Throwable th) {
            if ((th instanceof UnknownHostException) || (th instanceof NetworkException)) {
                return OperationResult.a(ErrorCode.CONNECTION_FAILURE, th);
            }
            return OperationResult.a(ErrorCode.OTHER, th);
        }
    }

    private OperationResult m24219f(OperationParams operationParams) {
        DeleteStoryMethod.Params params = (DeleteStoryMethod.Params) operationParams.b().getParcelable("deleteStoryParams");
        try {
            if (params.d == DeleteMode.LOCAL_AND_SERVER) {
                this.f21610a.a((ApiMethod) this.f21613d.get(), params);
            }
            return OperationResult.a();
        } catch (ApiException e) {
            return OperationResult.a(ErrorCode.API_ERROR);
        }
    }

    private AbstractFeedTypeDataItem m24216a(FetchFeedParams fetchFeedParams) {
        for (AbstractFeedTypeDataItem abstractFeedTypeDataItem : (Set) this.f21624o.get()) {
            if (fetchFeedParams.b.g.equals(abstractFeedTypeDataItem.a)) {
                return abstractFeedTypeDataItem;
            }
        }
        throw new ApiMethodNotFoundException("Unknown FeedType: " + fetchFeedParams.b.g);
    }
}
