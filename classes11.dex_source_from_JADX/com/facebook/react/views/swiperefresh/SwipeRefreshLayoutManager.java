package com.facebook.react.views.swiperefresh;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: RecyclableWrapperView measured but no view attached */
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> {
    protected final void m11963a(final ThemedReactContext themedReactContext, View view) {
        final ReactSwipeRefreshLayout reactSwipeRefreshLayout = (ReactSwipeRefreshLayout) view;
        reactSwipeRefreshLayout.e = new OnRefreshListener(this) {
            final /* synthetic */ SwipeRefreshLayoutManager f11510c;

            public final void m11960a() {
                ((UIManagerModule) themedReactContext.b(UIManagerModule.class)).a.a(new RefreshEvent(reactSwipeRefreshLayout.getId(), SystemClock.b()));
            }
        };
    }

    protected final View m11961a(ThemedReactContext themedReactContext) {
        return new ReactSwipeRefreshLayout(themedReactContext);
    }

    public final String m11962a() {
        return "AndroidSwipeRefreshLayout";
    }

    @ReactProp(d = true, name = "enabled")
    public void setEnabled(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        reactSwipeRefreshLayout.setEnabled(z);
    }

    @ReactProp(customType = "ColorArray", name = "colors")
    public void setColors(ReactSwipeRefreshLayout reactSwipeRefreshLayout, @Nullable ReadableArray readableArray) {
        int i = 0;
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            while (i < readableArray.size()) {
                iArr[i] = readableArray.getInt(i);
                i++;
            }
            reactSwipeRefreshLayout.setColorSchemeColors(iArr);
            return;
        }
        reactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
    }

    @ReactProp(c = 0, customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i) {
        reactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(i);
    }

    @ReactProp(c = 1, name = "size")
    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i) {
        reactSwipeRefreshLayout.setSize(i);
    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        reactSwipeRefreshLayout.setRefreshing(z);
    }

    @ReactProp(b = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(ReactSwipeRefreshLayout reactSwipeRefreshLayout, float f) {
        reactSwipeRefreshLayout.setProgressViewOffset(f);
    }

    @Nullable
    public final Map<String, Object> m11965i() {
        return MapBuilder.a("SIZE", MapBuilder.a("DEFAULT", Integer.valueOf(1), "LARGE", Integer.valueOf(0)));
    }

    public final Map<String, Object> m11964h() {
        return MapBuilder.b().a("topRefresh", MapBuilder.a("registrationName", "onRefresh")).a();
    }
}
