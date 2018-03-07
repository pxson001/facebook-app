package com.facebook.events.invite;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.events.invite.EventsExtendedInviteActivity.C24752;
import com.facebook.events.invite.EventsExtendedInviteFragment.AddContactsButtonClickListener;
import com.facebook.events.invite.EventsExtendedInviteFragment.C24882;
import com.facebook.events.invite.EventsExtendedInvitePageHolder.C25095;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: clearLocalStorage */
public class EventsExtendedInvitePagerAdapter extends PagerAdapter {
    private final ImmutableList<EventsExtendedInviteContactType> f17660a;
    private final Set<String> f17661b;
    private final boolean f17662c;
    private int f17663d = -1;
    private C24882 f17664e;
    private C24752 f17665f;
    public EventsExtendedInvitePageHolder[] f17666g;
    private OnScrollListener f17667h;
    private OnScrollListener f17668i;
    private FragmentManager f17669j;
    private boolean f17670k;
    private boolean f17671l;
    public int f17672m = Integer.MAX_VALUE;
    private ImmutableList<SimpleUserToken> f17673n;
    private ImmutableList<SimpleUserToken> f17674o;
    private ImmutableList<SimpleUserToken> f17675p;
    private Context f17676q;
    private EventsExtendedInvitePageHolderProvider f17677r;

    @Inject
    public EventsExtendedInvitePagerAdapter(Context context, EventsExtendedInvitePageHolderProvider eventsExtendedInvitePageHolderProvider, FbSharedPreferences fbSharedPreferences, Provider<String> provider, QeAccessor qeAccessor, @Assisted Set<String> set, @Assisted AddContactsButtonClickListener addContactsButtonClickListener, @Assisted EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener, @Assisted OnScrollListener onScrollListener, @Assisted OnScrollListener onScrollListener2, @Assisted FragmentManager fragmentManager) {
        this.f17676q = context;
        this.f17677r = eventsExtendedInvitePageHolderProvider;
        boolean a = fbSharedPreferences.a(GrowthPrefKeys.a((String) provider.get()), false);
        this.f17662c = qeAccessor.a(ExperimentsForEventsGatingModule.F, false);
        if (a || this.f17662c) {
            this.f17660a = ImmutableList.of(EventsExtendedInviteContactType.FACEBOOK, EventsExtendedInviteContactType.CONTACTS);
        } else {
            this.f17660a = ImmutableList.of(EventsExtendedInviteContactType.FACEBOOK);
        }
        this.f17661b = set;
        this.f17664e = addContactsButtonClickListener;
        this.f17665f = eventsExtendedInviteFriendSelectionChangedListener;
        this.f17667h = onScrollListener;
        this.f17668i = onScrollListener2;
        this.f17669j = fragmentManager;
        this.f17666g = new EventsExtendedInvitePageHolder[b()];
    }

    public final int m17999b() {
        return this.f17660a.size();
    }

    public final CharSequence J_(int i) {
        return this.f17676q.getResources().getString(((EventsExtendedInviteContactType) this.f17660a.get(i)).resourceId);
    }

    public final Object m17993a(ViewGroup viewGroup, int i) {
        if (this.f17666g[i] == null) {
            this.f17666g[i] = this.f17677r.m17992a(viewGroup, (EventsExtendedInviteContactType) this.f17660a.get(i), this.f17661b, this.f17672m, this.f17671l, this.f17674o, this.f17675p, this.f17670k, this.f17673n, this.f17662c, this.f17664e, this.f17665f, this.f17667h, this.f17668i, this.f17669j);
        }
        return this.f17666g[i];
    }

    public final boolean m17998a(View view, Object obj) {
        return ((EventsExtendedInvitePageHolder) obj).f17657x == view;
    }

