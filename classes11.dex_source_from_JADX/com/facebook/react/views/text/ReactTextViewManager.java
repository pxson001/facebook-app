package com.facebook.react.views.text;

import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: ReactNative */
public class ReactTextViewManager extends BaseViewManager<ReactTextView, ReactTextShadowNode> {
    public /* synthetic */ View mo308a(ThemedReactContext themedReactContext) {
        return mo312b(themedReactContext);
    }

    public /* synthetic */ ReactShadowNode mo314c() {
        return mo315d();
    }

    public String mo309a() {
        return "RCTText";
    }

    public ReactTextView mo312b(ThemedReactContext themedReactContext) {
        return new ReactTextView(themedReactContext);
    }

    @ReactProp(c = Integer.MAX_VALUE, name = "numberOfLines")
    public void setNumberOfLines(ReactTextView reactTextView, int i) {
        reactTextView.setMaxLines(i);
        reactTextView.setEllipsize(TruncateAt.END);
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactTextView.setGravityHorizontal(0);
        } else if ("left".equals(str)) {
            reactTextView.setGravityHorizontal(3);
        } else if ("right".equals(str)) {
            reactTextView.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactTextView.setGravityHorizontal(1);
        } else if ("justify".equals(str)) {
            reactTextView.setGravityHorizontal(3);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactTextView reactTextView, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactTextView.setGravityVertical(0);
        } else if ("top".equals(str)) {
            reactTextView.setGravityVertical(48);
        } else if ("bottom".equals(str)) {
            reactTextView.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactTextView.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
        }
    }

    @ReactProp(b = Float.NaN, name = "lineHeight")
    public void setLineHeight(ReactTextView reactTextView, float f) {
        if (Float.isNaN(f)) {
            reactTextView.setLineSpacing(0.0f, 1.0f);
        } else {
            reactTextView.setLineSpacing(PixelUtil.b(f), 0.0f);
        }
    }

    public void mo311a(ReactTextView reactTextView, Object obj) {
        ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
        if (reactTextUpdate.f11548c) {
            TextInlineImageSpan.m12020a(reactTextUpdate.f11546a, reactTextView);
        }
        reactTextView.setText(reactTextUpdate);
    }

    public ReactTextShadowNode mo315d() {
        return new ReactTextShadowNode(false);
    }

    public Class<ReactTextShadowNode> mo313b() {
        return ReactTextShadowNode.class;
    }
}
