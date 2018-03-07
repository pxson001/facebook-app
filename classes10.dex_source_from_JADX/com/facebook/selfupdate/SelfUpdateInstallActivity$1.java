package com.facebook.selfupdate;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableBiMap;
import java.io.File;

/* compiled from: has_pin */
class SelfUpdateInstallActivity$1 implements OnClickListener {
    final /* synthetic */ String f9990a;
    final /* synthetic */ SelfUpdateInstallActivity f9991b;

    SelfUpdateInstallActivity$1(SelfUpdateInstallActivity selfUpdateInstallActivity, String str) {
        this.f9991b = selfUpdateInstallActivity;
        this.f9990a = str;
    }

    public void onClick(View view) {
        Intent intent;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1167589976);
        Uri parse = Uri.parse(this.f9990a);
        if (parse.getScheme() == null) {
            parse = Uri.fromFile(new File(this.f9990a));
        }
        SelfUpdateNotifier selfUpdateNotifier = this.f9991b.q;
        SelfUpdateInstallActivity selfUpdateInstallActivity = this.f9991b;
        if (parse == null) {
            intent = null;
        } else {
            intent = new Intent();
            intent.setDataAndType(parse, "application/vnd.android.package-archive");
        }
        Intent intent2 = intent;
        if (intent2 != null) {
            Object obj;
            Context applicationContext = selfUpdateInstallActivity.getApplicationContext();
            if (selfUpdateNotifier.f10019l.d() || !SelfUpdateChecker.b(applicationContext)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                intent2.setAction("android.intent.action.INSTALL_PACKAGE");
                intent2.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                intent2.putExtra("android.intent.extra.ALLOW_REPLACE", true);
                intent2.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", selfUpdateInstallActivity.getApplicationInfo().packageName);
                selfUpdateNotifier.f10012e.b(intent2, 4, selfUpdateInstallActivity);
            } else {
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(268435456);
                selfUpdateNotifier.f10012e.b(intent2, selfUpdateInstallActivity);
            }
        }
        this.f9991b.p.a("selfupdate_click_install", ImmutableBiMap.b("source", this.f9991b.B));
        Logger.a(2, EntryType.UI_INPUT_END, -1216896773, a);
    }
}
