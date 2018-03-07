package com.facebook.gk.internal;

import android.os.Bundle;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;

/* compiled from: sms_takeover_explain_dialog_action */
public class GatekeeperUpdateListener implements GatekeeperFetchListener {
    private final FbSharedPreferences f2024a;
    private final GatekeeperWriter f2025b;

    @Inject
    public GatekeeperUpdateListener(FbSharedPreferences fbSharedPreferences, GatekeeperWriter gatekeeperWriter) {
        this.f2024a = fbSharedPreferences;
        this.f2025b = gatekeeperWriter;
    }

    public final void mo84a(Bundle bundle) {
        this.f2024a.edit().a(GkPrefKeys.c, System.currentTimeMillis()).commit();
        this.f2025b.e().mo4a(bundle.getBooleanArray("gatekeepers")).mo6a(true);
    }
}
