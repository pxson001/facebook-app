package com.facebook.video.player.events;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.video.player.plugins.PlaybackController.State;

/* compiled from: composer_edit_remove_minutiae_tag */
public class RVPCommercialBreakPlayerStateChangedEvent extends RichVideoPlayerEvent {
    public final State f19271a;

    public RVPCommercialBreakPlayerStateChangedEvent(State state) {
        this.f19271a = state;
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("%s: commercial break player state %s", super.toString(), this.f19271a);
    }
}
