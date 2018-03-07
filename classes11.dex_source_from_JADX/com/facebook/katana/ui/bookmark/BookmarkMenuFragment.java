package com.facebook.katana.ui.bookmark;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.apptab.state.TabBarStateManager;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.bookmark.FetchBookmarksResult;
import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.bookmark.model.Bookmark;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.bookmark.model.OptionalBookmarksGroup;
import com.facebook.bookmark.model.STATICDI_MULTIBIND_PROVIDER;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment;
import com.facebook.bookmark.ui.BaseBookmarkMenuFragment.ViewItemType;
import com.facebook.bookmark.ui.BaseViewItemFactory.CaspianBookmarkViewItem;
import com.facebook.bookmark.ui.BaseViewItemFactory.CaspianDividerViewItem;
import com.facebook.bookmark.ui.BaseViewItemFactory.CaspianProfileViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.BaseViewItem;
import com.facebook.bookmark.ui.BookmarkAdapter.ViewItem;
import com.facebook.bugreporter.BugReporter;
import com.facebook.common.annotationcache.AnnotationCache;
import com.facebook.common.annotationcache.AnnotationCacheMethodAutoProvider;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.fbreact.interfaces.FbReactInstanceManager;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.groups.logging.GroupsSequenceLogger;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.activity.codegenerator.GatedCodeGeneratorExperimentHelper;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.katana.features.bugreporter.annotations.BugReportingNotRequired;
import com.facebook.katana.ui.bookmark.FB4AViewItemFactory.C00201;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.katana.urimap.IntentHandlerUtil;
import com.facebook.katana.util.LogoutHelper;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.onavo.bookmark.OnavoBookmarkController;
import com.facebook.onavo.bookmark.OnavoBookmarkController.ClickTarget;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.qe.smoketest.ExperimentsForSmokeTestModule;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager;
import com.facebook.timeline.profilemedia.sync.ProfilePhotoSyncManager.Listener;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.listview.ScrollingViewUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.work.bookmarks.bridge.Boolean_IsWorkBookmarksEnabledMethodAutoProvider;
import com.facebook.work.bookmarks.bridge.DummyWorkBookmarksQuery;
import com.facebook.work.bookmarks.bridge.IsWorkBookmarksEnabled;
import com.facebook.work.bookmarks.bridge.WorkGroupedBookmarksQuery;
import com.facebook.zero.annotations.IsFreeFacebookSettingsBookmarkEnabledGateKeeper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: westBound */
public class BookmarkMenuFragment extends BaseBookmarkMenuFragment implements ScrollingViewProxyContainer {
    private static final Class<BookmarkMenuFragment> aX = BookmarkMenuFragment.class;
    private static final int aY = 2131236560;
    @Inject
    NavigationLogger aA;
    @Inject
    AnnotationCache aB;
    @Inject
    @IsWorkBuild
    Boolean aC;
    @Inject
    Set<OptionalBookmarksGroup> aD;
    @Inject
    InteractionLogger aE;
    @Inject
    SecureContextHelper aF;
    @Inject
    LogoutHelper aG;
    @Inject
    Fb4aUriIntentMapper aH;
    @Inject
    DataSensitivitySettingsPrefUtil aI;
    @Inject
    GatedCodeGeneratorExperimentHelper aJ;
    @Inject
    @ReactFragmentActivity
    Provider<ComponentName> aK;
    @Inject
    QeAccessor aL;
    @Inject
    BookmarkClient aM;
    @Inject
    Provider<BottomSheetDialog> aN;
    @Inject
    GroupsSequenceLogger aO;
    @Inject
    Lazy<FbReactInstanceManager> aP;
    @Inject
    @IsFreeFacebookSettingsBookmarkEnabledGateKeeper
    public Provider<Boolean> aQ;
    @Inject
    @IsWorkBookmarksEnabled
    Boolean aR;
    @Inject
    Lazy<WorkGroupedBookmarksQuery> aS;
    @Inject
    ProfilePhotoSyncManager aT;
    @Inject
    GatekeeperStoreImpl aU;
    @Inject
    Lazy<AnalyticsLogger> aV;
    @Inject
    Lazy<FbDataConnectionManager> aW;
    private final Listener aZ = new C00151(this);
    @Inject
    FB4AViewItemFactory ar;
    @Inject
    DefaultBookmarkFactory as;
    @Inject
    TabBarStateManager at;
    @Inject
    @LoggedInUserId
    Provider<String> au;
    @Inject
    DBLStorageAndRetrievalHelper av;
    @Inject
    public Lazy<BugReporter> aw;
    @Inject
    public JewelCounters ax;
    @Inject
    OnavoBookmarkController ay;
    @Inject
    IntentHandlerUtil az;
    private ViewGroup ba;
    private boolean bb = false;
    public boolean bc;
    private ViewItem bd;
    private OnJewelCountChangeListener be;
    public Bookmark bf;
    public Bookmark bg;
    public ScrollingViewProxy bh;
    public ProgressBar bi;
    private FbSwipeRefreshLayout bj;
    public final Map<OptionalBookmarksGroup, Boolean> bk = Maps.c();
    public List<BookmarksGroup> bl = RegularImmutableList.a;
    private final Object bm = new Object();
    private final Object bn = new Object();
    private final Object bo = new Object();

