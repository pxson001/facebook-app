package com.facebook.events.notificationsettings;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.events.notificationsettings.EventsNotificationSettingsPager.C25232;
import com.facebook.events.notificationsettings.EventsNotificationSettingsPager.C25243;
import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQLModels.FetchEventsNotificationSubscriptionLevelsModel.PossibleNotificationSubscriptionLevelsModel.EdgesModel;
import com.facebook.graphql.enums.GraphQLEventNotificationSubscriptionLevel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import java.util.List;
import javax.inject.Inject;

/* compiled from: catalog_render_time */
public class EventsNotificationSettingsFragment extends FbFragment {
    @Inject
    public EventsNotificationSettingsAdapterProvider f17804a;
    @Inject
    public EventsNotificationSettingsPager f17805b;
    @Inject
    public FbTitleBarSupplier f17806c;
    public EventsNotificationSettingsAdapter f17807d;
    private RecyclerView f17808e;
    public String f17809f;

    /* compiled from: catalog_render_time */
    public class C25211 {
        final /* synthetic */ EventsNotificationSettingsFragment f17803a;

        public C25211(EventsNotificationSettingsFragment eventsNotificationSettingsFragment) {
            this.f17803a = eventsNotificationSettingsFragment;
        }

        public final void m18151a(List<EdgesModel> list, GraphQLEventNotificationSubscriptionLevel graphQLEventNotificationSubscriptionLevel) {
            if (!list.isEmpty()) {
                EventsNotificationSettingsAdapter eventsNotificationSettingsAdapter = this.f17803a.f17807d;
                eventsNotificationSettingsAdapter.f17798a = list;
                eventsNotificationSettingsAdapter.notifyDataSetChanged();
            }
            this.f17803a.f17807d.f17799b = graphQLEventNotificationSubscriptionLevel;
        }
    }

    public static void m18152a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EventsNotificationSettingsFragment eventsNotificationSettingsFragment = (EventsNotificationSettingsFragment) obj;
        EventsNotificationSettingsAdapterProvider eventsNotificationSettingsAdapterProvider = (EventsNotificationSettingsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventsNotificationSettingsAdapterProvider.class);
        EventsNotificationSettingsPager eventsNotificationSettingsPager = new EventsNotificationSettingsPager(GraphQLQueryExecutor.a(fbInjector), GraphQLSubscriptionHolder.b(fbInjector), TasksManager.b(fbInjector));
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector);
        eventsNotificationSettingsFragment.f17804a = eventsNotificationSettingsAdapterProvider;
        eventsNotificationSettingsFragment.f17805b = eventsNotificationSettingsPager;
        eventsNotificationSettingsFragment.f17806c = fbTitleBarSupplier;
    }

    public final void m18156c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventsNotificationSettingsFragment.class;
        m18152a((Object) this, getContext());
        this.f17809f = this.s.getString("event_id");
        this.f17807d = new EventsNotificationSettingsAdapter(this.f17809f, GraphQLQueryExecutor.a(this.f17804a));
    }

    public final View m18154a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1650197586);
        View inflate = layoutInflater.inflate(2130904164, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 830741717, a);
        return inflate;
    }

    public final void m18155a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f17808e = (RecyclerView) e(2131561569);
        this.f17808e.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.f17808e.setAdapter(this.f17807d);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2074757502);
        super.mi_();
        ((FbTitleBar) this.f17806c.get()).setTitle(2131241912);
        EventsNotificationSettingsPager eventsNotificationSettingsPager = this.f17805b;
        String str = this.f17809f;
        eventsNotificationSettingsPager.f17818d = new C25211(this);
        eventsNotificationSettingsPager.f17817c.a("fetchNotificationSettings", new C25232(eventsNotificationSettingsPager, str), new C25243(eventsNotificationSettingsPager, str));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1438303816, a);
    }

    public final void m18153I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 796400557);
        super.I();
        this.f17805b.f17817c.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 92397709, a);
    }
}
