package com.facebook.react;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.HMRClient;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.JSCHeapCapture.HeapCapture;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.JSTimersExecution;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.AnimationsDebugModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.AppRegistry;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.debug.DebugComponentOwnershipModule;
import com.facebook.react.uimanager.debug.DebugComponentOwnershipModule.RCTDebugComponentOwnership;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: has_disabled_units */
class CoreModulesPackage implements ReactPackage {
    private final ReactInstanceManager f11351a;
    private final DefaultHardwareBackBtnHandler f11352b;
    private final UIImplementationProvider f11353c;

    CoreModulesPackage(ReactInstanceManager reactInstanceManager, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, UIImplementationProvider uIImplementationProvider) {
        this.f11351a = reactInstanceManager;
        this.f11352b = defaultHardwareBackBtnHandler;
        this.f11353c = uIImplementationProvider;
    }

    public final List<NativeModule> mo619a(ReactApplicationContext reactApplicationContext) {
        Systrace.a(8192, "createUIManagerModule");
        try {
            List a = this.f11351a.mo622a(reactApplicationContext);
            NativeModule uIManagerModule = new UIManagerModule(reactApplicationContext, a, this.f11353c.m14027a(reactApplicationContext, a));
            return Arrays.asList(new NativeModule[]{new AnimationsDebugModule(reactApplicationContext, this.f11351a.mo621a().mo718b()), new AndroidInfoModule(), new DeviceEventManagerModule(reactApplicationContext, this.f11352b), new ExceptionsManagerModule(this.f11351a.mo621a()), new Timing(reactApplicationContext), new SourceCodeModule(this.f11351a.mo635h(), this.f11351a.mo621a().mo719c()), uIManagerModule, new JSCHeapCapture(reactApplicationContext), new DebugComponentOwnershipModule(reactApplicationContext)});
        } finally {
            Systrace.a(8192);
        }
    }

    public final List<Class<? extends JavaScriptModule>> mo618a() {
        return Arrays.asList(new Class[]{RCTDeviceEventEmitter.class, JSTimersExecution.class, RCTEventEmitter.class, RCTNativeAppEventEmitter.class, AppRegistry.class, com.facebook.react.bridge.Systrace.class, HMRClient.class, HeapCapture.class, RCTDebugComponentOwnership.class});
    }

    public final List<ViewManager> mo620b(ReactApplicationContext reactApplicationContext) {
        return new ArrayList(0);
    }
}
