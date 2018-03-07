package com.facebook.pages.fb4a.events.eventslist;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.model.Event;
import com.facebook.events.widget.eventrow.EventRowView;
import com.facebook.events.widget.eventrow.EventRowView.EventRowViewUpdateRsvpStatusListener;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: ptr_grid_view */
public class PageEventsListAdapter extends SectionedListAdapter implements StickyHeaderAdapter {
    private static final Object f2958c = new Object();
    public final Context f2959d;
    public EnumMap<SectionType, Section> f2960e;
    private EventAnalyticsParams f2961f;
    private EventRowViewUpdateRsvpStatusListener f2962g;
    public HashMap<String, Integer> f2963h;
    public HashMap<String, Integer> f2964i;
    public Set<String> f2965j = new HashSet();
    private List<SectionType> f2966k = new ArrayList();
    private int f2967l = 0;
    public int f2968m;

    /* compiled from: ptr_grid_view */
    class C03971 implements EventRowViewUpdateRsvpStatusListener {
        final /* synthetic */ PageEventsListAdapter f2953a;

        C03971(PageEventsListAdapter pageEventsListAdapter) {
            this.f2953a = pageEventsListAdapter;
        }

        public final void m3967a(String str, Event event) {
            this.f2953a.m3975a(str, event);
        }
    }

    /* compiled from: ptr_grid_view */
    public class Section {
        protected final String f2956a;
        public final List<Event> f2957b = new ArrayList();

        protected Section(String str) {
            this.f2956a = str;
        }
    }

    /* compiled from: ptr_grid_view */
    public enum SectionType {
        NEW,
        UPCOMING,
        PAST
    }

    /* compiled from: ptr_grid_view */
    public enum ViewTypes {
        EVENT_ROW_VIEW,
        NULL_STATE_VIEW,
        TEXT_HEADER_VIEW
    }

    @Inject
    public PageEventsListAdapter(@Assisted EventAnalyticsParams eventAnalyticsParams, Context context) {
        this.f2959d = context;
        this.f2960e = new EnumMap(SectionType.class);
        this.f2963h = new HashMap();
        this.f2964i = new HashMap();
        this.f2966k.addAll(Arrays.asList(new SectionType[]{SectionType.UPCOMING, SectionType.PAST}));
        this.f2961f = eventAnalyticsParams;
        this.f2962g = new C03971(this);
    }

    public final void m3976a(List<Event> list, SectionType sectionType) {
        if (sectionType == SectionType.NEW) {
            this.f2966k.add(0, SectionType.NEW);
        }
        if (!this.f2960e.containsKey(sectionType)) {
            this.f2960e.put(sectionType, new Section(m3970a(sectionType)));
        }
        List list2;
        if (sectionType.equals(SectionType.UPCOMING)) {
            for (Event event : list) {
                list2 = ((Section) this.f2960e.get(sectionType)).f2957b;
                list2.add(event);
                this.f2963h.put(event.a, Integer.valueOf(list2.size() - 1));
            }
        } else if (sectionType.equals(SectionType.NEW)) {
            for (Event event2 : list) {
                list2 = ((Section) this.f2960e.get(sectionType)).f2957b;
                list2.add(event2);
                this.f2964i.put(event2.a, Integer.valueOf(list2.size() - 1));
            }
        } else {
            ((Section) this.f2960e.get(sectionType)).f2957b.addAll(list);
        }
        AdapterDetour.a(this, 775100826);
    }

    protected final int m3980c() {
        return this.f2960e.size();
    }

    protected final View m3973a(int i, View view, ViewGroup viewGroup) {
        View a;
        ViewTypes viewTypes = ViewTypes.values()[m3971a(i)];
        if (view == null) {
            a = m3969a(viewTypes);
        } else {
            a = view;
        }
        if (viewTypes == ViewTypes.TEXT_HEADER_VIEW) {
            PageEventsListSectionHeaderView pageEventsListSectionHeaderView = (PageEventsListSectionHeaderView) a;
            pageEventsListSectionHeaderView.f3013a.setText(((Section) m3978b(i)).f2956a);
        }
        return a;
    }

    private View m3969a(ViewTypes viewTypes) {
        switch (viewTypes) {
            case TEXT_HEADER_VIEW:
                return new PageEventsListSectionHeaderView(this.f2959d);
            default:
                throw new IllegalArgumentException("Invalid header view type: " + viewTypes);
        }
    }

    protected final int m3971a(int i) {
        return ViewTypes.TEXT_HEADER_VIEW.ordinal();
    }

    protected final Object m3978b(int i) {
        return this.f2960e.get(this.f2966k.get(i));
    }

