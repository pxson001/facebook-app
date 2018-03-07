package com.facebook.react.views.textinput;

import android.view.View;
import com.facebook.react.uimanager.AccessibilityHelper;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RECENT_MENTIONS */
public class ReactTextInputManager$$PropsSetter implements ViewManagerSetter<ReactTextInputManager, ReactEditText> {
    public final void m12081a(ViewManager viewManager, View view, String str, ReactStylesDiffMap reactStylesDiffMap) {
        ReactTextInputManager reactTextInputManager = (ReactTextInputManager) viewManager;
        ReactEditText reactEditText = (ReactEditText) view;
        Integer num = null;
        boolean z = true;
        switch (str.hashCode()) {
            case -1775748605:
                if (str.equals("placeholderTextColor")) {
                    z = true;
                    break;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    z = true;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    z = true;
                    break;
                }
                break;
            case -1702963415:
                if (str.equals("accessibilityComponentType")) {
                    z = false;
                    break;
                }
                break;
            case -1573887368:
                if (str.equals("underlineColorAndroid")) {
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
            case -1339545093:
                if (str.equals("autoCapitalize")) {
                    z = true;
                    break;
                }
                break;
            case -1329887265:
                if (str.equals("numberOfLines")) {
                    z = true;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
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
            case -1206239059:
                if (str.equals("multiline")) {
                    z = true;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals("textAlign")) {
                    z = true;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    z = true;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    z = true;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    z = true;
                    break;
                }
                break;
            case -869116834:
                if (str.equals("blurOnSubmit")) {
                    z = true;
                    break;
                }
                break;
            case -791400086:
                if (str.equals("maxLength")) {
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
            case -700807899:
                if (str.equals("returnKeyLabel")) {
                    z = true;
                    break;
                }
                break;
            case -637043280:
                if (str.equals("selectTextOnFocus")) {
                    z = true;
                    break;
                }
                break;
            case -435916869:
                if (str.equals("autoCorrect")) {
                    z = true;
                    break;
                }
                break;
            case -80891667:
                if (str.equals("renderToHardwareTextureAndroid")) {
                    z = true;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    z = true;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    z = true;
                    break;
                }
                break;
            case 36255470:
                if (str.equals("accessibilityLiveRegion")) {
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
            case 208939969:
                if (str.equals("keyboardType")) {
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
            case 552298621:
                if (str.equals("onSelectionChange")) {
                    z = true;
                    break;
                }
                break;
            case 598246771:
                if (str.equals("placeholder")) {
                    z = true;
                    break;
                }
                break;
            case 746986311:
                if (str.equals("importantForAccessibility")) {
                    z = true;
                    break;
                }
                break;
            case 947486441:
                if (str.equals("returnKeyType")) {
                    z = true;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    z = true;
                    break;
                }
                break;
            case 1146842694:
                if (str.equals("accessibilityLabel")) {
                    z = true;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals("password")) {
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
            case 1602416228:
                if (str.equals("editable")) {
                    z = true;
                    break;
                }
                break;
            case 1869416814:
                if (str.equals("textAlignVertical")) {
                    z = true;
                    break;
                }
                break;
            case 1948272180:
                if (str.equals("decomposedMatrix")) {
                    z = true;
                    break;
                }
                break;
            case 2142299447:
                if (str.equals("selectionColor")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                AccessibilityHelper.a(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactEditText.setContentDescription(reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setAccessibilityLiveRegion(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setAutoCapitalize(reactEditText, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                Boolean valueOf;
                if (!reactStylesDiffMap.b(str)) {
                    valueOf = Boolean.valueOf(reactStylesDiffMap.a(str, false));
                }
                reactTextInputManager.setAutoCorrect(reactEditText, valueOf);
                return;
            case true:
                reactTextInputManager.setBackgroundColor(reactEditText, reactStylesDiffMap.a(str, 0));
                return;
            case true:
                reactEditText.f11584l = reactStylesDiffMap.a(str, true);
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactTextInputManager.setColor(reactEditText, num);
                return;
            case true:
                reactTextInputManager.setDecomposedMatrix(reactEditText, reactStylesDiffMap.e(str));
                return;
            case true:
                reactEditText.setEnabled(reactStylesDiffMap.a(str, true));
                return;
            case true:
                reactTextInputManager.setElevation(reactEditText, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactTextInputManager.setFontFamily(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setFontSize(reactEditText, reactStylesDiffMap.a(str, 14.0f));
                return;
            case true:
                reactTextInputManager.setFontStyle(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setFontWeight(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setImportantForAccessibility(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setKeyboardType(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactTextInputManager.setMaxLength(reactEditText, num);
                return;
            case true:
                reactTextInputManager.setMultiline(reactEditText, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactEditText.setLines(reactStylesDiffMap.a(str, 1));
                return;
            case true:
                reactTextInputManager.setOnSelectionChange(reactEditText, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactEditText.setAlpha(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactTextInputManager.setPassword(reactEditText, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactEditText.setHint(reactStylesDiffMap.c(str));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactTextInputManager.setPlaceholderTextColor(reactEditText, num);
                return;
            case true:
                reactTextInputManager.setRenderToHardwareTexture(reactEditText, reactStylesDiffMap.a(str, false));
                return;
            case true:
                reactTextInputManager.setReturnKeyLabel(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setReturnKeyType(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactEditText.setRotation(reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactEditText.setScaleX(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactEditText.setScaleY(reactStylesDiffMap.a(str, 1.0f));
                return;
            case true:
                reactEditText.setSelectAllOnFocus(reactStylesDiffMap.a(str, false));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactTextInputManager.setSelectionColor(reactEditText, num);
                return;
            case true:
                reactEditText.setTag(reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setTextAlign(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setTextAlignVertical(reactEditText, reactStylesDiffMap.c(str));
                return;
            case true:
                reactTextInputManager.setTransform(reactEditText, reactStylesDiffMap.e(str));
                return;
            case true:
                reactTextInputManager.setTranslateX(reactEditText, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                reactTextInputManager.setTranslateY(reactEditText, reactStylesDiffMap.a(str, 0.0f));
                return;
            case true:
                if (!reactStylesDiffMap.b(str)) {
                    num = Integer.valueOf(reactStylesDiffMap.a(str, 0));
                }
                reactTextInputManager.setUnderlineColor(reactEditText, num);
                return;
            default:
                return;
        }
    }

    public final Map<String, String> m12080a() {
        Map<String, String> hashMap = new HashMap(40);
        hashMap.put("accessibilityComponentType", "String");
        hashMap.put("accessibilityLabel", "String");
        hashMap.put("accessibilityLiveRegion", "String");
        hashMap.put("autoCapitalize", "number");
        hashMap.put("autoCorrect", "boolean");
        hashMap.put("backgroundColor", "Color");
        hashMap.put("blurOnSubmit", "boolean");
        hashMap.put("color", "Color");
        hashMap.put("decomposedMatrix", "Map");
        hashMap.put("editable", "boolean");
        hashMap.put("elevation", "number");
        hashMap.put("fontFamily", "String");
        hashMap.put("fontSize", "number");
        hashMap.put("fontStyle", "String");
        hashMap.put("fontWeight", "String");
        hashMap.put("importantForAccessibility", "String");
        hashMap.put("keyboardType", "String");
        hashMap.put("maxLength", "number");
        hashMap.put("multiline", "boolean");
        hashMap.put("numberOfLines", "number");
        hashMap.put("onSelectionChange", "boolean");
        hashMap.put("opacity", "number");
        hashMap.put("password", "boolean");
        hashMap.put("placeholder", "String");
        hashMap.put("placeholderTextColor", "Color");
        hashMap.put("renderToHardwareTextureAndroid", "boolean");
        hashMap.put("returnKeyLabel", "String");
        hashMap.put("returnKeyType", "String");
        hashMap.put("rotation", "number");
        hashMap.put("scaleX", "number");
        hashMap.put("scaleY", "number");
        hashMap.put("selectTextOnFocus", "boolean");
        hashMap.put("selectionColor", "Color");
        hashMap.put("testID", "String");
        hashMap.put("textAlign", "String");
        hashMap.put("textAlignVertical", "String");
        hashMap.put("transform", "Map");
        hashMap.put("translateX", "number");
        hashMap.put("translateY", "number");
        hashMap.put("underlineColorAndroid", "Color");
        return hashMap;
    }
}
