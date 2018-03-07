package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import java.util.Map;
import javax.annotation.Nullable;

@ReactPropertyHolder
/* compiled from: friend_finder_turn_off_continuous_contacts_upload */
public abstract class ViewManager<T extends View, C extends ReactShadowNode> {
    protected abstract T mo743a(ThemedReactContext themedReactContext);

    public abstract String mo744a();

    public abstract void mo740a(T t, Object obj);

    public abstract Class<? extends C> mo741b();

    public abstract C mo742c();

    public final void m13792a(T t, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.m14098a(this, t, reactStylesDiffMap);
        m13796b(t);
    }

    public final T m13788a(ThemedReactContext themedReactContext, JSResponderHandler jSResponderHandler) {
        View a = mo743a(themedReactContext);
        m13794a(themedReactContext, a);
        if (a instanceof ReactInterceptingViewGroup) {
            ((ReactInterceptingViewGroup) a).setOnInterceptTouchEventListener(jSResponderHandler);
        }
        return a;
    }

    public void m13790a(T t) {
    }

    protected void m13794a(ThemedReactContext themedReactContext, T t) {
    }

    protected void m13796b(T t) {
    }

    public void mo765a(T t, int i, @Nullable ReadableArray readableArray) {
    }

    @Nullable
    public Map<String, Integer> mo769f() {
        return null;
    }

    @Nullable
    public Map<String, Object> m13799g() {
        return null;
    }

    @Nullable
    public Map<String, Object> m13800h() {
        return null;
    }

    @Nullable
    public Map<String, Object> m13801i() {
        return null;
    }

    public final Map<String, String> m13802j() {
        return ViewManagerPropertyUpdater.m14096a(getClass(), mo741b());
    }
}
