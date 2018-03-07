package com.facebook.photos.pandora.ui;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.photos.albums.protocols.AlbumQuery.AlbumMetadataQueryString;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.photos.pandora.common.data.PandoraStoryPagedCollection;
import com.facebook.photos.pandora.common.futures.PandoraFuturesGenerator;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererGridConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraInlineVideoEnvironmentProvider;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.ui.views.PandoraAlbumPermalinkDetailsView;
import com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils;
import com.facebook.photos.photoset.ui.permalink.futures.AlbumPermalinkFuturesGenerator;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.Futures.ImmediateFailedCheckedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment */
public class PandoraAlbumMediaSetAdapter extends PandoraBasicFeedAdapter {
    private ProfilePermissions f17615A;
    private boolean f17616B;
    private long f17617C = -1;
    private boolean f17618D = false;
    public final Lazy<PandoraFuturesGenerator> f17619t;
    private final Lazy<PandoraRendererGridConfiguration> f17620u;
    public final Lazy<AlbumPermalinkFuturesGenerator> f17621v;
    public PandoraRendererConfiguration f17622w;
    public GraphQLAlbum f17623x;
    public ComposerTargetData f17624y;
    public boolean f17625z;

    /* compiled from: com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment */
    public class C18701 implements Callable<ListenableFuture> {
        final /* synthetic */ PandoraAlbumMediaSetAdapter f17610a;

        public C18701(PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
            this.f17610a = pandoraAlbumMediaSetAdapter;
        }

        public Object call() {
            return ((PandoraFuturesGenerator) this.f17610a.f17619t.get()).m21384a(this.f17610a.f17458j, this.f17610a.f17460l, null, PandoraAlbumMediaSetAdapter.m21585r(this.f17610a).f17365d, this.f17610a.m21431b() ? 30 : 12, this.f17610a.m21436h(), this.f17610a.f17622w);
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment */
    public class C18712 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PandoraAlbumMediaSetAdapter f17611a;

        public C18712(PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
            this.f17611a = pandoraAlbumMediaSetAdapter;
        }

        protected final void m21578a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null && operationResult.b) {
                PandoraRendererResult pandoraRendererResult = (PandoraRendererResult) operationResult.h();
                if (pandoraRendererResult != null) {
                    boolean z;
                    this.f17611a.f17457i.m21442a(pandoraRendererResult.f17472a);
                    PandoraStoryPagedCollection r = PandoraAlbumMediaSetAdapter.m21585r(this.f17611a);
                    PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.f17611a;
                    if (r == null || !r.f17364c) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pandoraBasicFeedAdapter.f17461m = z;
                    AdapterDetour.a(this.f17611a, -380703068);
                }
            }
        }

