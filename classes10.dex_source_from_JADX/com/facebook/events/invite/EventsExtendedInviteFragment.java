package com.facebook.events.invite;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.events.invite.EventsExtendedInviteActivity.C24752;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.OnTabClickListener;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.ui.toaster.Toaster;
import com.facebook.ui.typeahead.BaseTypeaheadController.OnNewSuggestionsListener;
import com.facebook.ui.typeahead.FetchState;
import com.facebook.ui.typeahead.OnFetchStateChangedListener;
import com.facebook.ui.typeahead.TypeaheadResponse;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.BetterRecyclerView.OnItemClickListener;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: clock_skew_detected */
public class EventsExtendedInviteFragment extends FbFragment {
    public final Set<String> f17559a = new LinkedHashSet();
    @Inject
    private EventsExtendedInviteTypeaheadControllerProvider aA;
    @Inject
    private FbSharedPreferences aB;
    @Inject
    public InvitePickerPerformanceLogger aC;
    @Inject
    public InviteSessionLogger aD;
    @Inject
    @LoggedInUserId
    private Provider<String> aE;
    private Set<String> al;
    public String am;
    private final OnScrollListener an = new C24871(this);
    private final C24882 ao = new C24882(this);
    public int ap = Integer.MAX_VALUE;
    public ImmutableList<SimpleUserToken> aq = RegularImmutableList.a;
    public ImmutableList<SimpleUserToken> ar = RegularImmutableList.a;
    public BetterRecyclerView as;
    public TabbedViewPagerIndicator at;
    public TextView au;
    public View av;
    public ViewPager aw;
    @Inject
    private EventsExtendedInviteFriendsFetcherProvider ax;
    @Inject
    public EventsExtendedInviteFriendsSearchListAdapterProvider ay;
    @Inject
    private EventsExtendedInvitePagerAdapterProvider az;
    public boolean f17560b;
    public C24752 f17561c;
    public EventsExtendedInviteFriendsFetcher f17562d;
    public EventsExtendedInviteFriendsSearchListAdapter f17563e;
    public EventsExtendedInvitePagerAdapter f17564f;
    public EventsExtendedInviteTypeaheadController f17565g;
    private PrefKey f17566h;
    public OnScrollListener f17567i;

    /* compiled from: clock_skew_detected */
    class C24871 extends OnScrollListener {
        final /* synthetic */ EventsExtendedInviteFragment f17548a;

        C24871(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17548a = eventsExtendedInviteFragment;
        }

