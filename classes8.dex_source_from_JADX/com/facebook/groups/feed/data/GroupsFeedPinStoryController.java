package com.facebook.groups.feed.data;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.groups.feed.data.GroupsFeedEvents.StoryPinEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: faceweb/f?href=/notifications.php?targetID=%s */
public class GroupsFeedPinStoryController {
    private final FeedEventBus f14034a;
    private final com.facebook.groups.feed.data.GroupsFeedEvents.StoryPinEventSubscriber f14035b = new StoryPinEventSubscriber(this);
    public final FeedStoryMutator f14036c;
    public final ControllerMutationGatekeepers f14037d;
    public LegacyFeedUnitUpdater f14038e;
    public GroupsPinDataChangeListener f14039f;
    public PinState f14040g;

    /* compiled from: faceweb/f?href=/notifications.php?targetID=%s */
    public interface GroupsPinDataChangeListener extends GroupsOnDataChangeListener {
        void m15622a();
    }

    /* compiled from: faceweb/f?href=/notifications.php?targetID=%s */
    class StoryPinEventSubscriber extends com.facebook.groups.feed.data.GroupsFeedEvents.StoryPinEventSubscriber {
        final /* synthetic */ GroupsFeedPinStoryController f14033a;

        public StoryPinEventSubscriber(GroupsFeedPinStoryController groupsFeedPinStoryController) {
            this.f14033a = groupsFeedPinStoryController;
        }

        public final void m15623b(FbEvent fbEvent) {
            StoryPinEvent storyPinEvent = (StoryPinEvent) fbEvent;
            if (this.f14033a.f14037d.b()) {
                StoryVisibility storyVisibility;
                if (storyPinEvent.f14015b == this.f14033a.f14040g) {
                    storyVisibility = StoryVisibility.GONE;
                } else {
                    storyVisibility = StoryVisibility.VISIBLE;
                }
                this.f14033a.f14038e.a((FeedUnit) this.f14033a.f14036c.a(storyPinEvent.f14014a, storyVisibility).a);
                this.f14033a.f14039f.m15594b();
            }
            if (!storyPinEvent.f14016c) {
                this.f14033a.f14039f.m15622a();
            }
        }
    }

    public static GroupsFeedPinStoryController m15625b(InjectorLike injectorLike) {
        return new GroupsFeedPinStoryController(FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike), ControllerMutationGatekeepers.b(injectorLike));
    }

    @Inject
    public GroupsFeedPinStoryController(FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f14034a = feedEventBus;
        this.f14036c = feedStoryMutator;
        this.f14037d = controllerMutationGatekeepers;
    }

    public final void m15627a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, GroupsPinDataChangeListener groupsPinDataChangeListener, PinState pinState) {
        this.f14034a.a(this.f14035b);
        this.f14038e = legacyFeedUnitUpdater;
        this.f14039f = groupsPinDataChangeListener;
        this.f14040g = pinState;
    }

    public static GroupsFeedPinStoryController m15624a(InjectorLike injectorLike) {
        return m15625b(injectorLike);
    }

    public final void m15626a() {
        this.f14034a.b(this.f14035b);
    }
}
