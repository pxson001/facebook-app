package com.facebook.feed.pill;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.HidingScrollListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory;

/* compiled from: popEnterAnim=# */
public class FeedPillUIController {
    public static final SpringConfig f9469a = SpringConfig.m7843b(5.0d, 10.0d);
    public final SpringSystem f9470b;
    public final Rect f9471c;
    public final int[] f9472d = new int[]{0, 0};
    @Inject
    public QeAccessor f9473e;
    @Inject
    public ThrottledOnScrollListenerFactory f9474f;
    public View f9475g;
    public Spring f9476h;
    public AnimationSpringListener f9477i;
    public AnimationState f9478j = AnimationState.HIDDEN;
    public ScrollingViewProxy f9479k;
    public HidingScrollListener f9480l;
    public OnScrollListener f9481m;
    public boolean f9482n;
    public boolean f9483o;

    /* compiled from: popEnterAnim=# */
    public enum AnimationState {
        REVEALING,
        HIDING,
        SHOWN,
        HIDDEN
    }

    /* compiled from: popEnterAnim=# */
    public class C05641 extends HidingScrollListener {
        final /* synthetic */ FeedPillUIController f13808a;

        public C05641(FeedPillUIController feedPillUIController, ScrollingViewProxy scrollingViewProxy, boolean z) {
            this.f13808a = feedPillUIController;
            super(scrollingViewProxy, z);
        }

        public final void aY_() {
            FeedPillUIController.m14472i(this.f13808a);
        }

        public final void mo2675b() {
            FeedPillUIController.m14471h(this.f13808a);
        }

        public final int mo1974a() {
            return this.f13808a.f9473e.mo572a(ExperimentsForNewsFeedAbTestModule.ad, 0);
        }
    }

    /* compiled from: popEnterAnim=# */
    public class AnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ FeedPillUIController f13821a;

        public AnimationSpringListener(FeedPillUIController feedPillUIController) {
            this.f13821a = feedPillUIController;
        }

        public final void mo1162c(Spring spring) {
            this.f13821a.f9475g.setVisibility(0);
        }

        public final void mo1160a(Spring spring) {
            float d = (float) spring.m7821d();
            float a = (float) SpringUtil.m11942a((double) d, 0.0d, 1.0d, 0.5d, 1.0d);
            this.f13821a.f9475g.setScaleX(a);
            this.f13821a.f9475g.setScaleY(a);
            if (FeedPillUIController.m14473j(this.f13821a) || FeedPillUIController.m14475m(this.f13821a)) {
                this.f13821a.f9475g.setAlpha(d);
            }
        }

        public final void mo1161b(Spring spring) {
            if (FeedPillUIController.m14475m(this.f13821a)) {
                this.f13821a.f9478j = AnimationState.HIDDEN;
            } else if (FeedPillUIController.m14473j(this.f13821a)) {
                this.f13821a.f9478j = AnimationState.SHOWN;
            }
        }
    }

    /* compiled from: popEnterAnim=# */
    public class C05652 implements OnTouchListener {
        final /* synthetic */ FeedPillUIController f13822a;

        public C05652(FeedPillUIController feedPillUIController) {
            this.f13822a = feedPillUIController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return FeedPillUIController.m14468a(this.f13822a, view, motionEvent);
        }
    }

    public static FeedPillUIController m14467a(InjectorLike injectorLike) {
        FeedPillUIController feedPillUIController = new FeedPillUIController(SpringSystem.m7835b(injectorLike));
        ThrottledOnScrollListenerFactory a = ThrottledOnScrollListenerFactory.m14478a(injectorLike);
        feedPillUIController.f9473e = QeInternalImplMethodAutoProvider.m3744a(injectorLike);
        feedPillUIController.f9474f = a;
        return feedPillUIController;
    }

    @Inject
    public FeedPillUIController(SpringSystem springSystem) {
        this.f9470b = springSystem;
        this.f9471c = new Rect();
    }

    public static boolean m14468a(FeedPillUIController feedPillUIController, View view, MotionEvent motionEvent) {
        feedPillUIController.f9475g.getLocationOnScreen(feedPillUIController.f9472d);
        int i = feedPillUIController.f9472d[0];
        int i2 = feedPillUIController.f9472d[1];
        feedPillUIController.f9471c.set(i, i2, feedPillUIController.f9475g.getWidth() + i, feedPillUIController.f9475g.getHeight() + i2);
        boolean contains = feedPillUIController.f9471c.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        switch (motionEvent.getAction()) {
            case 0:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (contains) {
                    feedPillUIController.m14469f();
                } else {
                    feedPillUIController.m14470g();
                }
                feedPillUIController.f9475g.setPressed(contains);
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (contains) {
                    view.performClick();
                    break;
                }
                break;
            case 3:
                break;
        }
        feedPillUIController.m14470g();
        feedPillUIController.f9475g.setPressed(false);
        return true;
    }

    private void m14469f() {
        if (m14474k()) {
            this.f9476h.m7818b(0.949999988079071d);
        }
    }

    private void m14470g() {
        if (m14474k()) {
            this.f9476h.m7818b(1.0d);
        }
    }

    public static boolean m14471h(FeedPillUIController feedPillUIController) {
        if (m14473j(feedPillUIController) || feedPillUIController.m14474k() || !feedPillUIController.f9482n) {
            return false;
        }
        feedPillUIController.f9478j = AnimationState.REVEALING;
        feedPillUIController.f9476h.m7818b(1.0d);
        if (feedPillUIController.f9480l == null || !feedPillUIController.f9483o) {
            return true;
        }
        feedPillUIController.f9480l.f13810b = true;
        return true;
    }

    public final boolean m14476d() {
        boolean i = m14472i(this);
        this.f9482n = false;
        return i;
    }

    public static boolean m14472i(FeedPillUIController feedPillUIController) {
        if (AnimationState.HIDDEN.equals(feedPillUIController.f9478j) || m14475m(feedPillUIController) || !feedPillUIController.f9482n) {
            return false;
        }
        feedPillUIController.f9478j = AnimationState.HIDING;
        feedPillUIController.f9476h.m7818b(0.0d);
        if (feedPillUIController.f9480l != null && feedPillUIController.f9483o) {
            feedPillUIController.f9480l.f13810b = false;
        }
        return true;
    }

    public static boolean m14473j(FeedPillUIController feedPillUIController) {
        return AnimationState.REVEALING.equals(feedPillUIController.f9478j);
    }

    private boolean m14474k() {
        return AnimationState.SHOWN.equals(this.f9478j);
    }

    public static boolean m14475m(FeedPillUIController feedPillUIController) {
        return AnimationState.HIDING.equals(feedPillUIController.f9478j);
    }

    public final void m14477e() {
        if (this.f9476h != null) {
            this.f9476h.m7817a();
        }
        if (this.f9479k != null && this.f9481m != null) {
            this.f9479k.mo2374c(this.f9481m);
        }
    }
}
