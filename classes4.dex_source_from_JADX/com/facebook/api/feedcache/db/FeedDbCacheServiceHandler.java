package com.facebook.api.feedcache.db;

import android.os.Bundle;
import com.facebook.analytics.cache.CacheTracker;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.api.feed.FeedOperationTypes;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.MarkResearchPollCompletedParams;
import com.facebook.api.feed.MarkSurveyCompletedParams;
import com.facebook.api.feed.SetHScrollUnitVisibleItemIndexParams;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.saved.common.protocol.UpdateSavedStateParams;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: privacy_selector_specific_friends_close */
public class FeedDbCacheServiceHandler implements BlueServiceHandler$Filter {
    private static volatile FeedDbCacheServiceHandler f4163c;
    public final Lazy<FeedDbCacheCleaner> f4164a;
    public final CacheTracker f4165b;

    public static com.facebook.api.feedcache.db.FeedDbCacheServiceHandler m4704a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4163c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.FeedDbCacheServiceHandler.class;
        monitor-enter(r1);
        r0 = f4163c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4706b(r0);	 Catch:{ all -> 0x0035 }
        f4163c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4163c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedDbCacheServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.FeedDbCacheServiceHandler");
    }

    private static FeedDbCacheServiceHandler m4706b(InjectorLike injectorLike) {
        return new FeedDbCacheServiceHandler(IdBasedSingletonScopeProvider.b(injectorLike, 4802), Factory.a(injectorLike));
    }

    @Inject
    public FeedDbCacheServiceHandler(Lazy<FeedDbCacheCleaner> lazy, Factory factory) {
        this.f4164a = lazy;
        this.f4165b = factory.a("feed_db_cleared");
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        if (FeedOperationTypes.m4701a(str)) {
            return m4708n(operationParams, blueServiceHandler);
        }
        if ("feed_delete_comment".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_toggle_like".equals(str)) {
            return m4707g(operationParams, blueServiceHandler);
        }
        if ("feed_toggle_page_like".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_set_notify_me".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_hide_story".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_negative_feedback_story".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_delete_story".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_edit_privacy".equals(str)) {
            return blueServiceHandler.a(operationParams);
        }
        if ("feed_clear_cache".equals(str)) {
            ((FeedDbCacheCleaner) this.f4164a.get()).clearUserData();
            this.f4165b.a();
            return blueServiceHandler.a(operationParams);
        } else if ("feed_mark_impression_logged".equals(str)) {
            return OperationResult.a;
        } else {
            if ("publish_edit_post".equals(str)) {
                return blueServiceHandler.a(operationParams);
            }
            OperationResult a;
            if ("feed_mark_survey_completed".equals(str)) {
                MarkSurveyCompletedParams markSurveyCompletedParams = (MarkSurveyCompletedParams) operationParams.c.getParcelable("markSurveyCompletedParamsKey");
                if (markSurveyCompletedParams.a == null || markSurveyCompletedParams.b == null || !Objects.equal(markSurveyCompletedParams.b, ObjectType.a(-1190325796))) {
                    a = OperationResult.a(ErrorCode.OTHER, "feed_mark_survey_completed is not supported on " + markSurveyCompletedParams.b);
                } else {
                    a = OperationResult.a;
                }
                return a;
            } else if ("feed_mark_research_poll_completed".equals(str)) {
                MarkResearchPollCompletedParams markResearchPollCompletedParams = (MarkResearchPollCompletedParams) operationParams.c.getParcelable("markResearchPollCompletedParamsKey");
                if (markResearchPollCompletedParams.a == null || markResearchPollCompletedParams.b == null || !markResearchPollCompletedParams.b.equals(ObjectType.a(-1148667268))) {
                    a = OperationResult.a(ErrorCode.OTHER, "feed_mark_research_poll_completed is not supported on " + markResearchPollCompletedParams.b);
                } else {
                    a = OperationResult.a;
                }
                return a;
            } else if ("set_hscroll_unit_visible_item_index".equals(str)) {
                SetHScrollUnitVisibleItemIndexParams setHScrollUnitVisibleItemIndexParams = (SetHScrollUnitVisibleItemIndexParams) operationParams.c.getParcelable("setHScrollUnitVisibleItemIndexKey");
                if (setHScrollUnitVisibleItemIndexParams.a == null || setHScrollUnitVisibleItemIndexParams.b == null) {
                    a = OperationResult.a(ErrorCode.API_ERROR, "set_hscroll_unit_visible_item_index is not supported on " + setHScrollUnitVisibleItemIndexParams.b);
                } else {
                    a = OperationResult.a;
                }
                return a;
            } else if ("toggle_save_place".equals(str)) {
                return blueServiceHandler.a(operationParams);
            } else {
                OperationResult a2;
                if ("update_story_saved_state".equals(str)) {
                    a2 = blueServiceHandler.a(operationParams);
                    Bundle bundle = operationParams.c;
                    if (bundle == null) {
                        a = a2;
                    } else {
                        ImmutableList immutableList = ((UpdateSavedStateParams) bundle.getParcelable("updateStorySavedStateParamsKey")).h;
                        a = (immutableList == null || immutableList.isEmpty() || !(a2.b || a2.e == ErrorCode.CONNECTION_FAILURE)) ? a2 : a2;
                    }
                    return a;
                } else if ("update_timeline_app_collection_in_newsfeed".equals(str)) {
                    a2 = blueServiceHandler.a(operationParams);
                    if (a2.b) {
                        UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams = (UpdateTimelineAppCollectionParams) operationParams.c.getParcelable("timelineAppCollectionParamsKey");
                        a = (updateTimelineAppCollectionParams == null || updateTimelineAppCollectionParams.h == null || updateTimelineAppCollectionParams.h.isEmpty() || updateTimelineAppCollectionParams.f == null || StringUtil.a(updateTimelineAppCollectionParams.a)) ? a2 : a2;
                    } else {
                        a = a2;
                    }
                    return a;
                } else if ("xOutPlaceReviewItem".equals(str)) {
                    return OperationResult.a;
                } else {
                    return blueServiceHandler.a(operationParams);
                }
            }
        }
    }

    private static OperationResult m4707g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        try {
            return blueServiceHandler.a(operationParams);
        } catch (IOException e) {
            throw e;
        }
    }

    public static OperationResult m4705a(OperationResult operationResult) {
        if (!operationResult.b) {
            return operationResult;
        }
        Object fetchFeedResult;
        FetchFeedResult fetchFeedResult2 = (FetchFeedResult) operationResult.k();
        if (fetchFeedResult2 != null) {
            fetchFeedResult = new FetchFeedResult(fetchFeedResult2.a, fetchFeedResult2.b, fetchFeedResult2.freshness, fetchFeedResult2.clientTimeMs, fetchFeedResult2.c);
        } else {
            FetchFeedResult fetchFeedResult3 = fetchFeedResult2;
        }
        return OperationResult.a(fetchFeedResult);
    }

    private OperationResult m4708n(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) operationParams.b().getParcelable("fetchFeedParams");
        boolean i = fetchFeedParams.i();
        CachePolicy e = fetchFeedParams.f().e();
        if (e == CachePolicy.NO_CACHE || e == CachePolicy.MEMORY_ONLY_CACHE) {
            return blueServiceHandler.a(operationParams);
        }
        TracerDetour.a("NFDbServiceHandler.handleFetchNewsFeed", 978269687);
        if (i) {
            operationParams = operationParams.a(new 1(this));
        }
        try {
            OperationResult a = m4705a(blueServiceHandler.a(operationParams));
            return a;
        } finally {
            TracerDetour.a(-156866764);
        }
    }
}
