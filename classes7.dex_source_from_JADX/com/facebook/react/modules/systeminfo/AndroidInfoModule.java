package com.facebook.react.modules.systeminfo;

import android.os.Build.VERSION;
import com.facebook.react.bridge.BaseJavaModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: friendly_names_to_rewrite */
public class AndroidInfoModule extends BaseJavaModule {
    public String getName() {
        return "AndroidConstants";
    }

    @Nullable
    public final Map<String, Object> m13777a() {
        Map hashMap = new HashMap();
        hashMap.put("Version", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("ServerHost", AndroidInfoHelpers.m13774a());
        return hashMap;
    }
}