        public final void m17922a(RecyclerView recyclerView, int i, int i2) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int aZ_ = recyclerView.o.aZ_();
            int v = linearLayoutManager.v();
            int l = linearLayoutManager.l();
            if (v > 0 && aZ_ > 0 && (l + v) + 5 > aZ_) {
                this.f17548a.f17562d.m17959a();
            }
        }
    }

    /* compiled from: clock_skew_detected */
    public class C24882 {
        public final /* synthetic */ EventsExtendedInviteFragment f17549a;

        C24882(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17549a = eventsExtendedInviteFragment;
        }
    }

    /* compiled from: clock_skew_detected */
    class C24893 implements OnTabClickListener {
        final /* synthetic */ EventsExtendedInviteFragment f17550a;

        C24893(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17550a = eventsExtendedInviteFragment;
        }

        public final void m17923a(int i, int i2) {
            this.f17550a.aC.m18046d();
        }
    }

    /* compiled from: clock_skew_detected */
    public class C24904 {
        public final /* synthetic */ EventsExtendedInviteFragment f17551a;
        private ImmutableList<SimpleUserToken> f17552b;

        C24904(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17551a = eventsExtendedInviteFragment;
        }

        public final void m17928a(ImmutableMap<String, SimpleUserToken> immutableMap, ImmutableList<String> immutableList) {
            if (this.f17552b == null) {
                this.f17552b = ImmutableList.copyOf(immutableMap.values());
            }
            Builder builder = ImmutableList.builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                SimpleUserToken simpleUserToken = (SimpleUserToken) immutableMap.get((String) immutableList.get(i));
                if (simpleUserToken != null) {
                    builder.c(simpleUserToken);
                    EventsExtendedInviteFragment.m17933a(this.f17551a, simpleUserToken);
                }
            }
            m17925b(this.f17552b);
            this.f17551a.f17564f.m17996a(false, this.f17551a.ar, builder.b());
        }

        public final void m17929a(ImmutableMap<String, SimpleUserToken> immutableMap, ImmutableSet<String> immutableSet, ImmutableSet<String> immutableSet2, int i) {
            Builder builder = ImmutableList.builder();
            Iterator it = immutableMap.values().iterator();
            while (it.hasNext()) {
                SimpleUserToken simpleUserToken = (SimpleUserToken) it.next();
                String p = simpleUserToken.p();
                if (!immutableSet.contains(p)) {
                    boolean z;
                    if (immutableSet2.contains(p)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    simpleUserToken.i = z;
                    builder.c(simpleUserToken);
                }
            }
            m17924a(i);
            ImmutableList b = builder.b();
            if (this.f17552b == null) {
                this.f17552b = b;
                return;
            }
            m17925b(b);
            this.f17551a.f17564f.m17995a(this.f17551a.ar);
        }

        public final void m17926a() {
            this.f17551a.aC.m18044b();
            m17925b(this.f17551a.ar);
            this.f17551a.f17564f.m17996a(true, this.f17551a.ar, RegularImmutableList.a);
        }

        public final void m17927a(ImmutableList<SimpleUserToken> immutableList, int i, boolean z) {
            m17924a(i);
            int size = immutableList.size();
            for (int i2 = 0; i2 < size; i2++) {
                EventsExtendedInviteFragment.m17933a(this.f17551a, (SimpleUserToken) immutableList.get(i2));
            }
            Builder builder = new Builder();
            builder.b(this.f17551a.aq);
            builder.b(immutableList);
            this.f17551a.aq = builder.b();
            this.f17551a.f17564f.m17997a(false, this.f17551a.aq, z);
        }

        private void m17925b(ImmutableList<SimpleUserToken> immutableList) {
            this.f17551a.ar = immutableList;
            if (this.f17551a.f17565g != null) {
                this.f17551a.f17565g.m18012b(this.f17551a.ar);
            }
        }

        private void m17924a(int i) {
            if (this.f17551a.ap == Integer.MAX_VALUE) {
                this.f17551a.ap = i;
                if (this.f17551a.f17563e != null) {
                    this.f17551a.f17563e.f17614d = this.f17551a.ap;
                }
                EventsExtendedInvitePagerAdapter eventsExtendedInvitePagerAdapter = this.f17551a.f17564f;
                eventsExtendedInvitePagerAdapter.f17672m = this.f17551a.ap;
                for (EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder : eventsExtendedInvitePagerAdapter.f17666g) {
                    if (eventsExtendedInvitePageHolder != null) {
                        int i2 = eventsExtendedInvitePagerAdapter.f17672m;
                        int size = eventsExtendedInvitePageHolder.f17649p.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            ((EventsExtendedInviteFriendsListSectionAdapter) eventsExtendedInvitePageHolder.f17649p.get(i3)).f17606f = i2;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: clock_skew_detected */
    public class C24915 implements AnimatorUpdateListener {
        final /* synthetic */ View f17553a;
        final /* synthetic */ EventsExtendedInviteFragment f17554b;

        public C24915(EventsExtendedInviteFragment eventsExtendedInviteFragment, View view) {
            this.f17554b = eventsExtendedInviteFragment;
            this.f17553a = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f17553a.setPadding(this.f17553a.getPaddingLeft(), this.f17553a.getPaddingTop(), this.f17553a.getPaddingRight(), Integer.parseInt(valueAnimator.getAnimatedValue().toString()));
        }
    }

    /* compiled from: clock_skew_detected */
    class C24926 implements OnNewSuggestionsListener<SimpleUserToken> {
        final /* synthetic */ EventsExtendedInviteFragment f17555a;

        public final void m17930a(TypeaheadResponse<SimpleUserToken> typeaheadResponse) {
            if (!typeaheadResponse.a.b.isEmpty()) {
                Object obj;
                ImmutableList immutableList = typeaheadResponse.b.b;
                EventsExtendedInviteFragment eventsExtendedInviteFragment = this.f17555a;
                if (immutableList.isEmpty()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                int i = 0;
                eventsExtendedInviteFragment.as.setVisibility(obj != null ? 0 : 8);
                TextView textView = eventsExtendedInviteFragment.au;
                if (obj != null) {
                    i = 8;
                }
                textView.setVisibility(i);
                eventsExtendedInviteFragment.av.setVisibility(8);
                EventsExtendedInviteFriendsSearchListAdapter eventsExtendedInviteFriendsSearchListAdapter = this.f17555a.f17563e;
                eventsExtendedInviteFriendsSearchListAdapter.f17615e = immutableList;
                eventsExtendedInviteFriendsSearchListAdapter.notifyDataSetChanged();
            }
        }

        C24926(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17555a = eventsExtendedInviteFragment;
        }
    }

    /* compiled from: clock_skew_detected */
    class C24937 implements OnFetchStateChangedListener {
        final /* synthetic */ EventsExtendedInviteFragment f17556a;

        C24937(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17556a = eventsExtendedInviteFragment;
        }

        public final void m17931a(FetchState fetchState) {
            switch (C24959.f17558a[fetchState.ordinal()]) {
                case 1:
                    this.f17556a.f17563e.m17975b(true);
                    return;
                case 2:
                case 3:
                    this.f17556a.f17563e.m17975b(false);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: clock_skew_detected */
    public class C24948 implements OnItemClickListener {
        final /* synthetic */ EventsExtendedInviteFragment f17557a;

        public C24948(EventsExtendedInviteFragment eventsExtendedInviteFragment) {
            this.f17557a = eventsExtendedInviteFragment;
        }

        public final void m17932a(BetterRecyclerView betterRecyclerView, View view, int i, long j) {
            if (this.f17557a.f17563e.m17976f(i)) {
                this.f17557a.f17564f.m18002e();
            }
        }
    }

    /* compiled from: clock_skew_detected */
    /* synthetic */ class C24959 {
        static final /* synthetic */ int[] f17558a = new int[FetchState.values().length];

        static {
            try {
                f17558a[FetchState.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17558a[FetchState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17558a[FetchState.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m17935a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EventsExtendedInviteFragment) obj).m17934a((EventsExtendedInviteFriendsFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsExtendedInviteFriendsFetcherProvider.class), (EventsExtendedInviteFriendsSearchListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsExtendedInviteFriendsSearchListAdapterProvider.class), (EventsExtendedInvitePagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsExtendedInvitePagerAdapterProvider.class), (EventsExtendedInviteTypeaheadControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EventsExtendedInviteTypeaheadControllerProvider.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InvitePickerPerformanceLogger.m18041a(injectorLike), InviteSessionLogger.m18047a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    public final void m17942c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = EventsExtendedInviteFragment.class;
        m17935a((Object) this, getContext());
        this.am = this.s.getString("event_id");
        this.f17566h = GrowthPrefKeys.a((String) this.aE.get());
        if (bundle != null) {
            this.al = new HashSet(bundle.getStringArrayList("SELECTED_FRIENDS_TOKENS_IDS"));
        }
    }

    public final void m17943e(Bundle bundle) {
        super.e(bundle);
        bundle.putStringArrayList("SELECTED_FRIENDS_TOKENS_IDS", new ArrayList(this.f17559a));
    }

    public final View m17939a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -773559527);
        View inflate = layoutInflater.inflate(2130904156, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1594520656, a);
        return inflate;
    }

    public final void m17940a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f17564f = this.az.m18004a(this.f17559a, this.ao, this.f17561c, this.f17567i, this.an, s());
        this.aw = (ViewPager) e(2131561557);
        this.aw.setAdapter(this.f17564f);
        this.at = (TabbedViewPagerIndicator) e(2131561556);
        this.at.setViewPager(this.aw);
        if (this.f17564f.b() > 1) {
            this.at.setPadding(0, this.at.getPaddingTop(), 0, this.at.getPaddingBottom());
            this.at.j = true;
            this.at.m = new C24893(this);
        } else {
            this.at.setVisibility(8);
        }
        this.f17562d = this.ax.m17961a(this.am, new C24904(this));
        boolean z = this.aB.a(this.f17566h, false) && this.f17564f.m18003g();
        this.f17562d.m17960a(z, this.f17559a);
    }

    private void m17934a(EventsExtendedInviteFriendsFetcherProvider eventsExtendedInviteFriendsFetcherProvider, EventsExtendedInviteFriendsSearchListAdapterProvider eventsExtendedInviteFriendsSearchListAdapterProvider, EventsExtendedInvitePagerAdapterProvider eventsExtendedInvitePagerAdapterProvider, EventsExtendedInviteTypeaheadControllerProvider eventsExtendedInviteTypeaheadControllerProvider, FbSharedPreferences fbSharedPreferences, InvitePickerPerformanceLogger invitePickerPerformanceLogger, InviteSessionLogger inviteSessionLogger, Provider<String> provider) {
        this.ax = eventsExtendedInviteFriendsFetcherProvider;
        this.ay = eventsExtendedInviteFriendsSearchListAdapterProvider;
        this.az = eventsExtendedInvitePagerAdapterProvider;
        this.aA = eventsExtendedInviteTypeaheadControllerProvider;
        this.aB = fbSharedPreferences;
        this.aC = invitePickerPerformanceLogger;
        this.aD = inviteSessionLogger;
        this.aE = provider;
    }

    public static void m17933a(EventsExtendedInviteFragment eventsExtendedInviteFragment, SimpleUserToken simpleUserToken) {
        String p = simpleUserToken.p();
        if (eventsExtendedInviteFragment.al != null && eventsExtendedInviteFragment.al.contains(p)) {
            eventsExtendedInviteFragment.al.remove(p);
            eventsExtendedInviteFragment.f17559a.add(p);
            eventsExtendedInviteFragment.f17561c.m17869a(simpleUserToken, true, false);
        }
    }

    public final void m17937G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -804538332);
        super.G();
        if (this.aq.isEmpty() && this.f17564f.m18003g() && this.aB.a(this.f17566h, false)) {
            this.f17562d.m17959a();
        }
        for (EventsExtendedInvitePageHolder eventsExtendedInvitePageHolder : this.f17564f.f17666g) {
            if (eventsExtendedInvitePageHolder != null) {
                eventsExtendedInvitePageHolder.m17991c();
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1465409393, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -177606417);
        super.mY_();
        this.aC.m18046d();
        this.as = null;
        this.at = null;
        this.au = null;
        this.av = null;
        this.aw = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1559639197, a);
    }

    public final void m17938I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2093402785);
        super.I();
        if (this.f17562d != null) {
            EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher = this.f17562d;
            eventsExtendedInviteFriendsFetcher.f17600x.c();
            EventsExtendedInviteFriendsFetcher.m17957j(eventsExtendedInviteFriendsFetcher);
            EventsExtendedInviteFriendsFetcher.m17958k(eventsExtendedInviteFriendsFetcher);
            if (eventsExtendedInviteFriendsFetcher.f17578b != null) {
                eventsExtendedInviteFriendsFetcher.f17578b.jc_();
            }
            if (eventsExtendedInviteFriendsFetcher.f17579c != null) {
                eventsExtendedInviteFriendsFetcher.f17579c.cancel(true);
            }
        }
        if (this.f17565g != null) {
            this.f17565g.a(RegularImmutableBiMap.a);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1779497487, a);
    }

    public final void m17941a(CharSequence charSequence) {
        if (!StringUtil.a(charSequence)) {
            if (!this.f17560b) {
                this.f17560b = true;
                this.aD.m18052a(InviteSubSessionTypes.INVITE_SEARCH);
            }
            if (this.as == null) {
                this.as = (BetterRecyclerView) ((ViewStub) e(2131561553)).inflate();
                this.au = (TextView) ((ViewStub) e(2131561554)).inflate();
                this.av = ((ViewStub) e(2131561555)).inflate();
                InjectorLike injectorLike = this.ay;
                this.f17563e = new EventsExtendedInviteFriendsSearchListAdapter(InviteSessionLogger.m18047a(injectorLike), Toaster.b(injectorLike), this.f17559a, this.f17561c);
                this.f17563e.f17614d = this.ap;
                BetterRecyclerView betterRecyclerView = this.as;
                getContext();
                betterRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
                this.as.setAdapter(this.f17563e);
                this.as.setOnItemClickListener(new C24948(this));
                if (this.f17567i != null) {
                    this.as.setOnScrollListener(this.f17567i);
                }
                this.f17565g = this.aA.m18013a(this.am);
                this.f17565g.n = new C24926(this);
                this.f17565g.a(new C24937(this));
                this.f17565g.m18012b(this.ar);
            }
            m17936b(false);
            this.f17565g.b(GraphSearchQuery.a(charSequence.toString()));
        } else if (this.as != null) {
            this.f17565g.b(GraphSearchQuery.a(""));
            if (this.f17560b) {
                this.aD.m18055b(InviteSubSessionTypes.INVITE_SEARCH);
                this.f17560b = false;
            }
            this.as.setVisibility(8);
            this.au.setVisibility(8);
            this.av.setVisibility(8);
            m17936b(true);
        }
    }

    private void m17936b(boolean z) {
        int i = z ? 0 : 8;
        this.aw.setVisibility(i);
        if (this.f17564f != null && this.f17564f.b() > 1) {
            this.at.setVisibility(i);
        }
    }
}
