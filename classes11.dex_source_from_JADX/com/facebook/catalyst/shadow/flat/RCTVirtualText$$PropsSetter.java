package com.facebook.catalyst.shadow.flat;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: like_page */
public class RCTVirtualText$$PropsSetter implements ShadowNodeSetter<RCTVirtualText> {
    public final void m7218a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        RCTVirtualText rCTVirtualText = (RCTVirtualText) reactShadowNode;
        boolean z = true;
        switch (str.hashCode()) {
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
            case -1550943582:
                if (str.equals("fontStyle")) {
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
            case -1290574193:
                if (str.equals("borderBottomWidth")) {
                    z = true;
                    break;
                }
                break;
            case -1224696685:
                if (str.equals("fontFamily")) {
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
            case -734428249:
                if (str.equals("fontWeight")) {
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
            case -289173127:
                if (str.equals("marginBottom")) {
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
            case 94842723:
                if (str.equals("color")) {
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
            case 365601008:
                if (str.equals("fontSize")) {
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
            case 578735798:
                if (str.equals("textShadowColor")) {
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
            case 1096003488:
                if (str.equals("textShadowOffset")) {
                    z = true;
                    break;
                }
                break;
            case 1177204639:
                if (str.equals("textShadowRadius")) {
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
                rCTVirtualText.setAlignItems(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setAlignSelf(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setBackgroundColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                rCTVirtualText.setBorderWidths(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setBorderWidths(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setBorderWidths(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setBorderWidths(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setBorderWidths(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setBottom(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setColor(reactStylesDiffMap.a(str, Double.NaN));
                return;
            case true:
                rCTVirtualText.setFlex(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTVirtualText.setFlexDirection(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setFlexWrap(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setFontFamily(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setFontSize(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setFontStyle(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setFontWeight(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setHeight(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setJustifyContent(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setLeft(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(6, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(5, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setMargins(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.k = reactStylesDiffMap.a(str, false);
                return;
            case true:
                rCTVirtualText.setOverflow(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setPaddings(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPaddings(6, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPaddings(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPaddings(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPaddings(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPaddings(5, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPaddings(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setPosition(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTVirtualText.setRight(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setTextShadowColor(reactStylesDiffMap.a(str, 1426063360));
                return;
            case true:
                rCTVirtualText.setTextShadowOffset(reactStylesDiffMap.e(str));
                return;
            case true:
                rCTVirtualText.setTextShadowRadius(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTVirtualText.setTop(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTVirtualText.setWidth(reactStylesDiffMap.a(str, Float.NaN));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7217a() {
        Map<String, String> hashMap = new HashMap(43);
        hashMap.put("alignItems", "String");
        hashMap.put("alignSelf", "String");
        hashMap.put("backgroundColor", "number");
        hashMap.put("borderBottomWidth", "number");
        hashMap.put("borderLeftWidth", "number");
        hashMap.put("borderRightWidth", "number");
        hashMap.put("borderTopWidth", "number");
        hashMap.put("borderWidth", "number");
        hashMap.put("bottom", "number");
        hashMap.put("color", "number");
        hashMap.put("flex", "number");
        hashMap.put("flexDirection", "String");
        hashMap.put("flexWrap", "String");
        hashMap.put("fontFamily", "String");
        hashMap.put("fontSize", "number");
        hashMap.put("fontStyle", "String");
        hashMap.put("fontWeight", "String");
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
        hashMap.put("onLayout", "boolean");
        hashMap.put("overflow", "String");
        hashMap.put("padding", "number");
        hashMap.put("paddingBottom", "number");
        hashMap.put("paddingHorizontal", "number");
        hashMap.put("paddingLeft", "number");
        hashMap.put("paddingRight", "number");
        hashMap.put("paddingTop", "number");
        hashMap.put("paddingVertical", "number");
        hashMap.put("position", "String");
        hashMap.put("right", "number");
        hashMap.put("textShadowColor", "Color");
        hashMap.put("textShadowOffset", "Map");
        hashMap.put("textShadowRadius", "number");
        hashMap.put("top", "number");
        hashMap.put("width", "number");
        return hashMap;
    }
}
