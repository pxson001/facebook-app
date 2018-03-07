package com.facebook.redspace.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.adapter.RedSpaceOverflowFriendsAdapter;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.Params;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.RedSpaceFriendsFetchListener;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelperProvider;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.data.RedSpaceMutationsExecutor;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.data.RedSpaceOverflowSubscriptionHelper;
import com.facebook.redspace.data.RedSpaceOverflowSubscriptionHelperProvider;
import com.facebook.redspace.debug.RedSpaceFriendsDebugWriter;
import com.facebook.redspace.debug.RedSpaceFriendsDebugWriter.FriendSectionDeterminator;
import com.facebook.redspace.event.OverflowCountChangedEvent;
import com.facebook.redspace.event.RedSpaceEventBus;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener.OnScrolledToBottomListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorAdapter;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.DelegatingAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Provider;

@UriMatchPatterns(fragment = ContentFragmentType.REDSPACE_FRIENDS_OVERFLOW_FRAGMENT)
/* compiled from: Payload Too Large */
public class RedSpaceOverflowFriendsFragment extends FbFragment implements FragmentWithDebugInfo, RedSpaceFriendsFetchListener {
    private static final String f11967c = RedSpaceOverflowFriendsFragment.class.getSimpleName();
    @Inject
    volatile Provider<RedSpaceTabUnseenCountFetcher> f11968a = UltralightRuntime.a;
    private RedSpaceOverflowSubscriptionHelper al;
    public RedSpaceFriendsFetcherHelper am;
    private LoadingIndicatorAdapter an;
    private RedSpaceLoadingScrollListener ao;
    private BetterRecyclerView ap;
    private MultiAdapterListAdapter aq;
    public FbTextView ar;
    private boolean as;
    private final SimpleFriendChangedSubscriber at = new C14271(this);
    @Inject
    volatile Provider<RedSpaceOptimisticBadgeStore> f11969b = UltralightRuntime.a;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsDebugWriter> f11970d = UltralightRuntime.b;
    @Inject
    private RedSpaceOverflowSubscriptionHelperProvider f11971e;
    @Inject
    private RedSpaceEventBus f11972f;
    @Inject
    private RedSpaceFriendsFetcherHelperProvider f11973g;
    @Inject
    public RedSpaceFriendsCollection f11974h;
    @Inject
    public RedSpaceStrings f11975i;

    /* compiled from: Payload Too Large */
    class C14271 extends SimpleFriendChangedSubscriber {
        final /* synthetic */ RedSpaceOverflowFriendsFragment f11963a;

        C14271(RedSpaceOverflowFriendsFragment redSpaceOverflowFriendsFragment) {
            this.f11963a = redSpaceOverflowFriendsFragment;
        }

