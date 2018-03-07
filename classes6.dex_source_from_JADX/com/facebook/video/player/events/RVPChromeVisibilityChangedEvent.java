package com.facebook.video.player.events;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: composer_edit_remove_place_tag */
public class RVPChromeVisibilityChangedEvent extends RichVideoPlayerEvent {
    public final boolean f19270a;

    public RVPChromeVisibilityChangedEvent(boolean z) {
        this.f19270a = z;
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("%s: %s", super.toString(), Boolean.valueOf(this.f19270a));
    }
}
