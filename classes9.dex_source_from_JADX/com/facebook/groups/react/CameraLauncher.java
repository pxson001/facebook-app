package com.facebook.groups.react;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: payment_transaction_query_type */
public class CameraLauncher {
    public static final String[] f6979a = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public final Activity f6980b;
    public MediaStorage f6981c;
    public ActivityRuntimePermissionsManager f6982d;
    public SecureContextHelper f6983e;
    public Toaster f6984f;
    public Callback f6985g;
    public Uri f6986h;

    /* compiled from: payment_transaction_query_type */
    public class C07281 implements RuntimePermissionsListener {
        final /* synthetic */ CameraLauncher f6978a;

        public C07281(CameraLauncher cameraLauncher) {
            this.f6978a = cameraLauncher;
        }

        public final void m7300a() {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.f6978a.f6986h);
            this.f6978a.f6983e.b(intent, 1010, this.f6978a.f6980b);
        }

        public final void m7301a(String[] strArr, String[] strArr2) {
            this.f6978a.f6984f.b(new ToastBuilder(this.f6978a.f6980b.getString(2131239990)));
        }

        public final void m7302b() {
        }
    }

    @Inject
    public CameraLauncher(@Assisted Activity activity, MediaStorage mediaStorage, SecureContextHelper secureContextHelper, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Toaster toaster) {
        this.f6980b = activity;
        this.f6981c = mediaStorage;
        this.f6983e = secureContextHelper;
        this.f6982d = activityRuntimePermissionsManagerProvider.a(activity);
        this.f6984f = toaster;
    }

    public final void m7303a(int i) {
        String str = "";
        if (i == -1) {
            str = this.f6986h.toString();
        }
        new WritableNativeMap().putString("uri", str);
        this.f6985g.a(new Object[]{r1});
        this.f6985g = null;
    }
}
