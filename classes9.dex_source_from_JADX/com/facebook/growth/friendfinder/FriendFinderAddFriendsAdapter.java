package com.facebook.growth.friendfinder;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friending.common.list.DefaultFriendListBinder;
import com.facebook.friending.common.list.DefaultFriendListBinderProvider;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.navigator.FriendingNavigatorGatekeepers;
import com.facebook.friends.navigator.NavigationEventBus;
import com.facebook.friends.navigator.NavigationEvents.FriendableContactsChangedEvent;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: paymentCardBin */
public class FriendFinderAddFriendsAdapter extends FbBaseAdapter implements Filterable, StickyHeaderAdapter {
    private static final Object f7149a = new Object();
    private static final Object f7150b = new Object();
    private static final Object f7151c = new Object();
    private static final Object f7152d = new Object();
    public final List<FriendFinderFriendCandidate> f7153e;
    public final List<FriendFinderFriendCandidate> f7154f;
    public final Map<Long, FriendFinderFriendCandidate> f7155g;
    public final Set<FriendFinderFriendCandidate> f7156h;
    private final FriendshipStatusChangedEventSubscriber f7157i;
    public List<FriendFinderFriendCandidate> f7158j;
    public List<FriendFinderFriendCandidate> f7159k;
    private Filter f7160l;
    private int f7161m;
    public State f7162n = State.DEFAULT;
    public RetryClickedListener f7163o;
    public final FbUriIntentHandler f7164p;
    public final FriendFinderAnalyticsLogger f7165q;
    private final FriendingEventBus f7166r;
    private final DefaultFriendListBinder f7167s;
    public final Context f7168t;
    public final Resources f7169u;
    public final NavigationEventBus f7170v;
    public final GatekeeperStoreImpl f7171w;

    /* compiled from: paymentCardBin */
    public class C07581 implements OnClickListener {
        final /* synthetic */ FriendFinderAddFriendsAdapter f7141a;

