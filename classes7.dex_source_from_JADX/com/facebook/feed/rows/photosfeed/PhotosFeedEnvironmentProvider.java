package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImpl;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.Callable;

/* compiled from: a_vertex */
public class PhotosFeedEnvironmentProvider extends AbstractAssistedProvider<PhotosFeedEnvironment> {
    public final PhotosFeedEnvironment m23341a(Context context, FeedListType feedListType, CanLaunchMediaGalleryImpl canLaunchMediaGalleryImpl, Runnable runnable, Callable<FeedProps<GraphQLStory>> callable, HasPrefetcherImpl hasPrefetcherImpl) {
        return new PhotosFeedEnvironment(context, feedListType, canLaunchMediaGalleryImpl, runnable, callable, hasPrefetcherImpl, (FeedbackControllerProvider) getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), FlyoutLauncher.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ReactionsMutationController.a(this));
    }
}
