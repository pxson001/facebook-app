package com.facebook.goodwill.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.feed.data.FeedUnitSubscriber;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.basefeedfragment.BaseFeedFragment;
import com.facebook.feedcontrollers.FeedDeletePostController;
import com.facebook.feedcontrollers.FeedStoryVisibilityController;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger.Events;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger.SubscriptionSource;
import com.facebook.goodwill.analytics.GoodwillPerformanceLogger;
import com.facebook.goodwill.feed.data.ThrowbackFeedPager;
import com.facebook.goodwill.feed.data.ThrowbackFeedPager.C29981;
import com.facebook.goodwill.feed.data.ThrowbackFeedPager.LoadStoriesCallback;
import com.facebook.goodwill.feed.data.ThrowbackFeedPager.Task;
import com.facebook.goodwill.feed.data.ThrowbackFeedPagerProtocol;
import com.facebook.goodwill.feed.data.ThrowbackFeedResources;
import com.facebook.goodwill.feed.data.ThrowbackSettingsManager;
import com.facebook.goodwill.feed.data.ThrowbackSettingsManager.SubmitSubscriptionListener;
import com.facebook.goodwill.feed.data.ThrowbackSettingsManager.ThrowbackSubscriptionStatus;
import com.facebook.goodwill.feed.rows.ThrowbackFeedRootGroupPartDefinition;
import com.facebook.graphql.calls.ThrowbackSettingsEditInputData.SubscriptionStatus;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tablet.abtest.SideshowCompatibleContainer;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.widget.bottomsheet.DescriptiveBottomSheetAdapter;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: VIEW_MORE_INLINE */
public class ThrowbackFeedFragment extends BaseFeedFragment implements AnalyticsFragment, SideshowCompatibleContainer {
    @Inject
    public ThrowbackFeedPager f21200a;
    private View aA;
    public LoadingIndicatorView aB;
    public ScrollingViewProxy aC;
    private FeedOnDataChangeListener aD;
    public View aE;
    public View aF;
    public ThrowbackNUXView aG;
    public final SubmitSubscriptionListener aH = new C30071(this);
    @Inject
    GoodwillPerformanceLogger al;
    @Inject
    @ForUiThread
    public Provider<Executor> am;
    @Inject
    ErrorDialogs an;
    @Inject
    MultiRowAdapterBuilder ao;
    @Inject
    Lazy<ThrowbackFeedRootGroupPartDefinition> ap;
    @Inject
    Lazy<DumpsysDumper> aq;
    @Inject
    ThrowbackFeedEnvironmentProvider ar;
    @Inject
    public Provider<BottomSheetDialog> as;
    @Inject
    GatekeeperStoreImpl at;
    @Inject
    SecureContextHelper au;
    @Inject
    public GlyphColorizer av;
    @Inject
    public QeAccessor aw;
    private MultiRowAdapter ax;
    public ThrowbackFeedHeaderView ay;
    public View az;
    @Inject
    ThrowbackFeedPagerProtocol f21201b;
    @Inject
    MultipleRowsStoriesRecycleCallback f21202c;
    @Inject
    FeedUnitSubscriber f21203d;
    @Inject
    public FeedDeletePostController f21204e;
    @Inject
    public FeedStoryVisibilityController f21205f;
    @Inject
    public ThrowbackSettingsManager f21206g;
    @Inject
    Lazy<ComposerPublishServiceHelper> f21207h;
    @Inject
    public GoodwillAnalyticsLogger f21208i;

    /* compiled from: VIEW_MORE_INLINE */
    class C30071 implements SubmitSubscriptionListener {
        final /* synthetic */ ThrowbackFeedFragment f21189a;

        C30071(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21189a = throwbackFeedFragment;
        }

        public final void mo950a() {
            this.f21189a.f21206g.f21120g = ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_ALL;
            this.f21189a.f21208i.a(SubscriptionSource.THROWBACK_FEED_NUX_MEGAPHONE, true);
            if (this.f21189a.mx_()) {
                this.f21189a.ay.m22149a();
            }
        }

