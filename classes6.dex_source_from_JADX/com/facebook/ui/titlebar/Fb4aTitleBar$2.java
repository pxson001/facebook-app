package com.facebook.ui.titlebar;

import com.facebook.fbui.tooltip.Tooltip;

/* compiled from: creativecam */
class Fb4aTitleBar$2 implements Runnable {
    final /* synthetic */ Tooltip f18355a;
    final /* synthetic */ Fb4aTitleBar f18356b;

    Fb4aTitleBar$2(Fb4aTitleBar fb4aTitleBar, Tooltip tooltip) {
        this.f18356b = fb4aTitleBar;
        this.f18355a = tooltip;
    }

    public void run() {
        if (this.f18356b.o.b != null) {
            this.f18355a.f(this.f18356b.o.b);
        }
    }
}
