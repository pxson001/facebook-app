package com.facebook.facecastdisplay;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: story_attachments_icon_image */
class LiveEventsPlugin$VideoTimeUpdateHandler extends Handler {
    private final WeakReference<LiveEventsPlugin> f2970a;

    public LiveEventsPlugin$VideoTimeUpdateHandler(LiveEventsPlugin liveEventsPlugin) {
        this.f2970a = new WeakReference(liveEventsPlugin);
    }

    public void handleMessage(Message message) {
        LiveEventsPlugin liveEventsPlugin = (LiveEventsPlugin) this.f2970a.get();
        if (liveEventsPlugin != null) {
            switch (message.what) {
                case 2:
                    liveEventsPlugin.d();
                    return;
                default:
                    return;
            }
        }
    }
}
