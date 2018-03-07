package com.facebook.events.permalink.messageguests;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.messageguests.EventMessageGuestsFrameFragment.C26571;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* compiled from: beginTime */
public class EventMessageGuestsPagerAdapter extends FragmentPagerAdapter {
    List<EventGuestListType> f18668a;
    ImmutableList<Integer> f18669b;
    private final Context f18670c;
    public final EventMessageGuestsFragment[] f18671d;
    private Bundle f18672e;
    public C26571 f18673f;

    public EventMessageGuestsPagerAdapter(FragmentManager fragmentManager, Context context, List<EventGuestListType> list, ImmutableList<Integer> immutableList, Bundle bundle) {
        super(fragmentManager);
        this.f18670c = context;
        if (list == null || list.size() != 3) {
            this.f18668a = Arrays.asList(new EventGuestListType[]{EventGuestListType.PRIVATE_GOING, EventGuestListType.PRIVATE_MAYBE, EventGuestListType.PRIVATE_INVITED});
        } else {
            this.f18668a = list;
        }
        if (immutableList == null || immutableList.size() != 3) {
            this.f18669b = ImmutableList.of(Integer.valueOf(2131237083), Integer.valueOf(2131237084), Integer.valueOf(2131237085));
        } else {
            this.f18669b = immutableList;
        }
        this.f18671d = new EventMessageGuestsFragment[this.f18668a.size()];
        this.f18672e = bundle;
    }

    public final CharSequence J_(int i) {
        return this.f18670c.getResources().getString(((Integer) this.f18669b.get(i)).intValue());
    }

    public final void m18978b(ViewGroup viewGroup, int i, Object obj) {
        super.b(viewGroup, i, obj);
        if (this.f18673f != null) {
            EventGuestListType eventGuestListType = (EventGuestListType) this.f18668a.get(i);
            this.f18673f.f18654a.f18659a.m18849a(eventGuestListType);
        }
    }

    public final int m18977b() {
        return this.f18671d.length;
    }

    public final Fragment m18975a(int i) {
        return this.f18671d[i];
    }

    public final Set<String> m18979d() {
        Collection a = Sets.a();
        for (EventMessageGuestsFragment eventMessageGuestsFragment : this.f18671d) {
            if (eventMessageGuestsFragment != null) {
                a.addAll(eventMessageGuestsFragment.aq());
            }
        }
        return ImmutableSet.copyOf(a);
    }

    public final Object m18976a(ViewGroup viewGroup, int i) {
        if (a(i) == null) {
            EventMessageGuestsFragment[] eventMessageGuestsFragmentArr = this.f18671d;
            Bundle bundle = this.f18672e;
            EventGuestListType eventGuestListType = (EventGuestListType) this.f18668a.get(i);
            EventMessageGuestsFragment eventMessageGuestsFragment = new EventMessageGuestsFragment();
            Bundle bundle2 = new Bundle(bundle);
            bundle2.putString("EVENT_GUEST_LIST_RSVP_TYPE", eventGuestListType.toString());
            eventMessageGuestsFragment.g(bundle2);
            eventMessageGuestsFragmentArr[i] = eventMessageGuestsFragment;
        }
        return super.a(viewGroup, i);
    }
}
