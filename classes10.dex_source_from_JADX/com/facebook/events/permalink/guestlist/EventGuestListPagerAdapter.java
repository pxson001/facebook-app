package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.events.connectionqe.EventsConnectionExperimentController;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.EventGuestListFrameFragment.C26062;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventGuestSingleListModel;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: boost_post */
public class EventGuestListPagerAdapter extends FragmentPagerAdapter {
    private static final ImmutableList<EventGuestListType> f18421b = new Builder().b(new EventGuestListType[]{EventGuestListType.PRIVATE_GOING, EventGuestListType.PRIVATE_MAYBE, EventGuestListType.PRIVATE_INVITED}).b();
    ImmutableList<EventGuestSingleListModel> f18422a;
    private final Context f18423c;
    private final NumberTruncationUtil f18424d;
    private final EventsConnectionExperimentController f18425e;
    private boolean f18426f;
    public EventGuestListFragment[] f18427g;
    public C26062 f18428h;
    public ImmutableList<EventGuestListType> f18429i;
    public int[] f18430j;
    private Fragment f18431k;
    public ImmutableList<List<EventUser>> f18432l;
    public ImmutableList<List<EventUser>> f18433m;

    /* compiled from: boost_post */
    /* synthetic */ class C26142 {
        static final /* synthetic */ int[] f18420a = new int[EventGuestListType.values().length];

        static {
            try {
                f18420a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18420a[EventGuestListType.PUBLIC_GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18420a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18420a[EventGuestListType.PUBLIC_WATCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18420a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18420a[EventGuestListType.PUBLIC_INVITED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18420a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Inject
    public EventGuestListPagerAdapter(EventsConnectionExperimentController eventsConnectionExperimentController, NumberTruncationUtil numberTruncationUtil, @Assisted FragmentManager fragmentManager, @Assisted Context context, @Assisted boolean z) {
        super(fragmentManager);
        this.f18425e = eventsConnectionExperimentController;
        this.f18424d = numberTruncationUtil;
        this.f18423c = context;
        this.f18426f = z;
    }

    public final EventGuestListPagerAdapter m18775a(ImmutableList<EventGuestSingleListModel> immutableList, Bundle bundle) {
        ImmutableList immutableList2;
        int i = 0;
        this.f18422a = immutableList;
        if (immutableList != null) {
            ImmutableList immutableList3;
            if (immutableList == null) {
                immutableList3 = null;
            } else {
                Builder builder = new Builder();
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    builder.c(((EventGuestSingleListModel) immutableList.get(i2)).a);
                }
                immutableList3 = builder.b();
            }
            immutableList2 = immutableList3;
        } else {
            immutableList2 = f18421b;
        }
        this.f18429i = immutableList2;
        final int size2 = this.f18429i.size();
        this.f18430j = new int[size2];
        this.f18427g = new EventGuestListFragment[size2];
        Builder builder2 = new Builder();
        Builder builder3 = new Builder();
        for (int i3 = 0; i3 < size2; i3++) {
            builder2.c(new ArrayList());
            builder3.c(new ArrayList());
        }
        this.f18432l = builder2.b();
        this.f18433m = builder3.b();
        while (i < size2) {
            this.f18427g[i] = EventGuestListFragment.m18705a(bundle, (EventGuestListType) this.f18429i.get(i));
            this.f18427g[i].ap = new Object(this) {
                public final /* synthetic */ EventGuestListPagerAdapter f18419b;
            };
            i++;
        }
        return this;
    }

    public final CharSequence J_(int i) {
        if (i >= this.f18422a.size()) {
            return "";
        }
        EventGuestSingleListModel eventGuestSingleListModel = (EventGuestSingleListModel) this.f18422a.get(i);
        return m18771a(eventGuestSingleListModel.a, eventGuestSingleListModel.b == null ? null : Integer.valueOf(eventGuestSingleListModel.b.intValue() + eventGuestSingleListModel.c));
    }

    private String m18772b(EventGuestListType eventGuestListType) {
        Resources resources = this.f18423c.getResources();
        switch (C26142.f18420a[eventGuestListType.ordinal()]) {
            case 1:
            case 2:
                return resources.getString(2131237083);
            case 3:
                return resources.getString(2131237084);
            case 4:
                return resources.getString(2131237204);
            case 5:
            case 6:
                return resources.getString(2131237085);
            case 7:
                return resources.getString(2131237086);
            default:
                throw new IllegalArgumentException("GuestListType has no resource assigned to it");
        }
    }

    private String m18771a(EventGuestListType eventGuestListType, Integer num) {
        if (!this.f18426f || num == null || num.intValue() < 0) {
            return m18772b(eventGuestListType);
        }
        return this.f18423c.getResources().getQuantityString(m18773c(eventGuestListType), num.intValue(), new Object[]{this.f18424d.a(num.intValue())});
    }

    private static int m18773c(EventGuestListType eventGuestListType) {
        switch (C26142.f18420a[eventGuestListType.ordinal()]) {
            case 1:
                return 2131689670;
            case 3:
                return 2131689671;
            case 5:
                return 2131689672;
            case 7:
                return 2131689673;
            default:
                throw new IllegalArgumentException("GuestListType has no resource assigned to it");
        }
    }

    public final void m18778b(ViewGroup viewGroup, int i, Object obj) {
        EventGuestListFragment eventGuestListFragment = (EventGuestListFragment) obj;
        if (eventGuestListFragment != this.f18431k) {
            super.b(viewGroup, i, obj);
            int[] iArr = this.f18430j;
            iArr[i] = iArr[i] + 1;
            if (this.f18428h != null) {
                C26062 c26062 = this.f18428h;
                c26062.f18374a.f18380c.m18849a((EventGuestListType) this.f18429i.get(i));
                EventGuestListPagerAdapter eventGuestListPagerAdapter = c26062.f18374a.f18385h;
                for (int i2 = 0; i2 < eventGuestListPagerAdapter.f18429i.size(); i2++) {
                    EventGuestListFragment eventGuestListFragment2;
                    List list = (List) eventGuestListPagerAdapter.f18433m.get(i2);
                    if (!list.isEmpty()) {
                        eventGuestListFragment2 = eventGuestListPagerAdapter.f18427g[i2];
                        if (eventGuestListFragment2.f18367d != null) {
                            eventGuestListFragment2.f18367d.m18767a(list);
                        }
                        if (eventGuestListFragment2.f18370g != null) {
                            eventGuestListFragment2.f18370g.f18342j.clear();
                            AdapterDetour.a(eventGuestListFragment2.f18370g, 563182889);
                        }
                        list.clear();
                    }
                    list = (List) eventGuestListPagerAdapter.f18432l.get(i2);
                    if (!list.isEmpty()) {
                        eventGuestListFragment2 = eventGuestListPagerAdapter.f18427g[i2];
                        if (eventGuestListFragment2.f18367d != null) {
                            eventGuestListFragment2.f18367d.m18768b(list);
                        }
                        if (eventGuestListFragment2.f18370g != null) {
                            AdapterDetour.a(eventGuestListFragment2.f18370g, 1687326327);
                        }
                        list.clear();
                    }
                }
            }
            this.f18431k = eventGuestListFragment;
        }
    }

    public final int m18777b() {
        return this.f18427g.length;
    }

    public final Fragment m18774a(int i) {
        return this.f18427g[i];
    }

    public final Object m18776a(ViewGroup viewGroup, int i) {
        Object a = super.a(viewGroup, i);
        this.f18427g[i] = (EventGuestListFragment) a;
        return a;
    }
}
