package com.facebook.launcherbadges;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.TriState;
import javax.inject.Inject;

/* compiled from: mUserId */
public class SonyLauncherBadgesInterface implements LauncherBadgesInterface {
    private final Context f8450a;
    private final AbstractFbErrorReporter f8451b;
    private final String f8452c;
    private final String f8453d;
    private boolean f8454e = false;

    @Inject
    public SonyLauncherBadgesInterface(Context context, AbstractFbErrorReporter abstractFbErrorReporter, String str) {
        this.f8450a = context;
        this.f8451b = abstractFbErrorReporter;
        this.f8453d = str;
        this.f8452c = context.getPackageName();
    }

    public final TriState mo683a(int i) {
        if (this.f8454e) {
            return TriState.NO;
        }
        try {
            Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
            if (VERSION.SDK_INT >= 12) {
                m8699a(intent);
            }
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", this.f8453d);
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i != 0);
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", this.f8452c);
            this.f8450a.sendBroadcast(intent);
            return TriState.UNSET;
        } catch (Throwable e) {
            this.f8451b.a(SonyLauncherBadgesInterface.class.getName(), "unexpected exception", e);
            this.f8454e = true;
            return TriState.NO;
        }
    }

    @TargetApi(12)
    private static final void m8699a(Intent intent) {
        intent.setFlags(16);
    }
}
