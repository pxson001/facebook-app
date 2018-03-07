package com.facebook.feed.logging;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.NewsFeedRecyclerViewAdapterWrapper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_voip_android */
public class RowHeightMeasurer {
    private final AbstractFbErrorReporter f13662a;
    public final ScrollingViewProxy f13663b;
    private final NewsFeedRecyclerViewAdapterWrapper f13664c;
    private final Map<Integer, ViewHolder> f13665d = new MapMaker().m1487g().m1489l();
    public final LayoutParams f13666e = new LayoutParams(-1, -2);
    private final MultipleRowsStoriesRecycleCallback f13667f;
    public FeedUnitHeightTrackerStore f13668g;

    @Inject
    public RowHeightMeasurer(@Assisted ScrollingViewProxy scrollingViewProxy, @Assisted NewsFeedRecyclerViewAdapterWrapper newsFeedRecyclerViewAdapterWrapper, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13663b = scrollingViewProxy;
        this.f13664c = newsFeedRecyclerViewAdapterWrapper;
        this.f13662a = abstractFbErrorReporter;
        this.f13667f = multipleRowsStoriesRecycleCallback;
    }

    public final void m20081a(FeedUnit feedUnit, int i, int i2, int i3) {
        Preconditions.checkNotNull(this.f13668g);
        if (!this.f13668g.m20075b(feedUnit, i3, i)) {
            int a = m20076a(feedUnit, i2);
            if (a != -1) {
                this.f13668g.m20074a(feedUnit, i3, a, i);
            }
        }
    }

    private int m20076a(FeedUnit feedUnit, int i) {
        int q = i - this.f13663b.mo2402q();
        if (q < 0 || q >= this.f13663b.mo2401p()) {
            return m20080b(feedUnit, i);
        }
        int i2;
        View f = this.f13663b.mo2386f(q);
        if (f == null || f.getMeasuredHeight() == 0) {
            i2 = -1;
        } else {
            i2 = f.getMeasuredHeight();
        }
        q = i2;
        return q == -1 ? m20080b(feedUnit, i) : q;
    }

    private int m20080b(FeedUnit feedUnit, int i) {
        int aZ_ = this.f13664c.aZ_();
        if (i < 0 || i >= aZ_) {
            this.f13662a.m2350b("RowHeightMeasurer_IllegalIndex", "Trying to get height for index=" + i + " when adapter.getCount()=" + aZ_);
            return -1;
        }
        int itemViewType = this.f13664c.getItemViewType(i);
        ViewHolder viewHolder = (ViewHolder) this.f13665d.get(Integer.valueOf(itemViewType));
        ViewHolder a = m20079a(feedUnit, viewHolder, i, itemViewType);
        if (a == null) {
            return -1;
        }
        View view = a.f14095a;
        view.setLayoutParams(this.f13666e);
        view.measure(MeasureSpec.makeMeasureSpec(this.f13663b.ix_().getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        if (viewHolder == null) {
            this.f13665d.put(Integer.valueOf(itemViewType), a);
        }
        aZ_ = view.getMeasuredHeight();
        MultipleRowsStoriesRecycleCallback.m10041a(view);
        return aZ_;
    }

    @Nullable
    private ViewHolder m20079a(FeedUnit feedUnit, @Nullable ViewHolder viewHolder, int i, int i2) {
        int aZ_ = this.f13664c.aZ_();
        if (i >= aZ_) {
            this.f13662a.m2350b("RowHeightMeasurer_IllegalIndex", "Trying to measure index " + i + " when adapter item count is " + aZ_);
            return null;
        }
        try {
            if (this.f13664c instanceof MultiRowAdapter) {
                return m20077a((MultiRowAdapter) this.f13664c, viewHolder, i);
            }
            if (this.f13664c instanceof MultiRowRecyclerViewAdapter) {
                return m20078a((MultiRowRecyclerViewAdapter) this.f13664c, viewHolder, i, i2);
            }
            throw new IllegalStateException("Unknown Feed Adapter type");
        } catch (Throwable e) {
            Throwable th = e;
            AbstractFbErrorReporter abstractFbErrorReporter = this.f13662a;
            String str = "RowHeightMeasurer";
            String str2 = "Problem measuring %s. Zombie: %s";
            Object[] objArr = new Object[2];
            objArr[0] = viewHolder == null ? null : viewHolder.f14095a.getClass().getSimpleName();
            objArr[1] = feedUnit.S_();
            abstractFbErrorReporter.mo336a(SoftError.a(str, StringLocaleUtil.m21640a(str2, objArr)).a(th).g());
            return null;
        }
    }

    @Nullable
    private ViewHolder m20077a(MultiRowAdapter multiRowAdapter, @Nullable ViewHolder viewHolder, int i) {
        return new 1(this, multiRowAdapter.getView(i, viewHolder != null ? viewHolder.f14095a : null, this.f13663b.mo2363b()));
    }

    @Nullable
    private ViewHolder m20078a(MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter, @Nullable ViewHolder viewHolder, int i, int i2) {
        if (viewHolder == null) {
            viewHolder = multiRowRecyclerViewAdapter.mo2222a(this.f13663b.mo2363b(), i2);
        }
        multiRowRecyclerViewAdapter.mo2225a(viewHolder, i);
        return viewHolder;
    }
}
