package com.facebook.appupdate;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.selfupdate.FbandroidAppConfiguration;
import java.util.UUID;

/* compiled from: ranked_threaded */
public class AppUpdateNotificationsCreator implements AppUpdateOperation$StateCallback {
    public final Context f8287a;
    private final NotificationManager f8288b;
    private final FbandroidAppConfiguration f8289c;
    public final AppInstallCallback f8290d;

    public AppUpdateNotificationsCreator(Context context, NotificationManager notificationManager, FbandroidAppConfiguration fbandroidAppConfiguration, AppInstallCallback appInstallCallback) {
        this.f8287a = context;
        this.f8288b = notificationManager;
        this.f8289c = fbandroidAppConfiguration;
        this.f8290d = appInstallCallback;
    }

    public final void mo1727a(AppUpdateOperation appUpdateOperation, AppUpdateState appUpdateState) {
        m12810a(appUpdateState);
    }

    public final void m12810a(AppUpdateState appUpdateState) {
        if (appUpdateState.isBackgroundMode) {
            m12807b(appUpdateState);
        } else {
            m12808c(appUpdateState);
        }
    }

    private void m12807b(AppUpdateState appUpdateState) {
        int leastSignificantBits = (int) UUID.fromString(appUpdateState.operationUuid).getLeastSignificantBits();
        if (appUpdateState.operationState == 4) {
            Builder builder = new Builder(this.f8287a);
            FbandroidAppConfiguration fbandroidAppConfiguration = this.f8289c;
            builder.a(2130840913);
            builder.a("Update for " + appUpdateState.releaseInfo.appName);
            builder.b("Version " + appUpdateState.releaseInfo.versionName + " is ready to install");
            builder.d = m12806a(appUpdateState, leastSignificantBits);
            this.f8288b.notify("app_update_notification", leastSignificantBits, builder.c());
            return;
        }
        this.f8288b.cancel("app_update_notification", leastSignificantBits);
    }

    private void m12808c(AppUpdateState appUpdateState) {
        int leastSignificantBits = (int) UUID.fromString(appUpdateState.operationUuid).getLeastSignificantBits();
        if (appUpdateState.operationState == 2 || appUpdateState.operationState == 6) {
            this.f8288b.cancel("app_update_notification", leastSignificantBits);
            return;
        }
        CharSequence charSequence;
        Builder builder = new Builder(this.f8287a);
        FbandroidAppConfiguration fbandroidAppConfiguration = this.f8289c;
        builder.a(2130840913);
        builder.a("Update for " + appUpdateState.releaseInfo.appName);
        Intent intent;
        switch (appUpdateState.operationState) {
            case 0:
                charSequence = "Version " + appUpdateState.releaseInfo.versionName + " is available (fb-only)";
                intent = new Intent(this.f8287a, AppUpdateService.class);
                intent.setAction("start_download");
                intent.putExtra("operation_uuid", appUpdateState.operationUuid);
                builder.a(17301540, "Start Download", PendingIntent.getService(this.f8287a, leastSignificantBits, intent, 134217728));
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                charSequence = "Starting";
                builder.a(0, 0, true);
                break;
            case 3:
                charSequence = "Verifying";
                builder.a(0, 0, true);
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                PendingIntent activity;
                charSequence = "Version " + appUpdateState.releaseInfo.versionName + " is ready to install";
                if (this.f8290d == null) {
                    activity = PendingIntent.getActivity(this.f8287a, leastSignificantBits, AppUpdateActivity.a(this.f8287a, Uri.parse(appUpdateState.localFile.toURI().toString())), 134217728);
                } else {
                    intent = new Intent(this.f8287a, AppUpdateService.class);
                    intent.setAction("start_install");
                    intent.putExtra("operation_uuid", appUpdateState.operationUuid);
                    activity = PendingIntent.getService(this.f8287a, leastSignificantBits, intent, 134217728);
                }
                builder.a(17301555, "Start Install", activity);
                break;
            case 5:
                charSequence = "Failed to fetch update";
                break;
            default:
                charSequence = "Error: unknown state! (" + appUpdateState.operationState + ")";
                break;
        }
        builder.b(charSequence);
        builder.d = m12806a(appUpdateState, leastSignificantBits);
        this.f8288b.notify("app_update_notification", leastSignificantBits, builder.c());
    }

    private PendingIntent m12806a(AppUpdateState appUpdateState, int i) {
        Parcelable intent = new Intent(this.f8287a, AppUpdateActivity.class);
        intent.putExtra("operation_uuid", appUpdateState.operationUuid);
        Intent intent2 = new Intent(this.f8287a, WaitForInitActivity.class);
        intent2.putExtra("next_activity_intent", intent);
        return PendingIntent.getActivity(this.f8287a, i, intent2, 134217728);
    }
}
