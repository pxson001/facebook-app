package com.facebook.backstage.nub;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.backstage.camera.CameraFlowView;
import com.facebook.backstage.camera.CameraFlowView.CameraInteractionListener;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.nub.FloatingWindowManager.C05702;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;

/* compiled from: reply_path_present */
public class OpticsCameraFullWindowView extends FullWindowView {
    private final CameraInteractionListener f5464g = new C05761(this);
    private CameraFlowView f5465h = new CameraFlowView(getContext());

    /* compiled from: reply_path_present */
    class C05761 implements CameraInteractionListener {
        final /* synthetic */ OpticsCameraFullWindowView f5463a;

        C05761(OpticsCameraFullWindowView opticsCameraFullWindowView) {
            this.f5463a = opticsCameraFullWindowView;
        }

        public final void mo157a() {
            if (this.f5463a.f5444c != null) {
                this.f5463a.f5444c.f5415a.f5423e.m5705g();
            }
        }

        public final void mo158b() {
        }
    }

    public OpticsCameraFullWindowView(Context context, ScreenUtil screenUtil, C05702 c05702) {
        super(context, screenUtil, c05702);
        this.f5465h.setLayoutParams(new LayoutParams(-1, -1));
        this.f5465h.m4308a(this.f5464g);
        addView(this.f5465h);
    }

    protected final void mo201c() {
        ViewAnimator.m5752a(this.f5465h).m5761e();
    }

    public final void mo202d() {
        if (m5660a()) {
            this.f5445d.setX(this.f5465h.getX() + ((float) this.f5465h.getWidth()));
        } else {
            this.f5445d.setX(this.f5465h.getX() - ((float) this.f5445d.getWidth()));
        }
    }

    protected final void mo197a(int i, int i2, int i3, boolean z) {
        this.f5465h.setX(z ? (float) ((i3 + i) - i2) : (float) (((i3 - this.f5465h.getWidth()) - i) + i2));
        this.f5445d.setX(z ? (float) ((i3 - i) - i2) : (float) ((i3 - i) + i2));
    }

    protected final void mo200b(OnFinishListener onFinishListener) {
        float centeredCameraViewX = getCenteredCameraViewX() - this.f5465h.getX();
        ViewAnimator e = ViewAnimator.m5752a(this.f5465h).m5761e();
        e.f5528e = onFinishListener;
        e.m5756b(this.f5465h.getX(), getCenteredCameraViewX()).m5759d();
        ViewAnimator.m5752a(this.f5445d).m5761e().m5754a(centeredCameraViewX).m5759d();
        this.f5465h.setIsHiding(false);
    }

    protected final void mo199b(int i, OnFinishListener onFinishListener) {
        int a = this.f5443b.m4551a();
        if (i <= this.f5443b.m4551a() / 2) {
            a = -this.f5465h.getWidth();
        }
        float x = ((float) a) - this.f5465h.getX();
        ViewAnimator e = ViewAnimator.m5752a(this.f5465h).m5761e();
        e.f5528e = onFinishListener;
        e.m5756b(this.f5465h.getX(), (float) a).m5759d();
        ViewAnimator.m5752a(this.f5445d).m5761e().m5754a(x).m5759d();
        this.f5465h.setIsHiding(true);
    }

    protected final void mo196a(int i) {
        this.f5465h.setX((float) i);
        this.f5465h.setVisibility(0);
        this.f5465h.m4317c();
    }

    protected final void mo203e() {
        this.f5465h.setVisibility(8);
    }

    protected final void mo204g() {
        this.f5465h.setVisibility(0);
        this.f5465h.setX(getCenteredCameraViewX());
    }

    public float getCenteredCameraViewX() {
        return ((float) this.f5443b.m4553c()) - (((float) this.f5465h.getWidth()) / 2.0f);
    }

    public float getCenteredCameraViewOffsetX() {
        return this.f5465h.getX() - getCenteredCameraViewX();
    }

    protected final void mo207i() {
        this.f5465h.m4313b();
    }

    protected final boolean mo198a(MotionEvent motionEvent) {
        return !this.f5465h.m4316b(motionEvent) && (this.f5465h.m4311a(motionEvent) || this.f5442a.f5434b.f5562l);
    }

    protected final boolean mo208k() {
        return this.f5465h.m4312a(false);
    }

    protected void setCameraByX(int i) {
        this.f5465h.setXBy((float) i);
    }
}
