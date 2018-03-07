package com.facebook.video.player.events;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.event.FbEventBus;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: delete_thread_dialog_action */
public class RichVideoPlayerEventBus extends FbEventBus<RichVideoPlayerEventSubscriber, RichVideoPlayerEvent> {
    private static final Set<Class<RVPVideoSpecUpdateEvent>> f14063a = Sets.a(new Class[]{RVPVideoSpecUpdateEvent.class});
    private DefaultAndroidThreadUtil f14064b;

    @Inject
    public RichVideoPlayerEventBus(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f14064b = defaultAndroidThreadUtil;
    }

    public final void m14878a(RichVideoPlayerEvent richVideoPlayerEvent) {
        if (this.f14064b.c()) {
            f14063a.contains(richVideoPlayerEvent.getClass());
            super.a(richVideoPlayerEvent);
            return;
        }
        this.f14064b.b(new 1(this, richVideoPlayerEvent));
    }
}
