package com.facebook.catalyst.shadow.flat;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: lineHeight */
public class RCTView$$PropsSetter implements ShadowNodeSetter<RCTView> {
    public final void m7205a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        RCTView rCTView = (RCTView) reactShadowNode;
        boolean z = true;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals("borderRightColor")) {
                    z = true;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals("borderRightWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1906103182:
                if (str.equals("marginHorizontal")) {
                    z = true;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    z = true;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals("borderTopColor")) {
                    z = true;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals("borderTopWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    z = true;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals("borderBottomColor")) {
                    z = true;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals("borderBottomWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    z = true;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    z = true;
                    break;
                }
                break;
            case -1063257157:
                if (str.equals("alignItems")) {
                    z = false;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    z = true;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    z = true;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    z = true;
                    break;
                }
                break;
            case -359890155:
                if (str.equals("paddingHorizontal")) {
                    z = true;
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    z = true;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    z = true;
                    break;
                }
                break;
            case -242276144:
                if (str.equals("borderLeftColor")) {
                    z = true;
                    break;
                }
                break;
            case -223992013:
                if (str.equals("borderLeftWidth")) {
                    z = true;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    z = true;
                    break;
                }
                break;
            case 3145721:
                if (str.equals("flex")) {
                    z = true;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    z = true;
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    z = true;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    z = true;
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    z = true;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    z = true;
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    z = true;
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    z = true;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    z = true;
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    z = true;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    z = true;
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    z = true;
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    z = true;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    z = true;
                    break;
                }
                break;
            case 1288688105:
                if (str.equals("onLayout")) {
                    z = true;
                    break;
                }
                break;
            case 1343645351:
                if (str.equals("paddingVertical")) {
                    z = true;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    z = true;
                    break;
                }
                break;
            case 1431421764:
                if (str.equals("marginVertical")) {
                    z = true;
                    break;
                }
                break;
            case 1744216035:
                if (str.equals("flexWrap")) {
                    z = true;
                    break;
                }
                break;
            case 1747724810:
                if (str.equals("nativeBackgroundAndroid")) {
                    z = true;
                    break;
                }
                break;
            case 1767100401:
                if (str.equals("alignSelf")) {
                    z = true;
                    break;
                }
                break;
            case 1860657097:
                if (str.equals("justifyContent")) {
                    z = true;
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                rCTView.setAlignItems(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setAlignSelf(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setBackgroundColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                rCTView.setBorderColor(4, reactStylesDiffMap.a(str, Double.NaN));
                return;
            case true:
                rCTView.setBorderWidths(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setBorderColor(0, reactStylesDiffMap.a(str, Double.NaN));
                return;
            case true:
                rCTView.setBorderColor(1, reactStylesDiffMap.a(str, Double.NaN));
                return;
            case true:
                rCTView.setBorderWidths(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setBorderRadius(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTView.setBorderColor(2, reactStylesDiffMap.a(str, Double.NaN));
                return;
            case true:
                rCTView.setBorderWidths(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setBorderStyle(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setBorderColor(3, reactStylesDiffMap.a(str, Double.NaN));
                return;
            case true:
                rCTView.setBorderWidths(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setBorderWidths(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setBottom(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setFlex(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTView.setFlexDirection(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setFlexWrap(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setHeight(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setJustifyContent(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setLeft(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(6, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(5, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setMargins(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setHotspot(reactStylesDiffMap.e(str));
                return;
            case true:
                rCTView.k = reactStylesDiffMap.a(str, false);
                return;
            case true:
                rCTView.setOverflow(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setPaddings(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setPaddings(6, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setPaddings(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setPaddings(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setPaddings(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setPaddings(5, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setPaddings(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                String c = reactStylesDiffMap.c(str);
                rCTView.ae();
                return;
            case true:
                rCTView.setPosition(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTView.setRight(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setTop(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTView.setWidth(reactStylesDiffMap.a(str, Float.NaN));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7204a() {
        Map<String, String> hashMap = new HashMap(44);
        hashMap.put("alignItems", "String");
        hashMap.put("alignSelf", "String");
        hashMap.put("backgroundColor", "number");
        hashMap.put("borderBottomColor", "Color");
        hashMap.put("borderBottomWidth", "number");
        hashMap.put("borderColor", "Color");
        hashMap.put("borderLeftColor", "Color");
        hashMap.put("borderLeftWidth", "number");
        hashMap.put("borderRadius", "number");
        hashMap.put("borderRightColor", "Color");
        hashMap.put("borderRightWidth", "number");
        hashMap.put("borderStyle", "String");
        hashMap.put("borderTopColor", "Color");
        hashMap.put("borderTopWidth", "number");
        hashMap.put("borderWidth", "number");
        hashMap.put("bottom", "number");
        hashMap.put("flex", "number");
        hashMap.put("flexDirection", "String");
        hashMap.put("flexWrap", "String");
        hashMap.put("height", "number");
        hashMap.put("justifyContent", "String");
        hashMap.put("left", "number");
        hashMap.put("margin", "number");
        hashMap.put("marginBottom", "number");
        hashMap.put("marginHorizontal", "number");
        hashMap.put("marginLeft", "number");
        hashMap.put("marginRight", "number");
        hashMap.put("marginTop", "number");
        hashMap.put("marginVertical", "number");
        hashMap.put("nativeBackgroundAndroid", "Map");
        hashMap.put("onLayout", "boolean");
        hashMap.put("overflow", "String");
        hashMap.put("padding", "number");
        hashMap.put("paddingBottom", "number");
        hashMap.put("paddingHorizontal", "number");
        hashMap.put("paddingLeft", "number");
        hashMap.put("paddingRight", "number");
        hashMap.put("paddingTop", "number");
        hashMap.put("paddingVertical", "number");
        hashMap.put("pointerEvents", "String");
        hashMap.put("position", "String");
        hashMap.put("right", "number");
        hashMap.put("top", "number");
        hashMap.put("width", "number");
        return hashMap;
    }
}
