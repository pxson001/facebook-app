package com.facebook.quicklog.module;

import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.util.TriState;

/* compiled from: upsell_last_seen */
public class StandardAppStates {
    private TriState f1577a = TriState.UNSET;
    private AppStateManager f1578b;

    public StandardAppStates(AppStateManager appStateManager) {
        this.f1578b = appStateManager;
    }

    public final TriState m3177a() {
        if (!this.f1577a.isSet()) {
            this.f1577a = this.f1578b.m2263k();
        }
        return this.f1577a;
    }
}
