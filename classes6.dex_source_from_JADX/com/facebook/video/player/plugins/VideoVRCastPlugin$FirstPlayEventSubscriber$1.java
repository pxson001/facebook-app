package com.facebook.video.player.plugins;

import com.facebook.video.player.plugins.VideoVRCastPlugin.FirstPlayEventSubscriber;

/* compiled from: commerce_view_page_store_entry_point */
class VideoVRCastPlugin$FirstPlayEventSubscriber$1 implements Runnable {
    final /* synthetic */ FirstPlayEventSubscriber f19426a;

    VideoVRCastPlugin$FirstPlayEventSubscriber$1(FirstPlayEventSubscriber firstPlayEventSubscriber) {
        this.f19426a = firstPlayEventSubscriber;
    }

    public void run() {
        this.f19426a.a.l.setVisibility(8);
    }
}
