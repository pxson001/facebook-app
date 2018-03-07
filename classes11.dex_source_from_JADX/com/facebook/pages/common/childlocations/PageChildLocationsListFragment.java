package com.facebook.pages.common.childlocations;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.device.ScreenUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQL;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQL.ChildLocationQueryWithViewerLocationString;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQL.ChildLocationQueryWithoutViewerLocationString;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationConnectionFieldsModel.NodesModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationQueryWithViewerLocationModel;
import com.facebook.pages.data.graphql.cards.ChildLocationCardGraphQLModels.ChildLocationQueryWithoutViewerLocationModel;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: step_no_change_text */
public class PageChildLocationsListFragment extends FbFragment implements AnalyticsFragment, PagesSurfaceTabFragment {
    public static final int[] aA = new int[2];
    @Inject
    PageChildLocationsListAdapterProvider f1368a;
    public boolean aB = false;
    public int aC = -1;
    private String al;
    public Location am;
    public int an;
    public int ao;
    public ImmutableList<NodesModel> ap;
    public ListView aq;
    public PageChildLocationsListAdapter ar;
    private ReactionHeaderTouchDelegateView as;
    private ReactionHeaderViewWithTouchDelegate at;
    public View au;
    public PagesSurfaceFragment av;
    private boolean aw = false;
    public int ax;
    private int ay;
    private int az = -1;
    @Inject
    FbTitleBarSupplier f1369b;
    @Inject
    TasksManager f1370c;
    @Inject
    AbstractFbErrorReporter f1371d;
    @Inject
    GraphQLQueryExecutor f1372e;
    @Inject
    GraphQLImageHelper f1373f;
    @Inject
    public FbLocationCache f1374g;
    @Inject
    ScreenUtil f1375h;
    public String f1376i;

    /* compiled from: step_no_change_text */
    class C01821 implements OnScrollListener {
        final /* synthetic */ PageChildLocationsListFragment f1365a;

        C01821(PageChildLocationsListFragment pageChildLocationsListFragment) {
            this.f1365a = pageChildLocationsListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int count = this.f1365a.aq.getAdapter() != null ? this.f1365a.aq.getAdapter().getCount() : 0;
            if (!(this.f1365a.aB && this.f1365a.aC == count)) {
                Pair a = PagesScrollUtils.a(this.f1365a.au, this.f1365a.aq, i, PageChildLocationsListFragment.aA, this.f1365a.f1375h.d());
                this.f1365a.aB = ((Boolean) a.a).booleanValue();
                if (this.f1365a.aB) {
                    this.f1365a.E_(((Integer) a.b).intValue());
                    this.f1365a.aC = count;
                }
            }
            if (this.f1365a.aq.getChildAt(0) != null) {
                int top = this.f1365a.aq.getChildAt(0).getTop();
                if (this.f1365a.av != null && this.f1365a.ax != top && this.f1365a.D()) {
                    this.f1365a.av.m5039a(this.f1365a.aq, i);
                    this.f1365a.ax = top;
                }
            }
        }
    }

    /* compiled from: step_no_change_text */
    class C01832 implements Callable<ListenableFuture<? extends GraphQLResult<?>>> {
        final /* synthetic */ PageChildLocationsListFragment f1366a;

        C01832(PageChildLocationsListFragment pageChildLocationsListFragment) {
            this.f1366a = pageChildLocationsListFragment;
        }

        public Object call() {
            GraphQLRequest a;
            GraphQLQueryExecutor graphQLQueryExecutor = this.f1366a.f1372e;
            PageChildLocationsListFragment pageChildLocationsListFragment = this.f1366a;
            Location location = pageChildLocationsListFragment.am;
            if (location == null) {
                ImmutableLocation a2 = pageChildLocationsListFragment.f1374g.a(1800000);
                if (a2 != null) {
                    location = a2.l();
                }
            }
            GraphQLRequest a3;
            if (location != null) {
                a3 = GraphQLRequest.a((ChildLocationQueryWithViewerLocationString) ChildLocationCardGraphQL.a().a("page_id", pageChildLocationsListFragment.f1376i).a("user_image_size", Integer.valueOf(pageChildLocationsListFragment.ao)).a("viewer_latitude", Double.valueOf(location.getLatitude())).a("viewer_longitude", Double.valueOf(location.getLongitude())).a("max_child_locations", Integer.valueOf(pageChildLocationsListFragment.an)));
                a3.e = ImmutableSet.of("GraphQlPageCardTag");
                a = a3.a(RequestPriority.INTERACTIVE);
            } else {
                a3 = GraphQLRequest.a((ChildLocationQueryWithoutViewerLocationString) ChildLocationCardGraphQL.b().a("page_id", pageChildLocationsListFragment.f1376i).a("user_image_size", Integer.valueOf(pageChildLocationsListFragment.ao)).a("max_child_locations", Integer.valueOf(pageChildLocationsListFragment.an)));
                a3.e = ImmutableSet.of("GraphQlPageCardTag");
                a = a3.a(RequestPriority.INTERACTIVE);
            }
            return graphQLQueryExecutor.a(a);
        }
    }

