package com.facebook.greetingcards.render;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.MathUtil;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feedplugins.greetingcard.GreetingCardPartDefinition.1.1.1;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import com.facebook.widget.CustomViewUtils;

@TargetApi(12)
/* compiled from: {!informational false} */
public class FoldingPopoverFragment extends FbDialogFragment implements SafelyDismissable {
    public static final String am = FoldingPopoverFragment.class.getSimpleName();
    private boolean aA;
    public RenderCardFragment aB;
    public DraggableView an;
    public BackPressAwareFragment ao;
    public FoldingLayout ap;
    public Rect aq;
    public Bitmap ar;
    public StatusBarVisibilityController as;
    public AbstractFbErrorReporter at;
    public boolean au;
    public BackgroundAnimationHandler av;
    public Spring aw;
    public 1 ax;
    public AnalyticsLogger ay;
    public FragmentManager az;

    /* compiled from: {!informational false} */
    public abstract class BackPressAwareFragment extends FbFragment implements AnalyticsFragment {
        public abstract boolean mo6e();
    }

    /* compiled from: {!informational false} */
    class C00331 implements Runnable {
        final /* synthetic */ FoldingPopoverFragment f189a;

        /* compiled from: {!informational false} */
        class C00321 implements Runnable {
            final /* synthetic */ C00331 f188a;

            C00321(C00331 c00331) {
                this.f188a = c00331;
            }

            public void run() {
                FoldingPopoverFragment.as(this.f188a.f189a);
            }
        }

        C00331(FoldingPopoverFragment foldingPopoverFragment) {
            this.f189a = foldingPopoverFragment;
        }

