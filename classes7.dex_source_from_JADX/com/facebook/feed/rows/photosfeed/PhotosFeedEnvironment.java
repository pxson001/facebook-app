package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: a_vertexColor */
public class PhotosFeedEnvironment extends BaseFeedEnvironment implements FeedEnvironment, CanLaunchMediaGallery, CanLaunchPhotosFeedFlyout, CanLikePhotosFeedImage, CanReactToPhotosFeeedImage {
    private final FeedListType f20199m;
    private final CanLaunchMediaGalleryImpl f20200n;
    private final CanLaunchPhotosFeedFlyoutImpl f20201o;
    private final CanLikePhotosFeedImageImpl f20202p;
    private final HasPrefetcherImpl f20203q;
    private final CanReactToPhotosFeedImageImpl f20204r;

    @Inject
    public PhotosFeedEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted CanLaunchMediaGalleryImpl canLaunchMediaGalleryImpl, @Assisted Runnable runnable, @Assisted Callable<FeedProps<GraphQLStory>> callable, @Assisted HasPrefetcherImpl hasPrefetcherImpl, FeedbackControllerProvider feedbackControllerProvider, FlyoutLauncher flyoutLauncher, FbErrorReporter fbErrorReporter, ReactionsMutationController reactionsMutationController) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f20199m = feedListType;
        this.f20200n = canLaunchMediaGalleryImpl;
        this.f20201o = new CanLaunchPhotosFeedFlyoutImpl(flyoutLauncher, callable, fbErrorReporter);
        this.f20202p = new CanLikePhotosFeedImageImpl(feedbackControllerProvider, callable, fbErrorReporter);
        this.f20203q = hasPrefetcherImpl;
        this.f20204r = new CanReactToPhotosFeedImageImpl(reactionsMutationController, callable, fbErrorReporter);
    }

    public final BaseFeedStoryMenuHelper m23340e() {
        return null;
    }

    public final FeedListType m23339c() {
        return this.f20199m;
    }

    public final void m23337a(ImageRequest imageRequest, CallerContext callerContext) {
        a(m(), imageRequest, callerContext);
    }

    public final void m23333a(RowKey rowKey, ImageRequest imageRequest, CallerContext callerContext) {
        this.f20203q.a(rowKey, imageRequest, callerContext);
    }

    public final void mo1483a(MediaMetadata mediaMetadata, ImageRequest imageRequest, boolean z, int i) {
        this.f20200n.mo1483a(mediaMetadata, imageRequest, z, i);
    }

    public final void mo1484a(GraphQLFeedback graphQLFeedback, View view, FlyoutLauncher$FlyoutContext flyoutLauncher$FlyoutContext) {
        this.f20201o.mo1484a(graphQLFeedback, view, flyoutLauncher$FlyoutContext);
    }

    public final void mo1485a(GraphQLFeedback graphQLFeedback) {
        this.f20202p.mo1485a(graphQLFeedback);
    }

    public final void mo1486a(GraphQLFeedback graphQLFeedback, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
        this.f20204r.mo1486a(graphQLFeedback, feedbackReaction, disposableFutureCallback);
    }
}
