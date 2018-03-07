package com.facebook.pages.browser.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
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
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.AllSectionsRecommendedPagesModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.AllSectionsRecommendedPagesModel.PageBrowserCategoriesModel.NodesModel;
import com.facebook.pages.browser.data.graphql.RecommendedPagesModels.RecommendedPageFieldsModel;
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
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: story_gallery_survey_ratings_pref_second */
public class PagesBrowserFragment extends BasePagesBrowserFragment {
    public PagesBrowserEventBus al;
    public FbTitleBarSupplier am;
    private FbTitleBar an;
    public AbstractFbErrorReporter ao;
    public AllSectionsRecommendedPagesModel ap;
    private ListenableFuture<OperationResult> aq;
    public PagesBrowserSectionAdapter ar;
    public NodesModel f1302e;
    public NodesModel f1303f;
    private View f1304g;
    private BetterListView f1305h;
    private FbEventSubscriberListManager f1306i;

    /* compiled from: story_gallery_survey_ratings_pref_second */
    class C01731 extends PageLikedEventSubscriber {
        final /* synthetic */ PagesBrowserFragment f1300a;

        C01731(PagesBrowserFragment pagesBrowserFragment) {
            this.f1300a = pagesBrowserFragment;
        }

        public final void m1948b(FbEvent fbEvent) {
            PageLikedEvent pageLikedEvent = (PageLikedEvent) fbEvent;
            if (pageLikedEvent.f1291b) {
                this.f1300a.f1298d.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_like_page_on_landing").a("page_id", Long.parseLong(pageLikedEvent.f1290a)));
            } else {
                this.f1300a.f1298d.f1219a.c(PagesBrowserAnalytics.m1790d("tapped_unlike_page_on_landing").a("page_id", Long.parseLong(pageLikedEvent.f1290a)));
            }
            this.f1300a.m1944a(pageLikedEvent.f1290a, pageLikedEvent.f1291b);
            AdapterDetour.a(this.f1300a.ar, -1967709489);
            this.f1300a.m1946b(pageLikedEvent.f1290a, pageLikedEvent.f1291b);
        }
    }

    /* compiled from: story_gallery_survey_ratings_pref_second */
    class C01742 extends OperationResultFutureCallback {
        final /* synthetic */ PagesBrowserFragment f1301a;

        C01742(PagesBrowserFragment pagesBrowserFragment) {
            this.f1301a = pagesBrowserFragment;
        }

