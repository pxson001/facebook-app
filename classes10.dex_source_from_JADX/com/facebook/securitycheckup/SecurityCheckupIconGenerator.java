package com.facebook.securitycheckup;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.securitycheckup.items.SecurityCheckupItem.ItemType;
import com.facebook.securitycheckup.utils.ViewUtil;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringClock;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringSystemFrameCallbackWrapper;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;

/* compiled from: inbox_units_db */
public class SecurityCheckupIconGenerator {
    public static final SpringConfig f9655a = new SpringConfig(60.0d, 8.0d);
    private static final SpringConfig f9656b = new SpringConfig(100.0d, 5.0d);
    private ImageView f9657c;
    public ImageView f9658d;
    public ImageView f9659e;
    public ImageView f9660f;
    private ImageView f9661g;
    private ImageView f9662h;
    public SpringSystem f9663i;
    public Spring f9664j;
    public Spring f9665k;
    public Spring f9666l;
    private ItemType f9667m;
    public FrameLayout f9668n;
    public boolean f9669o = false;
    private TransitionDrawable f9670p;
    private AnimationState f9671q;

    /* compiled from: inbox_units_db */
    public class C14351 implements Runnable {
        final /* synthetic */ SecurityCheckupIconGenerator f9646a;

        public C14351(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9646a = securityCheckupIconGenerator;
        }

        public void run() {
            this.f9646a.f9664j.a(0.0d).b(1.0d).c(6.0d);
        }
    }

    /* compiled from: inbox_units_db */
    class C14362 implements Runnable {
        final /* synthetic */ SecurityCheckupIconGenerator f9647a;

        C14362(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9647a = securityCheckupIconGenerator;
        }

        public void run() {
            this.f9647a.f9664j.a(0.0d).b(1.0d).c(6.0d);
        }
    }

    /* compiled from: inbox_units_db */
    class C14373 implements Runnable {
        final /* synthetic */ SecurityCheckupIconGenerator f9648a;

        C14373(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9648a = securityCheckupIconGenerator;
        }

        public void run() {
            this.f9648a.f9666l.a(0.0d).b(1.0d).c(30.0d);
        }
    }

    /* compiled from: inbox_units_db */
    class C14384 implements Runnable {
        final /* synthetic */ SecurityCheckupIconGenerator f9649a;

        C14384(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9649a = securityCheckupIconGenerator;
        }

        public void run() {
            this.f9649a.f9665k.a(0.0d).b(1.0d).c(30.0d);
        }
    }

    /* compiled from: inbox_units_db */
    public class C14395 implements Runnable {
        final /* synthetic */ SecurityCheckupIconGenerator f9650a;

        public C14395(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9650a = securityCheckupIconGenerator;
        }

        public void run() {
            this.f9650a.f9664j.a(0.0d).b(1.0d).c(6.0d);
        }
    }

    /* compiled from: inbox_units_db */
    public enum AnimationState {
        INITIAL,
        ANIMATED
    }

    /* compiled from: inbox_units_db */
    class LeftKeySpringListener extends SimpleSpringListener {
        final /* synthetic */ SecurityCheckupIconGenerator f9652a;

        public LeftKeySpringListener(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9652a = securityCheckupIconGenerator;
        }

        public final void m9882a(Spring spring) {
            this.f9652a.f9659e.setRotation((float) SpringUtil.a((double) ((float) spring.d()), 0.0d, 1.0d, 0.0d, 10.0d));
        }

        public final void m9883b(Spring spring) {
            this.f9652a.f9659e.setRotation(10.0f);
        }
    }

    /* compiled from: inbox_units_db */
    class RightKeySpringListener extends SimpleSpringListener {
        final /* synthetic */ SecurityCheckupIconGenerator f9653a;

        public RightKeySpringListener(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9653a = securityCheckupIconGenerator;
        }

        public final void m9884a(Spring spring) {
            this.f9653a.f9660f.setRotation((float) SpringUtil.a((double) ((float) spring.d()), 0.0d, 1.0d, 0.0d, 10.0d));
        }

        public final void m9885b(Spring spring) {
            this.f9653a.f9660f.setRotation(10.0f);
        }
    }

