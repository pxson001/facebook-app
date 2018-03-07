package com.facebook.http.prefs.delaybasedqp;

import android.widget.TextView;
import com.facebook.prefs.shared.FbSharedPreferences;
import javax.inject.Inject;

/* compiled from: edit_and_share_successful */
public class DelayBasedQPViewController {
    public TextView f14928a;
    public FbSharedPreferences f14929b;

    @Inject
    public DelayBasedQPViewController(FbSharedPreferences fbSharedPreferences) {
        this.f14929b = fbSharedPreferences;
    }

    public final void m17398a(boolean z) {
        if (this.f14928a != null) {
            this.f14928a.setVisibility(z ? 0 : 8);
        }
    }
}
