package com.facebook.backstage.nub;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.nub.FloatingWindowManager.C05702;
import com.facebook.backstage.nub.FullWindowView.C05731;
import com.facebook.backstage.nub.FullWindowView.C05742;
import com.facebook.backstage.nub.FullWindowView.ViewState;
import com.facebook.backstage.nub.NubView.DrawingMode;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.backstage.util.BetterGestureDetector;
import com.facebook.backstage.util.BetterGestureListener;
import com.facebook.backstage.util.BetterGestureListener.TouchEventState;
import com.facebook.backstage.util.SwipeGestureHelper;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;

/* compiled from: reply_flow */
public class WindowManagerDrawerController extends BetterGestureListener {
    private static final String f5470a = WindowManagerDrawerController.class.getSimpleName();
    public final NubWindow f5471b;
    public final FullWindow f5472c;
    private final ScreenUtil f5473d;
    public final int[] f5474e;
    public final BetterGestureDetector f5475f;
    public final ProxyFullWindow f5476g;
    private boolean f5477h;
    private float f5478i;

    /* compiled from: reply_flow */
    class C05771 implements Runnable {
        final /* synthetic */ WindowManagerDrawerController f5466a;

        C05771(WindowManagerDrawerController windowManagerDrawerController) {
            this.f5466a = windowManagerDrawerController;
        }

        public void run() {
            this.f5466a.f5472c.m5651d();
            FullWindowView fullWindowView = (FullWindowView) this.f5466a.f5472c.f5411b;
            int i = this.f5466a.f5474e[0];
            int i2 = this.f5466a.f5474e[1];
            fullWindowView.f5445d.m5679a(i, fullWindowView.f5443b.m4551a());
            fullWindowView.f5445d.setX((float) i);
            fullWindowView.f5445d.setY((float) i2);
            fullWindowView.f5447f = i < fullWindowView.f5443b.m4553c();
        }
    }

    /* compiled from: reply_flow */
    class C05782 implements OnFinishListener {
        final /* synthetic */ WindowManagerDrawerController f5467a;

        C05782(WindowManagerDrawerController windowManagerDrawerController) {
            this.f5467a = windowManagerDrawerController;
        }

        public final void mo142a() {
            ((FullWindowView) this.f5467a.f5472c.f5411b).m5668f();
            this.f5467a.f5471b.m5681d();
        }
    }

    /* compiled from: reply_flow */
    class C05793 implements OnFinishListener {
        final /* synthetic */ WindowManagerDrawerController f5468a;

        C05793(WindowManagerDrawerController windowManagerDrawerController) {
            this.f5468a = windowManagerDrawerController;
        }

        public final void mo142a() {
            this.f5468a.f5476g.m5695e();
            this.f5468a.mo210e();
        }
    }

    /* compiled from: reply_flow */
    class C05804 implements OnFinishListener {
        final /* synthetic */ WindowManagerDrawerController f5469a;

        C05804(WindowManagerDrawerController windowManagerDrawerController) {
            this.f5469a = windowManagerDrawerController;
        }

        public final void mo142a() {
            this.f5469a.mo210e();
        }
    }

