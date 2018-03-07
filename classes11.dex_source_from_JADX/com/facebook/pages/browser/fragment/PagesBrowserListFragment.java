package com.facebook.pages.browser.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.browser.analytics.PagesBrowserAnalytics;
import com.facebook.pages.browser.data.adapters.PagesBrowserSectionAdapter;
import com.facebook.pages.browser.data.adapters.PagesBrowserSectionAdapter.Section;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPagesInCategoryModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPagesInCategoryModel.PageBrowserCategoriesModel.NodesModel;
import com.facebook.pages.browser.data.methods.FetchRecommendedPagesInCategory.Params;
import com.facebook.pages.browser.event.PagesBrowserEventBus;
import com.facebook.pages.browser.event.PagesBrowserEvents.PageLikedEvent;
import com.facebook.pages.browser.event.PagesBrowserEvents.PageLikedEventSubscriber;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: story_gallery_survey_feed_unit_taken */
public class PagesBrowserListFragment extends BasePagesBrowserFragment {
    public ListenableFuture<OperationResult> al;
    public String am;
    public PagesBrowserSectionAdapter an;
    public FbTitleBarSupplier ao;
    public FbTitleBar ap;
    public RecommendedPagesInCategoryModel aq;
    private View f1310e;
    private BetterListView f1311f;
    public PagesBrowserEventBus f1312g;
    private FbEventSubscriberListManager f1313h;
    public AbstractFbErrorReporter f1314i;

    /* compiled from: story_gallery_survey_feed_unit_taken */
    class C01751 extends PageLikedEventSubscriber {
        final /* synthetic */ PagesBrowserListFragment f1307a;

        C01751(PagesBrowserListFragment pagesBrowserListFragment) {
            this.f1307a = pagesBrowserListFragment;
        }

        public final void m1961b(FbEvent fbEvent) {
            PageLikedEvent pageLikedEvent = (PageLikedEvent) fbEvent;
            PagesBrowserAnalytics pagesBrowserAnalytics;
            long parseLong;
            if (pageLikedEvent.f1291b) {
                pagesBrowserAnalytics = this.f1307a.f1298d;
                parseLong = Long.parseLong(pageLikedEvent.f1290a);
                pagesBrowserAnalytics.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_like_page_in_category").a("page_id", parseLong).b("page_id", this.f1307a.am));
            } else {
                pagesBrowserAnalytics = this.f1307a.f1298d;
                parseLong = Long.parseLong(pageLikedEvent.f1290a);
                pagesBrowserAnalytics.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_unlike_page_in_category").a("page_id", parseLong).b("page_id", this.f1307a.am));
            }
            this.f1307a.m1944a(pageLikedEvent.f1290a, pageLikedEvent.f1291b);
            this.f1307a.m1946b(pageLikedEvent.f1290a, pageLikedEvent.f1291b);
            AdapterDetour.a(this.f1307a.an, 1461192819);
        }
    }

    /* compiled from: story_gallery_survey_feed_unit_taken */
    class C01762 implements Callable<ListenableFuture<OperationResult>> {
        final /* synthetic */ PagesBrowserListFragment f1308a;

        C01762(PagesBrowserListFragment pagesBrowserListFragment) {
            this.f1308a = pagesBrowserListFragment;
        }

        public Object call() {
            return this.f1308a.al;
        }
    }

    /* compiled from: story_gallery_survey_feed_unit_taken */
    class C01773 extends OperationResultFutureCallback {
        final /* synthetic */ PagesBrowserListFragment f1309a;

        C01773(PagesBrowserListFragment pagesBrowserListFragment) {
            this.f1309a = pagesBrowserListFragment;
        }

        public final void m1963a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            int i = 0;
            this.f1309a.f1298d.f1219a.c(PagesBrowserAnalytics.m1790d("pages_browser_category_page_load_successful").b("page_id", this.f1309a.am));
            this.f1309a.aq = (RecommendedPagesInCategoryModel) operationResult.k();
            if (!(this.f1309a.aq == null || this.f1309a.aq.m1900a() == null || this.f1309a.aq.m1900a().m1896a().isEmpty())) {
                ImmutableList a = ((NodesModel) this.f1309a.aq.m1900a().m1896a().get(0)).m1892k().m1887a();
                int size = a.size();
                while (i < size) {
                    RecommendedPageFieldsModel recommendedPageFieldsModel = (RecommendedPageFieldsModel) a.get(i);
                    if (recommendedPageFieldsModel.m1872b()) {
                        this.f1309a.f1297c.m1989a(recommendedPageFieldsModel.m1873c());
                    }
                    i++;
                }
            }
            PagesBrowserListFragment.m1965e(this.f1309a);
        }

