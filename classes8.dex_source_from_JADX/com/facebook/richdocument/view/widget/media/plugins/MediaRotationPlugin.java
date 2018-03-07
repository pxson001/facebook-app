package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RotatableCandidateRegisterEvent;
import com.facebook.richdocument.event.RichDocumentEvents.RotatableCandidateRegisterEvent.RequestType;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.motion.OrientationChangeEventListener.DeviceOrientation;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.RotatableViewAware;
import javax.inject.Inject;

/* compiled from: num_cards_available */
public class MediaRotationPlugin extends BaseMediaFramePlugin<Void> implements RotatableViewAware {
    @Inject
    public RichDocumentEventBus f7671a;
    private MediaTransitionState f7672b;

    public static void m7948a(Object obj, Context context) {
        ((MediaRotationPlugin) obj).f7671a = RichDocumentEventBus.m5130a(FbInjector.get(context));
    }

    public MediaRotationPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = MediaRotationPlugin.class;
        m7948a(this, getContext());
    }

    public final void mo509d() {
        this.f7671a.a(new RotatableCandidateRegisterEvent(this, RequestType.REGISTER));
    }

    public final void mo510e() {
        this.f7671a.a(new RotatableCandidateRegisterEvent(this, RequestType.UNREGISTER));
    }

    private void m7949k() {
        MediaTransitionState j = m7896j();
        if (j.f6982f == Orientation.PORTRAIT) {
            this.f7672b = j;
        }
    }

    public final View m7950a() {
        if (this.f7617a.getTransitionStrategy().mo419j()) {
            Object h = m7894h();
            if (h != null && h.getMeasuredHeight() > 0) {
                return h;
            }
        }
        return null;
    }

    public final void m7951a(DeviceOrientation deviceOrientation) {
        MediaFrame mediaFrame = this.f7617a;
        switch (deviceOrientation) {
            case PORTRAIT:
                if (m7896j().f6982f.isLandscape()) {
                    if (this.f7672b != null) {
                        mediaFrame.mo478a(this.f7672b);
                    } else {
                        mediaFrame.mo478a((MediaTransitionState) this.f7617a.getTransitionStrategy().mo420d());
                    }
                }
                this.f7672b = null;
                return;
            case LANDSCAPE_LEFT:
                m7949k();
                mediaFrame.mo478a(MediaTransitionState.f6979c);
                return;
            case LANDSCAPE_RIGHT:
                m7949k();
                mediaFrame.mo478a(MediaTransitionState.f6980d);
                return;
            default:
                return;
        }
    }
}