    /* compiled from: inbox_units_db */
    public class ShieldSpringListener extends SimpleSpringListener {
        final /* synthetic */ SecurityCheckupIconGenerator f9654a;

        public ShieldSpringListener(SecurityCheckupIconGenerator securityCheckupIconGenerator) {
            this.f9654a = securityCheckupIconGenerator;
        }

        public final void m9886a(Spring spring) {
            float d = (float) spring.d();
            this.f9654a.f9658d.setVisibility(0);
            this.f9654a.f9658d.setScaleX(d);
            this.f9654a.f9658d.setScaleY(d);
        }

        public final void m9887b(Spring spring) {
            this.f9654a.f9658d.setScaleX(1.0f);
            this.f9654a.f9658d.setScaleY(1.0f);
        }
    }

    public SecurityCheckupIconGenerator(FrameLayout frameLayout, ItemType itemType, boolean z) {
        this.f9668n = frameLayout;
        this.f9667m = itemType;
        this.f9671q = AnimationState.INITIAL;
        this.f9663i = new SpringSystem(new SpringClock(), new DefaultChoreographerWrapper(), new SpringSystemFrameCallbackWrapper());
        this.f9669o = z;
        switch (this.f9667m) {
            case INTRO:
                this.f9658d = (ImageView) LayoutInflater.from(this.f9668n.getContext()).inflate(2130907031, this.f9668n, true).findViewById(2131567347);
                this.f9664j = this.f9663i.a().a(f9655a).a(new ShieldSpringListener(this));
                return;
            case LOGIN_ALERTS:
                m9890e();
                return;
            case PASSWORD:
                m9891f();
                return;
            case UNUSED_SESSIONS:
                m9889d();
                return;
            case CONCLUSION:
                m9892g();
                return;
            default:
                return;
        }
    }

    private void m9889d() {
        View inflate = LayoutInflater.from(this.f9668n.getContext()).inflate(2130907037, this.f9668n, true);
        this.f9670p = new TransitionDrawable(new Drawable[]{this.f9668n.getResources().getDrawable(2130843260), this.f9668n.getResources().getDrawable(2130843257)});
        this.f9657c = (ImageView) inflate.findViewById(2131567370);
        this.f9657c.setImageDrawable(this.f9670p);
        this.f9661g = (ImageView) inflate.findViewById(2131567372);
        this.f9662h = (ImageView) inflate.findViewById(2131567374);
    }

    private void m9890e() {
        View inflate = LayoutInflater.from(this.f9668n.getContext()).inflate(2130907032, this.f9668n, true);
        this.f9670p = new TransitionDrawable(new Drawable[]{this.f9668n.getResources().getDrawable(2130843260), this.f9668n.getResources().getDrawable(2130843254)});
        this.f9657c = (ImageView) inflate.findViewById(2131567348);
        this.f9657c.setImageDrawable(this.f9670p);
        this.f9658d = (ImageView) inflate.findViewById(2131567350);
        this.f9658d.setScaleX(0.0f);
        this.f9658d.setScaleY(0.0f);
    }

    private void m9891f() {
        View inflate = LayoutInflater.from(this.f9668n.getContext()).inflate(2130907035, this.f9668n, true);
        this.f9670p = new TransitionDrawable(new Drawable[]{this.f9668n.getResources().getDrawable(2130843260), this.f9668n.getResources().getDrawable(2130843255)});
        this.f9657c = (ImageView) inflate.findViewById(2131567360);
        this.f9657c.setImageDrawable(this.f9670p);
        this.f9659e = (ImageView) inflate.findViewById(2131567361);
        this.f9660f = (ImageView) inflate.findViewById(2131567362);
        DisplayMetrics displayMetrics = this.f9668n.getContext().getResources().getDisplayMetrics();
        this.f9660f.setPivotX((float) ViewUtil.m10068a(displayMetrics, 9));
        this.f9660f.setPivotY((float) ViewUtil.m10068a(displayMetrics, 2));
        this.f9659e.setPivotX((float) ViewUtil.m10068a(displayMetrics, 18));
        this.f9659e.setPivotY((float) ViewUtil.m10068a(displayMetrics, 4));
        this.f9665k = this.f9663i.a().a(f9656b).a(new LeftKeySpringListener(this));
        this.f9666l = this.f9663i.a().a(f9656b).a(new RightKeySpringListener(this));
    }

