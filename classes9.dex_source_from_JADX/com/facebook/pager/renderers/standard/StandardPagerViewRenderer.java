package com.facebook.pager.renderers.standard;

import android.view.ViewGroup;
import com.facebook.common.collect.ArraySet;
import com.facebook.pager.PagerViewItemFactory;
import com.facebook.pager.RenderInfo;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.LinkedList;

/* compiled from: ccu_enabled */
public class StandardPagerViewRenderer<T, S extends PagerViewItem<T>> {
    private static final Class<?> f18423a = StandardPagerViewRenderer.class;
    public final ArraySet<RenderInfo<T, S>> f18424b;
    private final ViewGroup f18425c;
    public final RenderInfo<T, S> f18426d = RenderInfo.m18403a();
    public final LinkedList<RenderInfo<T, S>> f18427e;
    private final int f18428f;
    public final LinkedList<S> f18429g;
    private final PagerViewItemFactory<S> f18430h;
    public boolean f18431i;
    private boolean f18432j;

    public StandardPagerViewRenderer(ViewGroup viewGroup, PagerViewItemFactory<S> pagerViewItemFactory, int i) {
        this.f18425c = viewGroup;
        this.f18430h = pagerViewItemFactory;
        this.f18424b = new ArraySet(false);
        this.f18427e = Lists.b();
        this.f18429g = Lists.b();
        this.f18428f = i;
    }

    public final void m18413a() {
        this.f18431i = true;
    }

    public final void m18417b() {
        this.f18431i = false;
    }

    public final void m18416a(T t, int i, float f, float f2, float f3, boolean z) {
        PagerViewItem b = m18412b(t, i);
        b.mo164a(this.f18425c, t, i, f, f2, f3, z);
        b.setIsInViewport(z);
    }

    public final void m18415a(T t, int i) {
        RenderInfo a = RenderInfo.m18403a();
        a.f18416b = t;
        a.f18418d = i;
        for (int i2 = 0; i2 < this.f18424b.size(); i2++) {
            RenderInfo renderInfo = (RenderInfo) this.f18424b.get(i2);
            if (renderInfo.equals(a)) {
                this.f18427e.offer(renderInfo);
                this.f18424b.remove(renderInfo);
                ((PagerViewItem) renderInfo.f18417c).setIsInViewport(false);
                break;
            }
        }
        while (this.f18427e.size() > this.f18428f) {
            RenderInfo renderInfo2 = (RenderInfo) this.f18427e.poll();
            PagerViewItem pagerViewItem = (PagerViewItem) renderInfo2.f18417c;
            pagerViewItem.setIsInViewport(false);
            pagerViewItem.mo163a();
            this.f18429g.offer(pagerViewItem);
            this.f18424b.remove(renderInfo2);
            renderInfo2.m18404b();
        }
        a.m18404b();
    }

    public final void m18414a(int i, T t) {
        m18411a(false);
        this.f18426d.f18418d = i;
        this.f18426d.f18416b = t;
        m18411a(true);
    }

    private void m18411a(boolean z) {
        for (int i = 0; i < this.f18424b.size(); i++) {
            RenderInfo renderInfo = (RenderInfo) this.f18424b.get(i);
            if (renderInfo.equals(this.f18426d)) {
                ((PagerViewItem) renderInfo.f18417c).mo165a(z);
            }
        }
    }

    private S m18412b(T t, int i) {
        int i2 = 0;
        RenderInfo a = RenderInfo.m18403a();
        a.f18416b = t;
        a.f18418d = i;
        int i3 = 0;
        while (i3 < this.f18424b.size()) {
            RenderInfo renderInfo = (RenderInfo) this.f18424b.get(i3);
            if (renderInfo.equals(a)) {
                PagerViewItem pagerViewItem = (PagerViewItem) renderInfo.f18417c;
                a.m18404b();
                return pagerViewItem;
            } else if (this.f18432j && Objects.equal(renderInfo.f18416b, t)) {
                renderInfo.f18418d = i;
                a.m18404b();
                return (PagerViewItem) renderInfo.f18417c;
            } else {
                i3++;
            }
        }
        while (i2 < this.f18427e.size()) {
            renderInfo = (RenderInfo) this.f18427e.get(i2);
            if (renderInfo.equals(a)) {
                this.f18424b.add(renderInfo);
                this.f18427e.remove(i2);
                pagerViewItem = (PagerViewItem) renderInfo.f18417c;
                a.m18404b();
                return pagerViewItem;
            }
            i2++;
        }
        if (this.f18429g.size() > 0) {
            pagerViewItem = (PagerViewItem) this.f18429g.poll();
            a.f18417c = pagerViewItem;
            this.f18424b.add(a);
            return pagerViewItem;
        }
        pagerViewItem = (PagerViewItem) this.f18430h.mo170a();
        a.f18417c = pagerViewItem;
        this.f18424b.add(a);
        return pagerViewItem;
    }
}
