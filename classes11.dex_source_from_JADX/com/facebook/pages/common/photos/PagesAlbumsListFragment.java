package com.facebook.pages.common.photos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.ipc.profile.TimelinePhotoEditMode;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.photos.PagesAlbumsAdapter.PagesAlbumsAdapterBaseViewHolder;
import com.facebook.pages.common.recyclerview.PageRecyclerViewAdapter;
import com.facebook.pages.common.recyclerview.SelectiveDividerWithPaddingDecorator;
import com.facebook.pages.common.recyclerview.SelectiveDividerWithPaddingDecorator.DividerPadding;
import com.facebook.pages.common.surfaceinterfaces.PagesPhotosTabFragmentDelegate;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesScrollUtils;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.C05581;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumCreatedEventSubscriber;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumDeletedEventSubscriber;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumTitleRenamedEventSubscriber;
import com.facebook.photos.albums.futures.AlbumsFuturesGenerator;
import com.facebook.photos.intent.PhotosViewIntentBuilder;
import com.facebook.photos.intent.PhotosViewIntentProvider;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderTouchDelegateView;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: setTextWithEntities */
public class PagesAlbumsListFragment extends FbFragment implements PagesSurfaceTabFragment {
    public static final CallerContext f1723a = CallerContext.a(PagesAlbumsListFragment.class, "pages_public_view");
    public static int aq = 3;
    public boolean aA = false;
    public String aB;
    private CallerContext aC;
    @Nullable
    public ArrayList<String> aD;
    @Nullable
    public ComposerTargetData aE;
    public String aF = null;
    public boolean aG = false;
    private ReactionHeaderTouchDelegateView aH;
    private ReactionHeaderViewWithTouchDelegate aI;
    private View aJ;
    public PagesSurfaceFragment aK;
    public int aL;
    private int aM;
    private int aN = -1;
    @Inject
    public Lazy<FbErrorReporter> al;
    @Inject
    Lazy<GraphQLCacheManager> am;
    @Inject
    public Lazy<SecureContextHelper> an;
    @Inject
    Lazy<PhotosViewIntentBuilder> ao;
    @Inject
    public Lazy<PagesAnalytics> ap;
    private final AlbumCreatedEventSubscriber ar = new C02331(this);
    private final AlbumDeletedEventSubscriber as = new C02342(this);
    private final AlbumTitleRenamedEventSubscriber at = new C02353(this);
    private RecyclerView au;
    public LinearLayoutManager av;
    public PagesAlbumsAdapter aw;
    public PageRecyclerViewAdapter ax;
    private EmptyListViewItem ay;
    public boolean az = false;
    @Inject
    AlbumsEventBus f1724b;
    @Inject
    AlbumsFuturesGenerator f1725c;
    @Inject
    PagesAlbumsAdapterProvider f1726d;
    @Inject
    TasksManager f1727e;
    @Inject
    ViewerContext f1728f;
    @Inject
    AdminedPagesRamCache f1729g;
    @Inject
    ViewerContextManager f1730h;
    @Inject
    public Lazy<AlbumCreatorIntentBuilder> f1731i;

    /* compiled from: setTextWithEntities */
    class C02331 extends AlbumCreatedEventSubscriber {
        final /* synthetic */ PagesAlbumsListFragment f1712a;

        C02331(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1712a = pagesAlbumsListFragment;
        }

        public final void m2523b(FbEvent fbEvent) {
            PagesAlbumsListFragment.ax(this.f1712a);
            this.f1712a.m2550j();
        }
    }

    /* compiled from: setTextWithEntities */
    class C02342 extends AlbumDeletedEventSubscriber {
        final /* synthetic */ PagesAlbumsListFragment f1713a;

        C02342(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1713a = pagesAlbumsListFragment;
        }

        public final void m2524b(FbEvent fbEvent) {
            PagesAlbumsListFragment.ax(this.f1713a);
            this.f1713a.m2550j();
        }
    }

