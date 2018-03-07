package com.facebook.react.views.art;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SEND */
public class ARTTextShadowNode$$PropsSetter implements ShadowNodeSetter<ARTTextShadowNode> {
    public final void m11798a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ARTTextShadowNode aRTTextShadowNode = (ARTTextShadowNode) reactShadowNode;
        int i = -1;
        switch (str.hashCode()) {
            case -1267206133:
                if (str.equals("opacity")) {
                    i = 4;
                    break;
                }
                break;
            case -891980232:
                if (str.equals("stroke")) {
                    i = 5;
                    break;
                }
                break;
            case -631243286:
                if (str.equals("strokeDash")) {
                    i = 7;
                    break;
                }
                break;
            case -631051390:
                if (str.equals("strokeJoin")) {
                    i = 8;
                    break;
                }
                break;
            case -20363654:
                if (str.equals("strokeCap")) {
                    i = 6;
                    break;
                }
                break;
            case 100:
                if (str.equals("d")) {
                    i = 1;
                    break;
                }
                break;
            case 3143043:
                if (str.equals("fill")) {
                    i = 2;
                    break;
                }
                break;
            case 97692013:
                if (str.equals("frame")) {
                    i = 3;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    i = 10;
                    break;
                }
                break;
            case 1767875043:
                if (str.equals("alignment")) {
                    i = 0;
                    break;
                }
                break;
            case 1924065902:
                if (str.equals("strokeWidth")) {
                    i = 9;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                aRTTextShadowNode.f11429k = reactStylesDiffMap.a(str, 0);
                return;
            case 1:
                aRTTextShadowNode.setShapePath(reactStylesDiffMap.d(str));
                return;
            case 2:
                aRTTextShadowNode.setFill(reactStylesDiffMap.d(str));
                return;
            case 3:
                aRTTextShadowNode.f11428j = reactStylesDiffMap.e(str);
                return;
            case 4:
                aRTTextShadowNode.setOpacity(reactStylesDiffMap.a(str, 1.0f));
                return;
            case 5:
                aRTTextShadowNode.setStroke(reactStylesDiffMap.d(str));
                return;
            case 6:
                aRTTextShadowNode.setStrokeCap(reactStylesDiffMap.a(str, 1));
                return;
            case 7:
                aRTTextShadowNode.setStrokeDash(reactStylesDiffMap.d(str));
                return;
            case 8:
                aRTTextShadowNode.setStrokeJoin(reactStylesDiffMap.a(str, 1));
                return;
            case 9:
                aRTTextShadowNode.setStrokeWidth(reactStylesDiffMap.a(str, 1.0f));
                return;
            case 10:
                aRTTextShadowNode.setTransform(reactStylesDiffMap.d(str));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m11797a() {
        Map<String, String> hashMap = new HashMap(11);
        hashMap.put("alignment", "number");
        hashMap.put("d", "Array");
        hashMap.put("fill", "Array");
        hashMap.put("frame", "Map");
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
