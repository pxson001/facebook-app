package com.facebook.fbreact.interfaces;

import com.facebook.react.bridge.JavaScriptModule;
import javax.annotation.Nullable;

/* compiled from: staging_ground_ */
public interface RCTViewEventEmitter extends JavaScriptModule {
    void emit(String str, @Nullable Object obj);
}
