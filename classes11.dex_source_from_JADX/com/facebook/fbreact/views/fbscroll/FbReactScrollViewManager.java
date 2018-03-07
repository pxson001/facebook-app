package com.facebook.fbreact.views.fbscroll;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.FpsListener;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollToCommandData;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: example */
public class FbReactScrollViewManager extends ViewGroupManager<FbReactScrollView> implements ScrollCommandHandler<FbReactScrollView> {
    @Nullable
    private FpsListener f7403a = null;

    public /* synthetic */ View mo218a(ThemedReactContext themedReactContext) {
        return mo219b(themedReactContext);
    }

    public final void m8575a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.a(this, (FbReactScrollView) view, i, readableArray);
    }

    public final void m8576a(Object obj, ScrollToCommandData scrollToCommandData) {
        FbReactScrollView fbReactScrollView = (FbReactScrollView) obj;
        if (scrollToCommandData.c) {
            fbReactScrollView.m8628a(scrollToCommandData.a, scrollToCommandData.b);
        } else {
            fbReactScrollView.scrollTo(scrollToCommandData.a, scrollToCommandData.b);
        }
    }

    public final String m8574a() {
        return "RCTScrollView";
    }

    public FbReactScrollView mo219b(ThemedReactContext themedReactContext) {
        return new FbReactScrollView(themedReactContext, this.f7403a);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(FbReactScrollView fbReactScrollView, boolean z) {
        fbReactScrollView.f7441d = z;
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(FbReactScrollView fbReactScrollView, boolean z) {
        fbReactScrollView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(FbReactScrollView fbReactScrollView, String str) {
        fbReactScrollView.f7447j = str;
    }

    @ReactProp(name = "contentInset")
    public void setContentInset(FbReactScrollView fbReactScrollView, ReadableMap readableMap) {
        if (readableMap == null) {
            fbReactScrollView.setMinScrollDeltaY(0);
            fbReactScrollView.setMaxScrollDeltaY(0);
            return;
        }
        if (readableMap.hasKey("top")) {
            if (readableMap.isNull("top")) {
                fbReactScrollView.setMinScrollDeltaY(0);
            } else {
                fbReactScrollView.setMinScrollDeltaY(-((int) PixelUtil.a(readableMap.getDouble("top"))));
            }
        }
        if (!readableMap.hasKey("bottom")) {
            return;
        }
        if (readableMap.isNull("bottom")) {
            fbReactScrollView.setMaxScrollDeltaY(0);
        } else {
            fbReactScrollView.setMaxScrollDeltaY(-((int) PixelUtil.a(readableMap.getDouble("bottom"))));
        }
    }

    @Nullable
    public final Map<String, Integer> m8578f() {
        return ReactScrollViewCommandHelper.a();
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(FbReactScrollView fbReactScrollView, boolean z) {
        if (z && fbReactScrollView.f7440c == null) {
            fbReactScrollView.f7440c = new Rect();
        }
        fbReactScrollView.f7439b = z;
        fbReactScrollView.m8632a();
    }

    @Nullable
    public final Map m8579h() {
        return ReactScrollViewManager.k();
    }

    @ReactProp(c = 0, customType = "Color", name = "endFillColor")
    public void setBottomFillColor(FbReactScrollView fbReactScrollView, int i) {
        if (i != fbReactScrollView.f7449l) {
            fbReactScrollView.f7449l = i;
            fbReactScrollView.f7448k = new ColorDrawable(fbReactScrollView.f7449l);
        }
    }

    @ReactProp(d = true, name = "scrollEnabled")
    public void setScrollEnabled(FbReactScrollView fbReactScrollView, boolean z) {
        fbReactScrollView.f7445h = z;
    }
}
