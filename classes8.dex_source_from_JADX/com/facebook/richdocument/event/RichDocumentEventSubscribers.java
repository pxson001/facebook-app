package com.facebook.richdocument.event;

import com.facebook.richdocument.event.RichDocumentEvents.AutoplayCandidateRegisterEvent;
import com.facebook.richdocument.event.RichDocumentEvents.IncomingAnimationCompleteEvent;
import com.facebook.richdocument.event.RichDocumentEvents.OutgoingAnimationCompleteEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksAppendedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksErrorEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentBlocksFetchStartedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFirstRenderEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaSnappingEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaTransitionEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentPrefetchRequest;
import com.facebook.richdocument.event.RichDocumentEvents.RotatableCandidateRegisterEvent;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import com.facebook.richdocument.event.RichDocumentEvents.StartupUiTasksCompleted;

/* compiled from: profile-video */
public final class RichDocumentEventSubscribers {

    /* compiled from: profile-video */
    public abstract class RichDocumentStartupUiTasksCompletedSubscriber extends RichDocumentEventSubscriber<StartupUiTasksCompleted> {
        public final Class<StartupUiTasksCompleted> m5042a() {
            return StartupUiTasksCompleted.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentFirstRenderSubscriber extends RichDocumentEventSubscriber<RichDocumentFirstRenderEvent> {
        public final Class<RichDocumentFirstRenderEvent> m5044a() {
            return RichDocumentFirstRenderEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentOutgoingAnimationCompleteSubscriber extends RichDocumentEventSubscriber<OutgoingAnimationCompleteEvent> {
        public final Class<OutgoingAnimationCompleteEvent> m5046a() {
            return OutgoingAnimationCompleteEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class AutoplayCandidateRegisterEventSubscriber extends RichDocumentEventSubscriber<AutoplayCandidateRegisterEvent> {
        public final Class<AutoplayCandidateRegisterEvent> m5131a() {
            return AutoplayCandidateRegisterEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentBlocksAppendedSubscriber extends RichDocumentEventSubscriber<RichDocumentBlocksAppendedEvent> {
        public final Class<RichDocumentBlocksAppendedEvent> m5132a() {
            return RichDocumentBlocksAppendedEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentBlocksErrorSubscriber extends RichDocumentEventSubscriber<RichDocumentBlocksErrorEvent> {
        public final Class<RichDocumentBlocksErrorEvent> m5133a() {
            return RichDocumentBlocksErrorEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentBlocksFetchStartedSubscriber extends RichDocumentEventSubscriber<RichDocumentBlocksFetchStartedEvent> {
        public final Class<RichDocumentBlocksFetchStartedEvent> m5134a() {
            return RichDocumentBlocksFetchStartedEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentFragmentLifeCycleSubscriber extends RichDocumentEventSubscriber<RichDocumentFragmentLifeCycleEvent> {
        public final Class<RichDocumentFragmentLifeCycleEvent> m5135a() {
            return RichDocumentFragmentLifeCycleEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentIncomingAnimationCompleteSubscriber extends RichDocumentEventSubscriber<IncomingAnimationCompleteEvent> {
        public final Class<IncomingAnimationCompleteEvent> m5136a() {
            return IncomingAnimationCompleteEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentMediaSnappingEventSubscriber extends RichDocumentEventSubscriber<RichDocumentMediaSnappingEvent> {
        public final Class<RichDocumentMediaSnappingEvent> m5137a() {
            return RichDocumentMediaSnappingEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentMediaTransitionEventSubscriber extends RichDocumentEventSubscriber<RichDocumentMediaTransitionEvent> {
        public final Class<RichDocumentMediaTransitionEvent> m5138a() {
            return RichDocumentMediaTransitionEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RichDocumentPrefetchRequestEventSubscriber extends RichDocumentEventSubscriber<RichDocumentPrefetchRequest> {
        public final Class<RichDocumentPrefetchRequest> m5139a() {
            return RichDocumentPrefetchRequest.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class RotatableCandidateRegisterEventSubscriber extends RichDocumentEventSubscriber<RotatableCandidateRegisterEvent> {
        public final Class<RotatableCandidateRegisterEvent> m5140a() {
            return RotatableCandidateRegisterEvent.class;
        }
    }

    /* compiled from: profile-video */
    public abstract class ScrollValueChangedEventSubscriber extends RichDocumentEventSubscriber<ScrollValueChangedEvent> {
        public final Class<ScrollValueChangedEvent> m5141a() {
            return ScrollValueChangedEvent.class;
        }
    }
}
