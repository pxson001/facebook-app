package com.facebook.launcherbadges;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.String_AppLaunchClassMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: p2p_initiate_receipt */
public class AsusLauncherBadgesInterface implements LauncherBadgesInterface {
    private final Context f7616a;
    private final AbstractFbErrorReporter f7617b;
    private final String f7618c;
    private final String f7619d;

    private static AsusLauncherBadgesInterface m7898b(InjectorLike injectorLike) {
        return new AsusLauncherBadgesInterface((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), String_AppLaunchClassMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AsusLauncherBadgesInterface(Context context, AbstractFbErrorReporter abstractFbErrorReporter, String str) {
        this.f7616a = context;
        this.f7617b = abstractFbErrorReporter;
        this.f7618c = context.getPackageName();
        this.f7619d = str;
    }

    public final TriState m7899a(int i) {
        try {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", this.f7618c);
            intent.putExtra("badge_count_class_name", this.f7619d);
            this.f7616a.sendBroadcast(intent);
            return TriState.YES;
        } catch (Throwable e) {
            this.f7617b.a(AsusLauncherBadgesInterface.class.getName(), "exception", e);
            return TriState.NO;
        }
    }
}
