package com.facebook.events.permalink.hostsinfo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.fragment.FbFragment;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.events.model.EventArtist;
import com.facebook.events.model.EventUser;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: blank title */
public class EventHostsFragment extends FbFragment implements AnalyticsFragmentWithExtraData {
    @Inject
    public EventPermalinkController f18555a;
    @Inject
    public FbTitleBarSupplier f18556b;

    /* compiled from: blank title */
    class EventArtistsAdapter extends BaseAdapter {
        private Context f18551a;
        private final List<EventArtist> f18552b;

        public EventArtistsAdapter(Context context, List<EventArtist> list) {
            this.f18551a = context;
            this.f18552b = list;
        }

        public int getCount() {
            return this.f18552b.size();
        }

        public Object getItem(int i) {
            return this.f18552b.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Uri parse;
            if (view != null) {
                view = (HostInfoRow) view;
            } else {
                view = new HostInfoRow(this.f18551a);
            }
            EventArtist eventArtist = (EventArtist) this.f18552b.get(i);
            Preconditions.checkNotNull(eventArtist);
            FbDraweeView fbDraweeView = view.f18558b;
            if (eventArtist.c != null) {
                parse = Uri.parse(eventArtist.c);
            } else {
                parse = null;
            }
            fbDraweeView.a(parse, HostInfoRow.f18557a);
            view.f18559c.setText(eventArtist.b);
            return view;
        }
    }

    /* compiled from: blank title */
    class EventUsersAdapter extends BaseAdapter {
        private Context f18553a;
        private final List<EventUser> f18554b;

        public EventUsersAdapter(Context context, List<EventUser> list) {
            this.f18553a = context;
            this.f18554b = list;
        }

        public int getCount() {
            return this.f18554b.size();
        }

        public Object getItem(int i) {
            return this.f18554b.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Uri parse;
            if (view != null) {
                view = (HostInfoRow) view;
            } else {
                view = new HostInfoRow(this.f18553a);
            }
            EventUser eventUser = (EventUser) this.f18554b.get(i);
            Preconditions.checkNotNull(eventUser);
            FbDraweeView fbDraweeView = view.f18558b;
            if (eventUser.d != null) {
                parse = Uri.parse(eventUser.d);
            } else {
                parse = null;
            }
            fbDraweeView.a(parse, HostInfoRow.f18557a);
            view.f18559c.setText(eventUser.c);
            return view;
        }
    }

    public static void m18894a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        EventHostsFragment eventHostsFragment = (EventHostsFragment) obj;
        EventPermalinkController b = EventPermalinkController.m18262b(injectorLike);
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike);
        eventHostsFragment.f18555a = b;
        eventHostsFragment.f18556b = fbTitleBarSupplier;
    }

    public final void m18898c(Bundle bundle) {
        super.c(bundle);
        Class cls = EventHostsFragment.class;
        m18894a((Object) this, getContext());
    }

    public final View m18895a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -247630704);
        View inflate = layoutInflater.inflate(2130904042, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -402755529, a);
        return inflate;
    }

    public final void m18896a(View view, Bundle bundle) {
        super.a(view, bundle);
        ListView listView = (ListView) e(2131561309);
        Bundle bundle2 = this.s;
        List parcelableArrayList = bundle2.getParcelableArrayList("ARTISTS");
        List parcelableArrayList2 = bundle2.getParcelableArrayList("HOSTS");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            final ListAdapter eventArtistsAdapter = new EventArtistsAdapter(getContext(), parcelableArrayList);
            listView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ EventHostsFragment f18548b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f18548b.f18555a.m18267a(this.f18548b.getContext(), (EventArtist) eventArtistsAdapter.getItem(i));
                }
            });
            listView.setAdapter(eventArtistsAdapter);
        } else if (parcelableArrayList2 == null || parcelableArrayList2.isEmpty()) {
            throw new IllegalStateException("Should not be starting hosts when no artist or hosts are provided.");
        } else {
            final ListAdapter eventUsersAdapter = new EventUsersAdapter(getContext(), parcelableArrayList2);
            listView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ EventHostsFragment f18550b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f18550b.f18555a.m18268a(this.f18550b.getContext(), (EventUser) eventUsersAdapter.getItem(i));
                }
            });
            listView.setAdapter(eventUsersAdapter);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1489440894);
        super.mi_();
        ((FbTitleBar) this.f18556b.get()).setTitle(2131237081);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 79606765, a);
    }

    public final String am_() {
        return "event_host_list";
    }

    public final Map<String, Object> m18897c() {
        return EventEventLogger.m18117a((Object) this.s.getString("EVENT_ID"));
    }
}