        protected final void m21579a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17611a.f17452d.get()).b("fetchAlbumMediaSet", th);
            AdapterDetour.a(this.f17611a, 6885475);
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment */
    class C18734 extends AbstractDisposableFutureCallback<GraphQLResult<GraphQLAlbum>> {
        final /* synthetic */ PandoraAlbumMediaSetAdapter f17614a;

        C18734(PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
            this.f17614a = pandoraAlbumMediaSetAdapter;
        }

        protected final void m21580a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null) {
                GraphQLAlbum graphQLAlbum = (GraphQLAlbum) graphQLResult.e;
                if (graphQLAlbum != null) {
                    boolean z;
                    Builder a = Builder.a(graphQLAlbum);
                    if (this.f17614a.f17623x != null) {
                        if (this.f17614a.f17623x.w() != null) {
                            a.q = this.f17614a.f17623x.w();
                        }
                        if (this.f17614a.f17623x.C() != null) {
                            a.x = this.f17614a.f17623x.C();
                        }
                    }
                    this.f17614a.f17623x = a.a();
                    PandoraStoryPagedCollection r = PandoraAlbumMediaSetAdapter.m21585r(this.f17614a);
                    PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.f17614a;
                    if (r == null || !r.f17364c) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pandoraBasicFeedAdapter.f17461m = z;
                    this.f17614a.f17625z = PandoraAlbumMediaSetAdapter.m21584p(this.f17614a);
                    AdapterDetour.a(this.f17614a, -1404637737);
                }
            }
        }

        protected final void m21581a(Throwable th) {
            ((AbstractFbErrorReporter) this.f17614a.f17452d.get()).b("refetchAlbumDetails", th);
            AdapterDetour.a(this.f17614a, 448253970);
        }
    }

    public static PandoraAlbumMediaSetAdapter m21583b(InjectorLike injectorLike) {
        return new PandoraAlbumMediaSetAdapter(IdBasedLazy.a(injectorLike, 9373), IdBasedLazy.a(injectorLike, 9376), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 9384), IdBasedLazy.a(injectorLike, 9385), IdBasedSingletonScopeProvider.b(injectorLike, 9414), IdBasedSingletonScopeProvider.b(injectorLike, 494), ViewerContextMethodAutoProvider.b(injectorLike), PandoraSequenceLogger.m21549a(injectorLike), (PandoraInlineVideoEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraInlineVideoEnvironmentProvider.class));
    }

    @Inject
    public PandoraAlbumMediaSetAdapter(Lazy<PandoraStoryMemoryCache> lazy, Lazy<PandoraFuturesGenerator> lazy2, Lazy<TasksManager> lazy3, Lazy<PandoraRendererController> lazy4, Lazy<PandoraRendererGridConfiguration> lazy5, Lazy<AlbumPermalinkFuturesGenerator> lazy6, Lazy<FbErrorReporter> lazy7, ViewerContext viewerContext, PandoraSequenceLogger pandoraSequenceLogger, PandoraInlineVideoEnvironmentProvider pandoraInlineVideoEnvironmentProvider) {
        super(lazy, lazy3, lazy4, (PandoraRendererConfiguration) lazy5.get(), lazy7, viewerContext.a(), pandoraSequenceLogger, pandoraInlineVideoEnvironmentProvider);
        this.f17619t = lazy2;
        this.f17620u = lazy5;
        this.f17622w = (PandoraRendererConfiguration) this.f17620u.get();
        this.f17621v = lazy6;
    }

    public final void m21587a(GraphQLAlbum graphQLAlbum, @Nullable ComposerTargetData composerTargetData, @Nullable ArrayList<String> arrayList, boolean z, long j, boolean z2) {
        this.f17623x = graphQLAlbum;
        this.f17624y = composerTargetData;
        this.f17615A = arrayList != null ? new ProfilePermissions(arrayList) : null;
        this.f17616B = z;
        this.f17625z = m21584p(this);
        this.f17617C = j;
        this.f17618D = z2;
        m21582a(this.f17623x.u());
        super.mo1053a(this.f17623x.u(), "LoadScreenImagesAlbum", true, true, false);
    }

    public final void mo1053a(String str, String str2, boolean z, boolean z2, boolean z3) {
        throw new RuntimeException("should use init(GraphQLAlbum album) instead. ");
    }

    public final String mo1055e() {
        return StringFormatUtil.a("fetchAlbumMediaSet_%s", new Object[]{this.f17460l});
    }

    public final void mo1054d() {
        if (this.f17461m) {
            ((TasksManager) this.f17451c.get()).a(mo1055e(), new C18701(this), new C18712(this));
        }
    }

    private void m21582a(final String str) {
        ((TasksManager) this.f17451c.get()).a(StringFormatUtil.a("refetchAlbumDetails_%s", new Object[]{str}), new Callable<ListenableFuture<GraphQLResult<GraphQLAlbum>>>(this) {
            final /* synthetic */ PandoraAlbumMediaSetAdapter f17613b;

            public Object call() {
                ImmediateFailedCheckedFuture a;
                AlbumPermalinkFuturesGenerator albumPermalinkFuturesGenerator = (AlbumPermalinkFuturesGenerator) this.f17613b.f17621v.get();
                String str = str;
                if (Strings.isNullOrEmpty(str)) {
                    a = Futures.a(new RuntimeException("album Node ID cannot be null."));
                } else {
                    GraphQlQueryString albumMetadataQueryString = new AlbumMetadataQueryString();
                    albumMetadataQueryString.a("node_id", str).a("media_type", ((GraphQLImageHelper) albumPermalinkFuturesGenerator.f17896b.get()).a()).a("contributor_pic_width", String.valueOf(((GraphQLImageHelper) albumPermalinkFuturesGenerator.f17896b.get()).a(0, 0)));
                    a = ((GraphQLQueryExecutor) albumPermalinkFuturesGenerator.f17895a.get()).a(GraphQLRequest.a(albumMetadataQueryString).a(GraphQLCachePolicy.c));
                }
                return a;
            }
        }, new C18734(this));
    }

    public final GraphQLAlbum m21594n() {
        return this.f17623x;
    }

    protected final PandoraRequestSource mo1056f() {
        return PandoraRequestSource.ALBUM_MEDIA_SET;
    }

    protected View mo1052a(View view, View view2) {
        PandoraAlbumPermalinkDetailsView pandoraAlbumPermalinkDetailsView;
        ComposerTargetData composerTargetData;
        if (view != null) {
            pandoraAlbumPermalinkDetailsView = (PandoraAlbumPermalinkDetailsView) view;
        } else {
            pandoraAlbumPermalinkDetailsView = new PandoraAlbumPermalinkDetailsView(view2.getContext());
        }
        GraphQLAlbum graphQLAlbum = this.f17623x;
        boolean z = this.f17625z;
        long j = this.f17617C;
        boolean z2 = this.f17618D;
        if (this.f17624y != null) {
            composerTargetData = this.f17624y;
        } else {
            if (!(this.f17623x.x() == null || this.f17623x.x().j() == null)) {
                int g = this.f17623x.x().j().g();
                ComposerTargetData.Builder builder;
                if (g == 69076575) {
                    builder = new ComposerTargetData.Builder(Long.parseLong(this.f17623x.x().b()), TargetType.GROUP);
                    builder.c = this.f17623x.x().U();
                    this.f17624y = builder.a();
                } else if (g == 67338874) {
                    builder = new ComposerTargetData.Builder(Long.parseLong(this.f17623x.x().b()), TargetType.EVENT);
                    builder.c = this.f17623x.x().U();
                    this.f17624y = builder.a();
                }
            }
            composerTargetData = this.f17624y;
        }
        pandoraAlbumPermalinkDetailsView.m21733a(graphQLAlbum, z, j, z2, composerTargetData);
        return pandoraAlbumPermalinkDetailsView;
    }

    protected final boolean mo1057j() {
        return true;
    }

    protected final boolean mo1058m() {
        return this.f17461m;
    }

    public static boolean m21584p(PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
        if (pandoraAlbumMediaSetAdapter.f17616B || pandoraAlbumMediaSetAdapter.f17623x.x() == null || pandoraAlbumMediaSetAdapter.f17623x.x().j() == null) {
            return false;
        }
        int g = pandoraAlbumMediaSetAdapter.f17623x.x().j().g();
        boolean z = GraphQLAlbumUtils.m21792a(pandoraAlbumMediaSetAdapter.f17623x, pandoraAlbumMediaSetAdapter.f17459k) || GraphQLAlbumUtils.m21793b(pandoraAlbumMediaSetAdapter.f17623x, pandoraAlbumMediaSetAdapter.f17459k);
        switch (g) {
            case 2479791:
                if (pandoraAlbumMediaSetAdapter.f17615A == null) {
                    return z;
                }
                if (z && pandoraAlbumMediaSetAdapter.f17615A.a(Permission.EDIT_PROFILE)) {
                    return true;
                }
                return false;
            case 67338874:
            case 69076575:
                return pandoraAlbumMediaSetAdapter.f17623x.o();
            default:
                return z;
        }
    }

    public static PandoraStoryPagedCollection m21585r(PandoraAlbumMediaSetAdapter pandoraAlbumMediaSetAdapter) {
        pandoraAlbumMediaSetAdapter.h = ((PandoraStoryMemoryCache) pandoraAlbumMediaSetAdapter.f17450b.get()).m21363a(pandoraAlbumMediaSetAdapter.m21436h());
        return pandoraAlbumMediaSetAdapter.f17456h;
    }
}
