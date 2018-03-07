package com.facebook.react.views.drawer;

import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: SECTION_FULL_FRAME */
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> {

    /* compiled from: SECTION_FULL_FRAME */
    public class DrawerEventEmitter implements DrawerListener {
        private final DrawerLayout f11432a;
        private final EventDispatcher f11433b;

        public DrawerEventEmitter(DrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            this.f11432a = drawerLayout;
            this.f11433b = eventDispatcher;
        }

        public final void m11811a(float f) {
            this.f11433b.a(new DrawerSlideEvent(this.f11432a.getId(), SystemClock.b(), f));
        }

        public final void m11810a() {
            this.f11433b.a(new DrawerOpenedEvent(this.f11432a.getId(), SystemClock.b()));
        }

        public final void m11813b() {
            this.f11433b.a(new DrawerClosedEvent(this.f11432a.getId(), SystemClock.b()));
        }

        public final void m11812a(int i) {
            this.f11433b.a(new DrawerStateChangedEvent(this.f11432a.getId(), SystemClock.b(), i));
        }
    }

    public final void m11817a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactDrawerLayout reactDrawerLayout = (ReactDrawerLayout) view;
        switch (i) {
            case 1:
                reactDrawerLayout.m11803d();
                return;
            case 2:
                reactDrawerLayout.m11804e();
                return;
            default:
                return;
        }
    }

    public final void m11818a(ViewGroup viewGroup, View view, int i) {
        ReactDrawerLayout reactDrawerLayout = (ReactDrawerLayout) viewGroup;
        if (a(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i == 0 || i == 1) {
            reactDrawerLayout.addView(view, i);
            reactDrawerLayout.m11806f();
        } else {
            throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + i + " instead.");
        }
    }

    protected final void m11819a(ThemedReactContext themedReactContext, View view) {
        ReactDrawerLayout reactDrawerLayout = (ReactDrawerLayout) view;
        reactDrawerLayout.t = new DrawerEventEmitter(reactDrawerLayout, ((UIManagerModule) themedReactContext.b(UIManagerModule.class)).a);
    }

    public /* synthetic */ void setElevation(View view, float f) {
        m11814a((ReactDrawerLayout) view, f);
    }

    public final String m11816a() {
        return "AndroidDrawerLayout";
    }

    protected final View m11815a(ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    @ReactProp(c = 8388611, name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, int i) {
        if (8388611 == i || 8388613 == i) {
            reactDrawerLayout.m11805e(i);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Unknown drawerPosition " + i);
    }

    @ReactProp(b = Float.NaN, name = "drawerWidth")
    public void getDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f) {
        reactDrawerLayout.m11807f(Float.isNaN(f) ? -1 : Math.round(PixelUtil.a(f)));
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            throw new JSApplicationIllegalArgumentException("Unknown drawerLockMode " + str);
        }
    }

    public static void m11814a(ReactDrawerLayout reactDrawerLayout, float f) {
        if (VERSION.SDK_INT >= 21) {
            try {
                ReactDrawerLayout.class.getMethod("setDrawerElevation", new Class[]{Float.TYPE}).invoke(reactDrawerLayout, new Object[]{Float.valueOf(PixelUtil.a(f))});
            } catch (Throwable e) {
                FLog.a("React", "setDrawerElevation is not available in this version of the support lib.", e);
            }
        }
    }

    public final boolean m11820e() {
        return true;
    }

    @Nullable
    public final Map<String, Integer> m11821f() {
        return MapBuilder.a("openDrawer", Integer.valueOf(1), "closeDrawer", Integer.valueOf(2));
    }

    @Nullable
    public final Map m11823i() {
        return MapBuilder.a("DrawerPosition", MapBuilder.a("Left", Integer.valueOf(8388611), "Right", Integer.valueOf(8388613)));
    }

    @Nullable
    public final Map m11822h() {
        return MapBuilder.a("topDrawerSlide", MapBuilder.a("registrationName", "onDrawerSlide"), "topDrawerOpened", MapBuilder.a("registrationName", "onDrawerOpen"), "topDrawerClosed", MapBuilder.a("registrationName", "onDrawerClose"), "topDrawerStateChanged", MapBuilder.a("registrationName", "onDrawerStateChanged"));
    }
}
