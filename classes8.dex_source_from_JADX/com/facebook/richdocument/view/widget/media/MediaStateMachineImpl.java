package com.facebook.richdocument.view.widget.media;

import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.state.MediaStateMachine;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.ExpandedMediaHolder;

/* compiled from: nux_state */
public class MediaStateMachineImpl implements MediaStateMachine {
    public final MediaFrame f7600a;
    private final ExpandedMediaHolder f7601b;

    public MediaStateMachineImpl(MediaFrame mediaFrame, ExpandedMediaHolder expandedMediaHolder) {
        this.f7600a = mediaFrame;
        this.f7601b = expandedMediaHolder;
    }

    public final boolean mo447a(Event event) {
        if (this.f7600a == null || this.f7600a.getTransitionStrategy() == null || !this.f7600a.getTransitionStrategy().m7254l()) {
            return false;
        }
        switch (event) {
            case CLICK_MEDIA:
                MediaTransitionState b = m7847b();
                if (b == MediaTransitionState.f6977a) {
                    if (!this.f7600a.mo481b(MediaTransitionState.f6978b)) {
                        return false;
                    }
                    this.f7600a.mo478a(MediaTransitionState.f6978b);
                    return true;
                } else if (b != MediaTransitionState.f6978b) {
                    return false;
                } else {
                    if (this.f7600a.mo481b(MediaTransitionState.f6977a)) {
                        this.f7600a.mo478a(MediaTransitionState.f6977a);
                        return true;
                    } else if (!this.f7600a.mo481b(MediaTransitionState.f6978b)) {
                        return false;
                    } else {
                        this.f7600a.mo478a(MediaTransitionState.f6978b);
                        return true;
                    }
                }
            case SCROLL_FINISHED:
                this.f7601b.m7441a(null);
                break;
            case BACK:
                break;
            default:
                return false;
        }
        if (m7846a()) {
            return false;
        }
        this.f7600a.mo478a(m7848c());
        if (m7848c() != MediaTransitionState.f6978b) {
            return true;
        }
        return false;
    }

    private boolean m7846a() {
        return m7847b() == m7848c();
    }

    private MediaTransitionState m7847b() {
        return (MediaTransitionState) this.f7600a.getTransitionStrategy().m7206f();
    }

    private MediaTransitionState m7848c() {
        return (MediaTransitionState) this.f7600a.getTransitionStrategy().mo420d();
    }
}
