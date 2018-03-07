package com.facebook.react.uimanager;

import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.HashMap;
import java.util.Map;

/* compiled from: frame_asset_download_request_submitted */
class UIManagerModuleConstants {
    UIManagerModuleConstants() {
    }

    static Map m14038a() {
        return MapBuilder.m13609b().m13601a("topChange", MapBuilder.m13604a("phasedRegistrationNames", MapBuilder.m13605a("bubbled", "onChange", "captured", "onChangeCapture"))).m13601a("topSelect", MapBuilder.m13604a("phasedRegistrationNames", MapBuilder.m13605a("bubbled", "onSelect", "captured", "onSelectCapture"))).m13601a(TouchEventType.START.getJSEventName(), MapBuilder.m13604a("phasedRegistrationNames", MapBuilder.m13605a("bubbled", "onTouchStart", "captured", "onTouchStartCapture"))).m13601a(TouchEventType.MOVE.getJSEventName(), MapBuilder.m13604a("phasedRegistrationNames", MapBuilder.m13605a("bubbled", "onTouchMove", "captured", "onTouchMoveCapture"))).m13601a(TouchEventType.END.getJSEventName(), MapBuilder.m13604a("phasedRegistrationNames", MapBuilder.m13605a("bubbled", "onTouchEnd", "captured", "onTouchEndCapture"))).m13602a();
    }

    static Map m14039b() {
        return MapBuilder.m13609b().m13601a("topSelectionChange", MapBuilder.m13604a("registrationName", "onSelectionChange")).m13601a("topLoadingStart", MapBuilder.m13604a("registrationName", "onLoadingStart")).m13601a("topLoadingFinish", MapBuilder.m13604a("registrationName", "onLoadingFinish")).m13601a("topLoadingError", MapBuilder.m13604a("registrationName", "onLoadingError")).m13601a("topLayout", MapBuilder.m13604a("registrationName", "onLayout")).m13602a();
    }

    public static Map<String, Object> m14040c() {
        Map hashMap = new HashMap();
        hashMap.put("UIView", MapBuilder.m13604a("ContentMode", MapBuilder.m13606a("ScaleAspectFit", Integer.valueOf(ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ScaleType.CENTER_INSIDE.ordinal()))));
        DisplayMetrics a = DisplayMetricsHolder.m13805a();
        DisplayMetrics b = DisplayMetricsHolder.m13808b();
        hashMap.put("Dimensions", MapBuilder.m13605a("windowPhysicalPixels", MapBuilder.m13608a("width", Integer.valueOf(a.widthPixels), "height", Integer.valueOf(a.heightPixels), "scale", Float.valueOf(a.density), "fontScale", Float.valueOf(a.scaledDensity), "densityDpi", Integer.valueOf(a.densityDpi)), "screenPhysicalPixels", MapBuilder.m13608a("width", Integer.valueOf(b.widthPixels), "height", Integer.valueOf(b.heightPixels), "scale", Float.valueOf(b.density), "fontScale", Float.valueOf(b.scaledDensity), "densityDpi", Integer.valueOf(b.densityDpi))));
        hashMap.put("StyleConstants", MapBuilder.m13604a("PointerEventsValues", MapBuilder.m13607a("none", Integer.valueOf(PointerEvents.NONE.ordinal()), "boxNone", Integer.valueOf(PointerEvents.BOX_NONE.ordinal()), "boxOnly", Integer.valueOf(PointerEvents.BOX_ONLY.ordinal()), "unspecified", Integer.valueOf(PointerEvents.AUTO.ordinal()))));
        hashMap.put("PopupMenu", MapBuilder.m13605a("dismissed", "dismissed", "itemSelected", "itemSelected"));
        hashMap.put("AccessibilityEventTypes", MapBuilder.m13605a("typeWindowStateChanged", Integer.valueOf(32), "typeViewClicked", Integer.valueOf(1)));
        return hashMap;
    }
}
