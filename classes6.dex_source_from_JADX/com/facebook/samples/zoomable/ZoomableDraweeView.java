package com.facebook.samples.zoomable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeController.InternalForwardingListener;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: setGroupCommerceCategories */
public class ZoomableDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public static final Class<?> f4833a = ZoomableDraweeView.class;
    private final RectF f4834b = new RectF();
    private final RectF f4835c = new RectF();
    private DraweeController f4836d;
    private ZoomableController f4837e;
    private GestureDetector f4838f;
    private final ControllerListener f4839g = new C02901(this);
    private final C02912 f4840h = new C02912(this);
    private final GestureListenerWrapper f4841i = new GestureListenerWrapper();

    /* compiled from: setGroupCommerceCategories */
    class C02901 extends BaseControllerListener<Object> {
        final /* synthetic */ ZoomableDraweeView f4831a;

        C02901(ZoomableDraweeView zoomableDraweeView) {
            this.f4831a = zoomableDraweeView;
        }

        public final void m7630a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            ZoomableDraweeView.m7643e(this.f4831a);
        }

        public final void m7629a(String str) {
            ZoomableDraweeView.m7644f(this.f4831a);
        }
    }

    /* compiled from: setGroupCommerceCategories */
    public class C02912 {
        final /* synthetic */ ZoomableDraweeView f4832a;

        C02912(ZoomableDraweeView zoomableDraweeView) {
            this.f4832a = zoomableDraweeView;
        }

        public final void m7631a(Matrix matrix) {
            this.f4832a.m7647a(matrix);
        }
    }

    public ZoomableDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
        m7641c();
    }

    public ZoomableDraweeView(Context context) {
        super(context);
        m7632a(context, null);
        m7641c();
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7632a(context, attributeSet);
        m7641c();
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7632a(context, attributeSet);
        m7641c();
    }

    private void m7632a(Context context, @Nullable AttributeSet attributeSet) {
        GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(context.getResources()).e(ScaleType.c);
        GenericDraweeHierarchyInflater.a(e, context, attributeSet);
        setAspectRatio(e.e);
        setHierarchy(e.u());
    }

    private void m7641c() {
        this.f4837e = AnimatedZoomableController.m7625i();
        this.f4837e.mo338a(this.f4840h);
        this.f4838f = new GestureDetector(getContext(), this.f4841i);
    }

    private void m7633a(RectF rectF) {
        ((GenericDraweeHierarchy) getHierarchy()).a(rectF);
    }

    private void m7637b(RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    public void setZoomableController(ZoomableController zoomableController) {
        Preconditions.a(zoomableController);
        this.f4837e.mo338a(null);
        this.f4837e = zoomableController;
        this.f4837e.mo338a(this.f4840h);
    }

    public ZoomableController getZoomableController() {
        return this.f4837e;
    }

    public void setTapListener(SimpleOnGestureListener simpleOnGestureListener) {
        this.f4841i.f4830a = simpleOnGestureListener;
    }

    public void setIsLongpressEnabled(boolean z) {
        this.f4838f.setIsLongpressEnabled(z);
    }

    public void setController(@Nullable DraweeController draweeController) {
        m7635a(draweeController, null);
    }

    private void m7635a(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        m7639b(null, null);
        this.f4837e.mo341b(false);
        m7639b(draweeController, draweeController2);
    }

    private void m7639b(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        m7634a(getController());
        m7638b(draweeController);
        this.f4836d = draweeController2;
        super.setController(draweeController);
    }

    private void m7642d() {
        if (this.f4836d != null && this.f4837e.mo344m() > 1.1f) {
            m7639b(this.f4836d, null);
        }
    }

    private void m7634a(DraweeController draweeController) {
        if (draweeController instanceof AbstractDraweeController) {
            AbstractDraweeController abstractDraweeController = (AbstractDraweeController) draweeController;
            ControllerListener controllerListener = this.f4839g;
            Preconditions.a(controllerListener);
            if (abstractDraweeController.g instanceof InternalForwardingListener) {
                ((InternalForwardingListener) abstractDraweeController.g).b(controllerListener);
            } else if (abstractDraweeController.g == controllerListener) {
                abstractDraweeController.g = null;
            }
        }
    }

    private void m7638b(DraweeController draweeController) {
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).a(this.f4839g);
        }
    }

    protected void onDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.f4837e.mo345p());
        super.onDraw(canvas);
        canvas.restoreToCount(save);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1317926661);
        int actionMasked = motionEvent.getActionMasked();
        Class cls = f4833a;
        Integer.valueOf(actionMasked);
        Integer.valueOf(hashCode());
        if (this.f4838f.onTouchEvent(motionEvent)) {
            cls = f4833a;
            Integer.valueOf(actionMasked);
            Integer.valueOf(hashCode());
            Logger.a(2, EntryType.UI_INPUT_END, -508235156, a);
            return true;
        } else if (this.f4837e.mo339a(motionEvent)) {
            if (!this.f4837e.mo342b()) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            cls = f4833a;
            Integer.valueOf(actionMasked);
            Integer.valueOf(hashCode());
            LogUtils.a(1913471510, a);
            return true;
        } else if (super.onTouchEvent(motionEvent)) {
            cls = f4833a;
            Integer.valueOf(actionMasked);
            Integer.valueOf(hashCode());
            LogUtils.a(353779372, a);
            return true;
        } else {
            LogUtils.a(1095980062, a);
            return false;
        }
    }

    private void m7645g() {
        m7633a(this.f4834b);
        m7637b(this.f4835c);
        this.f4837e.mo337a(this.f4834b);
        this.f4837e.mo340b(this.f4835c);
        Class cls = f4833a;
        Integer.valueOf(hashCode());
    }

    public static void m7643e(ZoomableDraweeView zoomableDraweeView) {
        Class cls = f4833a;
        Integer.valueOf(zoomableDraweeView.hashCode());
        if (!zoomableDraweeView.f4837e.mo343j()) {
            zoomableDraweeView.m7645g();
            zoomableDraweeView.f4837e.mo341b(true);
        }
    }

    public static void m7644f(ZoomableDraweeView zoomableDraweeView) {
        Class cls = f4833a;
        Integer.valueOf(zoomableDraweeView.hashCode());
        zoomableDraweeView.f4837e.mo341b(false);
    }

    protected void m7647a(Matrix matrix) {
        Class cls = f4833a;
        Integer.valueOf(hashCode());
        m7642d();
        invalidate();
    }

    protected Class<?> getLogTag() {
        return f4833a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Class cls = f4833a;
        Integer.valueOf(hashCode());
        super.onLayout(z, i, i2, i3, i4);
        m7645g();
    }

    private static ZoomableController m7646h() {
        return AnimatedZoomableController.m7625i();
    }
}
