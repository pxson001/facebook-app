package com.facebook.appinvites.nux;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: ed23f7a75e5908d85766e86a98c39503 */
public final class AppInviteNuxInterstitialController$1 implements OnClickListener {
    final /* synthetic */ View f14611a;

    public AppInviteNuxInterstitialController$1(View view) {
        this.f14611a = view;
    }

    public final void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -769159348);
        this.f14611a.setVisibility(8);
        Logger.a(2, EntryType.UI_INPUT_END, -1692073453, a);
    }
}
