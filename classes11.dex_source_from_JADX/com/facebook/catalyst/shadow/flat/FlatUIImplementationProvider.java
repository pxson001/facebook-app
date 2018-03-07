package com.facebook.catalyst.shadow.flat;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIImplementationProvider;
import java.util.List;

/* compiled from: longitudeDelta */
public final class FlatUIImplementationProvider extends UIImplementationProvider {
    public final UIImplementation m7047a(ReactApplicationContext reactApplicationContext, List list) {
        return FlatUIImplementation.m7022a(reactApplicationContext, list);
    }
}
