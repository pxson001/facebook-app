package com.facebook.pages.common.logging.analytics;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.view.Display;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: media_item_identifier */
public class PagesInternalAnalyticsLogger {
    private final PagesAnalytics f9113a;
    private boolean f9114b = false;

    public static PagesInternalAnalyticsLogger m10958a(InjectorLike injectorLike) {
        return new PagesInternalAnalyticsLogger(PagesAnalytics.m10916a(injectorLike));
    }

    @Inject
    public PagesInternalAnalyticsLogger(PagesAnalytics pagesAnalytics) {
        this.f9113a = pagesAnalytics;
    }

    public final void m10959a(Context context, long j, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (this.f9114b) {
            boolean z;
            if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                z = false;
            } else if (VERSION.SDK_INT >= 20) {
                for (Display state : ((DisplayManager) context.getSystemService("display")).getDisplays()) {
                    if (state.getState() != 1) {
                        z = true;
                        break;
                    }
                }
                z = false;
            } else {
                z = ((PowerManager) context.getSystemService("power")).isScreenOn();
            }
            if (z) {
                this.f9113a.m10923a(j, graphQLPagePresenceTabType);
                return;
            }
            return;
        }
        this.f9114b = true;
    }
}
