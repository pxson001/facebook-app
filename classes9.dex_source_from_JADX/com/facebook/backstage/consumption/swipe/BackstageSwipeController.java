package com.facebook.backstage.consumption.swipe;

import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.util.BetterGestureListener;
import com.facebook.backstage.util.SwipeGestureHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.pager.PagerViewController;
import com.facebook.pager.PagerViewController.ScrollState;
import com.facebook.pager.PagerViewDataAdapter;
import com.facebook.pager.RenderInfo;
import com.facebook.pager.renderers.standard.PagerViewItem;
import com.facebook.pager.renderers.standard.StandardPagerViewRenderer;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;

/* compiled from: ride_type_id */
public class BackstageSwipeController<Data, Item extends PagerViewItem<Data>> {
    public final BetterGestureListener f5092a = new C05461(this);
    public final ScreenUtil f5093b;
    private final SpringSystem f5094c;
    private final AbstractFbErrorReporter f5095d;
    private StandardPagerViewRenderer<Data, Item> f5096e;
    public PagerViewController<Data> f5097f;
    private Spring f5098g;
    @Nullable
    public GestureEventListener f5099h;

    /* compiled from: ride_type_id */
    public interface GestureEventListener {
        void mo177c();

        void mo178d();
    }

    /* compiled from: ride_type_id */
    class C05461 extends BetterGestureListener {
        final /* synthetic */ BackstageSwipeController f5090a;
        private float f5091b;

        C05461(BackstageSwipeController backstageSwipeController) {
            this.f5090a = backstageSwipeController;
        }

        public boolean onDown(MotionEvent motionEvent) {
            super.onDown(motionEvent);
            this.f5091b = motionEvent.getX();
            PagerViewController pagerViewController = this.f5090a.f5097f;
            if (pagerViewController.f18410z.equals(ScrollState.IDLE)) {
                pagerViewController.f18392h = pagerViewController.f18391g;
            }
            PagerViewController.m18376a(pagerViewController, ScrollState.IDLE);
            pagerViewController.f18398n.l();
            return true;
        }

        public final void mo185a(MotionEvent motionEvent, float f, float f2) {
            super.mo185a(motionEvent, f, f2);
            this.f5090a.f5097f.m18384a(-f);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            super.onFling(motionEvent, motionEvent2, f, f2);
            if (f <= 0.0f) {
                this.f5090a.f5097f.m18385a(f, 1);
            } else {
                this.f5090a.f5097f.m18387b(f, 1);
            }
            return true;
        }

        public final void mo184a(MotionEvent motionEvent) {
            super.mo184a(motionEvent);
            boolean a = SwipeGestureHelper.m5780a((int) this.f5091b, this.f5090a.f5093b.m4551a());
            if (!SwipeGestureHelper.m5779a(motionEvent.getX() - this.f5091b, (float) this.f5090a.f5093b.m4553c())) {
                PagerViewController pagerViewController = this.f5090a.f5097f;
                int i = pagerViewController.f18384I;
                if ((Math.abs(10.0f) > ((float) i) ? 1 : 0) == 0) {
                    pagerViewController.m18386a(pagerViewController.f18377B, 0.0f);
                } else if (10.0f > ((float) i)) {
                    pagerViewController.m18387b(10.0f, 1);
                } else if (10.0f < ((float) (-i))) {
                    pagerViewController.m18385a(10.0f, 1);
                }
            } else if (a) {
                this.f5090a.f5097f.m18385a(10.0f, 1);
            } else {
                this.f5090a.f5097f.m18387b(10.0f, 1);
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (this.f5090a.f5099h != null) {
                this.f5090a.f5099h.mo177c();
            }
            return super.onSingleTapUp(motionEvent);
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f5090a.f5099h != null) {
                this.f5090a.f5099h.mo178d();
            }
            super.onLongPress(motionEvent);
        }
    }

    public BackstageSwipeController(ScreenUtil screenUtil, SpringSystem springSystem, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5093b = screenUtil;
        this.f5094c = springSystem;
        this.f5095d = abstractFbErrorReporter;
    }

    public final void m4889a(StandardPagerViewRenderer standardPagerViewRenderer, float f, float f2, List<Data> list) {
        this.f5096e = standardPagerViewRenderer;
        this.f5098g = this.f5094c.a().a(SpringConfig.a(80.0d, 11.0d));
        this.f5098g.k = 1.0d;
        this.f5098g.e(1.0d);
        PagerViewDataAdapter pagerViewDataAdapter = new PagerViewDataAdapter();
        pagerViewDataAdapter.mo715a((List) list);
        this.f5097f = new PagerViewController(pagerViewDataAdapter, this.f5096e, this.f5095d, this.f5098g, f, f2, 1, 0, false);
    }

    public final Item m4890c() {
        if (this.f5096e == null) {
            return null;
        }
        Item item;
        StandardPagerViewRenderer standardPagerViewRenderer = this.f5096e;
        for (int i = 0; i < standardPagerViewRenderer.f18424b.size(); i++) {
            RenderInfo renderInfo = (RenderInfo) standardPagerViewRenderer.f18424b.get(i);
            if (renderInfo.equals(standardPagerViewRenderer.f18426d)) {
                item = (PagerViewItem) renderInfo.f18417c;
                break;
            }
        }
        item = null;
        return item;
    }

    public final void m4891d() {
        if (this.f5096e != null) {
            int i;
            this.f5096e.m18417b();
            StandardPagerViewRenderer standardPagerViewRenderer = this.f5096e;
            int i2 = 0;
            Builder builder = new Builder();
            for (i = 0; i < standardPagerViewRenderer.f18424b.size(); i++) {
                builder.c(((RenderInfo) standardPagerViewRenderer.f18424b.get(i)).f18417c);
            }
            for (i = 0; i < standardPagerViewRenderer.f18427e.size(); i++) {
                builder.c(((RenderInfo) standardPagerViewRenderer.f18427e.get(i)).f18417c);
            }
            while (i2 < standardPagerViewRenderer.f18429g.size()) {
                builder.c((PagerViewItem) standardPagerViewRenderer.f18429g.get(i2));
                i2++;
            }
            List b = builder.b();
            for (int i3 = 0; i3 < b.size(); i3++) {
                PagerViewItem pagerViewItem = (PagerViewItem) b.get(i3);
                pagerViewItem.setIsInViewport(false);
                pagerViewItem.mo163a();
            }
            standardPagerViewRenderer.f18424b.clear();
            standardPagerViewRenderer.f18427e.clear();
            standardPagerViewRenderer.f18429g.clear();
            standardPagerViewRenderer.f18431i = false;
            this.f5096e = null;
        }
        if (this.f5097f != null) {
            PagerViewController pagerViewController = this.f5097f;
            pagerViewController.f18398n.b(pagerViewController.f18399o);
            pagerViewController.f18386b.mo716b(pagerViewController.f18385a);
            this.f5097f = null;
        }
        if (this.f5098g != null) {
            this.f5098g.a();
        }
    }

    public final void m4888a(GestureEventListener gestureEventListener) {
        this.f5099h = gestureEventListener;
    }
}
