package com.facebook.fbreactmodules.perf;

import com.facebook.fbreact.eventsperf.EventsPerfLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import javax.inject.Inject;

/* compiled from: eastBound */
public class FBPerformanceLogger extends BaseJavaModule {
    private final EventsPerfLogger f7510a;

    private static FBPerformanceLogger m8715b(InjectorLike injectorLike) {
        return new FBPerformanceLogger(EventsPerfLogger.m8493a(injectorLike));
    }

    @Inject
    public FBPerformanceLogger(EventsPerfLogger eventsPerfLogger) {
        this.f7510a = eventsPerfLogger;
    }

    public String getName() {
        return "FBPerformanceLogger";
    }

    @ReactMethod
    public void logEvents(ReadableMap readableMap, String str) {
        if ("events_dashboard".equals(str)) {
            this.f7510a.m8501a(readableMap);
        }
    }

    public static FBPerformanceLogger m8714a(InjectorLike injectorLike) {
        return m8715b(injectorLike);
    }
}
