package com.facebook.react.uimanager;

import com.facebook.csslayout.CSSAlign;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSFlexDirection;
import com.facebook.csslayout.CSSJustify;
import com.facebook.csslayout.CSSPositionType;
import com.facebook.csslayout.CSSWrap;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: friend_finder_learn_more_manage */
public class LayoutShadowNode extends ReactShadowNode {
    @ReactProp(b = Float.NaN, name = "width")
    public void setWidth(float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        e(f);
    }

    @ReactProp(b = Float.NaN, name = "height")
    public void setHeight(float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        f(f);
    }

    @ReactProp(b = Float.NaN, name = "left")
    public void setLeft(float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        c(f);
    }

    @ReactProp(b = Float.NaN, name = "top")
    public void setTop(float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        a_(f);
    }

    @ReactProp(b = Float.NaN, name = "bottom")
    public void setBottom(float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        b_(f);
    }

    @ReactProp(b = Float.NaN, name = "right")
    public void setRight(float f) {
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        d(f);
    }

    @ReactProp(b = 0.0f, name = "flex")
    public void setFlex(float f) {
        super.setFlex(f);
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(@Nullable String str) {
        a(str == null ? CSSFlexDirection.COLUMN : CSSFlexDirection.valueOf(str.toUpperCase(Locale.US)));
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(@Nullable String str) {
        a(str == null ? CSSWrap.NOWRAP : CSSWrap.valueOf(str.toUpperCase(Locale.US)));
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(@Nullable String str) {
        b(str == null ? CSSAlign.AUTO : CSSAlign.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(@Nullable String str) {
        a(str == null ? CSSAlign.STRETCH : CSSAlign.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(@Nullable String str) {
        a(str == null ? CSSJustify.FLEX_START : CSSJustify.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
    }

    @ReactPropGroup(a = {"margin", "marginVertical", "marginHorizontal", "marginLeft", "marginRight", "marginTop", "marginBottom"}, b = Float.NaN)
    public void setMargins(int i, float f) {
        a(ViewProps.f11882b[i], PixelUtil.m13924a(f));
    }

    @ReactPropGroup(a = {"padding", "paddingVertical", "paddingHorizontal", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom"}, b = Float.NaN)
    public void setPaddings(int i, float f) {
        int i2 = ViewProps.f11882b[i];
        if (!CSSConstants.a(f)) {
            f = PixelUtil.m13924a(f);
        }
        b(i2, f);
    }

    @ReactPropGroup(a = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"}, b = Float.NaN)
    public void setBorderWidths(int i, float f) {
        c(ViewProps.f11881a[i], PixelUtil.m13924a(f));
    }

    @ReactProp(name = "position")
    public void setPosition(@Nullable String str) {
        a(str == null ? CSSPositionType.RELATIVE : CSSPositionType.valueOf(str.toUpperCase(Locale.US)));
    }
}
