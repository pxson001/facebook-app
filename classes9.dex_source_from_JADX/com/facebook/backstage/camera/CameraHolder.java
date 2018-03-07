package com.facebook.backstage.camera;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.backstage.consumption.BackstageLifeCycleHelper;
import com.facebook.backstage.consumption.HolderListener;
import com.facebook.backstage.consumption.camera.ConsumptionCameraFlowView;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: search_origin_activity_type */
public class CameraHolder {
    private final BackstageLifeCycleHelper f4333a;
    private final Activity f4334b;
    private final ViewGroup f4335c;
    private ConsumptionCameraFlowView f4336d;

    /* compiled from: search_origin_activity_type */
    class C03981 implements HolderListener {
        final /* synthetic */ CameraHolder f4332a;

        C03981(CameraHolder cameraHolder) {
            this.f4332a = cameraHolder;
        }

        public final void mo143a() {
            this.f4332a.m4320a();
        }
    }

    @Inject
    public CameraHolder(@Assisted Activity activity, @Assisted ViewGroup viewGroup, @Assisted BackstageLifeCycleHelper backstageLifeCycleHelper) {
        this.f4333a = backstageLifeCycleHelper;
        this.f4334b = activity;
        this.f4335c = viewGroup;
    }

    public final void m4320a() {
        if (this.f4336d != null) {
            this.f4333a.m4487a(null);
            ((ViewGroup) this.f4336d.getParent()).removeView(this.f4336d);
            this.f4336d = null;
        }
    }

    public final boolean m4321b() {
        return this.f4336d != null;
    }

    public final ConsumptionCameraFlowView m4322c() {
        if (this.f4336d != null) {
            return this.f4336d;
        }
        this.f4336d = new ConsumptionCameraFlowView(this.f4334b);
        this.f4333a.m4487a(this.f4336d);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        this.f4336d.setLayoutParams(layoutParams);
        this.f4336d.f4329l = new C03981(this);
        this.f4336d.setVisibility(8);
        this.f4335c.addView(this.f4336d);
        return this.f4336d;
    }
}
