package com.facebook.feedcontrollers;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEventSubscriber;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: group_associated_message_threads */
public class FeedStoryVisibilityController {
    public final Clock f11968a;
    private final FeedEventBus f11969b;
    private final StoryVisibilityEventSubscriber f11970c = new StoryVisibilitySubscriber(this);
    private final com.facebook.feed.util.event.HideEvents.ChangeRendererEventSubscriber f11971d = new ChangeRendererEventSubscriber(this);
    public LegacyFeedUnitUpdater f11972e;
    public FeedOnDataChangeListener f11973f;

    /* compiled from: group_associated_message_threads */
    class ChangeRendererEventSubscriber extends com.facebook.feed.util.event.HideEvents.ChangeRendererEventSubscriber {
        final /* synthetic */ FeedStoryVisibilityController f11966a;

        public ChangeRendererEventSubscriber(FeedStoryVisibilityController feedStoryVisibilityController) {
            this.f11966a = feedStoryVisibilityController;
        }

        public final void m14050b(FbEvent fbEvent) {
            this.f11966a.f11973f.c();
        }
    }

    /* compiled from: group_associated_message_threads */
    class StoryVisibilitySubscriber extends StoryVisibilityEventSubscriber {
        final /* synthetic */ FeedStoryVisibilityController f11967a;

        public StoryVisibilitySubscriber(FeedStoryVisibilityController feedStoryVisibilityController) {
            this.f11967a = feedStoryVisibilityController;
        }

        public final void m14052b(FbEvent fbEvent) {
            StoryVisibilityEvent storyVisibilityEvent = (StoryVisibilityEvent) fbEvent;
            if (storyVisibilityEvent.a == null) {
                HideableUnit b;
                if (storyVisibilityEvent.b != null) {
                    b = this.f11967a.f11972e.b(storyVisibilityEvent.b);
                } else {
                    b = this.f11967a.f11972e.c(storyVisibilityEvent.c);
                }
                if (b != null) {
                    m14051a(b, storyVisibilityEvent);
                    return;
                }
                return;
            }
            for (GraphQLFeedUnitEdge c : this.f11967a.f11972e.d(storyVisibilityEvent.a)) {
                FeedUnit c2 = c.c();
                if (c2 instanceof HideableUnit) {
                    m14051a((HideableUnit) c2, storyVisibilityEvent);
                }
            }
        }

        private void m14051a(HideableUnit hideableUnit, StoryVisibilityEvent storyVisibilityEvent) {
            this.f11967a.f11972e.a((HideableUnit) FeedUnitMutator.a(hideableUnit).a(this.f11967a.f11968a.a(), storyVisibilityEvent.d, storyVisibilityEvent.e).a());
            this.f11967a.f11973f.c();
        }
    }

    public static FeedStoryVisibilityController m14054b(InjectorLike injectorLike) {
        return new FeedStoryVisibilityController((Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedEventBus.a(injectorLike));
    }

    @Inject
    public FeedStoryVisibilityController(Clock clock, FeedEventBus feedEventBus) {
        this.f11968a = clock;
        this.f11969b = feedEventBus;
    }

    public final void m14056a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f11969b.a(this.f11970c);
        this.f11969b.a(this.f11971d);
        this.f11972e = legacyFeedUnitUpdater;
        this.f11973f = feedOnDataChangeListener;
    }

    public final void m14055a() {
        this.f11969b.b(this.f11970c);
        this.f11969b.b(this.f11971d);
    }

    public static FeedStoryVisibilityController m14053a(InjectorLike injectorLike) {
        return m14054b(injectorLike);
    }
}
