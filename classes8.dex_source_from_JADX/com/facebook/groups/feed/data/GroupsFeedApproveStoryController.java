package com.facebook.groups.feed.data;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryApproveEvent;
import com.facebook.groups.feed.ui.GroupPendingPostsFragment.2;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=likecount */
public class GroupsFeedApproveStoryController {
    public final FeedEventBus f13980a;
    public final StoryApproveEventSubscriber f13981b = new StoryApproveEventSubscriber(this);
    public final FeedStoryMutator f13982c;
    public LegacyFeedUnitUpdater f13983d;
    public 2 f13984e;
    public boolean f13985f;

    /* compiled from: faceweb/f?href=/pages/insights/overview/%s?expandsection=likecount */
    class StoryApproveEventSubscriber extends com.facebook.groups.feed.data.GroupsFeedEvents.StoryApproveEventSubscriber {
        final /* synthetic */ GroupsFeedApproveStoryController f13979a;

        public StoryApproveEventSubscriber(GroupsFeedApproveStoryController groupsFeedApproveStoryController) {
            this.f13979a = groupsFeedApproveStoryController;
        }

        public final void m15596b(FbEvent fbEvent) {
            StoryApproveEvent storyApproveEvent = (StoryApproveEvent) fbEvent;
            if (storyApproveEvent.f14009b == this.f13979a.f13985f) {
                this.f13979a.f13983d.a((FeedUnit) this.f13979a.f13982c.a(storyApproveEvent.f14008a, StoryVisibility.GONE).a);
            } else {
                this.f13979a.f13983d.a((FeedUnit) storyApproveEvent.f14008a.a);
            }
            this.f13979a.f13984e.m15594b();
            if (!storyApproveEvent.f14010c) {
                this.f13979a.f13984e.a.e();
            }
        }
    }

    public static GroupsFeedApproveStoryController m15597b(InjectorLike injectorLike) {
        return new GroupsFeedApproveStoryController(FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike));
    }

    @Inject
    public GroupsFeedApproveStoryController(FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator) {
        this.f13980a = feedEventBus;
        this.f13982c = feedStoryMutator;
    }

    public final void m15598a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, 2 2, boolean z) {
        this.f13980a.a(this.f13981b);
        this.f13983d = legacyFeedUnitUpdater;
        this.f13984e = 2;
        this.f13985f = z;
    }
}
