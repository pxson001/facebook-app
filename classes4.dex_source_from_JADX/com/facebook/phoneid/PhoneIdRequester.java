package com.facebook.phoneid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.device_id.DefaultPhoneIdStore;
import com.facebook.device_id.DefaultPhoneIdUpdatedCallback;
import com.facebook.device_id.FbPhoneIdSyncStatsReporter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: total_pc */
public class PhoneIdRequester {
    private final Context f883a;
    private final DefaultPhoneIdStore f884b;
    private final DefaultPhoneIdUpdatedCallback f885c;
    private final FbPhoneIdSyncStatsReporter f886d;

    public PhoneIdRequester(Context context, DefaultPhoneIdStore defaultPhoneIdStore, DefaultPhoneIdUpdatedCallback defaultPhoneIdUpdatedCallback, FbPhoneIdSyncStatsReporter fbPhoneIdSyncStatsReporter) {
        this.f883a = context;
        this.f884b = defaultPhoneIdStore;
        this.f885c = defaultPhoneIdUpdatedCallback;
        this.f886d = fbPhoneIdSyncStatsReporter;
    }

    public final void m1220a() {
        if (this.f884b.m1206a()) {
            m1217b();
            for (String str : m1218c()) {
                Intent intent = new Intent();
                intent.setAction("com.facebook.GET_PHONE_ID");
                intent.setPackage(str);
                this.f883a.sendOrderedBroadcast(intent, null, new PhoneIdResponseReceiver(this.f884b, this.f885c, this.f886d, new Response(str, this.f884b.m1207b())), null, 1, null, m1219d());
            }
        }
    }

    private boolean m1217b() {
        synchronized (this.f884b) {
            if (this.f884b.m1207b() == null) {
                this.f884b.m1205a(new PhoneId(UUID.randomUUID().toString(), System.currentTimeMillis()));
                return true;
            }
            return false;
        }
    }

    private List<String> m1218c() {
        List<PackageInfo> installedPackages = this.f883a.getPackageManager().getInstalledPackages(0);
        List<String> arrayList = new ArrayList();
        String packageName = this.f883a.getPackageName();
        for (PackageInfo packageInfo : installedPackages) {
            PackageInfo packageInfo2;
            if (!packageInfo2.packageName.equals(packageName)) {
                try {
                    packageInfo2 = this.f883a.getPackageManager().getPackageInfo(packageInfo2.packageName, 64);
                    if (AppAuthHelper.m1223a(packageInfo2)) {
                        arrayList.add(packageInfo2.packageName);
                    }
                } catch (NameNotFoundException e) {
                }
            }
        }
        return arrayList;
    }

    private Bundle m1219d() {
        Parcelable activity = PendingIntent.getActivity(this.f883a, 0, new Intent(), 134217728);
        Bundle bundle = new Bundle();
        bundle.putParcelable("auth", activity);
        return bundle;
    }
}
