package com.facebook.video.engine.texview.exo;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.PlayPosition;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$12 implements Runnable {
    final /* synthetic */ boolean f18877a;
    final /* synthetic */ ExoVideoPlayerClient f18878b;

    ExoVideoPlayerClient$12(ExoVideoPlayerClient exoVideoPlayerClient, boolean z) {
        this.f18878b = exoVideoPlayerClient;
        this.f18877a = z;
    }

    public void run() {
        if (this.f18878b.i()) {
            if (this.f18877a) {
                ExoVideoPlayerClient.b(this.f18878b, EventTriggerType.BY_PLAYER_INTERNAL_ERROR, new PlayPosition(0, 0));
            }
            ExoVideoPlayerClient.N(this.f18878b);
        }
    }
}
