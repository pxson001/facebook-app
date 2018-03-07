package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.CamcorderProfile;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(10)
/* compiled from: proxy_login_permissions_list */
public class CameraUtil {
    private final Provider<Boolean> f6002a;

    public static CameraUtil m6329b(InjectorLike injectorLike) {
        return new CameraUtil(IdBasedProvider.a(injectorLike, 3928));
    }

    @Inject
    public CameraUtil(Provider<Boolean> provider) {
        this.f6002a = provider;
    }

    public static int m6327a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public final void m6332a(Matrix matrix, boolean z, int i, Rect rect) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) i);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(-1000.0f, -1000.0f, 1000.0f, 1000.0f), new RectF((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom), ScaleToFit.FILL);
        matrix.setConcat(matrix2, matrix);
    }

    public final boolean m6333a(int i) {
        return m6328b(i, 0) != null;
    }

    public final CamcorderProfile m6334b(int i) {
        CamcorderProfile c = m6330c(i);
        if (c != null) {
            return c;
        }
        throw new RuntimeException("Couldn't find valid camcorder profile");
    }

    public final CamcorderProfile m6331a(int i, int i2) {
        CamcorderProfile b = m6328b(i, i2);
        if (b != null) {
            return b;
        }
        throw new RuntimeException("Couldn't find valid camcorder profile");
    }

    private CamcorderProfile m6328b(int i, int i2) {
        if (!((Boolean) this.f6002a.get()).booleanValue()) {
            return m6330c(i);
        }
        CamcorderProfile camcorderProfile = null;
        if (1 == i2 && CamcorderProfile.hasProfile(i, 5)) {
            return CamcorderProfile.get(i, 5);
        }
        if (CamcorderProfile.hasProfile(i, 4)) {
            camcorderProfile = CamcorderProfile.get(i, 4);
        } else if (CamcorderProfile.hasProfile(i, 0)) {
            camcorderProfile = CamcorderProfile.get(i, 0);
        }
        if (camcorderProfile == null) {
            return camcorderProfile;
        }
        camcorderProfile.videoBitRate = 655360;
        return camcorderProfile;
    }

    private static CamcorderProfile m6330c(int i) {
        if (CamcorderProfile.hasProfile(i, 1)) {
            return CamcorderProfile.get(i, 1);
        }
        if (CamcorderProfile.hasProfile(i, 6)) {
            return CamcorderProfile.get(i, 6);
        }
        if (CamcorderProfile.hasProfile(i, 5)) {
            return CamcorderProfile.get(i, 5);
        }
        if (CamcorderProfile.hasProfile(i, 4)) {
            return CamcorderProfile.get(i, 4);
        }
        return null;
    }
}
