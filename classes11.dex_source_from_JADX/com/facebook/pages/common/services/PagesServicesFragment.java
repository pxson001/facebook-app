package com.facebook.pages.common.services;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.FrameLayout;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceHeaderDataListener;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.PresenceScrollType;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQL.ServicesListGraphQLString;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServiceItem;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServicesData;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServicesDataModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServicesDataModel.ServicesCardModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServicesDataModel.ServicesCardModel.ProductCatalogModel.CatalogItemsModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServicesDataModel.ServicesCardModel.ProductCatalogModel.CatalogItemsModel.EdgesModel;
import com.facebook.pages.identity.protocol.graphql.ServicesMutationsModels.ServicesSectionUpdateMutationModel;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rich_media_lightning_bolt_animation_start */
public class PagesServicesFragment extends FbFragment implements CanHandleBackPressed, PagesSurfaceHeaderDataListener, PagesSurfaceTabFragment {
    public static final int[] aJ = new int[2];
    @Inject
    public TasksManager f2366a;
    public boolean aA = false;
    private ReactionHeaderTouchDelegateView aB;
    private ReactionHeaderViewWithTouchDelegate aC;
    public View aD;
    public PagesSurfaceFragment aE;
    private boolean aF = false;
    public int aG;
    private int aH;
    private int aI = -1;
    public boolean aK = false;
    public int aL = -1;
    public C05581 aM;
    @Inject
    PageCallToActionUtil al;
    @Inject
    public FunnelLoggerImpl am;
    @Inject
    Lazy<Toaster> an;
    @Inject
    public PageEventBus ao;
    public PagesServicesModel ap;
    public EmptyListViewItem aq;
    public BetterListView ar;
    public PagesServicesListAdapter as;
    public List<PageServiceItem> at;
    public List<PageServiceItem> au;
    public PageHeaderData av;
    public String aw;
    public TitleBarButtonSpec ax;
    public OnToolbarButtonListener ay;
    public boolean az = false;
    @Inject
    public GraphQLQueryExecutor f2367b;
    @Inject
    Lazy<FbErrorReporter> f2368c;
    @Inject
    public Lazy<SecureContextHelper> f2369d;
    @Inject
    public Lazy<UriIntentMapper> f2370e;
    @Inject
    PagesServicesFragmentControllerImp f2371f;
    @Inject
    public ScreenUtil f2372g;
    @Inject
    public FbUriIntentHandler f2373h;
    @Inject
    public GatekeeperStoreImpl f2374i;

    /* compiled from: rich_media_lightning_bolt_animation_start */
    public class AnonymousClass10 extends AbstractDisposableFutureCallback<GraphQLResult<ServicesSectionUpdateMutationModel>> {
        final /* synthetic */ String f2354a;
        final /* synthetic */ PagesServicesFragment f2355b;

        public AnonymousClass10(PagesServicesFragment pagesServicesFragment, String str) {
            this.f2355b = pagesServicesFragment;
            this.f2354a = str;
        }

        protected final void m3307a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (!(graphQLResult == null || graphQLResult.e == null || ((ServicesSectionUpdateMutationModel) graphQLResult.e).a() == null)) {
                PagesServicesFragment pagesServicesFragment = this.f2355b;
                if (PagesServicesFragment.m3320b(((ServicesSectionUpdateMutationModel) graphQLResult.e).a().a())) {
                    if (!StringUtil.a(this.f2355b.aw, ((ServicesSectionUpdateMutationModel) graphQLResult.e).a().a())) {
                        this.f2355b.aw = ((ServicesSectionUpdateMutationModel) graphQLResult.e).a().a();
                        PagesServicesFragment.av(this.f2355b);
                        return;
                    }
                    return;
                }
            }
            this.f2355b.aw = this.f2354a;
            PagesServicesFragment.av(this.f2355b);
            ((Toaster) this.f2355b.an.get()).a(new ToastBuilder(2131235443));
        }

