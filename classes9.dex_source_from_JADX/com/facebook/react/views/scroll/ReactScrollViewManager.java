package com.facebook.react.views.scroll;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollToCommandData;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: back_button_clicked */
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView> implements ScrollCommandHandler<ReactScrollView> {
    @Nullable
    private FpsListener f19094a;

    public /* synthetic */ View m19068a(ThemedReactContext themedReactContext) {
        return m19072b(themedReactContext);
    }

    public final void m19070a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.m19058a(this, (ReactScrollView) view, i, readableArray);
    }

    public final void mo770a(Object obj, ScrollToCommandData scrollToCommandData) {
        ReactScrollView reactScrollView = (ReactScrollView) obj;
        if (scrollToCommandData.f19093c) {
            reactScrollView.smoothScrollTo(scrollToCommandData.f19091a, scrollToCommandData.f19092b);
        } else {
            reactScrollView.scrollTo(scrollToCommandData.f19091a, scrollToCommandData.f19092b);
        }
    }

    public ReactScrollViewManager() {
        this(null);
    }

    private ReactScrollViewManager(@Nullable FpsListener fpsListener) {
        this.f19094a = null;
        this.f19094a = fpsListener;
    }

    public final String m19069a() {
        return "RCTScrollView";
    }

    public ReactScrollView m19072b(ThemedReactContext themedReactContext) {
        return new ReactScrollView(themedReactContext, this.f19094a);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.f19086h = z;
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactScrollView reactScrollView, String str) {
        reactScrollView.f19088j = str;
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setRemoveClippedSubviews(z);
    }

    @ReactProp(d = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.f19085g = z;
    }

    @ReactProp(c = 0, customType = "Color", name = "endFillColor")
    public void setBottomFillColor(ReactScrollView reactScrollView, int i) {
        reactScrollView.setEndFillColor(i);
    }

    @Nullable
    public final Map<String, Integer> m19073f() {
        return ReactScrollViewCommandHelper.m19057a();
    }

    @Nullable
    public final Map m19074h() {
        return m19067k();
    }

    public static Map m19067k() {
        return MapBuilder.b().a(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.a("registrationName", "onScroll")).a(ScrollEventType.BEGIN_DRAG.getJSEventName(), MapBuilder.a("registrationName", "onScrollBeginDrag")).a(ScrollEventType.END_DRAG.getJSEventName(), MapBuilder.a("registrationName", "onScrollEndDrag")).a(ScrollEventType.ANIMATION_END.getJSEventName(), MapBuilder.a("registrationName", "onScrollAnimationEnd")).a(ScrollEventType.MOMENTUM_BEGIN.getJSEventName(), MapBuilder.a("registrationName", "onMomentumScrollBegin")).a(ScrollEventType.MOMENTUM_END.getJSEventName(), MapBuilder.a("registrationName", "onMomentumScrollEnd")).a();
    }
}
