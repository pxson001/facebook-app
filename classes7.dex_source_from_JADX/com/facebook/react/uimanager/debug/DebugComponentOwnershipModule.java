package com.facebook.react.uimanager.debug;

import android.util.SparseArray;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import javax.annotation.Nullable;

/* compiled from: force_enter_crop_view */
public class DebugComponentOwnershipModule extends ReactContextBaseJavaModule {
    private final SparseArray<OwnerHierarchyCallback> f11884a = new SparseArray();
    @Nullable
    private RCTDebugComponentOwnership f11885b;
    private int f11886c = 0;

    /* compiled from: force_enter_crop_view */
    public interface OwnerHierarchyCallback {
    }

    /* compiled from: force_enter_crop_view */
    public interface RCTDebugComponentOwnership extends JavaScriptModule {
    }

    public DebugComponentOwnershipModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public final void m14131c() {
        super.c();
        this.f11885b = (RCTDebugComponentOwnership) this.f1100a.m13515a(RCTDebugComponentOwnership.class);
    }

    public final void m14132e() {
        super.e();
        this.f11885b = null;
    }

    @ReactMethod
    public synchronized void receiveOwnershipHierarchy(int i, int i2, @Nullable ReadableArray readableArray) {
        if (((OwnerHierarchyCallback) this.f11884a.get(i)) == null) {
            throw new JSApplicationCausedNativeException("Got receiveOwnershipHierarchy for invalid request id: " + i);
        }
        this.f11884a.delete(i);
    }

    public String getName() {
        return "DebugComponentOwnershipModule";
    }
}
