package com.facebook.pages.common.services;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServiceItem;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomViewPager;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: selling_unread */
public class PagesServiceCarousel extends CustomViewPager {
    public PagesServiceCarousel f2324a;
    public PagesServiceCarouselPagerAdapter f2325b;
    private ScrollerCustomDuration f2326c;
    public Handler f2327d;
    private Runnable f2328e;
    private boolean f2329f = true;

    /* compiled from: selling_unread */
    public interface PagesServiceCarouselItemClickListener {
        void mo44a(PageServiceItemModel pageServiceItemModel);
    }

    /* compiled from: selling_unread */
    class C02881 implements Runnable {
        final /* synthetic */ PagesServiceCarousel f2323a;

        C02881(PagesServiceCarousel pagesServiceCarousel) {
            this.f2323a = pagesServiceCarousel;
        }

        public void run() {
            this.f2323a.f2324a.a((this.f2323a.f2324a.k + 1) % this.f2323a.f2325b.b(), true);
            HandlerDetour.b(this.f2323a.f2327d, this, 3000, -278923617);
        }
    }

    /* compiled from: selling_unread */
    class ScrollerCustomDuration extends Scroller {
        public ScrollerCustomDuration(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, 1500);
        }
    }

    public PagesServiceCarousel(Context context) {
        super(context);
        m3291i();
        this.f2324a = this;
        this.f2325b = new PagesServiceCarouselPagerAdapter(context);
        setAdapter(this.f2325b);
        this.f2327d = new Handler();
        this.f2328e = new C02881(this);
        HandlerDetour.b(this.f2327d, this.f2328e, 3000, -2034751299);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((int) (((float) MeasureSpec.getSize(i)) / 1.7777778f), 1073741824));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1713072706);
        m3293g();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1645762851, a);
        return onTouchEvent;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -465376517);
        super.onDetachedFromWindow();
        m3293g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -617013834, a);
    }

    public final void m3293g() {
        if (this.f2327d != null && this.f2328e != null) {
            HandlerDetour.a(this.f2327d, this.f2328e);
            this.f2329f = false;
        }
    }

    public final void m3292a(List<PageServiceItem> list, PagesServiceCarouselItemClickListener pagesServiceCarouselItemClickListener) {
        this.f2325b.m3297a((List) list);
        this.f2325b.f2338b = pagesServiceCarouselItemClickListener;
        if (!this.f2329f && this.f2327d != null && this.f2328e != null) {
            HandlerDetour.b(this.f2327d, this.f2328e, 3000, -1497908707);
            this.f2329f = true;
        }
    }

    private void m3291i() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("o");
            declaredField.setAccessible(true);
            Field declaredField2 = ViewPager.class.getDeclaredField("f");
            declaredField2.setAccessible(true);
            this.f2326c = new ScrollerCustomDuration(getContext(), (Interpolator) declaredField2.get(null));
            declaredField.set(this, this.f2326c);
        } catch (Exception e) {
        }
    }
}
