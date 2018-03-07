package com.facebook.tablet.sideshow.pyml.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.tablet.sideshow.pyml.model.PagesYouMayLikeDataHolder;
import com.facebook.tablet.sideshow.pyml.model.PagesYouMayLikeRow;
import com.facebook.tablet.sideshow.widget.SideShowExpandableListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;

/* compiled from: on body  */
public class PagesYouMayLikeListAdapter extends SideShowExpandableListAdapter {
    private final Context f4849a;
    public PagesYouMayLikeDataHolder f4850b;
    private FeedEventBus f4851c;

    /* compiled from: on body  */
    public class C06551 {
        public final /* synthetic */ PagesYouMayLikeListAdapter f4848a;

        public C06551(PagesYouMayLikeListAdapter pagesYouMayLikeListAdapter) {
            this.f4848a = pagesYouMayLikeListAdapter;
        }

        public final void m6056b() {
            AdapterDetour.a(this.f4848a, 2136655659);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m6057a(i);
    }

    @Inject
    public PagesYouMayLikeListAdapter(Context context, FeedEventBus feedEventBus) {
        this.f4849a = context;
        this.f4851c = feedEventBus;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View pagesYouMayLikeRowView;
        if (view == null) {
            pagesYouMayLikeRowView = new PagesYouMayLikeRowView(this.f4849a);
            pagesYouMayLikeRowView.f4856k = this.f4851c;
        } else {
            pagesYouMayLikeRowView = view;
        }
        PagesYouMayLikeRow a = m6057a(i);
        if (a != null) {
            ((PagesYouMayLikeRowView) pagesYouMayLikeRowView).m6061a(a);
            ((PagesYouMayLikeRowView) pagesYouMayLikeRowView).f4856k = this.f4851c;
        }
        return pagesYouMayLikeRowView;
    }

    private PagesYouMayLikeRow m6057a(int i) {
        PagesYouMayLikeRow pagesYouMayLikeRow;
        PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder = this.f4850b;
        if (pagesYouMayLikeDataHolder.f4839c == null || pagesYouMayLikeDataHolder.f4839c.size() <= i) {
            pagesYouMayLikeRow = null;
        } else {
            pagesYouMayLikeRow = (PagesYouMayLikeRow) pagesYouMayLikeDataHolder.f4839c.get(i);
        }
        return pagesYouMayLikeRow;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f4850b.m6055a();
    }

    public final int m6058a() {
        return 3;
    }

    public final void m6059a(String str, boolean z) {
        PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder = this.f4850b;
        if (pagesYouMayLikeDataHolder.f4840d.containsKey(str)) {
            ((PagesYouMayLikeRow) pagesYouMayLikeDataHolder.f4839c.get(((Integer) pagesYouMayLikeDataHolder.f4840d.get(str)).intValue())).f4846f = z;
        }
        AdapterDetour.a(this, -476513614);
    }
}
