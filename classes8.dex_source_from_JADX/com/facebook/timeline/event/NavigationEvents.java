package com.facebook.timeline.event;

import android.os.ParcelUuid;

/* compiled from: map_exists */
public class NavigationEvents {

    /* compiled from: map_exists */
    public class RecentStoriesInvalidatingNavigationEvent extends TimelineStoryEvent {
        public RecentStoriesInvalidatingNavigationEvent(ParcelUuid parcelUuid) {
        }
    }

    /* compiled from: map_exists */
    public abstract class RecentStoriesInvalidatingNavigationEventSubscriber extends TimelineStoryEventSubscriber<RecentStoriesInvalidatingNavigationEvent> {
        public RecentStoriesInvalidatingNavigationEventSubscriber(ParcelUuid parcelUuid) {
        }

        public final Class<RecentStoriesInvalidatingNavigationEvent> m10921a() {
            return RecentStoriesInvalidatingNavigationEvent.class;
        }
    }
}
