package com.facebook.redspace.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.bugreporter.activity.ActivityWithDebugInfo;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.util.MathUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.debug.log.BLog;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.ui.fullscreenvideoplayer.FullScreenVideoInflater;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.feedcontrollers.mutators.DeletePostSubscriber;
import com.facebook.feedcontrollers.mutators.FeedbackNotificationSubscriber;
import com.facebook.graphql.executor.GraphQLResult;
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
import com.facebook.redspace.adapter.RedSpaceUserCollectionAdapterProvider;
import com.facebook.redspace.adapter.RedSpaceUserMultiAdapter;
import com.facebook.redspace.adapter.RedSpaceUserSectionAdapterProvider;
import com.facebook.redspace.analytics.RedSpaceFriendViewListener;
import com.facebook.redspace.analytics.RedSpaceFriendViewListenerProvider;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsFetchResult;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.Params;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelper.RedSpaceFriendsFetchListener;
import com.facebook.redspace.data.RedSpaceFriendsFetcherHelperProvider;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.data.RedSpaceMutationsExecutor.SimpleFriendChangedSubscriber;
import com.facebook.redspace.data.RedSpaceMutator;
import com.facebook.redspace.data.RedSpaceSelfProfileDataStore;
import com.facebook.redspace.data.RedSpaceSelfProfileDataStore.State;
import com.facebook.redspace.data.RedSpaceStoryViewSubscriptionHelper;
import com.facebook.redspace.data.RedSpaceStoryViewSubscriptionHelperProvider;
import com.facebook.redspace.debug.RedSpaceFriendsDebugWriter;
import com.facebook.redspace.event.FriendsFetchEvent;
import com.facebook.redspace.event.RedSpaceEventBus;
import com.facebook.redspace.fetcher.RedSpaceViewerProfileFetcher;
import com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper;
import com.facebook.redspace.pagerindicator.SwipeImagePageIndicator;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceFeedVerticalScrollHelper.HasFeedScrollListener;
import com.facebook.redspace.ui.RedSpaceFeedVerticalScrollHelper.OnFeedScrolledListener;
import com.facebook.redspace.ui.animation.RedSpaceAnimations;
import com.facebook.redspace.ui.titlebar.RedSpaceUserTitleBar;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager.Listener;
import com.facebook.ui.statusbar.StatusBarUtil;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.video.channelfeed.ChannelFeedInflater;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SUCCESS */
public class RedSpaceUserActivity extends FbFragmentActivity implements AnalyticsActivity, ActivityWithDebugInfo, FullScreenVideoPlayerHost, RedSpaceFriendsFetchListener, HasFeedScrollListener, Listener {
    @Inject
    private FeedbackNotificationSubscriber f12389A;
    @Inject
    public RedSpaceFeedVerticalScrollHelper f12390B;
    @Inject
    private RedSpaceFriendsFetcherHelperProvider f12391C;
    @Inject
    private RedSpaceFriendViewListenerProvider f12392D;
    @Inject
    private RedSpaceStoryViewSubscriptionHelperProvider f12393E;
    @Inject
    private RedSpaceUserCollectionAdapterProvider f12394F;
    @Inject
    private RedSpaceUserSectionAdapterProvider f12395G;
    @Inject
    private StatusBarUtil f12396H;
    @Inject
    private QeAccessor f12397I;
    @Inject
    private FeedLoggingViewportEventListener f12398J;
    @Inject
    private ProfilePhotoSyncManager f12399K;
    private RedSpaceStoryViewSubscriptionHelper f12400L;
    public RedSpaceUserTitleBar f12401M;
    private ViewPager f12402N;
    private RedSpaceFriendViewListener f12403O;
    private RedSpaceUserMultiAdapter f12404P;
    private RedSpaceFriendsFetcherHelper f12405Q;
    public SwipeImagePageIndicator f12406R;
    private boolean f12407S;
    private boolean f12408T;
    private final OnFeedScrolledListener f12409U = new C14675(this);
    @Inject
    volatile Provider<RedSpaceAnimations> f12410p = UltralightRuntime.a;
    @Inject
    @Lazy
    @ForUiThread
    private com.facebook.inject.Lazy<ExecutorService> f12411q = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ChannelFeedInflater> f12412r = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerPublishServiceHelper> f12413s = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FullScreenVideoInflater> f12414t = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceEventBus> f12415u = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceViewerProfileHelper> f12416v = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceViewerProfileFetcher> f12417w = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceFriendsDebugWriter> f12418x = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> f12419y = UltralightRuntime.b;
    @Inject
    private DeletePostSubscriber f12420z;

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SUCCESS */
    class C14653 implements OnClickListener {
        final /* synthetic */ RedSpaceUserActivity f12386a;

