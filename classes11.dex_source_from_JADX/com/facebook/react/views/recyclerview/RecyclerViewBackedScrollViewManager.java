package com.facebook.react.views.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollToCommandData;
import com.facebook.react.views.scroll.ScrollEventType;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: eventStatus */
public class RecyclerViewBackedScrollViewManager extends ViewGroupManager<RecyclerViewBackedScrollView> implements ScrollCommandHandler<RecyclerViewBackedScrollView> {
    public final int m8592a(ViewGroup viewGroup) {
        return ((RecyclerViewBackedScrollView) viewGroup).getChildCountFromAdapter();
    }

    public final View m8593a(ViewGroup viewGroup, int i) {
        return ((RecyclerViewBackedScrollView) viewGroup).m11953g(i);
    }

    protected /* synthetic */ View mo220a(ThemedReactContext themedReactContext) {
        return mo221b(themedReactContext);
    }

    public final void m8596a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.a(this, (RecyclerViewBackedScrollView) view, i, readableArray);
    }

    public final void m8597a(ViewGroup viewGroup, View view, int i) {
        ((RecyclerViewBackedScrollView) viewGroup).m11950a(view, i);
    }

    public final void m8598a(Object obj, ScrollToCommandData scrollToCommandData) {
        ((RecyclerViewBackedScrollView) obj).m11951b(scrollToCommandData.b, scrollToCommandData.c);
    }

    public final void m8600b(ViewGroup viewGroup, int i) {
        ((RecyclerViewBackedScrollView) viewGroup).m11952f(i);
    }

    public final String m8595a() {
        return "AndroidRecyclerViewBackedScrollView";
    }

    protected RecyclerViewBackedScrollView mo221b(ThemedReactContext themedReactContext) {
        return new RecyclerViewBackedScrollView(themedReactContext);
    }

    @Nullable
    public final Map m8601h() {
        return MapBuilder.b().a(ScrollEventType.SCROLL.getJSEventName(), MapBuilder.a("registrationName", "onScroll")).a("topContentSizeChange", MapBuilder.a("registrationName", "onContentSizeChange")).a();
    }

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(RecyclerViewBackedScrollView recyclerViewBackedScrollView, boolean z) {
        recyclerViewBackedScrollView.f11504h = z;
    }
}
