package com.facebook.redspace.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.adapter.RedSpaceSearchFriendsAdapter;
import com.facebook.redspace.data.RedSpaceFriendsSearchCollection;
import com.facebook.redspace.data.RedSpaceMutationsExecutor;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.data.RedSpaceSearchFriendsFetcherHelper;
import com.facebook.redspace.data.RedSpaceSearchFriendsFetcherHelperProvider;
import com.facebook.redspace.data.RedSpaceSearchSubscriptionHelper;
import com.facebook.redspace.data.RedSpaceSearchSubscriptionHelperProvider;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.facebook.redspace.ui.RedSpaceFriendOptionsHelper;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener.OnScrolledToBottomListener;
import com.facebook.redspace.ui.RedSpaceSearchBarView;
import com.facebook.redspace.ui.RedSpaceSearchBarView.OnSearchTextChangedListener;
import com.facebook.redspace.ui.RedSpaceSearchFriendsItemView;
import com.facebook.redspace.ui.animation.RedSpaceAnimations;
import com.facebook.redspace.ui.animation.RedSpaceAnimations.C14682;
import com.facebook.redspace.ui.animation.RedSpaceAnimations.C14705;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorAdapter;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.DelegatingAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import javax.inject.Provider;

/* compiled from: PayView was already initialized. */
public class RedSpaceSearchFragment extends FbFragment {
    @Inject
    volatile Provider<RedSpaceAnimations> f11984a = UltralightRuntime.a;
    public MultiAdapterListAdapter al;
    public RedSpaceLoadingScrollListener am;
    public RecyclerView an;
    public RedSpaceSearchBarView ao;
    public View ap;
    @Inject
    public RedSpaceFriendsSearchCollection f11985b;
    @Inject
    public RedSpaceSearchFriendsFetcherHelperProvider f11986c;
    @Inject
    public RedSpaceSearchSubscriptionHelperProvider f11987d;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> f11988e = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceMutationsExecutor> f11989f = UltralightRuntime.b;
    public RedSpaceSearchSubscriptionHelper f11990g;
    public RedSpaceSearchFriendsFetcherHelper f11991h;
    public LoadingIndicatorAdapter f11992i;

    /* compiled from: PayView was already initialized. */
    class C14311 implements Runnable {
        final /* synthetic */ RedSpaceSearchFragment f11976a;

        C14311(RedSpaceSearchFragment redSpaceSearchFragment) {
            this.f11976a = redSpaceSearchFragment;
        }

        public void run() {
            if (this.f11976a.hn_()) {
                this.f11976a.ao.m12792a();
                this.f11976a.f11991h.m12313a(this.f11976a.ao.getText().toString());
            }
        }
    }

    /* compiled from: PayView was already initialized. */
    public class C14322 implements RetryClickedListener {
        final /* synthetic */ String f11977a;
        final /* synthetic */ RedSpaceSearchFragment f11978b;

        public C14322(RedSpaceSearchFragment redSpaceSearchFragment, String str) {
            this.f11978b = redSpaceSearchFragment;
            this.f11977a = str;
        }

        public final void m12427a() {
            this.f11978b.f11991h.m12314b(this.f11977a);
        }
    }

    /* compiled from: PayView was already initialized. */
    public class C14333 implements OnSearchTextChangedListener {
        final /* synthetic */ RedSpaceSearchFragment f11979a;

        public C14333(RedSpaceSearchFragment redSpaceSearchFragment) {
            this.f11979a = redSpaceSearchFragment;
        }

        public final void mo346a(CharSequence charSequence) {
            RedSpaceSearchFragment redSpaceSearchFragment = this.f11979a;
            if (redSpaceSearchFragment.f11991h.m12314b(charSequence.toString())) {
                redSpaceSearchFragment.ao.setShowProgress(true);
            }
        }
    }

    /* compiled from: PayView was already initialized. */
    public class C14344 implements OnClickListener {
        final /* synthetic */ RedSpaceSearchFragment f11980a;

