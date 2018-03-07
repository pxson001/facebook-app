package com.facebook.orca.threadview;

import android.content.res.Resources;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import javax.inject.Inject;

/* compiled from: msgr_flower_border_set_enabled */
public class AdminMessageWithLinkViewModelFactory {
    public final EphemeralGatingUtil f6854a;
    public final Resources f6855b;

    @Inject
    public AdminMessageWithLinkViewModelFactory(EphemeralGatingUtil ephemeralGatingUtil, Resources resources) {
        this.f6854a = ephemeralGatingUtil;
        this.f6855b = resources;
    }
}
