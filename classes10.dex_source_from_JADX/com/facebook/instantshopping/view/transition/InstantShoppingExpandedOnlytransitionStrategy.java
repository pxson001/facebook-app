package com.facebook.instantshopping.view.transition;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.richdocument.view.transition.MediaTransitionStrategy.FullscreenMediaTransitionStrategy;
import com.facebook.richdocument.view.transition.TransitionSpring;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: SOCIAL_CONTEXT */
public class InstantShoppingExpandedOnlytransitionStrategy extends FullscreenMediaTransitionStrategy {
    public boolean f23849a;
    private int f23850b;

    public InstantShoppingExpandedOnlytransitionStrategy(MediaFrame mediaFrame, TransitionSpring transitionSpring) {
        super(mediaFrame, transitionSpring);
    }

    protected final void m25133k() {
        View view = (View) m().getParent();
        if (!(view instanceof RecyclerView)) {
            view = (View) view.getParent();
        }
        a(view.getWidth(), view.getHeight());
        if (this.f23850b <= 0) {
            this.f23850b = this.f23849a ? m().getHeight() : view.getHeight();
        }
        b(view.getWidth(), this.f23850b);
    }

    public boolean mo1033j() {
        return false;
    }
}
