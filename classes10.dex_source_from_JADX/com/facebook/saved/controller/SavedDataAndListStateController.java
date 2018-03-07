package com.facebook.saved.controller;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.ViewportMonitorController;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.controller.SavedDashboardLoadMoreController.LoadingState;
import com.facebook.saved.controller.SavedDashboardLoadMoreController.OnLoadMoreListener;
import com.facebook.saved.controller.SavedDashboardNavigationController.NavigationEventListener;
import com.facebook.saved.controller.SavedDashboardNewItemsPillController.C13751;
import com.facebook.saved.controller.SavedItemsReconnectController.C13871;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.data.SavedDashboardItemMutator;
import com.facebook.saved.data.SavedDashboardListItem;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.saved.event.SavedEventBus;
import com.facebook.saved.event.SavedEvents.SavedItemMutatedEvent;
import com.facebook.saved.event.SavedEvents.SavedItemMutatedEventSubscriber;
import com.facebook.saved.event.SavedEvents.SavedItemReviewedEvent;
import com.facebook.saved.event.SavedEvents.SavedItemReviewedSubscriber;
import com.facebook.saved.fragment.SavedItemsListAdapter;
import com.facebook.saved.fragment.SavedItemsListAdapter.ItemsFreshness;
import com.facebook.saved.helper.SavedSectionHelper;
import com.facebook.saved.loader.SavedDashboardEarlyFetcher;
import com.facebook.saved.loader.SavedDashboardEarlyFetcher.EarlyFetchFutures;
import com.facebook.saved.loader.SavedDashboardItemLoader;
import com.facebook.saved.loader.SavedDashboardItemLoader.ItemLoadListener;
import com.facebook.saved.viewport.SavedItemsVpvLogger;
import com.facebook.saved.viewport.SavedItemsVpvLoggerProvider;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_current_device */
public class SavedDataAndListStateController extends OnRefreshListener implements OnLoadMoreListener, NavigationEventListener {
    public static final String f9066a = SavedDataAndListStateController.class.getSimpleName();
    public final SavedDashboardItemLoader f9067b;
    private final SavedSectionHelper f9068c;
    public final SavedDashboardLoadMoreController f9069d;
    public final SavedEventBus f9070e;
    public final SavedDashboardItemMutator f9071f;
    public final ViewportMonitorController<SavedDashboardItem> f9072g;
    public final SavedItemsVpvLogger f9073h;
    public final AbstractFbErrorReporter f9074i;
    public final SavedDashboardLoadingStateController f9075j;
    public final SavedItemsEmptyListViewController f9076k;
    public final SavedDashboardNewItemsPillController f9077l;
    private final SavedDashboardEarlyFetcher f9078m;
    public FbEventSubscriberListManager f9079n;
    public final SavedItemsReconnectController f9080o;
    private final QeAccessor f9081p;
    public ScrollingViewProxy f9082q;
    public SavedItemsListAdapter f9083r;
    public Optional<SavedDashboardSection> f9084s = Absent.withType();
    public SavedDashboardPaginatedSavedItems f9085t;

    /* compiled from: is_current_device */
    public class C13791 implements OnDrawListener {
        final /* synthetic */ SavedDataAndListStateController f9057a;

        public C13791(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9057a = savedDataAndListStateController;
        }

        public final boolean gD_() {
            SavedDashboardLoadingStateController savedDashboardLoadingStateController = this.f9057a.f9075j;
            SavedItemsListAdapter savedItemsListAdapter = this.f9057a.f9083r;
            boolean z = false;
            ItemsFreshness itemsFreshness = savedItemsListAdapter.f9151e;
            int count = savedItemsListAdapter.getCount();
            savedDashboardLoadingStateController.f9032g.m9259a(count, itemsFreshness);
            if (savedDashboardLoadingStateController.f9029d == 1 && savedDashboardLoadingStateController.f9028c == 2) {
                savedDashboardLoadingStateController.f9032g.m9258a(count);
            } else if (savedDashboardLoadingStateController.f9029d == 2 && savedDashboardLoadingStateController.f9028c == 1) {
                savedDashboardLoadingStateController.f9032g.m9264b(count);
            } else if (savedDashboardLoadingStateController.f9029d == 2 && savedDashboardLoadingStateController.f9028c == 2) {
                if (itemsFreshness == ItemsFreshness.FROM_SERVER) {
                    savedDashboardLoadingStateController.f9032g.m9264b(count);
                } else if (itemsFreshness == ItemsFreshness.FROM_CACHE) {
                    savedDashboardLoadingStateController.f9032g.m9258a(count);
                } else {
                    savedDashboardLoadingStateController.f9033h.a(SavedDashboardLoadingStateController.f9024a, "Invalid ItemsFreshness from adapter");
                }
                savedDashboardLoadingStateController.f9032g.m9262a(true);
                z = true;
            } else {
                savedDashboardLoadingStateController.f9033h.a(SavedDashboardLoadingStateController.f9024a, "Invalid state with onListDrawn");
            }
            return z;
        }
    }

