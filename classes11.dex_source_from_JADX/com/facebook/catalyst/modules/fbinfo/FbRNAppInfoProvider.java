package com.facebook.catalyst.modules.fbinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.autoupdater.OverTheAirBundleInfo;

/* compiled from: marketplaceSearch */
public class FbRNAppInfoProvider {
    private String f5566a = "";
    private String f5567b = "";
    public String f5568c = "";
    public int f5569d = 0;
    private final int f5570e;

    public FbRNAppInfoProvider(Context context) {
        String packageName = context.getPackageName();
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("app_id", "string", packageName);
        if (identifier != 0) {
            this.f5566a = resources.getString(identifier);
        }
        identifier = resources.getIdentifier("fb_mobile_app_name", "string", packageName);
        if (identifier != 0) {
            this.f5567b = resources.getString(identifier);
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            this.f5568c = packageInfo.versionName;
            this.f5569d = packageInfo.versionCode;
        } catch (Throwable e) {
            FLog.a("React", "Failed to find PackageInfo for current App : " + packageName, e);
        }
        int a = new OverTheAirBundleInfo(context).m8466a();
        if (a == 0) {
            a = this.f5569d;
        }
        this.f5570e = a;
    }
}
