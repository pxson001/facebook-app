package com.facebook.video.subtitles.controller.compat;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener */
public class CustomSubtitleAdapter$SubtitleThreadHandler extends Handler {
    private final WeakReference<CustomSubtitleAdapter> f19666a;

    public CustomSubtitleAdapter$SubtitleThreadHandler(Looper looper, CustomSubtitleAdapter customSubtitleAdapter) {
        super(looper);
        this.f19666a = new WeakReference(customSubtitleAdapter);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 322420958:
                if (this.f19666a.get() != null) {
                    ((CustomSubtitleAdapter) this.f19666a.get()).e();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