        public final void m1950a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            this.f1301a.f1298d.f1219a.c(PagesBrowserAnalytics.m1790d("pages_browser_landing_page_load_successful"));
            AllSectionsRecommendedPagesModel allSectionsRecommendedPagesModel = (AllSectionsRecommendedPagesModel) operationResult.k();
            if (allSectionsRecommendedPagesModel != null && allSectionsRecommendedPagesModel.m1841a() != null) {
                ImmutableList a = allSectionsRecommendedPagesModel.m1841a().m1837a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    NodesModel nodesModel = (NodesModel) a.get(i);
                    if (!PagesBrowserFragment.m1952b(nodesModel)) {
                        ImmutableList a2 = nodesModel.m1833k().m1828a();
                        int size2 = a2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            RecommendedPageFieldsModel recommendedPageFieldsModel = (RecommendedPageFieldsModel) a2.get(i2);
                            if (recommendedPageFieldsModel.m1872b()) {
                                this.f1301a.f1297c.m1989a(recommendedPageFieldsModel.m1873c());
                            }
                        }
                        if (nodesModel.m1831a().equals("invites")) {
                            this.f1301a.f1303f = nodesModel;
                        }
                        if (nodesModel.m1831a().equals("top")) {
                            this.f1301a.f1302e = nodesModel;
                        }
                    }
                }
                if (this.f1301a.f1303f != null) {
                    this.f1301a.ar.m1807a(this.f1301a.f1303f, true, true);
                }
                if (this.f1301a.f1302e != null) {
                    this.f1301a.ar.m1807a(this.f1301a.f1302e, false, true);
                }
                AdapterDetour.a(this.f1301a.ar, -10949523);
            }
        }

        protected final void m1949a(ServiceException serviceException) {
            this.f1301a.f1298d.f1219a.c(PagesBrowserAnalytics.m1790d("pages_browser_landing_page_load_error"));
            this.f1301a.ao.a("page_identity_data_fetch_fail", serviceException);
        }
    }

    public static void m1951a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PagesBrowserFragment pagesBrowserFragment = (PagesBrowserFragment) obj;
        PagesBrowserEventBus a = PagesBrowserEventBus.m1936a(injectorLike);
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        PagesBrowserSectionAdapter b = PagesBrowserSectionAdapter.m1800b(injectorLike);
        pagesBrowserFragment.al = a;
        pagesBrowserFragment.am = fbTitleBarSupplier;
        pagesBrowserFragment.ao = abstractFbErrorReporter;
        pagesBrowserFragment.ar = b;
    }

    public final void mo27c(Bundle bundle) {
        super.mo27c(bundle);
        Class cls = PagesBrowserFragment.class;
        m1951a(this, getContext());
        if (this.am != null) {
            this.an = (FbTitleBar) this.am.get();
        }
    }

    public final View m1956a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -712178048);
        this.f1304g = layoutInflater.inflate(2130903522, viewGroup, false);
        this.f1306i = new FbEventSubscriberListManager();
        this.f1306i.a(new C01731(this));
        this.f1305h = (BetterListView) this.f1304g.findViewById(2131560265);
        this.f1305h.setEmptyView(this.f1304g.findViewById(16908292));
        this.f1305h.c();
        this.f1305h.setAdapter(this.ar);
        if (bundle == null || !bundle.containsKey("pages_browser_data")) {
            m1953e();
        } else {
            this.ap = (AllSectionsRecommendedPagesModel) FlatBufferModelHelper.a(bundle, "pages_browser_data");
            if (!(this.ap == null || this.ap.m1841a() == null)) {
                ImmutableList a2 = this.ap.m1841a().m1837a();
                int size = a2.size();
                for (int i = 0; i < size; i++) {
                    NodesModel nodesModel = (NodesModel) a2.get(i);
                    if (!m1952b(nodesModel)) {
                        if (nodesModel.m1831a().equals("invites")) {
                            this.f1303f = nodesModel;
                        }
                        if (nodesModel.m1831a().equals("top")) {
                            this.f1302e = nodesModel;
                        }
                    }
                }
                if (this.f1303f != null) {
                    this.ar.m1807a(this.f1303f, true, true);
                }
                if (this.f1302e != null) {
                    this.ar.m1807a(this.f1302e, false, true);
                }
                AdapterDetour.a(this.ar, 1663104376);
            }
        }
        View view = this.f1304g;
        LogUtils.f(1973824284, a);
        return view;
    }

    public final void m1955H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1875768236);
        super.H();
        if (this.f1296b != null) {
            this.f1296b.c();
        }
        if (this.f1306i != null) {
            this.f1306i.b(this.al);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -717988243, a);
    }

    public final void m1954G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 569135244);
        super.G();
        if (this.aq != null && this.aq.isCancelled()) {
            m1953e();
        }
        if (this.f1306i != null) {
            this.f1306i.a(this.al);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 602532972, a);
    }

    public final void m1959e(Bundle bundle) {
        super.e(bundle);
        if (this.ap != null) {
            FlatBufferModelHelper.a(bundle, "pages_browser_data", this.ap);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1666099581);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131242277);
        } else if (this.an != null) {
            this.an.setTitle(2131242277);
        }
        LogUtils.f(-379765629, a);
    }

    public static boolean m1952b(NodesModel nodesModel) {
        return nodesModel == null || nodesModel.m1833k() == null || nodesModel.m1833k().m1828a().isEmpty();
    }

    private void m1953e() {
        this.aq = this.f1295a.m1816a();
        this.f1296b.a("pages_browser_fetch_initial_recommended_pages", this.aq, new C01742(this));
    }

    protected final void mo26b() {
        AdapterDetour.a(this.ar, -1303333109);
    }
}
