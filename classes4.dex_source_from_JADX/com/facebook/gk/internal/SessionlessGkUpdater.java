package com.facebook.gk.internal;

import android.os.Bundle;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import javax.inject.Inject;

/* compiled from: timeout_attachment_futures */
public class SessionlessGkUpdater implements GatekeeperFetchListener {
    private final FbSharedPreferences f1000a;
    private final GatekeeperWriter f1001b;

    @Inject
    public SessionlessGkUpdater(FbSharedPreferences fbSharedPreferences, GatekeeperWriter gatekeeperWriter) {
        this.f1000a = fbSharedPreferences;
        this.f1001b = gatekeeperWriter;
    }

    public final void mo84a(Bundle bundle) {
        this.f1001b.e().mo4a(bundle.getBooleanArray("gatekeepers")).mo6a(true);
        Editor edit = this.f1000a.edit();
        edit.a(SessionlessGkPrefKeys.f44b, System.currentTimeMillis());
        if (this.f1000a.a(SessionlessGkPrefKeys.f47e, 0) != 1) {
            edit.a(SessionlessGkPrefKeys.f47e, 1);
        }
        edit.commit();
    }
}
