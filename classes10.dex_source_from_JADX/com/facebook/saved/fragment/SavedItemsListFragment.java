package com.facebook.saved.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.viewport.ViewportMonitorController;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.analytics.UndoAction;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.controller.SavedDashboardListItemController;
import com.facebook.saved.controller.SavedDashboardLoadMoreController.OnLoadMoreListener;
import com.facebook.saved.controller.SavedDashboardLoadingStateController;
import com.facebook.saved.controller.SavedDashboardNavigationController.NavigationEventListener;
import com.facebook.saved.controller.SavedDashboardNewItemsPillController;
import com.facebook.saved.controller.SavedDataAndListStateController;
import com.facebook.saved.controller.SavedDataAndListStateController.C13791;
import com.facebook.saved.controller.SavedDataAndListStateController.C13802;
import com.facebook.saved.controller.SavedDataAndListStateController.C13824;
import com.facebook.saved.controller.SavedDataAndListStateController.C13835;
import com.facebook.saved.controller.SavedDataAndListStateController.C13846;
import com.facebook.saved.controller.SavedDataAndListStateControllerProvider;
import com.facebook.saved.controller.SavedItemsEmptyListViewController;
import com.facebook.saved.controller.SavedItemsReconnectController;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.helper.SavedListItemHelper;
import com.facebook.saved.perf.SavedItemsScrollPerfLogger;
import com.facebook.saved.views.SavedDashboardSavedItemView.SavedItemEventListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemLongClickListener;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: invite_image_scale */
public class SavedItemsListFragment extends FbFragment implements NavigationEventListener {
    @Inject
    public SavedItemsListAdapter f9159a;
    @Inject
    public SavedItemsScrollPerfLogger f9160b;
    @Inject
    public SavedDataAndListStateControllerProvider f9161c;
    @Inject
    public SavedDashboardListItemController f9162d;
    public ScrollingViewProxy f9163e;
    private ViewStub f9164f;
    private RefreshableListViewContainer f9165g;
    private ViewStub f9166h;
    public SavedDataAndListStateController f9167i;

    /* compiled from: invite_image_scale */
    public class C13901 implements OnItemClickListener {
        final /* synthetic */ SavedItemsListFragment f9156a;

        public C13901(SavedItemsListFragment savedItemsListFragment) {
            this.f9156a = savedItemsListFragment;
        }

        public final void m9155a(int i) {
            this.f9156a.f9162d.m9026a(this.f9156a.f9163e.o(), i, this.f9156a.f9167i.f9084s);
        }
    }

    /* compiled from: invite_image_scale */
    public class C13912 implements OnItemLongClickListener {
        final /* synthetic */ SavedItemsListFragment f9157a;

        public C13912(SavedItemsListFragment savedItemsListFragment) {
            this.f9157a = savedItemsListFragment;
        }

        public final boolean m9156a(View view, int i) {
            return this.f9157a.f9162d.m9029a(this.f9157a.f9163e.o(), view, i, this.f9157a, CurationMechanism.LONG_CLICK);
        }
    }

    /* compiled from: invite_image_scale */
    public class C13923 implements SavedItemEventListener {
        final /* synthetic */ SavedItemsListFragment f9158a;

        public C13923(SavedItemsListFragment savedItemsListFragment) {
            this.f9158a = savedItemsListFragment;
        }

        public final void mo434a(SavedDashboardItem savedDashboardItem, View view) {
            this.f9158a.f9162d.m9028a(savedDashboardItem, view, this.f9158a, CurationMechanism.MORE_BUTTON);
        }

        public final void mo433a(SavedDashboardItem savedDashboardItem) {
            this.f9158a.f9162d.m9027a(savedDashboardItem);
        }

        public final void mo435a(SavedDashboardItem savedDashboardItem, UndoAction undoAction) {
            SaveAnalyticsLogger saveAnalyticsLogger = this.f9158a.f9162d.f9012i;
            String o = savedDashboardItem.f9112g.m9318o();
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("saved_dashboard_undo_button_imp");
            honeyClientEvent.c = "saved_dashboard";
            saveAnalyticsLogger.a.a(honeyClientEvent.b("object_id", o).a("undo_action", undoAction).b("event_id", SafeUUIDGenerator.a().toString()));
        }
    }

