package com.facebook.groups.sideshow.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.groups.sideshow.model.RecentActiveGroupRow;
import com.facebook.groups.sideshow.model.RecentActiveGroupsDataHolder;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.sideshow.widget.SideShowExpandableListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;

/* compiled from: wall_clock_age_ms */
public class RecentActiveGroupsListAdapter extends SideShowExpandableListAdapter {
    private final Context f351a;
    public RecentActiveGroupsDataHolder f352b;

    /* compiled from: wall_clock_age_ms */
    public class C00611 {
        public final /* synthetic */ RecentActiveGroupsListAdapter f350a;

        public C00611(RecentActiveGroupsListAdapter recentActiveGroupsListAdapter) {
            this.f350a = recentActiveGroupsListAdapter;
        }

        public final void m477b() {
            AdapterDetour.a(this.f350a, 1986533287);
        }
    }

    public static RecentActiveGroupsListAdapter m480b(InjectorLike injectorLike) {
        return new RecentActiveGroupsListAdapter((Context) injectorLike.getInstance(Context.class));
    }

    public /* synthetic */ Object getItem(int i) {
        return m479a(i);
    }

    @Inject
    public RecentActiveGroupsListAdapter(Context context) {
        this.f351a = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View recentActiveGroupRowView;
        if (view == null) {
            recentActiveGroupRowView = new RecentActiveGroupRowView(this.f351a);
        } else {
            recentActiveGroupRowView = view;
        }
        RecentActiveGroupRowView recentActiveGroupRowView2 = (RecentActiveGroupRowView) recentActiveGroupRowView;
        recentActiveGroupRowView2.f349h = m479a(i);
        if (recentActiveGroupRowView2.f349h.f341b != null) {
            recentActiveGroupRowView2.setThumbnailUri(Uri.parse(recentActiveGroupRowView2.f349h.f341b));
        }
        recentActiveGroupRowView2.setTitleText(recentActiveGroupRowView2.f349h.f342c);
        recentActiveGroupRowView2.setSubtitleText(recentActiveGroupRowView2.getResources().getQuantityString(2131689799, recentActiveGroupRowView2.f349h.f343d, new Object[]{Integer.valueOf(recentActiveGroupRowView2.f349h.f343d)}));
        return recentActiveGroupRowView;
    }

    private RecentActiveGroupRow m479a(int i) {
        RecentActiveGroupRow recentActiveGroupRow;
        RecentActiveGroupsDataHolder recentActiveGroupsDataHolder = this.f352b;
        if (recentActiveGroupsDataHolder.f348c == null || recentActiveGroupsDataHolder.f348c.size() <= i) {
            recentActiveGroupRow = null;
        } else {
            recentActiveGroupRow = (RecentActiveGroupRow) recentActiveGroupsDataHolder.f348c.get(i);
        }
        return recentActiveGroupRow;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f352b.m476a();
    }

    public final int mo16a() {
        return 3;
    }
}
