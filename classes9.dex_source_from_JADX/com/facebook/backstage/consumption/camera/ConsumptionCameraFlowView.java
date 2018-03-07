package com.facebook.backstage.consumption.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.backstage.camera.CameraFlowView;
import com.facebook.backstage.camera.CameraFlowView.CameraFlowState;
import com.facebook.backstage.camera.CameraFlowView.CameraInteractionListener;
import com.facebook.backstage.camera.PreviewView;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.util.KeyboardHeightChangeDetector.OnKeyboardHeightChangeListener;
import com.google.common.base.Strings;

@TargetApi(16)
/* compiled from: root_hash */
public class ConsumptionCameraFlowView extends CameraFlowView implements OnKeyboardHeightChangeListener {
    private final BackstageNavigatorApi f4719j;
    private Float f4720k;

    /* compiled from: root_hash */
    class C04791 implements CameraInteractionListener {
        final /* synthetic */ ConsumptionCameraFlowView f4717a;

        C04791(ConsumptionCameraFlowView consumptionCameraFlowView) {
            this.f4717a = consumptionCameraFlowView;
        }

        public final void mo157a() {
            this.f4717a.mo160b(false);
        }

        public final void mo158b() {
        }
    }

    /* compiled from: root_hash */
    class C04802 implements OnTouchListener {
        final /* synthetic */ ConsumptionCameraFlowView f4718a;

        C04802(ConsumptionCameraFlowView consumptionCameraFlowView) {
            this.f4718a = consumptionCameraFlowView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public ConsumptionCameraFlowView(Context context) {
        this(context, null);
    }

    private ConsumptionCameraFlowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ConsumptionCameraFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4719j = BackstageNavigatorApi.m4489a();
        m4308a(new C04791(this));
        setOnTouchListener(new C04802(this));
    }

    public final void mo160b(boolean z) {
        Object obj;
        if (this.f4321d == CameraFlowState.CAMERA && Strings.isNullOrEmpty(this.f4323f)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f4719j.m4492a(NavigationState.CAMERA, NavigationState.MAIN_LIST);
        } else if (this.f4321d == CameraFlowState.TEXT && Strings.isNullOrEmpty(this.f4323f)) {
            this.f4719j.m4492a(NavigationState.TEXT_ONLY, NavigationState.MAIN_LIST);
        }
        m4609e();
        if (this.f4321d == CameraFlowState.PREVIEW) {
            ((PreviewView) this.f4319b.m5715a()).m4431a();
            setState(CameraFlowState.CAMERA);
        }
        super.mo160b(z);
    }

    private void m4609e() {
        if (this.f4720k != null) {
            clearAnimation();
            ViewAnimator.m5752a((View) this).m5761e();
            setY(this.f4720k.floatValue());
            this.f4720k = null;
        }
    }

    public final void mo159a(int i) {
        if (!this.f4330m) {
            return;
        }
        if (i == 0) {
            m4609e();
            return;
        }
        this.f4720k = Float.valueOf(getY());
        ViewAnimator.m5752a((View) this).m5755b((float) (-i)).m5759d();
    }
}