    private void m9892g() {
        this.f9658d = (ImageView) LayoutInflater.from(this.f9668n.getContext()).inflate(2130907025, this.f9668n, true).findViewById(2131567307);
        if (!this.f9669o) {
            this.f9658d.setScaleX(0.0f);
            this.f9658d.setScaleY(0.0f);
        }
    }

    public final void m9899a() {
        switch (this.f9667m) {
            case INTRO:
                if (!this.f9669o) {
                    this.f9658d.setScaleX(0.0f);
                    this.f9658d.setScaleY(0.0f);
                    HandlerDetour.b(new Handler(), new C14351(this), 300, 1339499042);
                    break;
                }
                break;
            case LOGIN_ALERTS:
                if (this.f9671q == AnimationState.INITIAL) {
                    m9888a(500, true);
                }
                m9894j();
                break;
            case PASSWORD:
                if (this.f9671q == AnimationState.INITIAL) {
                    m9888a(500, true);
                }
                m9895k();
                break;
            case UNUSED_SESSIONS:
                if (this.f9671q == AnimationState.INITIAL) {
                    m9888a(500, true);
                }
                m9893i();
                break;
            case CONCLUSION:
                if (!this.f9669o) {
                    this.f9664j = this.f9663i.a().a(f9655a).a(new ShieldSpringListener(this));
                    HandlerDetour.b(new Handler(), new C14395(this), 300, -16549704);
                    break;
                }
                break;
        }
        this.f9671q = AnimationState.ANIMATED;
    }

    private void m9888a(int i, boolean z) {
        if (this.f9670p == null) {
            return;
        }
        if (z) {
            this.f9670p.startTransition(i);
        } else {
            this.f9670p.reverseTransition(i);
        }
    }

    private void m9893i() {
        m9896m();
        DisplayMetrics displayMetrics = this.f9668n.getContext().getResources().getDisplayMetrics();
        this.f9661g.animate().translationYBy((float) (-ViewUtil.m10068a(displayMetrics, 100))).setStartDelay(250).setDuration(500).setInterpolator(new DecelerateInterpolator());
        this.f9662h.setVisibility(0);
        this.f9662h.animate().translationXBy((float) (-ViewUtil.m10068a(displayMetrics, 30))).setStartDelay(300).setDuration(200).setInterpolator(new DecelerateInterpolator());
    }

    private void m9894j() {
        m9897n();
        this.f9664j = this.f9663i.a().a(f9655a).a(new ShieldSpringListener(this));
        HandlerDetour.b(new Handler(), new C14362(this), 1000, -2048355294);
    }

    private void m9895k() {
        m9898o();
        HandlerDetour.b(new Handler(), new C14373(this), 200, -2117867798);
        HandlerDetour.b(new Handler(), new C14384(this), 300, 592869194);
    }

    public final void m9900b() {
        switch (this.f9667m) {
            case LOGIN_ALERTS:
                m9897n();
                break;
            case PASSWORD:
                m9898o();
                break;
            case UNUSED_SESSIONS:
                m9896m();
                break;
        }
        m9888a(500, false);
        this.f9671q = AnimationState.INITIAL;
    }

    private void m9896m() {
        if (this.f9661g != null) {
            this.f9661g.animate().cancel();
            this.f9662h.animate().cancel();
            this.f9661g.setTranslationY(0.0f);
            this.f9662h.setTranslationX(0.0f);
            this.f9662h.setVisibility(4);
        }
    }

    private void m9897n() {
        if (this.f9664j != null) {
            this.f9664j.a();
            this.f9664j = null;
        }
        this.f9658d.setScaleX(0.0f);
        this.f9658d.setScaleY(0.0f);
    }

    private void m9898o() {
        if (this.f9665k != null && this.f9666l != null) {
            this.f9665k.a(1.0d).l();
            this.f9666l.a(1.0d).l();
        }
    }
}
