package com.facebook.react;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnGenericMotionListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.UIManagerModule;
import javax.annotation.Nullable;

/* compiled from: hard-coded */
public class ReactRootView extends SizeMonitoringFrameLayout implements RootView {
    @Nullable
    public ReactInstanceManager f11410a;
    @Nullable
    private String f11411b;
    @Nullable
    public Bundle f11412c;
    @Nullable
    private KeyboardListener f11413d;
    @Nullable
    private OnGenericMotionListener f11414e;
    private boolean f11415f = false;
    public boolean f11416g = false;
    private final JSTouchDispatcher f11417h = new JSTouchDispatcher(this);

    /* compiled from: hard-coded */
    class C10041 implements Runnable {
        final /* synthetic */ ReactRootView f11404a;

        C10041(ReactRootView reactRootView) {
            this.f11404a = reactRootView;
        }

        public void run() {
            this.f11404a.f11410a;
        }
    }

    /* compiled from: hard-coded */
    class KeyboardListener implements OnGlobalLayoutListener {
        final /* synthetic */ ReactRootView f11405a;
        private final Rect f11406b = new Rect();
        private final int f11407c = ((int) PixelUtil.m13924a(60.0f));
        private int f11408d = 0;

        KeyboardListener(ReactRootView reactRootView) {
            this.f11405a = reactRootView;
        }

        public void onGlobalLayout() {
            if (this.f11405a.f11410a == null || !this.f11405a.f11416g || this.f11405a.f11410a.mo637j() == null) {
                FLog.a("React", "Unable to dispatch keyboard events in JS as the react instance has not been attached");
                return;
            }
            this.f11405a.getRootView().getWindowVisibleDisplayFrame(this.f11406b);
            int i = DisplayMetricsHolder.f11710a.heightPixels - this.f11406b.bottom;
            if (this.f11408d != i && i > this.f11407c) {
                this.f11408d = i;
                WritableMap b = Arguments.m13388b();
                WritableMap b2 = Arguments.m13388b();
                b2.putDouble("screenY", (double) PixelUtil.m13926c((float) this.f11406b.bottom));
                b2.putDouble("screenX", (double) PixelUtil.m13926c((float) this.f11406b.left));
                b2.putDouble("width", (double) PixelUtil.m13926c((float) this.f11406b.width()));
                b2.putDouble("height", (double) PixelUtil.m13926c((float) this.f11408d));
                b.mo696a("endCoordinates", b2);
                m13319a("keyboardDidShow", b);
            } else if (this.f11408d != 0 && i <= this.f11407c) {
                this.f11408d = 0;
                m13319a("keyboardDidHide", null);
            }
        }

        private void m13319a(String str, @Nullable WritableMap writableMap) {
            if (this.f11405a.f11410a != null) {
                ((RCTDeviceEventEmitter) this.f11405a.f11410a.mo637j().m13515a(RCTDeviceEventEmitter.class)).emit(str, writableMap);
            }
        }
    }

    public ReactRootView(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        if (mode == 0 || mode2 == 0) {
            throw new IllegalStateException("The root catalyst view must have a width and height given to it by it's parent view. You can do this by specifying MATCH_PARENT or explicit width and height in the layout.");
        }
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
        this.f11415f = true;
        if (this.f11410a != null && !this.f11416g) {
            UiThreadUtil.m13552a(new C10041(this));
        }
    }

    public final void mo638a(MotionEvent motionEvent) {
        if (this.f11410a == null || !this.f11416g || this.f11410a.mo637j() == null) {
            FLog.a("React", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return;
        }
        this.f11417h.m13812a(motionEvent, ((UIManagerModule) this.f11410a.mo637j().m13525b(UIManagerModule.class)).f11785a);
        if (this.f11414e != null) {
            this.f11414e.onGenericMotion(this, motionEvent);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m13323b(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 187891562);
        m13323b(motionEvent);
        super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1058622229, a);
        return true;
    }

    public void setOnGenericMotionListener(OnGenericMotionListener onGenericMotionListener) {
        this.f11414e = onGenericMotionListener;
    }

    private void m13323b(MotionEvent motionEvent) {
        if (this.f11410a == null || !this.f11416g || this.f11410a.mo637j() == null) {
            FLog.a("React", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return;
        }
        this.f11417h.m13813b(motionEvent, ((UIManagerModule) this.f11410a.mo637j().m13525b(UIManagerModule.class)).f11785a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1281753175);
        super.onAttachedToWindow();
        if (this.f11416g) {
            getViewTreeObserver().addOnGlobalLayoutListener(getKeyboardListener());
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1920771215, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -908014204);
        super.onDetachedFromWindow();
        if (this.f11416g) {
            getViewTreeObserver().removeOnGlobalLayoutListener(getKeyboardListener());
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1908634875, a);
    }

    public final void m13328a(ReactInstanceManager reactInstanceManager, String str, @Nullable Bundle bundle) {
        UiThreadUtil.m13554b();
        Assertions.a(this.f11410a == null, "This root view has already been attached to a catalyst instance manager");
        this.f11410a = reactInstanceManager;
        this.f11411b = str;
        this.f11412c = bundle;
        if (!this.f11410a.mo630c()) {
            this.f11410a.mo627b();
        }
        if (this.f11415f) {
            this.f11410a;
        }
    }

    public final void m13326a() {
        if (this.f11410a != null && this.f11416g) {
            this.f11410a.mo629b(this);
            this.f11416g = false;
        }
    }

    String getJSModuleName() {
        return (String) Assertions.b(this.f11411b);
    }

    @Nullable
    Bundle getLaunchOptions() {
        return this.f11412c;
    }

    private KeyboardListener getKeyboardListener() {
        if (this.f11413d == null) {
            this.f11413d = new KeyboardListener(this);
        }
        return this.f11413d;
    }

    public static void m13324b(ReactRootView reactRootView) {
        if (!reactRootView.f11416g) {
            reactRootView.f11416g = true;
            ((ReactInstanceManager) Assertions.b(reactRootView.f11410a)).mo626a(reactRootView);
            reactRootView.getViewTreeObserver().addOnGlobalLayoutListener(reactRootView.getKeyboardListener());
        }
    }

    protected void finalize() {
        super.finalize();
        Assertions.a(!this.f11416g, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }
}
