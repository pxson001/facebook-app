package com.facebook.photos.photoset.ui.photoset;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.graphql.model.GraphQLMediaSetMediaConnection;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.PandoraAlbumsAdapter;
import com.facebook.photos.albums.abtest.VideoAlbumConfig;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEvent;
import com.facebook.photos.albums.futures.AlbumsFuturesGenerator;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQL.VideosUploadedByUserSimpleQueryString;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoSimpleFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideosUploadedByUserSimpleQueryModel;
import com.facebook.photos.albums.video.VideoAlbumPermalinkActivity;
import com.facebook.photos.albums.video.VideoAlbumPermalinkActivity.VideoAlbumEntityType;
import com.facebook.photos.intent.PhotosViewIntentBuilder;
import com.facebook.photos.intent.PhotosViewIntentProvider;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.ui.FamilyAlbumUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.analytics.VideoAnalytics.VideoAlbumOriginType;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: click_share_button */
public class PandoraAlbumsFragment extends FbFragment {
    private static ComposerTargetData f17916a;
    private Lazy<FbPhotoPickerController> aA;
    private ViewerContext aB;
    private VideoAlbumConfig aC;
    private Lazy<VideoAlbumConfig> aD;
    private Lazy<GraphQLQueryExecutor> aE;
    public Lazy<FbErrorReporter> aF;
    private FamilyAlbumUtil aG;
    private Executor aH;
    public ArrayList<String> al;
    private boolean am;
    private PandoraCustomizedBackgroundConfig an;
    private int ao = -1;
    public boolean ap = false;
    public String aq = null;
    public boolean ar = false;
    public boolean as = false;
    private TimelinePhotoTabModeParams at;
    public String au;
    public Lazy<AlbumsFuturesGenerator> av;
    public Lazy<TasksManager> aw;
    public Lazy<SecureContextHelper> ax;
    private Lazy<AlbumsEventBus> ay;
    private Lazy<PhotosViewIntentBuilder> az;
    private final AlbumSelectedEventSubscriber f17917b = new AlbumSelectedEventSubscriber(this);
    private final VideoAlbumSelectedEventSubscriber f17918c = new VideoAlbumSelectedEventSubscriber(this);
    public BetterListView f17919d;
    private View f17920e;
    private View f17921f;
    public PandoraAlbumsAdapter f17922g;
    public Long f17923h = Long.valueOf(-1);
    private boolean f17924i = false;

    /* compiled from: click_share_button */
    class C19241 implements OnScrollListener {
        final /* synthetic */ PandoraAlbumsFragment f17902a;

