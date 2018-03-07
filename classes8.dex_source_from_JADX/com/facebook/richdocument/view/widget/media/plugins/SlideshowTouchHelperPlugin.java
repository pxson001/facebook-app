package com.facebook.richdocument.view.widget.media.plugins;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.OnMediaTouchListener;

/* compiled from: numRelatedArticlesToFetch */
public class SlideshowTouchHelperPlugin extends BaseMediaFramePlugin<Void> implements OnMediaTouchListener {
    private final SlideshowView f7700a = ((SlideshowView) m7895i());
    private final int f7701b;
    private State f7702c = State.WAITING_FOR_DOWN;
    private float f7703d;

    /* compiled from: numRelatedArticlesToFetch */
    enum State {
        WAITING_FOR_DOWN,
        WAITING_TO_STEAL_GESTURE,
        SCROLLING_SLIDESHOW
    }

    public SlideshowTouchHelperPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        this.f7701b = ViewConfiguration.get(mediaFrame.getContext()).getScaledTouchSlop();
    }

    public final boolean mo512a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f7703d = motionEvent.getX();
            this.f7702c = State.WAITING_TO_STEAL_GESTURE;
            return false;
        } else if (motionEvent.getAction() == 2 && this.f7702c == State.WAITING_TO_STEAL_GESTURE) {
            if (Math.abs(motionEvent.getX() - this.f7703d) <= ((float) this.f7701b)) {
                return false;
            }
            this.f7700a.onTouchEvent(motionEvent);
            this.f7702c = State.SCROLLING_SLIDESHOW;
            return true;
        } else if (motionEvent.getAction() != 1) {
            return false;
        } else {
            this.f7702c = State.WAITING_FOR_DOWN;
            return false;
        }
    }

    public final boolean mo513b(MotionEvent motionEvent) {
        return false;
    }
}
