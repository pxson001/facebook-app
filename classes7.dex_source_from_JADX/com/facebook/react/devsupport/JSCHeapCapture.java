package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.util.HashSet;
import javax.annotation.Nullable;

/* compiled from: ftyp */
public class JSCHeapCapture extends ReactContextBaseJavaModule {
    private static final HashSet<JSCHeapCapture> f11626e = new HashSet();
    @Nullable
    private HeapCapture f11627a = null;
    private boolean f11628b = false;
    private int f11629c = 0;
    @Nullable
    private String f11630d = null;

    /* compiled from: ftyp */
    public interface HeapCapture extends JavaScriptModule {
    }

    private static synchronized void m13693a(JSCHeapCapture jSCHeapCapture) {
        synchronized (JSCHeapCapture.class) {
            if (f11626e.contains(jSCHeapCapture)) {
                throw new RuntimeException("a JSCHeapCapture registered more than once");
            }
            f11626e.add(jSCHeapCapture);
        }
    }

    private static synchronized void m13694b(JSCHeapCapture jSCHeapCapture) {
        synchronized (JSCHeapCapture.class) {
            f11626e.remove(jSCHeapCapture);
        }
    }

    public JSCHeapCapture(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public synchronized void operationComplete(int i, String str) {
        if (i == this.f11629c) {
            this.f11628b = false;
            this.f11630d = str;
            ObjectDetour.b(this, 1030609150);
        } else {
            throw new RuntimeException("Completed operation is not in progress.");
        }
    }

    public String getName() {
        return "JSCHeapCapture";
    }

    public final void m13695c() {
        super.c();
        this.f11627a = (HeapCapture) this.f1100a.m13515a(HeapCapture.class);
        m13693a(this);
    }

    public final void m13696e() {
        super.e();
        m13694b(this);
        this.f11627a = null;
    }
}
