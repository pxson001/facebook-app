package com.facebook.feed.flyout.renderer;

import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.inject.InjectorLike;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.ufiservices.flyout.renderer.IFlyoutRenderer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: app_attribution */
public class FeedFlyoutRenderer implements IFlyoutRenderer {
    private final DefaultFeedUnitRenderer f19203a;

    public static FeedFlyoutRenderer m22719b(InjectorLike injectorLike) {
        return new FeedFlyoutRenderer(DefaultFeedUnitRenderer.a(injectorLike));
    }

    @Inject
    public FeedFlyoutRenderer(DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
        this.f19203a = defaultFeedUnitRenderer;
    }

    public final void m22720a(View view, GraphQLProfile graphQLProfile, @Nullable HoneyClientEvent honeyClientEvent) {
        view.setOnClickListener(this.f19203a.a(view, LinkifyTargetBuilder.a(graphQLProfile), honeyClientEvent, null, null, null));
    }
}
