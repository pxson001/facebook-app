package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.logging.ImagePerfLogger;
import com.facebook.richdocument.logging.ImagePerfLogger.ImageInfo;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: num_interactions */
public class ImageInteractionMonitorPlugin extends BaseMediaFramePlugin<Void> {
    @Inject
    public ImagePerfLogger f7638a;
    public String f7639b;

    public static void m7914a(Object obj, Context context) {
        ((ImageInteractionMonitorPlugin) obj).f7638a = ImagePerfLogger.m5347a(FbInjector.get(context));
    }

    public ImageInteractionMonitorPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = ImageInteractionMonitorPlugin.class;
        m7914a(this, getContext());
    }

    public final boolean mo507b() {
        return true;
    }

    public final boolean mo447a(Event event) {
        if (event == Event.CLICK_MEDIA) {
            ImagePerfLogger imagePerfLogger = this.f7638a;
            ImageInfo imageInfo = (ImageInfo) imagePerfLogger.f5472f.get(this.f7639b);
            if (imageInfo != null && imageInfo.f5453b) {
                imageInfo.f5458g = true;
            }
        }
        return super.mo447a(event);
    }
}
