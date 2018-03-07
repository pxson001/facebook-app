package com.facebook.fbreact.jscperf;

import com.facebook.inject.Assisted;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import javax.inject.Inject;

/* compiled from: extra_in_admin_container_frag */
public class JSCPerfRecorderModule extends ReactContextBaseJavaModule {
    private JSCPerfRecorder f7348a;

    @Inject
    public JSCPerfRecorderModule(@Assisted ReactApplicationContext reactApplicationContext, JSCPerfRecorder jSCPerfRecorder) {
        super(reactApplicationContext);
        this.f7348a = jSCPerfRecorder;
    }

    public String getName() {
        return "JSCPerfRecorder";
    }

    @ReactMethod
    public void recordJSCPerf(ReadableMap readableMap) {
        this.f7348a.m8534a(new JSCPerfRecord(readableMap));
    }
}
