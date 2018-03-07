package com.facebook.redspace.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.RecyclerListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragmentController;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.SecureContextHelper;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.RedSpaceFriendsLayout;
import com.facebook.redspace.abtest.RedSpaceStrings;
import com.facebook.redspace.adapter.RedSpaceFriendsAdapter;
import com.facebook.redspace.adapter.RedSpaceHomeComposerAdapter;
import com.facebook.redspace.adapter.RedSpaceHomeMultiAdapter;
import com.facebook.redspace.analytics.RedSpaceComposerListener;
import com.facebook.redspace.analytics.RedSpaceGridImpressionListener;
import com.facebook.redspace.analytics.RedSpaceGridOpenListener;
import com.facebook.redspace.analytics.RedSpaceGridViewportMonitor;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.analytics.logger.RedSpaceTimeLogger;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.Params;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.RedSpaceFriendsFetchListener;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelperProvider;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.data.RedSpaceHomeSubscriptionHelper;
import com.facebook.redspace.data.RedSpaceHomeSubscriptionHelperProvider;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.data.RedSpaceSelfProfileDataStore;
import com.facebook.redspace.data.RedSpaceSelfProfileDataStore.State;
import com.facebook.redspace.debug.RedSpaceFriendsDebugWriter;
import com.facebook.redspace.debug.RedSpaceFriendsDebugWriter.FriendSectionDeterminator;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceHomeControllerCallbacksDispatcher;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceHomeDispatcherFactory;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceBadgeController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceHomeViewMutatorController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceSelfProfileDataController;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceFriendOptionsHelper;
import com.facebook.redspace.ui.RedSpaceGridEqualSpacingDecorator;
import com.facebook.redspace.ui.RedSpaceHomeComposerView;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener;
import com.facebook.redspace.ui.RedSpaceLoadingScrollListener.OnScrolledToBottomListener;
import com.facebook.redspace.ui.RedSpaceUserActivity;
import com.facebook.redspace.ui.animation.RedSpaceAnimations;
import com.facebook.redspace.ui.animation.RedSpaceAnimations.C14694;
import com.facebook.redspace.ui.animation.RedSpaceFriendViewAnimationParams;
import com.facebook.redspace.ui.friendslist.RedSpaceAnimationSupportedView;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsListItemHolder;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsOverflowView;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsTitleView.OnEditModeSwitchListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollingFragmentViewHolder;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorAdapter;
import com.facebook.widget.recyclerview.BetterGridLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.DelegatingAdapter;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Provider;

@UriMatchPatterns(fragment = ContentFragmentType.REDSPACE_HOME_FRAGMENT)
/* compiled from: Payment method has a null logo url */
public class RedSpaceHomeFragment extends DrawerContentFragment implements AnalyticsFragment, CanHandleBackPressed, FragmentWithDebugInfo, RedSpaceFriendsFetchListener, ScrollableListContainer, ScrollingFragmentViewHolder {
    private static final String f11950d = RedSpaceHomeFragment.class.getSimpleName();
    @Inject
    volatile Provider<RedSpaceTabUnseenCountFetcher> f11951a = UltralightRuntime.a;
    @Inject
    public RedSpaceFriendsCollection aA;
    @Inject
    private Resources aB;
    @Inject
    private QeAccessor aC;
    @Inject
    public RedSpaceStrings aD;
    @Inject
    private RedSpaceHomeDispatcherFactory aE;
    public RedSpaceHomeSubscriptionHelper aF;
    public RedSpaceFriendsAdapter aG;
    public RedSpaceFriendsAdapter aH;
    private LoadingIndicatorAdapter aI;
    private RedSpaceLoadingScrollListener aJ;
    public OnClickListener aK;
    public OnClickListener aL;
    public OnClickListener aM;
    public OnLongClickListener aN;
    public OnEditModeSwitchListener aO;
    public BetterRecyclerView aP;
    private C14192 aQ;
    public RedSpaceFriendsFetcherHelper aR;
    public RedSpaceHomeMultiAdapter aS;
    private ScrollingViewProxy aT;
    private GridLayoutManager aU;
    private FbSwipeRefreshLayout aV;
    private boolean aW;
    public boolean aX;
    public View aY;
    private RedSpaceHomeComposerAdapter aZ;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> al = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceComposerListener> am = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceGridOpenListener> an = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> ao = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceTimeLogger> ap = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsDebugWriter> aq = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> ar = UltralightRuntime.b;
    @Inject
    public MultipleRowsStoriesRecycleCallback as;
    @Inject
    public RedSpaceHomeSubscriptionHelperProvider at;
    @Inject
    private RedSpaceTabUnseenCountFetcher au;
    @Inject
    private RedSpaceGridImpressionListener av;
    @Inject
    private RedSpaceGridViewportMonitor aw;
    @Inject
    private RedSpaceFriendsFetcherHelperProvider ax;
    @Inject
    private ScreenUtil ay;
    @Inject
    public RedSpaceFriendsCollection az;
    @Inject
    volatile Provider<RedSpaceOptimisticBadgeStore> f11952b = UltralightRuntime.a;
    private Handler ba;
    public RedSpaceHomeControllerCallbacksDispatcher bb;
    @Inject
    volatile Provider<RedSpaceAnimations> f11953c = UltralightRuntime.a;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<UriIntentMapper> f11954e = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceLogger> f11955f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceGridEqualSpacingDecorator> f11956g = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> f11957h = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<LoggedInUserAuthDataStore> f11958i = UltralightRuntime.b;

