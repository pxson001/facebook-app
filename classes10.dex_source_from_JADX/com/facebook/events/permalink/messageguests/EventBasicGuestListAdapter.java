package com.facebook.events.permalink.messageguests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.guestlist.EventGuestListSection;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.SectionedListAdapter;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.IdentityHashMap;
import java.util.Map;

/* compiled from: broadcast_extras */
public abstract class EventBasicGuestListAdapter extends SectionedListAdapter implements SectionIndexer {
    public final Context f18329c;
    private final Map<String, EventUser> f18330d = Maps.c();
    private boolean f18331e;
    public int[] f18332f;
    public EventGuestListType f18333g;
    public ImmutableList<EventGuestListSection> f18334h = RegularImmutableList.a;

    /* compiled from: broadcast_extras */
    public enum ViewTypes {
        HEADER,
        CHILD,
        LOADING
    }

    public EventBasicGuestListAdapter(Context context) {
        this.f18329c = context;
    }

    protected final int m18680f(int i) {
        return this.f18332f[i];
    }

    protected final void m18679d(int i, int i2) {
        this.f18332f[i] = i2;
    }

    public final void m18672a(ImmutableList<EventGuestListSection> immutableList) {
        Builder builder = ImmutableList.builder();
        IdentityHashMap identityHashMap = new IdentityHashMap(immutableList.size());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            EventGuestListSection eventGuestListSection = (EventGuestListSection) immutableList.get(i);
            if (!identityHashMap.containsKey(eventGuestListSection)) {
                builder.c(eventGuestListSection);
                identityHashMap.put(eventGuestListSection, eventGuestListSection);
            }
        }
        this.f18334h = builder.b();
        this.f18332f = new int[immutableList.size()];
        AdapterDetour.a(this, 542566567);
    }

    public final EventGuestListType m18681i() {
        return this.f18333g;
    }

    public final Object m18674b(int i) {
        return this.f18334h.get(i);
    }

    public final int m18676c() {
        return this.f18334h.size();
    }

    public final View m18670a(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view != null) {
            view = (ViewGroup) view;
        } else {
            view = (ViewGroup) LayoutInflater.from(this.f18329c).inflate(2130904166, viewGroup, false);
        }
        SectionedListSection sectionedListSection = (SectionedListSection) m18674b(i);
        BetterTextView betterTextView = (BetterTextView) view.findViewById(2131561570);
        betterTextView.setText(sectionedListSection.a());
        if (sectionedListSection.a() == null) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        betterTextView.setVisibility(i2);
        return view;
    }

    public final int m18669a(int i) {
        return ViewTypes.HEADER.ordinal();
    }

    public final Object m18671a(int i, int i2) {
        return ((EventGuestListSection) this.f18334h.get(i)).b().get(i2);
    }

    public final int m18677c(int i) {
        int size;
        SectionedListSection sectionedListSection = (SectionedListSection) this.f18334h.get(i);
        if (sectionedListSection.c()) {
            size = sectionedListSection.b().size() + 1;
        } else {
            size = sectionedListSection.b().size();
        }
        if (this.f18331e && i == this.f18334h.size() - 1) {
            return size + 1;
        }
        return size;
    }

    public final int m18678c(int i, int i2) {
        if (this.f18331e && i == this.f18334h.size() - 1 && i2 == ((EventGuestListSection) this.f18334h.get(i)).b().size()) {
            return ViewTypes.LOADING.ordinal();
        }
        return ViewTypes.CHILD.ordinal();
    }

    public final boolean m18675b(int i, int i2) {
        return true;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public final void m18673a(boolean z) {
        if (this.f18331e != z) {
            this.f18331e = z;
            AdapterDetour.a(this, -1233343365);
        }
    }
}
