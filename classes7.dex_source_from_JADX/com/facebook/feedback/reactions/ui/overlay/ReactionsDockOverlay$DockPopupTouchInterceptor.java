package com.facebook.feedback.reactions.ui.overlay;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: serialized_story_data.txt */
public class ReactionsDockOverlay$DockPopupTouchInterceptor implements OnTouchListener {
    final /* synthetic */ ReactionsDockOverlay f3971a;

    public ReactionsDockOverlay$DockPopupTouchInterceptor(ReactionsDockOverlay reactionsDockOverlay) {
        this.f3971a = reactionsDockOverlay;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ReactionsDockOverlay reactionsDockOverlay = this.f3971a;
        Object obj = null;
        if (!reactionsDockOverlay.n.mo191f()) {
            int i;
            if (reactionsDockOverlay.s != -1) {
                i = 1;
            } else if (motionEvent.getAction() != 0 || reactionsDockOverlay.n.mo187b(motionEvent) || reactionsDockOverlay.h.isTouchExplorationEnabled()) {
                i = 1;
            }
        }
        if (obj != null) {
            ReactionsDockOverlay.a(this.f3971a, null, motionEvent, true);
        } else {
            this.f3971a.b();
        }
        return true;
    }
}
