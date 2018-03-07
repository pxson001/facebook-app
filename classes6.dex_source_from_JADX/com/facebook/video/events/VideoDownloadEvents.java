package com.facebook.video.events;

import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedHandler;

/* compiled from: composer_select_album_cancel */
public class VideoDownloadEvents {

    /* compiled from: composer_select_album_cancel */
    public class DownloadStatusChangeEvent extends TypedEvent<Handler> {
        public final VideoDownloadStatus f18947a;
        public final String f18948b;

        /* compiled from: composer_select_album_cancel */
        public interface Handler extends TypedHandler {
            void m27619a(DownloadStatusChangeEvent downloadStatusChangeEvent);
        }

        public final void m27620a(TypedHandler typedHandler) {
            ((Handler) typedHandler).m27619a(this);
        }

        public DownloadStatusChangeEvent(String str, VideoDownloadStatus videoDownloadStatus) {
            this.f18947a = videoDownloadStatus;
            this.f18948b = str;
        }
    }
}
