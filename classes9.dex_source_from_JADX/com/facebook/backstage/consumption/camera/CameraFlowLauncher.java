package com.facebook.backstage.consumption.camera;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.facebook.backstage.camera.CameraFlowView.CameraInteractionListener;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.inject.Assisted;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: roster_view_profile */
public class CameraFlowLauncher {
    private static final String f4706a = CameraFlowLauncher.class.getSimpleName();
    private static final String[] f4707b = new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private final RuntimePermissionsUtil f4708c;
    private final ActivityRuntimePermissionsManager f4709d;
    public final Context f4710e;

    @Inject
    public CameraFlowLauncher(@Assisted Activity activity, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, Context context, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f4710e = context;
        this.f4708c = runtimePermissionsUtil;
        this.f4709d = activityRuntimePermissionsManagerProvider.a(activity);
    }

    public final void m4601a(final CameraHolder cameraHolder, final CameraOptions cameraOptions, @Nullable final CameraInteractionListener cameraInteractionListener) {
        if (cameraOptions.f4715e || this.f4708c.a(f4707b)) {
            if (cameraInteractionListener != null) {
                cameraHolder.m4322c().m4308a(cameraInteractionListener);
            }
            cameraHolder.m4322c().m4309a(cameraOptions);
            return;
        }
        this.f4709d.a(f4707b, new RuntimePermissionsListener(this) {
            final /* synthetic */ CameraFlowLauncher f4705d;

            public final void m4598a() {
                this.f4705d.m4601a(cameraHolder, cameraOptions, cameraInteractionListener);
            }

            public final void m4599a(String[] strArr, String[] strArr2) {
                Toast.makeText(this.f4705d.f4710e, this.f4705d.f4710e.getText(2131239923), 0).show();
            }

            public final void m4600b() {
                Toast.makeText(this.f4705d.f4710e, this.f4705d.f4710e.getText(2131239923), 0).show();
            }
        });
    }
}