    public WindowManagerDrawerController(Context context, NubWindow nubWindow, FullWindow fullWindow, ProxyFullWindow proxyFullWindow, ScreenUtil screenUtil, int[] iArr) {
        this.f5471b = nubWindow;
        this.f5472c = fullWindow;
        this.f5476g = proxyFullWindow;
        this.f5473d = screenUtil;
        this.f5474e = iArr;
        this.f5475f = new BetterGestureDetector(context, this);
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.f5089e == TouchEventState.ON_UP || this.f5089e == TouchEventState.ON_FLING) {
            DrawingMode drawingMode;
            this.f5477h = SwipeGestureHelper.m5780a((int) motionEvent.getRawX(), this.f5473d.m4551a());
            FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
            boolean z = this.f5477h;
            fullWindowView.f5446e = ViewState.SWIPING_VIEW;
            fullWindowView.f5445d.f5457a = false;
            fullWindowView.mo196a(-100000);
            NubView nubView = fullWindowView.f5445d;
            if (z) {
                drawingMode = DrawingMode.ARC_RIGHT;
            } else {
                drawingMode = DrawingMode.ARC_LEFT;
            }
            nubView.f5462f = drawingMode;
            fullWindowView.f5445d.invalidate();
            this.f5478i = motionEvent.getRawX();
            this.f5471b.m5681d();
        } else {
            BLog.b(f5470a, "Wrong touch event before onDown : %s", new Object[]{this.f5089e});
        }
        return super.onDown(motionEvent);
    }

    public final void mo185a(MotionEvent motionEvent, float f, float f2) {
        if (this.f5087c) {
            FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
            int i = (int) f;
            int i2 = (int) f2;
            if (ViewAnimator.m5752a(fullWindowView.f5445d).m5758c()) {
                fullWindowView.f5449h += (float) i;
                fullWindowView.f5450i += (float) i2;
                ViewAnimator.m5752a(fullWindowView.f5445d).f5528e = new C05731(fullWindowView);
            } else {
                fullWindowView.f5445d.setXBy((float) i);
                fullWindowView.f5445d.setYBy((float) i2);
            }
        } else if (this.f5089e == TouchEventState.ON_MOVE || this.f5089e == TouchEventState.ON_DOWN) {
            FullWindowView fullWindowView2 = (FullWindowView) this.f5472c.f5411b;
            int rawX = (int) motionEvent.getRawX();
            fullWindowView2.mo197a(fullWindowView2.f5445d.getWidth() / 2, (int) fullWindowView2.f5445d.getArcWidth(), rawX, this.f5477h);
        } else {
            BLog.b(f5470a, "Invalid previous touch state onMove : %s", new Object[]{this.f5089e});
        }
        super.mo185a(motionEvent, f, f2);
    }

    public final void mo210e() {
        this.f5472c.m5652e();
        this.f5476g.m5695e();
        ((FullWindowView) this.f5472c.f5411b).m5662b();
        this.f5472c.m5639b();
        FloatingWindow floatingWindow = this.f5471b;
        floatingWindow.m5639b();
        ((NubView) floatingWindow.f5411b).f5457a = false;
        floatingWindow.m5638a(true);
        this.f5471b.m5680a(this.f5474e[0], this.f5474e[1], this.f5473d.m4551a());
        ((NubView) this.f5471b.f5411b).postInvalidate();
        HandlerDetour.a(new Handler(), new C05771(this), 374822391);
    }

    public final void m5704f() {
        this.f5472c.m5639b();
        this.f5472c.m5653f();
        this.f5476g.m5695e();
        FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
        OnFinishListener c05782 = new C05782(this);
        fullWindowView.f5446e = ViewState.SHOWING_CAMERA;
        fullWindowView.mo200b(c05782);
    }

    public final void m5705g() {
        Preconditions.checkArgument(((NubView) this.f5471b.f5411b).f5457a);
        this.f5471b.m5680a(this.f5474e[0], this.f5474e[1], this.f5473d.m4551a());
        this.f5472c.m5652e();
        FloatingWindow floatingWindow = this.f5476g;
        floatingWindow.m5639b();
        floatingWindow.m5638a(true);
        FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
        int i = this.f5474e[0];
        OnFinishListener c05793 = new C05793(this);
        fullWindowView.f5446e = ViewState.HIDING_CAMERA;
        fullWindowView.mo199b(i, c05793);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f5472c.m5653f();
        FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        fullWindowView.f5446e = ViewState.REPOSITIONING;
        fullWindowView.f5445d.f5457a = false;
        View view = fullWindowView.f5445d;
        switch (view.f5462f) {
            case CIRCLE:
                break;
            case ARC_LEFT:
                view.setX(view.getX() - view.m5678a());
                break;
            case ARC_RIGHT:
                view.setX(view.getX() + view.m5678a());
                break;
        }
        view.f5462f = DrawingMode.CIRCLE;
        ViewAnimator.m5752a(view).m5756b(view.getX(), rawX - (((float) view.f5458b) / 2.0f)).m5757c(view.getY(), rawY - (((float) view.f5459c) / 2.0f)).m5759d();
        fullWindowView.mo203e();
        ViewAnimator.m5752a(fullWindowView.f5448g).m5761e().m5757c(fullWindowView.f5448g.getY(), (float) (fullWindowView.f5443b.m4552b() - fullWindowView.f5448g.getHeight())).m5759d();
        fullWindowView.f5445d.invalidate();
        this.f5471b.m5681d();
        super.onLongPress(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.f5087c) {
            if (((FullWindowView) this.f5472c.f5411b).m5671j()) {
                m5700h();
                return true;
            }
            m5699a((int) motionEvent2.getRawX(), ((FullWindowView) this.f5472c.f5411b).getNubY());
        } else if (this.f5089e == TouchEventState.ON_MOVE || this.f5089e == TouchEventState.ON_DOWN) {
            m5704f();
        } else {
            BLog.b(f5470a, "Invalid previous touch state onUp : %s", new Object[]{this.f5089e});
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public final void mo184a(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        if (this.f5087c) {
            if (((FullWindowView) this.f5472c.f5411b).m5671j()) {
                m5700h();
                return;
            } else {
                ((FullWindowView) this.f5472c.f5411b).m5662b();
                m5699a(rawX, ((FullWindowView) this.f5472c.f5411b).getNubY());
            }
        } else if (this.f5089e == TouchEventState.ON_MOVE) {
            ((FullWindowView) this.f5472c.f5411b).m5662b();
            if (SwipeGestureHelper.m5779a(((float) rawX) - this.f5478i, (float) (this.f5473d.m4551a() / 2))) {
                m5704f();
            } else {
                m5705g();
            }
        } else if (this.f5089e == TouchEventState.ON_DOWN) {
            mo210e();
        } else {
            BLog.b(f5470a, "Invalid previous touch state onUp : %s", new Object[]{this.f5089e});
        }
        super.mo184a(motionEvent);
    }

    private void m5699a(int i, int i2) {
        int a = (int) ((NubView) this.f5471b.f5411b).m5678a();
        int arcWidth = (int) ((NubView) this.f5471b.f5411b).getArcWidth();
        int a2 = this.f5473d.m4551a();
        a = i > a2 / 2 ? a2 - arcWidth : -a;
        if (i > a2 / 2) {
            arcWidth = a2 - ((NubView) this.f5471b.f5411b).getWidth();
        } else {
            arcWidth = 0;
        }
        this.f5474e[0] = arcWidth;
        this.f5474e[1] = i2;
        Preconditions.checkArgument(((NubView) this.f5471b.f5411b).f5457a);
        this.f5471b.m5680a(this.f5474e[0], this.f5474e[1], a2);
        FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
        OnFinishListener c05804 = new C05804(this);
        fullWindowView.f5446e = ViewState.DOCKING_NUB;
        fullWindowView.f5447f = a <= fullWindowView.f5443b.m4553c();
        C05702 c05702 = fullWindowView.f5444c;
        boolean z = fullWindowView.f5447f;
        c05702.f5415a.f5428j.m5640b((int) (((float) c05702.f5415a.f5429k.m4551a()) * 0.3f));
        if (z) {
            c05702.f5415a.f5428j.m5637a(0);
        } else {
            c05702.f5415a.f5428j.m5637a((int) (((float) c05702.f5415a.f5429k.m4551a()) * 0.7f));
        }
        ViewAnimator.m5752a(fullWindowView.f5448g).m5761e().m5757c(fullWindowView.f5448g.getY(), (float) fullWindowView.f5443b.m4552b()).m5759d();
        ViewAnimator e = ViewAnimator.m5752a(fullWindowView.f5445d).m5761e();
        e.f5528e = c05804;
        e.m5756b(fullWindowView.f5445d.getX(), (float) a).m5759d();
    }

    private void m5700h() {
        FullWindowView fullWindowView = (FullWindowView) this.f5472c.f5411b;
        ViewAnimator.m5752a(fullWindowView.f5445d).m5761e().m5757c(fullWindowView.f5445d.getY(), (float) fullWindowView.f5443b.m4552b()).m5759d();
        ViewAnimator c = ViewAnimator.m5752a(fullWindowView.f5448g).m5761e().m5757c(fullWindowView.f5448g.getY(), (float) fullWindowView.f5443b.m4552b());
        c.f5528e = new C05742(fullWindowView);
        c.m5759d();
    }
}
