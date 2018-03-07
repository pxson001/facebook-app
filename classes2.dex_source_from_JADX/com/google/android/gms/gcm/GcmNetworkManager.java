package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.iid.zzc;
import java.util.List;

public class GcmNetworkManager {
    private static GcmNetworkManager f3653a;
    private Context f3654b;
    private final PendingIntent f3655c = PendingIntent.getBroadcast(this.f3654b, 0, new Intent(), 0);

    private GcmNetworkManager(Context context) {
        this.f3654b = context;
    }

    private Intent m5925a() {
        int b = GoogleCloudMessaging.m5940b(this.f3654b);
        if (b < GoogleCloudMessaging.f3667a) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + b);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(zzc.m5941a(this.f3654b));
        intent.putExtra("app", this.f3655c);
        return intent;
    }

    public static GcmNetworkManager m5926a(Context context) {
        if (f3653a == null) {
            f3653a = new GcmNetworkManager(context.getApplicationContext());
        }
        return f3653a;
    }

    static void m5927a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private void m5928b(String str) {
        boolean z = true;
        zzx.m105a((Object) str, (Object) "GcmTaskService must not be null.");
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
        intent.setPackage(this.f3654b.getPackageName());
        List<ResolveInfo> queryIntentServices = this.f3654b.getPackageManager().queryIntentServices(intent, 0);
        boolean z2 = (queryIntentServices == null || queryIntentServices.size() == 0) ? false : true;
        zzx.m113b(z2, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo.name.equals(str)) {
                break;
            }
        }
        z = false;
        zzx.m113b(z, "The GcmTaskService class you provided " + str + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.");
    }

    public final void m5929a(Task task) {
        m5928b(task.f3656a);
        Intent a = m5925a();
        if (a != null) {
            Bundle extras = a.getExtras();
            extras.putString("scheduler_action", "SCHEDULE_TASK");
            task.mo778a(extras);
            a.putExtras(extras);
            this.f3654b.sendBroadcast(a);
        }
    }

    public final void m5930a(Class<? extends GcmTaskService> cls) {
        m5928b(cls.getName());
        Intent a = m5925a();
        if (a != null) {
            a.putExtra("scheduler_action", "CANCEL_ALL");
            a.putExtra("component", new ComponentName(this.f3654b, cls));
            this.f3654b.sendBroadcast(a);
        }
    }

    public final void m5931a(String str, Class<? extends GcmTaskService> cls) {
        m5927a(str);
        m5928b(cls.getName());
        Intent a = m5925a();
        if (a != null) {
            a.putExtra("scheduler_action", "CANCEL_TASK");
            a.putExtra("tag", str);
            a.putExtra("component", new ComponentName(this.f3654b, cls));
            this.f3654b.sendBroadcast(a);
        }
    }
}
