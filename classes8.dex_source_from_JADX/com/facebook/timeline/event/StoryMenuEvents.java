package com.facebook.timeline.event;

import android.os.ParcelUuid;
import android.view.View;

/* compiled from: major */
public class StoryMenuEvents {

    /* compiled from: major */
    public class BanUserClickedEvent extends TimelineStoryEvent {
        public final long f9141a;
        public final long f9142b;
        public final String f9143c;
        public final View f9144d;

        public BanUserClickedEvent(ParcelUuid parcelUuid, long j, long j2, String str, View view) {
            this.f9141a = j;
            this.f9142b = j2;
            this.f9143c = str;
            this.f9144d = view;
        }
    }

    /* compiled from: major */
    public abstract class BanUserClickedEventSubscriber extends TimelineStoryEventSubscriber<BanUserClickedEvent> {
        public BanUserClickedEventSubscriber(ParcelUuid parcelUuid) {
        }

        public final Class<BanUserClickedEvent> m10922a() {
            return BanUserClickedEvent.class;
        }
    }

    /* compiled from: major */
    public class DeleteStoryClickedEvent extends TimelineStoryEvent {
        public final String f9145a;
        public final String f9146b;
        public final String f9147c;
        public final View f9148d;

        public DeleteStoryClickedEvent(ParcelUuid parcelUuid, String str, String str2, String str3, View view) {
            this.f9145a = str;
            this.f9146b = str2;
            this.f9147c = str3;
            this.f9148d = view;
        }
    }

    /* compiled from: major */
    public abstract class DeleteStoryClickedEventSubscriber extends TimelineStoryEventSubscriber<DeleteStoryClickedEvent> {
        public DeleteStoryClickedEventSubscriber(ParcelUuid parcelUuid) {
        }

        public final Class<DeleteStoryClickedEvent> m10923a() {
            return DeleteStoryClickedEvent.class;
        }
    }

    /* compiled from: major */
    public class EditStoryEvent extends TimelineStoryEvent {
        public final String f9149a;

        public EditStoryEvent(ParcelUuid parcelUuid, String str) {
            this.f9149a = str;
        }
    }

    /* compiled from: major */
    public abstract class EditStoryEventSubscriber extends TimelineStoryEventSubscriber<EditStoryEvent> {
        public EditStoryEventSubscriber(ParcelUuid parcelUuid) {
        }

        public final Class<EditStoryEvent> m10924a() {
            return EditStoryEvent.class;
        }
    }
}
