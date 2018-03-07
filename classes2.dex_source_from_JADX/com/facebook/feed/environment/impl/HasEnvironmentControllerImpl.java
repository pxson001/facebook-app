package com.facebook.feed.environment.impl;

import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.HasEnvironmentController;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: news_feed_scroll */
public class HasEnvironmentControllerImpl implements HasEnvironmentController {
    EnvironmentController f12293a;

    public static HasEnvironmentControllerImpl m18323a(InjectorLike injectorLike) {
        return new HasEnvironmentControllerImpl(FeedEnvironmentController.m18325a(injectorLike));
    }

    @Inject
    public HasEnvironmentControllerImpl(FeedEnvironmentController feedEnvironmentController) {
        this.f12293a = feedEnvironmentController;
    }

    public final EnvironmentController mo2441b() {
        return this.f12293a;
    }
}
