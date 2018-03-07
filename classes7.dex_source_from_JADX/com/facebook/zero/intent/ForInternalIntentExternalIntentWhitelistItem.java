package com.facebook.zero.intent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.TriState;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: ी */
public class ForInternalIntentExternalIntentWhitelistItem implements ExternalIntentWhitelistItem {
    public static final ImmutableList<String> f111a = ImmutableList.of("com.facebook.browser.lite.BrowserLiteActivity");
    private final String f112b;
    private final AbstractFbErrorReporter f113c;

    @Inject
    public ForInternalIntentExternalIntentWhitelistItem(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f112b = context.getPackageName();
        this.f113c = abstractFbErrorReporter;
    }

    public final TriState m101a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null && f111a.contains(component.getClassName())) {
            return TriState.NO;
        }
        if (component == null || !this.f112b.equals(component.getPackageName())) {
            return TriState.UNSET;
        }
        this.f113c.a("fix:shall_start_internal_activity_instead", String.valueOf(intent));
        return TriState.YES;
    }
}
