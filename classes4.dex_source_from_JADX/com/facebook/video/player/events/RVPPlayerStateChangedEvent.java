package com.facebook.video.player.events;

import com.facebook.video.player.plugins.PlaybackController.State;
import javax.annotation.Nullable;

/* compiled from: delete from person_summary where ROWID IN (SELECT ROWID FROM person_summary ORDER BY last_call_time ASC LIMIT  */
public class RVPPlayerStateChangedEvent extends RichVideoPlayerEvent {
    @Nullable
    public final String f14078a;
    public final State f14079b;

    public RVPPlayerStateChangedEvent(@Nullable String str, State state) {
        this.f14078a = str;
        this.f14079b = state;
    }

    public String toString() {
        return String.format("%s: %s - %s", new Object[]{super.toString(), this.f14078a, this.f14079b});
    }
}
