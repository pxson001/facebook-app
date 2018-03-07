package com.facebook.tablet.sideshow.trending.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.tablet.sideshow.trending.model.TrendingDataHolder;
import com.facebook.tablet.sideshow.trending.model.TrendingRow;
import com.facebook.tablet.sideshow.widget.SideShowExpandableListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import javax.inject.Inject;

/* compiled from: nvite_coworker */
public class TrendingSideshowListAdapter extends SideShowExpandableListAdapter {
    private final Context f4902a;
    public TrendingDataHolder f4903b;

    /* compiled from: nvite_coworker */
    public class C06621 {
        public final /* synthetic */ TrendingSideshowListAdapter f4901a;

        public C06621(TrendingSideshowListAdapter trendingSideshowListAdapter) {
            this.f4901a = trendingSideshowListAdapter;
        }

        public final void m6113b() {
            AdapterDetour.a(this.f4901a, -1983807837);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m6114a(i);
    }

    @Inject
    public TrendingSideshowListAdapter(Context context) {
        this.f4902a = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View trendingRowView;
        if (view == null) {
            trendingRowView = new TrendingRowView(this.f4902a);
        } else {
            trendingRowView = view;
        }
        TrendingRowView trendingRowView2 = (TrendingRowView) trendingRowView;
        trendingRowView2.f4898h = m6114a(i);
        trendingRowView2.setTitleText(trendingRowView2.f4898h.f4896b);
        trendingRowView2.setSubtitleText(trendingRowView2.f4898h.f4897c);
        if (trendingRowView2.f4899i.isPresent()) {
            CustomFontHelper.a((TextView) trendingRowView2.f4899i.get(), FontFamily.ROBOTO, FontWeight.MEDIUM, ((BetterTextView) trendingRowView2.f4899i.get()).getTypeface());
        }
        if (trendingRowView2.f4900j.isPresent()) {
            CustomFontHelper.a((TextView) trendingRowView2.f4899i.get(), FontFamily.ROBOTO, FontWeight.LIGHT, ((BetterTextView) trendingRowView2.f4899i.get()).getTypeface());
        }
        return trendingRowView;
    }

    private TrendingRow m6114a(int i) {
        TrendingRow trendingRow;
        TrendingDataHolder trendingDataHolder = this.f4903b;
        if (trendingDataHolder.f4894c == null || trendingDataHolder.f4894c.size() <= i) {
            trendingRow = null;
        } else {
            trendingRow = (TrendingRow) trendingDataHolder.f4894c.get(i);
        }
        return trendingRow;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f4903b.m6112a();
    }

    public final int m6115a() {
        return 3;
    }
}
