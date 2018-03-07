package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.ExpandedMediaHolder;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: numSubmitClicks */
public class SlideshowSyncPlugin extends BaseMediaFramePlugin<Void> {
    @Inject
    public ExpandedMediaHolder f7699a;

    public static void m7982a(Object obj, Context context) {
        ((SlideshowSyncPlugin) obj).f7699a = ExpandedMediaHolder.m7438a(FbInjector.get(context));
    }

    public SlideshowSyncPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = SlideshowSyncPlugin.class;
        m7982a(this, getContext());
    }

    public final boolean mo447a(Event event) {
        if (event == Event.CLICK_MEDIA) {
            if (m7983a() && this.f7699a.m7440a() == null) {
                MediaFrame k = m7984k();
                if (k != null) {
                    k.mo478a(MediaTransitionState.f6978b);
                    this.f7699a.m7441a(m7893g());
                    return true;
                }
            }
        } else if (event == Event.BACK && !m7985l()) {
            return this.f7617a.mo447a(Event.CLICK_MEDIA);
        }
        return super.mo447a(event);
    }

    public final void mo503a(MediaTransitionState mediaTransitionState) {
        if (mediaTransitionState == MediaTransitionState.f6977a && !m7983a()) {
            MediaFrame k = m7984k();
            if (k != null) {
                k.mo482c();
            }
        }
    }

    private boolean m7983a() {
        MediaFrame k = m7984k();
        if (k == null || k.getTransitionStrategy().mo420d() != MediaTransitionState.f6978b) {
            return false;
        }
        return true;
    }

    private MediaFrame m7984k() {
        SlideshowView slideshowView = (SlideshowView) m7893g().getParent();
        if (slideshowView != null) {
            return slideshowView.getMediaFrame();
        }
        return null;
    }

    private boolean m7985l() {
        MediaFrame k = m7984k();
        if (k == null || k.getTransitionStrategy().mo420d() == m7896j()) {
            return true;
        }
        return false;
    }
}
