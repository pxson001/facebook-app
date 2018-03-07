package com.facebook.react.uimanager;

import android.content.Context;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SizeMonitoringFrameLayout.OnSizeChangedListener;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: frame_asset_download_request_success */
public class UIManagerModule extends ReactContextBaseJavaModule implements LifecycleEventListener, OnBatchCompleteListener {
    public final EventDispatcher f11785a;
    private final Map<String, Object> f11786b;
    private final UIImplementation f11787c;
    private int f11788d = 1;
    private int f11789e = 0;

    private void m14031a(int i, int i2, int i3) {
        this.f1100a.m13534g();
        this.f11787c.m13998a(i, i2, i3, this.f11785a);
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, UIImplementation uIImplementation) {
        super(reactApplicationContext);
        DisplayMetricsHolder.m13806a((Context) reactApplicationContext);
        this.f11785a = new EventDispatcher(reactApplicationContext);
        this.f11786b = m14030a((List) list);
        this.f11787c = uIImplementation;
        reactApplicationContext.mo745a((LifecycleEventListener) this);
    }

    public String getName() {
        return "RKUIManager";
    }

    public final Map<String, Object> m14034a() {
        return this.f11786b;
    }

    public final void hf_() {
        this.f11787c.m14024c();
    }

    public final void hg_() {
        this.f11787c.m14026d();
    }

    public final void hh_() {
    }

    public final void m14036e() {
        super.e();
        this.f11785a.m14158a();
    }

    private static Map<String, Object> m14030a(List<ViewManager> list) {
        Systrace.a(8192, "CreateUIManagerConstants");
        try {
            Map<String, Object> a = UIManagerModuleConstantsHelper.m14041a(list);
            return a;
        } finally {
            Systrace.a(8192);
        }
    }

    public final int m14033a(SizeMonitoringFrameLayout sizeMonitoringFrameLayout) {
        int width;
        int height;
        final int i = this.f11788d;
        this.f11788d += 10;
        if (sizeMonitoringFrameLayout.getLayoutParams() == null || sizeMonitoringFrameLayout.getLayoutParams().width <= 0 || sizeMonitoringFrameLayout.getLayoutParams().height <= 0) {
            width = sizeMonitoringFrameLayout.getWidth();
            height = sizeMonitoringFrameLayout.getHeight();
        } else {
            width = sizeMonitoringFrameLayout.getLayoutParams().width;
            height = sizeMonitoringFrameLayout.getLayoutParams().height;
        }
        this.f11787c.m14014a(sizeMonitoringFrameLayout, i, width, height, new ThemedReactContext(this.f1100a, sizeMonitoringFrameLayout.getContext()));
        sizeMonitoringFrameLayout.f11409a = new OnSizeChangedListener(this) {
            final /* synthetic */ UIManagerModule f11784b;

            public final void mo747a(final int i, final int i2) {
                this.f11784b.f1100a.m13527b(new Runnable(this) {
                    final /* synthetic */ C10421 f11782c;

                    public void run() {
                        this.f11782c.f11784b.m14031a(i, i, i2);
                    }
                });
            }
        };
        return i;
    }

    @ReactMethod
    public void removeRootView(int i) {
        this.f11787c.m14021b(i);
    }

    @ReactMethod
    public void createView(int i, String str, int i2, ReadableMap readableMap) {
        this.f11787c.m14006a(i, str, i2, readableMap);
    }

    @ReactMethod
    public void updateView(int i, String str, ReadableMap readableMap) {
        this.f11787c.m14007a(i, str, readableMap);
    }

    @ReactMethod
    public void manageChildren(int i, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2, @Nullable ReadableArray readableArray3, @Nullable ReadableArray readableArray4, @Nullable ReadableArray readableArray5) {
        this.f11787c.m14005a(i, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void setChildren(int i, ReadableArray readableArray) {
        this.f11787c.m14003a(i, readableArray);
    }

    @ReactMethod
    public void replaceExistingNonRootView(int i, int i2) {
        this.f11787c.m13997a(i, i2);
    }

    @ReactMethod
    public void removeSubviewsFromContainerWithID(int i) {
        this.f11787c.m14025c(i);
    }

    @ReactMethod
    public void measure(int i, Callback callback) {
        this.f11787c.m14001a(i, callback);
    }

    @ReactMethod
    public void measureInWindow(int i, Callback callback) {
        this.f11787c.m14023b(i, callback);
    }

    @ReactMethod
    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
        this.f11787c.m13999a(i, i2, callback, callback2);
    }

    @ReactMethod
    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
        this.f11787c.m14002a(i, callback, callback2);
    }

    @ReactMethod
    public void findSubviewIn(int i, ReadableArray readableArray, Callback callback) {
        this.f11787c.m13996a(i, (float) Math.round(PixelUtil.m13923a(readableArray.getDouble(0))), (float) Math.round(PixelUtil.m13923a(readableArray.getDouble(1))), callback);
    }

    @ReactMethod
    public void setJSResponder(int i, boolean z) {
        this.f11787c.m14008a(i, z);
    }

    @ReactMethod
    public void clearJSResponder() {
        this.f11787c.m14020b();
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i, int i2, ReadableArray readableArray) {
        this.f11787c.m14000a(i, i2, readableArray);
    }

    @ReactMethod
    public void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.f11787c.m14004a(i, readableArray, callback, callback2);
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        this.f11787c.m14018a(z);
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.f11787c.m14009a(readableMap, callback, callback2);
    }

    public final void hi_() {
        int i = this.f11789e;
        this.f11789e++;
        SystraceMessage.a(8192, "onBatchCompleteUI").a("BatchId", i).a();
        try {
            this.f11787c.m14017a(this.f11785a, i);
        } finally {
            Systrace.a(8192);
        }
    }

    public final void m14035a(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.f11787c.m14015a(notThreadSafeViewHierarchyUpdateDebugListener);
    }

    public final EventDispatcher m14037r() {
        return this.f11785a;
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i, int i2) {
        this.f11787c.m14022b(i, i2);
    }
}
