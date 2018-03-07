package com.facebook.events.invite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.events.invite.EventsExtendedInviteActivity.C24752;
import com.facebook.events.invite.EventsExtendedInviteFragment.AddContactsButtonClickListener;
import com.facebook.events.invite.EventsExtendedInviteFragment.C24882;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.events.prefs.EventsPrefKeys;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import com.facebook.widget.recyclerview.StickyHeaderItemDecorator;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: clickY */
public class EventsExtendedInvitePageHolder {
    public InvitePickerPerformanceLogger f17629A;
    public InviteSessionLogger f17630B;
    private FbSharedPreferences f17631C;
    public FragmentFactoryMap f17632D;
    public TipSeenTracker f17633E;
    private final PrefKey f17634a;
    private final Set<String> f17635b;
    public boolean f17636c;
    public boolean f17637d;
    public boolean f17638e;
    private boolean f17639f;
    public Context f17640g;
    public EventsExtendedInviteContactType f17641h;
    public C24882 f17642i;
    public EventsExtendedInviteFriendsListAdapter f17643j;
    private EventsExtendedInviteFriendsListSectionAdapter f17644k;
    public EventsExtendedInviteFriendsListSectionAdapter f17645l;
    private EventsExtendedInviteFriendsListSectionAdapter f17646m;
    private C24752 f17647n;
    public FragmentManager f17648o;
    public ImmutableList<EventsExtendedInviteFriendsListSectionAdapter> f17649p;
    private ImmutableList<SimpleUserToken> f17650q;
    public ImmutableList<SimpleUserToken> f17651r;
    private ImmutableList<SimpleUserToken> f17652s;
    private OnScrollListener f17653t;
    public BetterRecyclerView f17654u;
    public TextView f17655v;
    public View f17656w;
    public ViewGroup f17657x;
    private EventsExtendedInviteFriendsListSectionAdapterProvider f17658y;
    public InterstitialManager f17659z;

    /* compiled from: clickY */
    class C25051 implements OnItemClickListener {
        final /* synthetic */ EventsExtendedInvitePageHolder f17624a;

        C25051(EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder) {
            this.f17624a = eventsExtendedInvitePageHolder;
        }

