package com.facebook.react.uimanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: fragment_resume */
public class ViewManagerRegistry {
    private final Map<String, ViewManager> f11866a = new HashMap();

    public ViewManagerRegistry(List<ViewManager> list) {
        for (ViewManager viewManager : list) {
            this.f11866a.put(viewManager.mo744a(), viewManager);
        }
    }

    public final ViewManager m14101a(String str) {
        ViewManager viewManager = (ViewManager) this.f11866a.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        throw new IllegalViewOperationException("No ViewManager defined for class " + str);
    }
}
