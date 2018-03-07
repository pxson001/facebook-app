package com.facebook.react;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;

/* compiled from: has_disclaimer */
public interface ReactPackage {
    List<Class<? extends JavaScriptModule>> mo618a();

    List<NativeModule> mo619a(ReactApplicationContext reactApplicationContext);

    List<ViewManager> mo620b(ReactApplicationContext reactApplicationContext);
}
