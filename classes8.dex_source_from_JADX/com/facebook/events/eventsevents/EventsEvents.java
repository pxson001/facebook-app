package com.facebook.events.eventsevents;

import com.facebook.events.model.Event;

/* compiled from: heading */
public class EventsEvents {

    /* compiled from: heading */
    public class EventCanceledEvent extends EventsEvent {
        public final EventStatus f11435a;

        public EventCanceledEvent(EventStatus eventStatus) {
            this.f11435a = eventStatus;
        }
    }

    /* compiled from: heading */
    public abstract class EventCanceledEventSubscriber extends EventsEventSubscriber<EventCanceledEvent> {
        public final Class<EventCanceledEvent> m13363a() {
            return EventCanceledEvent.class;
        }
    }

    /* compiled from: heading */
    public class EventCreatedEvent extends EventsEvent {
        public final String f11436a;

        public EventCreatedEvent(String str) {
            this.f11436a = str;
        }
    }

    /* compiled from: heading */
    public abstract class EventCreatedEventSubscriber extends EventsEventSubscriber<EventCreatedEvent> {
        public final Class<EventCreatedEvent> m13364a() {
            return EventCreatedEvent.class;
        }
    }

    /* compiled from: heading */
    public class EventDeletedEvent extends EventsEvent {
        public final String f11437a;

        public EventDeletedEvent(String str) {
            this.f11437a = str;
        }
    }

    /* compiled from: heading */
    public abstract class EventDeletedEventSubscriber extends EventsEventSubscriber<EventDeletedEvent> {
        public final Class<EventDeletedEvent> m13365a() {
            return EventDeletedEvent.class;
        }
    }

    /* compiled from: heading */
    public class EventIgnoredEvent extends EventsEvent {
        public final boolean f11438a;
        public final Event f11439b;

        public EventIgnoredEvent(Event event, boolean z) {
            this.f11439b = event;
            this.f11438a = z;
        }
    }

    /* compiled from: heading */
    public abstract class EventIgnoredEventSubscriber extends EventsEventSubscriber<EventIgnoredEvent> {
        public final Class<EventIgnoredEvent> m13366a() {
            return EventIgnoredEvent.class;
        }
    }

    /* compiled from: heading */
    public class EventSavingEvent extends EventsEvent {
    }

    /* compiled from: heading */
    public abstract class EventSavingEventSubscriber extends EventsEventSubscriber<EventSavingEvent> {
        public final Class<EventSavingEvent> m13367a() {
            return EventSavingEvent.class;
        }
    }

    /* compiled from: heading */
    public enum EventStatus {
        SENDING,
        SUCCESS,
        FAILURE
    }

    /* compiled from: heading */
    public class EventUnsavingEvent extends EventsEvent {
    }

    /* compiled from: heading */
    public abstract class EventUnsavingEventSubscriber extends EventsEventSubscriber<EventUnsavingEvent> {
        public final Class<EventUnsavingEvent> m13368a() {
            return EventUnsavingEvent.class;
        }
    }

    /* compiled from: heading */
    public class EventUpdatedEvent extends EventsEvent {
        public final String f11440a;

        public EventUpdatedEvent(String str) {
            this.f11440a = str;
        }
    }

    /* compiled from: heading */
    public abstract class EventUpdatedEventSubscriber extends EventsEventSubscriber<EventUpdatedEvent> {
        public final Class<EventUpdatedEvent> m13369a() {
            return EventUpdatedEvent.class;
        }
    }

    /* compiled from: heading */
    public class PostEvent extends EventsEvent {
        public final EventStatus f11441a;

        public PostEvent(EventStatus eventStatus) {
            this.f11441a = eventStatus;
        }
    }

    /* compiled from: heading */
    public abstract class PostEventSubscriber extends EventsEventSubscriber<PostEvent> {
        public final Class<PostEvent> m13370a() {
            return PostEvent.class;
        }
    }

    /* compiled from: heading */
    public class PromptDeletedEvent extends EventsEvent {
        public final String f11442a;

        public PromptDeletedEvent(String str) {
            this.f11442a = str;
        }
    }

    /* compiled from: heading */
    public abstract class PromptDeletedEventSubscriber extends EventsEventSubscriber<PromptDeletedEvent> {
        public final Class<PromptDeletedEvent> m13371a() {
            return PromptDeletedEvent.class;
        }
    }

    /* compiled from: heading */
    public class RespondingInviteEvent extends EventsEvent {
        public final EventStatus f11443a;

        public RespondingInviteEvent(EventStatus eventStatus) {
            this.f11443a = eventStatus;
        }
    }

    /* compiled from: heading */
    public abstract class RespondingInviteEventSubscriber extends EventsEventSubscriber<RespondingInviteEvent> {
        public final Class<RespondingInviteEvent> m13372a() {
            return RespondingInviteEvent.class;
        }
    }

    /* compiled from: heading */
    public class RsvpChangeEvent extends EventsEvent {
        public final EventStatus f11444a;
        public final Event f11445b;
        public final Event f11446c;

        public RsvpChangeEvent(EventStatus eventStatus, Event event, Event event2) {
            this.f11444a = eventStatus;
            this.f11445b = event;
            this.f11446c = event2;
        }
    }

    /* compiled from: heading */
    public abstract class RsvpChangeEventSubscriber extends EventsEventSubscriber<RsvpChangeEvent> {
        public final Class<RsvpChangeEvent> m13373a() {
            return RsvpChangeEvent.class;
        }
    }

    /* compiled from: heading */
    public class SendingInviteEvent extends EventsEvent {
    }

    /* compiled from: heading */
    public abstract class SendingInviteEventSubscriber extends EventsEventSubscriber<SendingInviteEvent> {
        public final Class<SendingInviteEvent> m13374a() {
            return SendingInviteEvent.class;
        }
    }

    /* compiled from: heading */
    public class SendingInviteFailedEvent extends EventsEvent {
    }

    /* compiled from: heading */
    public abstract class SendingInviteFailedEventSubscriber extends EventsEventSubscriber<SendingInviteFailedEvent> {
        public final Class<SendingInviteFailedEvent> m13375a() {
            return SendingInviteFailedEvent.class;
        }
    }
}
