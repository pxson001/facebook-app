package com.facebook.api.feedcache.memory;

import android.os.Bundle;
import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.FeedOperationTypes;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams;
import com.facebook.api.feed.HideFeedStoryMethod;
import com.facebook.api.feed.MarkImpressionsLoggedParams;
import com.facebook.api.feed.MarkResearchPollCompletedParams;
import com.facebook.api.feed.MarkSurveyCompletedParams;
import com.facebook.api.feed.NegativeFeedbackActionOnFeedMethod;
import com.facebook.api.feed.SetHScrollUnitVisibleItemIndexParams;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.EditPostParams.Builder;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionInfoType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNegativeFeedbackAction;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentConnection;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.protocol.EditFeedStoryPrivacyParams;
import com.facebook.saved.common.protocol.UpdateSavedStateParams;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: processed_logout_notification */
public class FeedMemoryCacheServiceHandler implements BlueServiceHandler$Filter {
    private static volatile FeedMemoryCacheServiceHandler f4158d;
    public final FeedUnitCache f4159a;
    public final Lazy<FeedMemoryCacheCleaner> f4160b;
    public final Lazy<FeedbackGraphQLGenerator> f4161c;

    public static com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler m4688a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4158d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler.class;
        monitor-enter(r1);
        r0 = f4158d;	 Catch:{ all -> 0x003a }
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
        r0 = m4691b(r0);	 Catch:{ all -> 0x0035 }
        f4158d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4158d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.memory.FeedMemoryCacheServiceHandler");
    }

    private static FeedMemoryCacheServiceHandler m4691b(InjectorLike injectorLike) {
        return new FeedMemoryCacheServiceHandler(FeedUnitCache.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 4803), IdBasedLazy.a(injectorLike, 995));
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        String str = operationParams.b;
        Bundle bundle;
        OperationResult a;
        OperationResult a2;
        if (FeedOperationTypes.m4701a(str)) {
            bundle = operationParams.c;
            FetchFeedParams fetchFeedParams = (FetchFeedParams) bundle.getParcelable("fetchFeedParams");
            if (fetchFeedParams == null) {
                a = OperationResult.a(ErrorCode.OTHER, "Invalid params " + bundle.keySet().toString());
            } else {
                a2 = blueServiceHandler.a(operationParams);
                if (a2.b) {
                    FetchFeedResult fetchFeedResult = (FetchFeedResult) a2.k();
                    if (!(fetchFeedResult == null || fetchFeedParams.b.e() == CachePolicy.NO_CACHE)) {
                        this.f4159a.a(fetchFeedResult);
                    }
                    a = OperationResult.a(fetchFeedResult);
                } else {
                    a = a2;
                }
            }
            return a;
        } else if ("feed_delete_comment".equals(str)) {
            operationParams.c.getParcelable("deleteCommentParams");
            return blueServiceHandler.a(operationParams);
        } else if ("feed_toggle_like".equals(str)) {
            return blueServiceHandler.a(operationParams);
        } else {
            if ("feed_toggle_page_like".equals(str)) {
                return blueServiceHandler.a(operationParams);
            }
            if ("feed_set_notify_me".equals(str)) {
                operationParams.c.getParcelable("setNotifyMeParams");
                return blueServiceHandler.a(operationParams);
            } else if ("feed_hide_story".equals(str)) {
                return m4697f(operationParams, blueServiceHandler);
            } else {
                if ("feed_negative_feedback_story".equals(str)) {
                    return m4696e(operationParams, blueServiceHandler);
                }
                if ("feed_delete_story".equals(str)) {
                    return m4698g(operationParams, blueServiceHandler);
                }
                if ("feed_edit_privacy".equals(str)) {
                    return m4699h(operationParams, blueServiceHandler);
                }
                if ("feed_clear_cache".equals(str)) {
                    ((FeedMemoryCacheCleaner) this.f4160b.get()).clearUserData();
                    return blueServiceHandler.a(operationParams);
                } else if ("feed_trim_cache".equals(str)) {
                    this.f4159a.a(operationParams.c.getStringArrayList("trimCacheParamIdsToKeep"));
                    return OperationResult.a;
                } else if ("feed_mark_impression_logged".equals(str)) {
                    MarkImpressionsLoggedParams markImpressionsLoggedParams = (MarkImpressionsLoggedParams) operationParams.c.getParcelable("markImpressionLoggedParams");
                    a2 = blueServiceHandler.a(operationParams);
                    if (a2.b) {
                        this.f4159a.e(markImpressionsLoggedParams.f4143a);
                        a = a2;
                    } else {
                        a = a2;
                    }
                    return a;
                } else if ("publish_edit_post".equals(str)) {
                    bundle = operationParams.c;
                    EditPostParams editPostParams = (EditPostParams) bundle.getParcelable("publishEditPostParamsKey");
                    r5 = "publishEditPostParamsKey";
                    bundle.putParcelable(r5, new Builder(editPostParams).a(this.f4159a.c(editPostParams.storyId)).a());
                    r4 = blueServiceHandler.a(operationParams);
                    if (r4.b && editPostParams.storyId != null) {
                        if (editPostParams.productItemAttachment != null) {
                            ((FeedbackGraphQLGenerator) this.f4161c.get()).a(editPostParams.storyId, editPostParams.productItemAttachment);
                        } else {
                            ((FeedbackGraphQLGenerator) this.f4161c.get()).a(editPostParams.storyId, (GraphQLStory) r4.h());
                        }
                    }
                    return r4;
                } else if ("feed_mark_survey_completed".equals(str)) {
                    MarkSurveyCompletedParams markSurveyCompletedParams = (MarkSurveyCompletedParams) operationParams.c.getParcelable("markSurveyCompletedParamsKey");
                    a2 = blueServiceHandler.a(operationParams);
                    if (a2.b && markSurveyCompletedParams.a != null) {
                        this.f4159a.f(markSurveyCompletedParams.a);
                    }
                    return a2;
                } else if ("feed_mark_research_poll_completed".equals(str)) {
                    MarkResearchPollCompletedParams markResearchPollCompletedParams = (MarkResearchPollCompletedParams) operationParams.c.getParcelable("markResearchPollCompletedParamsKey");
                    a2 = blueServiceHandler.a(operationParams);
                    if (a2.b && markResearchPollCompletedParams.a != null) {
                        this.f4159a.f(markResearchPollCompletedParams.a);
                    }
                    return a2;
                } else if ("set_hscroll_unit_visible_item_index".equals(str)) {
                    SetHScrollUnitVisibleItemIndexParams setHScrollUnitVisibleItemIndexParams = (SetHScrollUnitVisibleItemIndexParams) operationParams.c.getParcelable("setHScrollUnitVisibleItemIndexKey");
                    a2 = blueServiceHandler.a(operationParams);
                    if (a2.b && setHScrollUnitVisibleItemIndexParams.a != null) {
                        this.f4159a.a(setHScrollUnitVisibleItemIndexParams.a, setHScrollUnitVisibleItemIndexParams.c.intValue());
                    }
                    return a2;
                } else if ("toggle_save_place".equals(str)) {
                    return m4695d(operationParams, blueServiceHandler);
                } else {
                    if ("update_story_saved_state".equals(str)) {
                        return m4692b(operationParams, blueServiceHandler);
                    }
                    if ("update_timeline_app_collection_in_newsfeed".equals(str)) {
                        return m4694c(operationParams, blueServiceHandler);
                    }
                    if ("feed_fetch_followup_feed_unit".equals(str)) {
                        FeedUnit feedUnit;
                        r4 = blueServiceHandler.a(operationParams);
                        r5 = ((FetchFollowUpFeedUnitParams) operationParams.c.getParcelable("fetchFollowUpFeedUnitParamsKey")).c;
                        if (r4.b) {
                            feedUnit = (FeedUnit) r4.k();
                        } else {
                            feedUnit = null;
                        }
                        if (!(feedUnit == null || r5 == null)) {
                            ((FeedbackGraphQLGenerator) this.f4161c.get()).a(r5, feedUnit);
                        }
                        return r4;
                    } else if (!"xOutPlaceReviewItem".equals(str)) {
                        return blueServiceHandler.a(operationParams);
                    } else {
                        XOutPlaceReviewItemParams xOutPlaceReviewItemParams = (XOutPlaceReviewItemParams) operationParams.c.getParcelable("xOutPlaceReviewItemParamKey");
                        this.f4159a.a(xOutPlaceReviewItemParams.a, xOutPlaceReviewItemParams.c);
                        return blueServiceHandler.a(operationParams);
                    }
                }
            }
        }
    }

    private OperationResult m4692b(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Bundle bundle = operationParams.c;
        if (bundle == null) {
            return blueServiceHandler.a(operationParams);
        }
        UpdateSavedStateParams updateSavedStateParams = (UpdateSavedStateParams) bundle.getParcelable("updateStorySavedStateParamsKey");
        ImmutableList immutableList = updateSavedStateParams.h;
        if (immutableList == null || immutableList.isEmpty()) {
            return blueServiceHandler.a(operationParams);
        }
        GraphQLSavedState graphQLSavedState;
        GraphQLSavedState graphQLSavedState2;
        if (updateSavedStateParams.e == SavedAction.SAVE) {
            graphQLSavedState = GraphQLSavedState.SAVED;
        } else {
            graphQLSavedState = GraphQLSavedState.NOT_SAVED;
        }
        if (updateSavedStateParams.e == SavedAction.SAVE) {
            graphQLSavedState2 = GraphQLSavedState.NOT_SAVED;
        } else {
            graphQLSavedState2 = GraphQLSavedState.SAVED;
        }
        m4689a(updateSavedStateParams, graphQLSavedState);
        OperationResult a = blueServiceHandler.a(operationParams);
        if (!(a.b || a.e == ErrorCode.CONNECTION_FAILURE)) {
            m4689a(updateSavedStateParams, graphQLSavedState2);
        }
        return a;
    }

    private OperationResult m4698g(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Bundle bundle = operationParams.c;
        Params params = (Params) bundle.getParcelable("deleteStoryParams");
        if (params.c != null) {
            bundle.putParcelable("deleteStoryParams", new Params(params.a, this.f4159a.c(params.c), params.c, params.d));
        }
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a.b) {
            String str = params.c;
            if (str != null) {
                ((FeedbackGraphQLGenerator) this.f4161c.get()).a(str, StoryVisibility.GONE, 0);
            }
        }
        return a;
    }

    private OperationResult m4699h(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        EditFeedStoryPrivacyParams editFeedStoryPrivacyParams = (EditFeedStoryPrivacyParams) operationParams.c.getParcelable("editPrivacyFeedStoryParams");
        String str = editFeedStoryPrivacyParams.a != null ? editFeedStoryPrivacyParams.a : editFeedStoryPrivacyParams.c != null ? editFeedStoryPrivacyParams.c : editFeedStoryPrivacyParams.b != null ? editFeedStoryPrivacyParams.b : null;
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a.b) {
            FeedbackGraphQLGenerator feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) this.f4161c.get();
            GraphQLPrivacyOptionsContentEdge.Builder builder = new GraphQLPrivacyOptionsContentEdge.Builder();
            GraphQLPrivacyOption graphQLPrivacyOption = editFeedStoryPrivacyParams.d;
            builder.d = true;
            GraphQLPrivacyOptionsContentEdge.Builder builder2 = builder;
            builder2.e = graphQLPrivacyOption;
            builder2 = builder2;
            builder2.f = GraphQLPrivacyOptionInfoType.SELECTED;
            GraphQLPrivacyOptionsContentEdge a2 = builder2.a();
            GraphQLPrivacyOptionsContentConnection.Builder builder3 = new GraphQLPrivacyOptionsContentConnection.Builder();
            builder3.d = ImmutableList.of(a2);
            GraphQLPrivacyOptionsContentConnection a3 = builder3.a();
            GraphQLPrivacyScope.Builder builder4 = new GraphQLPrivacyScope.Builder();
            builder4.d = true;
            builder4 = builder4.c(editFeedStoryPrivacyParams.d.l().d());
            builder4.i = editFeedStoryPrivacyParams.d.d();
            builder4 = builder4;
            builder4.k = a3;
            feedbackGraphQLGenerator.a(str, builder4.a());
        }
        return a;
    }

    @Inject
    public FeedMemoryCacheServiceHandler(FeedUnitCache feedUnitCache, Lazy<FeedMemoryCacheCleaner> lazy, Lazy<FeedbackGraphQLGenerator> lazy2) {
        this.f4159a = feedUnitCache;
        this.f4160b = lazy;
        this.f4161c = lazy2;
    }

    private void m4689a(UpdateSavedStateParams updateSavedStateParams, GraphQLSavedState graphQLSavedState) {
        if (updateSavedStateParams.h != null) {
            ImmutableList immutableList = updateSavedStateParams.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                immutableList.get(i);
                if (updateSavedStateParams.b.isPresent()) {
                    ((FeedbackGraphQLGenerator) this.f4161c.get()).a((String) updateSavedStateParams.b.get(), graphQLSavedState);
                }
                if (!StringUtil.a((CharSequence) updateSavedStateParams.a.get())) {
                    ((FeedbackGraphQLGenerator) this.f4161c.get()).b((String) updateSavedStateParams.a.get(), graphQLSavedState);
                }
            }
        }
    }

    private OperationResult m4694c(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams = (UpdateTimelineAppCollectionParams) operationParams.b().getParcelable("timelineAppCollectionParamsKey");
        GraphQLSavedState graphQLSavedState = updateTimelineAppCollectionParams.c() == Action.ADD ? GraphQLSavedState.SAVED : GraphQLSavedState.NOT_SAVED;
        GraphQLSavedState graphQLSavedState2 = updateTimelineAppCollectionParams.c() == Action.ADD ? GraphQLSavedState.NOT_SAVED : GraphQLSavedState.SAVED;
        try {
            m4690a(updateTimelineAppCollectionParams, graphQLSavedState);
            OperationResult a = blueServiceHandler.a(operationParams);
            if (!a.b()) {
                m4690a(updateTimelineAppCollectionParams, graphQLSavedState2);
            }
            return a;
        } catch (Exception e) {
            m4690a(updateTimelineAppCollectionParams, graphQLSavedState2);
            throw e;
        }
    }

    private void m4690a(UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams, GraphQLSavedState graphQLSavedState) {
        if (updateTimelineAppCollectionParams != null && updateTimelineAppCollectionParams.h != null && !updateTimelineAppCollectionParams.h.isEmpty() && updateTimelineAppCollectionParams.f != null) {
            if (updateTimelineAppCollectionParams.f.g() == -1917069369) {
                if (updateTimelineAppCollectionParams.h != null) {
                    ImmutableList immutableList = updateTimelineAppCollectionParams.h;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        immutableList.get(i);
                        if (!StringUtil.a(updateTimelineAppCollectionParams.b)) {
                            ((FeedbackGraphQLGenerator) this.f4161c.get()).a(updateTimelineAppCollectionParams.b, graphQLSavedState);
                        }
                    }
                }
                return;
            }
            m4693b(updateTimelineAppCollectionParams, graphQLSavedState);
        }
    }

    private void m4693b(@Nonnull UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams, GraphQLSavedState graphQLSavedState) {
        if (updateTimelineAppCollectionParams.h != null) {
            ImmutableList immutableList = updateTimelineAppCollectionParams.h;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                String str = (String) immutableList.get(i);
                if (!StringUtil.a(new CharSequence[]{updateTimelineAppCollectionParams.i, updateTimelineAppCollectionParams.a})) {
                    ((FeedbackGraphQLGenerator) this.f4161c.get()).a(str, updateTimelineAppCollectionParams.i, updateTimelineAppCollectionParams.a, updateTimelineAppCollectionParams.c);
                }
                if (!StringUtil.a(updateTimelineAppCollectionParams.b)) {
                    ((FeedbackGraphQLGenerator) this.f4161c.get()).a(updateTimelineAppCollectionParams.b, graphQLSavedState);
                }
                if (!StringUtil.a(updateTimelineAppCollectionParams.l)) {
                    ((FeedbackGraphQLGenerator) this.f4161c.get()).b(updateTimelineAppCollectionParams.l, graphQLSavedState);
                }
            }
        }
    }

    private OperationResult m4695d(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        ToggleSaveParams toggleSaveParams = (ToggleSaveParams) operationParams.b().getParcelable("togglePlaceParamsKey");
        FeedbackGraphQLGenerator feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) this.f4161c.get();
        String str = toggleSaveParams.a;
        feedbackGraphQLGenerator.a(toggleSaveParams.b, toggleSaveParams.e ? GraphQLSavedState.SAVED : GraphQLSavedState.NOT_SAVED);
        try {
            OperationResult a = blueServiceHandler.a(operationParams);
            if (!a.b()) {
                feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) this.f4161c.get();
                str = toggleSaveParams.a;
                feedbackGraphQLGenerator.a(toggleSaveParams.b, toggleSaveParams.e ? GraphQLSavedState.NOT_SAVED : GraphQLSavedState.SAVED);
            }
            return a;
        } catch (Exception e) {
            Exception exception = e;
            feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) this.f4161c.get();
            String str2 = toggleSaveParams.a;
            feedbackGraphQLGenerator.a(toggleSaveParams.b, toggleSaveParams.e ? GraphQLSavedState.NOT_SAVED : GraphQLSavedState.SAVED);
            throw exception;
        }
    }

    private OperationResult m4696e(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction = null;
        int i = 0;
        NegativeFeedbackActionOnFeedMethod.Params params = (NegativeFeedbackActionOnFeedMethod.Params) operationParams.c.getParcelable("negativeFeedbackActionOnFeedParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a.b && params.e != null) {
            FeedbackGraphQLGenerator feedbackGraphQLGenerator;
            boolean z = params.i;
            if (!params.g.b().equals(GraphQLNegativeFeedbackActionType.DONT_LIKE)) {
                ((FeedbackGraphQLGenerator) this.f4161c.get()).a(params.e, z ? StoryVisibility.VISIBLE : StoryVisibility.HIDDEN, z ? 0 : params.f);
                if (params.c != null) {
                    feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) this.f4161c.get();
                    String str = params.c;
                    StoryVisibility storyVisibility = z ? StoryVisibility.VISIBLE : StoryVisibility.HIDDEN;
                    if (!z) {
                        i = params.f;
                    }
                    feedbackGraphQLGenerator.a(str, storyVisibility, i);
                }
            }
            ((FeedbackGraphQLGenerator) this.f4161c.get()).a(params.e, z ? null : params.g);
            if (params.c != null) {
                feedbackGraphQLGenerator = (FeedbackGraphQLGenerator) this.f4161c.get();
                String str2 = params.c;
                if (!z) {
                    graphQLNegativeFeedbackAction = params.g;
                }
                feedbackGraphQLGenerator.a(str2, graphQLNegativeFeedbackAction);
            }
        }
        return a;
    }

    private OperationResult m4697f(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        HideFeedStoryMethod.Params params = (HideFeedStoryMethod.Params) operationParams.c.getParcelable("hideFeedStoryParams");
        OperationResult a = blueServiceHandler.a(operationParams);
        if (a.b && params.f != null) {
            StoryVisibility storyVisibility = params.d;
            ((FeedbackGraphQLGenerator) this.f4161c.get()).a(params.f, storyVisibility, params.g);
            if (params.h != null) {
                ((FeedbackGraphQLGenerator) this.f4161c.get()).a(params.h, storyVisibility, params.g);
            }
            if (storyVisibility.isHiddenOrVisible()) {
                ((FeedbackGraphQLGenerator) this.f4161c.get()).a(params.f, null);
                if (params.h != null) {
                    ((FeedbackGraphQLGenerator) this.f4161c.get()).a(params.h, null);
                }
            }
        }
        return a;
    }
}
