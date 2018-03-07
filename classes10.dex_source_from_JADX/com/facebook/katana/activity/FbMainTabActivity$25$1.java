package com.facebook.katana.activity;

import com.facebook.katana.activity.FbMainTabActivity.25;
import com.facebook.notifications.util.RedSpaceBadgeCountManager;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$25$1 implements Runnable {
    final /* synthetic */ 25 f24214a;

    FbMainTabActivity$25$1(25 25) {
        this.f24214a = 25;
    }

    public void run() {
        ((RedSpaceBadgeCountManager) this.f24214a.a.aQ.get()).c();
    }
}