    /* compiled from: step_no_change_text */
    class C01843 extends AbstractDisposableFutureCallback<GraphQLResult<?>> {
        final /* synthetic */ PageChildLocationsListFragment f1367a;

        C01843(PageChildLocationsListFragment pageChildLocationsListFragment) {
            this.f1367a = pageChildLocationsListFragment;
        }

        protected final void m2003a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null) {
                if (graphQLResult.e instanceof ChildLocationQueryWithViewerLocationModel) {
                    ChildLocationQueryWithViewerLocationModel childLocationQueryWithViewerLocationModel = (ChildLocationQueryWithViewerLocationModel) graphQLResult.e;
                    if (childLocationQueryWithViewerLocationModel.a() != null && !childLocationQueryWithViewerLocationModel.a().a().isEmpty()) {
                        this.f1367a.ar.clear();
                        this.f1367a.ap = childLocationQueryWithViewerLocationModel.a().a();
                        this.f1367a.ar.addAll(this.f1367a.ap);
                    }
                } else if (graphQLResult.e instanceof ChildLocationQueryWithoutViewerLocationModel) {
                    ChildLocationQueryWithoutViewerLocationModel childLocationQueryWithoutViewerLocationModel = (ChildLocationQueryWithoutViewerLocationModel) graphQLResult.e;
                    if (childLocationQueryWithoutViewerLocationModel.a() != null && !childLocationQueryWithoutViewerLocationModel.a().a().isEmpty()) {
                        this.f1367a.ar.clear();
                        this.f1367a.ap = childLocationQueryWithoutViewerLocationModel.a().a();
                        this.f1367a.ar.addAll(this.f1367a.ap);
                    }
                } else {
                    this.f1367a.f1371d.b(getClass().getSimpleName(), "Unknown returned location model");
                }
            }
        }

        protected final void m2004a(Throwable th) {
            this.f1367a.f1371d.a(getClass().getSimpleName(), th);
        }
    }

    /* compiled from: step_no_change_text */
    enum Tasks {
        FETCH_CHILD_LOCATIONS
    }

    public static void m2007a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageChildLocationsListFragment) obj).m2006a((PageChildLocationsListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PageChildLocationsListAdapterProvider.class), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector), TasksManager.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), GraphQLImageHelper.a(fbInjector), FbLocationCache.b(fbInjector), ScreenUtil.a(fbInjector));
    }

    private void m2006a(PageChildLocationsListAdapterProvider pageChildLocationsListAdapterProvider, FbTitleBarSupplier fbTitleBarSupplier, TasksManager tasksManager, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, FbLocationCache fbLocationCache, ScreenUtil screenUtil) {
        this.f1368a = pageChildLocationsListAdapterProvider;
        this.f1369b = fbTitleBarSupplier;
        this.f1370c = tasksManager;
        this.f1371d = abstractFbErrorReporter;
        this.f1372e = graphQLQueryExecutor;
        this.f1373f = graphQLImageHelper;
        this.f1374g = fbLocationCache;
        this.f1375h = screenUtil;
    }

    public static PageChildLocationsListFragment m2005a(ArrayList<NodesModel> arrayList, Location location, String str, String str2, boolean z) {
        PageChildLocationsListFragment pageChildLocationsListFragment = new PageChildLocationsListFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "extra_child_locations", arrayList);
        bundle.putParcelable("extra_page_user_location", location);
        bundle.putString("com.facebook.katana.profile.id", str);
        bundle.putString("extra_page_name", str2);
        bundle.putBoolean("extra_is_inside_page_surface_tab", z);
        pageChildLocationsListFragment.g(bundle);
        return pageChildLocationsListFragment;
    }

    public final void m2014c(Bundle bundle) {
        super.c(bundle);
        Class cls = PageChildLocationsListFragment.class;
        m2007a((Object) this, getContext());
        this.an = jW_().getInteger(2131492914);
        this.ao = GraphQLImageHelper.a(jW_().getDimensionPixelSize(2131429986)).intValue();
        Bundle bundle2 = this.s;
        this.f1376i = bundle2.getString("com.facebook.katana.profile.id");
        this.al = bundle2.getString("extra_page_name");
        this.am = (Location) bundle2.getParcelable("extra_page_user_location");
        this.aw = bundle2.getBoolean("extra_is_inside_page_surface_tab");
    }

    public final View m2009a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1110718062);
        View inflate = layoutInflater.inflate(2130903092, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) FindViewUtil.b(inflate, 2131559224);
        this.aq = (ListView) FindViewUtil.b(inflate, 2131559225);
        if (this.aw) {
            inflate.setBackgroundResource(0);
            linearLayout.setPadding(0, jW_().getDimensionPixelSize(2131427418), 0, 0);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 389516900, a);
        return inflate;
    }

    public final void m2010a(View view, Bundle bundle) {
        List list;
        super.a(view, bundle);
        if (this.aw) {
            as();
            this.aq.setVerticalScrollBarEnabled(false);
            this.aq.addHeaderView(this.as);
            this.au = new View(getContext());
            E_(this.az);
            this.aq.addFooterView(this.au);
            this.aq.setOnScrollListener(new C01821(this));
        }
        List b = FlatBufferModelHelper.b(this.s, "extra_child_locations");
        PageChildLocationsListAdapterProvider pageChildLocationsListAdapterProvider = this.f1368a;
        if (b != null) {
            list = b;
        } else {
            list = new ArrayList();
        }
        this.ar = new PageChildLocationsListAdapter((Context) pageChildLocationsListAdapterProvider.getInstance(Context.class), list, (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(pageChildLocationsListAdapterProvider), (SecureContextHelper) DefaultSecureContextHelper.a(pageChildLocationsListAdapterProvider));
        this.aq.setAdapter(this.ar);
        if (this.aw) {
            D_(this.ay);
        }
        if (b == null) {
            m2008a(true);
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -50076767);
        super.mi_();
        if (!(this.aw || StringUtil.c(this.al))) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            FbTitleBar fbTitleBar = (FbTitleBar) this.f1369b.get();
            if (hasTitleBar != null) {
                hasTitleBar.a_(this.al);
            } else if (fbTitleBar != null) {
                fbTitleBar.setTitle(this.al);
            }
        }
        LogUtils.f(1787249238, a);
    }

    private void m2008a(boolean z) {
        if (!z || this.ap == null || this.ap.isEmpty()) {
            this.f1370c.a(Tasks.FETCH_CHILD_LOCATIONS, new C01832(this), new C01843(this));
            return;
        }
        this.ar.clear();
        this.ar.addAll(this.ap);
    }

    public final String am_() {
        return "page_child_locations_list_activity";
    }

    private void as() {
        if (this.as == null) {
            if (this.at == null) {
                this.as = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.as = new ReactionHeaderTouchDelegateView(this.at);
                this.at.a(this.as);
            }
            this.as.c = true;
        } else if (this.at != null) {
            this.as.a = this.at;
            this.at.a(this.as);
            this.as.requestLayout();
        }
    }

    public final void m2012a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.av = pagesSurfaceFragment;
    }

    public final void m2015j() {
        m2008a(false);
    }

    public final void m2013a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.at = reactionHeaderViewWithTouchDelegate;
        as();
    }

    public final void D_(int i) {
        this.ay = i;
        PagesScrollUtils.a(this.aq, this.ay);
    }

    public final void E_(int i) {
        if (this.az < 0 || i <= this.az) {
            this.az = i;
            if (this.au != null) {
                this.au.setLayoutParams(new LayoutParams(-1, this.az));
            }
        }
    }

    public final void m2011a(C05581 c05581) {
    }
}
