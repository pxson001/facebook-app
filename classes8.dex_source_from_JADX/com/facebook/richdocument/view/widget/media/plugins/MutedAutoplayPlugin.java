package com.facebook.richdocument.view.widget.media.plugins;

import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.Orientation;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.RichDocumentVideoPlayer;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayer;
import java.lang.ref.WeakReference;

/* compiled from: num_added_units */
public class MutedAutoplayPlugin extends BaseMediaFramePlugin<Void> {
    public AudioPlugin f7695a;

    public MutedAutoplayPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        if (!(mediaFrame.getMediaView() instanceof RichVideoPlayer)) {
            throw new IllegalArgumentException("Expecting RichVideoPlayer");
        }
    }

    public final void m7977k() {
        RichVideoPlayer richVideoPlayer = (RichVideoPlayer) m7895i();
        this.f7695a = new AudioPlugin(getContext());
        richVideoPlayer.b(AudioPlugin.class);
        richVideoPlayer.a(this.f7695a);
        this.f7695a.f7615m = new WeakReference(this);
    }

    public final void mo506b(ViewLayout viewLayout) {
        MediaTransitionState j = m7896j();
        RichVideoPlayer richVideoPlayer = (RichVideoPlayer) m7895i();
        if (richVideoPlayer != null && this.f7695a != null) {
            Object obj;
            Orientation orientation = j.f6982f;
            if (orientation == Orientation.LANDSCAPE_LEFT || orientation == Orientation.LANDSCAPE_RIGHT) {
                obj = 1;
            } else {
                obj = null;
            }
            boolean z = obj != null || j == MediaTransitionState.f6978b;
            this.f7695a.f7613d = z;
            m7974a(false);
            if (z) {
                this.f7695a.m7871e();
            } else {
                this.f7695a.m7869a(richVideoPlayer.o());
            }
        }
    }

    public final void m7975a() {
        m7974a(true);
    }

    public final void m7978l() {
        m7974a(false);
    }

    private void m7974a(boolean z) {
        RichDocumentVideoPlayer richDocumentVideoPlayer = (RichDocumentVideoPlayer) m7895i();
        if (richDocumentVideoPlayer != null && this.f7695a != null) {
            Object obj;
            boolean z2 = z ? !richDocumentVideoPlayer.f7363l : richDocumentVideoPlayer.f7363l;
            richDocumentVideoPlayer.a(z2, EventTriggerType.BY_USER);
            AudioPlugin audioPlugin = this.f7695a;
            if (z2) {
                obj = null;
            } else {
                obj = 1;
            }
            if (audioPlugin.f7616n != (obj == null)) {
                boolean z3;
                audioPlugin.f7611b.setImageResource(obj != null ? 2130837734 : 2130837740);
                if (obj == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                audioPlugin.f7616n = z3;
                audioPlugin.f7614l = false;
            }
            if (richDocumentVideoPlayer.m()) {
                this.f7695a.m7870d();
            }
        }
    }
}
