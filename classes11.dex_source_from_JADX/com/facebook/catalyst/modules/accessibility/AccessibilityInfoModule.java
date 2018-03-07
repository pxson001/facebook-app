package com.facebook.catalyst.modules.accessibility;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import javax.annotation.Nullable;

/* compiled from: matched_messages */
public class AccessibilityInfoModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    @Nullable
    private AccessibilityManager f5561a;
    @Nullable
    private ReactTouchExplorationStateChangeListener f5562b;
    private boolean f5563c;

    @TargetApi(19)
    /* compiled from: matched_messages */
    class ReactTouchExplorationStateChangeListener implements TouchExplorationStateChangeListener {
        final /* synthetic */ AccessibilityInfoModule f5560a;

        public ReactTouchExplorationStateChangeListener(AccessibilityInfoModule accessibilityInfoModule) {
            this.f5560a = accessibilityInfoModule;
        }

        public void onTouchExplorationStateChanged(boolean z) {
            this.f5560a.m6876a(z);
        }
    }

    public final void m6877c() {
        this.a.a(this);
        m6876a(this.f5561a.isTouchExplorationEnabled());
    }

    public AccessibilityInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f5563c = false;
        this.f5561a = (AccessibilityManager) this.a.getSystemService("accessibility");
        this.f5563c = this.f5561a.isTouchExplorationEnabled();
        if (VERSION.SDK_INT >= 19) {
            this.f5562b = new ReactTouchExplorationStateChangeListener(this);
        }
    }

    public String getName() {
        return "AccessibilityInfo";
    }

    @ReactMethod
    public void isTouchExplorationEnabled(Callback callback) {
        callback.a(new Object[]{Boolean.valueOf(this.f5563c)});
    }

    private void m6876a(boolean z) {
        if (this.f5563c != z) {
            this.f5563c = z;
            ((RCTDeviceEventEmitter) this.a.a(RCTDeviceEventEmitter.class)).emit("touchExplorationDidChange", Boolean.valueOf(this.f5563c));
        }
    }

    public final void hf_() {
        if (VERSION.SDK_INT >= 19) {
            this.f5561a.addTouchExplorationStateChangeListener(this.f5562b);
        }
        m6876a(this.f5561a.isTouchExplorationEnabled());
    }

    public final void hg_() {
        if (VERSION.SDK_INT >= 19) {
            this.f5561a.removeTouchExplorationStateChangeListener(this.f5562b);
        }
    }

    public final void hh_() {
    }
}
