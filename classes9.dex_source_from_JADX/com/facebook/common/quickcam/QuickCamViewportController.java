package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewStub;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@TargetApi(10)
/* compiled from: promo_ride */
public class QuickCamViewportController {
    public final QuickCamPreviewHolder f6116a;
    private View f6117b;
    public CameraPreviewListener f6118c;
    public QuickCamAsync f6119d;

    /* compiled from: promo_ride */
    public class C06371 {
        final /* synthetic */ QuickCamViewportController f6115a;

        C06371(QuickCamViewportController quickCamViewportController) {
            this.f6115a = quickCamViewportController;
        }

        public final void m6459a() {
            QuickCamViewportController quickCamViewportController = this.f6115a;
            if (quickCamViewportController.f6118c != null) {
                quickCamViewportController.f6118c.mo687a();
            }
            quickCamViewportController.f6119d.m6381a(quickCamViewportController.f6116a);
        }

        public final void m6460b() {
            this.f6115a.f6119d.m6382b();
        }
    }

    /* compiled from: promo_ride */
    public interface CameraPreviewListener {
        void mo687a();
    }

    public static QuickCamViewportController m6462a(InjectorLike injectorLike) {
        return new QuickCamViewportController(new QuickCamPreviewHolderFactory(ResourcesMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public QuickCamViewportController(QuickCamPreviewHolderFactory quickCamPreviewHolderFactory) {
        QuickCamPreviewHolderForTextureView quickCamPreviewHolderForTextureView;
        if (VERSION.SDK_INT >= 16) {
            quickCamPreviewHolderForTextureView = new QuickCamPreviewHolderForTextureView();
        } else {
            quickCamPreviewHolderForTextureView = new QuickCamPreviewHolderForSurfaceView(quickCamPreviewHolderFactory.f6072a);
        }
        this.f6116a = quickCamPreviewHolderForTextureView;
        this.f6116a.mo237a(new C06371(this));
    }

    public final void m6466a(QuickCamAsync quickCamAsync) {
        this.f6119d = quickCamAsync;
    }

    public final void m6465a(ViewStub viewStub, View view) {
        this.f6116a.mo236a(viewStub);
        this.f6117b = view;
    }

    public final void m6464a(int i, int i2) {
        this.f6119d.m6379a(i, i2);
    }

    public final void m6467a(CameraPreviewListener cameraPreviewListener) {
        this.f6118c = cameraPreviewListener;
    }

    public final void m6468b(int i, int i2) {
        float i3 = this.f6119d.m6389i();
        if (i != 0 && i2 != 0 && i3 > 0.0f) {
            int d = m6471d(i2, i);
            LayoutParamsUtil.a(this.f6117b, d);
            float f = ((float) d) / ((float) i2);
            View d2 = m6472d();
            int i4;
            if (f > 1.0f * i3) {
                i4 = (int) (((float) d) / i3);
                LayoutParamsUtil.a(d2, -1, i4);
                d2.setTranslationX(0.0f);
                d2.setTranslationY((float) ((i2 - i4) / 2));
                return;
            }
            i4 = (int) (i3 * ((float) i2));
            LayoutParamsUtil.a(d2, i4, -1);
            d2.setTranslationX((float) ((d - i4) / 2));
            d2.setTranslationY(0.0f);
        }
    }

    public final int m6471d(int i, int i2) {
        float i3 = this.f6119d.m6389i();
        if (i == 0 || i2 == 0 || i3 == -1.0f) {
            return 0;
        }
        float f = ((float) i2) / ((float) i);
        if (i3 >= 1.0f || i3 * 0.9f >= f) {
            return (i3 <= 1.0f || i3 * 0.9f <= f) ? (int) (i3 * ((float) i)) : i2;
        } else {
            return i2;
        }
    }

    public final boolean m6469b() {
        return this.f6116a.mo240c();
    }

    public final void m6463a(int i) {
        m6472d().setVisibility(i);
    }

    public final void m6470c() {
        m6472d().requestLayout();
    }

    public final View m6472d() {
        return this.f6116a.mo239b();
    }
}