        public void run() {
            Rect a = CustomViewUtils.a(this.f189a.an);
            View frameLayout = new FrameLayout(this.f189a.getContext());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f189a.aq.width(), this.f189a.aq.height(), 48);
            layoutParams.setMargins(this.f189a.aq.left, this.f189a.aq.top - a.top, 0, 0);
            frameLayout.setLayoutParams(layoutParams);
            CustomViewUtils.b(frameLayout, new BitmapDrawable(this.f189a.jW_(), this.f189a.ar));
            this.f189a.an.addView(this.f189a.ap);
            FoldingLayout foldingLayout = this.f189a.ap;
            View findViewById = this.f189a.an.findViewById(2131562106);
            foldingLayout.f173b = frameLayout;
            foldingLayout.addView(foldingLayout.f173b);
            foldingLayout.f174c = findViewById;
            foldingLayout.f174c.setVisibility(4);
            frameLayout.setVisibility(4);
            this.f189a.ap.post(new C00321(this));
        }
    }

    /* compiled from: {!informational false} */
    public class BackgroundAnimationHandler {
        final /* synthetic */ FoldingPopoverFragment f190a;
        public View f191b;
        public Window f192c;
        public Drawable f193d;
        private Drawable f194e;

        public BackgroundAnimationHandler(FoldingPopoverFragment foldingPopoverFragment, View view, Window window) {
            this.f190a = foldingPopoverFragment;
            this.f191b = view;
            if (window != null) {
                this.f192c = window;
                this.f193d = this.f192c.getDecorView().getBackground();
            }
        }

        public final Drawable m197a() {
            if (this.f194e == null) {
                this.f194e = new ColorDrawable(this.f190a.jW_().getColor(17170444));
                this.f194e.setAlpha(0);
            }
            return this.f194e;
        }

        final void m198c() {
            if (this.f192c != null) {
                this.f192c.setBackgroundDrawableResource(17170444);
            }
        }
    }

    /* compiled from: {!informational false} */
    class DragListener implements com.facebook.fbui.draggable.AdvancedDragDetector.DragListener {
        final /* synthetic */ FoldingPopoverFragment f195a;
        private float f196b;
        private Direction f197c;

        public DragListener(FoldingPopoverFragment foldingPopoverFragment) {
            this.f195a = foldingPopoverFragment;
        }

        public final boolean m201a(float f, float f2, Direction direction) {
            if (this.f195a.aB != null) {
                boolean a;
                RenderCardFragment renderCardFragment = this.f195a.aB;
                if (renderCardFragment.am != null) {
                    a = renderCardFragment.am.a(direction);
                } else {
                    a = false;
                }
                if (a) {
                    return false;
                }
            }
            if (this.f195a.ap.f177f == 1.0f) {
                this.f195a.ap.m196a();
            }
            this.f196b = 1.2f / ((float) this.f195a.an.getHeight());
            this.f197c = direction;
            return true;
        }

        public final void m203b(float f, float f2, Direction direction) {
            float f3 = this.f195a.ap.f177f;
            if (this.f197c == Direction.UP) {
                f2 = -f2;
            }
            f3 = MathUtil.b(f3 - (this.f196b * f2), 0.0f, 1.0f);
            if ((((double) f3) > 0.9d && direction == Direction.UP && this.f197c == Direction.DOWN) || (((double) f3) > 0.9d && direction == Direction.DOWN && this.f197c == Direction.UP)) {
                this.f195a.an.m190a();
                FoldingPopoverFragment.as(this.f195a);
            } else if ((((double) f3) < 0.1d && direction == Direction.DOWN && this.f197c == Direction.DOWN) || (((double) f3) < 0.1d && direction == Direction.UP && this.f197c == Direction.UP)) {
                this.f195a.an.m190a();
                this.f195a.ar();
            } else {
                this.f195a.aw.a((double) f3).b((double) f3).f();
            }
        }

        public final void m199a() {
            if (((double) this.f195a.ap.f177f) > 0.5d) {
                FoldingPopoverFragment.as(this.f195a);
            } else {
                this.f195a.ar();
            }
        }

        public final void m200a(Direction direction, int i) {
            if (direction == Direction.UP && this.f197c == Direction.DOWN) {
                FoldingPopoverFragment.m208a(this.f195a, (double) (((float) (-i)) * this.f196b));
            } else {
                FoldingPopoverFragment.m210b(this.f195a, (double) (((float) (-i)) * this.f196b));
            }
        }

        public final void m202b() {
        }
    }

    /* compiled from: {!informational false} */
    class FoldingSpringListener implements SpringListener {
        final /* synthetic */ FoldingPopoverFragment f198a;

        public FoldingSpringListener(FoldingPopoverFragment foldingPopoverFragment) {
            this.f198a = foldingPopoverFragment;
        }

        public final void m205a(Spring spring) {
            float b = (float) spring.b();
            this.f198a.ap.setFoldFactor(b);
            if (this.f198a.av != null) {
                BackgroundAnimationHandler backgroundAnimationHandler = this.f198a.av;
                if (backgroundAnimationHandler.f191b != null) {
                    float min = Math.min(1.0f - (0.050000012f * b), 1.0f);
                    backgroundAnimationHandler.f191b.setScaleX(min);
                    backgroundAnimationHandler.f191b.setScaleY(min);
                    backgroundAnimationHandler.m197a().setAlpha(Math.round(178.0f * b));
                }
            }
        }

        public final void m204a() {
            if (this.f198a.au) {
                if (this.f198a.ax != null) {
                    1 1 = this.f198a.ax;
                    if (1.a.g.c.a == null) {
                        1.a.g.c.a = 1.a.c.aq;
                    }
                    if (1.a.g.c.f != null) {
                        1.a.g.c.f.m267b();
                    }
                }
                this.f198a.a();
            } else if (this.f198a.ax != null) {
                this.f198a.ax.a.c.as();
            }
        }

        public final void m206b() {
        }

        public final void m207b(Spring spring) {
            float b = (float) spring.b();
            if (b == 0.0f || b == 1.0f) {
                this.f198a.ap.m196a();
            }
        }
    }

    /* compiled from: {!informational false} */
    class PopoverDialog extends FbDialog {
        final /* synthetic */ FoldingPopoverFragment f199b;

        public PopoverDialog(FoldingPopoverFragment foldingPopoverFragment) {
            this.f199b = foldingPopoverFragment;
            super(foldingPopoverFragment, foldingPopoverFragment.getContext(), foldingPopoverFragment.d());
        }

        public void onBackPressed() {
            this.f199b.O_();
        }

        public void onWindowFocusChanged(boolean z) {
            FoldingPopoverFragment foldingPopoverFragment = this.f199b;
            if (z && foldingPopoverFragment.as != null) {
                foldingPopoverFragment.as.m266a();
            }
        }
    }

    public static void m209a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FoldingPopoverFragment foldingPopoverFragment = (FoldingPopoverFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        foldingPopoverFragment.at = abstractFbErrorReporter;
        foldingPopoverFragment.ay = a;
    }

    public final void m216a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1493674201);
        super.a(bundle);
        Class cls = FoldingPopoverFragment.class;
        m209a((Object) this, getContext());
        Spring a2 = SpringSystem.b().a();
        a2.c = true;
        this.aw = a2.a(new SpringConfig(180.0d, 27.0d));
        this.aw.a(new FoldingSpringListener(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1703059773, a);
    }

    public final View m213a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2074185292);
        this.an = (DraggableView) layoutInflater.inflate(2130904396, viewGroup, false);
        this.an.setDragListener(new DragListener(this));
        this.as = new StatusBarVisibilityController(this.f.getWindow());
        this.as.m266a();
        if (this.av != null) {
            CustomViewUtils.b(this.an, this.av.m197a());
        }
        m217a(this.ao);
        this.ap = new FoldingLayout(getContext());
        if (!(this.ar == null || this.aq == null)) {
            this.an.post(new C00331(this));
        }
        View view = this.an;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 740773656, a);
        return view;
    }

    public final void m219e(Bundle bundle) {
        if (this.au) {
            a();
        }
        super.e(bundle);
    }

    public final void m211G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 766920163);
        super.G();
        if (this.aA) {
            a();
            this.aA = false;
        }
        if (this.av != null) {
            this.av.m198c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1458865280, a);
    }

    public final void aq() {
        this.aA = true;
    }

    public final void m212I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 502418494);
        super.I();
        if (this.av != null) {
            BackgroundAnimationHandler backgroundAnimationHandler = this.av;
            if (backgroundAnimationHandler.f192c != null) {
                backgroundAnimationHandler.f192c.setBackgroundDrawable(backgroundAnimationHandler.f193d);
            }
        }
        HoneyClientEventFast a2 = this.ay.a("greeting_card_dismissed", false);
        if (a2.a()) {
            a2.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -532840344, a);
    }

    public final Dialog m218c(Bundle bundle) {
        return new PopoverDialog(this);
    }

    public final void m217a(BackPressAwareFragment backPressAwareFragment) {
        if (backPressAwareFragment != null) {
            if (this.ao != backPressAwareFragment) {
                this.ao = backPressAwareFragment;
            }
            s().a().b(2131562106, backPressAwareFragment).a(null).b();
        }
    }

    public final FoldingPopoverFragment m214a(RenderCardFragment renderCardFragment) {
        this.aB = renderCardFragment;
        return this;
    }

    public final void m215a() {
        this.an.setVisibility(8);
        if (this.ar != null) {
            this.ar.recycle();
        }
        b();
        this.az.b();
        this.au = false;
        if (this.av != null) {
            BackgroundAnimationHandler backgroundAnimationHandler = this.av;
            if (backgroundAnimationHandler.f191b != null) {
                backgroundAnimationHandler.f191b.setScaleX(1.0f);
                backgroundAnimationHandler.f191b.setScaleY(1.0f);
            }
        }
    }

    public static void as(FoldingPopoverFragment foldingPopoverFragment) {
        m208a(foldingPopoverFragment, 0.0d);
    }

    public static void m208a(FoldingPopoverFragment foldingPopoverFragment, double d) {
        if (foldingPopoverFragment.av != null) {
            foldingPopoverFragment.av.m198c();
        }
        foldingPopoverFragment.aw.c(d).b(1.0d);
    }

    public final void ar() {
        m210b(this, 0.0d);
    }

    public static void m210b(FoldingPopoverFragment foldingPopoverFragment, double d) {
        foldingPopoverFragment.au = true;
        foldingPopoverFragment.aw.b(0.0d).c(d);
    }

    public final boolean O_() {
        if (this.ao == null || this.ap == null) {
            a();
        } else if (!(this.ao.mo6e() || this.au)) {
            ar();
        }
        return true;
    }
}
