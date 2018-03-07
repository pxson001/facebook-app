package com.facebook.catalyst.shadow.flat;

import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: location_fix */
public class RCTImageView$$PropsSetter implements ShadowNodeSetter<RCTImageView> {
    public final void m7115a(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        RCTImageView rCTImageView = (RCTImageView) reactShadowNode;
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
            case -197243856:
                if (str.equals("fadeDuration")) {
                    z = true;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
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
            case 167841179:
                if (str.equals("shouldNotifyLoadEvents")) {
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
            case 1327599912:
                if (str.equals("tintColor")) {
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
            case 2049757303:
                if (str.equals("resizeMode")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                rCTImageView.setAlignItems(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setAlignSelf(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setBackgroundColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                rCTImageView.setBorderWidths(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setBorderColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                rCTImageView.setBorderWidths(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setBorderRadius(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTImageView.setBorderWidths(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setBorderWidths(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setBorderWidths(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setBottom(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setFadeDuration(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                rCTImageView.setFlex(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                rCTImageView.setFlexDirection(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setFlexWrap(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setHeight(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setJustifyContent(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setLeft(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(6, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(5, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setMargins(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.k = reactStylesDiffMap.a(str, false);
                return;
            case true:
                rCTImageView.setOverflow(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setPaddings(0, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPaddings(6, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPaddings(2, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPaddings(3, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPaddings(4, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPaddings(5, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPaddings(1, reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setPosition(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setResizeMode(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setRight(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setShouldNotifyLoadEvents(reactStylesDiffMap.a(str, false));
                return;
            case true:
                rCTImageView.setSource(reactStylesDiffMap.c(str));
                return;
            case true:
                rCTImageView.setTintColor(reactStylesDiffMap.a(str, 0));
                return;
            case true:
                rCTImageView.setTop(reactStylesDiffMap.a(str, Float.NaN));
                return;
            case true:
                rCTImageView.setWidth(reactStylesDiffMap.a(str, Float.NaN));
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m7114a() {
        Map<String, String> hashMap = new HashMap(42);
        hashMap.put("alignItems", "String");
        hashMap.put("alignSelf", "String");
        hashMap.put("backgroundColor", "number");
        hashMap.put("borderBottomWidth", "number");
        hashMap.put("borderColor", "Color");
        hashMap.put("borderLeftWidth", "number");
        hashMap.put("borderRadius", "number");
        hashMap.put("borderRightWidth", "number");
        hashMap.put("borderTopWidth", "number");
        hashMap.put("borderWidth", "number");
        hashMap.put("bottom", "number");
        hashMap.put("fadeDuration", "number");
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
        hashMap.put("resizeMode", "String");
        hashMap.put("right", "number");
        hashMap.put("shouldNotifyLoadEvents", "boolean");
        hashMap.put("src", "String");
        hashMap.put("tintColor", "number");
        hashMap.put("top", "number");
        hashMap.put("width", "number");
        return hashMap;
    }
}