    public static void m9163a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SavedItemsListFragment savedItemsListFragment = (SavedItemsListFragment) obj;
        SavedItemsListAdapter savedItemsListAdapter = new SavedItemsListAdapter(ResourcesMethodAutoProvider.a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike), SavedListItemHelper.m9178a(injectorLike));
        SavedItemsScrollPerfLogger a = SavedItemsScrollPerfLogger.m9274a(injectorLike);
        SavedDataAndListStateControllerProvider savedDataAndListStateControllerProvider = (SavedDataAndListStateControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedDataAndListStateControllerProvider.class);
        SavedDashboardListItemController a2 = SavedDashboardListItemController.m9020a(injectorLike);
        savedItemsListFragment.f9159a = savedItemsListAdapter;
        savedItemsListFragment.f9160b = a;
        savedItemsListFragment.f9161c = savedDataAndListStateControllerProvider;
        savedItemsListFragment.f9162d = a2;
    }

    public final void m9169c(Bundle bundle) {
        super.c(bundle);
        Class cls = SavedItemsListFragment.class;
        m9163a((Object) this, getContext());
        this.f9167i = this.f9161c.m9096a(this.f9159a);
    }

    public final View m9166a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1637555582);
        View inflate = layoutInflater.inflate(2130906952, viewGroup, false);
        this.f9163e = new ListViewProxy((BetterListView) FindViewUtil.b(inflate, 2131567228));
        this.f9164f = (ViewStub) FindViewUtil.b(inflate, 2131567230);
        this.f9165g = (RefreshableListViewContainer) FindViewUtil.b(inflate, 2131567227);
        this.f9166h = (ViewStub) FindViewUtil.b(inflate, 2131567229);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -284947978, a);
        return inflate;
    }

    public final void m9167a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f9165g.setOnRefreshListener(this.f9167i);
        OnLoadMoreListener onLoadMoreListener = this.f9167i;
        ScrollingViewProxy scrollingViewProxy = this.f9163e;
        RefreshableListViewContainer refreshableListViewContainer = this.f9165g;
        ViewStub viewStub = this.f9164f;
        ViewStub viewStub2 = this.f9166h;
        onLoadMoreListener.f9082q = scrollingViewProxy;
        ViewportMonitorController viewportMonitorController = onLoadMoreListener.f9072g;
        Object obj = onLoadMoreListener.f9083r;
        viewportMonitorController.c = scrollingViewProxy;
        viewportMonitorController.d = obj;
        viewportMonitorController.c.b(viewportMonitorController.a);
        viewportMonitorController.d.registerDataSetObserver(viewportMonitorController.b);
        viewportMonitorController = onLoadMoreListener.f9072g;
        viewportMonitorController.a.a(onLoadMoreListener.f9073h);
        onLoadMoreListener.f9082q.b(new C13791(onLoadMoreListener));
        SavedItemsEmptyListViewController savedItemsEmptyListViewController = onLoadMoreListener.f9076k;
        savedItemsEmptyListViewController.f9086a = scrollingViewProxy;
        savedItemsEmptyListViewController.f9088c = viewStub;
        SavedDashboardLoadingStateController savedDashboardLoadingStateController = onLoadMoreListener.f9075j;
        SavedItemsEmptyListViewController savedItemsEmptyListViewController2 = onLoadMoreListener.f9076k;
        savedDashboardLoadingStateController.f9027b = refreshableListViewContainer;
        savedDashboardLoadingStateController.f9034i = savedItemsEmptyListViewController2;
        SavedDashboardNewItemsPillController savedDashboardNewItemsPillController = onLoadMoreListener.f9077l;
        savedDashboardNewItemsPillController.f9041b = viewStub2;
        savedDashboardNewItemsPillController.f9042c = onLoadMoreListener;
        onLoadMoreListener.f9082q.b(onLoadMoreListener.f9077l);
        onLoadMoreListener.f9079n.a(new C13835(onLoadMoreListener));
        onLoadMoreListener.f9079n.a(new C13846(onLoadMoreListener));
        onLoadMoreListener.f9079n.a(onLoadMoreListener.f9070e);
        onLoadMoreListener.f9082q.b(onLoadMoreListener.f9069d);
        onLoadMoreListener.f9069d.m9036a(onLoadMoreListener);
        onLoadMoreListener.f9069d.m9036a(onLoadMoreListener.f9083r);
        onLoadMoreListener.f9083r.f9155i = new C13824(onLoadMoreListener);
        onLoadMoreListener.f9080o.f9093c = new C13802(onLoadMoreListener);
        this.f9163e.b(this.f9160b);
        this.f9163e.c(true);
        this.f9163e.a(this.f9159a);
        this.f9163e.a(new C13901(this));
        this.f9163e.a(new C13912(this));
        this.f9159a.f9154h = new C13923(this);
    }

    public final void m9164G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1571085192);
        super.G();
        ViewportMonitorController viewportMonitorController = this.f9167i.f9072g;
        viewportMonitorController.a.a(viewportMonitorController.c);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1301258678, a);
    }

    public final void m9165H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2052012789);
        super.H();
        this.f9160b.f9238a.b();
        ViewportMonitorController viewportMonitorController = this.f9167i.f9072g;
        viewportMonitorController.a.c(viewportMonitorController.c);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1942767066, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1307254850);
        super.mY_();
        SavedDataAndListStateController savedDataAndListStateController = this.f9167i;
        savedDataAndListStateController.f9082q.x();
        savedDataAndListStateController.f9082q.c(savedDataAndListStateController.f9077l);
        ViewportMonitorController viewportMonitorController = savedDataAndListStateController.f9072g;
        viewportMonitorController.c.c(viewportMonitorController.a);
        viewportMonitorController.d.unregisterDataSetObserver(viewportMonitorController.b);
        viewportMonitorController.c = null;
        viewportMonitorController.d = null;
        viewportMonitorController = savedDataAndListStateController.f9072g;
        viewportMonitorController.a.b(savedDataAndListStateController.f9073h);
        savedDataAndListStateController.f9067b.m9239b();
        SavedDashboardLoadingStateController savedDashboardLoadingStateController = savedDataAndListStateController.f9075j;
        savedDashboardLoadingStateController.f9028c = 2;
        savedDashboardLoadingStateController.f9029d = 2;
        savedDashboardLoadingStateController.f9027b = null;
        savedDashboardLoadingStateController.f9030e = false;
        SavedItemsEmptyListViewController savedItemsEmptyListViewController = savedDataAndListStateController.f9076k;
        if (savedItemsEmptyListViewController.f9087b != null) {
            savedItemsEmptyListViewController.f9087b.setOnClickListener(null);
        }
        SavedDashboardNewItemsPillController savedDashboardNewItemsPillController = savedDataAndListStateController.f9077l;
        savedDashboardNewItemsPillController.f9041b = null;
        savedDashboardNewItemsPillController.f9040a = null;
        savedDashboardNewItemsPillController.f9042c = null;
        savedDataAndListStateController.f9069d.f9019a.clear();
        savedDataAndListStateController.f9079n.b(savedDataAndListStateController.f9070e);
        SavedItemsReconnectController savedItemsReconnectController = savedDataAndListStateController.f9080o;
        if (savedItemsReconnectController.f9092b != null && savedItemsReconnectController.f9092b.a()) {
            savedItemsReconnectController.f9092b.c();
        }
        savedItemsReconnectController.f9092b = null;
        savedItemsReconnectController.f9093c = null;
        this.f9159a.f9154h = null;
        this.f9163e.c(this.f9160b);
        this.f9163e.a(null);
        this.f9163e.a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1461053978, a);
    }

    public final void mo417a(Optional<SavedDashboardSection> optional) {
        this.f9167i.mo417a(optional);
    }
}
