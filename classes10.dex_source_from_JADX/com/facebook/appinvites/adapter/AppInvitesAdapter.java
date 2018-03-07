package com.facebook.appinvites.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appinvites.data.AppInvitesData;
import com.facebook.appinvites.data.AppInvitesData.C20371;
import com.facebook.appinvites.data.AppInvitesData.C20393;
import com.facebook.appinvites.data.AppInvitesDataCluster;
import com.facebook.appinvites.events.AppInviteEventSubscriber;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteAllDeletedEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteAppInstalledEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteApplicationBlockedEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteCollapseAnimationCompleteEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteDeletedEvent;
import com.facebook.appinvites.events.AppInviteEvents.AppInviteUserBlockedEvent;
import com.facebook.appinvites.ui.AppInviteView;
import com.facebook.appinvites.ui.AppInvitesViewController;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.Iterables;
import javax.inject.Inject;

/* compiled from: eil */
public class AppInvitesAdapter extends FbBaseAdapter {
    public final AppInvitesData f14551a;
    private final AppInvitesViewController f14552b;

    /* compiled from: eil */
    public class C20301 extends AppInviteEventSubscriber<AppInviteDeletedEvent> {
        final /* synthetic */ AppInvitesAdapter f14545a;

        public C20301(AppInvitesAdapter appInvitesAdapter) {
            this.f14545a = appInvitesAdapter;
        }

        public final void m14723b(FbEvent fbEvent) {
            this.f14545a.f14551a.m14742a(((AppInviteDeletedEvent) fbEvent).f14580a.m15017c().m14991d());
            AdapterDetour.a(this.f14545a, 1970532689);
        }

        public final Class<AppInviteDeletedEvent> m14722a() {
            return AppInviteDeletedEvent.class;
        }
    }

    /* compiled from: eil */
    public class C20312 extends AppInviteEventSubscriber<AppInviteUserBlockedEvent> {
        final /* synthetic */ AppInvitesAdapter f14546a;

        public C20312(AppInvitesAdapter appInvitesAdapter) {
            this.f14546a = appInvitesAdapter;
        }

        public final void m14725b(FbEvent fbEvent) {
            AppInviteUserBlockedEvent appInviteUserBlockedEvent = (AppInviteUserBlockedEvent) fbEvent;
            AppInvitesData appInvitesData = this.f14546a.f14551a;
            String str = appInviteUserBlockedEvent.f14581a;
            int size = appInvitesData.f14571a.size();
            for (int i = 0; i < size; i++) {
                Iterables.a((AppInvitesDataCluster) appInvitesData.f14571a.get(i), new C20371(appInvitesData, str));
            }
            AdapterDetour.a(this.f14546a, -760238065);
        }

        public final Class<AppInviteUserBlockedEvent> m14724a() {
            return AppInviteUserBlockedEvent.class;
        }
    }

    /* compiled from: eil */
    public class C20323 extends AppInviteEventSubscriber<AppInviteApplicationBlockedEvent> {
        final /* synthetic */ AppInvitesAdapter f14547a;

        public C20323(AppInvitesAdapter appInvitesAdapter) {
            this.f14547a = appInvitesAdapter;
        }

        public final void m14727b(FbEvent fbEvent) {
            this.f14547a.f14551a.m14742a(((AppInviteApplicationBlockedEvent) fbEvent).f14579a);
            AdapterDetour.a(this.f14547a, 1525857646);
        }

        public final Class<AppInviteApplicationBlockedEvent> m14726a() {
            return AppInviteApplicationBlockedEvent.class;
        }
    }

    /* compiled from: eil */
    public class C20334 extends AppInviteEventSubscriber<AppInviteAllDeletedEvent> {
        final /* synthetic */ AppInvitesAdapter f14548a;

        public C20334(AppInvitesAdapter appInvitesAdapter) {
            this.f14548a = appInvitesAdapter;
        }

        public final void m14729b(FbEvent fbEvent) {
            this.f14548a.f14551a.m14743b();
            AdapterDetour.a(this.f14548a, -601742603);
        }

        public final Class<AppInviteAllDeletedEvent> m14728a() {
            return AppInviteAllDeletedEvent.class;
        }
    }

    /* compiled from: eil */
    public class C20345 extends AppInviteEventSubscriber<AppInviteAppInstalledEvent> {
        final /* synthetic */ AppInvitesAdapter f14549a;

        public C20345(AppInvitesAdapter appInvitesAdapter) {
            this.f14549a = appInvitesAdapter;
        }

        public final void m14731b(FbEvent fbEvent) {
            AdapterDetour.a(this.f14549a, 705420215);
        }

        public final Class<AppInviteAppInstalledEvent> m14730a() {
            return AppInviteAppInstalledEvent.class;
        }
    }

    /* compiled from: eil */
    public class C20356 extends AppInviteEventSubscriber<AppInviteCollapseAnimationCompleteEvent> {
        final /* synthetic */ AppInvitesAdapter f14550a;

        public C20356(AppInvitesAdapter appInvitesAdapter) {
            this.f14550a = appInvitesAdapter;
        }

        public final void m14733b(FbEvent fbEvent) {
            int a = this.f14550a.f14551a.m14740a();
            AppInvitesData appInvitesData = this.f14550a.f14551a;
            Iterables.a(appInvitesData.f14571a, new C20393(appInvitesData));
            if (a != this.f14550a.f14551a.m14740a()) {
                AdapterDetour.a(this.f14550a, -44109235);
            }
        }

        public final Class<AppInviteCollapseAnimationCompleteEvent> m14732a() {
            return AppInviteCollapseAnimationCompleteEvent.class;
        }
    }

    @Inject
    public AppInvitesAdapter(@Assisted AppInvitesData appInvitesData, AppInvitesViewController appInvitesViewController) {
        this.f14551a = appInvitesData;
        this.f14552b = appInvitesViewController;
    }

    public int getCount() {
        return this.f14551a.m14740a();
    }

    public Object getItem(int i) {
        return (AppInvitesDataCluster) this.f14551a.f14571a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m14734a(int i, ViewGroup viewGroup) {
        return new AppInviteView(viewGroup.getContext());
    }

    public final void m14735a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f14552b.m15106a((AppInvitesDataCluster) obj, (AppInviteView) view);
    }
}
