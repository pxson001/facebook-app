package com.facebook.registration.ui;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.registration.ui.RegClickableSpan.TargetActivity;

/* compiled from: extra_presence_map */
public class RegClickableSpanProvider extends AbstractAssistedProvider<RegClickableSpan> {
    public final RegClickableSpan m13212a(TargetActivity targetActivity, String str) {
        return new RegClickableSpan(IdBasedSingletonScopeProvider.b(this, 968), targetActivity, str);
    }
}
