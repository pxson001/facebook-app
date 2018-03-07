package com.facebook.widget.popover;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragDecider;
import com.facebook.fbui.draggable.AdvancedDragDetector.DragListener;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.maps.internal.IMapViewDelegate */
public class SimplePopoverLayout extends CustomFrameLayout implements DragDecider, DragListener {
    @Inject
    public AdvancedDragDetector f19830a;
    public float f19831b;
    private Direction f19832c;
    public BasePopoverDelegate f19833d;
    public ViewGroup f19834e;
    public Optional<ViewGroup> f19835f;
    public ViewGroup f19836g;

    /* compiled from: com.google.android.gms.maps.internal.IMapViewDelegate */
    public class C14891 implements AnimationListener {
        final /* synthetic */ SimplePopoverLayout f19827a;

        public C14891(SimplePopoverLayout simplePopoverLayout) {
            this.f19827a = simplePopoverLayout;
        }

        public void onAnimationStart(Animation animation) {
            this.f19827a.f19833d.mo1357a();
        }

        public void onAnimationEnd(Animation animation) {
            this.f19827a.f19833d.mo1359b();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IMapViewDelegate */
    class C14902 implements AnimationListener {
        final /* synthetic */ SimplePopoverLayout f19828a;

        C14902(SimplePopoverLayout simplePopoverLayout) {
            this.f19828a = simplePopoverLayout;
        }

        public void onAnimationStart(Animation animation) {
            this.f19828a.f19833d.mo1369c();
        }

        public void onAnimationEnd(Animation animation) {
            this.f19828a.f19833d.mo1356d();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IMapViewDelegate */
    class C14913 extends AnimatorListenerAdapter {
        final /* synthetic */ SimplePopoverLayout f19829a;

        C14913(SimplePopoverLayout simplePopoverLayout) {
            this.f19829a = simplePopoverLayout;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f19829a.f19831b = 0.0f;
        }
    }

    public static void m28542a(Object obj, Context context) {
        ((SimplePopoverLayout) obj).f19830a = AdvancedDragDetector.b(FbInjector.get(context));
    }

    public SimplePopoverLayout(Context context, int i) {
        super(context);
        Class cls = SimplePopoverLayout.class;
        m28542a((Object) this, getContext());
        setContentView(i);
        this.f19834e = (ViewGroup) c(2131560065);
        this.f19835f = d(2131562860);
        this.f19836g = (ViewGroup) c(2131562859);
        this.f19830a.q = this;
        this.f19830a.r = this;
        this.f19830a.p = Direction.UP.flag() | Direction.DOWN.flag();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f19830a.a(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1253757203);
        boolean b = this.f19830a.b(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1631795151, a);
        return b;
    }

    public final boolean m28547a(float f, float f2) {
        return true;
    }

    public final boolean m28551b(float f, float f2) {
        return false;
    }

    public final boolean m28548a(float f, float f2, Direction direction) {
        this.f19832c = direction;
        return PopoverUtil.m28516a(this.f19834e, f, f2) || this.f19833d.mo1358a(f, f2, direction);
    }

    public final void m28550b(float f, float f2, Direction direction) {
        this.f19831b += f2;
        getViewToDrag().setTranslationY(this.f19831b);
        if (PopoverUtil.m28515a((int) (((double) getHeight()) * 0.5d), this.f19831b, direction)) {
            m28541a(direction);
        }
    }

    private View getViewToDrag() {
        if (this.f19831b < 0.0f) {
            return this.f19836g;
        }
        return this.f19834e;
    }

    public final void m28552f() {
        m28541a(Direction.DOWN);
    }

    private void m28541a(Direction direction) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), Direction.DOWN == direction ? 2130968756 : 2130968761);
        loadAnimation.setAnimationListener(new C14902(this));
        this.f19836g.startAnimation(loadAnimation);
    }

    public final void m28545a() {
        m28543b(0);
    }

    public final void m28546a(Direction direction, int i) {
        m28543b(i);
    }

    public final void m28549b() {
    }

    private void m28543b(int i) {
        if (Math.abs(i) >= 800 || PopoverUtil.m28515a((int) (((double) this.f19836g.getHeight()) * 0.25d), this.f19831b, this.f19832c)) {
            m28541a(this.f19832c);
        } else {
            m28544h();
        }
    }

    private void m28544h() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getViewToDrag(), "translationY", new float[]{this.f19831b, 0.0f});
        ofFloat.setDuration(300);
        ofFloat.addListener(new C14913(this));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }
}