        protected final void m3308a(Throwable th) {
            this.f2355b.aw = this.f2354a;
            PagesServicesFragment.av(this.f2355b);
            ((Toaster) this.f2355b.an.get()).a(new ToastBuilder(2131235443));
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    class C02931 implements OnScrollListener {
        final /* synthetic */ PagesServicesFragment f2356a;

        C02931(PagesServicesFragment pagesServicesFragment) {
            this.f2356a = pagesServicesFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int count = this.f2356a.ar.getAdapter() != null ? this.f2356a.ar.getAdapter().getCount() : 0;
            if (!(this.f2356a.aK && this.f2356a.aL == count)) {
                Pair a = PagesScrollUtils.a(this.f2356a.aD, this.f2356a.ar, i, PagesServicesFragment.aJ, this.f2356a.f2372g.d());
                this.f2356a.aK = ((Boolean) a.a).booleanValue();
                if (this.f2356a.aK) {
                    this.f2356a.E_(((Integer) a.b).intValue());
                    this.f2356a.aL = count;
                }
            }
            if (this.f2356a.ar.getChildAt(0) != null) {
                int top = this.f2356a.ar.getChildAt(0).getTop();
                if (this.f2356a.aE != null && this.f2356a.aG != top && this.f2356a.D()) {
                    this.f2356a.aE.m5039a(this.f2356a.ar, i);
                    this.f2356a.aG = top;
                }
            }
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    class C02942 implements OnClickListener {
        final /* synthetic */ PagesServicesFragment f2357a;

        C02942(PagesServicesFragment pagesServicesFragment) {
            this.f2357a = pagesServicesFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -475526524);
            PagesServicesFragment.at(this.f2357a);
            Logger.a(2, EntryType.UI_INPUT_END, 1242484939, a);
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    public class C02953 {
        final /* synthetic */ PagesServicesFragment f2358a;

        C02953(PagesServicesFragment pagesServicesFragment) {
            this.f2358a = pagesServicesFragment;
        }

        public final void m3309a(PageServiceItemModel pageServiceItemModel) {
            PagesServicesFragment pagesServicesFragment = this.f2358a;
            pagesServicesFragment.am.b(FunnelRegistry.L, "tap_add_edit_button");
            if (pagesServicesFragment.f2374i.a(1051, false)) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                bundle2.putString("page_id", pagesServicesFragment.ap.f2416b);
                bundle2.putString("service_id", pageServiceItemModel.d());
                bundle.putBundle("init_props", bundle2);
                pagesServicesFragment.az = true;
                pagesServicesFragment.f2373h.a(pagesServicesFragment.getContext(), FBLinks.ei, bundle);
                return;
            }
            ((SecureContextHelper) pagesServicesFragment.f2369d.get()).a(((UriIntentMapper) pagesServicesFragment.f2370e.get()).a(pagesServicesFragment.getContext(), StringFormatUtil.formatStrLocaleSafe(URL.F, pagesServicesFragment.ap.f2416b, pageServiceItemModel.d())), pagesServicesFragment.getContext());
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    public class C02964 {
        public final /* synthetic */ PagesServicesFragment f2359a;

        C02964(PagesServicesFragment pagesServicesFragment) {
            this.f2359a = pagesServicesFragment;
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    public class C02975 {
        public final /* synthetic */ PagesServicesFragment f2360a;

        C02975(PagesServicesFragment pagesServicesFragment) {
            this.f2360a = pagesServicesFragment;
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    public class C02986 {
        final /* synthetic */ PagesServicesFragment f2361a;

        C02986(PagesServicesFragment pagesServicesFragment) {
            this.f2361a = pagesServicesFragment;
        }

        public final void m3310a(PageServiceItemModel pageServiceItemModel) {
            if (this.f2361a.aA) {
                Bundle bundle = new Bundle();
                bundle.putString("com.facebook.katana.profile.id", Long.toString(this.f2361a.av.a));
                bundle.putString("page_service_id_extra", pageServiceItemModel.d());
                if (!(this.f2361a.av.e == null || Strings.isNullOrEmpty(this.f2361a.av.e.D()))) {
                    bundle.putString("profile_name", this.f2361a.av.e.D());
                }
                bundle.putBoolean("extra_service_launched_from_page", true);
                this.f2361a.f2373h.a(this.f2361a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.ah, Long.valueOf(this.f2361a.av.a), pageServiceItemModel.d()), bundle);
                return;
            }
            PagesServicesFragment.ay(this.f2361a);
            C05581 c05581 = this.f2361a.aM;
            if (PagesSurfaceFragment.au(c05581.f4080a) == c05581.f4080a.bo) {
                PagesSurfaceFragment.m5016a(c05581.f4080a, PresenceScrollType.SCROLL_TO_TAB);
            }
            this.f2361a.aK = false;
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    public class C02997 extends OnToolbarButtonListener {
        final /* synthetic */ PagesServicesFragment f2362a;

        public C02997(PagesServicesFragment pagesServicesFragment) {
            this.f2362a = pagesServicesFragment;
        }

        public final void m3311a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            PagesServicesFragment.at(this.f2362a);
        }
    }

    /* compiled from: rich_media_lightning_bolt_animation_start */
    class C03008 implements Callable<ListenableFuture<GraphQLResult<PageServicesDataModel>>> {
        final /* synthetic */ PagesServicesFragment f2363a;

        C03008(PagesServicesFragment pagesServicesFragment) {
            this.f2363a = pagesServicesFragment;
        }

        public Object call() {
            GraphQLQueryExecutor graphQLQueryExecutor = this.f2363a.f2367b;
            PagesServicesFragment pagesServicesFragment = this.f2363a;
            GraphQlQueryString servicesListGraphQLString = new ServicesListGraphQLString();
            servicesListGraphQLString.a("page_id", pagesServicesFragment.ap.f2416b);
            int c = pagesServicesFragment.f2372g.c();
            servicesListGraphQLString.a("page_service_image_width", Integer.valueOf(c));
            servicesListGraphQLString.a("page_service_image_height", Integer.valueOf((int) (((float) c) / 1.0f)));
            return graphQLQueryExecutor.a(GraphQLRequest.a(servicesListGraphQLString));
        }
    }

    public static void m3318a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesServicesFragment) obj).m3317a(TasksManager.b(fbInjector), GraphQLQueryExecutor.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedSingletonScopeProvider.b(fbInjector, 2436), PagesServicesFragmentControllerImp.m3332b(fbInjector), ScreenUtil.a(fbInjector), FbUriIntentHandler.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), PageCallToActionUtil.a(fbInjector), FunnelLoggerImpl.a(fbInjector), IdBasedLazy.a(fbInjector, 3588), PageEventBus.m2423a(fbInjector));
    }

    private void m3317a(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<FbErrorReporter> lazy, Lazy<SecureContextHelper> lazy2, Lazy<UriIntentMapper> lazy3, PagesServicesFragmentController pagesServicesFragmentController, ScreenUtil screenUtil, FbUriIntentHandler fbUriIntentHandler, GatekeeperStore gatekeeperStore, PageCallToActionUtil pageCallToActionUtil, FunnelLogger funnelLogger, Lazy<Toaster> lazy4, PageEventBus pageEventBus) {
        this.f2366a = tasksManager;
        this.f2367b = graphQLQueryExecutor;
        this.f2368c = lazy;
        this.f2369d = lazy2;
        this.f2370e = lazy3;
        this.f2371f = pagesServicesFragmentController;
        this.f2372g = screenUtil;
        this.f2373h = fbUriIntentHandler;
        this.f2374i = gatekeeperStore;
        this.al = pageCallToActionUtil;
        this.am = funnelLogger;
        this.an = lazy4;
        this.ao = pageEventBus;
    }

    public static PagesServicesFragment m3315a(String str, @Nullable String str2, boolean z, @Nullable String str3, boolean z2) {
        PagesServicesFragment pagesServicesFragment = new PagesServicesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.katana.profile.id", str);
        if (!Strings.isNullOrEmpty(str2)) {
            bundle.putString("profile_name", str2);
        }
        bundle.putBoolean("can_viewer_create_content_extra", z);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z2);
        if (!Strings.isNullOrEmpty(str3)) {
            bundle.putString("page_clicked_item_id_extra", str3);
        }
        pagesServicesFragment.g(bundle);
        return pagesServicesFragment;
    }

    public final void m3330c(Bundle bundle) {
        String str;
        super.c(bundle);
        Class cls = PagesServicesFragment.class;
        m3318a((Object) this, getContext());
        PagesServicesFragmentControllerImp pagesServicesFragmentControllerImp = this.f2371f;
        Bundle bundle2 = this.s;
        Preconditions.checkNotNull(bundle2);
        String string = bundle2.getString("com.facebook.katana.profile.id");
        boolean z = !Strings.isNullOrEmpty(string) && Long.parseLong(string) > 0;
        Preconditions.checkState(z);
        String string2 = bundle2.getString("profile_name");
        String string3 = bundle2.getString("page_clicked_item_id_extra");
        boolean z2 = bundle2.getBoolean("can_viewer_create_content_extra", false);
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) pagesServicesFragmentControllerImp.f2375a.b(string);
        if (adminedPagesPrefetchNode != null) {
            if (Strings.isNullOrEmpty(string2)) {
                string2 = adminedPagesPrefetchNode.a.d();
            }
            if (!z2) {
                z = ProfilePermissions.b(adminedPagesPrefetchNode.a.g());
                str = string2;
                this.ap = new PagesServicesModel(z, string, str, string3);
                this.aF = this.s.getBoolean("extra_is_inside_page_surface_tab");
                this.am.a(FunnelRegistry.L);
                aB();
                this.as = new PagesServicesListAdapter(getContext(), b(bundle), this.am);
                this.aA = this.f2374i.a(1043, false);
                this.as.f2408n = this.aA;
            }
        }
        z = z2;
        str = string2;
        this.ap = new PagesServicesModel(z, string, str, string3);
        this.aF = this.s.getBoolean("extra_is_inside_page_surface_tab");
        this.am.a(FunnelRegistry.L);
        aB();
        this.as = new PagesServicesListAdapter(getContext(), b(bundle), this.am);
        this.aA = this.f2374i.a(1043, false);
        this.as.f2408n = this.aA;
    }

    public final View m3324a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 963590178);
        View inflate = layoutInflater.inflate(2130906128, viewGroup, false);
        FindViewUtil.b(inflate, 2131565745);
        this.aq = (EmptyListViewItem) inflate.findViewById(2131565747);
        this.ar = (BetterListView) inflate.findViewById(2131565746);
        if (this.aF) {
            inflate.setBackgroundResource(0);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1797012979, a);
        return inflate;
    }

    public final void m3325a(View view, Bundle bundle) {
        super.a(view, bundle);
        if (this.aF) {
            ax();
            this.ar.setVerticalScrollBarEnabled(false);
            this.ar.setPadding(0, 0, 0, 0);
            this.ar.addHeaderView(this.aB);
            ((FrameLayout) view.findViewById(2131565745)).removeView(this.aq);
            this.aq.setLayoutParams(new LayoutParams(-1, -2));
            this.aq.setBackgroundResource(0);
            this.ar.addHeaderView(this.aq);
            this.aD = new View(getContext());
            E_(this.aI);
            this.ar.addFooterView(this.aD);
            this.ar.setOnScrollListener(new C02931(this));
            this.ar.setVisibility(0);
        }
        if (this.ap.f2415a) {
            PagesServicesListAdapter pagesServicesListAdapter = this.as;
            OnClickListener c02942 = new C02942(this);
            pagesServicesListAdapter.f2398d = c02942 != null;
            pagesServicesListAdapter.f2400f = c02942;
            this.as.f2401g = new C02953(this);
            if (this.aF) {
                this.as.f2403i = new C02964(this);
                this.as.f2404j = new C02975(this);
            }
        } else {
            this.as.f2402h = new C02986(this);
        }
        aq();
        this.ar.setAdapter(this.as);
        D_(this.aH);
        this.aq.setVisibility(0);
        this.aq.a(true);
        if (this.at == null || this.at.isEmpty()) {
            m3319a(false);
        } else {
            av(this);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1193537415);
        super.mi_();
        ar(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 689619995, a);
    }

    public final void m3322G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1455262427);
        super.G();
        if (this.az) {
            m3331j();
            this.az = false;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -503615278, a);
    }

    public final void m3323I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1869162668);
        super.I();
        this.am.b(FunnelRegistry.L);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -627310244, a);
    }

    public final boolean O_() {
        if (this.as.f2414t == null) {
            return false;
        }
        this.as.m3354a(null);
        return true;
    }

    public final void mo52a(PageHeaderData pageHeaderData) {
        this.av = pageHeaderData;
        aq();
    }

    private void aq() {
        if (this.as != null) {
            PagesServicesListAdapter pagesServicesListAdapter = this.as;
            PageHeaderData pageHeaderData = this.av;
            boolean a = this.al.a(this.av, ImmutableList.of(GraphQLPageCallToActionType.CALL_NOW, GraphQLPageCallToActionType.MESSAGE));
            pagesServicesListAdapter.f2406l = pageHeaderData;
            pagesServicesListAdapter.f2407m = a;
            if (pagesServicesListAdapter.f2414t != null) {
                AdapterDetour.a(pagesServicesListAdapter, -391115028);
            }
        }
    }

    public static void ar(PagesServicesFragment pagesServicesFragment) {
        if (!pagesServicesFragment.aF) {
            HasTitleBar hasTitleBar = (HasTitleBar) pagesServicesFragment.a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(Strings.isNullOrEmpty(pagesServicesFragment.ap.f2417c) ? pagesServicesFragment.jW_().getString(2131235511) : pagesServicesFragment.ap.f2417c);
                if (pagesServicesFragment.ap.f2415a) {
                    hasTitleBar.c(true);
                    if (pagesServicesFragment.ax == null) {
                        Builder a = TitleBarButtonSpec.a();
                        a.i = 2130840032;
                        a = a;
                        a.j = pagesServicesFragment.jW_().getString(2131235513);
                        pagesServicesFragment.ax = a.a();
                    }
                    hasTitleBar.a(pagesServicesFragment.ax);
                    if (pagesServicesFragment.ay == null) {
                        pagesServicesFragment.ay = new C02997(pagesServicesFragment);
                    }
                    hasTitleBar.a(pagesServicesFragment.ay);
                }
            }
        }
    }

    public static void m3316a(PagesServicesFragment pagesServicesFragment, String str) {
        pagesServicesFragment.as.m3355a(str);
        AdapterDetour.a(pagesServicesFragment.as, 595103189);
        pagesServicesFragment.aA();
        pagesServicesFragment.ar.setVisibility(0);
    }

    public static void at(PagesServicesFragment pagesServicesFragment) {
        pagesServicesFragment.am.b(FunnelRegistry.L, "tap_add_edit_button");
        if (pagesServicesFragment.f2374i.a(1051, false)) {
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            bundle2.putString("page_id", pagesServicesFragment.ap.f2416b);
            bundle.putBundle("init_props", bundle2);
            pagesServicesFragment.az = true;
            pagesServicesFragment.f2373h.a(pagesServicesFragment.getContext(), FBLinks.ei, bundle);
            return;
        }
        ((SecureContextHelper) pagesServicesFragment.f2369d.get()).a(((UriIntentMapper) pagesServicesFragment.f2370e.get()).a(pagesServicesFragment.getContext(), StringFormatUtil.formatStrLocaleSafe(URL.E, pagesServicesFragment.ap.f2416b)), pagesServicesFragment.getContext());
    }

    public static void av(PagesServicesFragment pagesServicesFragment) {
        pagesServicesFragment.aA();
        pagesServicesFragment.ar.setVisibility(0);
        pagesServicesFragment.as.m3356a(pagesServicesFragment.at, pagesServicesFragment.au, pagesServicesFragment.ap.f2418d, pagesServicesFragment.ap.f2415a, pagesServicesFragment.aw);
    }

    private void m3319a(final boolean z) {
        this.f2366a.a("fetch_pages_services_list", new C03008(this), new AbstractDisposableFutureCallback<GraphQLResult<PageServicesDataModel>>(this) {
            final /* synthetic */ PagesServicesFragment f2365b;

            protected final void m3312a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((PageServicesDataModel) graphQLResult.e).a() == null) {
                    PagesServicesFragment.m3316a(this.f2365b, this.f2365b.jW_().getString(2131235516));
                    return;
                }
                PageServicesData pageServicesData = (PageServicesData) graphQLResult.e;
                this.f2365b.ap = this.f2365b.f2371f.m3333a(this.f2365b.ap, pageServicesData.a());
                PagesServicesFragment.ar(this.f2365b);
                ServicesCardModel b = pageServicesData.b();
                if (b == null || b.b() == null || !(b.b().equals("published") || this.f2365b.ap.f2415a)) {
                    PagesServicesFragment.m3316a(this.f2365b, this.f2365b.jW_().getString(2131235516));
                    return;
                }
                PagesServicesFragment.m3316a(this.f2365b, null);
                if (b.d() != null && b.d().b() != null) {
                    int count = this.f2365b.as.getCount();
                    PagesServicesFragment pagesServicesFragment = this.f2365b;
                    CatalogItemsModel b2 = b.d().b();
                    ImmutableList copyOf = ImmutableList.copyOf(b.c());
                    String b3 = b.b();
                    int i = 0;
                    pagesServicesFragment.at = new ArrayList();
                    ImmutableList a = b2.a();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        EdgesModel edgesModel = (EdgesModel) a.get(i2);
                        if (!(edgesModel.a() == null || Strings.isNullOrEmpty(edgesModel.a().d()) || Strings.isNullOrEmpty(edgesModel.a().eC_()))) {
                            pagesServicesFragment.at.add(edgesModel.a());
                        }
                    }
                    if (copyOf.isEmpty()) {
                        pagesServicesFragment.au = new ArrayList();
                        Iterator it = pagesServicesFragment.at.iterator();
                        while (it.hasNext() && i < 10) {
                            int i3;
                            PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) it.next();
                            if (PagesServiceUtils.m3305a(pageServiceItemModel) != null) {
                                pagesServicesFragment.au.add(pageServiceItemModel);
                                i3 = i + 1;
                            } else {
                                i3 = i;
                            }
                            i = i3;
                        }
                    } else {
                        pagesServicesFragment.au = copyOf;
                    }
                    if (PagesServicesFragment.m3320b(b3)) {
                        pagesServicesFragment.aw = b3;
                    }
                    PagesServicesFragment.av(pagesServicesFragment);
                    if (z && count != this.f2365b.as.getCount()) {
                        PagesServicesFragment.ay(this.f2365b);
                    }
                }
            }

            protected final void m3313a(Throwable th) {
                ((AbstractFbErrorReporter) this.f2365b.f2368c.get()).a("PagesServicesFragment", th);
                PagesServicesFragment.m3316a(this.f2365b, this.f2365b.jW_().getString(2131235516));
            }
        });
    }

    private void ax() {
        if (this.aB == null) {
            if (this.aC == null) {
                this.aB = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.aB = new ReactionHeaderTouchDelegateView(this.aC);
                this.aC.a(this.aB);
            }
            this.aB.c = true;
        } else if (this.aC != null) {
            this.aB.a = this.aC;
            this.aC.a(this.aB);
            this.aB.requestLayout();
        }
    }

    public final void m3328a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aE = pagesSurfaceFragment;
    }

    public final void m3331j() {
        m3319a(true);
    }

    public final void m3329a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aC = reactionHeaderViewWithTouchDelegate;
        ax();
    }

    public final void D_(int i) {
        this.aH = i;
        PagesScrollUtils.a(this.ar, this.aH);
    }

    public final void E_(int i) {
        if (this.aI < 0 || i <= this.aI) {
            m3321g(i);
        }
    }

    public final void m3327a(C05581 c05581) {
        this.aM = c05581;
    }

    private void m3321g(int i) {
        this.aI = i;
        if (this.aD != null) {
            this.aD.setLayoutParams(new LayoutParams(-1, this.aI));
        }
    }

    public static void ay(PagesServicesFragment pagesServicesFragment) {
        pagesServicesFragment.aK = false;
        pagesServicesFragment.m3321g(pagesServicesFragment.f2372g.d());
    }

    private void aA() {
        this.aq.setVisibility(8);
        this.aq.a(false);
    }

    private void aB() {
        if (this.ap.f2415a) {
            this.am.a(FunnelRegistry.L, "admin_can_edit");
        }
        if (this.f2374i.a(1051, false)) {
            this.am.a(FunnelRegistry.L, "use_react_native");
        }
    }

    public static boolean m3320b(String str) {
        return !StringUtil.a(str) && ("published".equals(str) || "staging".equals(str));
    }
}