    /* compiled from: Payment method has a null logo url */
    class C14181 implements OnScrolledToBottomListener {
        final /* synthetic */ RedSpaceHomeFragment f11941a;

        C14181(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11941a = redSpaceHomeFragment;
        }

        public final void mo340a() {
            if (this.f11941a.D() && !this.f11941a.aR.f11801l) {
                this.f11941a.aR.m12231a();
            }
        }
    }

    /* compiled from: Payment method has a null logo url */
    public class C14192 {
        public final /* synthetic */ RedSpaceHomeFragment f11942a;

        C14192(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11942a = redSpaceHomeFragment;
        }
    }

    /* compiled from: Payment method has a null logo url */
    public class C14203 implements OnClickListener {
        final /* synthetic */ RedSpaceHomeFragment f11943a;

        public C14203(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11943a = redSpaceHomeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1268024158);
            RedSpaceHomeFragment.m12389b(this.f11943a, view);
            Logger.a(2, EntryType.UI_INPUT_END, -265801429, a);
        }
    }

    /* compiled from: Payment method has a null logo url */
    public class C14214 implements OnClickListener {
        final /* synthetic */ RedSpaceHomeFragment f11944a;

        public C14214(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11944a = redSpaceHomeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 178301586);
            RedSpaceFriendsListItemHolder redSpaceFriendsListItemHolder = (RedSpaceFriendsListItemHolder) view;
            RedSpaceHomeFragment.m12386a(this.f11944a, redSpaceFriendsListItemHolder.getProfile().k(), redSpaceFriendsListItemHolder.getProfilePictureView());
            Logger.a(2, EntryType.UI_INPUT_END, 751580116, a);
        }
    }

    /* compiled from: Payment method has a null logo url */
    public class C14225 implements OnClickListener {
        final /* synthetic */ RedSpaceHomeFragment f11945a;

        public C14225(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11945a = redSpaceHomeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2088411529);
            Intent a2 = ((UriIntentMapper) this.f11945a.f11954e.get()).a(this.f11945a.getContext(), FBLinks.eU);
            a2.putExtra("bundle_section", ((RedSpaceFriendsOverflowView) view).getSection().getOverflowVariant().serialize());
            ((SecureContextHelper) this.f11945a.f11957h.get()).a(a2, 2, this.f11945a);
            Logger.a(2, EntryType.UI_INPUT_END, -1870215941, a);
        }
    }

    /* compiled from: Payment method has a null logo url */
    public class C14236 implements OnLongClickListener {
        final /* synthetic */ RedSpaceHomeFragment f11946a;

        public C14236(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11946a = redSpaceHomeFragment;
        }

        public boolean onLongClick(View view) {
            RedSpaceFriendsListItemHolder redSpaceFriendsListItemHolder = (RedSpaceFriendsListItemHolder) view;
            RedSpaceFeedProfileFragmentModel profile = redSpaceFriendsListItemHolder.getProfile();
            RedSpaceFriendsSection section = redSpaceFriendsListItemHolder.getSection();
            if (profile == null || section == null) {
                return false;
            }
            ((RedSpaceFriendOptionsHelper) this.f11946a.ao.get()).m12741a(this.f11946a.getContext(), view, profile, section);
            return true;
        }
    }

    /* compiled from: Payment method has a null logo url */
    public class C14247 implements OnEditModeSwitchListener {
        final /* synthetic */ RedSpaceHomeFragment f11947a;

        public C14247(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11947a = redSpaceHomeFragment;
        }

        public final void mo341a() {
            this.f11947a.aG.f11726j = true;
            this.f11947a.aH.f11726j = true;
            RedSpaceHomeFragment.av(this.f11947a);
            RedSpaceHomeFragment.aw(this.f11947a);
            HoneyClientEventFast a = ((RedSpaceLogger) this.f11947a.f11955f.get()).b.a("enter_edit_mode", false);
            if (a.a()) {
                a.a("redspace");
                a.b();
            }
        }

        public final void mo342b() {
            RedSpaceHomeFragment.au(this.f11947a);
        }
    }

    /* compiled from: Payment method has a null logo url */
    class C14258 implements OnRefreshListener {
        final /* synthetic */ RedSpaceHomeFragment f11948a;

        C14258(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11948a = redSpaceHomeFragment;
        }

        public final void m12382a() {
            RedSpaceHomeFragment redSpaceHomeFragment = this.f11948a;
            redSpaceHomeFragment.bb.av();
            redSpaceHomeFragment.aR.m12234e();
            redSpaceHomeFragment.az.mo333g();
            redSpaceHomeFragment.aA.mo333g();
            RedSpaceFriendsFetcherHelper redSpaceFriendsFetcherHelper = redSpaceHomeFragment.aR;
            redSpaceFriendsFetcherHelper.f11802m = true;
            int size = redSpaceFriendsFetcherHelper.f11799j.size();
            for (int i = 0; i < size; i++) {
                Pair pair = (Pair) redSpaceFriendsFetcherHelper.f11799j.get(i);
                redSpaceFriendsFetcherHelper.f11795f.m12211a((RedSpaceFriendsSection) pair.first);
            }
            redSpaceFriendsFetcherHelper.m12231a();
            AdapterDetour.a(redSpaceHomeFragment.aS, 626506435);
            HoneyClientEventFast a = ((RedSpaceLogger) redSpaceHomeFragment.f11955f.get()).b.a("ptr_grid_view", false);
            if (a.a()) {
                a.a("redspace");
                a.b();
            }
        }
    }

    /* compiled from: Payment method has a null logo url */
    class C14269 extends SpanSizeLookup {
        final /* synthetic */ RedSpaceHomeFragment f11949b;

        C14269(RedSpaceHomeFragment redSpaceHomeFragment) {
            this.f11949b = redSpaceHomeFragment;
        }

        public final int m12383a(int i) {
            return RedSpaceHomeFragment.m12384a(this.f11949b, i, this.f11949b.aS);
        }
    }

    public static void m12387a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RedSpaceHomeFragment) obj).m12388a(IdBasedSingletonScopeProvider.a(injectorLike, 10165), IdBasedSingletonScopeProvider.a(injectorLike, 3265), IdBasedProvider.a(injectorLike, 10222), IdBasedSingletonScopeProvider.b(injectorLike, 2436), IdBasedSingletonScopeProvider.b(injectorLike, 10162), IdBasedLazy.a(injectorLike, 10221), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedSingletonScopeProvider.b(injectorLike, 339), IdBasedLazy.a(injectorLike, 5272), IdBasedLazy.a(injectorLike, 10158), IdBasedLazy.a(injectorLike, 10160), IdBasedLazy.a(injectorLike, 10220), IdBasedLazy.a(injectorLike, 10163), IdBasedLazy.a(injectorLike, 10180), IdBasedLazy.a(injectorLike, 10174), MultipleRowsStoriesRecycleCallback.a(injectorLike), (RedSpaceHomeSubscriptionHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceHomeSubscriptionHelperProvider.class), RedSpaceTabUnseenCountFetcher.a(injectorLike), RedSpaceGridImpressionListener.m12192a(injectorLike), RedSpaceGridViewportMonitor.m12196a(injectorLike), (RedSpaceFriendsFetcherHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceFriendsFetcherHelperProvider.class), ScreenUtil.a(injectorLike), RedSpaceFriendsCollection.m12212a(injectorLike), RedSpaceFriendsCollection.m12212a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RedSpaceStrings.a(injectorLike), RedSpaceHomeDispatcherFactory.m12467a(injectorLike));
    }

    private void m12388a(Provider<RedSpaceTabUnseenCountFetcher> provider, Provider<RedSpaceOptimisticBadgeStore> provider2, Provider<RedSpaceAnimations> provider3, com.facebook.inject.Lazy<UriIntentMapper> lazy, com.facebook.inject.Lazy<RedSpaceLogger> lazy2, com.facebook.inject.Lazy<RedSpaceGridEqualSpacingDecorator> lazy3, com.facebook.inject.Lazy<SecureContextHelper> lazy4, com.facebook.inject.Lazy<LoggedInUserAuthDataStore> lazy5, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy6, com.facebook.inject.Lazy<RedSpaceComposerListener> lazy7, com.facebook.inject.Lazy<RedSpaceGridOpenListener> lazy8, com.facebook.inject.Lazy<RedSpaceFriendOptionsHelper> lazy9, com.facebook.inject.Lazy<RedSpaceTimeLogger> lazy10, com.facebook.inject.Lazy<RedSpaceFriendsDebugWriter> lazy11, com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> lazy12, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, RedSpaceHomeSubscriptionHelperProvider redSpaceHomeSubscriptionHelperProvider, RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher, RedSpaceGridImpressionListener redSpaceGridImpressionListener, RedSpaceGridViewportMonitor redSpaceGridViewportMonitor, RedSpaceFriendsFetcherHelperProvider redSpaceFriendsFetcherHelperProvider, ScreenUtil screenUtil, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsCollection redSpaceFriendsCollection2, Resources resources, QeAccessor qeAccessor, RedSpaceStrings redSpaceStrings, RedSpaceHomeDispatcherFactory redSpaceHomeDispatcherFactory) {
        this.f11951a = provider;
        this.f11952b = provider2;
        this.f11953c = provider3;
        this.f11954e = lazy;
        this.f11955f = lazy2;
        this.f11956g = lazy3;
        this.f11957h = lazy4;
        this.f11958i = lazy5;
        this.al = lazy6;
        this.am = lazy7;
        this.an = lazy8;
        this.ao = lazy9;
        this.ap = lazy10;
        this.aq = lazy11;
        this.ar = lazy12;
        this.as = multipleRowsStoriesRecycleCallback;
        this.at = redSpaceHomeSubscriptionHelperProvider;
        this.au = redSpaceTabUnseenCountFetcher;
        this.av = redSpaceGridImpressionListener;
        this.aw = redSpaceGridViewportMonitor;
        this.ax = redSpaceFriendsFetcherHelperProvider;
        this.ay = screenUtil;
        this.az = redSpaceFriendsCollection;
        this.aA = redSpaceFriendsCollection2;
        this.aB = resources;
        this.aC = qeAccessor;
        this.aD = redSpaceStrings;
        this.aE = redSpaceHomeDispatcherFactory;
    }

    public static RedSpaceHomeFragment m12385a(boolean z) {
        RedSpaceHomeFragment redSpaceHomeFragment = new RedSpaceHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("bundle_show_titlebar", z);
        redSpaceHomeFragment.g(bundle);
        return redSpaceHomeFragment;
    }

    public final void m12402c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = RedSpaceHomeFragment.class;
        m12387a((Object) this, getContext());
        this.ba = new Handler();
        if (this.s != null) {
            this.aX = this.s.getBoolean("bundle_show_titlebar");
        }
        this.aM = new C14203(this);
        this.aK = new C14214(this);
        this.aL = new C14225(this);
        this.aN = new C14236(this);
        this.aO = new C14247(this);
        RedSpaceFriendsFetcherHelperProvider redSpaceFriendsFetcherHelperProvider = this.ax;
        ImmutableList of = ImmutableList.of(new Pair(RedSpaceFriendsSection.TOP, this.az), new Pair(RedSpaceFriendsSection.OTHERS, this.aA));
        Params params = new Params();
        params.f11789a = true;
        this.aR = redSpaceFriendsFetcherHelperProvider.m12235a(this, of, params);
        RedSpaceFriendsLayout layout = RedSpaceFriendsLayout.getLayout(this.aC);
        this.aG = RedSpaceFriendsAdapter.m12151a(RedSpaceFriendsSection.TOP, false, this.az, this.aK, this.aL, this.aM, this.aN, this.aO, layout);
        this.aH = RedSpaceFriendsAdapter.m12151a(RedSpaceFriendsSection.OTHERS, true, this.aA, this.aK, this.aL, this.aM, this.aN, this.aO, layout);
        this.aI = new LoadingIndicatorAdapter(2130906778);
        this.aZ = new RedSpaceHomeComposerAdapter(new OnClickListener(this) {
            final /* synthetic */ RedSpaceHomeFragment f11939a;

            {
                this.f11939a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1852188062);
                RedSpaceHomeComposerView redSpaceHomeComposerView = (RedSpaceHomeComposerView) view;
                RedSpaceHomeFragment.m12386a(this.f11939a, (String) redSpaceHomeComposerView.getTag(), (View) redSpaceHomeComposerView.f12342r);
                if (this.f11939a.aG.f11726j) {
                    RedSpaceHomeFragment.au(this.f11939a);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1072382745, a);
            }
        });
        this.aS = new RedSpaceHomeMultiAdapter(this.aZ, this.aG, this.aH, this.aI);
        m12392n(bundle);
        this.aJ = new RedSpaceLoadingScrollListener(aE() * 3, new C14181(this));
        this.aQ = new C14192(this);
        RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher = this.au;
        redSpaceTabUnseenCountFetcher.n.a(this.aQ);
        this.aR.m12231a();
    }

    public final View m12396a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 142202114);
        View inflate = layoutInflater.inflate(2130906777, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1556154044, a);
        return inflate;
    }

    public final void m12398a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.aX) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(this.aD.a());
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
        m12390c(view);
        aG();
        this.aF = this.at.m12277a(this.az, this.aG, this.aA, this.aH, this.aS, this.aP.o);
        this.aY = e(2131566872);
    }

    private void m12392n(Bundle bundle) {
        RedSpaceBadgeController redSpaceBadgeController;
        RedSpaceSelfProfileDataController redSpaceSelfProfileDataController;
        RedSpaceHomeDispatcherFactory redSpaceHomeDispatcherFactory = this.aE;
        RedSpaceHomeComposerAdapter redSpaceHomeComposerAdapter = this.aZ;
        RedSpaceHomeControllerCallbacksDispatcher redSpaceHomeControllerCallbacksDispatcher = new RedSpaceHomeControllerCallbacksDispatcher(new FbFragmentController(), redSpaceHomeDispatcherFactory.f12010a, redSpaceHomeDispatcherFactory.f12011b, redSpaceHomeDispatcherFactory.f12012c);
        if (redSpaceHomeControllerCallbacksDispatcher.f12006a != null) {
            redSpaceHomeControllerCallbacksDispatcher.f12006a.a = redSpaceHomeControllerCallbacksDispatcher;
        }
        Holder holder = new Holder();
        if (redSpaceHomeControllerCallbacksDispatcher.f12006a != null) {
            redSpaceHomeControllerCallbacksDispatcher.f12006a.b = holder;
        }
        if (redSpaceHomeControllerCallbacksDispatcher.f12008c != null) {
            redSpaceHomeControllerCallbacksDispatcher.f12008c.f12098i = redSpaceHomeComposerAdapter;
        }
        RedSpaceHomeViewMutatorController redSpaceHomeViewMutatorController = null;
        redSpaceHomeControllerCallbacksDispatcher.f12006a = redSpaceHomeControllerCallbacksDispatcher.f12006a.kJ_() ? redSpaceHomeControllerCallbacksDispatcher.f12006a : null;
        if (redSpaceHomeControllerCallbacksDispatcher.f12007b.kJ_()) {
            redSpaceBadgeController = redSpaceHomeControllerCallbacksDispatcher.f12007b;
        } else {
            redSpaceBadgeController = null;
        }
        redSpaceHomeControllerCallbacksDispatcher.f12007b = redSpaceBadgeController;
        if (redSpaceHomeControllerCallbacksDispatcher.f12008c.kJ_()) {
            redSpaceSelfProfileDataController = redSpaceHomeControllerCallbacksDispatcher.f12008c;
        } else {
            redSpaceSelfProfileDataController = null;
        }
        redSpaceHomeControllerCallbacksDispatcher.f12008c = redSpaceSelfProfileDataController;
        if (redSpaceHomeControllerCallbacksDispatcher.f12009d.kJ_()) {
            redSpaceHomeViewMutatorController = redSpaceHomeControllerCallbacksDispatcher.f12009d;
        }
        redSpaceHomeControllerCallbacksDispatcher.f12009d = redSpaceHomeViewMutatorController;
        this.bb = redSpaceHomeControllerCallbacksDispatcher;
        RedSpaceHomeControllerCallbacksDispatcher redSpaceHomeControllerCallbacksDispatcher2 = this.bb;
        if (redSpaceHomeControllerCallbacksDispatcher2.f12006a != null) {
            redSpaceHomeControllerCallbacksDispatcher2.f12006a.a(this);
        }
        if (redSpaceHomeControllerCallbacksDispatcher2.f12007b != null) {
            RedSpaceBadgeController redSpaceBadgeController2 = redSpaceHomeControllerCallbacksDispatcher2.f12007b;
            redSpaceBadgeController2.f12034d = Integer.valueOf(redSpaceBadgeController2.f12031a.e());
            redSpaceBadgeController2.f12035e = redSpaceBadgeController2.f12031a.h();
        }
        if (redSpaceHomeControllerCallbacksDispatcher2.f12008c != null) {
            redSpaceHomeControllerCallbacksDispatcher2.f12008c.m12552e();
        }
    }

    public static void au(RedSpaceHomeFragment redSpaceHomeFragment) {
        redSpaceHomeFragment.aG.f11726j = false;
        redSpaceHomeFragment.aH.f11726j = false;
        av(redSpaceHomeFragment);
        aw(redSpaceHomeFragment);
    }

    public static void av(RedSpaceHomeFragment redSpaceHomeFragment) {
        for (int i = 0; i < redSpaceHomeFragment.aP.getChildCount(); i++) {
            View childAt = redSpaceHomeFragment.aP.getChildAt(i);
            if (childAt instanceof RedSpaceAnimationSupportedView) {
                ((RedSpaceAnimationSupportedView) childAt).mo356a();
            }
        }
    }

    public static void aw(RedSpaceHomeFragment redSpaceHomeFragment) {
        redSpaceHomeFragment.aP.o.a(0, redSpaceHomeFragment.aP.o.aZ_());
    }

    public static void m12389b(RedSpaceHomeFragment redSpaceHomeFragment, View view) {
        if (redSpaceHomeFragment.ay()) {
            View b = FindViewUtil.b(view, 2131566865);
            Parcelable rect = new Rect();
            b.getGlobalVisibleRect(rect);
            RedSpaceAnimations redSpaceAnimations = (RedSpaceAnimations) redSpaceHomeFragment.f11953c.get();
            View view2 = redSpaceHomeFragment.aY;
            FbSwipeRefreshLayout fbSwipeRefreshLayout = redSpaceHomeFragment.aV;
            redSpaceAnimations.f12432a.get();
            float y = view.getY();
            view2.setTranslationY(y);
            view2.setVisibility(0);
            view2.animate().setDuration(200).translationY(0.0f).setInterpolator(new DecelerateInterpolator());
            fbSwipeRefreshLayout.animate().setDuration(200).translationX(0.0f).translationY(-y).setInterpolator(new DecelerateInterpolator()).setListener(new C14694(redSpaceAnimations, fbSwipeRefreshLayout));
            FragmentTransaction a = redSpaceHomeFragment.s().a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("bundle_animation_params", rect);
            RedSpaceSearchFragment redSpaceSearchFragment = new RedSpaceSearchFragment();
            redSpaceSearchFragment.g(bundle);
            a.b(2131566872, redSpaceSearchFragment).b();
        }
    }

    public final void m12401a(RedSpaceSearchFragment redSpaceSearchFragment) {
        if (ay()) {
            s().a().a(0, 2130968608).a(redSpaceSearchFragment).b();
            this.aV.clearAnimation();
            this.aV.setTranslationY(0.0f);
            this.aV.setVisibility(0);
        }
    }

    private boolean ay() {
        return hn_() && s().c();
    }

    private void m12390c(View view) {
        this.aP = (BetterRecyclerView) view.findViewById(2131559427);
        this.aV = (FbSwipeRefreshLayout) view.findViewById(2131566871);
        this.aV.e = new C14258(this);
        this.aU = new BetterGridLayoutManager(getContext(), aE());
        this.aU.h = new C14269(this);
        this.aP.setLayoutManager(this.aU);
        this.aP.setAdapter(new DelegatingAdapter(this.aS, this.aP));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.g = false;
        this.aP.setItemAnimator(defaultItemAnimator);
        this.aP.a(this.aJ);
        this.aP.setRecyclerListener(new RecyclerListener(this) {
            final /* synthetic */ RedSpaceHomeFragment f11936a;

            {
                this.f11936a = r1;
            }

            public final void m12373a(ViewHolder viewHolder) {
                this.f11936a.as.a().a(viewHolder.a);
            }
        });
        this.aT = new RecyclerViewProxy(this.aP);
        this.aT.a(this.aS);
        this.aT.b(this.aw);
        RedSpaceHomeControllerCallbacksDispatcher redSpaceHomeControllerCallbacksDispatcher = this.bb;
        if (redSpaceHomeControllerCallbacksDispatcher.f12008c != null) {
            RedSpaceSelfProfileDataController redSpaceSelfProfileDataController = redSpaceHomeControllerCallbacksDispatcher.f12008c;
            RecyclerViewProxy recyclerViewProxy = (RecyclerViewProxy) n();
            redSpaceSelfProfileDataController.f12099j = recyclerViewProxy.c;
            redSpaceSelfProfileDataController.f12100k = (RedSpaceHomeMultiAdapter) recyclerViewProxy.o();
        }
        RedSpaceGridViewportMonitor redSpaceGridViewportMonitor = this.aw;
        RedSpaceGridImpressionListener redSpaceGridImpressionListener = this.av;
        if (!redSpaceGridViewportMonitor.f11761b.contains(redSpaceGridImpressionListener)) {
            redSpaceGridViewportMonitor.f11761b.add(redSpaceGridImpressionListener);
        }
        if (!aF()) {
            ((RedSpaceGridEqualSpacingDecorator) this.f11956g.get()).m12747a(this.aP);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!aF()) {
            aD();
        }
        super.onConfigurationChanged(configuration);
    }

    public final void m12403g(boolean z) {
        super.g(z);
        if (this.aw != null) {
            this.aW = true;
            ((RedSpaceGridOpenListener) this.an.get()).m12195a(z, this.au.e());
            if (z) {
                this.aw.m12199a(this.aT);
            } else {
                this.aw.m12198a();
            }
            this.au.d();
            if (z && this.aP != null && this.aJ.m12766a(this.aP)) {
                this.aR.m12231a();
            }
        }
    }

    public final void m12395I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1624611043);
        RedSpaceTabUnseenCountFetcher redSpaceTabUnseenCountFetcher = this.au;
        redSpaceTabUnseenCountFetcher.n.b(this.aQ);
        RedSpaceGridViewportMonitor redSpaceGridViewportMonitor = this.aw;
        redSpaceGridViewportMonitor.f11761b.remove(this.av);
        SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = this.aF;
        simpleFriendChangedSubscriber.f11819b.m12289b(simpleFriendChangedSubscriber);
        simpleFriendChangedSubscriber.f11824g.b(simpleFriendChangedSubscriber.f11825h);
        simpleFriendChangedSubscriber.f11824g.b(simpleFriendChangedSubscriber.f11826i);
        simpleFriendChangedSubscriber.f11824g.b(simpleFriendChangedSubscriber.f11827j);
        this.aR.m12233d();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 666200563, a);
    }

    public final void m12393G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1061145575);
        super.G();
        if (D()) {
            if (!this.aW) {
                g(true);
            }
            this.aw.m12199a(this.aT);
            LogUtils.f(449450180, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 174279556, a);
    }

    public final void m12394H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1373060465);
        if (D()) {
            this.aw.m12198a();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1142997167, a);
    }

    public final void gB_() {
        ScrollingViewProxy n = m12404n();
        if (n != null) {
            n.e(0);
        }
    }

    public final boolean gC_() {
        ScrollingViewProxy n = m12404n();
        if (n == null) {
            return true;
        }
        return n.n();
    }

    public final ScrollingViewProxy m12404n() {
        return this.aT;
    }

    public final void mo343a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
        this.bb.mo343a(redSpaceFriendsSection, redSpaceFriendsCollection);
        ((RedSpaceTimeLogger) this.ap.get()).a();
        this.aI.a();
    }

    public final void mo344a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        boolean z;
        this.bb.mo344a(redSpaceFriendsSection, redSpaceFriendsCollection, redSpaceFriendsFetchResult);
        RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f11955f.get();
        long b = ((RedSpaceTimeLogger) this.ap.get()).b();
        HoneyClientEventFast a = redSpaceLogger.b.a("grid_load", false);
        if (a.a()) {
            a.a("redspace_performance");
            a.a("elapsed_time_ms", b);
            a.b();
        }
        RedSpaceFriendsAdapter redSpaceFriendsAdapter = this.aH;
        if (this.aG.getCount() == 0) {
            z = true;
        } else {
            z = false;
        }
        redSpaceFriendsAdapter.f11725i = z;
        if (!(this.az.m12218a() || this.aA.m12218a())) {
            this.aI.b();
        }
        if (this.aV != null) {
            this.aV.setRefreshing(false);
        }
        if (!(redSpaceFriendsFetchResult == null || redSpaceFriendsFetchResult.f11780d == null)) {
            this.aZ.f11730d = redSpaceFriendsFetchResult.f11780d;
        }
        AdapterDetour.a(this.aS, 814405848);
        HandlerDetour.a(this.ba, new Runnable(this) {
            final /* synthetic */ RedSpaceHomeFragment f11937a;

            {
                this.f11937a = r1;
            }

            public void run() {
                if (this.f11937a.aP != null) {
                    this.f11937a.aP.requestLayout();
                }
            }
        }, -111166597);
        if (D() && this.aP != null && this.aJ.m12766a(this.aP)) {
            this.aR.m12231a();
            this.aw.m12199a(this.aT);
        }
    }

    public final void a_(Throwable th) {
        this.bb.a_(th);
        ((RedSpaceLogger) this.f11955f.get()).a(th, ((RedSpaceTimeLogger) this.ap.get()).b());
        if (o() != null) {
            if (this.aV != null) {
                this.aV.setRefreshing(false);
            }
            this.aI.a(this.aB.getString(2131230758), new RetryClickedListener(this) {
                final /* synthetic */ RedSpaceHomeFragment f11938a;

                {
                    this.f11938a = r1;
                }

                public final void m12374a() {
                    this.f11938a.aR.m12231a();
                }
            });
        }
    }

    public static void m12386a(RedSpaceHomeFragment redSpaceHomeFragment, String str, View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Parcelable redSpaceFriendViewAnimationParams = new RedSpaceFriendViewAnimationParams(str, rect);
        Intent intent = new Intent(redSpaceHomeFragment.getContext(), RedSpaceUserActivity.class);
        RedSpaceSelfProfileDataStore redSpaceSelfProfileDataStore = (RedSpaceSelfProfileDataStore) redSpaceHomeFragment.ar.get();
        intent.putExtra("bundle_collection_self", new State(redSpaceSelfProfileDataStore.f11871a, redSpaceSelfProfileDataStore.f11872b));
        intent.putExtra("bundle_collection_top", redSpaceHomeFragment.az);
        intent.putExtra("bundle_collection_others", redSpaceHomeFragment.aA);
        intent.putExtra("bundle_selected_profile_id", str);
        intent.putExtra("bundle_animation_params", redSpaceFriendViewAnimationParams);
        intent.putExtra("bundle_source", "grid");
        ((SecureContextHelper) redSpaceHomeFragment.f11957h.get()).a(intent, 1, redSpaceHomeFragment);
        redSpaceHomeFragment.f11953c.get();
        RedSpaceAnimations.m12836a(redSpaceHomeFragment.o());
    }

    public static int m12384a(RedSpaceHomeFragment redSpaceHomeFragment, int i, MultiAdapterListAdapter multiAdapterListAdapter) {
        if (redSpaceHomeFragment.aF()) {
            return 1;
        }
        int i2 = redSpaceHomeFragment.aU.c;
        FbListAdapter a = multiAdapterListAdapter.a(i);
        multiAdapterListAdapter.b.a(i);
        int i3 = multiAdapterListAdapter.b.d;
        if (!(a instanceof RedSpaceFriendsAdapter)) {
            return i2;
        }
        int a2 = ((RedSpaceFriendsAdapter) a).m12152a(i3);
        return (a2 == 0 || a2 == 1 || a2 == 4) ? i2 : 1;
    }

    public final void m12397a(int i, int i2, Intent intent) {
        ((RedSpaceGridOpenListener) this.an.get()).m12194a(i);
        RedSpaceComposerListener redSpaceComposerListener = (RedSpaceComposerListener) this.am.get();
        if (i == 1756) {
            HoneyClientEventFast a;
            if (i2 != -1) {
                a = redSpaceComposerListener.f11750a.b.a("redspace_composer_cancelled", false);
                if (a.a()) {
                    a.a("redspace");
                    a.b();
                }
            } else {
                PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
                if (publishPostParams != null) {
                    RedSpaceLogger redSpaceLogger = redSpaceComposerListener.f11750a;
                    String str = publishPostParams.privacy;
                    a = redSpaceLogger.b.a("redspace_composer_completed", false);
                    if (a.a()) {
                        a.a("redspace");
                        a.a("visibility", str);
                        a.b();
                    }
                }
            }
        }
        if (i2 == -1) {
            switch (i) {
                case 1756:
                    ((ComposerPublishServiceHelper) this.al.get()).c(intent);
                    Toast.makeText(getContext(), jW_().getString(2131234541), 0).show();
                    return;
                default:
                    super.a(i, i2, intent);
                    return;
            }
        }
    }

    public final String am_() {
        return "red_space_grid";
    }

    private void aD() {
        if (this.aU != null) {
            this.aU.a(aE());
            this.aP.setLayoutManager(this.aU);
            ((RedSpaceGridEqualSpacingDecorator) this.f11956g.get()).m12748b(this.aP);
        }
    }

    private int aE() {
        if (aF()) {
            return 1;
        }
        return m12391g(0);
    }

    private boolean aF() {
        return RedSpaceFriendsLayout.getLayout(this.aC) == RedSpaceFriendsLayout.LIST;
    }

    private int m12391g(int i) {
        return (int) ((i == 1 ? (float) this.ay.d() : (float) this.ay.c()) / jW_().getDimension(2131430560));
    }

    private void aG() {
        int a = this.aS.a(this.aG, 2);
        int a2 = this.aS.a(this.aH, 2);
        int a3 = this.aS.a(this.aZ, 0);
        int g = (m12391g(0) * m12391g(1)) * 2;
        RecycledViewPool recycledViewPool = this.aP.getRecycledViewPool();
        recycledViewPool.a(a, g);
        recycledViewPool.a(a2, g);
        recycledViewPool.a(a3, 1);
        this.aP.setRecycledViewPool(recycledViewPool);
    }

    public final boolean O_() {
        return aq();
    }

    public final boolean aq() {
        if (!ay()) {
            return false;
        }
        Fragment a = s().a(2131566872);
        if (a == null) {
            return false;
        }
        m12401a((RedSpaceSearchFragment) a);
        return true;
    }

    public Map<String, String> getDebugInfo() {
        if (this.aT == null) {
            return null;
        }
        return ((RedSpaceFriendsDebugWriter) this.aq.get()).m12365a(this.aT.q(), this.aT.r(), this.aS, this.az, this.aA, new FriendSectionDeterminator(this) {
            final /* synthetic */ RedSpaceHomeFragment f11940a;

            {
                this.f11940a = r1;
            }

            public final RedSpaceFriendsSection mo339a(int i) {
                return this.f11940a.aS.a(i) == this.f11940a.aG ? RedSpaceFriendsSection.TOP : RedSpaceFriendsSection.OTHERS;
            }
        }, (RedSpaceOptimisticBadgeStore) this.f11952b.get(), (RedSpaceTabUnseenCountFetcher) this.f11951a.get());
    }
}
