package com.facebook.appupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: UNKNOWN_SCREEN */
public class DownloadNotificationClickReceiver extends BroadcastReceiver {
    private static final Class<?> f23816a = DownloadNotificationClickReceiver.class;

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1945851666);
        long[] longArrayExtra = intent.getLongArrayExtra("extra_click_download_ids");
        if (longArrayExtra == null || longArrayExtra.length <= 0) {
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -537700827, a);
            return;
        }
        long j = longArrayExtra[0];
        AppUpdateState c;
        if (AppUpdateInjector.b()) {
            AppUpdateOperationFactory e = AppUpdateInjector.a().e();
            e.a();
            for (AppUpdateOperation c2 : e.c()) {
                c = c2.m25801c();
                if (c.downloadId > 0 && c.downloadId == j) {
                    Long.valueOf(j);
                    Intent a2 = m25819a(context, c);
                    a2.setFlags(268435456);
                    context.startActivity(a2);
                    LogUtils.a(intent, 204110888, a);
                    return;
                }
            }
        } else {
            for (AppUpdateState c3 : new AppUpdatePersistenceBackdoor(new AppUpdatePersistence(context)).m25805a()) {
                if (c3.downloadId > 0 && c3.downloadId == j) {
                    Long.valueOf(j);
                    Parcelable a3 = m25819a(context, c3);
                    Intent intent2 = new Intent(context, WaitForInitActivity.class);
                    intent2.putExtra("next_activity_intent", a3);
                    intent2.setFlags(268435456);
                    context.startActivity(intent2);
                    LogUtils.a(intent, -113776401, a);
                    return;
                }
            }
        }
        LogUtils.a(intent, 2014828372, a);
    }

    private static Intent m25819a(Context context, AppUpdateState appUpdateState) {
        Intent intent = new Intent(context, AppUpdateActivity.class);
        intent.putExtra("operation_uuid", appUpdateState.operationUuid);
        return intent;
    }
}