        public final void m17982a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            this.f17624a.f17643j.m17964f(i);
        }
    }

    /* compiled from: clickY */
    class C25062 implements OnDrawListener {
        final /* synthetic */ EventsExtendedInvitePageHolder f17625a;

        C25062(EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder) {
            this.f17625a = eventsExtendedInvitePageHolder;
        }

        public final boolean gD_() {
            if (EventsExtendedInvitePageHolder.m17987d(this.f17625a)) {
                return false;
            }
            this.f17625a.f17629A.m18045c();
            return true;
        }
    }

    /* compiled from: clickY */
    public class C25073 implements OnClickListener {
        final /* synthetic */ EventsExtendedInvitePageHolder f17626a;

        public C25073(EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder) {
            this.f17626a = eventsExtendedInvitePageHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1438804194);
            C24882 c24882 = this.f17626a.f17642i;
            if (!(c24882.f17549a.at == null || c24882.f17549a.aw == null || c24882.f17549a.f17564f == null || c24882.f17549a.f17564f.m18001d() < 0)) {
                c24882.f17549a.at.e_(c24882.f17549a.f17564f.m18001d());
                c24882.f17549a.aw.setCurrentItem(c24882.f17549a.f17564f.m18001d());
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1823853383, a);
        }
    }

    /* compiled from: clickY */
    public class C25084 implements OnAttachStateChangeListener {
        final /* synthetic */ EventsExtendedInvitePageHolder f17627a;

        public C25084(EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder) {
            this.f17627a = eventsExtendedInvitePageHolder;
        }

        public void onViewAttachedToWindow(View view) {
            this.f17627a.f17633E.b = 2;
            this.f17627a.f17633E.a(EventsPrefKeys.f19012f);
            if (this.f17627a.f17633E.c()) {
                Object obj;
                EventsExtendedInviteAddContactsButtonInterstitialController eventsExtendedInviteAddContactsButtonInterstitialController = (EventsExtendedInviteAddContactsButtonInterstitialController) this.f17627a.f17659z.a(EventsExtendedInviteAddContactsButtonInterstitialController.f17534a, EventsExtendedInviteAddContactsButtonInterstitialController.class);
                if (eventsExtendedInviteAddContactsButtonInterstitialController == null || !Objects.equal(eventsExtendedInviteAddContactsButtonInterstitialController.m17907b(), "4157")) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null && !this.f17627a.f17636c) {
                    Tooltip tooltip = new Tooltip(this.f17627a.f17640g, 2);
                    tooltip.b(2131236973);
                    tooltip.a(Position.ABOVE);
                    tooltip.t = -1;
                    tooltip.f(view.findViewById(2131561565));
                    this.f17627a.f17636c = true;
                    this.f17627a.f17633E.a();
                    this.f17627a.f17659z.a().a("4157");
                }
            }
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: clickY */
    public /* synthetic */ class C25095 {
        public static final /* synthetic */ int[] f17628a = new int[EventsExtendedInviteContactType.values().length];

        static {
            try {
                f17628a[EventsExtendedInviteContactType.FACEBOOK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17628a[EventsExtendedInviteContactType.CONTACTS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public EventsExtendedInvitePageHolder(EventsExtendedInviteFriendsListSectionAdapterProvider eventsExtendedInviteFriendsListSectionAdapterProvider, InvitePickerPerformanceLogger invitePickerPerformanceLogger, InviteSessionLogger inviteSessionLogger, InterstitialManager interstitialManager, FbSharedPreferences fbSharedPreferences, FragmentFactoryMap fragmentFactoryMap, Provider<String> provider, TipSeenTracker tipSeenTracker, @Assisted ViewGroup viewGroup, @Assisted EventsExtendedInviteContactType eventsExtendedInviteContactType, @Assisted Set<String> set, @Assisted int i, @Assisted boolean z, @Assisted ImmutableList<SimpleUserToken> immutableList, @Assisted ImmutableList<SimpleUserToken> immutableList2, @Assisted boolean z2, @Assisted ImmutableList<SimpleUserToken> immutableList3, @Assisted boolean z3, @Assisted AddContactsButtonClickListener addContactsButtonClickListener, @Assisted EventsExtendedInviteFriendSelectionChangedListener eventsExtendedInviteFriendSelectionChangedListener, @Assisted OnScrollListener onScrollListener, @Assisted OnScrollListener onScrollListener2, @Assisted FragmentManager fragmentManager) {
        this.f17658y = eventsExtendedInviteFriendsListSectionAdapterProvider;
        this.f17629A = invitePickerPerformanceLogger;
        this.f17630B = inviteSessionLogger;
        this.f17659z = interstitialManager;
        this.f17631C = fbSharedPreferences;
        this.f17632D = fragmentFactoryMap;
        this.f17633E = tipSeenTracker;
        this.f17634a = GrowthPrefKeys.a((String) provider.get());
        this.f17640g = viewGroup.getContext();
        this.f17641h = eventsExtendedInviteContactType;
        this.f17635b = set;
        this.f17651r = immutableList;
        this.f17652s = immutableList2;
        this.f17650q = immutableList3;
        this.f17639f = z3;
        this.f17642i = addContactsButtonClickListener;
        this.f17647n = eventsExtendedInviteFriendSelectionChangedListener;
        this.f17653t = onScrollListener2;
        this.f17648o = fragmentManager;
        m17983a(viewGroup, i, z, z2, onScrollListener);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m17983a(ViewGroup viewGroup, int i, boolean z, boolean z2, OnScrollListener onScrollListener) {
        this.f17657x = (ViewGroup) LayoutInflater.from(this.f17640g).inflate(2130904161, viewGroup, false);
        m17991c();
        this.f17654u = (BetterRecyclerView) this.f17657x.findViewById(2131561558);
        this.f17654u.setLayoutManager(new BetterLinearLayoutManager(this.f17640g, 1, false));
        this.f17643j = m17985b(i);
        this.f17654u.setAdapter(this.f17643j);
        this.f17654u.setOnItemClickListener(new C25051(this));
        if (onScrollListener != null) {
            this.f17654u.setOnScrollListener(onScrollListener);
        }
        this.f17654u.a(new StickyHeaderItemDecorator(this.f17643j, false));
        if (this.f17641h == EventsExtendedInviteContactType.FACEBOOK) {
            this.f17654u.a(new C25062(this));
        }
        if (this.f17641h == EventsExtendedInviteContactType.CONTACTS) {
            this.f17654u.a(this.f17653t);
        }
        this.f17655v = (TextView) this.f17657x.findViewById(2131561552);
        if ((this.f17641h == EventsExtendedInviteContactType.FACEBOOK && z) || (this.f17641h == EventsExtendedInviteContactType.CONTACTS && z2)) {
            this.f17655v.setText(2131230758);
        }
        this.f17656w = this.f17657x.findViewById(2131561560);
        if (m17987d(this)) {
            this.f17654u.setVisibility(8);
            this.f17655v.setVisibility(8);
            this.f17656w.setVisibility(0);
            return;
        }
        m17986b(!m17988e());
    }

    public static boolean m17987d(EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder) {
        switch (C25095.f17628a[eventsExtendedInvitePageHolder.f17641h.ordinal()]) {
            case 1:
                if (eventsExtendedInvitePageHolder.f17651r != null) {
                    return false;
                }
                return true;
            case 2:
                if (eventsExtendedInvitePageHolder.f17650q != null) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    private boolean m17988e() {
        switch (C25095.f17628a[this.f17641h.ordinal()]) {
            case 1:
                if (this.f17651r == null || this.f17651r.isEmpty()) {
                    return true;
                }
                return false;
            case 2:
                if (this.f17650q == null || this.f17650q.isEmpty()) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    private EventsExtendedInviteFriendsListAdapter m17985b(int i) {
        EventsExtendedInviteFriendsListSectionAdapterProvider eventsExtendedInviteFriendsListSectionAdapterProvider;
        ImmutableList immutableList;
        switch (C25095.f17628a[this.f17641h.ordinal()]) {
            case 1:
                eventsExtendedInviteFriendsListSectionAdapterProvider = this.f17658y;
                String string = this.f17640g.getResources().getString(2131237174);
                if (this.f17652s == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    immutableList = this.f17652s;
                }
                this.f17646m = eventsExtendedInviteFriendsListSectionAdapterProvider.m17970a(string, false, i, immutableList, this.f17635b, this.f17647n, InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
                eventsExtendedInviteFriendsListSectionAdapterProvider = this.f17658y;
                if (this.f17651r == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    immutableList = this.f17651r;
                }
                this.f17645l = eventsExtendedInviteFriendsListSectionAdapterProvider.m17970a(null, true, i, immutableList, this.f17635b, this.f17647n, InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
                this.f17649p = ImmutableList.of(this.f17646m, this.f17645l);
                break;
            case 2:
                eventsExtendedInviteFriendsListSectionAdapterProvider = this.f17658y;
                if (this.f17650q == null) {
                    immutableList = RegularImmutableList.a;
                } else {
                    immutableList = this.f17650q;
                }
                this.f17644k = eventsExtendedInviteFriendsListSectionAdapterProvider.m17970a(null, true, i, immutableList, this.f17635b, this.f17647n, InviteSubSessionTypes.CONTACTS);
                this.f17649p = ImmutableList.of(this.f17644k);
                break;
            default:
                this.f17649p = RegularImmutableList.a;
                break;
        }
        return new EventsExtendedInviteFriendsListAdapter(this.f17649p);
    }

    public final void m17989a(boolean z, ImmutableList<SimpleUserToken> immutableList, ImmutableList<SimpleUserToken> immutableList2) {
        if (this.f17641h == EventsExtendedInviteContactType.FACEBOOK) {
            this.f17651r = immutableList;
            this.f17652s = immutableList2;
            m17984a(z);
            this.f17646m.m17967a(immutableList2);
            this.f17645l.m17967a(immutableList);
        }
    }

    public final void m17990a(boolean z, ImmutableList<SimpleUserToken> immutableList, boolean z2) {
        if (this.f17641h == EventsExtendedInviteContactType.CONTACTS) {
            this.f17650q = immutableList;
            m17984a(z);
            this.f17644k.m17968b(z2);
            this.f17644k.m17967a(immutableList);
        }
    }

    private void m17984a(boolean z) {
        if (z) {
            this.f17655v.setText(2131230758);
        } else {
            this.f17655v.setText(2131232654);
        }
        if (!m17987d(this)) {
            m17986b(!m17988e());
        }
    }

    private void m17986b(boolean z) {
        int i;
        int i2 = 0;
        BetterRecyclerView betterRecyclerView = this.f17654u;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        betterRecyclerView.setVisibility(i);
        TextView textView = this.f17655v;
        if (z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        this.f17656w.setVisibility(8);
    }

    public final void m17991c() {
        boolean z = false;
        if (this.f17639f) {
            if (!this.f17631C.a(this.f17634a, false)) {
                z = true;
            }
            switch (C25095.f17628a[this.f17641h.ordinal()]) {
                case 2:
                    View findViewById = this.f17657x.findViewById(2131558637);
                    if (findViewById == null) {
                        findViewById = this.f17657x.findViewById(2131561566);
                        findViewById.setId(2131558637);
                    }
                    if (z) {
                        this.f17657x.findViewById(2131561567).setVisibility(8);
                        findViewById.setVisibility(0);
                        if (this.f17637d && !this.f17638e) {
                            this.f17648o.a().a(2131558637, this.f17632D.a(ContentFragmentType.FRIEND_FINDER_INTRO_FRAGMENT.ordinal()).a(new Intent()), "EVENTS_CONTACTS_FINDER_FRAGMENT_TAG").b();
                            this.f17638e = true;
                        }
                    } else {
                        this.f17657x.findViewById(2131561567).setVisibility(0);
                        findViewById.setVisibility(8);
                    }
                    return;
                default:
                    if (z) {
                        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) this.f17657x.findViewById(2131561564);
                        if (imageBlockLayout.getVisibility() != 0) {
                            imageBlockLayout.setVisibility(0);
                            Resources resources = this.f17640g.getResources();
                            imageBlockLayout.setContentDescription(resources.getString(2131236974) + System.getProperty("line.separator") + resources.getString(2131236975));
                            imageBlockLayout.setOnClickListener(new C25073(this));
                            imageBlockLayout.addOnAttachStateChangeListener(new C25084(this));
                        }
                    } else {
                        this.f17657x.findViewById(2131561564).setVisibility(8);
                    }
                    return;
            }
        }
    }
}
