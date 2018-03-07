package com.facebook.react.modules.debug;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: fromControlX */
public class SourceCodeModule extends BaseJavaModule {
    private final String f11678a;
    private final String f11679b;

    public SourceCodeModule(String str, String str2) {
        this.f11678a = str2;
        this.f11679b = str;
    }

    public String getName() {
        return "RCTSourceCode";
    }

    @ReactMethod
    public void getScriptText(Promise promise) {
        Object writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("fullSourceMappingURL", this.f11678a);
        promise.mo663a(writableNativeMap);
    }

    @Nullable
    public final Map<String, Object> m13744a() {
        Map hashMap = new HashMap();
        hashMap.put("scriptURL", this.f11679b);
        return hashMap;
    }
}
