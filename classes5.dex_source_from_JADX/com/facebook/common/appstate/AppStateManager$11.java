package com.facebook.common.appstate;

import com.facebook.common.init.INeedInit;

/* compiled from: story_with_page */
class AppStateManager$11 implements Runnable {
    final /* synthetic */ INeedInit f2484a;
    final /* synthetic */ AppStateManager f2485b;

    AppStateManager$11(AppStateManager appStateManager, INeedInit iNeedInit) {
        this.f2485b = appStateManager;
        this.f2484a = iNeedInit;
    }

    public void run() {
        this.f2484a.init();
    }
}