        protected final void m1962a(ServiceException serviceException) {
            this.f1309a.f1298d.f1219a.c(PagesBrowserAnalytics.m1790d("pages_browser_category_page_load_error").b("page_id", this.f1309a.am));
            this.f1309a.f1314i.a("page_identity_category_data_fetch_fail", serviceException);
        }
    }

    public static void m1964a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PagesBrowserListFragment pagesBrowserListFragment = (PagesBrowserListFragment) obj;
        PagesBrowserEventBus a = PagesBrowserEventBus.m1936a(injectorLike);
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        PagesBrowserSectionAdapter b = PagesBrowserSectionAdapter.m1800b(injectorLike);
        pagesBrowserListFragment.f1312g = a;
        pagesBrowserListFragment.ao = fbTitleBarSupplier;
        pagesBrowserListFragment.f1314i = abstractFbErrorReporter;
        pagesBrowserListFragment.an = b;
    }

    public final void mo27c(Bundle bundle) {
        super.mo27c(bundle);
        Class cls = PagesBrowserListFragment.class;
        m1964a(this, getContext());
        this.am = this.s.getString("category");
        Preconditions.checkArgument(!StringUtil.a(this.am), "Empty category");
        this.f1313h = new FbEventSubscriberListManager();
        this.f1313h.a(new C01751(this));
        if (this.ao != null) {
            this.ap = (FbTitleBar) this.ao.get();
        }
    }

    public final View m1968a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1290220222);
        this.f1310e = layoutInflater.inflate(2130903522, viewGroup, false);
        this.f1311f = (BetterListView) this.f1310e.findViewById(2131560265);
        this.f1311f.setEmptyView(this.f1310e.findViewById(16908292));
        this.f1311f.c();
        this.f1311f.setAdapter(this.an);
        if (bundle == null || !bundle.containsKey("pages_browser_list_data")) {
            aq();
        } else {
            this.aq = (RecommendedPagesInCategoryModel) FlatBufferModelHelper.a(bundle, "pages_browser_list_data");
            m1965e(this);
        }
        View view = this.f1310e;
        LogUtils.f(54389238, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 162245872);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131242277);
        } else if (this.ap != null) {
            this.ap.setTitle(2131242277);
        }
        LogUtils.f(341692128, a);
    }

    public final void m1967H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 130353339);
        super.H();
        if (this.f1296b != null) {
            this.f1296b.c();
        }
        if (this.f1313h != null) {
            this.f1313h.b(this.f1312g);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2070267820, a);
    }

    public final void m1966G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -171337402);
        super.G();
        if (this.al != null && this.al.isCancelled()) {
            aq();
        }
        if (this.f1313h != null) {
            this.f1313h.a(this.f1312g);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 86356438, a);
    }

    public final void m1971e(Bundle bundle) {
        super.e(bundle);
        if (this.aq != null) {
            FlatBufferModelHelper.a(bundle, "pages_browser_list_data", this.aq);
        }
    }

    public static void m1965e(PagesBrowserListFragment pagesBrowserListFragment) {
        if (!(pagesBrowserListFragment.aq == null || pagesBrowserListFragment.aq.m1900a() == null || pagesBrowserListFragment.aq.m1900a().m1896a().isEmpty())) {
            NodesModel nodesModel = (NodesModel) pagesBrowserListFragment.aq.m1900a().m1896a().get(0);
            String j = ((NodesModel) pagesBrowserListFragment.aq.m1900a().m1896a().get(0)).m1891j();
            HasTitleBar hasTitleBar = (HasTitleBar) pagesBrowserListFragment.a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(j);
            } else if (pagesBrowserListFragment.ap != null) {
                pagesBrowserListFragment.ap.setTitle(j);
            }
            PagesBrowserSectionAdapter pagesBrowserSectionAdapter = pagesBrowserListFragment.an;
            Section section = new Section(nodesModel.m1891j(), nodesModel.m1890a());
            section.f1235c = nodesModel.m1892k().m1887a();
            section.f1236d = false;
            section.f1237e = false;
            pagesBrowserSectionAdapter.f1240e.add(section);
        }
        AdapterDetour.a(pagesBrowserListFragment.an, -1315282393);
    }

    private void aq() {
        this.al = this.f1295a.m1817a(new Params(this.am));
        this.f1296b.a("fetch_recommended_pages_in_category", new C01762(this), new C01773(this));
    }

    protected final void mo26b() {
        AdapterDetour.a(this.an, 1553203306);
    }
}
