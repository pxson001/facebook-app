package com.facebook.catalyst.modules.permissions;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.catalyst.modules.core.PermissionAwareActivity;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* compiled from: map_time_to_interaction */
public class PermissionsModule extends ReactContextBaseJavaModule {
    private final SparseArray<Callback> f5604a = new SparseArray();
    private int f5605b = 0;

    public PermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "AndroidPermissions";
    }

    @ReactMethod
    public void checkPermission(String str, Callback callback, Callback callback2) {
        boolean z = false;
        PermissionAwareActivity r = m6916r();
        if (VERSION.SDK_INT < 23) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (r.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            callback.a(objArr);
            return;
        }
        objArr = new Object[2];
        objArr[0] = str;
        if (r.checkSelfPermission(str) == 0) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        callback.a(objArr);
    }

    @ReactMethod
    public void shouldShowRequestPermissionRationale(String str, Callback callback, Callback callback2) {
        if (VERSION.SDK_INT < 23) {
            callback.a(new Object[]{str, Boolean.valueOf(false)});
            return;
        }
        callback.a(new Object[]{str, Boolean.valueOf(m6916r().shouldShowRequestPermissionRationale(str))});
    }

    @ReactMethod
    public void requestPermission(final String str, final Callback callback, Callback callback2) {
        boolean z = false;
        PermissionAwareActivity r = m6916r();
        if (VERSION.SDK_INT < 23) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (r.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            callback.a(objArr);
        } else if (r.checkSelfPermission(str) == 0) {
            callback.a(new Object[]{str, Boolean.valueOf(true)});
        } else {
            this.f5604a.put(this.f5605b, new Callback(this) {
                final /* synthetic */ PermissionsModule f5603c;

                public final void m6915a(Object... objArr) {
                    callback.a(new Object[]{str, Boolean.valueOf(objArr[0].equals(Integer.valueOf(0)))});
                }
            });
            r.a(new String[]{str}, this.f5605b, this);
            this.f5605b++;
        }
    }

    public final boolean m6917a(int i, int[] iArr) {
        ((Callback) this.f5604a.get(i)).a(new Object[]{Integer.valueOf(iArr[0])});
        this.f5604a.remove(i);
        return this.f5604a.size() == 0;
    }

    private PermissionAwareActivity m6916r() {
        Activity q = q();
        if (q == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (q instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) q;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }
}