    /* compiled from: setTextWithEntities */
    class C02353 extends AlbumTitleRenamedEventSubscriber {
        final /* synthetic */ PagesAlbumsListFragment f1714a;

        C02353(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1714a = pagesAlbumsListFragment;
        }

        public final void m2525b(FbEvent fbEvent) {
            PagesAlbumsListFragment.ax(this.f1714a);
            this.f1714a.m2550j();
        }
    }

    /* compiled from: setTextWithEntities */
    class C02375 extends OnScrollListener {
        final /* synthetic */ PagesAlbumsListFragment f1717a;

        C02375(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1717a = pagesAlbumsListFragment;
        }

        public final void m2531a(RecyclerView recyclerView, int i) {
        }

        public final void m2532a(RecyclerView recyclerView, int i, int i2) {
            if (PagesAlbumsListFragment.av(this.f1717a)) {
                int l = this.f1717a.av.l();
                if (recyclerView.getChildAt(0) != null && this.f1717a.aK != null) {
                    int top = recyclerView.getChildAt(0).getTop();
                    if (!(this.f1717a.aK == null || this.f1717a.aL == top || !this.f1717a.D())) {
                        this.f1717a.aK.m5039a((ViewGroup) recyclerView, l);
                        this.f1717a.aL = top;
                    }
                } else {
                    return;
                }
            }
            if (this.f1717a.aA && !this.f1717a.az && this.f1717a.aG && this.f1717a.av.n() + PagesAlbumsListFragment.aq > this.f1717a.av.D()) {
                PagesAlbumsListFragment.m2537a(this.f1717a, GraphQLCachePolicy.c, null);
            }
        }
    }

    /* compiled from: setTextWithEntities */
    public class C02386 {
        public final /* synthetic */ PagesAlbumsListFragment f1718a;

        public C02386(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1718a = pagesAlbumsListFragment;
        }
    }

    /* compiled from: setTextWithEntities */
    public class C02397 {
        final /* synthetic */ PagesAlbumsListFragment f1719a;

        public C02397(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1719a = pagesAlbumsListFragment;
        }

        public final void m2533a(String str, String str2, int i) {
            ((PagesAnalytics) this.f1719a.ap.get()).a(Long.parseLong(this.f1719a.aB), str, str2, i, "redesign_albums_list", false);
            if (PagesAlbumsListFragment.av(this.f1719a)) {
                Fragment fragment = this.f1719a.G;
                Builder builder = new Builder();
                builder.o = str;
                GraphQLAlbum a = builder.a();
                TimelinePhotoTabModeParams timelinePhotoTabModeParams = new TimelinePhotoTabModeParams(TimelinePhotoEditMode.VIEWING_MODE, Long.parseLong(this.f1719a.aB));
                CallerContext callerContext = PagesAlbumsListFragment.f1723a;
                ArrayList arrayList = this.f1719a.aD;
                ComposerTargetData composerTargetData = this.f1719a.aE;
                Preconditions.checkNotNull(a);
                Preconditions.checkNotNull(callerContext);
                Bundle bundle = new Bundle();
                FlatBufferModelHelper.a(bundle, "extra_album_selected", a);
                bundle.putParcelable("extra_caller_context", callerContext);
                bundle.putStringArrayList("extra_pages_admin_permissions", arrayList);
                bundle.putParcelable("extra_composer_target_data", composerTargetData);
                bundle.putParcelable("extra_photo_tab_mode_params", timelinePhotoTabModeParams);
                new PagesAlbumPhotosGridFragment().g(bundle);
                return;
            }
            Context ao = this.f1719a.ao();
            builder = new Builder();
            builder.o = str;
            GraphQLAlbum a2 = builder.a();
            Intent a3 = ((PhotosViewIntentProvider) this.f1719a.ao.get()).a(ao, a2.u());
            FlatBufferModelHelper.a(a3, "extra_album_selected", a2);
            a3.putExtra("extra_photo_tab_mode_params", new TimelinePhotoTabModeParams(TimelinePhotoEditMode.VIEWING_MODE, Long.parseLong(this.f1719a.f1728f.mUserId)));
            a3.putExtra("is_page", true);
            a3.putExtra("owner_id", Long.parseLong(this.f1719a.aB));
            a3.putExtra("pick_hc_pic", false);
            a3.putExtra("pick_pic_lite", false);
            a3.putExtra("disable_adding_photos_to_albums", false);
            ViewerContext at = PagesAlbumsListFragment.at(this.f1719a);
            if (at != null) {
                a3.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", at);
                if (!(this.f1719a.aD == null || this.f1719a.aD.isEmpty())) {
                    a3.putStringArrayListExtra("extra_pages_admin_permissions", this.f1719a.aD);
                }
                a3.putExtra("extra_composer_target_data", this.f1719a.aE);
            }
            ((SecureContextHelper) this.f1719a.an.get()).a(a3, ao);
        }
    }

