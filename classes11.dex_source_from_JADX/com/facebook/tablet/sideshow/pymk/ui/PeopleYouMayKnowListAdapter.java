package com.facebook.tablet.sideshow.pymk.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.tablet.sideshow.pymk.model.PeopleYouMayKnowDataHolder;
import com.facebook.tablet.sideshow.pymk.model.PeopleYouMayKnowRow;
import com.facebook.tablet.sideshow.widget.SideShowExpandableListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.inject.Inject;

/* compiled from: onDrawerSlide */
public class PeopleYouMayKnowListAdapter extends SideShowExpandableListAdapter {
    private final Context f4779a;
    public PeopleYouMayKnowDataHolder f4780b;
    private FeedEventBus f4781c;

    /* compiled from: onDrawerSlide */
    public class C06471 {
        public final /* synthetic */ PeopleYouMayKnowListAdapter f4778a;

        public C06471(PeopleYouMayKnowListAdapter peopleYouMayKnowListAdapter) {
            this.f4778a = peopleYouMayKnowListAdapter;
        }

        public final void m5974b() {
            AdapterDetour.a(this.f4778a, -1685316169);
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m5975a(i);
    }

    @Inject
    public PeopleYouMayKnowListAdapter(Context context, FeedEventBus feedEventBus) {
        this.f4779a = context;
        this.f4781c = feedEventBus;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View peopleYouMayKnowRowView;
        if (view == null) {
            peopleYouMayKnowRowView = new PeopleYouMayKnowRowView(this.f4779a);
        } else {
            peopleYouMayKnowRowView = view;
        }
        PeopleYouMayKnowRow a = m5975a(i);
        if (a != null) {
            ((PeopleYouMayKnowRowView) peopleYouMayKnowRowView).m5978a(a);
            ((PeopleYouMayKnowRowView) peopleYouMayKnowRowView).f4788l = this.f4781c;
        }
        return peopleYouMayKnowRowView;
    }

    private PeopleYouMayKnowRow m5975a(int i) {
        PeopleYouMayKnowRow peopleYouMayKnowRow;
        PeopleYouMayKnowDataHolder peopleYouMayKnowDataHolder = this.f4780b;
        if (peopleYouMayKnowDataHolder.f4770c == null || peopleYouMayKnowDataHolder.f4770c.size() <= i) {
            peopleYouMayKnowRow = null;
        } else {
            peopleYouMayKnowRow = (PeopleYouMayKnowRow) peopleYouMayKnowDataHolder.f4770c.get(i);
        }
        return peopleYouMayKnowRow;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f4780b.m5973a();
    }

    public final int m5976a() {
        return 3;
    }
}
