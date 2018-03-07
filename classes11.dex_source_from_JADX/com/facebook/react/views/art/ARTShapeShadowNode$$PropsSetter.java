package com.facebook.react.views.art;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SERVICE_ITEM */
public class ARTShapeShadowNode$$PropsSetter implements ShadowNodeSetter<ARTShapeShadowNode> {
    public final void m11778a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ARTShapeShadowNode aRTShapeShadowNode = (ARTShapeShadowNode) reactShadowNode;
        int i = -1;
        switch (str.hashCode()) {
            case -1267206133:
                if (str.equals("opacity")) {
                    i = 2;
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    i = 3;
                    break;
                }
                break;
            case -631243286:
                if (str.equals("strokeDash")) {
                    i = 5;
                    break;
                }
                break;
            case -631051390:
                if (str.equals("strokeJoin")) {
                    i = 6;
                    break;
                }
                break;
            case -20363654:
                if (str.equals("strokeCap")) {
                    i = 4;
                    break;
                }
                break;
            case 100:
                if (str.equals("d")) {
                    i = 0;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    i = 1;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    i = 8;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    i = 7;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                aRTShapeShadowNode.setShapePath(reactStylesDiffMap.d(str));
                return;
            case 1:
                aRTShapeShadowNode.setFill(reactStylesDiffMap.d(str));
                return;
            case 2:
                aRTShapeShadowNode.setOpacity(reactStylesDiffMap.a(str, 1.0f));
                return;
            case 3:
                aRTShapeShadowNode.setStroke(reactStylesDiffMap.d(str));
                return;
            case 4:
                aRTShapeShadowNode.setStrokeCap(reactStylesDiffMap.a(str, 1));
                return;
            case 5:
                aRTShapeShadowNode.setStrokeDash(reactStylesDiffMap.d(str));
                return;
            case 6:
                aRTShapeShadowNode.setStrokeJoin(reactStylesDiffMap.a(str, 1));
                return;
            case 7:
                aRTShapeShadowNode.setStrokeWidth(reactStylesDiffMap.a(str, 1.0f));
                return;
            case 8:
                aRTShapeShadowNode.setTransform(reactStylesDiffMap.d(str));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11777a() {
        Map<String, String> hashMap = new HashMap(9);
        hashMap.put("d", "Array");
        hashMap.put("fill", "Array");
        hashMap.put("opacity", "number");
        hashMap.put("stroke", "Array");
        hashMap.put("strokeCap", "number");
        hashMap.put("strokeDash", "Array");
        hashMap.put("strokeJoin", "number");
        hashMap.put("strokeWidth", "number");
        hashMap.put("transform", "Array");
        return hashMap;
    }
}