        public C14344(RedSpaceSearchFragment redSpaceSearchFragment) {
            this.f11980a = redSpaceSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 738640338);
            this.f11980a.ao.m12793b();
            RedSpaceSearchFragment redSpaceSearchFragment = this.f11980a;
            if (redSpaceSearchFragment.G != null && (redSpaceSearchFragment.G instanceof RedSpaceHomeFragment)) {
                ((RedSpaceHomeFragment) redSpaceSearchFragment.G).m12401a(redSpaceSearchFragment);
            } else if (redSpaceSearchFragment.o() != null) {
                redSpaceSearchFragment.o().finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -541436855, a);
        }
    }

    /* compiled from: PayView was already initialized. */
    public class C14355 implements OnScrolledToBottomListener {
        final /* synthetic */ RedSpaceSearchFragment f11981a;

        public C14355(RedSpaceSearchFragment redSpaceSearchFragment) {
            this.f11981a = redSpaceSearchFragment;
        }

        public final void mo340a() {
            if (!this.f11981a.f11991h.f11863g) {
                this.f11981a.f11991h.m12313a(this.f11981a.ao.getText().toString());
            }
        }
    }

    /* compiled from: PayView was already initialized. */
    public class C14366 implements OnClickListener {
        final /* synthetic */ RedSpaceSearchFragment f11982a;

        public C14366(RedSpaceSearchFragment redSpaceSearchFragment) {
            this.f11982a = redSpaceSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1926579280);
            if (view instanceof RedSpaceSearchFriendsItemView) {
                ((RedSpaceFriendOptionsHelper) this.f11982a.f11988e.get()).m12742a(this.f11982a.o(), ((RedSpaceSearchFriendsItemView) view).f12379k, "search");
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1229379960, a);
        }
    }

    /* compiled from: PayView was already initialized. */
    public class C14377 implements OnClickListener {
        final /* synthetic */ RedSpaceSearchFragment f11983a;

        public C14377(RedSpaceSearchFragment redSpaceSearchFragment) {
            this.f11983a = redSpaceSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -931166315);
            RedSpaceSearchFriendsItemView redSpaceSearchFriendsItemView = (RedSpaceSearchFriendsItemView) view;
            if (!redSpaceSearchFriendsItemView.f12380l.isTop()) {
                this.f11983a.f11985b.f11807f.add(redSpaceSearchFriendsItemView.f12379k.k());
                ((RedSpaceMutationsExecutor) this.f11983a.f11989f.get()).m12287a(redSpaceSearchFriendsItemView.f12379k, redSpaceSearchFriendsItemView.f12380l, false);
                AdapterDetour.a(this.f11983a.al, -53784060);
            } else if (this.f11983a.f11985b.m12243i(redSpaceSearchFriendsItemView.f12379k)) {
                ((RedSpaceMutationsExecutor) this.f11983a.f11989f.get()).m12286a(redSpaceSearchFriendsItemView.f12379k, redSpaceSearchFriendsItemView.f12380l);
                this.f11983a.f11985b.m12242h(redSpaceSearchFriendsItemView.f12379k);
            }
            LogUtils.a(502312268, a);
        }
    }

    public static void m12431a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RedSpaceSearchFragment) obj).m12432a(IdBasedProvider.a(fbInjector, 10222), new RedSpaceFriendsSearchCollection(), (RedSpaceSearchFriendsFetcherHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(RedSpaceSearchFriendsFetcherHelperProvider.class), (RedSpaceSearchSubscriptionHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(RedSpaceSearchSubscriptionHelperProvider.class), IdBasedLazy.a(fbInjector, 10220), IdBasedSingletonScopeProvider.b(fbInjector, 10172));
    }

    public final void m12437c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = RedSpaceSearchFragment.class;
        m12431a((Object) this, getContext());
        RedSpaceSearchFriendsFetcherHelperProvider redSpaceSearchFriendsFetcherHelperProvider = this.f11986c;
        RedSpaceSearchFriendsFetcherHelper redSpaceSearchFriendsFetcherHelper = new RedSpaceSearchFriendsFetcherHelper(this, this.f11985b);
        RedSpaceBatchRequests a = RedSpaceBatchRequests.a(redSpaceSearchFriendsFetcherHelperProvider);
        RedSpaceRequests a2 = RedSpaceRequests.a(redSpaceSearchFriendsFetcherHelperProvider);
        redSpaceSearchFriendsFetcherHelper.f11858b = RedSpaceBatchFetcher.b(redSpaceSearchFriendsFetcherHelperProvider);
        redSpaceSearchFriendsFetcherHelper.f11859c = a;
        redSpaceSearchFriendsFetcherHelper.f11860d = a2;
        this.f11991h = redSpaceSearchFriendsFetcherHelper;
        RedSpaceSearchFriendsAdapter redSpaceSearchFriendsAdapter = new RedSpaceSearchFriendsAdapter(this.f11985b);
        redSpaceSearchFriendsAdapter.f11734b = new C14366(this);
        redSpaceSearchFriendsAdapter.f11735c = new C14377(this);
        this.f11992i = new LoadingIndicatorAdapter();
        this.al = MultiAdapterListAdapter.b(new FbListAdapter[]{redSpaceSearchFriendsAdapter, this.f11992i});
        InjectorLike injectorLike = this.f11987d;
        this.f11990g = new RedSpaceSearchSubscriptionHelper(RedSpaceMutationsExecutor.m12282a(injectorLike), this.f11985b, this.al);
    }

    public final View m12435a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1831533198);
        View inflate = layoutInflater.inflate(2130906779, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1501013227, a);
        return inflate;
    }

    public final void m12436a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131235740);
            hasTitleBar.c(true);
            hasTitleBar.a(null);
        }
        this.an = (RecyclerView) e(2131566876);
        this.an.setLayoutManager(new BetterLinearLayoutManager(o()));
        this.an.setAdapter(new DelegatingAdapter(this.al, this.an));
        this.am = new RedSpaceLoadingScrollListener(3, new C14355(this));
        this.an.setOnScrollListener(this.am);
        this.ao = (RedSpaceSearchBarView) e(2131566874);
        this.ap = e(2131566875);
        this.ao.f12370h = new C14333(this);
        this.ap.setOnClickListener(new C14344(this));
        m12433a(bundle == null);
    }

    private void m12433a(boolean z) {
        if (z && this.s != null && this.s.containsKey("bundle_animation_params")) {
            RedSpaceAnimations redSpaceAnimations = (RedSpaceAnimations) this.f11984a.get();
            View view = this.ao;
            View view2 = this.ap;
            Rect rect = (Rect) this.s.getParcelable("bundle_animation_params");
            C14311 c14311 = new C14311(this);
            view2.setVisibility(8);
            view.getViewTreeObserver().addOnPreDrawListener(new C14682(new C14705(redSpaceAnimations, view, view2, rect, c14311), view));
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 399929913);
        this.ao.m12793b();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 467400598, a);
    }

    public final void m12434I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -479796875);
        SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = this.f11990g;
        simpleFriendChangedSubscriber.f11864a.m12289b(simpleFriendChangedSubscriber);
        RedSpaceSearchFriendsFetcherHelper redSpaceSearchFriendsFetcherHelper = this.f11991h;
        redSpaceSearchFriendsFetcherHelper.f11862f.clear();
        redSpaceSearchFriendsFetcherHelper.f11858b.a();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 428127634, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ao.dispatchConfigurationChanged(configuration);
    }

    private void m12432a(Provider<RedSpaceAnimations> provider, RedSpaceFriendsSearchCollection redSpaceFriendsSearchCollection, RedSpaceSearchFriendsFetcherHelperProvider redSpaceSearchFriendsFetcherHelperProvider, RedSpaceSearchSubscriptionHelperProvider redSpaceSearchSubscriptionHelperProvider, com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> lazy, com.facebook.inject.Lazy<RedSpaceMutationsExecutor> lazy2) {
        this.f11984a = provider;
        this.f11985b = redSpaceFriendsSearchCollection;
        this.f11986c = redSpaceSearchFriendsFetcherHelperProvider;
        this.f11987d = redSpaceSearchSubscriptionHelperProvider;
        this.f11988e = lazy;
        this.f11989f = lazy2;
    }
}
