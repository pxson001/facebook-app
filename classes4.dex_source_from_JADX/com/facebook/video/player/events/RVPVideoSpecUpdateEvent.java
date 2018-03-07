package com.facebook.video.player.events;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

/* compiled from: delete_pending_story */
public class RVPVideoSpecUpdateEvent extends RichVideoPlayerEvent {
    public final boolean f14065a = false;
    public final ImmutableMap<String, String> f14066b;

    public RVPVideoSpecUpdateEvent(String str, String str2) {
        this.f14066b = ImmutableBiMap.b(str, str2);
    }
}
