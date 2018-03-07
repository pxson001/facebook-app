package com.facebook.reaction;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSessionManager.ReactionRequestTrackerCallback;
import com.facebook.reaction.event.ReactionEvent;
import com.facebook.reaction.event.ReactionEventBus;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidCacheResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidCacheResponseSubscriber;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidResponseEvent;
import com.facebook.reaction.event.ReactionFetchEvents.InvalidResponseSubscriber;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionCacheResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionCacheResultSubscriber;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionEmptyRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionEmptyRequestSubscriber;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionRequestEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionResultEvent;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionResultSubscriber;
import com.facebook.reaction.event.ReactionFetchEvents.ReactionSentSubscriber;
import com.facebook.reaction.event.ReactionFetchEvents.RequestNonCancellationFailureEvent;
import com.facebook.reaction.event.ReactionFetchEvents.RequestNonCancellationFailureSubscriber;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: button_style */
public class ReactionRequestTracker {
    public final ImmutableList<? extends FbEventSubscriber<? extends ReactionEvent>> f18653a = ImmutableList.of(new C20621(this), new C20632(this), new C20643(this), new C20654(this), new C20665(this), new C20676(this), new C20687(this));
    public final ReactionEventBus f18654b;
    public final ReactionRequestTrackerCallback f18655c;

    /* compiled from: button_style */
    class C20621 extends RequestNonCancellationFailureSubscriber {
        final /* synthetic */ ReactionRequestTracker f18646a;

        C20621(ReactionRequestTracker reactionRequestTracker) {
            this.f18646a = reactionRequestTracker;
        }

        public final void m22532b(FbEvent fbEvent) {
            this.f18646a.f18655c.m22588a((RequestNonCancellationFailureEvent) fbEvent);
        }
    }

    /* compiled from: button_style */
    class C20632 extends InvalidResponseSubscriber {
        final /* synthetic */ ReactionRequestTracker f18647a;

        C20632(ReactionRequestTracker reactionRequestTracker) {
            this.f18647a = reactionRequestTracker;
        }

        public final void m22534b(FbEvent fbEvent) {
            this.f18647a.f18655c.m22588a((InvalidResponseEvent) fbEvent);
        }
    }

    /* compiled from: button_style */
    class C20643 extends InvalidCacheResponseSubscriber {
        final /* synthetic */ ReactionRequestTracker f18648a;

        C20643(ReactionRequestTracker reactionRequestTracker) {
            this.f18648a = reactionRequestTracker;
        }

        public final void m22536b(FbEvent fbEvent) {
            this.f18648a.f18655c.m22588a((InvalidCacheResponseEvent) fbEvent);
        }
    }

    /* compiled from: button_style */
    class C20654 extends ReactionEmptyRequestSubscriber {
        final /* synthetic */ ReactionRequestTracker f18649a;

        C20654(ReactionRequestTracker reactionRequestTracker) {
            this.f18649a = reactionRequestTracker;
        }

        public final void m22538b(FbEvent fbEvent) {
            this.f18649a.f18655c.m22588a((ReactionEmptyRequestEvent) fbEvent);
        }
    }

    /* compiled from: button_style */
    class C20665 extends ReactionResultSubscriber {
        final /* synthetic */ ReactionRequestTracker f18650a;

        C20665(ReactionRequestTracker reactionRequestTracker) {
            this.f18650a = reactionRequestTracker;
        }

        public final void m22540b(FbEvent fbEvent) {
            this.f18650a.f18655c.m22588a((ReactionResultEvent) fbEvent);
        }
    }

    /* compiled from: button_style */
    class C20676 extends ReactionCacheResultSubscriber {
        final /* synthetic */ ReactionRequestTracker f18651a;

        C20676(ReactionRequestTracker reactionRequestTracker) {
            this.f18651a = reactionRequestTracker;
        }

        public final void m22542b(FbEvent fbEvent) {
            this.f18651a.f18655c.m22588a((ReactionCacheResultEvent) fbEvent);
        }
    }

    /* compiled from: button_style */
    class C20687 extends ReactionSentSubscriber {
        final /* synthetic */ ReactionRequestTracker f18652a;

        C20687(ReactionRequestTracker reactionRequestTracker) {
            this.f18652a = reactionRequestTracker;
        }

        public final void m22544b(FbEvent fbEvent) {
            this.f18652a.f18655c.m22588a((ReactionRequestEvent) fbEvent);
        }
    }

    @Inject
    public ReactionRequestTracker(@Assisted ReactionRequestTrackerCallback reactionRequestTrackerCallback, ReactionEventBus reactionEventBus) {
        this.f18655c = reactionRequestTrackerCallback;
        this.f18654b = reactionEventBus;
    }
}
