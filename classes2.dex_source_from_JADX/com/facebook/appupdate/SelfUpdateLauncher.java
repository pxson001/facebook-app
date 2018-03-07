package com.facebook.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.facebook.selfupdate.AppUpdateLoggerFbImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;
import org.json.JSONObject;

/* compiled from: ranking_model */
public class SelfUpdateLauncher {
    private static final Class<?> f8266a = SelfUpdateLauncher.class;
    private final AppUpdateLoggerFbImpl f8267b;
    private final AppUpdateOperationFactory f8268c;
    public final SharedPreferences f8269d;
    private final Provider<Long> f8270e;

    public SelfUpdateLauncher(AppUpdateLogger appUpdateLogger, AppUpdateOperationFactory appUpdateOperationFactory, SharedPreferences sharedPreferences, Provider<Long> provider) {
        this.f8267b = appUpdateLogger;
        this.f8268c = appUpdateOperationFactory;
        this.f8269d = sharedPreferences;
        this.f8270e = provider;
    }

    public final void m12791a(ReleaseInfo releaseInfo, boolean z, boolean z2) {
        Preconditions.m12789b();
        JSONObject jSONObject = new JSONObject();
        Utils.a(jSONObject, "release_info", releaseInfo.a());
        Utils.a(jSONObject, "background_mode", z);
        AppUpdateOperation a = m12790a();
        Utils.a(jSONObject, "existing_operation", String.valueOf(a));
        if (a == null) {
            this.f8268c.m12796a(releaseInfo, z, true, z2);
            Utils.a(jSONObject, "operation_stated", true);
        } else if (a.c().releaseInfo.versionCode < releaseInfo.versionCode) {
            this.f8268c.m12796a(releaseInfo, z, true, z2);
            Utils.a(jSONObject, "operation_stated", true);
            if (!z) {
                this.f8268c.m12799a(a);
            }
        } else {
            Utils.a(jSONObject, "operation_stated", false);
        }
        this.f8267b.m12752a("selfupdate_starting_operation", jSONObject);
    }

    public final boolean m12792a(Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f8269d.getLong("selfupdate_launch_ts", -1);
        long longValue = ((Long) this.f8270e.get()).longValue();
        if (longValue < 0 || currentTimeMillis - j < longValue) {
            Long.valueOf(longValue - (currentTimeMillis - j));
            return false;
        }
        this.f8268c.m12798a();
        this.f8268c.m12800b();
        AppUpdateOperation a = m12790a();
        if (a == null || a.c().operationState != 4) {
            return false;
        }
        Intent intent = new Intent(activity, AppUpdateActivity.class);
        intent.putExtra("operation_uuid", a.c().operationUuid);
        activity.startActivity(intent);
        this.f8269d.edit().putLong("selfupdate_launch_ts", currentTimeMillis).apply();
        this.f8267b.m12752a("selfupdatelauncher_started_activity", a.c().releaseInfo.a());
        return true;
    }

    @Nullable
    private AppUpdateOperation m12790a() {
        List<AppUpdateOperation> arrayList = new ArrayList();
        AppUpdateOperation appUpdateOperation = null;
        int i = 0;
        for (AppUpdateOperation appUpdateOperation2 : this.f8268c.m12801c()) {
            AppUpdateOperation appUpdateOperation3;
            int i2;
            AppUpdateState c = appUpdateOperation2.c();
            if (c.isSelfUpdate) {
                arrayList.add(appUpdateOperation2);
                if (c.releaseInfo.versionCode > i) {
                    appUpdateOperation3 = appUpdateOperation2;
                    i2 = c.releaseInfo.versionCode;
                    appUpdateOperation = appUpdateOperation3;
                    i = i2;
                }
            }
            i2 = i;
            appUpdateOperation3 = appUpdateOperation;
            appUpdateOperation = appUpdateOperation3;
            i = i2;
        }
        for (AppUpdateOperation appUpdateOperation22 : arrayList) {
            if (appUpdateOperation22 != appUpdateOperation) {
                this.f8268c.m12799a(appUpdateOperation22);
            }
        }
        return appUpdateOperation;
    }
}
