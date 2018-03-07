package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.facebook.camera.utils.CameraUtils;
import com.facebook.camera.utils.CameraUtils.OptimizeMode;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@TargetApi(18)
/* compiled from: savedvideos.db */
public class CameraSetup {
    public static CameraSetup m8004a(InjectorLike injectorLike) {
        return new CameraSetup();
    }

    @Nullable
    public static Camera m8003a(int i, Integer num) {
        Object obj = null;
        CameraInfo cameraInfo = new CameraInfo();
        Camera camera = null;
        for (int i2 = 0; i2 < 5 && camera == null; i2++) {
            try {
                camera = m8002a(i, cameraInfo);
            } catch (Exception e) {
                obj = e;
            }
        }
        if (camera == null) {
            Preconditions.checkNotNull(obj, "Failure exception cannot be null");
            throw obj;
        }
        int i3;
        Parameters parameters = camera.getParameters();
        m8005a(parameters);
        switch (num.intValue()) {
            case 0:
                i3 = 0;
                break;
            case 1:
                i3 = 90;
                break;
            case 2:
                i3 = 180;
                break;
            case 3:
                i3 = 270;
                break;
            default:
                i3 = 0;
                break;
        }
        int i4 = cameraInfo.orientation;
        if (cameraInfo.facing == 1) {
            i3 = (360 - ((i3 + i4) % 360)) % 360;
        } else {
            i3 = ((i4 - i3) + 360) % 360;
        }
        m8001a(parameters, 30000);
        parameters.setRecordingHint(true);
        camera.setParameters(parameters);
        camera.setDisplayOrientation(i3);
        return camera;
    }

    @Nullable
    private static Camera m8002a(int i, CameraInfo cameraInfo) {
        Camera camera = null;
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                camera = Camera.open(i2);
                break;
            }
        }
        if (camera != null) {
            return camera;
        }
        BLog.b("[CAMERA_SETUP]", "No camera %d found; opening default", new Object[]{Integer.valueOf(i)});
        return Camera.open();
    }

    private static void m8005a(Parameters parameters) {
        Size a = CameraUtils.a(parameters.getSupportedPreviewSizes(), 1280, 720, OptimizeMode.SMALLER_THAN_OR_EQUAL_TO);
        Integer.valueOf(1280);
        Integer.valueOf(720);
        Integer.valueOf(a.width);
        Integer.valueOf(a.height);
        if (a != null) {
            parameters.setPreviewSize(a.width, a.height);
        }
        if (parameters.getSupportedFocusModes() != null && parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
    }

    private static int m8001a(Parameters parameters, int i) {
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            if (iArr[0] == iArr[1] && iArr[0] == i) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                return iArr[0];
            }
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (iArr2[0] == i) {
            return iArr2[0];
        }
        if (iArr2[1] == i) {
            return iArr2[1];
        }
        int i2 = iArr2[1] / 2;
        Integer.valueOf(i);
        Integer.valueOf(i2);
        return i2;
    }
}
