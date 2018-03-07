package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.ExpandedMediaHolder;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: num_pages */
public class ExpandedOnlyMediaFramePlugin extends BaseMediaFramePlugin<Void> {
    @Inject
    public ExpandedMediaHolder f7627a;

    public static void m7905a(Object obj, Context context) {
        ((ExpandedOnlyMediaFramePlugin) obj).f7627a = ExpandedMediaHolder.m7438a(FbInjector.get(context));
    }

    public ExpandedOnlyMediaFramePlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = ExpandedOnlyMediaFramePlugin.class;
        m7905a(this, getContext());
    }

    public final boolean mo447a(Event event) {
        if (event == Event.CLICK_MEDIA) {
            Object obj;
            if (m7896j() == MediaTransitionState.f6978b) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && this.f7627a.m7440a() == null) {
                this.f7617a.mo478a(MediaTransitionState.f6978b);
                this.f7627a.m7441a(m7893g());
                return true;
            }
        }
        return super.mo447a(event);
    }

    public final void mo503a(MediaTransitionState mediaTransitionState) {
        super.mo503a(mediaTransitionState);
        if (mediaTransitionState == MediaTransitionState.f6978b || mediaTransitionState == MediaTransitionState.f6977a) {
            this.f7627a.m7441a(m7893g());
        }
    }
}
