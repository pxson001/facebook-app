package com.facebook.groups.feed.data;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryIgnoreReportEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/pages/edit/general/delete_confirm/%s/?ref=bookmark */
public class GroupsFeedIgnoreReportedStoryController {
    private final FeedEventBus f14027a;
    private final StoryIgnoreReportEventSubscriber f14028b = new StoryIgnoreReportEventSubscriber(this);
    public final FeedStoryMutator f14029c;
    public LegacyFeedUnitUpdater f14030d;
    public GroupsIgnoreReportedDataChangeListener f14031e;
    public boolean f14032f;

    /* compiled from: faceweb/f?href=/pages/edit/general/delete_confirm/%s/?ref=bookmark */
    public interface GroupsIgnoreReportedDataChangeListener extends GroupsOnDataChangeListener {
    }

    /* compiled from: faceweb/f?href=/pages/edit/general/delete_confirm/%s/?ref=bookmark */
    class StoryIgnoreReportEventSubscriber extends com.facebook.groups.feed.data.GroupsFeedEvents.StoryIgnoreReportEventSubscriber {
        final /* synthetic */ GroupsFeedIgnoreReportedStoryController f14026a;

        public StoryIgnoreReportEventSubscriber(GroupsFeedIgnoreReportedStoryController groupsFeedIgnoreReportedStoryController) {
            this.f14026a = groupsFeedIgnoreReportedStoryController;
        }

        public final void m15612b(FbEvent fbEvent) {
            StoryIgnoreReportEvent storyIgnoreReportEvent = (StoryIgnoreReportEvent) fbEvent;
            if (storyIgnoreReportEvent.f14012b == this.f14026a.f14032f) {
                this.f14026a.f14030d.a((FeedUnit) this.f14026a.f14029c.a(storyIgnoreReportEvent.f14011a, StoryVisibility.GONE).a);
            } else {
                this.f14026a.f14030d.a((FeedUnit) storyIgnoreReportEvent.f14011a.a);
            }
            this.f14026a.f14031e.m15594b();
        }
    }

    private static GroupsFeedIgnoreReportedStoryController m15613b(InjectorLike injectorLike) {
        return new GroupsFeedIgnoreReportedStoryController(FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike));
    }

    @Inject
    public GroupsFeedIgnoreReportedStoryController(FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator) {
        this.f14027a = feedEventBus;
        this.f14029c = feedStoryMutator;
    }
}