    /* compiled from: westBound */
    class C00151 implements Listener {
        final /* synthetic */ BookmarkMenuFragment f130a;

        C00151(BookmarkMenuFragment bookmarkMenuFragment) {
            this.f130a = bookmarkMenuFragment;
        }

        public final void m119a() {
            if (this.f130a.g != null) {
                this.f130a.g.f();
            }
        }
    }

    /* compiled from: westBound */
    class C00162 extends OnJewelCountChangeListener {
        final /* synthetic */ BookmarkMenuFragment f131a;

        C00162(BookmarkMenuFragment bookmarkMenuFragment) {
            this.f131a = bookmarkMenuFragment;
        }

        public final void m120a(Jewel jewel, int i) {
            if (jewel == Jewel.FRIEND_REQUESTS && this.f131a.bf != null) {
                this.f131a.bf.a(i);
            }
            if (jewel == Jewel.INBOX && this.f131a.bg != null) {
                BookmarkMenuFragment bookmarkMenuFragment = this.f131a;
                if (bookmarkMenuFragment.bh != null) {
                    int q = bookmarkMenuFragment.bh.q();
                    int r = bookmarkMenuFragment.bh.r();
                    int i2 = q;
                    while (i2 < r) {
                        BaseViewItem baseViewItem = (BaseViewItem) bookmarkMenuFragment.bh.g(i2);
                        if (baseViewItem == null || baseViewItem.c() == null || baseViewItem.c().id != 217974574879787L || baseViewItem.c().b() == bookmarkMenuFragment.ax.a(Jewel.INBOX)) {
                            i2++;
                        } else {
                            ((BaseViewItem) bookmarkMenuFragment.bh.g(i2)).a(bookmarkMenuFragment.bh.c(i2).getTag());
                            return;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: westBound */
    class C00173 implements OnRefreshListener {
        final /* synthetic */ BookmarkMenuFragment f132a;

        C00173(BookmarkMenuFragment bookmarkMenuFragment) {
            this.f132a = bookmarkMenuFragment;
        }

        public final void m121a() {
            this.f132a.bc = true;
            this.f132a.aM.a();
        }
    }

    /* compiled from: westBound */
    public class C00184 implements Runnable {
        final /* synthetic */ BookmarkMenuFragment f133a;

        public C00184(BookmarkMenuFragment bookmarkMenuFragment) {
            this.f133a = bookmarkMenuFragment;
        }

        public void run() {
            if (this.f133a.g.e().a.isEmpty()) {
                BookmarkMenuFragment.m127b(this.f133a, this.f133a.as.m150b());
            }
        }
    }

    /* compiled from: westBound */
    class C00195 {
        final /* synthetic */ BookmarkMenuFragment f134a;

        C00195(BookmarkMenuFragment bookmarkMenuFragment) {
            this.f134a = bookmarkMenuFragment;
        }
    }

    public static void m125a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BookmarkMenuFragment) obj).m123a(FB4AViewItemFactory.m165a(injectorLike), DefaultBookmarkFactory.m146a(injectorLike), TabBarStateManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), DBLStorageAndRetrievalHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5011), JewelCounters.a(injectorLike), OnavoBookmarkController.m1393a(injectorLike), IntentHandlerUtil.a(injectorLike), NavigationLogger.a(injectorLike), AnnotationCacheMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), STATICDI_MULTIBIND_PROVIDER.OptionalBookmarksGroup.a(injectorLike), InteractionLogger.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), LogoutHelper.a(injectorLike), Fb4aUriIntentMapper.a(injectorLike), DataSensitivitySettingsPrefUtil.a(injectorLike), GatedCodeGeneratorExperimentHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 13), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BookmarkClient.a(injectorLike), IdBasedProvider.a(injectorLike, 11752), GroupsSequenceLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 1138), IdBasedProvider.a(injectorLike, 4386), Boolean_IsWorkBookmarksEnabledMethodAutoProvider.m6539a(injectorLike), IdBasedLazy.a(injectorLike, 11775), ProfilePhotoSyncManager.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 175), IdBasedSingletonScopeProvider.b(injectorLike, 584));
    }

    private void m123a(FB4AViewItemFactory fB4AViewItemFactory, DefaultBookmarkFactory defaultBookmarkFactory, TabBarStateManager tabBarStateManager, Provider<String> provider, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper, Lazy<BugReporter> lazy, JewelCounters jewelCounters, OnavoBookmarkController onavoBookmarkController, IntentHandlerUtil intentHandlerUtil, NavigationLogger navigationLogger, AnnotationCache annotationCache, Boolean bool, Set<OptionalBookmarksGroup> set, InteractionLogger interactionLogger, SecureContextHelper secureContextHelper, LogoutHelper logoutHelper, Fb4aUriIntentMapper fb4aUriIntentMapper, DataSensitivitySettingsPrefUtil dataSensitivitySettingsPrefUtil, GatedCodeGeneratorExperimentHelper gatedCodeGeneratorExperimentHelper, Provider<ComponentName> provider2, QeAccessor qeAccessor, BookmarkClient bookmarkClient, Provider<BottomSheetDialog> provider3, GroupsSequenceLogger groupsSequenceLogger, Lazy<FbReactInstanceManager> lazy2, Provider<Boolean> provider4, Boolean bool2, Lazy<WorkGroupedBookmarksQuery> lazy3, ProfilePhotoSyncManager profilePhotoSyncManager, GatekeeperStore gatekeeperStore, Lazy<AnalyticsLogger> lazy4, Lazy<FbDataConnectionManager> lazy5) {
        this.ar = fB4AViewItemFactory;
        this.as = defaultBookmarkFactory;
        this.at = tabBarStateManager;
        this.au = provider;
        this.av = dBLStorageAndRetrievalHelper;
        this.aw = lazy;
        this.ax = jewelCounters;
        this.ay = onavoBookmarkController;
        this.az = intentHandlerUtil;
        this.aA = navigationLogger;
        this.aB = annotationCache;
        this.aC = bool;
        this.aD = set;
        this.aE = interactionLogger;
        this.aF = secureContextHelper;
        this.aG = logoutHelper;
        this.aH = fb4aUriIntentMapper;
        this.aI = dataSensitivitySettingsPrefUtil;
        this.aJ = gatedCodeGeneratorExperimentHelper;
        this.aK = provider2;
        this.aL = qeAccessor;
        this.aM = bookmarkClient;
        this.aN = provider3;
        this.aO = groupsSequenceLogger;
        this.aP = lazy2;
        this.aQ = provider4;
        this.aR = bool2;
        this.aS = lazy3;
        this.aT = profilePhotoSyncManager;
        this.aU = gatekeeperStore;
        this.aV = lazy4;
        this.aW = lazy5;
    }

    public BookmarkMenuFragment() {
        super(2130905031, 2131559962);
    }

    public final void m140c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = BookmarkMenuFragment.class;
        m125a((Object) this, getContext());
        ay();
        for (OptionalBookmarksGroup put : this.aD) {
            this.bk.put(put, Boolean.valueOf(true));
        }
        this.ao = 2130903417;
        this.aT.a(this.aZ);
        this.be = new C00162(this);
        this.bf = new Bookmark(0, b(2131233203), FBLinks.ch, this.ax.a(Jewel.FRIEND_REQUESTS), null, null, null, null);
        this.ax.a(this.be);
        boolean a = this.aL.a(ExperimentsForSmokeTestModule.f4552a, false);
        this.aL.a(ExperimentsForSmokeTestModule.f4553b, null);
        Boolean.valueOf(a);
    }

    public final void m134H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1757178836);
        super.H();
        this.aO.n();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1773841024, a);
    }

    public final void m135I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1061048350);
        super.I();
        this.ax.b(this.be);
        this.bh = null;
        if (this.bj != null) {
            this.bj.e = null;
            this.bj = null;
        }
        this.bl = RegularImmutableList.a;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1296908742, a);
    }

    public final ScrollingViewProxy m144n() {
        return this.bh;
    }

    public final void m143e(Bundle bundle) {
        super.e(bundle);
    }

    protected final int m142e() {
        return ViewItemType.values().length;
    }

    public final void m141d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 454176676);
        this.bd = new C00201(this.ar, ViewItemType.Loader);
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -986059034, a);
    }

    public final void m133G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1104578671);
        super.G();
        for (OptionalBookmarksGroup optionalBookmarksGroup : this.bk.keySet()) {
            if (Objects.equal(Boolean.valueOf(optionalBookmarksGroup.a()), this.bk.get(optionalBookmarksGroup))) {
                if (optionalBookmarksGroup.b()) {
                }
            }
            m127b(this, this.bl);
        }
        this.as = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1949701440, a);
    }

    public final View m136a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1542833450);
        this.ba = viewGroup;
        View a2 = super.a(layoutInflater, viewGroup, bundle);
        this.bh = new ListViewProxy((BetterListView) FindViewUtil.b(a2, 2131559962));
        this.bi = (ProgressBar) FindViewUtil.b(a2, 2131559963);
        this.bj = (FbSwipeRefreshLayout) a2.findViewById(2131559961);
        this.bj.setEnabled(false);
        this.bj.setColorSchemeResources(new int[]{2131361916});
        this.bj.e = new C00173(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1683632994, a);
        return a2;
    }

    public final void m137a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (D() && this.aL.a(ExperimentsForEventsGatingModule.T, false)) {
            ((Fb4aReactInstanceManager) this.aP.get()).a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ScrollingViewUtils.a(this.bh);
    }

    protected final void aq() {
        FetchBookmarksResult e = this.g.e();
        if (e.freshness == DataFreshnessResult.NO_DATA || e.freshness == DataFreshnessResult.FROM_CACHE_STALE) {
            this.bb = true;
        }
        if (e.a.isEmpty()) {
            this.bi.setVisibility(0);
            this.bi.postDelayed(new C00184(this), 5000);
            return;
        }
        m127b(this, e.a);
    }

    private static List<Bookmark> m122a(long j, List<Bookmark> list) {
        int i = -1;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((Bookmark) list.get(i2)).id == j) {
                i = i2;
            }
        }
        if (i < 0) {
            return list;
        }
        list = Lists.a(list);
        list.add(0, (Bookmark) list.remove(i));
        return list;
    }

    public static void m127b(BookmarkMenuFragment bookmarkMenuFragment, List list) {
        if (!list.isEmpty() && bookmarkMenuFragment.mx_()) {
            bookmarkMenuFragment.bi.setVisibility(8);
            bookmarkMenuFragment.bl = ImmutableList.copyOf(list);
            List a = Lists.a(list);
            List a2 = Lists.a();
            for (int i = 0; i < a.size(); i++) {
                if ("settings".equals(a.get(i))) {
                    a.add((BookmarksGroup) a.remove(i));
                    break;
                }
            }
            bookmarkMenuFragment.m129c(a);
            int i2 = 0;
            Object obj = null;
            while (i2 < a.size()) {
                Object obj2;
                BookmarksGroup bookmarksGroup = (BookmarksGroup) a.get(i2);
                if (bookmarksGroup.b() != 0) {
                    if ("group".equals(bookmarksGroup.id) && bookmarkMenuFragment.m131e(a)) {
                        obj2 = 1;
                        i2++;
                        obj = obj2;
                    } else if (!bookmarksGroup.c()) {
                        if (i2 > 0) {
                            a2.add(bookmarkMenuFragment.ar.a(ViewItemType.Divider, bookmarksGroup, i2 > 1));
                        }
                        if (!bookmarkMenuFragment.aC.booleanValue() && i2 == 1 && bookmarkMenuFragment.at.a().a()) {
                            a2.add(bookmarkMenuFragment.ar.b(ViewItemType.Bookmark, bookmarkMenuFragment.bf));
                        }
                        List a3 = m122a(608920319153834L, m122a(678003258979791L, m122a(217974574879787L, bookmarksGroup.e())));
                        for (int i3 = 0; i3 < a3.size(); i3++) {
                            Bookmark bookmark = (Bookmark) a3.get(i3);
                            bookmark.a("profile".equals(bookmarksGroup.id));
                            if ((StringUtil.a(new CharSequence[]{bookmark.url}) || !bookmark.url.contains(FBLinks.cq)) && !bookmarkMenuFragment.b(bookmark)) {
                                if ("profile".equals(bookmarksGroup.id) && "profile".equals(bookmark.type)) {
                                    obj2 = new CaspianProfileViewItem(bookmarkMenuFragment.ar, ViewItemType.Profile, bookmark);
                                } else if (4748854339L == bookmark.id || 608920319153834L == bookmark.id) {
                                    CaspianBookmarkViewItem caspianBookmarkViewItem = new CaspianBookmarkViewItem(bookmarkMenuFragment.ar, ViewItemType.NewsFeed, bookmark);
                                } else {
                                    obj2 = bookmarkMenuFragment.ar.b(ViewItemType.Bookmark, bookmark);
                                }
                                a2.add(obj2);
                            }
                        }
                        if (bookmarksGroup.g()) {
                            a2.add(bookmarkMenuFragment.ar.a(ViewItemType.SeeAll, bookmarksGroup, -1, 2131236555));
                        }
                    }
                }
                obj2 = obj;
                i2++;
                obj = obj2;
            }
            if (obj != null && bookmarkMenuFragment.ax()) {
                bookmarkMenuFragment.m132f(a2);
            }
            bookmarkMenuFragment.m130d(a2);
            bookmarkMenuFragment.a(a2);
        }
    }

    private void m129c(List<BookmarksGroup> list) {
        for (OptionalBookmarksGroup optionalBookmarksGroup : this.bk.keySet()) {
            boolean a = optionalBookmarksGroup.a();
            this.bk.put(optionalBookmarksGroup, Boolean.valueOf(a));
            if (a) {
                int i = 0;
                String c = optionalBookmarksGroup.c();
                if (c != null) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (Objects.equal(((BookmarksGroup) list.get(i2)).id, c)) {
                            i = i2 + 1;
                            break;
                        }
                    }
                }
                while (i < list.size()) {
                    if (Objects.equal(((BookmarksGroup) list.get(i)).id, "settings")) {
                        break;
                    }
                    i++;
                }
                i = list.size();
                list.add(i, optionalBookmarksGroup.d());
            }
        }
    }

    private void m130d(List<ViewItem> list) {
        if (mx_()) {
            boolean z;
            int i;
            Bookmark a;
            for (int size = list.size() - 1; size >= 0; size--) {
                ViewItem viewItem = (ViewItem) list.get(size);
                if (viewItem instanceof CaspianDividerViewItem) {
                    BookmarksGroup bookmarksGroup = (BookmarksGroup) ((CaspianDividerViewItem) viewItem).d;
                    if (bookmarksGroup != null && "settings".equals(bookmarksGroup.id)) {
                        z = true;
                        if (!z) {
                            list.add(this.ar.a(ViewItemType.Divider, new BookmarksGroup("settings", b(2131236546), 0, new ArrayList()), true));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f136a, 2130837649, 2131236552));
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f147l, 2130841019, 2131236548));
                        if (((Boolean) this.aQ.get()).booleanValue()) {
                            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f137b, 2130837649, 2131236551));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f138c, 2130840310, 2131236545));
                        if (this.aI.a()) {
                            if (this.aI.b.a(792, false)) {
                                i = 0;
                            } else {
                                i = list.size();
                            }
                            list.add(i, this.ar.a(ViewItemType.IconLabel, this.as.f139d, 2130838462, 2131233808));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f140e, 2130837567, 2131236549));
                        if (this.aU.a(70, false)) {
                            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f141f, 2130837649, 2131236550));
                        }
                        if (!this.aC.booleanValue() && (this.aJ.a() || !this.aJ.b())) {
                            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f143h, 2130838101, 2131236469));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f142g, 2130840777, 2131234233));
                        a = this.as.m149a();
                        if (a != null) {
                            list.add(this.ar.a(ViewItemType.IconLabel, a, 2130837581, 2131236554));
                        }
                        if (!this.aC.booleanValue()) {
                            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f144i, 2130842760, 2131236563));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f145j, 2130843564, 2131236564));
                        if (m128b(getContext())) {
                            list.add(this.ar.a(ViewItemType.IconLabel, this.bn, 2130843025, 2131235816));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f146k, 2130837565, 2131232455));
                        if (!(this.aC.booleanValue() || ((TriState) this.ay.f1036e.get()).asBoolean(false))) {
                            list.add(this.ar.a(ViewItemType.IconLabel, this.bo, 2130841252, this.ay.f1032a.getString(2131241699)));
                        }
                        list.add(this.ar.a(ViewItemType.IconLabel, this.bm, 2130841121, 2131236553));
                        if (!this.bb) {
                            list.add(this.bd);
                        }
                    }
                    z = false;
                    if (z) {
                        list.add(this.ar.a(ViewItemType.Divider, new BookmarksGroup("settings", b(2131236546), 0, new ArrayList()), true));
                    }
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f136a, 2130837649, 2131236552));
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f147l, 2130841019, 2131236548));
                    if (((Boolean) this.aQ.get()).booleanValue()) {
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f137b, 2130837649, 2131236551));
                    }
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f138c, 2130840310, 2131236545));
                    if (this.aI.a()) {
                        if (this.aI.b.a(792, false)) {
                            i = list.size();
                        } else {
                            i = 0;
                        }
                        list.add(i, this.ar.a(ViewItemType.IconLabel, this.as.f139d, 2130838462, 2131233808));
                    }
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f140e, 2130837567, 2131236549));
                    if (this.aU.a(70, false)) {
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f141f, 2130837649, 2131236550));
                    }
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f143h, 2130838101, 2131236469));
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f142g, 2130840777, 2131234233));
                    a = this.as.m149a();
                    if (a != null) {
                        list.add(this.ar.a(ViewItemType.IconLabel, a, 2130837581, 2131236554));
                    }
                    if (this.aC.booleanValue()) {
                        list.add(this.ar.a(ViewItemType.IconLabel, this.as.f144i, 2130842760, 2131236563));
                    }
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f145j, 2130843564, 2131236564));
                    if (m128b(getContext())) {
                        list.add(this.ar.a(ViewItemType.IconLabel, this.bn, 2130843025, 2131235816));
                    }
                    list.add(this.ar.a(ViewItemType.IconLabel, this.as.f146k, 2130837565, 2131232455));
                    list.add(this.ar.a(ViewItemType.IconLabel, this.bo, 2130841252, this.ay.f1032a.getString(2131241699)));
                    list.add(this.ar.a(ViewItemType.IconLabel, this.bm, 2130841121, 2131236553));
                    if (!this.bb) {
                        list.add(this.bd);
                    }
                }
            }
            z = false;
            if (z) {
                list.add(this.ar.a(ViewItemType.Divider, new BookmarksGroup("settings", b(2131236546), 0, new ArrayList()), true));
            }
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f136a, 2130837649, 2131236552));
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f147l, 2130841019, 2131236548));
            if (((Boolean) this.aQ.get()).booleanValue()) {
                list.add(this.ar.a(ViewItemType.IconLabel, this.as.f137b, 2130837649, 2131236551));
            }
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f138c, 2130840310, 2131236545));
            if (this.aI.a()) {
                if (this.aI.b.a(792, false)) {
                    i = 0;
                } else {
                    i = list.size();
                }
                list.add(i, this.ar.a(ViewItemType.IconLabel, this.as.f139d, 2130838462, 2131233808));
            }
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f140e, 2130837567, 2131236549));
            if (this.aU.a(70, false)) {
                list.add(this.ar.a(ViewItemType.IconLabel, this.as.f141f, 2130837649, 2131236550));
            }
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f143h, 2130838101, 2131236469));
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f142g, 2130840777, 2131234233));
            a = this.as.m149a();
            if (a != null) {
                list.add(this.ar.a(ViewItemType.IconLabel, a, 2130837581, 2131236554));
            }
            if (this.aC.booleanValue()) {
                list.add(this.ar.a(ViewItemType.IconLabel, this.as.f144i, 2130842760, 2131236563));
            }
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f145j, 2130843564, 2131236564));
            if (m128b(getContext())) {
                list.add(this.ar.a(ViewItemType.IconLabel, this.bn, 2130843025, 2131235816));
            }
            list.add(this.ar.a(ViewItemType.IconLabel, this.as.f146k, 2130837565, 2131232455));
            list.add(this.ar.a(ViewItemType.IconLabel, this.bo, 2130841252, this.ay.f1032a.getString(2131241699)));
            list.add(this.ar.a(ViewItemType.IconLabel, this.bm, 2130841121, 2131236553));
            if (!this.bb) {
                list.add(this.bd);
            }
        }
    }

    public final void m139a(BookmarksGroup bookmarksGroup) {
        if (this.g != null) {
            m127b(this, this.g.b());
        }
    }

    public final void m138a(FetchBookmarksResult fetchBookmarksResult, boolean z) {
        if (mx_()) {
            if (z || this.bb) {
                this.bb = false;
                m127b(this, fetchBookmarksResult.a);
            }
            if (this.bc && this.bj != null) {
                this.bc = false;
                this.bj.setRefreshing(false);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object g = this.bh.g(i);
        if (g instanceof BaseViewItem) {
            BaseViewItem baseViewItem = (BaseViewItem) g;
            ViewItemType viewItemType = (ViewItemType) baseViewItem.a();
            if (viewItemType == ViewItemType.SeeAll) {
                BookmarksGroup bookmarksGroup = (BookmarksGroup) baseViewItem.d;
                this.aE.a(bookmarksGroup.id, UIElementsTypes.c, UIElements.v);
                if ("group".equals(bookmarksGroup.id)) {
                    Intent component = new Intent().setComponent((ComponentName) this.aK.get());
                    component.putExtra("target_fragment", ContentFragmentType.GROUPS_GRID_FRAGMENT.ordinal());
                    this.aF.a(component, o());
                } else {
                    m126b(bookmarksGroup);
                    return;
                }
            }
            if (baseViewItem.d instanceof Bookmark) {
                Bookmark c = baseViewItem.c();
                if (!(c == null || c.id != 678003258979791L || c.a == null)) {
                    m126b(c.a);
                    return;
                }
            }
            if (viewItemType == ViewItemType.IconLabel && this.bm.equals(baseViewItem.d)) {
                this.aE.a("logout", UIElementsTypes.c, UIElements.v);
                Boolean valueOf = Boolean.valueOf(false);
                if (this.av.c((String) this.au.get()) != null) {
                    valueOf = Boolean.valueOf(true);
                }
                this.aG.a((Activity) getContext(), valueOf.booleanValue());
                return;
            }
            if (viewItemType == ViewItemType.IconLabel) {
                m124a(baseViewItem.d);
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return super.onItemLongClick(adapterView, view, i, j);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1267358690);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(aY);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1945608024, a);
    }

    private void m126b(BookmarksGroup bookmarksGroup) {
        Intent a = this.aH.a(o(), FBLinks.bx);
        a.putExtra(FBLinks.bx, bookmarksGroup);
        this.aF.a(a, o());
    }

    private boolean m128b(Context context) {
        return context == null || !this.aB.a(context.getClass(), BugReportingNotRequired.class);
    }

    private boolean m131e(List<BookmarksGroup> list) {
        if (!ax()) {
            return false;
        }
        for (BookmarksGroup bookmarksGroup : list) {
            for (Bookmark bookmark : bookmarksGroup.e()) {
                if ("pinned".equals(bookmarksGroup.id) && 230259100322928L == bookmark.id) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m124a(Object obj) {
        if (this.bn.equals(obj)) {
            this.aE.a(UIElements.k, null);
            if (m128b(getContext())) {
                ((BugReporter) this.aw.get()).a(getContext());
            }
        } else if (this.bo.equals(obj)) {
            ClickTarget clickTarget = ClickTarget.ONAVO_COUNT;
            if (!this.ay.m1394c()) {
                this.az.a(getContext(), FBLinks.dn);
                clickTarget = ClickTarget.PROMOTION;
            }
            this.aA.a("bookmarks_menu", UIElementsTypes.c, UIElements.m, ImmutableBiMap.b("target", clickTarget.name().toLowerCase(Locale.US)));
        } else if (this.as.f140e.equals(obj)) {
            ConnectionQuality c = ((FbDataConnectionManager) this.aW.get()).c();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("account_setting_open");
            honeyClientEvent.b("network", c.toString());
            ((AnalyticsLogger) this.aV.get()).a(honeyClientEvent);
        }
    }

    private boolean ax() {
        return this.aC.booleanValue() && this.aR.booleanValue();
    }

    private void ay() {
        if (ax()) {
            DummyWorkBookmarksQuery dummyWorkBookmarksQuery = (DummyWorkBookmarksQuery) this.aS.get();
            C00195 c00195 = new C00195(this);
            dummyWorkBookmarksQuery.m6541a();
        }
    }

    private void m132f(List<ViewItem> list) {
        if (((DummyWorkBookmarksQuery) this.aS.get()).m6543c()) {
            ImmutableList b = ((DummyWorkBookmarksQuery) this.aS.get()).m6542b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                BookmarksGroup bookmarksGroup = (BookmarksGroup) b.get(i);
                list.add(this.ar.a(ViewItemType.Divider, bookmarksGroup, true));
                for (Bookmark b2 : bookmarksGroup.e()) {
                    list.add(this.ar.b(ViewItemType.Bookmark, b2));
                }
            }
        }
    }
}