    /* compiled from: setTextWithEntities */
    class C02408 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PagesAlbumsListFragment f1720a;

        C02408(PagesAlbumsListFragment pagesAlbumsListFragment) {
            this.f1720a = pagesAlbumsListFragment;
        }

        protected final void m2534a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (!this.f1720a.aA && operationResult != null && operationResult.b) {
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) operationResult.k();
                if (graphQLAlbumsConnection != null && this.f1720a.aw != null) {
                    this.f1720a.aw.m2518a(graphQLAlbumsConnection);
                    if (this.f1720a.ax != null) {
                        this.f1720a.ax.notifyDataSetChanged();
                    }
                }
            }
        }

        protected final void m2535a(Throwable th) {
            ((AbstractFbErrorReporter) this.f1720a.al.get()).a("loadPagesAlbumsListFromCache", th);
        }
    }

    public static void m2539a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesAlbumsListFragment) obj).m2538a(AlbumsEventBus.a(fbInjector), AlbumsFuturesGenerator.a(fbInjector), (PagesAlbumsAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PagesAlbumsAdapterProvider.class), TasksManager.b(fbInjector), ViewerContextMethodAutoProvider.b(fbInjector), AdminedPagesRamCache.a(fbInjector), ViewerContextManagerProvider.b(fbInjector), IdBasedLazy.a(fbInjector, 9243), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedSingletonScopeProvider.b(fbInjector, 2179), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 9340), IdBasedSingletonScopeProvider.b(fbInjector, 8930));
    }

    private void m2538a(AlbumsEventBus albumsEventBus, AlbumsFuturesGenerator albumsFuturesGenerator, PagesAlbumsAdapterProvider pagesAlbumsAdapterProvider, TasksManager tasksManager, ViewerContext viewerContext, AdminedPagesRamCache adminedPagesRamCache, ViewerContextManager viewerContextManager, Lazy<AlbumCreatorIntentBuilder> lazy, Lazy<FbErrorReporter> lazy2, Lazy<GraphQLCacheManager> lazy3, Lazy<SecureContextHelper> lazy4, Lazy<PhotosViewIntentBuilder> lazy5, Lazy<PagesAnalytics> lazy6) {
        this.f1724b = albumsEventBus;
        this.f1725c = albumsFuturesGenerator;
        this.f1726d = pagesAlbumsAdapterProvider;
        this.f1727e = tasksManager;
        this.f1728f = viewerContext;
        this.f1729g = adminedPagesRamCache;
        this.f1730h = viewerContextManager;
        this.f1731i = lazy;
        this.al = lazy2;
        this.am = lazy3;
        this.an = lazy4;
        this.ao = lazy5;
        this.ap = lazy6;
    }

    public static PagesAlbumsListFragment m2536a(String str, CallerContext callerContext, @Nullable ArrayList<String> arrayList, @Nullable ComposerTargetData composerTargetData) {
        Bundle bundle = new Bundle();
        bundle.putLong("owner_id", Long.parseLong(str));
        bundle.putParcelable("extra_caller_context", callerContext);
        if (arrayList != null) {
            bundle.putStringArrayList("extra_pages_admin_permissions", arrayList);
        }
        if (composerTargetData != null) {
            bundle.putParcelable("extra_composer_target_data", composerTargetData);
        }
        PagesAlbumsListFragment pagesAlbumsListFragment = new PagesAlbumsListFragment();
        pagesAlbumsListFragment.g(bundle);
        return pagesAlbumsListFragment;
    }

    public final void m2549c(Bundle bundle) {
        super.c(bundle);
        Class cls = PagesAlbumsListFragment.class;
        m2539a((Object) this, getContext());
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            m2542n(bundle2);
        }
        if (!av(this)) {
            aq += 2;
        }
        this.f1724b.a(this.ar);
        this.f1724b.a(this.as);
        this.f1724b.a(this.at);
    }

    public final View m2544a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1049583850);
        aq();
        View inflate = layoutInflater.inflate(2130905966, viewGroup, false);
        this.au = (RecyclerView) FindViewUtil.b(inflate, 2131565366);
        m2541e();
        this.ay = new EmptyListViewItem(getContext());
        this.ay.setLayoutParams(new LayoutParams(-1, -2));
        this.ay.setBackgroundResource(0);
        ay(this);
        this.aJ = new View(getContext());
        E_(this.aN);
        if (this.aw == null) {
            ar();
            aw();
            m2537a(this, GraphQLCachePolicy.d, AlbumsFuturesGenerator.a(this.aB));
        }
        this.ax = new PageRecyclerViewAdapter(getContext(), m2540b(this.aH), this.aw, m2540b(this.ay), m2540b(this.aJ));
        getContext();
        this.av = new LinearLayoutManager(1, false);
        this.au.a(new SelectiveDividerWithPaddingDecorator(this, jW_().getDrawable(2130842488)) {
            final /* synthetic */ PagesAlbumsListFragment f1716a;

            protected final boolean mo41a(View view, RecyclerView recyclerView) {
                return recyclerView.a(view) instanceof PagesAlbumsAdapterBaseViewHolder;
            }

            protected final DividerPadding mo42b(View view, RecyclerView recyclerView) {
                BetterTextView betterTextView = (BetterTextView) FindViewUtil.b(view, 2131565368);
                Object obj = ViewCompat.h(view) == 0 ? 1 : null;
                return new DividerPadding(obj != null ? betterTextView.getLeft() : recyclerView.getPaddingLeft(), obj != null ? recyclerView.getWidth() - recyclerView.getPaddingRight() : betterTextView.getRight());
            }
        });
        this.au.setLayoutManager(this.av);
        this.au.setAdapter(this.ax);
        this.au.a(new C02375(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1695158496, a);
        return inflate;
    }

    public final void m2545a(View view, Bundle bundle) {
        super.a(view, bundle);
        D_(this.aM);
    }

    private void m2541e() {
        if (this.aH == null) {
            if (this.aI == null) {
                this.aH = new ReactionHeaderTouchDelegateView(new View(getContext()));
            } else {
                this.aH = new ReactionHeaderTouchDelegateView(this.aI);
                this.aI.a(this.aH);
            }
            this.aH.c = true;
        } else if (this.aI != null) {
            this.aH.a = this.aI;
            this.aI.a(this.aH);
            this.aH.requestLayout();
        }
    }

    public final void m2543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2029838695);
        this.f1724b.b(this.ar);
        this.f1724b.b(this.as);
        this.f1724b.b(this.at);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1712566232, a);
    }

    private void aq() {
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) this.f1729g.b(this.aB);
        if (adminedPagesPrefetchNode != null && adminedPagesPrefetchNode.b.isPresent() && !this.f1728f.mIsPageContext) {
            ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
            newBuilder.d = true;
            newBuilder = newBuilder;
            newBuilder.c = this.f1728f.mSessionCookiesString;
            newBuilder = newBuilder;
            newBuilder.f = this.f1728f.mSessionKey;
            newBuilder = newBuilder;
            newBuilder.e = this.f1728f.mSessionSecret;
            newBuilder = newBuilder;
            newBuilder.a = this.aB;
            ViewerContextBuilder viewerContextBuilder = newBuilder;
            viewerContextBuilder.b = (String) adminedPagesPrefetchNode.b.get();
            newBuilder = viewerContextBuilder;
            newBuilder.g = adminedPagesPrefetchNode.a.d();
            this.f1730h.a(newBuilder.h());
        }
    }

    private void m2542n(Bundle bundle) {
        long j = bundle.getLong("owner_id", -1);
        if (j == -1) {
            throw new IllegalArgumentException("Invalid page id " + this.aB);
        }
        this.aB = String.valueOf(j);
        this.aC = (CallerContext) bundle.getParcelable("extra_caller_context");
        if (this.aC == null) {
            throw new IllegalArgumentException("Invalid caller context " + this.aC);
        }
        this.aD = bundle.getStringArrayList("extra_pages_admin_permissions");
        this.aE = (ComposerTargetData) bundle.getParcelable("extra_composer_target_data");
    }

    private static View m2540b(View view) {
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        return view;
    }

    private void ar() {
        C02386 c02386;
        List arrayList = new ArrayList();
        boolean z = this.aD != null && new ProfilePermissions(this.aD).a(Permission.CREATE_CONTENT);
        PagesAlbumsAdapterProvider pagesAlbumsAdapterProvider = this.f1726d;
        Context context = getContext();
        C02397 c02397 = new C02397(this);
        if (z) {
            c02386 = new C02386(this);
        } else {
            c02386 = null;
        }
        this.aw = pagesAlbumsAdapterProvider.m2520a(context, arrayList, z, c02397, c02386);
    }

    @Nullable
    public static ViewerContext at(PagesAlbumsListFragment pagesAlbumsListFragment) {
        if (pagesAlbumsListFragment.f1728f.mIsPageContext) {
            return pagesAlbumsListFragment.f1728f;
        }
        Object obj;
        ViewerContext b = pagesAlbumsListFragment.f1730h.b();
        if (b == null || !b.mIsPageContext) {
            obj = null;
        } else {
            obj = 1;
        }
        return obj == null ? null : b;
    }

    private void aw() {
        final ListenableFuture a = this.f1725c.a(this.aB, 250, GraphQLCachePolicy.b, null, 20, null);
        C02408 c02408 = new C02408(this);
        this.f1727e.a(StringFormatUtil.a("loadPagesAlbumsListFromCache_%s", new Object[]{this.aB}), new Callable<ListenableFuture>(this) {
            final /* synthetic */ PagesAlbumsListFragment f1722b;

            public Object call() {
                return a;
            }
        }, c02408);
    }

    public static void m2537a(PagesAlbumsListFragment pagesAlbumsListFragment, @Nullable GraphQLCachePolicy graphQLCachePolicy, Set set) {
        String str;
        pagesAlbumsListFragment.az = true;
        ay(pagesAlbumsListFragment);
        final ListenableFuture a = pagesAlbumsListFragment.f1725c.a(pagesAlbumsListFragment.aB, 250, graphQLCachePolicy, pagesAlbumsListFragment.aF, 20, set);
        AnonymousClass10 anonymousClass10 = new AbstractDisposableFutureCallback<OperationResult>(pagesAlbumsListFragment) {
            final /* synthetic */ PagesAlbumsListFragment f1709a;

            {
                this.f1709a = r1;
            }

            protected final void m2521a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                boolean z = true;
                this.f1709a.aA = true;
                this.f1709a.az = false;
                PagesAlbumsListFragment.ay(this.f1709a);
                if (operationResult != null && operationResult.b) {
                    GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) operationResult.k();
                    if (graphQLAlbumsConnection != null && this.f1709a.aw != null) {
                        if (this.f1709a.aF != null) {
                            z = false;
                        }
                        if (z) {
                            this.f1709a.aw.m2519d();
                        }
                        this.f1709a.aw.m2518a(graphQLAlbumsConnection);
                        if (graphQLAlbumsConnection.j() != null) {
                            this.f1709a.aF = graphQLAlbumsConnection.j().a();
                            this.f1709a.aG = graphQLAlbumsConnection.j().b();
                        } else {
                            this.f1709a.aG = false;
                        }
                        if (this.f1709a.ax != null) {
                            this.f1709a.ax.notifyDataSetChanged();
                        }
                    }
                }
            }

            protected final void m2522a(Throwable th) {
                this.f1709a.az = false;
                PagesAlbumsListFragment.ay(this.f1709a);
                ((AbstractFbErrorReporter) this.f1709a.al.get()).a("fetchPagesAlbumsList", th);
            }
        };
        TasksManager tasksManager = pagesAlbumsListFragment.f1727e;
        String str2 = "fetchPagesAlbumsList_%s_%s";
        Object[] objArr = new Object[2];
        objArr[0] = pagesAlbumsListFragment.aB;
        if (pagesAlbumsListFragment.aF == null) {
            str = "null";
        } else {
            str = pagesAlbumsListFragment.aF;
        }
        objArr[1] = str;
        tasksManager.a(StringFormatUtil.a(str2, objArr), new Callable<ListenableFuture>(pagesAlbumsListFragment) {
            final /* synthetic */ PagesAlbumsListFragment f1711b;

            public Object call() {
                return a;
            }
        }, anonymousClass10);
    }

    public static void ax(PagesAlbumsListFragment pagesAlbumsListFragment) {
        Preconditions.checkArgument(!StringUtil.a(pagesAlbumsListFragment.aB), "Invalid pageId");
        ((GraphQLCacheManager) pagesAlbumsListFragment.am.get()).a(AlbumsFuturesGenerator.a(pagesAlbumsListFragment.aB));
    }

    public static void ay(PagesAlbumsListFragment pagesAlbumsListFragment) {
        if (pagesAlbumsListFragment.ay != null) {
            pagesAlbumsListFragment.ay.a(pagesAlbumsListFragment.az);
            pagesAlbumsListFragment.ay.setVisibility(pagesAlbumsListFragment.az ? 0 : 8);
        }
    }

    public final void m2547a(PagesSurfaceFragment pagesSurfaceFragment) {
        this.aK = pagesSurfaceFragment;
    }

    public final void m2550j() {
        this.aF = null;
        this.aA = false;
        this.aw.m2519d();
        this.ax.notifyDataSetChanged();
        m2537a(this, GraphQLCachePolicy.d, AlbumsFuturesGenerator.a(this.aB));
    }

    public final void m2548a(ReactionHeaderViewWithTouchDelegate reactionHeaderViewWithTouchDelegate) {
        this.aI = reactionHeaderViewWithTouchDelegate;
        m2541e();
    }

    public final void D_(int i) {
        this.aM = i;
        PagesScrollUtils.a(this.au, this.aM);
    }

    public final void E_(int i) {
        if (this.aN < 0 || i <= this.aN) {
            this.aN = i;
            if (this.aJ != null) {
                this.aJ.setLayoutParams(new AbsListView.LayoutParams(-1, this.aN));
            }
        }
    }

    public final void m2546a(C05581 c05581) {
    }

    public static boolean av(PagesAlbumsListFragment pagesAlbumsListFragment) {
        return pagesAlbumsListFragment.G instanceof PagesPhotosTabFragmentDelegate;
    }
}
