package com.facebook.feed.ui;

import android.content.res.Resources;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher.FlyoutContext;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.clickwithpositionlistener.ClickWithPositionListener;
import javax.inject.Inject;

/* compiled from: group_feed_pinned_type */
public class FeedStoryMessageFlyoutClickWithPositionListener implements ClickWithPositionListener {
    public final FlyoutLauncher f21740a;
    private final FeedStoryMessageFlyoutClickChecker f21741b;
    private final Resources f21742c;
    public FeedProps<GraphQLStory> f21743d;
    public GraphQLComment f21744e;
    public StoryRenderContext f21745f;

    public static FeedStoryMessageFlyoutClickWithPositionListener m29431b(InjectorLike injectorLike) {
        return new FeedStoryMessageFlyoutClickWithPositionListener(FlyoutLauncher.m28357a(injectorLike), new FeedStoryMessageFlyoutClickChecker(), ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public FeedStoryMessageFlyoutClickWithPositionListener(FlyoutLauncher flyoutLauncher, FeedStoryMessageFlyoutClickChecker feedStoryMessageFlyoutClickChecker, Resources resources) {
        this.f21740a = flyoutLauncher;
        this.f21741b = feedStoryMessageFlyoutClickChecker;
        this.f21742c = resources;
    }

    public final void m29433a(FeedProps<GraphQLStory> feedProps, StoryRenderContext storyRenderContext) {
        m29434a((FeedProps) feedProps, null, storyRenderContext);
    }

    public final void m29434a(FeedProps<GraphQLStory> feedProps, GraphQLComment graphQLComment, StoryRenderContext storyRenderContext) {
        this.f21743d = feedProps;
        this.f21744e = graphQLComment;
        this.f21745f = storyRenderContext;
    }

    public final void mo3186a(View view, float f, float f2) {
        GraphQLStory graphQLStory = (GraphQLStory) this.f21743d.f13444a;
        if (graphQLStory.mo2890l() == null) {
            return;
        }
        if (graphQLStory.mo2507g() != null || graphQLStory.m22350c() != null) {
            ClickableSpan a = this.f21741b.m29437a(view, f, f2, this.f21742c.getDimension(2131429129));
            if (a == null) {
                this.f21740a.m28365a(this.f21743d, this.f21744e, view, FlyoutContext.MESSAGE, this.f21745f);
            } else if (a != FeedStoryMessageFlyoutClickChecker.f21746a) {
                a.onClick(view);
            }
        }
    }
}
