package com.facebook.react.views.viewpager;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: RCTStickerInputView */
public class ReactViewPagerManager extends ViewGroupManager<ReactViewPager> {
    public final int m12130a(ViewGroup viewGroup) {
        return ((ReactViewPager) viewGroup).m12127g();
    }

    public final View m12131a(ViewGroup viewGroup, int i) {
        return ((ReactViewPager) viewGroup).m12126c(i);
    }

    public final void m12134a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactViewPager reactViewPager = (ReactViewPager) view;
        Assertions.b(reactViewPager);
        Assertions.b(readableArray);
        switch (i) {
            case 1:
                reactViewPager.m12125b(readableArray.getInt(0), true);
                return;
            case 2:
                reactViewPager.m12125b(readableArray.getInt(0), false);
                return;
            default:
                throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[]{Integer.valueOf(i), getClass().getSimpleName()}));
        }
    }

    public final void m12135a(ViewGroup viewGroup, View view, int i) {
        ((ReactViewPager) viewGroup).m12122a(view, i);
    }

    public final void m12136b(ViewGroup viewGroup, int i) {
        ((ReactViewPager) viewGroup).m12124b(i);
    }

    public final String m12133a() {
        return "AndroidViewPager";
    }

    protected final View m12132a(ThemedReactContext themedReactContext) {
        return new ReactViewPager(themedReactContext);
    }

    public final boolean m12137e() {
        return true;
    }

    public final Map m12139h() {
        return MapBuilder.a("topPageScroll", MapBuilder.a("registrationName", "onPageScroll"), "topPageScrollStateChanged", MapBuilder.a("registrationName", "onPageScrollStateChanged"), "topPageSelected", MapBuilder.a("registrationName", "onPageSelected"));
    }

    public final Map<String, Integer> m12138f() {
        return MapBuilder.a("setPage", Integer.valueOf(1), "setPageWithoutAnimation", Integer.valueOf(2));
    }

    @ReactProp(b = 0.0f, name = "pageMargin")
    public void setPageMargin(ReactViewPager reactViewPager, float f) {
        reactViewPager.setPageMargin((int) PixelUtil.a(f));
    }

    @ReactProp(d = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.f11626c = z;
    }
}
