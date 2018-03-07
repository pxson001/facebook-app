package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

/* compiled from: for_sale_categories */
public interface RCTEventEmitter extends JavaScriptModule {
    void receiveEvent(int i, String str, @Nullable WritableMap writableMap);

    void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2);
}
