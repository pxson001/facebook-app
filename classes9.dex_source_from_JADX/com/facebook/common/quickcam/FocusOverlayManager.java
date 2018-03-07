package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.inject.Assisted;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: proxy_login */
public class FocusOverlayManager {
    public int f6003a = 0;
    private AbstractFbErrorReporter f6004b;
    private boolean f6005c;
    public boolean f6006d;
    public boolean f6007e;
    private final Matrix f6008f = new Matrix();
    public final CameraUtil f6009g;
    private boolean f6010h;
    private int f6011i;
    private List<Area> f6012j;
    public List<Area> f6013k;
    private boolean f6014l;
    private final Camera f6015m;
    public final Rect f6016n = new Rect(0, 0, 0, 0);

    @Inject
    public FocusOverlayManager(@Assisted Camera camera, @Assisted Boolean bool, AbstractFbErrorReporter abstractFbErrorReporter, CameraUtil cameraUtil) {
        this.f6015m = camera;
        this.f6004b = abstractFbErrorReporter;
        this.f6009g = cameraUtil;
        Parameters parameters = this.f6015m.getParameters();
        if (parameters != null) {
            boolean z;
            CameraUtil cameraUtil2 = this.f6009g;
            if (parameters.getMaxNumFocusAreas() > 0) {
                Object obj;
                String str = "auto";
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes == null || supportedFocusModes.indexOf(str) < 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    z = true;
                    this.f6006d = z;
                    this.f6007e = parameters.getMaxNumMeteringAreas() <= 0;
                }
            }
            z = false;
            this.f6006d = z;
            if (parameters.getMaxNumMeteringAreas() <= 0) {
            }
            this.f6007e = parameters.getMaxNumMeteringAreas() <= 0;
        }
        m6347a(bool.booleanValue());
        this.f6014l = true;
    }

    public final void m6346a(int i, int i2) {
        if (this.f6016n.width() != i || this.f6016n.height() != i2) {
            m6338a(new Rect(0, 0, i, i2));
        }
    }

    private void m6338a(Rect rect) {
        if (!this.f6016n.equals(rect)) {
            this.f6016n.set(rect);
            m6339b();
        }
    }

    public final void m6347a(boolean z) {
        this.f6010h = z;
        m6339b();
    }

    public final void m6345a(int i) {
        this.f6011i = i;
        m6339b();
    }

    private void m6339b() {
        if (this.f6016n.width() != 0 && this.f6016n.height() != 0) {
            Matrix matrix = new Matrix();
            this.f6009g.m6332a(matrix, this.f6010h, this.f6011i, new Rect(this.f6016n));
            matrix.invert(this.f6008f);
            this.f6005c = true;
        }
    }

    @TargetApi(14)
    private void m6341c(int i, int i2) {
        if (this.f6012j == null) {
            this.f6012j = Lists.a();
            this.f6012j.add(new Area(new Rect(), 1));
        }
        m6337a(i, i2, 1.0f, ((Area) this.f6012j.get(0)).rect);
    }

    @TargetApi(14)
    private void m6342d(int i, int i2) {
        if (this.f6013k == null) {
            this.f6013k = Lists.a();
            this.f6013k.add(new Area(new Rect(), 1));
        }
        m6337a(i, i2, 1.5f, ((Area) this.f6013k.get(0)).rect);
    }

    private void m6340c() {
        if (this.f6012j != null && this.f6013k != null) {
            this.f6015m.cancelAutoFocus();
            Parameters parameters = this.f6015m.getParameters();
            parameters.setFocusMode("auto");
            parameters.setFocusAreas(this.f6012j);
            parameters.setMeteringAreas(this.f6013k);
            try {
                this.f6015m.setParameters(parameters);
                this.f6015m.autoFocus(null);
            } catch (RuntimeException e) {
                this.f6004b.a(SoftError.a("auto_focus", "auto focusing error").g());
            }
        }
    }

    public final void m6348b(int i, int i2) {
        if (!this.f6014l && (this.f6003a == 1 || this.f6003a == 3 || this.f6003a == 4)) {
            m6343f();
        }
        this.f6014l = false;
        if (this.f6006d) {
            m6341c(i, i2);
        }
        if (this.f6007e) {
            m6342d(i, i2);
        }
        m6340c();
        if (this.f6006d) {
            this.f6003a = 1;
        }
    }

    private void m6343f() {
        m6344g();
        this.f6003a = 0;
    }

    private void m6344g() {
        if (this.f6005c) {
            if (this.f6006d) {
                m6341c(this.f6016n.centerX(), this.f6016n.centerY());
            }
            if (this.f6007e) {
                this.f6013k = null;
            }
            this.f6014l = true;
        }
    }

    private void m6337a(int i, int i2, float f, Rect rect) {
        int max = (int) (((float) (Math.max(this.f6016n.width(), this.f6016n.height()) / 8)) * f);
        int a = CameraUtil.m6327a(i - (max / 2), this.f6016n.left, this.f6016n.right - max);
        int a2 = CameraUtil.m6327a(i2 - (max / 2), this.f6016n.top, this.f6016n.bottom - max);
        RectF rectF = new RectF((float) a, (float) a2, (float) (a + max), (float) (max + a2));
        this.f6008f.mapRect(rectF);
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }
}
