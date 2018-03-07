package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.SupportsWebWorkers;
import com.facebook.react.bridge.WritableArray;

@SupportsWebWorkers
/* compiled from: from_ridge_button */
public interface JSTimersExecution extends JavaScriptModule {
    void callTimers(WritableArray writableArray);
}
