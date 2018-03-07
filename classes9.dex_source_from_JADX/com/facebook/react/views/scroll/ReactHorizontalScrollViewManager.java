package com.facebook.react.views.scroll;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollToCommandData;
import javax.annotation.Nullable;

/* compiled from: back_facing */
public class ReactHorizontalScrollViewManager extends ViewGroupManager<ReactHorizontalScrollView> implements ScrollCommandHandler<ReactHorizontalScrollView> {
    @Nullable
    private FpsListener f19077a;

    public final void m19046a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.m19058a(this, (ReactHorizontalScrollView) view, i, readableArray);
    }

    public final void mo770a(Object obj, ScrollToCommandData scrollToCommandData) {
        ReactHorizontalScrollView reactHorizontalScrollView = (ReactHorizontalScrollView) obj;
        if (scrollToCommandData.f19093c) {
            reactHorizontalScrollView.smoothScrollTo(scrollToCommandData.f19091a, scrollToCommandData.f19092b);
        } else {
            reactHorizontalScrollView.scrollTo(scrollToCommandData.f19091a, scrollToCommandData.f19092b);
        }
    }

    public ReactHorizontalScrollViewManager() {
        this(null);
    }

    private ReactHorizontalScrollViewManager(@Nullable FpsListener fpsListener) {
        this.f19077a = null;
        this.f19077a = fpsListener;
    }

    public final String m19045a() {
        return "AndroidHorizontalScrollView";
    }

    public final View m19044a(ThemedReactContext themedReactContext) {
        return new ReactHorizontalScrollView(themedReactContext, this.f19077a);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.f19074k = str;
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setRemoveClippedSubviews(z);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.f19072i = z;
    }

    @ReactProp(d = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.f19071h = z;
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.f19068e = z;
    }

    @ReactProp(c = 0, customType = "Color", name = "endFillColor")
    public void setBottomFillColor(ReactHorizontalScrollView reactHorizontalScrollView, int i) {
        reactHorizontalScrollView.setEndFillColor(i);
    }
}