        C14653(RedSpaceUserActivity redSpaceUserActivity) {
            this.f12386a = redSpaceUserActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 279140526);
            this.f12386a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1519577162, a);
        }
    }

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SUCCESS */
    class C14664 extends SimpleOnPageChangeListener {
        final /* synthetic */ RedSpaceUserActivity f12387a;

        C14664(RedSpaceUserActivity redSpaceUserActivity) {
            this.f12387a = redSpaceUserActivity;
        }

        public final void m12803a(int i, float f, int i2) {
            this.f12387a.f12401M.m12911a(i, f, i2);
        }

        public final void m12804b(int i) {
            this.f12387a.f12401M.setPageState(i);
        }

        public final void e_(int i) {
            this.f12387a.f12401M.setCurrentItem(i);
            this.f12387a.f12390B.m12734a(i);
            RedSpaceUserActivity.m12823p(this.f12387a);
        }
    }

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_SUCCESS */
    class C14675 extends OnFeedScrolledListener {
        final /* synthetic */ RedSpaceUserActivity f12388a;

        C14675(RedSpaceUserActivity redSpaceUserActivity) {
            this.f12388a = redSpaceUserActivity;
        }

        public final void mo347a(int i) {
            RedSpaceFeedVerticalScrollHelper redSpaceFeedVerticalScrollHelper = this.f12388a.f12390B;
            Preconditions.checkNotNull(redSpaceFeedVerticalScrollHelper.f12298a, "The indicator needs to be set up. Please call setIndicator(...) beforehand.");
            redSpaceFeedVerticalScrollHelper.f12298a.setTranslationY(Math.min(0.0f, Math.max(redSpaceFeedVerticalScrollHelper.f12298a.getTranslationY() - ((float) i), (float) (-redSpaceFeedVerticalScrollHelper.f12300c))));
            redSpaceFeedVerticalScrollHelper.f12298a.f12154f.setAlpha(Math.abs(1.0f - MathUtil.b(Math.abs(redSpaceFeedVerticalScrollHelper.f12298a.getTranslationY() / ((float) redSpaceFeedVerticalScrollHelper.f12301d)), 0.0f, 1.0f)));
        }
    }

    private static <T extends Context> void m12810a(Class<T> cls, T t) {
        m12811a((Object) t, (Context) t);
    }

    public static void m12811a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((RedSpaceUserActivity) obj).m12812a(IdBasedProvider.a(injectorLike, 10222), IdBasedSingletonScopeProvider.b(injectorLike, 3863), IdBasedLazy.a(injectorLike, 11586), IdBasedLazy.a(injectorLike, 5272), IdBasedLazy.a(injectorLike, 6077), IdBasedSingletonScopeProvider.b(injectorLike, 10183), IdBasedSingletonScopeProvider.b(injectorLike, 10189), IdBasedLazy.a(injectorLike, 10188), IdBasedLazy.a(injectorLike, 10180), IdBasedLazy.a(injectorLike, 10174), DeletePostSubscriber.a(injectorLike), FeedbackNotificationSubscriber.a(injectorLike), RedSpaceFeedVerticalScrollHelper.m12732a(injectorLike), (RedSpaceFriendsFetcherHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceFriendsFetcherHelperProvider.class), (RedSpaceFriendViewListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceFriendViewListenerProvider.class), (RedSpaceStoryViewSubscriptionHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceStoryViewSubscriptionHelperProvider.class), (RedSpaceUserCollectionAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceUserCollectionAdapterProvider.class), (RedSpaceUserSectionAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RedSpaceUserSectionAdapterProvider.class), StatusBarUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), ProfilePhotoSyncManager.a(injectorLike));
    }

    private void m12812a(Provider<RedSpaceAnimations> provider, com.facebook.inject.Lazy<ExecutorService> lazy, com.facebook.inject.Lazy<ChannelFeedInflater> lazy2, com.facebook.inject.Lazy<ComposerPublishServiceHelper> lazy3, com.facebook.inject.Lazy<FullScreenVideoInflater> lazy4, com.facebook.inject.Lazy<RedSpaceEventBus> lazy5, com.facebook.inject.Lazy<RedSpaceViewerProfileHelper> lazy6, com.facebook.inject.Lazy<RedSpaceViewerProfileFetcher> lazy7, com.facebook.inject.Lazy<RedSpaceFriendsDebugWriter> lazy8, com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> lazy9, DeletePostSubscriber deletePostSubscriber, FeedbackNotificationSubscriber feedbackNotificationSubscriber, RedSpaceFeedVerticalScrollHelper redSpaceFeedVerticalScrollHelper, RedSpaceFriendsFetcherHelperProvider redSpaceFriendsFetcherHelperProvider, RedSpaceFriendViewListenerProvider redSpaceFriendViewListenerProvider, RedSpaceStoryViewSubscriptionHelperProvider redSpaceStoryViewSubscriptionHelperProvider, RedSpaceUserCollectionAdapterProvider redSpaceUserCollectionAdapterProvider, RedSpaceUserSectionAdapterProvider redSpaceUserSectionAdapterProvider, StatusBarUtil statusBarUtil, QeAccessor qeAccessor, FeedLoggingViewportEventListener feedLoggingViewportEventListener, ProfilePhotoSyncManager profilePhotoSyncManager) {
        this.f12410p = provider;
        this.f12411q = lazy;
        this.f12412r = lazy2;
        this.f12413s = lazy3;
        this.f12414t = lazy4;
        this.f12415u = lazy5;
        this.f12416v = lazy6;
        this.f12417w = lazy7;
        this.f12418x = lazy8;
        this.f12419y = lazy9;
        this.f12420z = deletePostSubscriber;
        this.f12389A = feedbackNotificationSubscriber;
        this.f12390B = redSpaceFeedVerticalScrollHelper;
        this.f12391C = redSpaceFriendsFetcherHelperProvider;
        this.f12392D = redSpaceFriendViewListenerProvider;
        this.f12393E = redSpaceStoryViewSubscriptionHelperProvider;
        this.f12394F = redSpaceUserCollectionAdapterProvider;
        this.f12395G = redSpaceUserSectionAdapterProvider;
        this.f12396H = statusBarUtil;
        this.f12397I = qeAccessor;
        this.f12398J = feedLoggingViewportEventListener;
        this.f12399K = profilePhotoSyncManager;
    }

    public final void m12828b(Bundle bundle) {
        m12820i();
        Class cls = RedSpaceUserActivity.class;
        m12811a((Object) this, (Context) this);
        super.b(bundle);
        setContentView(2130906793);
        this.f12407S = bundle == null;
        Intent intent = getIntent();
        int c = m12821j() ? m12816c(intent) : m12813b(intent);
        m12815b(c);
        m12807a(this.f12404P);
        m12808a(this.f12404P, c);
        m12818d(c);
        m12822m();
        m12823p(this);
    }

    private void m12815b(int i) {
        String stringExtra = getIntent().getStringExtra("bundle_source");
        RedSpaceFriendViewListenerProvider redSpaceFriendViewListenerProvider = this.f12392D;
        RedSpaceFriendViewListener redSpaceFriendViewListener = new RedSpaceFriendViewListener(this.f12404P, stringExtra);
        String b = String_LoggedInUserIdMethodAutoProvider.b(redSpaceFriendViewListenerProvider);
        redSpaceFriendViewListener.f11751a = RedSpaceLogger.a(redSpaceFriendViewListenerProvider);
        redSpaceFriendViewListener.f11752b = b;
        this.f12403O = redSpaceFriendViewListener;
        this.f12403O.m12191c(i);
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 708826287);
        this.f12398J.a("redspace");
        this.f12399K.a(this);
        super.onStart();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1989516446, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1502276860);
        super.onStop();
        this.f12398J.a("unknown");
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 561040904, a);
    }

    private void m12820i() {
        if (VERSION.SDK_INT >= 19) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.setFlags(67108864, 67108864);
        }
    }

    private int m12813b(Intent intent) {
        RedSpaceFriendsCollection redSpaceFriendsCollection = (RedSpaceFriendsCollection) intent.getParcelableExtra("bundle_collection_top");
        RedSpaceFriendsCollection redSpaceFriendsCollection2 = (RedSpaceFriendsCollection) intent.getParcelableExtra("bundle_collection_others");
        ((RedSpaceSelfProfileDataStore) this.f12419y.get()).m12320a((State) intent.getParcelableExtra("bundle_collection_self"));
        String stringExtra = intent.getStringExtra("bundle_selected_profile_id");
        RedSpaceFriendsFetcherHelperProvider redSpaceFriendsFetcherHelperProvider = this.f12391C;
        ImmutableList of = ImmutableList.of(new Pair(RedSpaceFriendsSection.TOP, redSpaceFriendsCollection), new Pair(RedSpaceFriendsSection.OTHERS, redSpaceFriendsCollection2));
        Params params = new Params();
        params.f11789a = true;
        this.f12405Q = redSpaceFriendsFetcherHelperProvider.m12235a(this, of, params);
        this.f12404P = new RedSpaceUserMultiAdapter(kO_(), this.f12394F.m12174a(r4, ((RedSpaceSelfProfileDataStore) this.f12419y.get()).f11871a, this.f12390B.f12302e), this.f12395G.m12187a(r4, RedSpaceFriendsSection.TOP, redSpaceFriendsCollection, this.f12390B.f12302e), this.f12395G.m12187a(kO_(), RedSpaceFriendsSection.OTHERS, redSpaceFriendsCollection2, this.f12390B.f12302e));
        this.f12400L = this.f12393E.m12322a(ImmutableList.of(redSpaceFriendsCollection, redSpaceFriendsCollection2), this.f12404P);
        m12809a(((RedSpaceSelfProfileDataStore) this.f12419y.get()).f11871a);
        return this.f12404P.m12178a(stringExtra);
    }

    private void m12809a(final RedSpaceFriendsCollection redSpaceFriendsCollection) {
        if (!RedSpaceViewerProfileHelper.a(redSpaceFriendsCollection.m12213a(0))) {
            RedSpaceViewerProfileFetcher redSpaceViewerProfileFetcher = (RedSpaceViewerProfileFetcher) this.f12417w.get();
            Futures.a(redSpaceViewerProfileFetcher.b.a(redSpaceViewerProfileFetcher.c.a(redSpaceViewerProfileFetcher.a)), new FutureCallback<GraphQLResult<RedSpaceFeedProfileFragmentModel>>(this) {
                final /* synthetic */ RedSpaceUserActivity f12385b;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (graphQLResult == null || graphQLResult.e == null) {
                        onFailure(new NullPointerException("Null result"));
                        return;
                    }
                    redSpaceFriendsCollection.m12217a(RedSpaceMutator.m12291a((RedSpaceFeedProfileFragmentModel) graphQLResult.e));
                    if (this.f12385b.f12406R != null) {
                        this.f12385b.f12406R.m12600a();
                    }
                }

                public void onFailure(Throwable th) {
                    BLog.b(getClass(), "Failed to fetch viewer profile", th);
                }
            }, (Executor) this.f12411q.get());
        }
    }

    private int m12816c(Intent intent) {
        RedSpaceFriendsCollection redSpaceFriendsCollection = (RedSpaceFriendsCollection) intent.getParcelableExtra("bundle_collection_single");
        this.f12404P = new RedSpaceUserMultiAdapter(kO_(), this.f12394F.m12174a(kO_(), redSpaceFriendsCollection, this.f12390B.f12302e));
        this.f12400L = this.f12393E.m12322a(ImmutableList.of(redSpaceFriendsCollection), this.f12404P);
        this.f12408T = true;
        return 0;
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1809265648);
        if (this.f12400L != null) {
            SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = this.f12400L;
            simpleFriendChangedSubscriber.f11875a.m12289b(simpleFriendChangedSubscriber);
        }
        if (this.f12405Q != null) {
            this.f12405Q.m12233d();
        }
        if (this.f12420z != null) {
            DeletePostSubscriber deletePostSubscriber = this.f12420z;
            deletePostSubscriber.c.b(deletePostSubscriber.b);
        }
        if (this.f12389A != null) {
            FeedbackNotificationSubscriber feedbackNotificationSubscriber = this.f12389A;
            feedbackNotificationSubscriber.a.b(feedbackNotificationSubscriber.c);
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1198540984, a);
    }

    public void onBackPressed() {
        if (!m12832k().b()) {
            super.onBackPressed();
        }
    }

    private boolean m12821j() {
        return getIntent().hasExtra("bundle_collection_single");
    }

    private void m12807a(RedSpaceUserMultiAdapter redSpaceUserMultiAdapter) {
        this.f12402N = (ViewPager) a(2131566892);
        this.f12402N.setAdapter(redSpaceUserMultiAdapter);
        this.f12402N.setOffscreenPageLimit(this.f12407S ? 0 : 1);
    }

    private void m12808a(RedSpaceUserMultiAdapter redSpaceUserMultiAdapter, int i) {
        this.f12401M = (RedSpaceUserTitleBar) a(2131566894);
        if (VERSION.SDK_INT >= 19) {
            LayoutParams layoutParams = (LayoutParams) this.f12401M.getLayoutParams();
            layoutParams.topMargin = this.f12396H.a(null);
            this.f12401M.setLayoutParams(layoutParams);
        }
        this.f12401M.setAdapter(redSpaceUserMultiAdapter);
        this.f12401M.setCurrentItem(i);
        if (m12821j() || RedSpaceFriendsLayout.getLayout(this.f12397I) == RedSpaceFriendsLayout.LIST) {
            this.f12401M.setBackButtonGlyph(2130838002);
        }
        this.f12401M.setOnBackButtonClickListener(new C14653(this));
    }

    private void m12818d(int i) {
        this.f12406R = (SwipeImagePageIndicator) a(2131566893);
        this.f12390B.f12298a = this.f12406R;
        this.f12406R.m12602a(new C14664(this));
        this.f12406R.m12603a(this.f12402N, i);
        this.f12406R.m12600a();
        if (i == 0) {
            this.f12406R.e_(i);
        }
        this.f12406R.m12602a(this.f12403O);
    }

    private void m12822m() {
        DeletePostSubscriber deletePostSubscriber = this.f12420z;
        deletePostSubscriber.c.a(deletePostSubscriber.b);
        FeedbackNotificationSubscriber feedbackNotificationSubscriber = this.f12389A;
        feedbackNotificationSubscriber.a.a(feedbackNotificationSubscriber.c);
    }

    public final OnFeedScrolledListener mo348c() {
        return this.f12409U;
    }

    public final void mo349d() {
        this.f12390B.m12735b();
    }

    public final void mo343a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection) {
    }

    public final void mo344a(RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsFetchResult redSpaceFriendsFetchResult) {
        this.f12404P.kR_();
        ((RedSpaceEventBus) this.f12415u.get()).a(new FriendsFetchEvent(redSpaceFriendsSection, redSpaceFriendsFetchResult));
        m12823p(this);
    }

    public final void a_(Throwable th) {
    }

    public static void m12823p(RedSpaceUserActivity redSpaceUserActivity) {
        if (redSpaceUserActivity.f12405Q != null && redSpaceUserActivity.m12824q()) {
            redSpaceUserActivity.f12405Q.m12231a();
        }
    }

    private boolean m12824q() {
        return this.f12402N.k > this.f12404P.b() + -5;
    }

    public final boolean m12831h() {
        return m12832k().a();
    }

    public final ImmersiveVideoPlayer m12833l() {
        return ((ChannelFeedInflater) this.f12412r.get()).a(this);
    }

    public final ImmersiveVideoPlayer m12832k() {
        return ((FullScreenVideoInflater) this.f12414t.get()).a(this);
    }

    public final ImmersiveVideoPlayer m12834n() {
        return null;
    }

    public final boolean m12835o() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1756:
                case 1758:
                    ((ComposerPublishServiceHelper) this.f12413s.get()).c(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final String am_() {
        return "red_space_friend";
    }

    public Map<String, String> getDebugInfo() {
        if (this.f12402N == null || this.f12404P == null) {
            return null;
        }
        Fragment fragment;
        int i = this.f12402N.k;
        Builder builder = ImmutableMap.builder();
        builder.b("Friend", ((RedSpaceFriendsDebugWriter) this.f12418x.get()).m12364a(this.f12404P.m12186g(i)));
        WeakReference weakReference = (WeakReference) this.f12404P.f11748b.get(i);
        if (weakReference == null) {
            fragment = null;
        } else {
            fragment = (Fragment) weakReference.get();
        }
        Fragment fragment2 = fragment;
        if (fragment2 instanceof FragmentWithDebugInfo) {
            builder.a(((FragmentWithDebugInfo) fragment2).getDebugInfo());
        }
        return builder.b();
    }

    public final void m12825a() {
        this.f12404P.kR_();
    }
}