    protected final int m3981c(int i) {
        Section section = (Section) this.f2960e.get(this.f2966k.get(i));
        return !section.f2957b.isEmpty() ? section.f2957b.size() : 1;
    }

    protected final Object m3974a(int i, int i2) {
        Section section = (Section) this.f2960e.get(this.f2966k.get(i));
        return !section.f2957b.isEmpty() ? section.f2957b.get(i2) : f2958c;
    }

    protected final View m3972a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        return m3968a(i, i2, ViewTypes.values()[m3982c(i, i2)], view);
    }

    private View m3968a(int i, int i2, ViewTypes viewTypes, View view) {
        switch (viewTypes) {
            case EVENT_ROW_VIEW:
                View view2;
                if (view instanceof EventRowView) {
                    view2 = view;
                } else {
                    view2 = new EventRowView(this.f2959d);
                }
                Event event = (Event) m3974a(i, i2);
                ((EventRowView) view2).a(event, this.f2961f, false, this.f2962g, event.as());
                EventRowView eventRowView = (EventRowView) view2;
                eventRowView.o.setSelected(this.f2965j.contains(event.a));
                return view2;
            case NULL_STATE_VIEW:
                PageEventsListNullStateView pageEventsListNullStateView;
                String string;
                if (view instanceof PageEventsListNullStateView) {
                    pageEventsListNullStateView = view;
                } else {
                    pageEventsListNullStateView = new PageEventsListNullStateView(this.f2959d);
                }
                PageEventsListNullStateView pageEventsListNullStateView2 = pageEventsListNullStateView;
                if (((SectionType) this.f2966k.get(i)).equals(SectionType.UPCOMING)) {
                    string = this.f2959d.getResources().getString(2131239531);
                } else {
                    string = this.f2959d.getResources().getString(2131239532);
                }
                pageEventsListNullStateView2.f2987a.setText(string);
                return pageEventsListNullStateView;
            default:
                throw new IllegalArgumentException("No child views for view type: " + viewTypes.name());
        }
    }

    protected final boolean m3979b(int i, int i2) {
        return true;
    }

    protected final int m3982c(int i, int i2) {
        return ((Section) this.f2960e.get(this.f2966k.get(i))).f2957b.isEmpty() ? ViewTypes.NULL_STATE_VIEW.ordinal() : ViewTypes.EVENT_ROW_VIEW.ordinal();
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public final View m3977b(int i, View view, ViewGroup viewGroup) {
        if (i < this.f2968m) {
            return new PageEventsListSectionHeaderView(this.f2959d);
        }
        View a = m3973a(d(Math.max(i - this.f2968m, 0))[0], view, viewGroup);
        a.setLayoutParams(new LayoutParams(-1, -2));
        a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.f2967l = a.getMeasuredHeight();
        return a;
    }

    public final int o_(int i) {
        return ViewTypes.TEXT_HEADER_VIEW.ordinal();
    }

    public final int m3984e(int i) {
        if (i < this.f2968m) {
            return 0;
        }
        return this.f2967l;
    }

    public final int m3983d() {
        return this.f2959d.getResources().getColor(2131361920);
    }

    public final boolean m3985f(int i) {
        int max = Math.max(i - this.f2968m, 0);
        if (max < 0 || max >= getCount()) {
            return false;
        }
        if (d(max)[1] != -1) {
            return false;
        }
        return true;
    }

    private String m3970a(SectionType sectionType) {
        switch (sectionType) {
            case NEW:
                return this.f2959d.getResources().getString(2131239538);
            case UPCOMING:
                return this.f2959d.getResources().getString(2131239529);
            case PAST:
                return this.f2959d.getResources().getString(2131239530);
            default:
                throw new UnsupportedOperationException(sectionType.name() + " section type is not supported");
        }
    }

    public final void m3975a(String str, Event event) {
        List list;
        if (!(this.f2960e.get(SectionType.UPCOMING) == null || ((Section) this.f2960e.get(SectionType.UPCOMING)).f2957b.isEmpty())) {
            list = ((Section) this.f2960e.get(SectionType.UPCOMING)).f2957b;
            if (this.f2963h.containsKey(str)) {
                list.set(((Integer) this.f2963h.get(str)).intValue(), event);
            }
        }
        if (!(this.f2960e.get(SectionType.NEW) == null || ((Section) this.f2960e.get(SectionType.NEW)).f2957b.isEmpty())) {
            list = ((Section) this.f2960e.get(SectionType.NEW)).f2957b;
            if (this.f2964i.containsKey(str)) {
                list.set(((Integer) this.f2964i.get(str)).intValue(), event);
            }
        }
        AdapterDetour.a(this, -2137408328);
    }
}