        C19241(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17902a = pandoraAlbumsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!this.f17902a.as && this.f17902a.ar && absListView.getLastVisiblePosition() + 3 > this.f17902a.f17922g.getCount()) {
                PandoraAlbumsFragment pandoraAlbumsFragment = this.f17902a;
                ListenableFuture a = ((AlbumsFuturesGenerator) pandoraAlbumsFragment.av.get()).a(String.valueOf(pandoraAlbumsFragment.f17923h), 250, GraphQLCachePolicy.d, pandoraAlbumsFragment.aq, 20);
                TasksManager tasksManager = (TasksManager) pandoraAlbumsFragment.aw.get();
                tasksManager.a(StringFormatUtil.a("fetchMoreAlbumsList_%s", new Object[]{pandoraAlbumsFragment.f17923h}), new C19318(pandoraAlbumsFragment, a), new C19307(pandoraAlbumsFragment));
            }
        }
    }

    /* compiled from: click_share_button */
    class C19252 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PandoraAlbumsFragment f17903a;

        C19252(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17903a = pandoraAlbumsFragment;
        }

        protected final void m21857a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (!this.f17903a.ap && operationResult != null && operationResult.b) {
                PandoraAlbumsFragment.m21872a(this.f17903a, (GraphQLAlbumsConnection) operationResult.k(), false);
            }
        }

        protected final void m21858a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17903a.aF.get()).a("fetchInitialAlbumsList", th);
        }
    }

    /* compiled from: click_share_button */
    class C19263 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PandoraAlbumsFragment f17904a;

        C19263(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17904a = pandoraAlbumsFragment;
        }

        protected final void m21859a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null && operationResult.b) {
                this.f17904a.ap = true;
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) operationResult.k();
                if (graphQLAlbumsConnection == null || graphQLAlbumsConnection.j() == null) {
                    this.f17904a.ar = false;
                } else {
                    this.f17904a.aq = graphQLAlbumsConnection.j().a();
                    this.f17904a.ar = graphQLAlbumsConnection.j().b();
                }
                PandoraAlbumsFragment.m21872a(this.f17904a, graphQLAlbumsConnection, this.f17904a.ar);
            }
        }

        protected final void m21860a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17904a.aF.get()).a("fetchInitialAlbumsList", th);
        }
    }

    /* compiled from: click_share_button */
    class C19296 implements FutureCallback<GraphQLAlbumsConnection> {
        final /* synthetic */ PandoraAlbumsFragment f17909a;

        C19296(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17909a = pandoraAlbumsFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) obj;
            if (graphQLAlbumsConnection != null) {
                this.f17909a.f17922g.a(graphQLAlbumsConnection);
            }
        }

        public void onFailure(Throwable th) {
            ((AbstractFbErrorReporter) this.f17909a.aF.get()).a("fetchFamilyAlbum", th);
        }
    }

    /* compiled from: click_share_button */
    public class C19307 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PandoraAlbumsFragment f17910a;

        public C19307(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17910a = pandoraAlbumsFragment;
        }

        protected final void m21861a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null && operationResult.b) {
                this.f17910a.as = false;
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) operationResult.k();
                if (graphQLAlbumsConnection.j() != null) {
                    this.f17910a.aq = graphQLAlbumsConnection.j().a();
                    this.f17910a.ar = graphQLAlbumsConnection.j().b();
                } else {
                    this.f17910a.ar = false;
                }
                this.f17910a.f17922g.b(graphQLAlbumsConnection, this.f17910a.ar);
            }
        }

        protected final void m21862a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17910a.aF.get()).a("fetchMoreAlbumsList", th);
        }
    }

    /* compiled from: click_share_button */
    public class C19318 implements Callable<ListenableFuture> {
        final /* synthetic */ ListenableFuture f17911a;
        final /* synthetic */ PandoraAlbumsFragment f17912b;

        public C19318(PandoraAlbumsFragment pandoraAlbumsFragment, ListenableFuture listenableFuture) {
            this.f17912b = pandoraAlbumsFragment;
            this.f17911a = listenableFuture;
        }

        public Object call() {
            this.f17912b.as = true;
            return this.f17911a;
        }
    }

    /* compiled from: click_share_button */
    class C19329 extends AbstractDisposableFutureCallback<GraphQLResult<VideosUploadedByUserSimpleQueryModel>> {
        final /* synthetic */ PandoraAlbumsFragment f17913a;

        C19329(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17913a = pandoraAlbumsFragment;
        }

        public final void m21863a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((VideosUploadedByUserSimpleQueryModel) graphQLResult.e).j() != null && ((VideosUploadedByUserSimpleQueryModel) graphQLResult.e).j().j() != null) {
                int a = ((VideosUploadedByUserSimpleQueryModel) graphQLResult.e).j().a();
                ImmutableList j = ((VideosUploadedByUserSimpleQueryModel) graphQLResult.e).j().j();
                if (!j.isEmpty()) {
                    VideoSimpleFragmentModel videoSimpleFragmentModel = (VideoSimpleFragmentModel) j.get(0);
                    Builder builder = new Builder();
                    GraphQLPhoto.Builder builder2 = new GraphQLPhoto.Builder();
                    builder2.ab = DefaultGraphQLConversionHelper.a(videoSimpleFragmentModel.a());
                    builder.d = builder2.a();
                    Builder builder3 = builder;
                    GraphQLMediaSetMediaConnection.Builder builder4 = new GraphQLMediaSetMediaConnection.Builder();
                    builder4.d = a;
                    builder3.q = builder4.a();
                    PandoraAlbumsAdapter pandoraAlbumsAdapter = this.f17913a.f17922g;
                    pandoraAlbumsAdapter.f = builder.a();
                    AdapterDetour.a(pandoraAlbumsAdapter, -1885743790);
                }
            }
        }

        protected final void m21864a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17913a.aF.get()).b("fetchVideoAlbum", th);
        }
    }

    /* compiled from: click_share_button */
    class AlbumSelectedEventSubscriber extends com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEventSubscriber {
        final /* synthetic */ PandoraAlbumsFragment f17914a;

        public AlbumSelectedEventSubscriber(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17914a = pandoraAlbumsFragment;
        }

        public final void m21865b(FbEvent fbEvent) {
            AlbumSelectedEvent albumSelectedEvent = (AlbumSelectedEvent) fbEvent;
            this.f17914a.m21869a(albumSelectedEvent.a);
        }
    }

    /* compiled from: click_share_button */
    class VideoAlbumSelectedEventSubscriber extends com.facebook.photos.albums.events.AlbumsEvents.VideoAlbumSelectedEventSubscriber {
        final /* synthetic */ PandoraAlbumsFragment f17915a;

        public VideoAlbumSelectedEventSubscriber(PandoraAlbumsFragment pandoraAlbumsFragment) {
            this.f17915a = pandoraAlbumsFragment;
        }

        public final void m21866b(FbEvent fbEvent) {
            PandoraAlbumsFragment pandoraAlbumsFragment = this.f17915a;
            ((SecureContextHelper) pandoraAlbumsFragment.ax.get()).a(VideoAlbumPermalinkActivity.m21342a(pandoraAlbumsFragment.getContext(), pandoraAlbumsFragment.f17923h, VideoAlbumEntityType.USER, VideoAlbumOriginType.PHOTO_ALBUM), pandoraAlbumsFragment.getContext());
        }
    }

    public static void m21873a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PandoraAlbumsFragment) obj).m21870a(IdBasedLazy.a(fbInjector, 9249), IdBasedLazy.a(fbInjector, 3561), PandoraAlbumsAdapter.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 9247), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedLazy.a(fbInjector, 9340), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedLazy.a(fbInjector, 9246), IdBasedLazy.a(fbInjector, 2164), IdBasedLazy.a(fbInjector, 9406), ViewerContextMethodAutoProvider.b(fbInjector), FamilyAlbumUtil.m21775b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    @Inject
    private void m21870a(Lazy<AlbumsFuturesGenerator> lazy, Lazy<TasksManager> lazy2, PandoraAlbumsAdapter pandoraAlbumsAdapter, Lazy<AlbumsEventBus> lazy3, Lazy<SecureContextHelper> lazy4, Lazy<PhotosViewIntentBuilder> lazy5, Lazy<FbErrorReporter> lazy6, Lazy<VideoAlbumConfig> lazy7, Lazy<GraphQLQueryExecutor> lazy8, Lazy<FbPhotoPickerController> lazy9, ViewerContext viewerContext, FamilyAlbumUtil familyAlbumUtil, Executor executor) {
        this.au = viewerContext.mUserId;
        this.av = lazy;
        this.ax = lazy4;
        this.aw = lazy2;
        this.ay = lazy3;
        this.f17922g = pandoraAlbumsAdapter;
        this.az = lazy5;
        this.aF = lazy6;
        this.aA = lazy9;
        this.aB = viewerContext;
        this.aG = familyAlbumUtil;
        this.aH = executor;
        this.aE = lazy8;
        this.aD = lazy7;
    }

    private void m21868a(int i, int i2, GraphQLCachePolicy graphQLCachePolicy) {
        String str;
        final GraphQLQueryFuture a = ((GraphQLQueryExecutor) this.aE.get()).a(GraphQLRequest.a((TypedGraphQlQueryString) new VideosUploadedByUserSimpleQueryString().a("node_id", Long.toString(this.f17923h.longValue())).a("image_width", Integer.toString(i)).a("image_height", Integer.toString(i2)).a("count", "1").a("media_type", MediaTypeInputMimeType.IMAGEWEBP)).a(graphQLCachePolicy));
        C19329 c19329 = new C19329(this);
        TasksManager tasksManager = (TasksManager) this.aw.get();
        String str2 = "fetchVideosUploadedQuery_%s-%s";
        Object[] objArr = new Object[2];
        objArr[0] = this.f17923h;
        if (graphQLCachePolicy == GraphQLCachePolicy.b) {
            str = "cache";
        } else {
            str = "network";
        }
        objArr[1] = str;
        tasksManager.a(StringFormatUtil.a(str2, objArr), new Callable<ListenableFuture>(this) {
            final /* synthetic */ PandoraAlbumsFragment f17901b;

            public Object call() {
                return a;
            }
        }, c19329);
    }

    public static PandoraAlbumsFragment m21867a(@Nullable Bundle bundle, String str, boolean z, @Nullable ArrayList<String> arrayList, @Nullable ComposerTargetData composerTargetData) {
        PandoraAlbumsFragment pandoraAlbumsFragment = new PandoraAlbumsFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putLong("owner_id", Long.parseLong(str));
        bundle.putBoolean("is_page", z);
        if (arrayList != null) {
            bundle.putStringArrayList("extra_pages_admin_permissions", arrayList);
        }
        f17916a = composerTargetData;
        if (composerTargetData != null) {
            bundle.putParcelable("extra_composer_target_data", f17916a);
        }
        pandoraAlbumsFragment.g(bundle);
        return pandoraAlbumsFragment;
    }

    public View m21877a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2094516407);
        this.f17921f = layoutInflater.inflate(2130903240, viewGroup, false);
        this.f17919d = (BetterListView) this.f17921f.findViewById(16908298);
        this.f17920e = this.f17921f.findViewById(2131559561);
        View view = this.f17921f;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -651870934, a);
        return view;
    }

    public void m21878a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f17919d.setAdapter(this.f17922g);
        this.f17919d.a(new C19241(this));
    }

    public void m21879c(Bundle bundle) {
        super.c(bundle);
        Class cls = PandoraAlbumsFragment.class;
        m21873a((Object) this, getContext());
        this.aC = (VideoAlbumConfig) this.aD.get();
        ((FbPhotoPickerController) this.aA.get()).m21759a(o().getIntent());
    }

    public final void m21880d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -765801607);
        super.d(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.at = (TimelinePhotoTabModeParams) bundle2.getParcelable("extra_photo_tab_mode_params");
            this.f17923h = Long.valueOf(bundle2.getLong("owner_id", -1));
            this.f17924i = bundle2.getBoolean("is_page", false);
            this.al = bundle2.getStringArrayList("extra_pages_admin_permissions");
            this.am = bundle2.getBoolean("disable_adding_photos_to_albums", false);
            this.an = (PandoraCustomizedBackgroundConfig) bundle2.getParcelable("customized_res");
            if (this.an != null) {
                this.f17921f.setBackgroundResource(this.an.f17925a);
                this.f17919d.setBackgroundResource(this.an.f17925a);
                this.f17920e.setBackgroundResource(this.an.f17925a);
            }
        }
        if (this.f17923h.longValue() == -1 && !Strings.isNullOrEmpty(this.au)) {
            this.f17923h = Long.valueOf(Long.parseLong(this.au));
        }
        if (this.f17922g != null) {
            Integer valueOf;
            PandoraAlbumsAdapter pandoraAlbumsAdapter = this.f17922g;
            String valueOf2 = String.valueOf(this.f17923h);
            boolean z = this.f17924i;
            boolean a2 = this.al == null ? this.au != null && this.au.equals(String.valueOf(this.f17923h)) : new ProfilePermissions(this.al).a(Permission.CREATE_CONTENT);
            boolean z2 = a2;
            if (this.an != null) {
                valueOf = Integer.valueOf(this.an.f17926b);
            } else {
                valueOf = null;
            }
            pandoraAlbumsAdapter.a(valueOf2, z, true, z2, valueOf);
        }
        LogUtils.f(-706624839, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 639311068);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2132409477, a);
    }

    protected final void m21881e() {
        this.ap = false;
        this.aq = null;
        this.ar = false;
        this.as = false;
        final ListenableFuture a = ((AlbumsFuturesGenerator) this.av.get()).a(String.valueOf(this.f17923h), 250, GraphQLCachePolicy.b, null, 20);
        final ListenableFuture a2 = ((AlbumsFuturesGenerator) this.av.get()).a(String.valueOf(this.f17923h), 250, GraphQLCachePolicy.d, null, 20);
        C19252 c19252 = new C19252(this);
        C19263 c19263 = new C19263(this);
        ((TasksManager) this.aw.get()).a(StringFormatUtil.a("fetchInitialAlbumsListCache_%s", new Object[]{this.f17923h}), new Callable<ListenableFuture>(this) {
            final /* synthetic */ PandoraAlbumsFragment f17906b;

            public Object call() {
                return a;
            }
        }, c19252);
        ((TasksManager) this.aw.get()).a(StringFormatUtil.a("fetchInitialAlbumsListNetwork_%s", new Object[]{this.f17923h}), new Callable<ListenableFuture>(this) {
            final /* synthetic */ PandoraAlbumsFragment f17908b;

            public Object call() {
                return a2;
            }
        }, c19263);
        if (this.aC == null || !this.aC.a || at()) {
            boolean z = false;
        } else {
            int i = 1;
        }
        if (i != 0) {
            m21868a(250, 250, GraphQLCachePolicy.b);
            m21868a(250, 250, GraphQLCachePolicy.d);
        }
        if (!((Boolean) this.aG.f17797b.get()).booleanValue()) {
            return;
        }
        if (f17916a == null || f17916a.targetType.equals(TargetType.USER)) {
            Futures.a(this.aG.m21776a(250, 250, GraphQLCachePolicy.d, this.f17923h), new C19296(this), this.aH);
        }
    }

    public static void m21872a(PandoraAlbumsFragment pandoraAlbumsFragment, GraphQLAlbumsConnection graphQLAlbumsConnection, boolean z) {
        if (!(graphQLAlbumsConnection == null || graphQLAlbumsConnection.a() == null)) {
            PandoraAlbumsAdapter pandoraAlbumsAdapter = pandoraAlbumsFragment.f17922g;
            pandoraAlbumsAdapter.a.clear();
            pandoraAlbumsAdapter.b(graphQLAlbumsConnection, z);
        }
        pandoraAlbumsFragment.aq();
    }

    protected void aq() {
        if (this.f17922g.getCount() > 0 && this.f17919d.getVisibility() == 8) {
            this.f17919d.setVisibility(0);
            this.f17920e.setVisibility(8);
        } else if (this.f17919d.getVisibility() != 0) {
            this.f17921f.findViewById(2131561172).setVisibility(0);
            this.f17921f.findViewById(2131561173).setVisibility(8);
        }
    }

    public final void m21874G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1286082703);
        super.G();
        this.ao = o().getRequestedOrientation();
        o().setRequestedOrientation(1);
        ((AlbumsEventBus) this.ay.get()).a(this.f17917b);
        ((AlbumsEventBus) this.ay.get()).a(this.f17918c);
        m21881e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 571438083, a);
    }

    public final void m21875H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -666548477);
        o().setRequestedOrientation(this.ao);
        ((AlbumsEventBus) this.ay.get()).b(this.f17917b);
        ((AlbumsEventBus) this.ay.get()).b(this.f17918c);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 249474112, a);
    }

    public final void m21876I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 468276323);
        super.I();
        if (!(this.aw == null || this.aw.get() == null)) {
            ((TasksManager) this.aw.get()).c();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -149445574, a);
    }

    private void m21869a(GraphQLAlbum graphQLAlbum) {
        if (graphQLAlbum.k() == GraphQLPhotosAlbumAPIType.OTHER && graphQLAlbum.A() == "FamilyAlbum") {
            PhotosViewIntentProvider photosViewIntentProvider = (PhotosViewIntentProvider) this.az.get();
            Context context = getContext();
            String u = graphQLAlbum.u();
            Preconditions.checkState(!Strings.isNullOrEmpty(u));
            ((SecureContextHelper) this.ax.get()).a(photosViewIntentProvider.c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.aP, u)), getContext());
            return;
        }
        Intent a = ((PhotosViewIntentProvider) this.az.get()).a(getContext(), graphQLAlbum.u());
        FlatBufferModelHelper.a(a, "extra_album_selected", graphQLAlbum);
        a.putExtra("extra_photo_tab_mode_params", this.at);
        a.putExtra("pick_hc_pic", ((FbPhotoPickerController) this.aA.get()).f17782a);
        a.putExtra("pick_pic_lite", ((FbPhotoPickerController) this.aA.get()).f17783b);
        a.putExtra("disable_adding_photos_to_albums", this.am);
        a.putExtra("owner_id", this.f17923h);
        a.putExtra("is_page", this.f17924i);
        if (this.aB.mIsPageContext) {
            a.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", this.aB);
            if (this.al != null) {
                a.putStringArrayListExtra("extra_pages_admin_permissions", this.al);
            }
            a.putExtra("extra_composer_target_data", this.s.getParcelable("extra_composer_target_data"));
        }
        int i = -1;
        if (at()) {
            if (((FbPhotoPickerController) this.aA.get()).f17782a || ((FbPhotoPickerController) this.aA.get()).f17783b) {
                i = 9913;
            } else if (this.at != null && this.at.c()) {
                i = 9915;
            } else if (this.at != null && this.at.d()) {
                i = 9914;
            }
        }
        if (i > 0) {
            ((SecureContextHelper) this.ax.get()).a(a, i, ao());
        } else {
            ((SecureContextHelper) this.ax.get()).a(a, getContext());
        }
    }

    private boolean at() {
        return (this.at != null && (this.at.c() || this.at.d())) || ((FbPhotoPickerController) this.aA.get()).f17782a || ((FbPhotoPickerController) this.aA.get()).f17783b;
    }
}
