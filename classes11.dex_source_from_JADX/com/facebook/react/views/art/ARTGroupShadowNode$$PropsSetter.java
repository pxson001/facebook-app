package com.facebook.react.views.art;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SHARE_MESSAGE_SHORTLINK */
public class ARTGroupShadowNode$$PropsSetter implements ShadowNodeSetter<ARTGroupShadowNode> {
    public final void m11758a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ARTGroupShadowNode aRTGroupShadowNode = (ARTGroupShadowNode) reactShadowNode;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1267206133:
                if (str.equals("opacity")) {
                    obj = 1;
                    break;
                }
                break;
            case 918617282:
                if (str.equals("clipping")) {
                    obj = null;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                aRTGroupShadowNode.setClipping(reactStylesDiffMap.d(str));
                return;
            case 1:
                aRTGroupShadowNode.setOpacity(reactStylesDiffMap.a(str, 1.0f));
                return;
            case 2:
                aRTGroupShadowNode.setTransform(reactStylesDiffMap.d(str));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11757a() {
        Map<String, String> hashMap = new HashMap(3);
        hashMap.put("clipping", "Array");
        hashMap.put("opacity", "number");
        hashMap.put("transform", "Array");
        return hashMap;
    }
}
