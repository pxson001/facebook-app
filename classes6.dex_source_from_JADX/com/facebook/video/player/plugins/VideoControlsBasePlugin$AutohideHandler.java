package com.facebook.video.player.plugins;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: commerce_view_product_details */
class VideoControlsBasePlugin$AutohideHandler extends Handler {
    private final WeakReference<VideoControlsBasePlugin> f19418a;

    public VideoControlsBasePlugin$AutohideHandler(VideoControlsBasePlugin videoControlsBasePlugin) {
        this.f19418a = new WeakReference(videoControlsBasePlugin);
    }

    public void handleMessage(Message message) {
        VideoControlsBasePlugin videoControlsBasePlugin = (VideoControlsBasePlugin) this.f19418a.get();
        if (videoControlsBasePlugin != null) {
            switch (message.what) {
                case 1:
                case 2:
                    videoControlsBasePlugin.c(500);
                    return;
                default:
                    return;
            }
        }
    }
}
