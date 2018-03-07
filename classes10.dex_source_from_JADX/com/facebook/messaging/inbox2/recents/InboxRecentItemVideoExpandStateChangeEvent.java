package com.facebook.messaging.inbox2.recents;

import com.facebook.video.player.events.RichVideoPlayerEvent;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: selfupdate_start_fetching_from_oxygen */
class InboxRecentItemVideoExpandStateChangeEvent extends RichVideoPlayerEvent {
    public final boolean f2885a;

    public InboxRecentItemVideoExpandStateChangeEvent(boolean z) {
        this.f2885a = z;
    }
}
