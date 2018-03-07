package com.facebook.events.dashboard.birthdays;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.dashboard.EventsBirthdayRow;
import com.facebook.events.dashboard.EventsDashboardStickySectionHeaderView;
import com.facebook.events.dateformatter.EventsBirthdayTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventUserWithBirthdayFragmentModel.BirthdateModel;
import com.facebook.events.permalink.guestlist.EventGuestListLoadingRowView;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: com.facebook.timeline.favmediapicker.utils.favoriteMediaSuggestionsCacheTag */
public class EventsUpcomingBirthdaysAdapter extends SectionedListAdapter implements StickyHeaderAdapter {
    private static final Object f16984c = new Object();
    public final Context f16985d;
    private final EventsDashboardTimeFormatUtil f16986e;
    public FbFragment f16987f;
    private ArrayList<Section> f16988g;
    public boolean f16989h = true;
    public boolean f16990i;
    public String f16991j;
    public Bundle f16992k;
    private int f16993l;

    /* compiled from: com.facebook.timeline.favmediapicker.utils.favoriteMediaSuggestionsCacheTag */
    /* synthetic */ class C23851 {
        static final /* synthetic */ int[] f16981a = new int[CalendarBucket.values().length];

        static {
            try {
                f16981a[CalendarBucket.PAST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16981a[CalendarBucket.YESTERDAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16981a[CalendarBucket.TODAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16981a[CalendarBucket.TOMORROW.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16981a[CalendarBucket.THIS_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16981a[CalendarBucket.NEXT_WEEK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16981a[CalendarBucket.FUTURE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: com.facebook.timeline.favmediapicker.utils.favoriteMediaSuggestionsCacheTag */
    public class Section {
        protected final String f16982a;
        protected final ArrayList<EventUserWithBirthdayFragmentModel> f16983b;

        protected Section(@Nonnull String str) {
            this.f16982a = str;
            this.f16983b = new ArrayList();
        }

        protected Section(Section section) {
            this.f16982a = section.f16982a;
            this.f16983b = new ArrayList(section.f16983b);
        }
    }

    /* compiled from: com.facebook.timeline.favmediapicker.utils.favoriteMediaSuggestionsCacheTag */
    enum ViewTypes {
        HEADER,
        BIRTHDAY,
        LOADING
    }

    public static EventsUpcomingBirthdaysAdapter m17304b(InjectorLike injectorLike) {
        return new EventsUpcomingBirthdaysAdapter((Context) injectorLike.getInstance(Context.class), EventsDashboardTimeFormatUtil.a(injectorLike));
    }

    @Inject
    public EventsUpcomingBirthdaysAdapter(Context context, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil) {
        this.f16985d = new ContextThemeWrapper(context, 2131625810);
        this.f16986e = eventsDashboardTimeFormatUtil;
        this.f16988g = new ArrayList();
        this.f16992k = new Bundle();
    }

    public final void m17311a(@Nonnull List<EventUserWithBirthdayFragmentModel> list, boolean z) {
        m17303a((List) list);
        this.f16989h = z;
        AdapterDetour.a(this, 97404821);
    }

    public final void m17310a(String str, long j) {
        this.f16992k.putLong(str, j);
        AdapterDetour.a(this, -1600217876);
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    protected final int m17315c() {
        return this.f16988g.size();
    }

    protected final int m17306a(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    protected final View m17308a(int i, View view, ViewGroup viewGroup) {
        view = (EventsDashboardStickySectionHeaderView) view;
        if (view == null) {
            view = (EventsDashboardStickySectionHeaderView) LayoutInflater.from(this.f16985d).inflate(2130904138, viewGroup, false);
        }
        view.setTitle(((Section) m17313b(i)).f16982a);
        if (this.f16993l == 0) {
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f16993l = view.getMeasuredHeight();
        }
        return view;
    }

    protected final int m17316c(int i) {
        return (this.f16989h && i == this.f16988g.size() - 1) ? ((Section) this.f16988g.get(i)).f16983b.size() + 1 : ((Section) this.f16988g.get(i)).f16983b.size();
    }

    protected final Object m17313b(int i) {
        return this.f16988g.get(i);
    }

    protected final Object m17309a(int i, int i2) {
        if (this.f16989h && i == this.f16988g.size() - 1 && i2 == ((Section) this.f16988g.get(i)).f16983b.size()) {
            return f16984c;
        }
        return ((Section) this.f16988g.get(i)).f16983b.get(i2);
    }

    protected final View m17307a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        int i3 = new GregorianCalendar(TimeZone.getDefault()).get(2) + 1;
        if (m17309a(i, i2) == f16984c) {
            return m17302a(view);
        }
        boolean z2;
        View eventsBirthdayRow = view != null ? (EventsBirthdayRow) view : new EventsBirthdayRow(this.f16985d);
        EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel = (EventUserWithBirthdayFragmentModel) m17309a(i, i2);
        boolean z3 = eventUserWithBirthdayFragmentModel.j().b() <= i3;
        FbFragment fbFragment = this.f16987f;
        if (this.f16992k.getLong(eventUserWithBirthdayFragmentModel.m(), -1) != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        eventsBirthdayRow.m16940a(eventUserWithBirthdayFragmentModel, fbFragment, z3, z2, this.f16991j);
        return eventsBirthdayRow;
    }

    protected final int m17317c(int i, int i2) {
        if (m17309a(i, i2) == f16984c) {
            return ViewTypes.LOADING.ordinal();
        }
        return ViewTypes.BIRTHDAY.ordinal();
    }

    protected final boolean m17314b(int i, int i2) {
        return true;
    }

    private EventGuestListLoadingRowView m17302a(View view) {
        if (view != null) {
            return (EventGuestListLoadingRowView) view;
        }
        view = new EventGuestListLoadingRowView(this.f16985d);
        view.setBackgroundResource(2131361920);
        return view;
    }

    public final View m17312b(int i, View view, ViewGroup viewGroup) {
        return m17308a(d(i)[0], view, viewGroup);
    }

    public final int o_(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    public final int m17319e(int i) {
        return this.f16993l;
    }

    public final int m17318d() {
        return this.f16985d.getResources().getColor(2131361920);
    }

    public final boolean m17320f(int i) {
        if (i < 0 || i >= getCount()) {
            return false;
        }
        if (d(i)[1] != -1) {
            return false;
        }
        return true;
    }

    private void m17303a(@Nonnull List<EventUserWithBirthdayFragmentModel> list) {
        Section section;
        ArrayList g = m17305g();
        Date date = new Date();
        if (g.isEmpty()) {
            section = null;
        } else {
            section = (Section) g.get(g.size() - 1);
        }
        Section section2 = section;
        for (EventUserWithBirthdayFragmentModel eventUserWithBirthdayFragmentModel : list) {
            BirthdateModel j = eventUserWithBirthdayFragmentModel.j();
            Date time = EventsBirthdayTimeFormatUtil.a(date, TimeZone.getDefault(), j.a(), j.b(), true).getTime();
            String str = "";
            switch (C23851.f16981a[this.f16986e.a(time.getTime(), date.getTime()).ordinal()]) {
                case 1:
                case 2:
                    str = this.f16985d.getString(2131237146);
                    break;
                case 3:
                    str = this.f16985d.getString(2131237147);
                    break;
                case 4:
                case 5:
                    str = this.f16985d.getString(2131237148);
                    break;
                case 6:
                case 7:
                    if (!EventsBirthdayTimeFormatUtil.a(date, time)) {
                        str = this.f16986e.f(time);
                        break;
                    } else {
                        str = this.f16985d.getString(2131237149);
                        break;
                    }
            }
            if (section2 == null || !section2.f16982a.equals(str)) {
                section2 = new Section(str);
                g.add(section2);
            }
            section2.f16983b.add(eventUserWithBirthdayFragmentModel);
            if (!this.f16990i) {
                this.f16990i = true;
            }
        }
        this.f16988g = g;
    }

    private ArrayList<Section> m17305g() {
        ArrayList<Section> arrayList = new ArrayList(this.f16988g.size());
        int size = this.f16988g.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Section((Section) this.f16988g.get(i)));
        }
        return arrayList;
    }
}
