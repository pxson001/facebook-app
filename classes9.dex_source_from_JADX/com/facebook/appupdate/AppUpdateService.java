package com.facebook.appupdate;

import android.content.Intent;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: UNREACHABLE */
public class AppUpdateService extends WaitForInitService {
    private AppUpdateInjector f23802a;
    private AppUpdateOperationFactory f23803b;

    protected final void mo1099a(AppUpdateInjector appUpdateInjector) {
        this.f23802a = appUpdateInjector;
        this.f23803b = appUpdateInjector.e();
    }

    protected final boolean mo1100a(Intent intent) {
        String action = intent.getAction();
        boolean z = true;
        switch (action.hashCode()) {
            case -839973947:
                if (action.equals("start_download")) {
                    z = true;
                    break;
                }
                break;
            case -785075440:
                if (action.equals("download_complete")) {
                    z = false;
                    break;
                }
                break;
            case 83300030:
                if (action.equals("start_install")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                return m25811a(intent.getLongExtra("download_id", -1));
            case true:
                return m25812a(intent.getStringExtra("operation_uuid"));
            case true:
                return m25813b(intent.getStringExtra("operation_uuid"));
            default:
                return false;
        }
    }

    private boolean m25811a(long j) {
        for (AppUpdateOperation appUpdateOperation : this.f23803b.c()) {
            AppUpdateState c = appUpdateOperation.m25801c();
            if (j != -1 && j == c.downloadId) {
                appUpdateOperation.m25802d();
            }
        }
        return false;
    }

    private boolean m25812a(@Nullable String str) {
        for (AppUpdateOperation appUpdateOperation : this.f23803b.c()) {
            if (appUpdateOperation.m25801c().operationUuid.equals(str)) {
                appUpdateOperation.m25800b();
                break;
            }
        }
        return false;
    }

    private boolean m25813b(@Nullable String str) {
        this.f23802a.k().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        for (AppUpdateOperation c : this.f23803b.c()) {
            AppUpdateState c2 = c.m25801c();
            if (c2.operationUuid.equals(str)) {
                if (c2.operationState == 4) {
                    startActivity(AppUpdateActivity.m25768a(this, Uri.parse(c2.localFile.toURI().toString())));
                    this.f23802a.h();
                }
                return false;
            }
        }
        return false;
    }
}
