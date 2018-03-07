package com.facebook.react.views.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RCTText */
public class ReactViewPager extends ViewPager {
    public final EventDispatcher f11624a;
    public boolean f11625b;
    public boolean f11626c = true;

    /* compiled from: RCTText */
    class Adapter extends PagerAdapter {
        final /* synthetic */ ReactViewPager f11621a;
        private List<View> f11622b;

        public Adapter(ReactViewPager reactViewPager) {
            this.f11621a = reactViewPager;
            this.f11622b = new ArrayList();
        }

        final void m12115b(View view, int i) {
            this.f11622b.add(i, view);
            kR_();
            this.f11621a.setOffscreenPageLimit(this.f11622b.size());
        }

        final void m12110a(int i) {
            this.f11622b.remove(i);
            kR_();
            this.f11621a.setOffscreenPageLimit(this.f11622b.size());
        }

        final View m12114b(int i) {
            return (View) this.f11622b.get(i);
        }

        public final int m12113b() {
            return this.f11622b.size();
        }

        public final Object m12109a(ViewGroup viewGroup, int i) {
            View view = (View) this.f11622b.get(i);
            viewGroup.addView(view, 0, this.f11621a.generateDefaultLayoutParams());
            return view;
        }

        public final void m12111a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) this.f11622b.get(i));
        }

        public final boolean m12112a(View view, Object obj) {
            return view == obj;
        }
    }

    /* compiled from: RCTText */
    class PageChangeListener implements OnPageChangeListener {
        final /* synthetic */ ReactViewPager f11623a;

        public PageChangeListener(ReactViewPager reactViewPager) {
            this.f11623a = reactViewPager;
        }

        public final void m12116a(int i, float f, int i2) {
            this.f11623a.f11624a.a(new PageScrollEvent(this.f11623a.getId(), SystemClock.b(), i, f));
        }

        public final void e_(int i) {
            if (!this.f11623a.f11625b) {
                this.f11623a.f11624a.a(new PageSelectedEvent(this.f11623a.getId(), SystemClock.b(), i));
            }
        }

        public final void m12117b(int i) {
            String str;
            switch (i) {
                case 0:
                    str = "idle";
                    break;
                case 1:
                    str = "dragging";
                    break;
                case 2:
                    str = "settling";
                    break;
                default:
                    throw new IllegalStateException("Unsupported pageScrollState");
            }
            this.f11623a.f11624a.a(new PageScrollStateChangedEvent(this.f11623a.getId(), SystemClock.b(), str));
        }
    }

    public /* synthetic */ PagerAdapter getAdapter() {
        return m12121h();
    }

    public ReactViewPager(ReactContext reactContext) {
        super(reactContext);
        this.f11624a = ((UIManagerModule) reactContext.b(UIManagerModule.class)).a;
        this.f11625b = false;
        setOnPageChangeListener(new PageChangeListener(this));
        setAdapter(new Adapter(this));
    }

    private Adapter m12121h() {
        return (Adapter) super.getAdapter();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f11626c || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -937125185);
        if (this.f11626c) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(-2072403471, a);
            return onTouchEvent;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 2082898113, a);
        return false;
    }

    public final void m12125b(int i, boolean z) {
        this.f11625b = true;
        a(i, z);
        this.f11625b = false;
    }

    public final void m12123a(boolean z) {
        this.f11626c = z;
    }

    final void m12122a(View view, int i) {
        m12121h().m12115b(view, i);
    }

    final void m12124b(int i) {
        m12121h().m12110a(i);
    }

    final int m12127g() {
        return m12121h().m12113b();
    }

    final View m12126c(int i) {
        return m12121h().m12114b(i);
    }
}
