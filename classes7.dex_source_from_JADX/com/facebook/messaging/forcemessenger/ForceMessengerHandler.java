package com.facebook.messaging.forcemessenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: onCompletedPersistedRelayQuery */
public class ForceMessengerHandler {
    public final Context f7837a;
    public final SecureContextHelper f7838b;
    public final AnalyticsLogger f7839c;

    public static ForceMessengerHandler m9452b(InjectorLike injectorLike) {
        return new ForceMessengerHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ForceMessengerHandler(Context context, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger) {
        this.f7837a = context;
        this.f7838b = secureContextHelper;
        this.f7839c = analyticsLogger;
    }

    public final void m9454a(String str, String str2) {
        m9453b(str2);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(StringFormatUtil.formatStrLocaleSafe(FBLinks.R, str)));
        if (!(this.f7837a instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f7838b.a(intent, this.f7837a);
    }

    private void m9453b(String str) {
        if (str.equals("divebar")) {
            str = "diode_divebar";
        } else if (str.equals("inbox_jewel")) {
            str = "diode_jewel";
        } else if (str.equals("timeline")) {
            str = "diode_timeline";
        }
        if (this.f7839c != null) {
            HoneyClientEventFast a = this.f7839c.a(str, false);
            if (a.a()) {
                a.b();
            }
        }
    }
}
