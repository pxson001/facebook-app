package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;

/* compiled from: frame_delta_received */
public class UIImplementationProvider {
    public UIImplementation m14027a(ReactApplicationContext reactApplicationContext, List<ViewManager> list) {
        return new UIImplementation(reactApplicationContext, (List) list);
    }
}
