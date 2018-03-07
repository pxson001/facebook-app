package com.facebook.groups.create.coverphoto.event;

import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;

/* compiled from: payments_zip_code_keyboard_switcher_tapped */
public abstract class GroupCoverPhotoUpdateEventSubscriber extends FbEventSubscriber<GroupCoverPhotoUpdateEvent> {
    public abstract void m7100a(GroupCoverPhotoUpdateEvent groupCoverPhotoUpdateEvent);

    public /* synthetic */ void m7101b(FbEvent fbEvent) {
        m7100a((GroupCoverPhotoUpdateEvent) fbEvent);
    }

    public final Class<GroupCoverPhotoUpdateEvent> m7099a() {
        return GroupCoverPhotoUpdateEvent.class;
    }
}