        public final void mo951b() {
            ThrowbackFeedFragment.aw(this.f21189a);
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30082 extends OnToolbarButtonListener {
        final /* synthetic */ ThrowbackFeedFragment f21191a;

        public C30082(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21191a = throwbackFeedFragment;
        }

        public final void m22128a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f21191a.at.a(859, false)) {
                ThrowbackFeedFragment throwbackFeedFragment = this.f21191a;
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) throwbackFeedFragment.as.get();
                BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(bottomSheetDialog.getContext());
                bottomSheetAdapter.e(2131239678).setIcon(throwbackFeedFragment.av.a(2130839905, -8421505)).setOnMenuItemClickListener(new C30158(throwbackFeedFragment));
                bottomSheetAdapter.e(2131239679).setIcon(throwbackFeedFragment.av.a(2130839961, -8421505)).setOnMenuItemClickListener(new C30169(throwbackFeedFragment));
                bottomSheetDialog.a(bottomSheetAdapter);
                bottomSheetDialog.show();
            } else if (this.f21191a.f21206g.m22070f()) {
                ThrowbackFeedFragment.az(this.f21191a);
            } else {
                ThrowbackFeedFragment.aA(this.f21191a);
            }
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30093 implements OnClickListener {
        final /* synthetic */ ThrowbackFeedFragment f21192a;

        public C30093(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21192a = throwbackFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 371814587);
            this.f21192a.f21206g.m22066a(true, this.f21192a.aH);
            Logger.a(2, EntryType.UI_INPUT_END, -1499462094, a);
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30104 implements OnDismissListener {
        final /* synthetic */ ThrowbackFeedFragment f21193a;

        public C30104(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21193a = throwbackFeedFragment;
        }

        public final void m22129a(Megaphone megaphone) {
            this.f21193a.ay.m22149a();
            this.f21193a.f21206g.m22067b();
            this.f21193a.f21208i.a(Events.THROWBACK_NOTIFICATION_MEGAPHONE_DISMISSED);
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30115 implements OnClickListener {
        final /* synthetic */ ThrowbackFeedFragment f21194a;

        public C30115(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21194a = throwbackFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -963879324);
            this.f21194a.f21206g.m22066a(true, this.f21194a.aH);
            Logger.a(2, EntryType.UI_INPUT_END, -1628624195, a);
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30126 implements ThrowbackMegaphone.OnDismissListener {
        final /* synthetic */ ThrowbackFeedFragment f21195a;

        public C30126(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21195a = throwbackFeedFragment;
        }

        public final void mo952a() {
            this.f21195a.ay.m22149a();
            this.f21195a.f21206g.m22067b();
            this.f21195a.f21208i.a(Events.THROWBACK_NOTIFICATION_MEGAPHONE_DISMISSED);
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30147 implements OnClickListener {
        final /* synthetic */ ThrowbackFeedFragment f21197a;

        /* compiled from: VIEW_MORE_INLINE */
        class C30131 implements SubmitSubscriptionListener {
            final /* synthetic */ C30147 f21196a;

            C30131(C30147 c30147) {
                this.f21196a = c30147;
            }

            public final void mo950a() {
                this.f21196a.f21197a.f21206g.f21120g = ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_ALL;
                this.f21196a.f21197a.f21208i.a(SubscriptionSource.THROWBACK_FEED_EMPTY_STATE, true);
                this.f21196a.f21197a.f21200a.m22035f();
            }

            public final void mo951b() {
                ThrowbackFeedFragment.aw(this.f21196a.f21197a);
            }
        }

        public C30147(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21197a = throwbackFeedFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1858399336);
            this.f21197a.aG.m22156a();
            this.f21197a.f21206g.m22066a(true, new C30131(this));
            Logger.a(2, EntryType.UI_INPUT_END, -1064759934, a);
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30158 implements OnMenuItemClickListener {
        final /* synthetic */ ThrowbackFeedFragment f21198a;

        public C30158(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21198a = throwbackFeedFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ThrowbackFeedFragment.aA(this.f21198a);
            return true;
        }
    }

    /* compiled from: VIEW_MORE_INLINE */
    public class C30169 implements OnMenuItemClickListener {
        final /* synthetic */ ThrowbackFeedFragment f21199a;

        public C30169(ThrowbackFeedFragment throwbackFeedFragment) {
            this.f21199a = throwbackFeedFragment;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f21199a.au.a(new Intent().setAction("android.intent.action.VIEW").setData(Uri.parse(FBLinks.et)), 1, this.f21199a);
            return true;
        }
    }

    public static void m22137a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThrowbackFeedFragment) obj).m22135a(ThrowbackFeedPager.m22029a(fbInjector), ThrowbackFeedPagerProtocol.m22037a(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), FeedUnitSubscriber.a(fbInjector), FeedDeletePostController.a(fbInjector), FeedStoryVisibilityController.a(fbInjector), ThrowbackSettingsManager.m22064a(fbInjector), IdBasedLazy.a(fbInjector, 5272), GoodwillAnalyticsLogger.a(fbInjector), GoodwillPerformanceLogger.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 3863), ErrorDialogs.a(fbInjector), MultiRowAdapterBuilder.a(fbInjector), IdBasedLazy.a(fbInjector, 6827), IdBasedSingletonScopeProvider.b(fbInjector, 5454), (ThrowbackFeedEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ThrowbackFeedEnvironmentProvider.class), IdBasedProvider.a(fbInjector, 11752), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), GlyphColorizer.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m22135a(ThrowbackFeedPager throwbackFeedPager, ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, FeedUnitSubscriber feedUnitSubscriber, FeedDeletePostController feedDeletePostController, FeedStoryVisibilityController feedStoryVisibilityController, ThrowbackSettingsManager throwbackSettingsManager, Lazy<ComposerPublishServiceHelper> lazy, GoodwillAnalyticsLogger goodwillAnalyticsLogger, GoodwillPerformanceLogger goodwillPerformanceLogger, Provider<Executor> provider, ErrorDialogs errorDialogs, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<ThrowbackFeedRootGroupPartDefinition> lazy2, Lazy<DumpsysDumper> lazy3, ThrowbackFeedEnvironmentProvider throwbackFeedEnvironmentProvider, Provider<BottomSheetDialog> provider2, GatekeeperStore gatekeeperStore, SecureContextHelper secureContextHelper, GlyphColorizer glyphColorizer, QeAccessor qeAccessor) {
        this.f21200a = throwbackFeedPager;
        this.f21201b = throwbackFeedPagerProtocol;
        this.f21202c = multipleRowsStoriesRecycleCallback;
        this.f21203d = feedUnitSubscriber;
        this.f21204e = feedDeletePostController;
        this.f21205f = feedStoryVisibilityController;
        this.f21206g = throwbackSettingsManager;
        this.f21207h = lazy;
        this.f21208i = goodwillAnalyticsLogger;
        this.al = goodwillPerformanceLogger;
        this.am = provider;
        this.an = errorDialogs;
        this.ao = multiRowAdapterBuilder;
        this.ap = lazy2;
        this.aq = lazy3;
        this.ar = throwbackFeedEnvironmentProvider;
        this.as = provider2;
        this.at = gatekeeperStore;
        this.au = secureContextHelper;
        this.av = glyphColorizer;
        this.aw = qeAccessor;
    }

    public final void m22144c(Bundle bundle) {
        Class cls = ThrowbackFeedFragment.class;
        m22137a((Object) this, getContext());
        super.c(bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aC(this).notifyDataSetChanged();
        m22134a(LayoutInflater.from(getContext()), (ViewGroup) this.T);
    }

    public final View m22141a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1504732980);
        LayoutInflater from = LayoutInflater.from(getContext());
        SequenceLoggerDetour.a(this.al.b.a(GoodwillPerformanceLogger.a), "ThrowbackFeedViewCreation", -642249225);
        this.ay = new ThrowbackFeedHeaderView(getContext());
        this.az = from.inflate(2130907412, null, false);
        this.aA = from.inflate(2130907421, null, false);
        ViewGroup frameLayout = new FrameLayout(getContext());
        m22134a(from, frameLayout);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1726159501, a);
        return frameLayout;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1811923283);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239654);
            hasTitleBar.c(true);
            if (this.aw.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForThrowbackFeedUiModule.f21123a, true)) {
                String b = b(2131239655);
                Builder a2 = TitleBarButtonSpec.a();
                a2.j = b;
                Builder builder = a2;
                builder.i = 2130838001;
                hasTitleBar.a(builder.a());
                hasTitleBar.a(new C30082(this));
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1943963611, a);
    }

