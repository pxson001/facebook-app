package com.facebook.timeline.event;

/* compiled from: match_parent */
public class CoverPhotoEditEvents {

    /* compiled from: match_parent */
    public abstract class EditCoverPhotoLoadedEventSubscriber extends CoverPhotoEditEventSubscriber<EditCoverPhotoLoadedEvent> {
        public final Class<EditCoverPhotoLoadedEvent> m10901a() {
            return EditCoverPhotoLoadedEvent.class;
        }
    }

    /* compiled from: match_parent */
    public class EditCoverPhotoLoadedEvent extends CoverPhotoEditEvent {
        public final boolean f9140a;

        public EditCoverPhotoLoadedEvent(boolean z) {
            this.f9140a = z;
        }
    }
}
