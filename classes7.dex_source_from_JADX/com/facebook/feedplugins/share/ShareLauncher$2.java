package com.facebook.feedplugins.share;

import com.facebook.feedplugins.share.ShareMenuPopoverFactory.OnPopoverDismissCallback;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEvent;

/* compiled from: remoteModuleConfig */
class ShareLauncher$2 implements OnPopoverDismissCallback {
    final /* synthetic */ ShareLauncher f5287a;

    ShareLauncher$2(ShareLauncher shareLauncher) {
        this.f5287a = shareLauncher;
    }

    public final void mo283a() {
        this.f5287a.l.a(new FlyoutOnDismissEvent());
    }
}