        public C07581(FriendFinderAddFriendsAdapter friendFinderAddFriendsAdapter) {
            this.f7141a = friendFinderAddFriendsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1209275314);
            this.f7141a.f7165q.d();
            Bundle bundle = new Bundle();
            bundle.putBoolean("titlebar_with_modal_done", true);
            this.f7141a.f7164p.a(this.f7141a.f7168t, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, "/invite/history"), bundle);
            Logger.a(2, EntryType.UI_INPUT_END, -1724972701, a);
        }
    }

    /* compiled from: paymentCardBin */
    class FriendFinderAddFriendsAdapterFilter extends Filter {
        List<FriendFinderFriendCandidate> f7144a;
        List<FriendFinderFriendCandidate> f7145b;
        final Comparator<FriendFinderFriendCandidate> f7146c = new C07601(this);
        final /* synthetic */ FriendFinderAddFriendsAdapter f7147d;

        /* compiled from: paymentCardBin */
        class C07601 implements Comparator<FriendFinderFriendCandidate> {
            final /* synthetic */ FriendFinderAddFriendsAdapterFilter f7143a;

            C07601(FriendFinderAddFriendsAdapterFilter friendFinderAddFriendsAdapterFilter) {
                this.f7143a = friendFinderAddFriendsAdapterFilter;
            }

            public int compare(Object obj, Object obj2) {
                FriendFinderFriendCandidate friendFinderFriendCandidate = (FriendFinderFriendCandidate) obj2;
                String b = ((FriendFinderFriendCandidate) obj).m7469b();
                String b2 = friendFinderFriendCandidate.m7469b();
                if (b == null || b2 == null) {
                    return b == null ? -1 : 1;
                } else {
                    return b.compareTo(b2);
                }
            }
        }

        public FriendFinderAddFriendsAdapterFilter(FriendFinderAddFriendsAdapter friendFinderAddFriendsAdapter) {
            this.f7147d = friendFinderAddFriendsAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            if (!StringUtil.a(charSequence)) {
                Locale locale;
                Locale locale2 = this.f7147d.f7169u.getConfiguration().locale;
                if (locale2 == null) {
                    locale = Locale.getDefault();
                } else {
                    locale = locale2;
                }
                String toLowerCase = charSequence.toString().toLowerCase(locale);
                this.f7144a = Lists.a();
                for (FriendFinderFriendCandidate friendFinderFriendCandidate : this.f7147d.f7153e) {
                    if (m7421a(friendFinderFriendCandidate.m7469b().toLowerCase(locale), toLowerCase)) {
                        this.f7144a.add(friendFinderFriendCandidate);
                    }
                }
                this.f7145b = Lists.a();
                for (FriendFinderFriendCandidate friendFinderFriendCandidate2 : this.f7147d.f7154f) {
                    if (m7421a(friendFinderFriendCandidate2.m7469b().toLowerCase(locale), toLowerCase)) {
                        this.f7145b.add(friendFinderFriendCandidate2);
                    }
                }
                Collections.sort(this.f7144a, this.f7146c);
                Collections.sort(this.f7145b, this.f7146c);
            }
            return null;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (StringUtil.a(charSequence)) {
                this.f7147d.f7158j = this.f7147d.f7153e;
                this.f7147d.f7159k = this.f7147d.f7154f;
            } else {
                this.f7147d.f7158j = this.f7144a;
                this.f7147d.f7159k = this.f7145b;
            }
            AdapterDetour.a(this.f7147d, 956188028);
        }

        private static boolean m7421a(String str, String str2) {
            return str2.length() == 1 ? str.startsWith(str2) : str.contains(str2);
        }
    }

    /* compiled from: paymentCardBin */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendFinderAddFriendsAdapter f7148a;

        public FriendshipStatusChangedEventSubscriber(FriendFinderAddFriendsAdapter friendFinderAddFriendsAdapter) {
            this.f7148a = friendFinderAddFriendsAdapter;
        }

        public final void m7422b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null) {
                FriendFinderFriendCandidate friendFinderFriendCandidate = (FriendFinderFriendCandidate) this.f7148a.f7155g.get(Long.valueOf(friendshipStatusChangedEvent.a));
                if (friendFinderFriendCandidate == null) {
                    return;
                }
                if (friendshipStatusChangedEvent.c || friendshipStatusChangedEvent.b != friendFinderFriendCandidate.m7474f()) {
                    friendFinderFriendCandidate.m7470b(friendshipStatusChangedEvent.b);
                    if (this.f7148a.f7171w.a(FriendingNavigatorGatekeepers.f6747a, false) && this.f7148a.f7156h.contains(friendFinderFriendCandidate)) {
                        if (friendFinderFriendCandidate.m7474f() == GraphQLFriendshipStatus.OUTGOING_REQUEST) {
                            this.f7148a.f7170v.a(new FriendableContactsChangedEvent(-1));
                        } else if (friendFinderFriendCandidate.m7474f() == GraphQLFriendshipStatus.CAN_REQUEST) {
                            this.f7148a.f7170v.a(new FriendableContactsChangedEvent(1));
                        }
                    }
                    AdapterDetour.a(this.f7148a, 1832477972);
                }
            }
        }
    }

    /* compiled from: paymentCardBin */
    enum RowType {
        CONTACTS_HEADER,
        CONTACT,
        MANAGE_CONTACTS,
        LOADING,
        FAILURE,
        PYMK_HEADER,
        PYMK
    }

    /* compiled from: paymentCardBin */
    public enum State {
        DEFAULT,
        LOADING_MORE,
        FAILURE
    }

    @Inject
    public FriendFinderAddFriendsAdapter(FbUriIntentHandler fbUriIntentHandler, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, FriendingEventBus friendingEventBus, DefaultFriendListBinderProvider defaultFriendListBinderProvider, NavigationEventBus navigationEventBus, GatekeeperStoreImpl gatekeeperStoreImpl, @Assisted Context context) {
        this.f7164p = fbUriIntentHandler;
        this.f7165q = friendFinderAnalyticsLogger;
        this.f7166r = friendingEventBus;
        this.f7170v = navigationEventBus;
        this.f7171w = gatekeeperStoreImpl;
        this.f7168t = context;
        this.f7169u = context.getResources();
        this.f7167s = new DefaultFriendListBinder(this.f7169u, String_LoggedInUserIdMethodAutoProvider.b(defaultFriendListBinderProvider), FriendingButtonController.b(defaultFriendListBinderProvider), AllCapsTransformationMethod.b(defaultFriendListBinderProvider));
        this.f7157i = new FriendshipStatusChangedEventSubscriber(this);
        this.f7166r.a(this.f7157i);
        List a = Lists.a();
        this.f7158j = a;
        this.f7153e = a;
        a = Lists.a();
        this.f7159k = a;
        this.f7154f = a;
        this.f7155g = Maps.c();
        this.f7156h = new HashSet();
        this.f7161m = 0;
    }

    public int getCount() {
        int i = 0;
        boolean isEmpty = this.f7158j.isEmpty();
        boolean isEmpty2 = this.f7159k.isEmpty();
        if (isEmpty && isEmpty2) {
            return 0;
        }
        int size = (this.f7162n != State.DEFAULT ? 1 : 0) + ((this.f7158j.size() + 1) + 1);
        if (!isEmpty2) {
            i = this.f7159k.size() + 1;
        }
        return i + size;
    }

    public Object getItem(int i) {
        RowType b = m7425b(i);
        int a = i - m7423a(b);
        switch (b) {
            case CONTACTS_HEADER:
                return f7149a;
            case CONTACT:
                return this.f7158j.get(a);
            case LOADING:
            case FAILURE:
                return f7152d;
            case MANAGE_CONTACTS:
                return f7151c;
            case PYMK_HEADER:
                return f7150b;
            case PYMK:
                return this.f7159k.get(a);
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m7428a(int i, ViewGroup viewGroup) {
        View view;
        switch (RowType.values()[i]) {
            case CONTACTS_HEADER:
                view = (TextView) m7424a(viewGroup);
                view.setText(2131236424);
                return view;
            case CONTACT:
                return m7426d(viewGroup);
            case LOADING:
            case FAILURE:
                return LayoutInflater.from(viewGroup.getContext()).inflate(2130904476, viewGroup, false);
            case MANAGE_CONTACTS:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(2130904478, viewGroup, false);
                view.setOnClickListener(new C07581(this));
                return view;
            case PYMK_HEADER:
                view = (TextView) m7424a(viewGroup);
                view.setText(2131236425);
                return view;
            case PYMK:
                return m7426d(viewGroup);
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    public final void m7430a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (RowType.values()[i2]) {
            case CONTACT:
            case PYMK:
                this.f7167s.a((FriendListItemView) view, (FriendFinderFriendCandidate) obj);
                return;
            case LOADING:
                ((LoadingIndicatorView) view).a();
                return;
            case FAILURE:
                ((LoadingIndicatorView) view).a(this.f7169u.getString(2131230761), this.f7163o);
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        return m7425b(i).ordinal();
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public final View m7433b(int i, View view, ViewGroup viewGroup) {
        View a;
        RowType b = m7425b(i);
        if (view == null) {
            a = m7424a(viewGroup);
        } else {
            a = view;
        }
        TextView textView = (TextView) a;
        int i2 = (b == RowType.PYMK_HEADER || b == RowType.PYMK) ? 2131236425 : 2131236424;
        textView.setText(i2);
        if (this.f7161m == 0) {
            a.setLayoutParams(new LayoutParams(-1, -2));
            a.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            this.f7161m = a.getMeasuredHeight();
        }
        return a;
    }

    public final int o_(int i) {
        return 0;
    }

    public final int m7436e(int i) {
        return this.f7161m;
    }

    public final int m7435d() {
        return this.f7169u.getColor(2131361920);
    }

    public final boolean m7437f(int i) {
        return m7425b(i) == RowType.PYMK_HEADER;
    }

    public Filter getFilter() {
        if (this.f7160l == null) {
            this.f7160l = new FriendFinderAddFriendsAdapterFilter(this);
        }
        return this.f7160l;
    }

    public final void m7429a() {
        this.f7166r.b(this.f7157i);
    }

    private RowType m7425b(int i) {
        int size = this.f7158j.size();
        int i2 = this.f7162n != State.DEFAULT ? 1 : 0;
        if (i == 0) {
            return RowType.CONTACTS_HEADER;
        }
        if (i <= size) {
            return RowType.CONTACT;
        }
        if (this.f7162n == State.LOADING_MORE && i == size + 1) {
            return RowType.LOADING;
        }
        if (this.f7162n == State.FAILURE && i == size + 1) {
            return RowType.FAILURE;
        }
        if (i == (size + 1) + i2) {
            return RowType.MANAGE_CONTACTS;
        }
        if (i == i2 + ((size + 1) + 1)) {
            return RowType.PYMK_HEADER;
        }
        return RowType.PYMK;
    }

    private int m7423a(RowType rowType) {
        int i = this.f7162n == State.LOADING_MORE ? 1 : 0;
        switch (rowType) {
            case CONTACTS_HEADER:
                return 0;
            case CONTACT:
                return 1;
            case LOADING:
            case FAILURE:
                return this.f7158j.size() + 1;
            case MANAGE_CONTACTS:
                return (this.f7158j.size() + 1) + i;
            case PYMK_HEADER:
                return (i + (this.f7158j.size() + 1)) + 1;
            case PYMK:
                return ((i + (this.f7158j.size() + 1)) + 1) + 1;
            default:
                throw new IllegalArgumentException("Unexpected type");
        }
    }

    public static View m7424a(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130904480, viewGroup, false);
    }

    private static FriendListItemView m7426d(ViewGroup viewGroup) {
        FriendListItemView friendListItemView = new FriendListItemView(viewGroup.getContext());
        friendListItemView.setThumbnailSize(ThumbnailSize.XLARGE);
        return friendListItemView;
    }

    public final void m7432a(List<FriendFinderFriendCandidate> list) {
        if (list != null && !list.isEmpty()) {
            for (FriendFinderFriendCandidate friendFinderFriendCandidate : list) {
                this.f7155g.put(Long.valueOf(friendFinderFriendCandidate.m7467a()), friendFinderFriendCandidate);
                this.f7156h.add(friendFinderFriendCandidate);
            }
            this.f7153e.addAll(list);
            AdapterDetour.a(this, 7156471);
        }
    }

    public final void m7434b(List<FriendFinderFriendCandidate> list) {
        if (list != null && !list.isEmpty()) {
            for (FriendFinderFriendCandidate friendFinderFriendCandidate : list) {
                this.f7155g.put(Long.valueOf(friendFinderFriendCandidate.m7467a()), friendFinderFriendCandidate);
            }
            this.f7154f.addAll(list);
            AdapterDetour.a(this, 2069784403);
        }
    }

    public final int m7427a(int i) {
        return (i < 0 || i > this.f7153e.size()) ? i - 2 : i;
    }

    public final void m7431a(State state) {
        if (state != this.f7162n) {
            this.f7162n = state;
            AdapterDetour.a(this, 1503976233);
        }
    }
}
