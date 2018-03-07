package com.facebook.catalyst.modules.fbinfo;

import android.content.Context;
import com.facebook.common.manifest.AppBuildInfo;
import com.facebook.common.manifest.AppBuildInfoReader;
import com.facebook.common.manifest.ManifestReader;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import java.util.HashMap;
import java.util.Map;

/* compiled from: marketplaceSearchOther */
public final class BuildInfoModule extends ReactContextBaseJavaModule {
    public BuildInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public final String getName() {
        return "RKBuildInfo";
    }

    public final Map<String, Object> m6884a() {
        Map hashMap = new HashMap();
        Context context = this.a;
        if (AppBuildInfoReader.a == null) {
            AppBuildInfoReader.a = new AppBuildInfoReader(context, new ManifestReader(context)).a();
        }
        AppBuildInfo appBuildInfo = AppBuildInfoReader.a;
        FbRNAppInfoProvider fbRNAppInfoProvider = new FbRNAppInfoProvider(context);
        hashMap.put("appVersion", fbRNAppInfoProvider.f5568c);
        hashMap.put("buildBranchName", appBuildInfo.b);
        hashMap.put("buildRevision", appBuildInfo.a);
        hashMap.put("buildTime", Long.valueOf(appBuildInfo.c / 1000));
        hashMap.put("buildVersion", Integer.valueOf(fbRNAppInfoProvider.f5569d));
        hashMap.put("bundleIdentifier", context.getPackageName());
        return hashMap;
    }
}
