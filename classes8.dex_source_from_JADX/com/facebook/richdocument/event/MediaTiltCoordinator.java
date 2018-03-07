package com.facebook.richdocument.event;

import com.facebook.content.event.FbEvent;
import com.facebook.richdocument.event.RichDocumentEvents.MediaTiltEventListenerRequest;
import com.facebook.richdocument.event.RichDocumentEvents.MediaTiltEventListenerRequest.RequestType;
import com.facebook.richdocument.view.transition.motion.GyroBasedMediaTiltSensor;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin;

/* compiled from: primary_text */
public class MediaTiltCoordinator extends RichDocumentEventSubscriber<MediaTiltEventListenerRequest> {
    private final GyroBasedMediaTiltSensor f5148a;

    public final void m5124b(FbEvent fbEvent) {
        MediaTiltEventListenerRequest mediaTiltEventListenerRequest = (MediaTiltEventListenerRequest) fbEvent;
        RequestType requestType = mediaTiltEventListenerRequest.f5160b;
        MediaTiltPlugin mediaTiltPlugin = mediaTiltEventListenerRequest.f5159a;
        if (requestType == RequestType.REGISTER) {
            this.f5148a.m7338a(mediaTiltPlugin);
        } else if (requestType == RequestType.UNREGISTER) {
            this.f5148a.m7339b(mediaTiltPlugin);
        }
    }

    public MediaTiltCoordinator(GyroBasedMediaTiltSensor gyroBasedMediaTiltSensor) {
        this.f5148a = gyroBasedMediaTiltSensor;
    }

    public final Class<MediaTiltEventListenerRequest> m5123a() {
        return MediaTiltEventListenerRequest.class;
    }
}