    private void m22134a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        viewGroup.removeAllViewsInLayout();
        View inflate = layoutInflater.inflate(2130904610, viewGroup);
        this.aG = (ThrowbackNUXView) inflate.findViewById(2131562580);
        this.aF = layoutInflater.inflate(2130907403, null, false);
        this.ay.setVisibility(8);
        ThrowbackFeedHeaderView throwbackFeedHeaderView = this.ay;
        OnClickListener c30093 = new C30093(this);
        C30104 c30104 = new C30104(this);
        throwbackFeedHeaderView.f21216f.setOnPrimaryButtonClickListener(c30093);
        throwbackFeedHeaderView.f21216f.setShowSecondaryButton(false);
        throwbackFeedHeaderView.f21216f.setOnSecondaryButtonClickListener(null);
        throwbackFeedHeaderView.f21216f.m = c30104;
        throwbackFeedHeaderView = this.ay;
        c30093 = new C30115(this);
        ThrowbackMegaphone.OnDismissListener c30126 = new C30126(this);
        throwbackFeedHeaderView.f21217g.setOnPrimaryButtonClickListener(c30093);
        throwbackFeedHeaderView.f21217g.f21234g = c30126;
        this.aG.setNotificationButtonListener(new C30147(this));
        this.aE = inflate.findViewById(2131562581);
        this.aE.setVisibility(8);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) inflate.findViewById(2131562578);
        BetterListView betterListView = (BetterListView) inflate.findViewById(2131562579);
        if (aL()) {
            betterRecyclerView.setVisibility(0);
            betterListView.setVisibility(8);
            betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
            this.aC = new RecyclerViewProxy(betterRecyclerView);
        } else {
            betterRecyclerView.setVisibility(8);
            betterListView.setVisibility(0);
            this.aC = new ListViewProxy(betterListView);
        }
        this.aC.k();
        this.aC.b(false);
        this.aC.d(true);
        this.aC.e(this.az);
        this.aB = (LoadingIndicatorView) this.az.findViewById(2131567877);
        aE();
        aI();
        m22138a(true, this.aB);
        this.al.b();
        aK();
    }

    public final ContentFragmentType m22145d() {
        return ContentFragmentType.THROWBACK_FEED_FRAGMENT;
    }

    public static void aw(ThrowbackFeedFragment throwbackFeedFragment) {
        if (throwbackFeedFragment.mx_()) {
            throwbackFeedFragment.an.a(ErrorDialogParams.a(throwbackFeedFragment.jW_()).a(2131239672).b(2131239673).l());
        }
    }

    public static void az(ThrowbackFeedFragment throwbackFeedFragment) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) throwbackFeedFragment.as.get();
        DescriptiveBottomSheetAdapter descriptiveBottomSheetAdapter = new DescriptiveBottomSheetAdapter(bottomSheetDialog.getContext());
        MenuItemImpl a = descriptiveBottomSheetAdapter.a("");
        if (throwbackFeedFragment.f21206g.f21120g == ThrowbackSubscriptionStatus.STATUS_UNSUBSCRIBED) {
            a.a(2131239665);
            a.setTitle(2131239668);
        } else {
            if (throwbackFeedFragment.f21206g.f21120g == ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_HIGHLIGHTS) {
                a.a(2131239667);
                descriptiveBottomSheetAdapter.e(2131239669).setIcon(2130839905).setOnMenuItemClickListener(new OnMenuItemClickListener(throwbackFeedFragment) {
                    final /* synthetic */ ThrowbackFeedFragment f21178a;

                    {
                        this.f21178a = r1;
                    }

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        ThrowbackFeedFragment.m22136a(this.f21178a, true);
                        return true;
                    }
                });
            } else {
                a.a(2131239666);
            }
            descriptiveBottomSheetAdapter.e(2131239670).setIcon(2130839920).setOnMenuItemClickListener(new OnMenuItemClickListener(throwbackFeedFragment) {
                final /* synthetic */ ThrowbackFeedFragment f21179a;

                {
                    this.f21179a = r1;
                }

                public boolean onMenuItemClick(MenuItem menuItem) {
                    ThrowbackFeedFragment.m22136a(this.f21179a, false);
                    return true;
                }
            });
        }
        bottomSheetDialog.a(descriptiveBottomSheetAdapter);
        bottomSheetDialog.show();
    }

    public static void m22136a(ThrowbackFeedFragment throwbackFeedFragment, final boolean z) {
        throwbackFeedFragment.f21206g.m22066a(z, new SubmitSubscriptionListener(throwbackFeedFragment) {
            final /* synthetic */ ThrowbackFeedFragment f21181b;

            public final void mo950a() {
                ThrowbackSubscriptionStatus throwbackSubscriptionStatus;
                ThrowbackSettingsManager throwbackSettingsManager = this.f21181b.f21206g;
                if (z) {
                    throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_ALL;
                } else {
                    throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_UNSUBSCRIBED;
                }
                throwbackSettingsManager.f21120g = throwbackSubscriptionStatus;
                if (ThrowbackFeedFragment.aC(this.f21181b).getCount() == 0) {
                    this.f21181b.f21200a.m22035f();
                }
                this.f21181b.f21208i.a(SubscriptionSource.THROWBACK_FEED_MENU, z);
                if (this.f21181b.mx_() && !this.f21181b.f21206g.m22069e()) {
                    this.f21181b.f21206g.m22067b();
                }
            }

            public final void mo951b() {
                ThrowbackFeedFragment.aw(this.f21181b);
            }
        });
    }

    public static void aA(ThrowbackFeedFragment throwbackFeedFragment) {
        View view = throwbackFeedFragment.aA;
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        AlertDialog a = new FbAlertDialogBuilder(throwbackFeedFragment.o()).a(2131239663, new DialogInterface.OnClickListener(throwbackFeedFragment) {
            final /* synthetic */ ThrowbackFeedFragment f21182a;

            {
                this.f21182a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                boolean isChecked = ThrowbackFeedFragment.aB(this.f21182a).isChecked();
                if (isChecked != this.f21182a.f21206g.m22069e()) {
                    ThrowbackFeedFragment.m22136a(this.f21182a, isChecked);
                }
            }
        }).a();
        a.a(throwbackFeedFragment.aA);
        aB(throwbackFeedFragment).setChecked(throwbackFeedFragment.f21206g.m22069e());
        a.show();
    }

    private void aK() {
        String string = this.s.getString("source");
        String string2 = this.s.getString("campaign_id");
        String string3 = this.s.getString("story_id");
        GoodwillAnalyticsLogger goodwillAnalyticsLogger = this.f21208i;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Events.THROWBACK_PERMALINK_VIEW.name);
        honeyClientEvent.c = "goodwill";
        HoneyAnalyticsEvent b = honeyClientEvent.b("source", string);
        if (!(string3 == null || string3.equals("none"))) {
            b = b.b("story_id", string3);
        }
        if (!(string3 == null || string2.equals("none"))) {
            b = b.b("campaign_id", string2);
        }
        goodwillAnalyticsLogger.a.a(b);
    }

    public static CheckBox aB(ThrowbackFeedFragment throwbackFeedFragment) {
        return (CheckBox) throwbackFeedFragment.aA.findViewById(2131567896);
    }

    public final void m22142a(int i, int i2, Intent intent) {
        if (i == 1) {
            m22146e();
        }
        if (i2 == -1) {
            switch (i) {
                case 1756:
                case 1758:
                    ListenableFuture c = ((ComposerPublishServiceHelper) this.f21207h.get()).c(intent);
                    if (!intent.getBooleanExtra("is_uploading_media", false)) {
                        Futures.a(c, new FutureCallback<OperationResult>(this) {
                            final /* synthetic */ ThrowbackFeedFragment f21183a;

                            {
                                this.f21183a = r1;
                            }

                            public void onSuccess(Object obj) {
                                this.f21183a.m22146e();
                            }

                            public void onFailure(Throwable th) {
                            }
                        }, (Executor) this.am.get());
                        return;
                    }
                    return;
                case 1856:
                    m22146e();
                    return;
                default:
                    return;
            }
        }
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -61667385);
        super.dE_();
        this.f21200a.f21058c.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2016351728, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1111228049);
        super.mY_();
        if (this.ax != null) {
            this.ax.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1945709120, a);
    }

    public final void m22140I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1810899478);
        super.I();
        this.ax.jc_();
        this.f21200a.m22036h();
        this.f21203d.e();
        this.f21204e.a();
        this.f21205f.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2016003477, a);
    }

    protected final void aq() {
        super.aq();
        this.f21203d.d();
    }

    public final void m22146e() {
        this.f21200a.clearUserData();
        this.aC.f(null);
        this.aC.b(this.aF);
        this.aC.e(this.az);
        this.ay.setVisibility(8);
        this.aG.setVisibility(8);
        aC(this).notifyDataSetChanged();
        this.f21200a.m22034e();
    }

    public final String am_() {
        return "goodwill_throwback";
    }

    public static MultiRowAdapter aC(ThrowbackFeedFragment throwbackFeedFragment) {
        if (throwbackFeedFragment.ax == null) {
            ThrowbackFeedEnvironmentProvider throwbackFeedEnvironmentProvider = throwbackFeedFragment.ar;
            Context context = throwbackFeedFragment.getContext();
            ThrowbackFeedListType throwbackFeedListType = ThrowbackFeedListType.f21225a;
            AnonymousClass15 anonymousClass15 = new Runnable(throwbackFeedFragment) {
                final /* synthetic */ ThrowbackFeedFragment f21184a;

                {
                    this.f21184a = r1;
                }

                public void run() {
                    ThrowbackFeedFragment.aC(this.f21184a).notifyDataSetChanged();
                }
            };
            AnyEnvironment throwbackFeedEnvironment = new ThrowbackFeedEnvironment(context, throwbackFeedListType, anonymousClass15, HasScrollListenerSupportImpl.a(throwbackFeedFragment.aC), new ThrowbackFeedMenuProvider((ThrowbackStoryMenuHelperProvider) throwbackFeedEnvironmentProvider.getOnDemandAssistedProviderForStaticDi(ThrowbackStoryMenuHelperProvider.class)));
            MultiRowAdapterBuilder.Builder a = throwbackFeedFragment.ao.a(throwbackFeedFragment.ap, throwbackFeedFragment.aD());
            a.f = throwbackFeedEnvironment;
            throwbackFeedFragment.ax = a.e();
        }
        return throwbackFeedFragment.ax;
    }

    private FeedUnitCollection aD() {
        return this.f21200a.f21057b;
    }

    public static void m22139b(ThrowbackFeedFragment throwbackFeedFragment, boolean z) {
        if (z) {
            ThrowbackSubscriptionStatus throwbackSubscriptionStatus;
            CallerContext a = CallerContext.a(throwbackFeedFragment.getClass(), "goodwill_throwback");
            throwbackFeedFragment.ay.f21224n = throwbackFeedFragment.f21200a.f21062g;
            throwbackFeedFragment.ay.m22150a(throwbackFeedFragment.f21200a.f21060e, a);
            View view = throwbackFeedFragment.aF;
            ThrowbackFeedResources throwbackFeedResources = throwbackFeedFragment.f21200a.f21060e;
            FbDraweeView fbDraweeView;
            if ("standard".equals(throwbackFeedResources.f21096n)) {
                fbDraweeView = (FbDraweeView) view.findViewById(2131567865);
                fbDraweeView.setVisibility(0);
                fbDraweeView.a(ImageUtil.a(throwbackFeedResources.f21086d), a);
            } else if ("ipb_v1".equals(throwbackFeedResources.f21096n) && throwbackFeedResources.f21095m != null && throwbackFeedResources.f21095m.size() >= 2) {
                int dimensionPixelSize = throwbackFeedFragment.jW_().getDimensionPixelSize(2131433070);
                fbDraweeView = (FbDraweeView) view.findViewById(2131567867);
                fbDraweeView.setVisibility(0);
                fbDraweeView.setImageURI(Uri.parse((String) throwbackFeedResources.f21095m.get(throwbackFeedResources.f21095m.size() - 1)));
                fbDraweeView.getLayoutParams().width = dimensionPixelSize;
                fbDraweeView.getLayoutParams().height = dimensionPixelSize;
                fbDraweeView.setRotation(-10.0f);
                FbDraweeView fbDraweeView2 = (FbDraweeView) view.findViewById(2131567868);
                fbDraweeView2.setVisibility(0);
                fbDraweeView2.setImageURI(Uri.parse((String) throwbackFeedResources.f21095m.get(throwbackFeedResources.f21095m.size() - 2)));
                fbDraweeView2.getLayoutParams().width = dimensionPixelSize;
                fbDraweeView2.getLayoutParams().height = dimensionPixelSize;
                fbDraweeView2.setRotation(35.0f);
                fbDraweeView2.invalidate();
                fbDraweeView.invalidate();
            }
            ((TextView) view.findViewById(2131567866)).setText(throwbackFeedResources.f21087e);
            ThrowbackSettingsManager throwbackSettingsManager = throwbackFeedFragment.f21206g;
            String str = throwbackFeedFragment.f21200a.f21060e.f21094l;
            if (str == null) {
                if (throwbackSettingsManager.m22070f()) {
                    throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_HIGHLIGHTS;
                } else {
                    throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_UNSUBSCRIBED;
                }
            } else if (str.equalsIgnoreCase(SubscriptionStatus.UNSUBSCRIBED.toString())) {
                throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_UNSUBSCRIBED;
            } else if (str.equalsIgnoreCase(SubscriptionStatus.SUBSCRIBED_ALL.toString())) {
                throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_ALL;
            } else if (str.equalsIgnoreCase(SubscriptionStatus.SUBSCRIBED_HIGHLIGHTS.toString())) {
                throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_SUBSCRIBED_HIGHLIGHTS;
            } else {
                throwbackSubscriptionStatus = ThrowbackSubscriptionStatus.STATUS_UNKNOW;
            }
            throwbackSettingsManager.f21120g = throwbackSubscriptionStatus;
        }
        aC(throwbackFeedFragment).notifyDataSetChanged();
        throwbackFeedFragment.f21203d.a(throwbackFeedFragment.aD());
        if (aC(throwbackFeedFragment).getCount() > 0) {
            ThrowbackFeedHeaderView throwbackFeedHeaderView = throwbackFeedFragment.ay;
            boolean z2 = !throwbackFeedFragment.f21206g.m22069e() && throwbackFeedFragment.f21206g.m22068c();
            throwbackFeedHeaderView.m22151a(z2);
        } else {
            throwbackFeedFragment.aG.m22157a(throwbackFeedFragment.f21200a.f21060e, throwbackFeedFragment.f21206g.m22069e());
            throwbackFeedFragment.aC.f(throwbackFeedFragment.aG);
        }
        throwbackFeedFragment.al.c();
    }

    private void aE() {
        FeedType feedType = new FeedType("goodwill_throwback_feed", Name.x);
        ThrowbackFeedPagerProtocol throwbackFeedPagerProtocol = this.f21201b;
        throwbackFeedPagerProtocol.f21080j = feedType;
        throwbackFeedPagerProtocol.f21079i = 10;
        ThrowbackFeedPager throwbackFeedPager = this.f21200a;
        throwbackFeedPagerProtocol = this.f21201b;
        AnonymousClass16 anonymousClass16 = new Object(this) {
            public final /* synthetic */ ThrowbackFeedFragment f21185a;

            {
                this.f21185a = r1;
            }

            public final void m22119a(boolean z) {
                if (this.f21185a.mx_()) {
                    ThrowbackFeedFragment.m22139b(this.f21185a, z);
                }
            }

            public final void m22120b() {
                this.f21185a.aC.b(this.f21185a.az);
                if (this.f21185a.mx_() && ThrowbackFeedFragment.aC(this.f21185a).getCount() > 0 && this.f21185a.aC.v() == 0) {
                    this.f21185a.aC.e(this.f21185a.aF);
                }
            }

            public final void m22121c(boolean z) {
                if (this.f21185a.mx_() && z) {
                    this.f21185a.aG.m22158b(this.f21185a.f21200a.f21060e, this.f21185a.f21206g.m22069e());
                }
            }
        };
        throwbackFeedPager.f21063h = (ThrowbackFeedPagerProtocol) Preconditions.checkNotNull(throwbackFeedPagerProtocol);
        throwbackFeedPager.f21064i = (AnonymousClass16) Preconditions.checkNotNull(anonymousClass16);
        aG();
    }

    private void aG() {
        this.aD = new FeedOnDataChangeListener(this) {
            final /* synthetic */ ThrowbackFeedFragment f21187a;

            {
                this.f21187a = r1;
            }

            public final void m22122c() {
                ThrowbackFeedFragment.aC(this.f21187a).notifyDataSetChanged();
            }
        };
        this.f21203d.a(aD(), this.aD);
        this.f21204e.a(aD().a, this.aD);
        this.f21205f.a(aD().a, new FeedOnDataChangeListener(this) {
            final /* synthetic */ ThrowbackFeedFragment f21188a;

            {
                this.f21188a = r1;
            }

            public final void m22123c() {
            }
        });
    }

    private void aI() {
        Map map;
        this.aC.b(new OnScrollListener(this) {
            final /* synthetic */ ThrowbackFeedFragment f21190a;

            {
                this.f21190a = r1;
            }

            public final void m22126a(ScrollingViewProxy scrollingViewProxy, int i) {
            }

            public final void m22127a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                ThrowbackFeedFragment throwbackFeedFragment = this.f21190a;
                Object obj = null;
                if (!ThrowbackFeedFragment.aC(throwbackFeedFragment).isEmpty() && i2 > 0 && i3 > 0 && (i + i2) + 5 > i3) {
                    obj = 1;
                }
                if (obj != null) {
                    ThrowbackFeedPager throwbackFeedPager = throwbackFeedFragment.f21200a;
                    boolean z = false;
                    if (!throwbackFeedPager.f21065j) {
                        z = throwbackFeedPager.f21058c.a(Task.LOAD_NEXT_PAGE, new C29981(throwbackFeedPager), new LoadStoriesCallback(throwbackFeedPager));
                    }
                    if (z) {
                        throwbackFeedFragment.f21208i.a(Events.THROWBACK_PERMALINK_VIEW_MORE);
                    }
                }
            }
        });
        this.aC.d(this.ay);
        this.aC.a(aC(this));
        this.aC.a(this.f21202c.a());
        this.f21200a.clearUserData();
        ThrowbackFeedPager throwbackFeedPager = this.f21200a;
        Map hashMap = new HashMap();
        if (o() == null || o().getIntent() == null || o().getIntent().getExtras() == null) {
            map = hashMap;
        } else {
            Intent intent = o().getIntent();
            String str = (String) intent.getExtras().get("story_id");
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                hashMap.put("story_id", str);
            }
            str = (String) intent.getExtras().get("campaign_id");
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                hashMap.put("campaign_id", str);
            }
            str = (String) intent.getExtras().get("source");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("source", str);
            }
            map = hashMap;
        }
        Map map2 = map;
        throwbackFeedPager.f21065j = false;
        throwbackFeedPager.f21066k = true;
        throwbackFeedPager.f21058c.a(Task.LOAD_INITIAL_FEED, ThrowbackFeedPager.m22030a(throwbackFeedPager, true, map2), new LoadStoriesCallback(throwbackFeedPager));
        throwbackFeedPager.f21066k = false;
    }

    public static void m22138a(boolean z, LoadingIndicatorView loadingIndicatorView) {
        if (z) {
            loadingIndicatorView.a();
        } else {
            loadingIndicatorView.b();
        }
    }

    public final void m22143a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        aC(this).a(new DumpsysContext(str, fileDescriptor, printWriter, strArr, (DumpsysDumper) this.aq.get()));
    }

    private boolean aL() {
        return this.at.a(729, false);
    }
}
