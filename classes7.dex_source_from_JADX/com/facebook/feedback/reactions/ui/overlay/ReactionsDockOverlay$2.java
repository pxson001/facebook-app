package com.facebook.feedback.reactions.ui.overlay;

import android.widget.PopupWindow.OnDismissListener;

/* compiled from: serialized_story_data.txt */
public class ReactionsDockOverlay$2 implements OnDismissListener {
    final /* synthetic */ ReactionsDockOverlay f3970a;

    public ReactionsDockOverlay$2(ReactionsDockOverlay reactionsDockOverlay) {
        this.f3970a = reactionsDockOverlay;
    }

    public void onDismiss() {
        if (!this.f3970a.n.mo191f()) {
            this.f3970a.n.mo190e();
            ReactionsDockOverlay.d(this.f3970a).a(false);
        }
    }
}
