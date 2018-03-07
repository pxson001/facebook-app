package com.facebook.feed.rows.photosfeed;

import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import java.util.concurrent.Callable;

/* compiled from: activity_picker_background_fetch_success */
public class CanLaunchPhotosFeedFlyoutImpl implements CanLaunchPhotosFeedFlyout {
    private static final String f20006a = CanLaunchPhotosFeedFlyoutImpl.class.getSimpleName();
    private FlyoutLauncher f20007b;
    private Callable<FeedProps<GraphQLStory>> f20008c;
    private AbstractFbErrorReporter f20009d;

    public CanLaunchPhotosFeedFlyoutImpl(FlyoutLauncher flyoutLauncher, Callable<FeedProps<GraphQLStory>> callable, FbErrorReporter fbErrorReporter) {
        this.f20007b = flyoutLauncher;
        this.f20008c = callable;
        this.f20009d = fbErrorReporter;
    }

    public final void mo1484a(GraphQLFeedback graphQLFeedback, View view, FlyoutLauncher$FlyoutContext flyoutLauncher$FlyoutContext) {
        try {
            this.f20007b.a((FeedProps) this.f20008c.call(), graphQLFeedback, view, flyoutLauncher$FlyoutContext, StoryRenderContext.PHOTOS_FEED);
        } catch (Throwable e) {
            this.f20009d.b(f20006a, "mStoryCallable threw an exception", e);
        }
    }
}