    /* compiled from: is_current_device */
    public class C13802 {
        public final /* synthetic */ SavedDataAndListStateController f9058a;

        public C13802(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9058a = savedDataAndListStateController;
        }
    }

    /* compiled from: is_current_device */
    class C13813 implements ItemLoadListener {
        final /* synthetic */ SavedDataAndListStateController f9059a;

        C13813(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9059a = savedDataAndListStateController;
        }

        public final void mo408a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems) {
            SavedDataAndListStateController savedDataAndListStateController = this.f9059a;
            ImmutableList immutableList = (ImmutableList) savedDashboardPaginatedSavedItems.f9121a.or(RegularImmutableList.a);
            savedDataAndListStateController.f9083r.m9147b(immutableList, ItemsFreshness.FROM_SERVER);
            savedDataAndListStateController.f9069d.f9021c = savedDashboardPaginatedSavedItems.f9122b;
            this.f9059a.f9069d.m9039d();
        }

        public final void mo407a() {
            SavedDashboardLoadMoreController savedDashboardLoadMoreController = this.f9059a.f9069d;
            savedDashboardLoadMoreController.f9020b = LoadingState.LOAD_MORE_FAILED;
            for (OnLoadMoreListener f : savedDashboardLoadMoreController.f9019a) {
                f.mo421f();
            }
        }
    }

    /* compiled from: is_current_device */
    public class C13824 implements OnClickListener {
        final /* synthetic */ SavedDataAndListStateController f9060a;

        public C13824(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9060a = savedDataAndListStateController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 277588012);
            for (OnLoadMoreListener b : this.f9060a.f9069d.f9019a) {
                b.mo418b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1634815154, a);
        }
    }

    /* compiled from: is_current_device */
    public class C13835 extends SavedItemMutatedEventSubscriber {
        final /* synthetic */ SavedDataAndListStateController f9061a;

        public C13835(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9061a = savedDataAndListStateController;
        }

        public final void m9075b(FbEvent fbEvent) {
            this.f9061a.f9083r.m9142a(((SavedItemMutatedEvent) fbEvent).f9128a);
        }
    }

    /* compiled from: is_current_device */
    public class C13846 extends SavedItemReviewedSubscriber {
        final /* synthetic */ SavedDataAndListStateController f9062a;

        public C13846(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9062a = savedDataAndListStateController;
        }

        public final void m9077b(FbEvent fbEvent) {
            SavedItemReviewedEvent savedItemReviewedEvent = (SavedItemReviewedEvent) fbEvent;
            if (StringUtil.a(savedItemReviewedEvent.f9130b)) {
                this.f9062a.f9074i.b(SavedDataAndListStateController.f9066a, "SavedItemReviewedEvent posted without page Id");
                return;
            }
            Optional of;
            SavedItemsListAdapter savedItemsListAdapter = this.f9062a.f9083r;
            String str = savedItemReviewedEvent.f9130b;
            int size = savedItemsListAdapter.f9150d.size();
            for (int i = 0; i < size; i++) {
                SavedDashboardListItem savedDashboardListItem = (SavedDashboardListItem) savedItemsListAdapter.f9150d.get(i);
                if ((savedDashboardListItem instanceof SavedDashboardItem) && ((SavedDashboardItem) savedDashboardListItem).f9112g != null && ((SavedDashboardItem) savedDashboardListItem).f9112g.m9318o().equals(str)) {
                    of = Optional.of((SavedDashboardItem) savedDashboardListItem);
                    break;
                }
            }
            of = Absent.INSTANCE;
            Optional optional = of;
            if (optional.isPresent()) {
                SavedItemsListAdapter savedItemsListAdapter2 = this.f9062a.f9083r;
                SavedDashboardItemMutator savedDashboardItemMutator = this.f9062a.f9071f;
                savedItemsListAdapter2.m9142a(SavedDashboardItemMutator.m9108a((SavedDashboardItem) optional.get(), true));
            }
        }
    }

    /* compiled from: is_current_device */
    class C13857 implements ItemLoadListener {
        final /* synthetic */ SavedDataAndListStateController f9063a;

        public final void mo408a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems) {
            if (savedDashboardPaginatedSavedItems.f9121a.isPresent()) {
                boolean z;
                this.f9063a.m9082a(savedDashboardPaginatedSavedItems, ItemsFreshness.FROM_CACHE);
                SavedDashboardLoadingStateController savedDashboardLoadingStateController = this.f9063a.f9075j;
                if (this.f9063a.f9083r.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                savedDashboardLoadingStateController.m9048a(z, savedDashboardPaginatedSavedItems.f9123c);
                return;
            }
            this.f9063a.f9075j.m9052f();
        }

        C13857(SavedDataAndListStateController savedDataAndListStateController) {
            this.f9063a = savedDataAndListStateController;
        }

        public final void mo407a() {
            this.f9063a.f9075j.m9052f();
        }
    }

    private void m9082a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems, ItemsFreshness itemsFreshness) {
        this.f9083r.m9143a((ImmutableList) savedDashboardPaginatedSavedItems.f9121a.or(RegularImmutableList.a), itemsFreshness);
        this.f9069d.f9021c = savedDashboardPaginatedSavedItems.f9122b;
        this.f9082q.e(0);
    }

    @Inject
    public SavedDataAndListStateController(@Assisted SavedItemsListAdapter savedItemsListAdapter, SavedSectionHelper savedSectionHelper, SavedDashboardItemLoader savedDashboardItemLoader, SavedDashboardLoadMoreController savedDashboardLoadMoreController, SavedEventBus savedEventBus, SavedDashboardItemMutator savedDashboardItemMutator, ViewportMonitorController viewportMonitorController, SavedItemsVpvLoggerProvider savedItemsVpvLoggerProvider, AbstractFbErrorReporter abstractFbErrorReporter, SavedDashboardLoadingStateController savedDashboardLoadingStateController, SavedItemsEmptyListViewController savedItemsEmptyListViewController, SavedDashboardNewItemsPillController savedDashboardNewItemsPillController, SavedDashboardEarlyFetcher savedDashboardEarlyFetcher, SavedItemsReconnectController savedItemsReconnectController, QeAccessor qeAccessor) {
        this.f9083r = savedItemsListAdapter;
        this.f9068c = savedSectionHelper;
        this.f9067b = savedDashboardItemLoader;
        this.f9069d = savedDashboardLoadMoreController;
        this.f9070e = savedEventBus;
        this.f9071f = savedDashboardItemMutator;
        this.f9072g = viewportMonitorController;
        this.f9073h = savedItemsVpvLoggerProvider.m9493a(this);
        this.f9074i = abstractFbErrorReporter;
        this.f9075j = savedDashboardLoadingStateController;
        this.f9076k = savedItemsEmptyListViewController;
        this.f9077l = savedDashboardNewItemsPillController;
        this.f9078m = savedDashboardEarlyFetcher;
        this.f9079n = new FbEventSubscriberListManager();
        this.f9080o = savedItemsReconnectController;
        this.f9081p = qeAccessor;
    }

    public final void mo417a(Optional<SavedDashboardSection> optional) {
        ListenableFuture listenableFuture;
        Long valueOf;
        SavedDashboardLoadingStateController savedDashboardLoadingStateController;
        ListenableFuture listenableFuture2 = null;
        this.f9084s = optional;
        this.f9069d.m9040g();
        this.f9077l.m9064d();
        ViewportMonitorController viewportMonitorController = this.f9072g;
        viewportMonitorController.a.a(false, viewportMonitorController.c);
        Object obj = this.f9083r;
        obj.f9150d.clear();
        obj.f9151e = ItemsFreshness.NONE;
        obj.f9153g.clear();
        AdapterDetour.a(obj, -1097126959);
        viewportMonitorController = this.f9072g;
        viewportMonitorController.a.a(true, viewportMonitorController.c);
        this.f9067b.m9239b();
        Optional a = SavedSectionHelper.m9181a((Optional) optional);
        if (this.f9078m.c()) {
            EarlyFetchFutures earlyFetchFutures = (EarlyFetchFutures) this.f9078m.b(a.get());
            if (earlyFetchFutures != null) {
                listenableFuture = earlyFetchFutures.f9216b;
                listenableFuture2 = earlyFetchFutures.f9215a;
                valueOf = Long.valueOf(this.f9078m.d());
                savedDashboardLoadingStateController = this.f9075j;
                savedDashboardLoadingStateController.f9028c = 2;
                savedDashboardLoadingStateController.f9029d = 2;
                savedDashboardLoadingStateController = this.f9075j;
                savedDashboardLoadingStateController.f9031f = optional;
                if (!savedDashboardLoadingStateController.f9030e) {
                    savedDashboardLoadingStateController.f9030e = true;
                    if (valueOf != null) {
                        savedDashboardLoadingStateController.f9032g.m9263b();
                    } else {
                        savedDashboardLoadingStateController.f9032g.m9260a(valueOf.longValue());
                    }
                }
                savedDashboardLoadingStateController.f9027b.d();
                m9083a(a, listenableFuture);
                m9084a(a, listenableFuture2, false);
            }
        }
        valueOf = null;
        listenableFuture = null;
        savedDashboardLoadingStateController = this.f9075j;
        savedDashboardLoadingStateController.f9028c = 2;
        savedDashboardLoadingStateController.f9029d = 2;
        savedDashboardLoadingStateController = this.f9075j;
        savedDashboardLoadingStateController.f9031f = optional;
        if (savedDashboardLoadingStateController.f9030e) {
            savedDashboardLoadingStateController.f9030e = true;
            if (valueOf != null) {
                savedDashboardLoadingStateController.f9032g.m9260a(valueOf.longValue());
            } else {
                savedDashboardLoadingStateController.f9032g.m9263b();
            }
        }
        savedDashboardLoadingStateController.f9027b.d();
        m9083a(a, listenableFuture);
        m9084a(a, listenableFuture2, false);
    }

    public final void m9090b(boolean z) {
        if (z) {
            this.f9067b.m9239b();
            SavedDashboardLoadingStateController savedDashboardLoadingStateController = this.f9075j;
            savedDashboardLoadingStateController.m9051d();
            savedDashboardLoadingStateController.f9029d = 2;
            this.f9077l.m9063c();
            m9084a(SavedSectionHelper.m9181a(this.f9084s), null, true);
        }
        this.f9076k.b(z);
        SavedDashboardLoadMoreController savedDashboardLoadMoreController = this.f9069d;
        LoadingState loadingState = savedDashboardLoadMoreController.f9020b;
        savedDashboardLoadMoreController.f9020b = LoadingState.REFRESHING;
        if (loadingState == LoadingState.LOADING_MORE) {
            for (OnLoadMoreListener c : savedDashboardLoadMoreController.f9019a) {
                c.mo419c();
            }
        }
    }

    public final void m9087a() {
        this.f9076k.a();
        this.f9069d.m9039d();
    }

    public final void mo418b() {
        Optional optional;
        SavedItemsListAdapter savedItemsListAdapter = this.f9083r;
        if (savedItemsListAdapter.f9150d.isEmpty()) {
            optional = Absent.INSTANCE;
        } else {
            SavedDashboardListItem savedDashboardListItem = (SavedDashboardListItem) savedItemsListAdapter.f9150d.get(savedItemsListAdapter.f9150d.size() - 1);
            Preconditions.checkState(savedDashboardListItem instanceof SavedDashboardItem, "Last item of list should never be a header.");
            optional = Optional.fromNullable(((SavedDashboardItem) savedDashboardListItem).f9114i);
        }
        Optional optional2 = optional;
        if (optional2.isPresent()) {
            this.f9067b.m9237a(SavedSectionHelper.m9181a(this.f9084s), optional2, new C13813(this));
            this.f9069d.f9020b = LoadingState.LOADING_MORE;
        }
    }

    public final void mo419c() {
    }

    public final void mo420e() {
    }

    public final void mo421f() {
    }

    public final void mo422g() {
    }

    private void m9083a(Optional<GraphQLSavedDashboardSectionType> optional, @Nullable ListenableFuture<SavedDashboardPaginatedSavedItems> listenableFuture) {
        SavedDashboardLoadingStateController savedDashboardLoadingStateController = this.f9075j;
        savedDashboardLoadingStateController.f9032g.m9266d();
        savedDashboardLoadingStateController.f9028c = 1;
        ItemLoadListener c13857 = new C13857(this);
        if (listenableFuture != null) {
            this.f9067b.m9238a(listenableFuture, c13857);
            return;
        }
        SavedDashboardItemLoader savedDashboardItemLoader = this.f9067b;
        savedDashboardItemLoader.m9238a(savedDashboardItemLoader.f9226b.m9224b(optional, Absent.INSTANCE), c13857);
    }

    private void m9084a(Optional<GraphQLSavedDashboardSectionType> optional, ListenableFuture<SavedDashboardPaginatedSavedItems> listenableFuture, final boolean z) {
        SavedDashboardLoadingStateController savedDashboardLoadingStateController = this.f9075j;
        savedDashboardLoadingStateController.f9032g.m9270h();
        savedDashboardLoadingStateController.f9029d = 1;
        this.f9085t = null;
        ItemLoadListener c13868 = new ItemLoadListener(this) {
            final /* synthetic */ SavedDataAndListStateController f9065b;

            public final void mo408a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems) {
                boolean z = true;
                if (savedDashboardPaginatedSavedItems.f9121a.isPresent()) {
                    boolean z2;
                    SavedDashboardLoadingStateController savedDashboardLoadingStateController;
                    SavedItemsReconnectController savedItemsReconnectController = this.f9065b.f9080o;
                    if (savedItemsReconnectController.f9092b != null && savedItemsReconnectController.f9092b.a()) {
                        savedItemsReconnectController.f9092b.c();
                    }
                    this.f9065b.f9067b.f9225a.c("task_key_fetch_cached_only_saved_items");
                    this.f9065b.f9075j.m9051d();
                    boolean z3 = !this.f9065b.f9083r.isEmpty();
                    if (this.f9065b.f9083r.m9144a(savedDashboardPaginatedSavedItems)) {
                        if (this.f9065b.f9082q.n()) {
                            this.f9065b.m9082a(savedDashboardPaginatedSavedItems, ItemsFreshness.FROM_SERVER);
                            z2 = false;
                            this.f9065b.f9069d.m9039d();
                            savedDashboardLoadingStateController = this.f9065b.f9075j;
                            if (((ImmutableList) savedDashboardPaginatedSavedItems.f9121a.get()).isEmpty()) {
                                z = false;
                            }
                            savedDashboardLoadingStateController.m9049a(z, z2);
                            return;
                        }
                        this.f9065b.f9085t = savedDashboardPaginatedSavedItems;
                        SavedDashboardNewItemsPillController savedDashboardNewItemsPillController = this.f9065b.f9077l;
                        if (savedDashboardNewItemsPillController.f9040a == null) {
                            savedDashboardNewItemsPillController.f9040a = savedDashboardNewItemsPillController.f9041b.inflate();
                        }
                        savedDashboardNewItemsPillController.f9040a.setVisibility(0);
                        savedDashboardNewItemsPillController.f9040a.setOnClickListener(new C13751(savedDashboardNewItemsPillController));
                    }
                    z2 = z3;
                    this.f9065b.f9069d.m9039d();
                    savedDashboardLoadingStateController = this.f9065b.f9075j;
                    if (((ImmutableList) savedDashboardPaginatedSavedItems.f9121a.get()).isEmpty()) {
                        z = false;
                    }
                    savedDashboardLoadingStateController.m9049a(z, z2);
                    return;
                }
                SavedDataAndListStateController.m9086c(this.f9065b, z);
            }

            public final void mo407a() {
                SavedDataAndListStateController.m9086c(this.f9065b, z);
            }
        };
        if (listenableFuture != null) {
            this.f9067b.m9241b((ListenableFuture) listenableFuture, c13868);
        } else {
            this.f9067b.m9240b((Optional) optional, c13868);
        }
    }

    public static void m9086c(SavedDataAndListStateController savedDataAndListStateController, boolean z) {
        savedDataAndListStateController.f9069d.m9039d();
        savedDataAndListStateController.f9075j.m9050b(!savedDataAndListStateController.f9083r.isEmpty(), z);
        SavedItemsReconnectController savedItemsReconnectController = savedDataAndListStateController.f9080o;
        if (!savedItemsReconnectController.f9091a.a()) {
            if (savedItemsReconnectController.f9092b == null) {
                savedItemsReconnectController.f9092b = savedItemsReconnectController.f9091a.a(State.CONNECTED, new C13871(savedItemsReconnectController));
            }
            if (!savedItemsReconnectController.f9092b.a()) {
                savedItemsReconnectController.f9092b.b();
            }
        }
    }

    public final void m9092d() {
        if (this.f9085t != null) {
            m9082a(this.f9085t, ItemsFreshness.FROM_SERVER);
        }
    }
}
