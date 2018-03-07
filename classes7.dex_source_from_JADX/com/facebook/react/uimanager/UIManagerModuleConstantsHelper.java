package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import java.util.List;
import java.util.Map;

/* compiled from: frame_asset_download_request_failure */
class UIManagerModuleConstantsHelper {
    UIManagerModuleConstantsHelper() {
    }

    static Map<String, Object> m14041a(List<ViewManager> list) {
        Map<String, Object> c = UIManagerModuleConstants.m14040c();
        Map a = UIManagerModuleConstants.m14038a();
        Map b = UIManagerModuleConstants.m14039b();
        for (ViewManager viewManager : list) {
            Map g = viewManager.m13799g();
            if (g != null) {
                m14042a(a, g);
            }
            g = viewManager.m13800h();
            if (g != null) {
                m14042a(b, g);
            }
            g = MapBuilder.m13603a();
            Map i = viewManager.m13801i();
            if (i != null) {
                g.put("Constants", i);
            }
            i = viewManager.mo769f();
            if (i != null) {
                g.put("Commands", i);
            }
            i = viewManager.m13802j();
            if (!i.isEmpty()) {
                g.put("NativeProps", i);
            }
            if (!g.isEmpty()) {
                c.put(viewManager.mo744a(), g);
            }
        }
        c.put("customBubblingEventTypes", a);
        c.put("customDirectEventTypes", b);
        return c;
    }

    private static void m14042a(Map map, Map map2) {
        for (Object next : map2.keySet()) {
            Object obj = map2.get(next);
            Object obj2 = map.get(next);
            if (obj2 != null && (obj instanceof Map) && (obj2 instanceof Map)) {
                m14042a((Map) obj2, (Map) obj);
            } else {
                map.put(next, obj);
            }
        }
    }
}