        public final void mo337b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
            if (this.f11963a.o() != null && this.f11963a.f11974h.m12222d() == 0) {
                this.f11963a.o().finish();
            }
        }
    }

    /* compiled from: Payload Too Large */
    class C14282 implements OnScrolledToBottomListener {
        final /* synthetic */ RedSpaceOverflowFriendsFragment f11964a;

        C14282(RedSpaceOverflowFriendsFragment redSpaceOverflowFriendsFragment) {
            this.f11964a = redSpaceOverflowFriendsFragment;
        }

        public final void mo340a() {
            if (!this.f11964a.am.f11801l) {
                this.f11964a.am.m12231a();
            }
        }
    }

    /* compiled from: Payload Too Large */
    class C14293 implements RetryClickedListener {
        final /* synthetic */ RedSpaceOverflowFriendsFragment f11965a;

        C14293(RedSpaceOverflowFriendsFragment redSpaceOverflowFriendsFragment) {
            this.f11965a = redSpaceOverflowFriendsFragment;
        }

        public final void m12415a() {
            this.f11965a.am.m12231a();
        }
    }

    /* compiled from: Payload Too Large */
    class C14304 implements FriendSectionDeterminator {
        final /* synthetic */ RedSpaceOverflowFriendsFragment f11966a;

        C14304(RedSpaceOverflowFriendsFragment redSpaceOverflowFriendsFragment) {
            this.f11966a = redSpaceOverflowFriendsFragment;
        }

        public final RedSpaceFriendsSection mo339a(int i) {
            return RedSpaceOverflowFriendsFragment.m12419b(this.f11966a);
        }
    }

    public static void m12417a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RedSpaceOverflowFriendsFragment) obj).m12418a(IdBasedSingletonScopeProvider.a(injectorLike, 10165), IdBasedSingletonScopeProvider.a(injectorLike, 3265), IdBasedLazy.a(injectorLike, 10180), (RedSpaceOverflowSubscriptionHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceOverflowSubscriptionHelperProvider.class), RedSpaceEventBus.m12371a(injectorLike), (RedSpaceFriendsFetcherHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceFriendsFetcherHelperProvider.class), RedSpaceFriendsCollection.m12212a(injectorLike), RedSpaceStrings.a(injectorLike));
    }

    private void m12418a(Provider<RedSpaceTabUnseenCountFetcher> provider, Provider<RedSpaceOptimisticBadgeStore> provider2, com.facebook.inject.Lazy<RedSpaceFriendsDebugWriter> lazy, RedSpaceOverflowSubscriptionHelperProvider redSpaceOverflowSubscriptionHelperProvider, RedSpaceEventBus redSpaceEventBus, RedSpaceFriendsFetcherHelperProvider redSpaceFriendsFetcherHelperProvider, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceStrings redSpaceStrings) {
        this.f11968a = provider;
        this.f11969b = provider2;
        this.f11970d = lazy;
        this.f11971e = redSpaceOverflowSubscriptionHelperProvider;
        this.f11972f = redSpaceEventBus;
        this.f11973g = redSpaceFriendsFetcherHelperProvider;
        this.f11974h = redSpaceFriendsCollection;
        this.f11975i = redSpaceStrings;
    }

    public final void m12426c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = RedSpaceOverflowFriendsFragment.class;
        m12417a((Object) this, getContext());
        RedSpaceFriendsFetcherHelperProvider redSpaceFriendsFetcherHelperProvider = this.f11973g;
        ImmutableList of = ImmutableList.of(new Pair(m12419b(this), this.f11974h));
        Params params = new Params();
        params.f11789a = false;
        this.am = redSpaceFriendsFetcherHelperProvider.m12235a(this, of, params);
        RedSpaceOverflowFriendsAdapter redSpaceOverflowFriendsAdapter = new RedSpaceOverflowFriendsAdapter(this.f11974h, m12419b(this));
        this.an = new LoadingIndicatorAdapter();
        this.aq = MultiAdapterListAdapter.b(new FbListAdapter[]{redSpaceOverflowFriendsAdapter, this.an});
        InjectorLike injectorLike = this.f11971e;
        RedSpaceOverflowSubscriptionHelper redSpaceOverflowSubscriptionHelper = new RedSpaceOverflowSubscriptionHelper(RedSpaceMutationsExecutor.m12282a(injectorLike), this.f11974h, this.aq, m12419b(this));
        redSpaceOverflowSubscriptionHelper.f11849a = RedSpaceEventBus.m12371a(injectorLike);
        this.al = redSpaceOverflowSubscriptionHelper;
    }

    public final View m12423a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1559972441);
        View inflate = layoutInflater.inflate(2130906781, viewGroup, false);
        this.ap = (BetterRecyclerView) inflate.findViewById(2131559427);
        this.ar = (FbTextView) inflate.findViewById(2131566882);
        this.ao = new RedSpaceLoadingScrollListener(3, new C14282(this));
        this.ap.setLayoutManager(new BetterLinearLayoutManager(getContext()));
        this.ap.setAdapter(new DelegatingAdapter(this.aq, this.ap));
        this.ap.setOnScrollListener(this.ao);
        this.am.m12231a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1904952892, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2066331134);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.a_(this.f11975i.e());
            hasTitleBar.c(true);
            hasTitleBar.a(null);
        }
        this.ar.setText(this.f11975i.f());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -554600180, a);
    }

    public final void m12422I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1781988374);
        SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = this.al;
        simpleFriendChangedSubscriber.f11850b.m12289b(simpleFriendChangedSubscriber);
        this.am.m12233d();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1570604939, a);
    }

    public final void m12420G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2146921339);
        super.G();
        this.al.f11854f = this.at;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -410531531, a);
    }

    public final void m12421H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2093261169);
        super.H();
        this.al.f11854f = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1042609048, a);
    }

    public final void mo343a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        this.an.a();
    }

    public final void mo344a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        this.an.b();
        AdapterDetour.a(this.aq, 1064009492);
        if (!redSpaceFriendsCollection.m12218a()) {
            this.f11972f.a(new OverflowCountChangedEvent(m12419b(this), this.f11974h.m12222d()));
        }
        if (!this.as) {
            this.al.m12309b();
            this.as = true;
        }
        if (this.ao.m12766a(this.ap)) {
            this.am.m12231a();
        }
    }

    public final void a_(Throwable th) {
        if (o() != null) {
            this.an.a(b(2131230758), new C14293(this));
        }
    }

    public Map<String, String> getDebugInfo() {
        if (this.ap == null || this.ap.getLayoutManager() == null) {
            return null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.ap.getLayoutManager();
        return ((RedSpaceFriendsDebugWriter) this.f11970d.get()).m12365a(linearLayoutManager.l(), linearLayoutManager.n(), this.aq, m12419b(this).isTop() ? this.f11974h : null, m12419b(this).isTop() ? null : this.f11974h, new C14304(this), (RedSpaceOptimisticBadgeStore) this.f11969b.get(), (RedSpaceTabUnseenCountFetcher) this.f11968a.get());
    }

    public static RedSpaceFriendsSection m12419b(RedSpaceOverflowFriendsFragment redSpaceOverflowFriendsFragment) {
        return RedSpaceFriendsSection.deserialize(redSpaceOverflowFriendsFragment.s.getInt("bundle_section", 0));
    }
}