    public final void m18000b(ViewGroup viewGroup, int i, Object obj) {
        if (this.f17663d != i) {
            this.f17663d = i;
            EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder = (EventsExtendedInvitePageHolder) obj;
            switch (C25095.f17628a[eventsExtendedInvitePageHolder.f17641h.ordinal()]) {
                case 1:
                    eventsExtendedInvitePageHolder.f17630B.m18052a(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
                    eventsExtendedInvitePageHolder.f17630B.m18052a(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
                    eventsExtendedInvitePageHolder.f17630B.m18057c(InviteSubSessionTypes.CONTACTS);
                    break;
                case 2:
                    eventsExtendedInvitePageHolder.f17630B.m18057c(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
                    eventsExtendedInvitePageHolder.f17630B.m18057c(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
                    eventsExtendedInvitePageHolder.f17630B.m18052a(InviteSubSessionTypes.CONTACTS);
                    break;
            }
        }
        EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder2 = (EventsExtendedInvitePageHolder) obj;
        if (!eventsExtendedInvitePageHolder2.f17637d) {
            viewGroup.addView(eventsExtendedInvitePageHolder2.f17657x);
            eventsExtendedInvitePageHolder2.f17637d = true;
        }
        eventsExtendedInvitePageHolder2.m17991c();
    }

    public final void m17994a(ViewGroup viewGroup, int i, Object obj) {
        EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder = (EventsExtendedInvitePageHolder) obj;
        if (eventsExtendedInvitePageHolder.f17637d) {
            viewGroup.removeView(eventsExtendedInvitePageHolder.f17657x);
            eventsExtendedInvitePageHolder.f17637d = false;
        }
    }

    public final int m18001d() {
        return this.f17660a.indexOf(EventsExtendedInviteContactType.CONTACTS);
    }

    public final void m17995a(ImmutableList<SimpleUserToken> immutableList) {
        int i = 0;
        this.f17671l = false;
        this.f17674o = immutableList;
        EventsExtendedInvitePageHolder[] eventsExtendedInvitePageHolderArr = this.f17666g;
        int length = eventsExtendedInvitePageHolderArr.length;
        while (i < length) {
            EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder = eventsExtendedInvitePageHolderArr[i];
            if (eventsExtendedInvitePageHolder != null) {
                ImmutableList immutableList2 = this.f17674o;
                if (eventsExtendedInvitePageHolder.f17641h == EventsExtendedInviteContactType.FACEBOOK) {
                    eventsExtendedInvitePageHolder.f17651r = immutableList2;
                    eventsExtendedInvitePageHolder.f17645l.m17967a(immutableList2);
                }
            }
            i++;
        }
    }

    public final void m17996a(boolean z, ImmutableList<SimpleUserToken> immutableList, ImmutableList<SimpleUserToken> immutableList2) {
        this.f17671l = z;
        this.f17674o = immutableList;
        this.f17675p = immutableList2;
        for (EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder : this.f17666g) {
            if (eventsExtendedInvitePageHolder != null) {
                eventsExtendedInvitePageHolder.m17989a(this.f17671l, this.f17674o, this.f17675p);
            }
        }
    }

    public final void m17997a(boolean z, ImmutableList<SimpleUserToken> immutableList, boolean z2) {
        this.f17670k = z;
        this.f17673n = immutableList;
        for (EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder : this.f17666g) {
            if (eventsExtendedInvitePageHolder != null) {
                eventsExtendedInvitePageHolder.m17990a(this.f17670k, (ImmutableList) immutableList, z2);
            }
        }
    }

    public final void m18002e() {
        for (EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder : this.f17666g) {
            if (eventsExtendedInvitePageHolder != null) {
                int size = eventsExtendedInvitePageHolder.f17649p.size();
                for (int i = 0; i < size; i++) {
                    ((EventsExtendedInviteFriendsListSectionAdapter) eventsExtendedInvitePageHolder.f17649p.get(i)).notifyDataSetChanged();
                }
            }
        }
    }

    public final boolean m18003g() {
        return this.f17660a.contains(EventsExtendedInviteContactType.CONTACTS);
    }
}
