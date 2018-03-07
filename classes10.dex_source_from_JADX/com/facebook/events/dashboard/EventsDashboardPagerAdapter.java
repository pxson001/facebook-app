package com.facebook.events.dashboard;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.pagerindicator.BadgePagerAdapter;
import com.facebook.fbui.pagerindicator.BadgePagerProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: com.ubercab */
public class EventsDashboardPagerAdapter extends PagerAdapter implements BadgePagerProvider {
    public static final DashboardFilterType[] f16692a = new DashboardFilterType[]{DashboardFilterType.UPCOMING, DashboardFilterType.INVITED, DashboardFilterType.HOSTING, DashboardFilterType.PAST};
    public static final DashboardFilterType[] f16693b = new DashboardFilterType[]{DashboardFilterType.UPCOMING, DashboardFilterType.INVITED, DashboardFilterType.BIRTHDAYS, DashboardFilterType.HOSTING, DashboardFilterType.PAST};
    public final Context f16694c;
    public DashboardFilterType[] f16695d;
    public EventsDashboardListViewHolder[] f16696e;
    public EventsBadgePagerAdapter f16697f;
    public EventsDashboardFragment f16698g;
    private boolean f16699h = true;

    /* compiled from: com.ubercab */
    public class EventsBadgePagerAdapter extends BadgePagerAdapter {
        final /* synthetic */ EventsDashboardPagerAdapter f16690a;
        public int f16691b;

        public EventsBadgePagerAdapter(EventsDashboardPagerAdapter eventsDashboardPagerAdapter) {
            this.f16690a = eventsDashboardPagerAdapter;
        }

        public final CharSequence m17084a(int i) {
            if (this.f16690a.f16695d[i] != DashboardFilterType.INVITED) {
                return "";
            }
            return this.f16691b > 0 ? String.valueOf(this.f16691b) : "";
        }

        public final CharSequence m17085b(int i) {
            if (this.f16690a.f16695d[i] != DashboardFilterType.INVITED || this.f16691b <= 0) {
                return this.f16690a.J_(i);
            }
            return this.f16690a.f16694c.getResources().getQuantityString(2131689678, this.f16691b, new Object[]{Integer.valueOf(this.f16691b)});
        }
    }

    public static EventsDashboardPagerAdapter m17086a(InjectorLike injectorLike) {
        return new EventsDashboardPagerAdapter((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public EventsDashboardPagerAdapter(Context context) {
        this.f16694c = context;
    }

    public final int m17091b() {
        return this.f16695d.length;
    }

    public final boolean m17090a(View view, Object obj) {
        return ((EventsDashboardListViewHolder) obj).f16683b == view;
    }

    public final Object m17088a(ViewGroup viewGroup, int i) {
        Object obj = this.f16696e[i];
        if (obj != null) {
            return obj;
        }
        EventsDashboardListViewHolder eventsDashboardListViewHolder = new EventsDashboardListViewHolder(this.f16695d[i], this.f16698g);
        this.f16696e[i] = eventsDashboardListViewHolder;
        return eventsDashboardListViewHolder;
    }

    public final void m17089a(ViewGroup viewGroup, int i, Object obj) {
        EventsDashboardListViewHolder eventsDashboardListViewHolder = (EventsDashboardListViewHolder) obj;
        if (eventsDashboardListViewHolder.f16684c) {
            viewGroup.removeView(eventsDashboardListViewHolder.f16683b);
            eventsDashboardListViewHolder.f16684c = false;
        }
    }

    public final void m17092b(ViewGroup viewGroup, int i, Object obj) {
        EventsDashboardListViewHolder eventsDashboardListViewHolder = (EventsDashboardListViewHolder) obj;
        if (!eventsDashboardListViewHolder.f16684c) {
            FbSwipeRefreshLayout fbSwipeRefreshLayout;
            if (eventsDashboardListViewHolder.f16683b != null) {
                fbSwipeRefreshLayout = eventsDashboardListViewHolder.f16683b;
            } else {
                eventsDashboardListViewHolder.f16683b = (FbSwipeRefreshLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130904131, viewGroup, false);
                eventsDashboardListViewHolder.f16683b.setColorSchemeResources(new int[]{2131361916});
                if (eventsDashboardListViewHolder.f16686e != null) {
                    eventsDashboardListViewHolder.f16682a = (BetterListView) eventsDashboardListViewHolder.f16683b.findViewById(2131561514);
                    eventsDashboardListViewHolder.f16682a.setStickyHeaderEnabled(false);
                    eventsDashboardListViewHolder.f16686e.m17053a(eventsDashboardListViewHolder.f16682a, eventsDashboardListViewHolder.f16683b, eventsDashboardListViewHolder.f16685d);
                }
                fbSwipeRefreshLayout = eventsDashboardListViewHolder.f16683b;
            }
            viewGroup.addView(fbSwipeRefreshLayout);
            eventsDashboardListViewHolder.f16684c = true;
        } else if (eventsDashboardListViewHolder.f16686e != null) {
            eventsDashboardListViewHolder.f16686e.m17054b(eventsDashboardListViewHolder.f16682a, eventsDashboardListViewHolder.f16683b, eventsDashboardListViewHolder.f16685d);
        }
        if (this.f16699h && this.f16698g != null) {
            this.f16698g.aq();
            this.f16699h = false;
        }
    }

    public final CharSequence J_(int i) {
        return this.f16694c.getString(this.f16695d[i].menuStringResId).toUpperCase(Locale.getDefault());
    }

    public final BadgePagerAdapter m17087a() {
        return this.f16697f;
    }
}
