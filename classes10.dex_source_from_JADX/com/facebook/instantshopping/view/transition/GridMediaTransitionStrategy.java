package com.facebook.instantshopping.view.transition;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.common.util.SizeUtil;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.AspectFitMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionSpring;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.MediaView;

/* compiled from: SOLD_OUT */
public class GridMediaTransitionStrategy extends AspectFitMediaTransitionStrategy {
    public int f23847a = 1;
    public boolean f23848b = false;

    public GridMediaTransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
    }

    protected final void m25131k() {
        int max;
        View view = (View) m().getParent();
        MediaView mediaView = null;
        if (m() instanceof MediaFrame) {
            mediaView = ((MediaFrame) m()).getMediaView();
        }
        if (!(view instanceof RecyclerView)) {
            view = (View) view.getParent();
        }
        int a = this.f23847a > 1 ? SizeUtil.a(view.getContext(), 2.0f) : 0;
        int height = view.getHeight();
        if (mediaView != null) {
            max = (int) Math.max(((float) view.getMeasuredWidth()) / mediaView.getMediaAspectRatio(), (float) height);
        } else {
            max = height;
        }
        a((view.getWidth() / this.f23847a) - a, max);
        b(view.getWidth(), max);
    }

    public final boolean m25130j() {
        return this.f23848b;
    }
}
