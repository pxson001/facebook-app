package com.facebook.apptab.ui.nux;

import com.facebook.apptab.state.TabTag;
import com.facebook.nux.ui.NuxBubbleView;
import com.facebook.nux.ui.NuxBubbleView.Listener;

/* compiled from: profile_wizard_nux_dismiss */
class MainTabNuxController$1 implements Listener {
    final /* synthetic */ TabTag f7243a;
    final /* synthetic */ NuxBubbleView f7244b;
    final /* synthetic */ MainTabNuxController f7245c;

    MainTabNuxController$1(MainTabNuxController mainTabNuxController, TabTag tabTag, NuxBubbleView nuxBubbleView) {
        this.f7245c = mainTabNuxController;
        this.f7243a = tabTag;
        this.f7244b = nuxBubbleView;
    }

    public final void mo901a() {
        if (this.f7243a != null) {
            this.f7245c.b(this.f7243a);
        }
    }

    public final void mo902b() {
        this.f7245c.c.removeView(this.f7244b);
    }
}
