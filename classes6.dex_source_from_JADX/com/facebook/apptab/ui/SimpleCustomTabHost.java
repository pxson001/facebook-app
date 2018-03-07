package com.facebook.apptab.ui;

import android.app.LocalActivityManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* compiled from: progress */
public class SimpleCustomTabHost extends CustomFrameLayout implements OnTouchModeChangeListener {
    protected int f7220a;
    protected LocalActivityManager f7221b;
    public TabWidget f7222c;
    public FrameLayout f7223d;
    public List<TabSpec> f7224e;
    private View f7225f;
    public OnTabChangeListener f7226g;
    private OnKeyListener f7227h;

    /* compiled from: progress */
    public interface OnTabChangeListener {
        void mo897a(String str);
    }

    /* compiled from: progress */
    class C04251 implements OnKeyListener {
        final /* synthetic */ SimpleCustomTabHost f7237a;

        C04251(SimpleCustomTabHost simpleCustomTabHost) {
            this.f7237a = simpleCustomTabHost;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 66:
                    return false;
                default:
                    this.f7237a.f7223d.requestFocus(2);
                    return this.f7237a.f7223d.dispatchKeyEvent(keyEvent);
            }
        }
    }

    /* compiled from: progress */
    class C04262 implements InvocationHandler {
        final /* synthetic */ SimpleCustomTabHost f7238a;

        C04262(SimpleCustomTabHost simpleCustomTabHost) {
            this.f7238a = simpleCustomTabHost;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            int intValue = ((Integer) objArr[0]).intValue();
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            this.f7238a.setCurrentTab(intValue);
            if (booleanValue) {
                this.f7238a.f7223d.requestFocus(2);
            }
            return null;
        }
    }

    /* compiled from: progress */
    interface ContentStrategy {
        View m10366a();
    }

    /* compiled from: progress */
    public class TabSpec {
        public String f7239a;
        public ContentStrategy f7240b;
    }

    public void mo896a() {
        this.f7222c = (TabWidget) ((ViewGroup) getParent()).findViewById(16908307);
        if (this.f7222c == null) {
            throw new RuntimeException("Your TabHost must have a TabWidget whose id attribute is 'android.R.id.tabs'");
        }
        this.f7227h = new C04251(this);
        try {
            Class cls = TabWidget.class;
            for (Class cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().contains("OnTabSelectionChanged")) {
                    break;
                }
            }
            Class cls22 = null;
            Method declaredMethod = cls.getDeclaredMethod("setTabSelectionListener", new Class[]{cls22});
            Object newProxyInstance = Proxy.newProxyInstance(cls22.getClassLoader(), new Class[]{cls22}, new C04262(this));
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f7222c, new Object[]{newProxyInstance});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        this.f7223d = (FrameLayout) ((ViewGroup) getParent()).findViewById(16908305);
        if (this.f7223d == null) {
            throw new RuntimeException("Your TabHost must have a FrameLayout whose id attribute is 'android.R.id.tabcontent'");
        }
    }

    public void sendAccessibilityEvent(int i) {
    }

    public void setup(LocalActivityManager localActivityManager) {
        mo896a();
        this.f7221b = localActivityManager;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1264508801);
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 419776942, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1100409344);
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 124997163, a);
    }

    public void onTouchModeChanged(boolean z) {
        if (!z && this.f7225f != null) {
            if (!this.f7225f.hasFocus() || this.f7225f.isFocused()) {
                this.f7222c.getChildTabViewAt(this.f7220a).requestFocus();
            }
        }
    }

    public TabWidget getTabWidget() {
        return this.f7222c;
    }

    public int getCurrentTab() {
        return this.f7220a;
    }

    public String getCurrentTabTag() {
        if (this.f7220a < 0 || this.f7220a >= this.f7224e.size()) {
            return null;
        }
        return ((TabSpec) this.f7224e.get(this.f7220a)).f7239a;
    }

    public View getCurrentTabView() {
        if (this.f7220a < 0 || this.f7220a >= this.f7224e.size()) {
            return null;
        }
        return this.f7222c.getChildTabViewAt(this.f7220a);
    }

    public View getCurrentView() {
        return this.f7225f;
    }

    public FrameLayout getTabContentView() {
        return this.f7223d;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        if (!dispatchKeyEvent && keyEvent.getAction() == 0 && this.f7225f != null && this.f7225f.hasFocus()) {
            Object obj;
            int i;
            int i2;
            switch (this.f7222c.getOrientation()) {
                case 1:
                    if (this.f7223d.getLeft() >= this.f7222c.getLeft()) {
                        obj = null;
                        break;
                    }
                    obj = 2;
                    break;
                default:
                    if (this.f7223d.getTop() >= this.f7222c.getTop()) {
                        obj = 1;
                        break;
                    }
                    obj = 3;
                    break;
            }
            int i3;
            switch (obj) {
                case null:
                    i = 21;
                    i3 = 17;
                    i2 = 1;
                    break;
                case 2:
                    i = 22;
                    i3 = 66;
                    i2 = 3;
                    break;
                case 3:
                    i = 20;
                    i3 = 130;
                    i2 = 4;
                    break;
                default:
                    i = 19;
                    i3 = 33;
                    i2 = 2;
                    break;
            }
            if (keyEvent.getKeyCode() == i && this.f7225f.findFocus().focusSearch(r2) == null) {
                this.f7222c.getChildTabViewAt(this.f7220a).requestFocus();
                playSoundEffect(i2);
                return true;
            }
        }
        return dispatchKeyEvent;
    }

    public void dispatchWindowFocusChanged(boolean z) {
        if (this.f7225f != null) {
            this.f7225f.dispatchWindowFocusChanged(z);
        }
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.f7224e.size() && i != this.f7220a) {
            if (this.f7220a != -1) {
                this.f7224e.get(this.f7220a);
            }
            this.f7220a = i;
            TabSpec tabSpec = (TabSpec) this.f7224e.get(i);
            this.f7222c.focusCurrentTab(this.f7220a);
            this.f7225f = tabSpec.f7240b.m10366a();
            if (this.f7225f.getParent() == null) {
                this.f7223d.addView(this.f7225f, new LayoutParams(-1, -1));
            }
            if (!this.f7222c.hasFocus()) {
                this.f7225f.requestFocus();
            }
            if (this.f7226g != null) {
                this.f7226g.mo897a(getCurrentTabTag());
            }
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f7226g = onTabChangeListener;
    }
}
