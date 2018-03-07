package com.facebook.launcherbadges;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.TriState;
import javax.inject.Inject;

/* compiled from: mValue */
public class LgLauncherBadgesInterface implements LauncherBadgesInterface {
    private final Context f8440a;
    private final AbstractFbErrorReporter f8441b;
    private final String f8442c;
    private final String f8443d;

    @Inject
    public LgLauncherBadgesInterface(Context context, AbstractFbErrorReporter abstractFbErrorReporter, String str) {
        this.f8440a = context;
        this.f8441b = abstractFbErrorReporter;
        this.f8442c = context.getPackageName();
        this.f8443d = str;
    }

    public final TriState mo683a(int i) {
        try {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", this.f8442c);
            intent.putExtra("badge_count_class_name", this.f8443d);
            this.f8440a.sendBroadcast(intent);
            return TriState.YES;
        } catch (Throwable e) {
            this.f8441b.a(LgLauncherBadgesInterface.class.getName(), "exception", e);
            return TriState.NO;
        }
    }
}
