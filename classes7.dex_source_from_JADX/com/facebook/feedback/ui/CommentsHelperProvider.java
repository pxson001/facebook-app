package com.facebook.feedback.ui;

import android.support.v4.app.Fragment;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.environment.CommentsEnvironment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.qe.UfiFlyoutQuickExperimentController;
import com.google.common.base.Function;

/* compiled from: search_context */
public class CommentsHelperProvider extends AbstractAssistedProvider<CommentsHelper> {
    public final CommentsHelper m4974a(Fragment fragment, CommentAdapter commentAdapter, CommentsEnvironment commentsEnvironment, ScrollingProxy scrollingProxy, Function<GraphQLFeedback, Void> function) {
        return new CommentsHelper(fragment, commentAdapter, commentsEnvironment, scrollingProxy, function, (CommentListAutoscrollControllerProvider) getOnDemandAssistedProviderForStaticDi(CommentListAutoscrollControllerProvider.class), CommentPhotoPickerUtil.m4885a(this), (RootFeedbackEventSubscriberProvider) getOnDemandAssistedProviderForStaticDi(RootFeedbackEventSubscriberProvider.class), (NestedFeedbackEventSubscriberProvider) getOnDemandAssistedProviderForStaticDi(NestedFeedbackEventSubscriberProvider.class), FeedbackGraphQLSubscriber.m5080a((InjectorLike) this), FeedbackNewCommentsPillController.m5123a((InjectorLike) this), FeedbackNewCommentsLoadingController.m5116a((InjectorLike) this), FeedbackTypingPillController.m5130a((InjectorLike) this), MultipleRowsStoriesRecycleCallback.a(this), InterstitialManager.a(this), PlacePickerResultHandler.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), FeedbackMutator.a(this), UfiFlyoutQuickExperimentController.a(this), OfflineCommentCache.m5175a((InjectorLike) this), CommentsDisabledNoticeViewHelper.m4947a((InjectorLike) this), (SecureContextHelper) DefaultSecureContextHelper.a(this), InlineReplyExpansionExperimentUtil.a(this));
    }
}
