package com.facebook.feedplugins.feedbackreactions.ui.nux;

import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;

/* compiled from: Story posting not supported yet */
class ReactionsNuxControllerDelegate$1 implements OnDismissListener {
    final /* synthetic */ ReactionsNuxControllerDelegate f23131a;

    ReactionsNuxControllerDelegate$1(ReactionsNuxControllerDelegate reactionsNuxControllerDelegate) {
        this.f23131a = reactionsNuxControllerDelegate;
    }

    public final boolean m25554a(PopoverWindow popoverWindow) {
        if (this.f23131a.c != null) {
            this.f23131a.c.l();
        }
        return false;
    }
}
