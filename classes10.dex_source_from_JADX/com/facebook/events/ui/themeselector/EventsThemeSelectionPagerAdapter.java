package com.facebook.events.ui.themeselector;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeCategoriesModel.EventCoverPhotoThemeCategoriesModel.NodesModel;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: app_started_by_launcher */
public class EventsThemeSelectionPagerAdapter extends PagerAdapter {
    private EventsThemeSelectionRecyclerViewWrapperProvider f19547a;
    private String f19548b;
    private String f19549c;
    private int f19550d;
    public EventsThemeSelectionRecyclerViewWrapper[] f19551e = new EventsThemeSelectionRecyclerViewWrapper[b()];
    public ImmutableList<NodesModel> f19552f;

    @Inject
    public EventsThemeSelectionPagerAdapter(@Assisted String str, @Assisted String str2, @Assisted Integer num, @Assisted ImmutableList<NodesModel> immutableList, EventsThemeSelectionRecyclerViewWrapperProvider eventsThemeSelectionRecyclerViewWrapperProvider) {
        this.f19548b = str;
        this.f19549c = str2;
        this.f19547a = eventsThemeSelectionRecyclerViewWrapperProvider;
        this.f19550d = num.intValue();
        this.f19552f = immutableList;
    }

    public final int m19760b() {
        return this.f19552f.size();
    }

    public final boolean m19759a(View view, Object obj) {
        return ((EventsThemeSelectionRecyclerViewWrapper) obj).f19561e == view;
    }

    public final Object m19757a(ViewGroup viewGroup, int i) {
        Object obj = this.f19551e[i];
        if (obj != null) {
            return obj;
        }
        EventsThemeSelectionRecyclerViewWrapper a = this.f19547a.m19774a(this.f19548b, this.f19549c, Integer.valueOf(this.f19550d), ((NodesModel) this.f19552f.get(i)).m19814k());
        this.f19551e[i] = a;
        return a;
    }

    public final void m19761b(ViewGroup viewGroup, int i, Object obj) {
        ((EventsThemeSelectionRecyclerViewWrapper) obj).m19772a(viewGroup);
    }

    public final CharSequence J_(int i) {
        return ((NodesModel) this.f19552f.get(i)).m19813j();
    }

    public final void m19758a(ViewGroup viewGroup, int i, Object obj) {
        ((EventsThemeSelectionRecyclerViewWrapper) obj).m19773b(viewGroup);
    }
}
